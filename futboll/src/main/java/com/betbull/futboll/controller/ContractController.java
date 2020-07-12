package com.betbull.futboll.controller;

import com.betbull.futboll.enums.Error;
import com.betbull.futboll.repository.ContractRepository;
import com.betbull.futboll.request.ContractRequest;
import com.betbull.futboll.request.TeamRequest;
import com.betbull.futboll.response.ContractResponse;
import com.betbull.futboll.response.PlayerResponse;
import com.betbull.futboll.response.TeamResponse;
import com.betbull.futboll.service.ContractService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/contract")
@Api(value="Contract Team- Player Management System", description="Operations pertaining to contract in futboll Management System")
public class ContractController {

    @Autowired
    private ContractService contractService;

    @ApiOperation(value = "Create a contract", response = ContractResponse.class)
    @PostMapping
        public ContractResponse createContract(@RequestBody ContractRequest req, HttpServletResponse httpRes){
        ContractResponse res = null;
        if(null == req.getContract()){
            res = new ContractResponse(HttpServletResponse.SC_BAD_REQUEST, Error.ERR000, null);
        }else{
            try{
                res = new ContractResponse(HttpServletResponse.SC_OK, null, contractService.saveContract(req.getContract()));

            }catch (Exception ex){
                ex.printStackTrace();
                res = new ContractResponse(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, Error.ERR001, null);
            }
        }
        httpRes.setStatus(res.getStatusCode());
        return res;
    }


}
