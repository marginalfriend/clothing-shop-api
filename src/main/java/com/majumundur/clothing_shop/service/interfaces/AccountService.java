package com.majumundur.clothing_shop.service.interfaces;

import com.majumundur.clothing_shop.entity.Account;

public interface AccountService {
    Account getById(String id);

    Account getByContext();
}
