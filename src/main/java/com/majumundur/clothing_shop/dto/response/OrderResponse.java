package com.majumundur.clothing_shop.dto.response;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponse {
    private String orderId;
    private String orderDate;
    private Integer totalPrice;
    private String paymentStatus;
    private List<OrderDetailResponse> orderDetails;
}
