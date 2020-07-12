package com.betbull.futboll.service.impl;

import com.betbull.futboll.dto.TeamDto;
import com.betbull.futboll.model.Team;
import com.betbull.futboll.repository.TeamRepository;
import com.betbull.futboll.service.TeamService;
import com.betbull.futboll.util.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TeamServiceImpl implements TeamService {

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private Mapper mapper;

    @Override
    public TeamDto saveTeam(TeamDto teamDto) {
        return mapper.model2Dto(teamRepository.save(mapper.dto2Model(teamDto)));
    }

    @Override
    public TeamDto updateTeam(Integer id, TeamDto teamDto) {
        Team team = teamRepository.findFirstById(id);
        teamDto.setId(team.getId());
        return mapper.model2Dto(teamRepository.save(mapper.dto2Model(teamDto)));
    }

    @Override
    public TeamDto getTeam(Integer id) {
        return mapper.model2Dto(teamRepository.findFirstById(id));
    }

    @Override
    public List<TeamDto> getAllTeams() {
        return mapper.model2DtoTeams(teamRepository.findAll());
    }

    @Override
    public void deleteTeam(Integer id) {
        teamRepository.delete(teamRepository.findFirstById(id));
    }
}
