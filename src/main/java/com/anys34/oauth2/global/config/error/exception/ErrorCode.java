package com.anys34.oauth2.global.config.error.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "User Not Found"),
    UNEXPECTED_TOKEN(HttpStatus.BAD_REQUEST, "Unexpected token"),
    EXPIRED_JWT(HttpStatus.UNAUTHORIZED, "Expired Jwt");

    private final HttpStatus status;
    private final String message;
}
