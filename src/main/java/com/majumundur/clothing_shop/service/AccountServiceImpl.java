package com.majumundur.clothing_shop.service;

import com.majumundur.clothing_shop.entity.Account;
import com.majumundur.clothing_shop.repository.interfaces.AccountRepository;
import com.majumundur.clothing_shop.service.interfaces.AccountService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;

    public Account getById(String id) {
        return accountRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Account not found")
        );
    }

    public Account getByContext() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        return accountRepository.findByEmail(authentication.getPrincipal().toString()).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Account not found from context")
        );
    }
}
