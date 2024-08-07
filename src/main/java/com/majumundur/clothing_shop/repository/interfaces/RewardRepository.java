package com.majumundur.clothing_shop.repository.interfaces;

import com.majumundur.clothing_shop.entity.Reward;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RewardRepository extends JpaRepository<Reward, Integer> {
}
