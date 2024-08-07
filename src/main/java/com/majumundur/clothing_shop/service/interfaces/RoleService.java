package com.majumundur.clothing_shop.service.interfaces;

import com.majumundur.clothing_shop.entity.Enum.RoleType;
import com.majumundur.clothing_shop.entity.Role;

public interface RoleService {
    Role getOrSave(RoleType role);
}
