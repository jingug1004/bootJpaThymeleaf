package org.zerock.guestbook.blog.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BlogCreateAccessTokenRequest {
    private String refreshToken;
}
