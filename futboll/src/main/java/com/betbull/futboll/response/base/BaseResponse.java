package com.betbull.futboll.response.base;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.betbull.futboll.enums.Error;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class BaseResponse implements Serializable {

    public BaseResponse(int statusCode, Error error) {
        this.statusCode = statusCode;
        this.error = error;
    }

    private int statusCode;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Error error;

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }
}
