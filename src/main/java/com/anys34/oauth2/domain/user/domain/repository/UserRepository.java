package com.anys34.oauth2.domain.user.domain.repository;

import com.anys34.oauth2.domain.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
