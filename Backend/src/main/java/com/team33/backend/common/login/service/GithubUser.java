package com.team33.backend.common.login.service;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.team33.backend.common.login.token.OauthClient;
import lombok.Getter;

public class GithubUser implements OauthClient {

    @JsonProperty("login")
    private String githubId;

    @JsonProperty("avatar_url")
    private String profileImage;

    public GithubUser() {
    }

    @Override
    public String getClientId() {
        return githubId;
    }

    @Override
    public String getProfileImage() {
        return profileImage;
    }
}
