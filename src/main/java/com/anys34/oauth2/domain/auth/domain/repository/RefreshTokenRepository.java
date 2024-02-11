package com.anys34.oauth2.domain.auth.domain.repository;

import com.anys34.oauth2.domain.auth.domain.RefreshToken;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RefreshTokenRepository extends CrudRepository<RefreshToken, String> {
}