package com.betbull.futboll.controller;

import com.betbull.futboll.dto.TeamDto;
import com.betbull.futboll.request.TeamRequest;
import com.betbull.futboll.response.TeamListResponse;
import com.betbull.futboll.response.TeamResponse;
import com.betbull.futboll.service.TeamService;
import com.betbull.futboll.testbase.datahelper.team.TeamDOFactory;
import com.betbull.futboll.testbase.datahelper.team.TeamDTOFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import javax.servlet.http.HttpServletResponse;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@RunWith(MockitoJUnitRunner.class)
public class TeamControllerTest {
    @Mock
    private TeamService teamService;
    @InjectMocks
    private TeamController controller;

    @Mock
    private HttpServletResponse res;

    private TeamDOFactory doFactory;
    private TeamDTOFactory dtoFactory;

    @Before
    public void setup() {
        doFactory = new TeamDOFactory();
        dtoFactory = new TeamDTOFactory();
    }

    @Test
    public void createTeamTest(){
        //given
        TeamRequest request = new TeamRequest();
        request.setTeam(dtoFactory.teamDto());

        //when
        Mockito.when(teamService.saveTeam(request.getTeam())).thenReturn(request.getTeam());

        //then
        TeamResponse response = controller.createTeam(request, res);

        assertThat(response.getTeam().getId(), equalTo(request.getTeam().getId()));
        assertThat(response.getTeam().getName(), equalTo(request.getTeam().getName()));
        Mockito.verify(teamService, Mockito.times(1)).saveTeam(request.getTeam());
    }

    public void updateTeamTest(){
        //given
        TeamRequest request = new TeamRequest();
        request.setTeam(dtoFactory.teamDto());

        //when
        Mockito.when(teamService.updateTeam(request.getTeam().getId(), request.getTeam())).thenReturn(request.getTeam());

        //then
        TeamResponse response = controller.updateTeam(request.getTeam().getId(), request, res);

        assertThat(response.getTeam().getId(), equalTo(request.getTeam().getId()));
        assertThat(response.getTeam().getName(), equalTo(request.getTeam().getName()));
        Mockito.verify(teamService, Mockito.times(1)).updateTeam(request.getTeam().getId(), request.getTeam());
    }

    public void getTeamTest(){
        //given
        Integer teamId = doFactory.team().getId();
        TeamDto teamDto = dtoFactory.teamDto();

        //when
        Mockito.when(teamService.getTeam(teamId)).thenReturn(teamDto);

        //then
        TeamResponse response = controller.getTeam(teamId, res);

        assertThat(response.getTeam().getId(), equalTo(teamId));
        assertThat(response.getTeam().getName(), equalTo(teamDto.getName()));
        Mockito.verify(teamService, Mockito.times(1)).getTeam(teamId);
    }

    public void getAllTeamsTest(){
        //given
        List<TeamDto> teamDtos = Arrays.asList(dtoFactory.teamDto());

        //when
        Mockito.when(teamService.getAllTeams()).thenReturn(teamDtos);

        //then
        TeamListResponse response = controller.getAllTeams(res);

        assertThat(response.getTeams().size(), equalTo(1));
        assertThat(response.getTeams().get(0).getId(), equalTo(teamDtos.get(0).getId()));
        Mockito.verify(teamService, Mockito.times(1)).getAllTeams();

    }

}
