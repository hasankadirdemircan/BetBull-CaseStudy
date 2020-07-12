package com.betbull.futboll.response;

import com.betbull.futboll.dto.PlayerCostDto;
import com.betbull.futboll.enums.Error;
import com.betbull.futboll.response.base.BaseResponse;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlayerCostResponse extends BaseResponse {
    public PlayerCostResponse(int statusCode, Error error, PlayerCostDto playerCost) {
        super(statusCode, error);
        this.playerCost = playerCost;

    }
    @JsonInclude(JsonInclude.Include.NON_NULL)
    PlayerCostDto playerCost;
}
