package com.betbull.futboll.request;

import com.betbull.futboll.dto.TeamDto;
import com.betbull.futboll.request.base.BaseRequest;

public class TeamRequest extends BaseRequest {
    private TeamDto team;

    public TeamDto getTeam() {
        return team;
    }

    public void setTeam(TeamDto team) {
        this.team = team;
    }
}
