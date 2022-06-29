package com.team33.backend.common.login.service;


import com.team33.backend.common.login.token.OauthClient;

public interface LoginService {

    Token save(OauthClient oauthClient);

    Token createToken(OauthClient githubUser);

    void saveToken(String key, String value);
}
