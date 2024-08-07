package com.majumundur.clothing_shop.Entity;

import com.majumundur.clothing_shop.Constants.EntityName;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = EntityName.USER)
@Table(name = EntityName.USER)
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @OneToOne(optional = false, targetEntity = Account.class)
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    private Account account;

    @Column(nullable = false)
    private String name;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @Column(nullable = false)
    private Integer points;
}
