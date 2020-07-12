package com.betbull.futboll.request;

import com.betbull.futboll.request.base.BaseRequest;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlayerCostRequest  extends BaseRequest {
    private Integer playerId;
}
