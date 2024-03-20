package com.anys34.oauth2.domain.auth.service;

import com.anys34.oauth2.domain.auth.domain.repository.RefreshTokenRepository;
import com.anys34.oauth2.domain.auth.presentation.dto.req.RefreshTokenRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DeleteRefreshTokenService {
    private final RefreshTokenRepository refreshTokenRepository;

    public void execute(RefreshTokenRequest request) {
        refreshTokenRepository.deleteById(request.getRefreshToken());
    }
}
