package com.majumundur.clothing_shop.repository.interfaces;

import com.majumundur.clothing_shop.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
}
