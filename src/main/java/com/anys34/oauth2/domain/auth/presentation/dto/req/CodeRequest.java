package com.anys34.oauth2.domain.auth.presentation.dto.req;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CodeRequest {
    @NotNull(message = "code가 비었습니다.")
    private String code;
}
