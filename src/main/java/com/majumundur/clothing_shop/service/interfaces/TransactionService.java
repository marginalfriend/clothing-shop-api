package com.majumundur.clothing_shop.service.interfaces;

import com.majumundur.clothing_shop.dto.request.OrderRequest;
import com.majumundur.clothing_shop.dto.request.PaymentRequest;
import com.majumundur.clothing_shop.dto.response.OrderResponse;

public interface TransactionService {
    OrderResponse order(OrderRequest request);
    OrderResponse pay(PaymentRequest request);
}
