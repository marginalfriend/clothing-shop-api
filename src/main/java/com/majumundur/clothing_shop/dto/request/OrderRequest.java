package com.majumundur.clothing_shop.dto.request;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {
    List<OrderDetailRequest> orderDetails;
}
