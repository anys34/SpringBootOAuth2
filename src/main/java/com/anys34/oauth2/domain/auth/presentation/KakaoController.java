package com.anys34.oauth2.domain.auth.presentation;

import com.anys34.oauth2.domain.auth.service.kakao.KakaoAuthLinkService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/kakao")
@RestController
public class KakaoController {
    private final KakaoAuthLinkService kakaoAuthLinkService;

    @GetMapping
    public String getGoogleAuthLink() {
        return kakaoAuthLinkService.execute();
    }
}
