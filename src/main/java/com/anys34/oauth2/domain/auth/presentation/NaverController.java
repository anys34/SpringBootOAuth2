package com.anys34.oauth2.domain.auth.presentation;

import com.anys34.oauth2.domain.auth.presentation.dto.req.CodeRequest;
import com.anys34.oauth2.domain.auth.presentation.dto.res.TokenResponse;
import com.anys34.oauth2.domain.auth.service.naver.NaverAuthLinkService;
import com.anys34.oauth2.domain.auth.service.naver.NaverAuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/naver")
@RestController
public class NaverController {
    private final NaverAuthLinkService naverAuthLinkService;
    private final NaverAuthService naverAuthService;

    @GetMapping
    public String getNaverAuthLink() {
        return naverAuthLinkService.execute();
    }

    @PostMapping
    public TokenResponse login(@RequestBody @Valid CodeRequest codeRequest) {
        return naverAuthService.execute(codeRequest);
    }
}
