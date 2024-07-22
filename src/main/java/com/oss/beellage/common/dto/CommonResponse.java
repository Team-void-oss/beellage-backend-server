package com.oss.beellage.common.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.oss.beellage.common.dto.CommonResponse.CommonData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class CommonResponse<T> extends ResponseEntity<CommonData<T>> {

    private static final String COMMON_KEY = "data";

    public CommonResponse(T data, HttpStatus status) {
        super(new CommonData<>(data), status);
    }

    public CommonResponse(HttpStatus status) {
        super(status);
    }

    public record CommonData<T>(
            @JsonProperty(COMMON_KEY) T data
    ) {
    }
}
