package com.majumundur.clothing_shop.service;

import com.majumundur.clothing_shop.dto.request.LoginRequest;
import com.majumundur.clothing_shop.dto.request.RegisterRequest;
import com.majumundur.clothing_shop.dto.response.LoginResponse;
import com.majumundur.clothing_shop.dto.response.RegisterResponse;
import com.majumundur.clothing_shop.entity.Account;
import com.majumundur.clothing_shop.entity.Enum.RoleType;
import com.majumundur.clothing_shop.entity.Role;
import com.majumundur.clothing_shop.entity.User;
import com.majumundur.clothing_shop.repository.interfaces.AccountRepository;
import com.majumundur.clothing_shop.repository.interfaces.UserRepository;
import com.majumundur.clothing_shop.service.interfaces.AuthenticationService;
import com.majumundur.clothing_shop.service.interfaces.JWTService;
import com.majumundur.clothing_shop.service.interfaces.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final AccountRepository accountRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleService roleService;
    private final AuthenticationManager authenticationManager;
    private final JWTService jwtService;

    public RegisterResponse register(RegisterRequest request) {
        Role role = roleService.getOrSave(RoleType.CUSTOMER);

        Account account = Account.builder()
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .roles(List.of(role))
                .build();
        accountRepository.saveAndFlush(account);

        User user = User.builder()
                .name(request.getName())
                .points(0)
                .account(account)
                .build();
        userRepository.saveAndFlush(user);

        return RegisterResponse.builder()
                .email(account.getEmail())
                .name(user.getName())
                .roles(account.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList())
                .build();
    }

    public LoginResponse login(LoginRequest request) {
        Authentication authentication = new UsernamePasswordAuthenticationToken(
                request.getEmail(),
                request.getPassword()
        );

        Authentication authenticated = authenticationManager.authenticate(authentication);

        Account account = (Account) authenticated.getPrincipal();
        String token = jwtService.generateToken(account);
        return LoginResponse.builder()
                .token(token)
                .build();
    }
}
