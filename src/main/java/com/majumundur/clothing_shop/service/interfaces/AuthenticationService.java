package com.majumundur.clothing_shop.service.interfaces;

import com.majumundur.clothing_shop.dto.request.RegisterRequest;
import com.majumundur.clothing_shop.dto.response.LoginResponse;
import com.majumundur.clothing_shop.dto.request.LoginRequest;
import com.majumundur.clothing_shop.dto.response.RegisterResponse;

public interface AuthenticationService {
    RegisterResponse register(RegisterRequest request);
    LoginResponse login(LoginRequest request);

}
