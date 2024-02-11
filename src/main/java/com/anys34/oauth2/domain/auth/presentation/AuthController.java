package com.anys34.oauth2.domain.auth.presentation;

import com.anys34.oauth2.domain.auth.presentation.dto.req.CreateAccessTokenRequest;
import com.anys34.oauth2.domain.auth.presentation.dto.res.AccessTokenResponse;
import com.anys34.oauth2.domain.auth.service.CreateAccessTokenService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/auth")
@RestController
public class AuthController {
    private final CreateAccessTokenService createNewAccessToken;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public AccessTokenResponse createNewAccessToken(@RequestBody @Valid CreateAccessTokenRequest request) {
        return createNewAccessToken.execute(request.getRefreshToken());
    }
}
