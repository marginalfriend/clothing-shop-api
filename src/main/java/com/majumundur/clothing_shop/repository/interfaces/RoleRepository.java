package com.majumundur.clothing_shop.repository.interfaces;

import com.majumundur.clothing_shop.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
}
