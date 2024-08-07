package com.majumundur.clothing_shop.service;

import com.majumundur.clothing_shop.dto.request.CreateProductRequest;
import com.majumundur.clothing_shop.dto.response.ProductResponse;
import com.majumundur.clothing_shop.entity.Account;
import com.majumundur.clothing_shop.entity.Product;
import com.majumundur.clothing_shop.repository.interfaces.ProductRepository;
import com.majumundur.clothing_shop.service.interfaces.AccountService;
import com.majumundur.clothing_shop.service.interfaces.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final AccountService accountService;

    public Product getById(String id) {
        return productRepository.findById(id).orElseGet(null);
    }

    public List<ProductResponse> getAll() {
        List<Product> products = productRepository.findAll();

        if (products.isEmpty()) return null;

        return products.stream().map(product -> ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .merchant(product.getMerchant().getName())
                .price(product.getPrice())
                .description(product.getDescription())
                .build()).toList();
    }

    public ProductResponse create(CreateProductRequest request) {
        Account account = accountService.getByContext();

        Product product = Product.builder()
                .name(request.getName())
                .merchant(account.getUser())
                .description(request.getDescription())
                .price(request.getPrice())
                .build();
        productRepository.saveAndFlush(product);

        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .merchant(product.getMerchant().getName())
                .price(product.getPrice())
                .description(product.getDescription())
                .build();
    }
}
