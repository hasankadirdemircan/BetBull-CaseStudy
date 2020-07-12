package com.betbull.futboll.response;

import com.betbull.futboll.dto.PlayerDto;
import com.betbull.futboll.dto.TeamDto;
import com.betbull.futboll.enums.Error;
import com.betbull.futboll.response.base.BaseResponse;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeamResponse extends BaseResponse {
    public TeamResponse(int statusCode, Error error, TeamDto team) {
        super(statusCode, error);
        this.team = team;
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private TeamDto team;

}
