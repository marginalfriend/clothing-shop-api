package com.majumundur.clothing_shop.entity;

import com.majumundur.clothing_shop.constant.EntityName;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = EntityName.CLAIM_REWARD)
@Table(name = EntityName.CLAIM_REWARD)
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ClaimReward {
    @Id
    @GeneratedValue(generator = "claim_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "claim_seq", sequenceName = "claim_seq", allocationSize = 1)
    private Integer id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @ManyToOne(optional = false)
    @JoinColumn(name = "reward_id", referencedColumnName = "id")
    private Reward reward;
}
