package com.majumundur.clothing_shop.entity;

import com.majumundur.clothing_shop.constant.EntityName;
import com.majumundur.clothing_shop.entity.Enum.PaymentStatus;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@Entity(name = EntityName.TRANSACTION)
@Table(name = EntityName.TRANSACTION)
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @Basic(optional = false)
    @Column(insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp timestamp;

    @Column(name = "total_price", nullable = false)
    private Integer totalPrice;

    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;
}
