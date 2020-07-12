package com.betbull.futboll.service;

import com.betbull.futboll.dto.ContractDto;
import com.betbull.futboll.model.Contract;
import com.betbull.futboll.repository.ContractRepository;
import com.betbull.futboll.service.impl.ContractServiceImpl;
import com.betbull.futboll.testbase.datahelper.contract.ContractDOFactory;
import com.betbull.futboll.testbase.datahelper.contract.ContractDTOFactory;
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

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@RunWith(MockitoJUnitRunner.class)
public class ContractServiceTest {
    @Mock
    private ContractRepository contractRepository;
    @Mock
    private Mapper mapper;
    @InjectMocks
    private ContractServiceImpl contractServiceImpl;

    private ContractDOFactory doFactory;
    private ContractDTOFactory dtoFactory;
    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        doFactory = new ContractDOFactory();
        dtoFactory = new ContractDTOFactory();
    }

    @Test
    public void whenSaveContractCalledThenItShouldReturnContractDto(){
        //given
        ContractDto contractDto = dtoFactory.contractDto();
        Contract contract = doFactory.contract();

        //when
        Mockito.when(mapper.dto2Model(contractDto)).thenReturn(contract);
        Mockito.when(contractRepository.save(contract)).thenReturn(contract);
        Mockito.when(mapper.model2Dto(contract)).thenReturn(contractDto);

        //then
        ContractDto response = contractServiceImpl.saveContract(contractDto);

        assertThat(response.getId(), equalTo(contract.getId()));
        assertThat(response.getPlayerId(), equalTo(contract.getPlayerId()));
        Mockito.verify(mapper, Mockito.times(1)).dto2Model(contractDto);
        Mockito.verify(mapper, Mockito.times(1)).model2Dto(contract);
        Mockito.verify(contractRepository, Mockito.times(1)).save(contract);

    }

}
