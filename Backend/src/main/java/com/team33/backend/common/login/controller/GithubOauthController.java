package com.team33.backend.common.login.controller;

import com.team33.backend.common.login.configuration.ClientRegistration;
import com.team33.backend.common.login.configuration.InMemoryClientRegisterrRepository;
import com.team33.backend.common.login.service.LoginService;
import com.team33.backend.common.login.service.Token;
import com.team33.backend.common.login.token.OauthClient;
import com.team33.backend.common.login.token.WebToken;
import com.team33.backend.common.login.token.WebTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static com.team33.backend.common.login.token.github.GithubToken.GITHUB;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/oauth")
public class GithubOauthController implements OauthController {

    private final LoginService loginService;
    private final InMemoryClientRegisterrRepository inMemoryClientRegisterRepository;
    private final WebTokenProvider webTokenProvider;

    @Override
    @GetMapping("/callback")
    public ResponseEntity<LoginResponse> login(@RequestParam String code) {
        ClientRegistration clientRegistration = inMemoryClientRegisterRepository.findByRegistration(GITHUB);
        WebToken webToken = webTokenProvider.createToken(code, clientRegistration);
        OauthClient oauthClient = webTokenProvider.createOauthClient(webToken.getAccessToken(), clientRegistration);

        Token token = loginService.save(oauthClient);
        return ResponseEntity
                .ok(new LoginResponse(token.getAccessToken()));
    }
}
