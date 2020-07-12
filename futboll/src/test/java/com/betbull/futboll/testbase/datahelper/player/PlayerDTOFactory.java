package com.betbull.futboll.testbase.datahelper.player;

import com.betbull.futboll.dto.PlayerCostDto;
import com.betbull.futboll.dto.PlayerDto;
import com.betbull.futboll.dto.SearchPlayerDto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PlayerDTOFactory {
    public PlayerDto playerDto(){
        PlayerDto playerDto = new PlayerDto();
        playerDto.setId(1);
        playerDto.setBirthday(LocalDate.now());
        playerDto.setUsername("kadir");

        return playerDto;
    }

    public List<PlayerDto> playerDtoList(){
        List<PlayerDto> playerDtoList = new ArrayList<>();
        PlayerDto playerDto = new PlayerDto();
        playerDto.setId(1);
        playerDto.setBirthday(LocalDate.now());
        playerDto.setUsername("kadir");

        PlayerDto playerDto2 = new PlayerDto();
        playerDto2.setId(2);
        playerDto2.setBirthday(LocalDate.now());
        playerDto2.setUsername("hasan");

        playerDtoList.add(playerDto);
        playerDtoList.add(playerDto2);
        return playerDtoList;
    }


    public SearchPlayerDto searchPlayerDto(){
        SearchPlayerDto searchPlayerDto = new SearchPlayerDto();
        searchPlayerDto.setTeamId(3);
        searchPlayerDto.setStartDate(LocalDate.now());
        searchPlayerDto.setEndDate(LocalDate.now());

        return searchPlayerDto;
    }

    public PlayerCostDto playerCostDto(){
        PlayerCostDto playerCostDto = new PlayerCostDto();
        PlayerDOFactory doFactory = new PlayerDOFactory();
        playerCostDto.setPlayer(doFactory.player());
        playerCostDto.setTransferPayment(300.0);
        playerCostDto.setTeamCommission(500.0);
        playerCostDto.setContractPayment(600.0);
        playerCostDto.setPlayerCost(1000.0);

        return playerCostDto;
    }
}
