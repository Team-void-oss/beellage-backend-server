package com.oss.beellage.user.service;

import com.oss.beellage.user.dto.JoinRequest;
import com.oss.beellage.user.dto.UserResponse;

public interface UserService {
    void register(JoinRequest joinRequest);

    UserResponse findById(Long id);
}
