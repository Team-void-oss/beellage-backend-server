package com.oss.beellage.user.controller;

import com.oss.beellage.common.dto.CommonResponse;
import com.oss.beellage.user.dto.JoinRequest;
import com.oss.beellage.user.dto.UserUpdateRequest;

public interface UserController {
    CommonResponse<?> register(JoinRequest joinRequest);

    CommonResponse<?> findById(Long id);

    CommonResponse<?> modify(Long id, UserUpdateRequest userUpdateRequest);

    CommonResponse<?> withdraw(Long id);
}
