package com.anys34.oauth2.domain.auth.presentation;

import com.anys34.oauth2.domain.auth.presentation.dto.req.RefreshTokenRequest;
import com.anys34.oauth2.domain.auth.presentation.dto.res.AccessTokenResponse;
import com.anys34.oauth2.domain.auth.service.CreateAccessTokenService;
import com.anys34.oauth2.domain.auth.service.DeleteRefreshTokenService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/auth")
@RestController
public class AuthController {
    private final CreateAccessTokenService createNewAccessToken;
    private final DeleteRefreshTokenService deleteRefreshTokenService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public AccessTokenResponse createNewAccessToken(@RequestBody @Valid RefreshTokenRequest request) {
        return createNewAccessToken.execute(request.getRefreshToken());
    }

    @PostMapping("/logout")
    public void logout(@RequestBody @Valid RefreshTokenRequest request) {
        deleteRefreshTokenService.execute(request);
    }
}
