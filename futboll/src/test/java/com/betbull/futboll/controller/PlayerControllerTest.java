package com.betbull.futboll.controller;

import com.betbull.futboll.dto.PlayerDto;
import com.betbull.futboll.request.PlayerCostRequest;
import com.betbull.futboll.request.PlayerRequest;
import com.betbull.futboll.request.SearchPlayerRequest;
import com.betbull.futboll.response.PlayerCostResponse;
import com.betbull.futboll.response.PlayerListResponse;
import com.betbull.futboll.response.PlayerResponse;
import com.betbull.futboll.service.PlayerService;
import com.betbull.futboll.testbase.datahelper.contract.ContractDOFactory;
import com.betbull.futboll.testbase.datahelper.contract.ContractDTOFactory;
import com.betbull.futboll.testbase.datahelper.player.PlayerDOFactory;
import com.betbull.futboll.testbase.datahelper.player.PlayerDTOFactory;
import org.hibernate.validator.internal.engine.messageinterpolation.util.InterpolationHelper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import javax.servlet.http.HttpServletResponse;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@RunWith(MockitoJUnitRunner.class)
public class PlayerControllerTest {

    @Mock
    private PlayerService playerService;

    @InjectMocks
    private PlayerController controller;

    @Mock
    private HttpServletResponse res;

    private PlayerDOFactory doFactory;
    private PlayerDTOFactory dtoFactory;

    @Before
    public void setup() {
        doFactory = new PlayerDOFactory();
        dtoFactory = new PlayerDTOFactory();
    }

    @Test
    public void createPlayerTest(){
        //given
        PlayerRequest request = new PlayerRequest();
        request.setPlayer(dtoFactory.playerDto());

        //when
        Mockito.when(playerService.savePlayer(request.getPlayer())).thenReturn(request.getPlayer());

        //then
        PlayerResponse response = controller.createPlayer(request, res);

        assertThat(response.getPlayer().getId(), equalTo(request.getPlayer().getId()));
        assertThat(response.getPlayer().getUsername(), equalTo(request.getPlayer().getUsername()));
        Mockito.verify(playerService, Mockito.times(1)).savePlayer(request.getPlayer());

    }

    @Test
    public void updatePlayerTest(){
        //given
        PlayerRequest request = new PlayerRequest();
        request.setPlayer(dtoFactory.playerDto());

        //when
        Mockito.when(playerService.updatePlayer(request.getPlayer().getId(), request.getPlayer())).thenReturn(request.getPlayer());

        //then
        PlayerResponse response = controller.updatePlayer(request.getPlayer().getId(), request, res);

        assertThat(response.getPlayer().getId(), equalTo(request.getPlayer().getId()));
        assertThat(response.getPlayer().getUsername(), equalTo(request.getPlayer().getUsername()));
        Mockito.verify(playerService, Mockito.times(1)).updatePlayer(request.getPlayer().getId(), request.getPlayer());
    }

    @Test
    public void getPlayerTest(){
        //given
        PlayerDto playerDto = dtoFactory.playerDto();

        //when
        Mockito.when(playerService.getPlayer(playerDto.getId())).thenReturn(playerDto);

        //then
        PlayerResponse response = controller.getPlayer(playerDto.getId(),res);

        assertThat(response.getPlayer().getId(), equalTo(playerDto.getId()));
        assertThat(response.getPlayer().getUsername(), equalTo(playerDto.getUsername()));
        Mockito.verify(playerService, Mockito.times(1)).getPlayer(playerDto.getId());
    }

    @Test
    public void getAllPlayerTest(){
        //given
        PlayerDto playerDto = dtoFactory.playerDto();

        //when
        Mockito.when(playerService.getAllPlayers()).thenReturn(Arrays.asList(playerDto));

        //then
        PlayerListResponse response = controller.getAllPlayers(res);

        assertThat(response.getPlayers().size(), equalTo(1));
        Mockito.verify(playerService, Mockito.times(1)).getAllPlayers();

    }

    @Test
    public void deletePlayerTest(){
        //given
        Integer playerId = 1;

        //when

        //then
        controller.deletePlayer(playerId);
        Mockito.verify(playerService, Mockito.times(1)).deletePlayer(playerId);
    }

    @Test
    public void getSearchPlayerTest(){
        //given
        SearchPlayerRequest searchPlayerRequest =  new SearchPlayerRequest();
        searchPlayerRequest.setSearchPlayer(dtoFactory.searchPlayerDto());

        //when
        Mockito.when(playerService.getSearchPlayerWithTeamAndYear(searchPlayerRequest.getSearchPlayer())).thenReturn(Arrays.asList(dtoFactory.playerDto()));

        //then
        PlayerListResponse response = controller.getSearchPlayer(searchPlayerRequest, res);

        assertThat(response.getPlayers().size(), equalTo(1));
        Mockito.verify(playerService, Mockito.times(1)).getSearchPlayerWithTeamAndYear(searchPlayerRequest.getSearchPlayer());
    }

    @Test
    public void costPlayerTest(){
        //given
        PlayerCostRequest playerCostRequest = new PlayerCostRequest();
        playerCostRequest.setPlayerId(dtoFactory.playerDto().getId());

        //when
        Mockito.when(playerService.costPlayer(dtoFactory.playerDto().getId())).thenReturn(dtoFactory.playerCostDto());

        //then
        PlayerCostResponse response = controller.costPlayer(playerCostRequest, res);

        assertThat(response.getPlayerCost().getPlayerCost(), equalTo(dtoFactory.playerCostDto().getPlayerCost()));
        Mockito.verify(playerService, Mockito.times(1)).costPlayer(playerCostRequest.getPlayerId());
    }
}
