package com.anys34.oauth2.domain.auth.presentation;

import com.anys34.oauth2.domain.auth.service.naver.NaverAuthLinkService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/naver")
@RestController
public class NaverController {
    private final NaverAuthLinkService naverAuthLinkService;

    @GetMapping
    public String getNaverAuthLink() {
        return naverAuthLinkService.execute();
    }
}
