package com.anys34.oauth2.domain.auth.service;

import com.anys34.oauth2.global.config.properties.AuthProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class GoogleAuthLinkService {
    private static final String QUERY_STRING = "?client_id=%s&redirect_uri=%s" +
            "&response_type=token&scope=https://www.googleapis.com/auth/userinfo.email https://www.googleapis.com/auth/userinfo.profile";
    private final AuthProperties authProperties;

    public String execute() {
        return authProperties.getGoogleBaseUrl() +
                String.format(
                        QUERY_STRING,
                        authProperties.getGoogleClientId(),
                        authProperties.getGoogleRedirectUrl()
                );
    }
}
