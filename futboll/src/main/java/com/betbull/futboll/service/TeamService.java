package com.betbull.futboll.service;

import com.betbull.futboll.dto.TeamDto;

import java.util.List;

public interface TeamService {
    TeamDto saveTeam(TeamDto teamDto);
    TeamDto updateTeam(Integer id, TeamDto teamDto);
    TeamDto getTeam(Integer id);
    List<TeamDto> getAllTeams();
    void deleteTeam(Integer id) ;
}
