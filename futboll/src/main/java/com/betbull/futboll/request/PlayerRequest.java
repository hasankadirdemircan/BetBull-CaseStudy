package com.betbull.futboll.request;

import com.betbull.futboll.dto.PlayerDto;
import com.betbull.futboll.request.base.BaseRequest;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlayerRequest extends BaseRequest {
    private PlayerDto player;

}
