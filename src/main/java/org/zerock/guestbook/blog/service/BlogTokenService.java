package org.zerock.guestbook.blog.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.zerock.guestbook.blog.config.jwt.BlogTokenProvider;
import org.zerock.guestbook.blog.domain.BlogUsersEntity;

import java.time.Duration;

@RequiredArgsConstructor
@Service
public class BlogTokenService {

    private final BlogTokenProvider tokenProvider;
    private final BlogRefreshTokenService refreshTokenService;
    private final BlogUserService userService;

    public String createNewAccessToken(String refreshToken) {
        // 토큰 유효성 검사에 실패하면 예외 발생
        if (!tokenProvider.validToken(refreshToken)) {
            throw new IllegalArgumentException("Unexpected token");
        }

        Long userId = refreshTokenService.findByRefreshToken(refreshToken).getUserId();
        BlogUsersEntity user = userService.findById(userId);

        return tokenProvider.generateToken(user, Duration.ofHours(2));
    }
}

