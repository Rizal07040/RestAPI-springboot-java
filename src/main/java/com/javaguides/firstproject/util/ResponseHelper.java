package com.javaguides.firstproject.util;

import com.javaguides.firstproject.response.BaseResponse;
import org.springframework.http.ResponseEntity;

public class ResponseHelper {

    public static ResponseEntity<BaseResponse> buildOkResponse(Object data) {
        BaseResponse mainResponse = BaseResponse.builder()
                .data(data)
                .success(true).build();

        return ResponseEntity.ok(mainResponse);
    }
}
