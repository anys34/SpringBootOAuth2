package com.anys34.oauth2.domain.auth.presentation;

import com.anys34.oauth2.domain.auth.presentation.dto.req.CodeRequest;
import com.anys34.oauth2.domain.auth.presentation.dto.res.TokenResponse;
import com.anys34.oauth2.domain.auth.service.kakao.KakaoAuthLinkService;
import com.anys34.oauth2.domain.auth.service.kakao.KakaoAuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/kakao")
@RestController
public class KakaoController {
    private final KakaoAuthLinkService kakaoAuthLinkService;
    private final KakaoAuthService kakaoAuthService;

    @GetMapping
    public String getGoogleAuthLink() {
        return kakaoAuthLinkService.execute();
    }

    @PostMapping
    public TokenResponse login(@RequestBody @Valid CodeRequest codeRequest) {
        return kakaoAuthService.execute(codeRequest);
    }
}
