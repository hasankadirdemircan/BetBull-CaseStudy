package com.betbull.futboll.util;

import com.betbull.futboll.dto.ContractDto;
import com.betbull.futboll.dto.PlayerDto;
import com.betbull.futboll.dto.TeamDto;
import com.betbull.futboll.model.Contract;
import com.betbull.futboll.model.Player;
import com.betbull.futboll.model.Team;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class Mapper {
    @Autowired
    private ModelMapper modelMapper;

    /*
    Player
     */
    public Player dto2Model(PlayerDto dto){
        return dto2Model(dto, null);
    }
    public Player dto2Model(PlayerDto dto, Player model){
        if(model == null){
            model = new Player();
        }
        model = modelMapper.map(dto, Player.class);
        return model;
    }

    public PlayerDto model2Dto(Player model) {
        return model2Dto(model, null);
    }
    public PlayerDto model2Dto(Player model, PlayerDto dto) {
        if(dto == null) {
            dto = new PlayerDto();
        }
        dto = modelMapper.map(model, PlayerDto.class);
        return dto;
    }

    /*
    List Player
     */
    public List<PlayerDto> model2DtoPlayers(List<Player> modelList){
        List<PlayerDto> dtoList = new ArrayList<>();
        if(!Util.isNullOrEmpty(modelList)){
            for(Player model : modelList){
                dtoList.add(model2Dto(model));
            }
        }
        return dtoList;
    }

    public List<Player> dto2ModelPlayers(List<PlayerDto> dtoList){
        List<Player> modelList = new ArrayList<>();
        if(!Util.isNullOrEmpty(dtoList)){
            for(PlayerDto dto : dtoList){
                modelList.add(dto2Model(dto));
            }
        }
        return modelList;
    }

    /*
  Team
   */
    public Team dto2Model(TeamDto dto){
        return dto2Model(dto, null);
    }
    public Team dto2Model(TeamDto dto, Team model){
        if(model == null){
            model = new Team();
        }
        model = modelMapper.map(dto, Team.class);
        return model;
    }

    public TeamDto model2Dto(Team model) {
        return model2Dto(model, null);
    }
    public TeamDto model2Dto(Team model, TeamDto dto) {
        if(dto == null) {
            dto = new TeamDto();
        }
        dto = modelMapper.map(model, TeamDto.class);
        return dto;
    }

    /*
    List Team
     */
    public List<TeamDto> model2DtoTeams(List<Team> modelList){
        List<TeamDto> dtoList = new ArrayList<>();
        if(!Util.isNullOrEmpty(modelList)){
            for(Team model : modelList){
                dtoList.add(model2Dto(model));
            }
        }
        return dtoList;
    }

    public List<Team> dto2ModelTeams(List<TeamDto> dtoList){
        List<Team> modelList = new ArrayList<>();
        if(!Util.isNullOrEmpty(dtoList)){
            for(TeamDto dto : dtoList){
                modelList.add(dto2Model(dto));
            }
        }
        return modelList;
    }

    /*
  Contract
   */
    public Contract dto2Model(ContractDto dto){
        return dto2Model(dto, null);
    }
    public Contract dto2Model(ContractDto dto, Contract model){
        if(model == null){
            model = new Contract();
        }
        model = modelMapper.map(dto, Contract.class);
        return model;
    }

    public ContractDto model2Dto(Contract model) {
        return model2Dto(model, null);
    }
    public ContractDto model2Dto(Contract model, ContractDto dto) {
        if(dto == null) {
            dto = new ContractDto();
        }
        dto = modelMapper.map(model, ContractDto.class);
        return dto;
    }

    /*
    List Contract
     */
    public List<ContractDto> model2DtoContracts(List<Contract> modelList){
        List<ContractDto> dtoList = new ArrayList<>();
        if(!Util.isNullOrEmpty(modelList)){
            for(Contract model : modelList){
                dtoList.add(model2Dto(model));
            }
        }
        return dtoList;
    }

    public List<Contract> dto2ModelContracts(List<ContractDto> dtoList){
        List<Contract> modelList = new ArrayList<>();
        if(!Util.isNullOrEmpty(dtoList)){
            for(ContractDto dto : dtoList){
                modelList.add(dto2Model(dto));
            }
        }
        return modelList;
    }


}
