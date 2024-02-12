package com.anys34.oauth2.global.feign.auth.naver.dto.res;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class NaverAuthResponse {
    private String access_token;
}
