package com.anys34.oauth2.domain.auth.service.kakao;

import com.anys34.oauth2.global.config.properties.AuthProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class KakaoAuthLinkService {
    private static final String QUERY_STRING = "?client_id=%s&" +
            "redirect_uri=%s&response_type=code";
    private final AuthProperties authProperties;

    public String execute() {
        return authProperties.getKakaoBaseUrl() +
                String.format(
                        QUERY_STRING,
                        authProperties.getKakaoClientId(),
                        authProperties.getKakaoRedirectUrl()
                );
    }
}
