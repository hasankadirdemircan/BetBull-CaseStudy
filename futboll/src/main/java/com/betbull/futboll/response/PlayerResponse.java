package com.betbull.futboll.response;

import com.betbull.futboll.dto.PlayerDto;
import com.betbull.futboll.response.base.BaseResponse;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.betbull.futboll.enums.Error;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlayerResponse extends BaseResponse {

    private static final long serialVersionUID = -774947718002386439L;

    public PlayerResponse(int statusCode, Error error, PlayerDto player) {
        super(statusCode, error);
        this.player = player;
    }
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private PlayerDto player;

    public PlayerDto getPlayer() {
        return player;
    }

    public void setPlayer(PlayerDto player) {
        this.player = player;
    }
}
