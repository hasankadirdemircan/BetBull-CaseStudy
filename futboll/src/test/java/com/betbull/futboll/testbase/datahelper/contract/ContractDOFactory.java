package com.betbull.futboll.testbase.datahelper.contract;

import com.betbull.futboll.model.Contract;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ContractDOFactory {
    public Contract contract(){
        Contract contract = new Contract();
        contract.setId(1);
        contract.setPlayerId(1);
        contract.setTeamId(3);
        contract.setContractPayment(1L);
        contract.setTransferPayment(5L);
        contract.setTeamCommission(2L);
        contract.setStartDate(LocalDate.of(2020,02,02));
        contract.setEndDate(LocalDate.of(2022,02,02));

        return contract;
    }

    public List<Contract> contractList(){
        List<Contract> contractList = new ArrayList<>();
        Contract contract = new Contract();
        contract.setId(1);
        contract.setPlayerId(1);
        contract.setTeamId(3);
        contract.setContractPayment(1L);
        contract.setTransferPayment(5L);
        contract.setTeamCommission(2L);
        contract.setStartDate(LocalDate.of(2020,02,02));
        contract.setEndDate(LocalDate.of(2022,02,02));

        Contract contract2 = new Contract();
        contract2.setId(2);
        contract2.setPlayerId(1);
        contract2.setTeamId(4);
        contract2.setContractPayment(1L);
        contract2.setTransferPayment(5L);
        contract2.setTeamCommission(2L);
        contract2.setStartDate(LocalDate.of(2018,02,02));
        contract2.setEndDate(LocalDate.of(2020,02,02));

        contractList.add(contract);
        contractList.add(contract2);
        return contractList;
    }
}
