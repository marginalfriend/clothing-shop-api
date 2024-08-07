package com.majumundur.clothing_shop.entity;

import com.majumundur.clothing_shop.constant.EntityName;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = EntityName.PRODUCT)
@Table(name = EntityName.PRODUCT)
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "merchant_id", nullable = false)
    private User merchant;

    @Column(nullable = false)
    private String name;

    @Lob
    private String description;

    @Column(nullable = false)
    private Integer price;
}
