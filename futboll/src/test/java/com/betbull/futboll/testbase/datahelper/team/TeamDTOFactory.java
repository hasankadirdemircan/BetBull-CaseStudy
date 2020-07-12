package com.betbull.futboll.testbase.datahelper.team;

import com.betbull.futboll.dto.TeamDto;

public class TeamDTOFactory {
    public TeamDto teamDto(){
        TeamDto teamDto = new TeamDto();
        teamDto.setId(1);
        teamDto.setCurrency("tl");
        teamDto.setName("Galatasaray");

        return teamDto;
    }
}
