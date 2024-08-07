package com.majumundur.clothing_shop.service.interfaces;

import com.majumundur.clothing_shop.entity.Reward;
import com.majumundur.clothing_shop.entity.User;

public interface RewardService {
    void addPoint(User user);
    Reward claimReward(User user);
}
