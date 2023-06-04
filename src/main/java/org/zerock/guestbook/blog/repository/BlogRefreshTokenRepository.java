package org.zerock.guestbook.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zerock.guestbook.blog.domain.BlogRefreshToken;

import java.util.Optional;

public interface BlogRefreshTokenRepository extends JpaRepository<BlogRefreshToken, Long> {
    Optional<BlogRefreshToken> findByUserId(Long userId);

    Optional<BlogRefreshToken> findByRefreshToken(String refreshToken);
}

