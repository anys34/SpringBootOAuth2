package com.anys34.oauth2.global.feign.auth.kakao.dto.res;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class KakaoAuthResponse {
    private String access_token;
}
