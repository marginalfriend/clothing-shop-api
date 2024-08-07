package com.majumundur.clothing_shop.repository.interfaces;

import com.majumundur.clothing_shop.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, String> {
}
