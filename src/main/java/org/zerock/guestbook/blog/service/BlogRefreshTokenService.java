package org.zerock.guestbook.blog.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.zerock.guestbook.blog.domain.BlogRefreshToken;
import org.zerock.guestbook.blog.repository.BlogRefreshTokenRepository;

@RequiredArgsConstructor
@Service
public class BlogRefreshTokenService {
    private final BlogRefreshTokenRepository refreshTokenRepository;

    public BlogRefreshToken findByRefreshToken(String refreshToken) {
        return refreshTokenRepository.findByRefreshToken(refreshToken)
                .orElseThrow(() -> new IllegalArgumentException("Unexpected token"));
    }
}

