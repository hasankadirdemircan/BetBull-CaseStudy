package com.betbull.futboll.service;

import com.betbull.futboll.dto.PlayerDto;
import com.betbull.futboll.dto.TeamDto;
import com.betbull.futboll.model.Player;
import com.betbull.futboll.model.Team;
import com.betbull.futboll.repository.TeamRepository;
import com.betbull.futboll.service.impl.TeamServiceImpl;
import com.betbull.futboll.testbase.datahelper.player.PlayerDOFactory;
import com.betbull.futboll.testbase.datahelper.player.PlayerDTOFactory;
import com.betbull.futboll.testbase.datahelper.team.TeamDOFactory;
import com.betbull.futboll.testbase.datahelper.team.TeamDTOFactory;
import com.betbull.futboll.util.Mapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@RunWith(MockitoJUnitRunner.class)
public class TeamServiceTest {
    @Mock
    private TeamRepository teamRepository;
    @Mock
    private Mapper mapper;
    @InjectMocks
    private TeamServiceImpl teamService;

    private TeamDOFactory doFactory;
    private TeamDTOFactory dtoFactory;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        doFactory = new TeamDOFactory();
        dtoFactory = new TeamDTOFactory();
    }

    @Test
    public void whenSaveTeamCalledThenItShouldReturnTeamDto(){
        //given
        Team team = doFactory.team();
        TeamDto teamDto = dtoFactory.teamDto();

        //when
        Mockito.when(mapper.dto2Model(teamDto)).thenReturn(team);
        Mockito.when(teamRepository.save(team)).thenReturn(team);
        Mockito.when(mapper.model2Dto(team)).thenReturn(teamDto);

        //then
        TeamDto response = teamService.saveTeam(teamDto);

        assertThat(response.getId(), equalTo(team.getId()));
        assertThat(response.getName(), equalTo(team.getName()));
        Mockito.verify(teamRepository, Mockito.times(1)).save(team);
        Mockito.verify(mapper, Mockito.times(1)).dto2Model(teamDto);
        Mockito.verify(mapper, Mockito.times(1)).model2Dto(team);
    }

    @Test
    public void whenUpdateTeamCalledByIdThenItShouldReturnPlayerDto(){
        //given
        Team team = doFactory.team();
        Team updateTeam = doFactory.team();
        updateTeam.setName("fenerbahce");
        TeamDto teamDto = dtoFactory.teamDto();
        TeamDto updateTeamDto = dtoFactory.teamDto();
        updateTeamDto.setName("fenerbahce");
        //when
        Mockito.when(teamRepository.findFirstById(team.getId())).thenReturn(team);
        Mockito.when(teamRepository.save(updateTeam)).thenReturn(updateTeam);
        Mockito.when(mapper.model2Dto(updateTeam)).thenReturn(updateTeamDto);
        Mockito.when(mapper.dto2Model(updateTeamDto)).thenReturn(updateTeam);

        //then
        TeamDto response = teamService.updateTeam(updateTeamDto.getId(), updateTeamDto);

        assertThat(response.getId(), equalTo(team.getId()));
        assertThat(response.getName(), equalTo(updateTeam.getName()));
        Mockito.verify(teamRepository, Mockito.times(1)).findFirstById(team.getId());
        Mockito.verify(teamRepository, Mockito.times(1)).save(updateTeam);
        Mockito.verify(mapper, Mockito.times(1)).model2Dto(updateTeam);
        Mockito.verify(mapper, Mockito.times(1)).dto2Model(updateTeamDto);

    }

    @Test
    public void whenGetTeamCalledByIdThenItShouldReturnTeamDto(){
        //given
        Team team = doFactory.team();
        TeamDto teamDto = dtoFactory.teamDto();

        //when
        Mockito.when(teamRepository.findFirstById(team.getId())).thenReturn(team);
        Mockito.when(mapper.model2Dto(team)).thenReturn(teamDto);

        //then
        TeamDto response = teamService.getTeam(team.getId());

        assertThat(response.getId(), equalTo(team.getId()));
        assertThat(response.getName(), equalTo(team.getName()));
        Mockito.verify(teamRepository, Mockito.times(1)).findFirstById(team.getId());
        Mockito.verify(mapper, Mockito.times(1)).model2Dto(team);
    }

    @Test
    public void whenGetAllTeamsCalledThenItShouldReturnListTeamDto(){
        //given
        List<TeamDto> teamDtoList = Arrays.asList(dtoFactory.teamDto());
        List<Team> teamList = Arrays.asList(doFactory.team());

        //when
        Mockito.when(teamRepository.findAll()).thenReturn(teamList);
        Mockito.when(mapper.model2DtoTeams(teamList)).thenReturn(teamDtoList);

        //then
        List<TeamDto> response = teamService.getAllTeams();


        assertThat(response.size(), equalTo(teamDtoList.size()));
        assertThat(response.get(0).getId(), equalTo(teamDtoList.get(0).getId()));
        Mockito.verify(teamRepository, Mockito.times(1)).findAll();
        Mockito.verify(mapper, Mockito.times(1)).model2DtoTeams(teamList);

    }

    @Test
    public void whenDeleteTeamCalledThenItShouldVerify(){
        //given
        Team team = doFactory.team();
        Integer teamId = doFactory.team().getId();

        //when
        Mockito.when(teamRepository.findFirstById(teamId)).thenReturn(team);

        //then
        teamService.deleteTeam(teamId);
        Mockito.verify(teamRepository, Mockito.times(1)).delete(team);
    }

}
