package com.anys34.oauth2.global.config.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Setter
@Getter
@Configuration
@ConfigurationProperties("auth")
public class AuthProperties {

    private Google google;
    private Kakao kakao;

    @Getter
    @Setter
    public static class Google {
        private String baseUrl;
        private String clientId;
        private String redirectUrl;
    }

    @Getter
    @Setter
    public static class Kakao {
        private String baseUrl;
        private String clientId;
        private String redirectUrl;
    }

    public String getGoogleBaseUrl() {
        return google.getBaseUrl();
    }

    public String getGoogleClientId() {
        return google.getClientId();
    }

    public String getGoogleRedirectUrl() {
        return google.getRedirectUrl();
    }

    public String getKakaoBaseUrl() {
        return kakao.getBaseUrl();
    }

    public String getKakaoClientId() {
        return kakao.getClientId();
    }

    public String getKakaoRedirectUrl() {
        return kakao.getRedirectUrl();
    }
}
