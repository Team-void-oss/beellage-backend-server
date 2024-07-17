package com.oss.beellage.user.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.oss.beellage.user.User;
import java.time.LocalDateTime;
import lombok.Builder;

@Builder
public record UserResponse(
        @JsonProperty("id") Long id,
        @JsonProperty("email") String email,
        @JsonProperty("nickname") String nickname,
        @JsonProperty("profileImage") String profileImage,
        @JsonProperty("createdAt") LocalDateTime createdAt
) {
    public static UserResponse from(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .email(user.getEmail())
                .nickname(user.getPassword())
                .profileImage(user.getProfileImage())
                .createdAt(user.getCreatedAt())
                .build();
    }
}
