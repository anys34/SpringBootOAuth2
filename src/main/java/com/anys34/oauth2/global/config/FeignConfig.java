package com.anys34.oauth2.global.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = "com.anys34.oauth2.global.feign")
public class FeignConfig {
}
