package com.majumundur.clothing_shop.service;

import com.majumundur.clothing_shop.entity.Enum.RoleType;
import com.majumundur.clothing_shop.entity.Role;
import com.majumundur.clothing_shop.repository.interfaces.RoleRepository;
import com.majumundur.clothing_shop.service.interfaces.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    public Role getOrSave(RoleType role) {
        return roleRepository.findByRole(role).orElseGet(
                () -> roleRepository.saveAndFlush(
                        Role.builder()
                                .role(role)
                                .build()
                )
        );
    }
}
