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

    //FIXME: 이후에 유저 실명과 주민번호를 가입할 때 추가하고 계정 찾기에 사용하도록 수정하는 것이 바람직할 듯

    @Override
    @GetMapping("/login-email")
    public CommonResponse<?> findEmailByNickname(
            @RequestParam("nickname") String nickname
    ) {
        return ResponseHandler.handleResponse(
                authService.findEmailByNickname(nickname),
                HttpStatus.OK
        );
    }
}
