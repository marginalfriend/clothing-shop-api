package com.majumundur.clothing_shop.service.interfaces;

import com.majumundur.clothing_shop.dto.response.JWTClaims;
import com.majumundur.clothing_shop.entity.Account;

public interface JWTService {
    String generateToken(Account account);

    boolean verifyJwtToken(String token);

    JWTClaims getClaimsByToken(String token);
}
