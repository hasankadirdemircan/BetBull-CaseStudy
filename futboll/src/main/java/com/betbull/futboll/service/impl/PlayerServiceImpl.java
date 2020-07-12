package com.betbull.futboll.service.impl;

import com.betbull.futboll.constant.TransferParameter;
import com.betbull.futboll.dto.PlayerCostDto;
import com.betbull.futboll.dto.PlayerDto;
import com.betbull.futboll.dto.SearchPlayerDto;
import com.betbull.futboll.exception.InternalServerException;
import com.betbull.futboll.exception.PlayerNotFoundException;
import com.betbull.futboll.model.Contract;
import com.betbull.futboll.model.Player;
import com.betbull.futboll.repository.ContractRepository;
import com.betbull.futboll.repository.PlayerRepository;
import com.betbull.futboll.service.PlayerService;
import com.betbull.futboll.util.Mapper;
import jdk.vm.ci.meta.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    PlayerRepository playerRepository;

    @Autowired
    ContractRepository contractRepository;

    @Autowired
    Mapper mapper;

    @Override
    public PlayerDto savePlayer(PlayerDto playerDto) {
        return mapper.model2Dto(playerRepository.save(mapper.dto2Model(playerDto)));
    }

    @Override
    public PlayerDto updatePlayer(Integer id, PlayerDto playerDto) {
        Player player = playerRepository.findFirstById(id);
        player = mapper.dto2Model(playerDto);

        return mapper.model2Dto(playerRepository.save(mapper.dto2Model(playerDto)));
    }

    @Override
    public PlayerDto getPlayer(Integer id) {
        return mapper.model2Dto(playerRepository.findFirstById(id));
    }

    @Override
    public List<PlayerDto> getAllPlayers() {
        return mapper.model2DtoPlayers(playerRepository.findAll());
    }

    @Override
    public void deletePlayer(Integer id) {
        playerRepository.delete(playerRepository.findFirstById(id));
    }

    @Override
    public List<PlayerDto> getSearchPlayerWithTeamAndYear(SearchPlayerDto searchPlayerDto) {
      List<Contract> playersDetail = contractRepository.playerDetail(searchPlayerDto.getTeamId(), searchPlayerDto.getStartDate(), searchPlayerDto.getEndDate());
      List<Integer> collect = playersDetail.stream().map(contract -> contract.getPlayerId()).collect(Collectors.toList());
      List<Player> players = playerRepository.findAllById(collect);
      return mapper.model2DtoPlayers(players);
    }

    @Override
    public PlayerCostDto costPlayer(Integer playerId) {
        Player player = playerRepository.findFirstById(playerId);
        if(null == player){
            throw new PlayerNotFoundException("player not found "+ playerId);
        }
        List<Contract> playerContracts = contractRepository.findByPlayerId(player.getId());
        int monthExperienceOfPlayer = 0;
        for(Contract playerContract : playerContracts){
            monthExperienceOfPlayer += ChronoUnit.MONTHS.between(
                    LocalDate.parse(playerContract.getStartDate().toString()).withDayOfMonth(1),
                    LocalDate.parse(playerContract.getEndDate().toString()).withDayOfMonth(1));
        }
        Long playerAge = ChronoUnit.YEARS.between(player.getBirthday(), LocalDate.now());
        Double transferPayment = (monthExperienceOfPlayer * TransferParameter.TRANSFER_CONSTANT)/playerAge;
        Double teamCommission = transferPayment * TransferParameter.TEAM_COMISSION;
        Double contractPayment = transferPayment + teamCommission;

        PlayerCostDto playerCostDto = new PlayerCostDto();
        playerCostDto.setContractPayment(contractPayment);
        playerCostDto.setTeamCommission(teamCommission);
        playerCostDto.setTransferPayment(transferPayment);
        playerCostDto.setPlayer(player);
        return playerCostDto;
    }
}
