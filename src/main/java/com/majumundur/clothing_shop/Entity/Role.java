package com.majumundur.clothing_shop.Entity;

import com.majumundur.clothing_shop.Constants.EntityName;
import com.majumundur.clothing_shop.Entity.Enum.RoleType;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = EntityName.ROLE)
@Table(name = EntityName.ROLE)
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "role_seq")
    @SequenceGenerator(name = "role_seq", sequenceName = "role_seq", allocationSize = 1)
    private Integer id;

    @Enumerated(EnumType.STRING)
    private RoleType role;
}
