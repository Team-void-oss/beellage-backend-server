package com.oss.beellage.auth.controller;

import static com.oss.beellage.common.handler.ResponseHandler.handleResponse;

import com.oss.beellage.auth.dto.EmailAuthRequest;
import com.oss.beellage.auth.dto.LoginRequest;
import com.oss.beellage.auth.dto.LoginSuccessResult;
import com.oss.beellage.auth.service.AuthService;
import com.oss.beellage.common.dto.CommonResponse;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
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
        return handleResponse(HttpStatus.CREATED);
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
        return handleResponse(HttpStatus.OK);
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
        return handleResponse(HttpStatus.OK);
    }

    //FIXME: 이후에 유저 실명과 주민번호를 가입할 때 추가하고 계정 찾기에 사용하도록 수정하는 것이 바람직할 듯

    @Override
    @GetMapping("/login-email")
    public CommonResponse<?> findEmailByNickname(
            @RequestParam("nickname") String nickname
    ) {
        return handleResponse(
                authService.findEmailByNickname(nickname),
                HttpStatus.OK
        );
    }

    @Override
    @PostMapping("/login")
    public CommonResponse<?> login(
            @RequestBody LoginRequest loginRequest,
            HttpServletResponse response
    ) throws UnsupportedEncodingException {

        LoginSuccessResult loginSuccessResult = authService.login(loginRequest);

        Cookie accessTokenCookie = new Cookie("Authorization",
                URLEncoder.encode(loginSuccessResult.getAccessToken(), "UTF-8"));
        accessTokenCookie.setHttpOnly(true);
        accessTokenCookie.setSecure(true);
        accessTokenCookie.setPath("/");
        accessTokenCookie.setMaxAge(60 * 60 * 24);

        Cookie userIdCookie = new Cookie("user-id", String.valueOf(loginSuccessResult.getUserId()));
        userIdCookie.setHttpOnly(false);
        userIdCookie.setSecure(true);
        userIdCookie.setPath("/");
        userIdCookie.setMaxAge(60 * 60 * 24);

        response.addCookie(accessTokenCookie);
        response.addCookie(userIdCookie);

        return handleResponse(loginSuccessResult, HttpStatus.OK);
    }
}
