package com.betbull.futboll.testbase.datahelper.contract;

import com.betbull.futboll.dto.ContractDto;

import java.time.LocalDate;

public class ContractDTOFactory {

    public ContractDto contractDto(){
        ContractDto contractDto = new ContractDto();
        contractDto.setId(1);
        contractDto.setPlayerId(1);
        contractDto.setTeamId(3);
        contractDto.setContractPayment(1.0);
        contractDto.setTransferPayment(5.0);
        contractDto.setTeamCommission(2.0);
        contractDto.setStartDate(LocalDate.of(2020,02,02));
        contractDto.setEndDate(LocalDate.of(2022,02,02));

        return contractDto;
    }
}
