package com.oss.beellage.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class LoginSuccessResult {
    private Long userId;
    private String accessToken;
}
