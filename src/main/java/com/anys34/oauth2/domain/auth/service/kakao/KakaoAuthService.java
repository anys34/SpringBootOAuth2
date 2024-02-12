package com.anys34.oauth2.domain.auth.service.kakao;

import com.anys34.oauth2.domain.auth.presentation.dto.req.CodeRequest;
import com.anys34.oauth2.domain.auth.presentation.dto.res.TokenResponse;
import com.anys34.oauth2.domain.user.domain.User;
import com.anys34.oauth2.domain.user.domain.repository.UserRepository;
import com.anys34.oauth2.domain.user.domain.type.Provider;
import com.anys34.oauth2.global.config.properties.AuthProperties;
import com.anys34.oauth2.global.feign.auth.kakao.KakaoAuthClient;
import com.anys34.oauth2.global.feign.auth.kakao.KakaoInformationClient;
import com.anys34.oauth2.global.feign.auth.kakao.dto.res.KakaoAuthResponse;
import com.anys34.oauth2.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class KakaoAuthService {
    private final AuthProperties authProperties;
    private final KakaoAuthClient kakaoAuthClient;
    private final KakaoInformationClient kakaoInformationClient;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserRepository userRepository;

    public TokenResponse execute(CodeRequest codeRequest) {
        KakaoAuthResponse accessToken = kakaoAuthClient.getAccessToken(
                authProperties.getKakaoClientId(),
                authProperties.getKakaoRedirectUrl(),
                codeRequest.getCode());

        Map<String, Object> response = kakaoInformationClient.getUserInformation("Bearer " + accessToken.getAccess_token());

        Map<String, Object> kakao_account = (Map<String, Object>) response.get("kakao_account");
        Map<String, Object> profile = (Map<String, Object>) kakao_account.get("profile");

        String nickname = (String) profile.get("nickname");
        String profile_img = (String) profile.get("profile_image_url");
        String email = (String) kakao_account.get("email");

        Optional<User> user = userRepository.findByEmail(email);

        if (user.isEmpty()) {
            userRepository.save(User.builder()
                    .email(email)
                    .nickname(nickname)
                    .profileImg(profile_img)
                    .provider(Provider.KAKAO)
                    .build());
        }

        return TokenResponse.builder()
                .accessToken(jwtTokenProvider.createAccessToken(email))
                .refreshToken(jwtTokenProvider.createRefreshToken(email))
                .build();
    }
}
