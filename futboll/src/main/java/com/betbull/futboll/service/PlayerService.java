package com.betbull.futboll.service;

import com.betbull.futboll.dto.PlayerCostDto;
import com.betbull.futboll.dto.PlayerDto;
import com.betbull.futboll.dto.SearchPlayerDto;
import jdk.vm.ci.meta.Local;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.Date;
import java.util.List;

public interface PlayerService {

    PlayerDto savePlayer(PlayerDto playerDto);
    PlayerDto updatePlayer(Integer id, PlayerDto playerDto);
    PlayerDto getPlayer(Integer id);
    List<PlayerDto> getAllPlayers();
    void deletePlayer(Integer id);
    List<PlayerDto> getSearchPlayerWithTeamAndYear(SearchPlayerDto searchPlayerDto);
    PlayerCostDto costPlayer(Integer playerId);
}
