package com.anys34.oauth2.domain.auth.service.naver;

import com.anys34.oauth2.domain.auth.presentation.dto.req.CodeRequest;
import com.anys34.oauth2.domain.auth.presentation.dto.res.TokenResponse;
import com.anys34.oauth2.domain.user.domain.User;
import com.anys34.oauth2.domain.user.domain.repository.UserRepository;
import com.anys34.oauth2.domain.user.domain.type.Provider;
import com.anys34.oauth2.domain.user.facade.UserFacade;
import com.anys34.oauth2.global.config.properties.AuthProperties;
import com.anys34.oauth2.global.feign.auth.naver.NaverAuthClient;
import com.anys34.oauth2.global.feign.auth.naver.NaverInformationClient;
import com.anys34.oauth2.global.feign.auth.naver.dto.res.NaverAuthResponse;
import com.anys34.oauth2.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class NaverAuthService {
    private final AuthProperties authProperties;
    private final NaverAuthClient naverAuthClient;
    private final NaverInformationClient naverInformationClient;
    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserFacade userFacade;

    @Transactional
    public TokenResponse execute(CodeRequest codeRequest) {
        NaverAuthResponse accessToken = naverAuthClient.getAccessToken(
                authProperties.getNaverClientId(),
                authProperties.getNaverSecretId(),
                authProperties.getNaverRedirectUrl(),
                codeRequest.getCode(),
                authProperties.getNaverState()
        );

        Map<String, Object> response = naverInformationClient.getUserInformation("Bearer " + accessToken.getAccess_token());
        Map<String, Object> info = (Map<String, Object>) response.get("response");

        String nickname = (String) info.get("nickname");
        String profile_img = (String) info.get("profile_image");
        String email = (String) info.get("email");

        Optional<User> user = userFacade.findEmail(email);

        if (user.isEmpty()) {
            userRepository.save(User.builder()
                    .email(email)
                    .nickname(nickname)
                    .profileImg(profile_img)
                    .provider(Provider.NAVER)
                    .build());
        }

        return TokenResponse.builder()
                .accessToken(jwtTokenProvider.createAccessToken(email))
                .refreshToken(jwtTokenProvider.createRefreshToken(email))
                .build();
    }
}
