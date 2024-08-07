package com.majumundur.clothing_shop.dto.response;

import lombok.*;

import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailResponse {
    private String productId;
    private String productName;
    private Integer quantity;
    private Integer price;
    private Integer countedPrice;
}
