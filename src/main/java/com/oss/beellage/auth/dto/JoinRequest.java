package com.oss.beellage.auth.dto;

import com.oss.beellage.auth.User;
import org.springframework.security.crypto.password.PasswordEncoder;

public record JoinRequest(
        String email,
        String password,
        String nickname
) {
    public User toUser(PasswordEncoder passwordEncoder) {
        return User.builder()
                .email(email)
                .password(passwordEncoder.encode(password))
                .nickname(nickname)
                .build();
    }
}
