package com.anys34.oauth2.domain.auth.exception;

import com.anys34.oauth2.global.config.error.exception.BusinessException;
import com.anys34.oauth2.global.config.error.exception.ErrorCode;

public class UnexpectedTokenException extends BusinessException {
    public static final BusinessException EXCEPTION =
            new UnexpectedTokenException();

    private UnexpectedTokenException() {super(ErrorCode.INVALID_JWT);}
}
