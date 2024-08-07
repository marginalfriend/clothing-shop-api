package com.majumundur.clothing_shop.repository.interfaces;

import com.majumundur.clothing_shop.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, String> {
}
