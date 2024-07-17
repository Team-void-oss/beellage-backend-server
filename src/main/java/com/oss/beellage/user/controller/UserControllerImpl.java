package com.oss.beellage.user.controller;

import com.oss.beellage.common.dto.CommonResponse;
import com.oss.beellage.common.handler.ResponseHandler;
import com.oss.beellage.user.dto.JoinRequest;
import com.oss.beellage.user.dto.UserUpdateRequest;
import com.oss.beellage.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserControllerImpl implements UserController {

    private final UserService userService;

    @Override
    @PostMapping
    public CommonResponse<?> register(
            @RequestBody JoinRequest joinRequest
    ) {
        userService.register(joinRequest);
        return ResponseHandler.handleResponse(HttpStatus.CREATED);
    }

    @Override
    @GetMapping("/{userId}")
    public CommonResponse<?> findById(
            @PathVariable("userId") Long id
    ) {
        return ResponseHandler.handleResponse(userService.findById(id), HttpStatus.OK);
    }

    @Override
    @PatchMapping("/{userId}")
    public CommonResponse<?> modify(
            @PathVariable("userId") Long id,
            @RequestBody UserUpdateRequest userUpdateRequest
    ) {
        userService.modify(id, userUpdateRequest);
        return ResponseHandler.handleResponse(HttpStatus.NO_CONTENT);
    }

    // TODO: 로그인 및 JWT 발급
}
