package com.oss.beellage.auth.controller;

import com.oss.beellage.auth.dto.EmailAuthRequest;
import com.oss.beellage.common.dto.CommonResponse;

public interface AuthController {
    CommonResponse<?> validateEmail(EmailAuthRequest emailAuthRequest);

    CommonResponse<?> validateEmailCode(String email, String code);

    CommonResponse<?> validateNickname(String nickname);
}
