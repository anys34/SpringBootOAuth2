package com.anys34.oauth2.repository;

import com.anys34.oauth2.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Article, Long> {
}

