package com.majumundur.clothing_shop.service.interfaces;

import com.majumundur.clothing_shop.entity.TransactionDetail;

import java.util.List;

public interface TransactionDetailService {
    List<TransactionDetail> createBulk(List<TransactionDetail> transactionDetails);
}
