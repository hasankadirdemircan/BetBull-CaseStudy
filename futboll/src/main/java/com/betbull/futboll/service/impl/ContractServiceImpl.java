package com.betbull.futboll.service.impl;

import com.betbull.futboll.dto.ContractDto;
import com.betbull.futboll.repository.ContractRepository;
import com.betbull.futboll.service.ContractService;
import com.betbull.futboll.util.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class ContractServiceImpl implements ContractService {

    @Autowired
    private ContractRepository contractRepository;

    @Autowired
    private Mapper mapper;

    @Override
    public ContractDto saveContract(ContractDto contractDto) {
        return mapper.model2Dto(contractRepository.save(mapper.dto2Model(contractDto)));
    }

    @Override
    public List<Integer> playerIds(Integer teamId, Date contractStartDate, Date contractEndDate) {

        return null;
    }
}
