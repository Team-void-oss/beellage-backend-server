package com.oss.beellage.auth.service;

import com.oss.beellage.auth.dto.EmailAuthRequest;

public interface AuthService {
    void validateEmail(EmailAuthRequest emailAuthRequest);

    void validateEmailCode(String email, String code);
}
