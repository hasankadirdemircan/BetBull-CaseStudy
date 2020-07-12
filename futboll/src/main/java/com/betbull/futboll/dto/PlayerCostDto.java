package com.betbull.futboll.dto;

import com.betbull.futboll.model.Player;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlayerCostDto {
    private Player player;
    private Double playerCost;
    private Double contractPayment;
    private Double transferPayment;
    private Double teamCommission;
}
