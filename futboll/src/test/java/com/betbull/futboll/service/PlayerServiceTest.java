package com.betbull.futboll.service;

import com.betbull.futboll.dto.PlayerCostDto;
import com.betbull.futboll.dto.PlayerDto;
import com.betbull.futboll.model.Contract;
import com.betbull.futboll.model.Player;
import com.betbull.futboll.repository.ContractRepository;
import com.betbull.futboll.repository.PlayerRepository;
import com.betbull.futboll.service.impl.PlayerServiceImpl;
import com.betbull.futboll.testbase.datahelper.contract.ContractDOFactory;
import com.betbull.futboll.testbase.datahelper.player.PlayerDOFactory;
import com.betbull.futboll.testbase.datahelper.player.PlayerDTOFactory;
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
public class PlayerServiceTest {
    @Mock
    private PlayerRepository playerRepository;
    @Mock
    private ContractRepository contractRepository;
    @InjectMocks
    private PlayerServiceImpl playerServiceImpl;

    @Mock
    private Mapper mapper;

    private PlayerDOFactory doFactory;
    private PlayerDTOFactory dtoFactory;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        doFactory = new PlayerDOFactory();
        dtoFactory = new PlayerDTOFactory();
    }

    @Test
    public void whenSavePlayerCalledThenItShouldReturnPlayerDto(){
        //given
        Player player = doFactory.player();
        PlayerDto playerDto = dtoFactory.playerDto();

        //when
        Mockito.when(playerRepository.save(player)).thenReturn(player);
        Mockito.when(mapper.dto2Model(playerDto)).thenReturn(player);
        Mockito.when(mapper.model2Dto(player)).thenReturn(playerDto);
        //then
        PlayerDto response = playerServiceImpl.savePlayer(playerDto);

        assertThat(response.getId(), equalTo(player.getId()));
        assertThat(response.getUsername(), equalTo(player.getUsername()));
        Mockito.verify(playerRepository, Mockito.times(1)).save(player);
    }

    @Test
    public void whenUpdatePlayerCalledByIdThenItShouldReturnPlayerDto(){
        //given
        Player player = doFactory.player();
        PlayerDto playerDto = dtoFactory.playerDto();

        //when
        Mockito.when(playerRepository.findFirstById(player.getId())).thenReturn(player);
        Mockito.when(mapper.dto2Model(playerDto)).thenReturn(player);
        Mockito.when(playerRepository.save(player)).thenReturn(player);
        Mockito.when(mapper.model2Dto(player)).thenReturn(playerDto);

        //then
        PlayerDto response = playerServiceImpl.updatePlayer(player.getId(), playerDto);

        assertThat(response.getId(), equalTo(player.getId()));
        assertThat(response.getUsername(), equalTo(player.getUsername()));
        Mockito.verify(playerRepository, Mockito.times(1)).findFirstById(player.getId());
        Mockito.verify(playerRepository, Mockito.times(1)).save(player);
        Mockito.verify(mapper, Mockito.times(1)).model2Dto(player);

    }

    @Test
    public void whenGetPlayerCalledByIdThenItShouldReturnPlayerDto(){
        //given
        Player player = doFactory.player();
        PlayerDto playerDto = dtoFactory.playerDto();

        //when
        Mockito.when(playerRepository.findFirstById(player.getId())).thenReturn(player);
        Mockito.when(mapper.model2Dto(player)).thenReturn(playerDto);

        //then
        PlayerDto response = playerServiceImpl.getPlayer(player.getId());

        assertThat(response.getId(), equalTo(player.getId()));
        assertThat(response.getUsername(), equalTo(player.getUsername()));
        Mockito.verify(playerRepository, Mockito.times(1)).findFirstById(player.getId());
        Mockito.verify(mapper, Mockito.times(1)).model2Dto(player);
    }

    @Test
    public void whenGetAllPlayersCalledThenItShouldReturnListPlayerDto(){
        //given
        List<PlayerDto> playerDtos = Arrays.asList(dtoFactory.playerDto());
        List<Player> players = Arrays.asList(doFactory.player());

        //when
        Mockito.when(playerRepository.findAll()).thenReturn(players);
        Mockito.when(mapper.model2DtoPlayers(players)).thenReturn(playerDtos);

        //then
        List<PlayerDto> response = playerServiceImpl.getAllPlayers();

        assertThat(response.size(), equalTo(playerDtos.size()));
        assertThat(response.get(0).getId(), equalTo(playerDtos.get(0).getId()));
        Mockito.verify(playerRepository, Mockito.times(1)).findAll();
        Mockito.verify(mapper, Mockito.times(1)).model2DtoPlayers(players);
    }

    @Test
    public void whenDeletePlayerCalledThenItShouldVerify(){
        //given
        Player player = doFactory.player();
        Integer playerId = doFactory.player().getId();

        //when
        Mockito.when(playerRepository.findFirstById(playerId)).thenReturn(player);

        //then
        playerServiceImpl.deletePlayer(playerId);
        Mockito.verify(playerRepository, Mockito.times(1)).delete(player);
    }

    @Test
    public void whenGetSearchPlayerWithTeamAndYearCalledThenItShouldReturnListPlayerDto(){
        //given
     /*   SearchPlayerDto searchPlayerDto = dtoFactory.searchPlayerDto();
        ContractDOFactory contractDOFactory = new ContractDOFactory();
        List<Contract> contractList = contractDOFactory.contractList();
        List<Integer> collect = new ArrayList<>();
        collect.add(1);
        collect.add(2);
        List<Player> playerList = doFactory.playerList();
        List<PlayerDto> playerDTOList = dtoFactory.playerDtoList();

        //when

        Mockito.when(playerRepository.findAllById(collect)).thenReturn(playerList);
        Mockito.when(mapper.model2DtoPlayers(playerList)).thenReturn(playerDTOList);
       /* Mockito.when(contractRepository.playerDetail(searchPlayerDto.getTeamId(), searchPlayerDto.getStartDate(), searchPlayerDto.getEndDate()))
                .thenReturn(contractList);*/
        //then
     /*  List<PlayerDto> response =  playerServiceImpl.getSearchPlayerWithTeamAndYear(searchPlayerDto);
       assertThat(response.size(), equalTo(playerDTOList.size()));
       assertThat(response.get(0).getId(), equalTo(playerDTOList.get(0).getId()));
       Mockito.verify(playerRepository, Mockito.times(1)).findAllById(collect);
       Mockito.verify(mapper, Mockito.times(1)).model2DtoPlayers(playerList);

*/
    }

    @Test
    public void whenCostPlayerCalledThenItShouldReturnPlayerCostDto(){
        //given
        Player player = doFactory.player();
        ContractDOFactory contractDOFactory = new ContractDOFactory();
        List<Contract> contractList = contractDOFactory.contractList();
        //when
        Mockito.when(playerRepository.findFirstById(player.getId())).thenReturn(player);
        Mockito.when(contractRepository.findByPlayerId(player.getId())).thenReturn(contractList);

        //then
        PlayerCostDto response = playerServiceImpl.costPlayer(player.getId());

        assertThat(response.getTransferPayment(), equalTo(192000.0));
        assertThat(response.getTeamCommission(), equalTo(19200.0));
        assertThat(response.getContractPayment(), equalTo(211200.0));
        Mockito.verify(contractRepository, Mockito.times(1)).findByPlayerId(player.getId());
        Mockito.verify(playerRepository, Mockito.times(1)).findFirstById(player.getId());
    }
}
