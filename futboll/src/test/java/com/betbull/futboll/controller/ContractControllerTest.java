package com.betbull.futboll.controller;

import com.betbull.futboll.dto.ContractDto;
import com.betbull.futboll.request.ContractRequest;
import com.betbull.futboll.response.ContractResponse;
import com.betbull.futboll.service.ContractService;

import com.betbull.futboll.testbase.datahelper.contract.ContractDOFactory;
import com.betbull.futboll.testbase.datahelper.contract.ContractDTOFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import javax.servlet.http.HttpServletResponse;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@RunWith(MockitoJUnitRunner.Silent.class)
public class ContractControllerTest {
    @Mock
    private ContractService contractService;
    @InjectMocks
    private ContractController controller;

    @Mock
    private HttpServletResponse res;

    private ContractDOFactory doFactory;
    private ContractDTOFactory dtoFactory;

    @Before
    public void setup() {
        doFactory = new ContractDOFactory();
        dtoFactory = new ContractDTOFactory();
    }

    @Test
    public void createContractTest(){
        //given
        ContractRequest request = new ContractRequest();
        request.setContract(dtoFactory.contractDto());
        ContractDto contractDto = dtoFactory.contractDto();
        //when
        Mockito.when(contractService.saveContract(contractDto)).thenReturn(contractDto);

        //then
        ContractResponse response = controller.createContract(request, res);

        assertThat(response.getStatusCode(), equalTo(200));
        Mockito.verify(contractService, Mockito.times(1)).saveContract(request.getContract());

    }
}
