package com.betbull.futboll.response;

import com.betbull.futboll.dto.PlayerDto;
import com.betbull.futboll.enums.Error;
import com.betbull.futboll.response.base.BaseResponse;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

public class PlayerListResponse extends BaseResponse {

    public PlayerListResponse(int statusCode, Error error, List<PlayerDto> players) {
        super(statusCode, error);
        this.players = players;
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<PlayerDto> players;

    public List<PlayerDto> getPlayers() {
        return players;
    }

    public void setPlayers(List<PlayerDto> players) {
        this.players = players;
    }
}
