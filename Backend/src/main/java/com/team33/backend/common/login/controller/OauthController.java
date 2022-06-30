package com.team33.backend.common.login.controller;

import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;

public interface OauthController {

    ResponseEntity<LoginResponse> login(String code);

    default ResponseCookie createCookie(String token) {
        return ResponseCookie.from("refreshToken", token)
                .httpOnly(true)
                .secure(true)
                .maxAge(1000 * 60 * 12 * 24 * 7)
                .path("/")
                .build();
    }
}
