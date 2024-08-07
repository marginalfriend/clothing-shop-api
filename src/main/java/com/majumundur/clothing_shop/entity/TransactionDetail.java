package com.majumundur.clothing_shop.entity;

import com.majumundur.clothing_shop.constant.EntityName;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = EntityName.TRANSACTION_DETAILS)
@Table(name = EntityName.TRANSACTION_DETAILS)
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TransactionDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "transaction_details_seq")
    @SequenceGenerator(name = "transaction_details_seq", sequenceName = "transaction_details_seq", allocationSize = 1)
    private Integer id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "product_id", referencedColumnName = "id", nullable = false)
    private Product product;

    @Column(nullable = false)
    private Integer quantity;

    @Column(name = "counted_price", nullable = false)
    private Integer countedPrice;
}
