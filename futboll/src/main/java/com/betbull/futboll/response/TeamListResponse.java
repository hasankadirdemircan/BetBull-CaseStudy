package com.betbull.futboll.response;

import com.betbull.futboll.dto.PlayerDto;
import com.betbull.futboll.dto.TeamDto;
import com.betbull.futboll.enums.Error;
import com.betbull.futboll.response.base.BaseResponse;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

public class TeamListResponse extends BaseResponse {

    public TeamListResponse(int statusCode, Error error, List<TeamDto> teams) {
        super(statusCode, error);
        this.teams = teams;
    }
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<TeamDto> teams;

    public List<TeamDto> getTeams() {
        return teams;
    }

    public void setTeams(List<TeamDto> teams) {
        this.teams = teams;
    }
}
