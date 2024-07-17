package com.oss.beellage.user.dto;

import com.oss.beellage.user.User;
import org.springframework.security.crypto.password.PasswordEncoder;

public record JoinRequest(
        String email,
        String password,
        String nickname
) {
    public User toEntity(PasswordEncoder passwordEncoder) {
        return User.builder()
                .email(email)
                .password(passwordEncoder.encode(password))
                .nickname(nickname)
                .build();
    }
}
