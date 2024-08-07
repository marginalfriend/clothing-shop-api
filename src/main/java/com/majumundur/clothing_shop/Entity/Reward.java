package com.majumundur.clothing_shop.Entity;

import com.majumundur.clothing_shop.Constants.EntityName;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = EntityName.REWARD)
@Table(name = EntityName.REWARD)
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Reward {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reward_seq")
    @SequenceGenerator(sequenceName = "reward_seq", name = "reward_seq",allocationSize = 1)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer cost;
}
