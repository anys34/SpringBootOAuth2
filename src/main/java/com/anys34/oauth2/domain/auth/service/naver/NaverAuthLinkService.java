package com.anys34.oauth2.domain.auth.service.naver;

import com.anys34.oauth2.global.config.properties.AuthProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class NaverAuthLinkService {
    private static final String QUERY_STRING = "?response_type=code&" +
            "client_id=%s&redirect_uri=%s&state=%s";
    private final AuthProperties authProperties;

    public String execute() {
        return authProperties.getNaverBaseUrl() +
                String.format(
                        QUERY_STRING,
                        authProperties.getNaverClientId(),
                        authProperties.getNaverRedirectUrl(),
                        authProperties.getNaverState()
                );
    }
}
