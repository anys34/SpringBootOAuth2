package com.anys34.oauth2.global.feign.auth.naver;

import com.anys34.oauth2.global.feign.auth.naver.dto.res.NaverAuthResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "NaverAuthClient", url = "https://nid.naver.com/oauth2.0/token")
public interface NaverAuthClient {
    @GetMapping("?grant_type=authorization_code&client_id={CLIENT_ID}&client_secret={SECRET}&" +
            "redirect_uri={REDIRECT_URL}&code={CODE}&state={STATE}")
    NaverAuthResponse getAccessToken(@PathVariable("CLIENT_ID") String client_id,
                                     @PathVariable("SECRET") String secret,
                                     @PathVariable("REDIRECT_URL") String url,
                                     @PathVariable("CODE") String code,
                                     @PathVariable("STATE") String state);
}
