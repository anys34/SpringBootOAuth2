package com.anys34.oauth2.global.config.error.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    USER_NOT_MATCH(HttpStatus.BAD_REQUEST, "User Not Match"),
    UNEXPECTED_TOKEN(HttpStatus.BAD_REQUEST, "Unexpected token"),
    EXPIRED_JWT(HttpStatus.UNAUTHORIZED, "Expired Jwt"),
    INVALID_JWT(HttpStatus.UNAUTHORIZED, "Invalid Jwt"),
    INVALID_REFRESH_TOKEN(HttpStatus.UNAUTHORIZED, "Invalid Refresh Token"),

    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "User Not Found"),
    POST_NOT_FOUND(HttpStatus.NOT_FOUND, "Post Not Found"),
    REFRESH_TOKEN_NOT_FOUND(HttpStatus.NOT_FOUND, "Refresh Token Not Found"),
    CONTENT_TYPE_NOT_FOUND(HttpStatus.NOT_FOUND, "Content Type Not Found"),

    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error");

    private final HttpStatus status;
    private final String message;
}
