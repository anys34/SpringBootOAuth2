package com.anys34.oauth2.global.security.jwt.exception;

import com.anys34.oauth2.global.config.error.exception.BusinessException;
import com.anys34.oauth2.global.config.error.exception.ErrorCode;

public class InvalidJwtException extends BusinessException {

    public static final BusinessException EXCEPTION =
            new InvalidJwtException();

    private InvalidJwtException() {
        super(ErrorCode.INVALID_JWT);
    }
}