package com.oss.beellage.auth.controller;

import com.oss.beellage.auth.dto.EmailAuthRequest;
import com.oss.beellage.auth.dto.LoginRequest;
import com.oss.beellage.common.dto.CommonResponse;
import jakarta.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

public interface AuthController {
    CommonResponse<?> validateEmail(EmailAuthRequest emailAuthRequest);

    CommonResponse<?> validateEmailCode(String email, String code);

    CommonResponse<?> validateNickname(String nickname);

    CommonResponse<?> findEmailByNickname(String nickname);

//    CommonResponse<?> resetPassword();

    CommonResponse<?> login(LoginRequest loginRequest, HttpServletResponse response)
            throws UnsupportedEncodingException;
}
