package com.anys34.oauth2.domain.auth.service.google;

import com.anys34.oauth2.domain.auth.presentation.dto.res.TokenResponse;
import com.anys34.oauth2.domain.user.domain.User;
import com.anys34.oauth2.domain.user.domain.repository.UserRepository;
import com.anys34.oauth2.domain.user.domain.type.Provider;
import com.anys34.oauth2.domain.user.facade.UserFacade;
import com.anys34.oauth2.global.feign.auth.google.GoogleInformationClient;
import com.anys34.oauth2.global.feign.auth.google.dto.res.GoogleInformationResponse;
import com.anys34.oauth2.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GoogleAuthService {
    private final GoogleInformationClient googleInformationClient;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserRepository userRepository;
    private final UserFacade userFacade;

    @Transactional
    public TokenResponse execute(String accessToken) {
        GoogleInformationResponse response = googleInformationClient
                .getUserInformation(accessToken);
        String email = response.getEmail();

        Optional<User> user = userFacade.findEmail(email);

        if (user.isEmpty()) {
            userRepository.save(User.builder()
                    .email(email)
                    .nickname(response.getName())
                    .profileImg(response.getPicture())
                    .provider(Provider.GOOGLE)
                    .build());
        }

        return TokenResponse.builder()
                .accessToken(jwtTokenProvider.createAccessToken(email))
                .refreshToken(jwtTokenProvider.createRefreshToken(email))
                .build();
    }
}
