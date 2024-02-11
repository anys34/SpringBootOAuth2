package com.anys34.oauth2.domain.auth.presentation;

import com.anys34.oauth2.domain.auth.service.GoogleAuthLinkService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/google")
@RestController
public class GoogleController {
    private final GoogleAuthLinkService googleLinkService;

    @GetMapping
    public String getGoogleAuthLink() {
        return googleLinkService.execute();
    }
}
