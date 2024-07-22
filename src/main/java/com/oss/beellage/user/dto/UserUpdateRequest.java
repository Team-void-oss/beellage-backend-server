package com.oss.beellage.user.dto;

public record UserUpdateRequest(
        String nickname,
        String profileImage
) {
}
