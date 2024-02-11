package com.anys34.oauth2.domain.user.domain;

import com.anys34.oauth2.domain.user.domain.type.Provider;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "users")
@Entity
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String email;

    private String nickname;

    @Column(name = "profile_image")
    private String profileImg;

    private Provider provider;

    @Builder
    public User(String email, String nickname, String profileImg, Provider provider) {
        this.email = email;
        this.nickname = nickname;
        this.profileImg = profileImg;
        this.provider = provider;
    }
}
