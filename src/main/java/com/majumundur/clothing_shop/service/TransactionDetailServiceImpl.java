package com.majumundur.clothing_shop.service;

import com.majumundur.clothing_shop.entity.TransactionDetail;
import com.majumundur.clothing_shop.repository.interfaces.TransactionDetailRepository;
import com.majumundur.clothing_shop.service.interfaces.TransactionDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionDetailServiceImpl implements TransactionDetailService {
    private final TransactionDetailRepository transactionDetailRepository;

    public List<TransactionDetail> createBulk(List<TransactionDetail> transactionDetails) {
        return transactionDetailRepository.saveAllAndFlush(transactionDetails);
    }
}
