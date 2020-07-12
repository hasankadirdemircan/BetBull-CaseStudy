package com.betbull.futboll.response;

import com.betbull.futboll.dto.ContractDto;
import com.betbull.futboll.dto.PlayerDto;
import com.betbull.futboll.enums.Error;
import com.betbull.futboll.response.base.BaseResponse;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContractResponse extends BaseResponse {
    public ContractResponse(int statusCode, Error error, ContractDto contract) {
        super(statusCode, error);
        this.contract = contract;
    }
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private ContractDto contract;

}
