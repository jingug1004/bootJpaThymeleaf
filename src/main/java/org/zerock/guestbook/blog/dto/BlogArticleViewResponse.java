package org.zerock.guestbook.blog.dto;

import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class BlogArticleViewResponse {

    private Long id;
    private String blogTitle;
    private String blogContent;
    private LocalDateTime createdAt;

}