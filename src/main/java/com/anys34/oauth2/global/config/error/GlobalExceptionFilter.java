package com.anys34.oauth2.global.config.error;

import com.anys34.oauth2.global.config.error.exception.BusinessException;
import com.anys34.oauth2.global.config.error.exception.ErrorCode;
import jakarta.servlet.FilterChain;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.MediaType;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class GlobalExceptionFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws IOException {
        try {
            filterChain.doFilter(request, response);
        } catch (BusinessException e) {
            writerErrorCode(response, e.getErrorCode());
        } catch (Exception e) {
            e.printStackTrace();
            writerErrorCode(response, ErrorCode.INTERNAL_SERVER_ERROR);
        }
    }

    private void writerErrorCode(HttpServletResponse response, ErrorCode errorCode) throws IOException {
        ErrorResponse errorResponse =
                new ErrorResponse(errorCode.getStatus(), errorCode.getMessage());

        response.setStatus(errorCode.getStatus());
        response.setCharacterEncoding("UTF-8");
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.getWriter().write(errorResponse.toString());
    }
}