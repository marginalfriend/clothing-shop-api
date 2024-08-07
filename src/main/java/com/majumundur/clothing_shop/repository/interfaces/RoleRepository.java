package com.majumundur.clothing_shop.repository.interfaces;

import com.majumundur.clothing_shop.entity.Enum.RoleType;
import com.majumundur.clothing_shop.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByRole(RoleType role);
}
