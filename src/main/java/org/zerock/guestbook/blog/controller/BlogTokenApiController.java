package org.zerock.guestbook.blog.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.guestbook.blog.dto.BlogCreateAccessTokenRequest;
import org.zerock.guestbook.blog.dto.BlogCreateAccessTokenResponse;
import org.zerock.guestbook.blog.service.BlogTokenService;

@RequiredArgsConstructor
@RestController
public class BlogTokenApiController {

    private final BlogTokenService tokenService;

    @PostMapping("/api/token")
    public ResponseEntity<BlogCreateAccessTokenResponse> createNewAccessToken(@RequestBody BlogCreateAccessTokenRequest request) {
        String newAccessToken = tokenService.createNewAccessToken(request.getRefreshToken());

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new BlogCreateAccessTokenResponse(newAccessToken));
    }
}
