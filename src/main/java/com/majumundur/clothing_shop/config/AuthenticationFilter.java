package com.majumundur.clothing_shop.config;

import com.majumundur.clothing_shop.dto.response.JWTClaims;
import com.majumundur.clothing_shop.entity.Account;
import com.majumundur.clothing_shop.service.interfaces.AccountService;
import com.majumundur.clothing_shop.service.interfaces.JWTService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
@Slf4j
public class AuthenticationFilter extends OncePerRequestFilter {
	final String AUTH_HEADER = "Authorization";
	private final JWTService jwtService;
	private final AccountService userService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
		try {

			String bearerToken = request.getHeader(AUTH_HEADER);

			if(bearerToken != null && jwtService.verifyJwtToken(bearerToken)){
				JWTClaims decodeJwt = jwtService.getClaimsByToken(bearerToken);

				Account userAccountBySub = userService.getById(decodeJwt.getAccountId());
				UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
								userAccountBySub.getUsername(),
								null,
								userAccountBySub.getAuthorities()
				);

				authentication.setDetails(new WebAuthenticationDetails(request));

				SecurityContextHolder.getContext().setAuthentication(authentication);
			}
		} catch (Exception e){
			log.error("Cannot set user authentication: {}", e.getMessage());
		}

		filterChain.doFilter(request,response);
	}
}
