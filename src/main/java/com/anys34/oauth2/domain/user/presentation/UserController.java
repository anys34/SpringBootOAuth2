package com.anys34.oauth2.domain.user.presentation;

import com.anys34.oauth2.domain.user.domain.User;
import com.anys34.oauth2.domain.user.presentation.dto.res.UserInfoResponse;
import com.anys34.oauth2.domain.user.service.LoginUserInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/user")
@RestController
public class UserController {
    private final LoginUserInfoService loginUserInfoService;

    @GetMapping
    public UserInfoResponse profile() {
        return loginUserInfoService.execute();
    }
}
