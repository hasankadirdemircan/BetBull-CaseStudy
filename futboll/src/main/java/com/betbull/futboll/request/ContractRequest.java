package com.betbull.futboll.request;

import com.betbull.futboll.dto.ContractDto;
import com.betbull.futboll.request.base.BaseRequest;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContractRequest extends BaseRequest {
    ContractDto contract;
}
