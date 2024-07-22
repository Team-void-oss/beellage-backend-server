package com.oss.beellage.user.service;

import com.oss.beellage.user.dto.JoinRequest;
import com.oss.beellage.user.dto.UserResponse;
import com.oss.beellage.user.dto.UserUpdateRequest;

public interface UserService {
    void register(JoinRequest joinRequest);

    UserResponse findById(Long id);

    void modify(Long id, UserUpdateRequest userUpdateRequest);

    void withdraw(Long id);
}
