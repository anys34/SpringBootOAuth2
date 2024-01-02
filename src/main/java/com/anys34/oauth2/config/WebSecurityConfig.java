//package com.anys34.oauth2.config;
//
//import com.anys34.oauth2.config.jwt.TokenProvider;
//import com.anys34.oauth2.config.oauth.OAuth2UserCustomService;
//import com.anys34.oauth2.repository.RefreshTokenRepository;
//import com.anys34.oauth2.service.UserDetailService;
//import com.anys34.oauth2.service.UserService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpStatus;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.HttpStatusEntryPoint;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//
//import static org.springframework.boot.autoconfigure.security.servlet.PathRequest.toH2Console;
//
//@RequiredArgsConstructor
//@Configuration
//public class WebSecurityConfig {
//    private final UserDetailService userService;
//
//    @Bean
//    public WebSecurityCustomizer configure() {
//        return (web) -> web.ignoring()
//                .requestMatchers(toH2Console())
//                .requestMatchers("/static/**");
//    }
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        return http
//                .authorizeRequests()
//                    .requestMatchers("/login", "/signup", "/user").permitAll()
//                    .anyRequest().authenticated()
//                .and()
//                .formLogin()
//                    .loginPage("/login")
//                    .defaultSuccessUrl("/articles")
//                .and()
//                .logout()
//                    .logoutSuccessUrl("/login")
//                    .invalidateHttpSession(true)
//                .and()
//                .csrf().disable()
//                .build();
//    }
//
//    @Bean
//    public AuthenticationManager authenticationManager(HttpSecurity http, BCryptPasswordEncoder bCryptPasswordEncoder, UserDetailService userDetailService) throws Exception {
//        return http.getSharedObject(AuthenticationManagerBuilder.class)
//                .userDetailsService(userService)
//                .passwordEncoder(bCryptPasswordEncoder)
//                .and()
//                .build();
//    }
//
//    @Bean
//    public BCryptPasswordEncoder bCryptPasswordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//}
