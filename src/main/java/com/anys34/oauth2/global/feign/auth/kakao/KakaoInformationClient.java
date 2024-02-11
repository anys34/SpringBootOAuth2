package com.anys34.oauth2.global.feign.auth.kakao;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.Map;

@FeignClient(name = "KakaoInformationClient", url = "https://kapi.kakao.com")
public interface KakaoInformationClient {
    @GetMapping("/v2/user/me")
    Map<String, Object> getUserInformation(@RequestHeader("Authorization") String token);
}
