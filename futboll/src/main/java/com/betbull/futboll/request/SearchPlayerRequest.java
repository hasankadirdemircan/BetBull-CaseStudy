package com.betbull.futboll.request;

import com.betbull.futboll.dto.SearchPlayerDto;
import com.betbull.futboll.request.base.BaseRequest;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchPlayerRequest extends BaseRequest {
    SearchPlayerDto searchPlayer;
}
