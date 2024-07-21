package com.oss.beellage.user.dto;

import lombok.Data;

@Data
public class UserRequest {
    private String email;
    private String password;
    private String nickname;
    private String profileImage;
}
