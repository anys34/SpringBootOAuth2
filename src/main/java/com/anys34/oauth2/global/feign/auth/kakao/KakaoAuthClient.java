package com.anys34.oauth2.global.feign.auth.kakao;

import com.anys34.oauth2.global.feign.auth.kakao.dto.res.KakaoAuthResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "KakaoAuthClient", url = "https://kauth.kakao.com/oauth/token")
public interface KakaoAuthClient {
    @GetMapping("?grant_type=authorization_code&" +
            "client_id={CLIENT_ID}&redirect_uri={REDIRECT_URL}&code={CODE}")
    KakaoAuthResponse getAccessToken(@PathVariable("CLIENT_ID") String client_id,
                                         @PathVariable("REDIRECT_URL") String url,
                                         @PathVariable("CODE") String code);
}
