package com.anys34.oauth2.global.feign.auth.naver;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.Map;

@FeignClient(name = "NaverInformationClient", url = "https://openapi.naver.com")
public interface NaverInformationClient {
    @GetMapping("/v1/nid/me")
    Map<String, Object> getUserInformation(@RequestHeader("Authorization") String token);
}
