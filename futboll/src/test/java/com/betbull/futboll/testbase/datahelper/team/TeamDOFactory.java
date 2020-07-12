package com.betbull.futboll.testbase.datahelper.team;

import com.betbull.futboll.model.Team;

public class TeamDOFactory {
    public Team team(){
        Team team = new Team();
        team.setId(1);
        team.setCurrency("tl");
        team.setName("Galatasaray");

        return team;
    }
}
