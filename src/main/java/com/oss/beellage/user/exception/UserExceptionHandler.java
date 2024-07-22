package com.oss.beellage.user.exception;

import com.oss.beellage.auth.exception.AuthException;
import com.oss.beellage.common.dto.CommonResponse;
import com.oss.beellage.common.handler.ResponseHandler;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@RestControllerAdvice
public class UserExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({UserException.class})
    public CommonResponse<?> handleException(HttpServletRequest request, AuthException e) {
        log.error("User Exception {} => ", e.getMessage());

        return ResponseHandler.handleResponse(e.getHttpStatus());
    }

}
