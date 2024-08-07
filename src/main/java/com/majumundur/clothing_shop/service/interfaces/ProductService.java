package com.majumundur.clothing_shop.service.interfaces;

import com.majumundur.clothing_shop.dto.request.CreateProductRequest;
import com.majumundur.clothing_shop.dto.response.ProductResponse;
import com.majumundur.clothing_shop.entity.Product;

import java.util.List;

public interface ProductService {
    Product getById(String id);
    List<ProductResponse> getAll();
    ProductResponse create(CreateProductRequest request);
}
