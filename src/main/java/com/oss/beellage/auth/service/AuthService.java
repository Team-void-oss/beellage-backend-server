package com.oss.beellage.auth.service;

import com.oss.beellage.auth.dto.EmailAuthRequest;
import com.oss.beellage.auth.dto.EmailResponse;
import com.oss.beellage.auth.dto.LoginRequest;
import com.oss.beellage.auth.dto.LoginSuccessResult;

public interface AuthService {
    void validateEmail(EmailAuthRequest emailAuthRequest);

    void validateEmailCode(String email, String code);

    void validateNickname(String nickname);

    EmailResponse findEmailByNickname(String nickname);

    LoginSuccessResult login(LoginRequest loginRequest);
}
