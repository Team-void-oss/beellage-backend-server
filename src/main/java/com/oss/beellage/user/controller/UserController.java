package com.oss.beellage.user.controller;

import com.oss.beellage.common.dto.CommonResponse;
import com.oss.beellage.user.dto.JoinRequest;

public interface UserController {
    CommonResponse<?> register(JoinRequest joinRequest);

    CommonResponse<?> findById(Long id);
}
