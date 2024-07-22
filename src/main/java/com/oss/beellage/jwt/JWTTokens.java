package com.oss.beellage.jwt;

public record JWTTokens(
        String accessToken,
        String refreshToken
) {
}
