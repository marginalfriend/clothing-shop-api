package com.majumundur.clothing_shop.dto.response;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {
    private String id;
    private String name;
    private String merchant;
    private Integer price;
    private String description;
}
