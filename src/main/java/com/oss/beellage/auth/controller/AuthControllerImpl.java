package com.oss.beellage.auth.controller;

import com.oss.beellage.auth.dto.EmailAuthRequest;
import com.oss.beellage.auth.service.AuthService;
import com.oss.beellage.common.dto.CommonResponse;
import com.oss.beellage.common.handler.ResponseHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthControllerImpl implements AuthController {

    private final AuthService authService;

    /**
     * 이메일 포멧은 클라이언트 측에서 검증해줘야 하고 여기로 넘어왔을 땐 정상적인 이메일 포맷임이 보장
     */
    @Override
    @PostMapping("/email")
    public CommonResponse<?> validateEmail(
            @RequestBody EmailAuthRequest emailAuthRequest
    ) {
        authService.validateEmail(emailAuthRequest);
        return ResponseHandler.handleResponse(HttpStatus.CREATED);
    }

    /**
     *
     */
    @Override
    @GetMapping("/email/code")
    public CommonResponse<?> validateEmailCode(
            @RequestParam("email") String email,
            @RequestParam("code") String code
    ) {
        authService.validateEmailCode(email, code);
        return ResponseHandler.handleResponse(HttpStatus.OK);
    }

    /**
     *
     */
    @Override
    @GetMapping("/nickname")
    public CommonResponse<?> validateNickname(
            @RequestParam("nickname") String nickname
    ) {
        authService.validateNickname(nickname);
        return ResponseHandler.handleResponse(HttpStatus.OK);
    }
}
