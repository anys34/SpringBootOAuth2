package com.anys34.oauth2.global.feign.auth.google.dto.res;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GoogleInformationResponse {

    private String email;
    private String name;
    private String picture;
}
