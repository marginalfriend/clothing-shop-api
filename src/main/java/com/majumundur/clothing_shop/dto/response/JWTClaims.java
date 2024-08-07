package com.majumundur.clothing_shop.dto.response;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JWTClaims {
    private String accountId;
    private List<String> roles;
}
