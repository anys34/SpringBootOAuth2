package com.anys34.oauth2.domain.user.service;

import com.anys34.oauth2.domain.user.domain.User;
import com.anys34.oauth2.domain.user.facade.UserFacade;
import com.anys34.oauth2.domain.user.presentation.dto.res.UserInfoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class LoginUserInfoService {
    private final UserFacade userFacade;

    @Transactional(readOnly = true)
    public UserInfoResponse execute() {
        User user = userFacade.getCurrentUser();
        return new UserInfoResponse(user);
    }
}
