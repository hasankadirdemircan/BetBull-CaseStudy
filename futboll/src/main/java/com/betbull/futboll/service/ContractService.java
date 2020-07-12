package com.betbull.futboll.service;

import com.betbull.futboll.dto.ContractDto;
import com.betbull.futboll.model.Contract;

import java.util.Date;
import java.util.List;

public interface ContractService {
    ContractDto saveContract(ContractDto contractDto);
    List<Integer> playerIds(Integer teamId, Date contractStartDate, Date contractEndDate);
}
