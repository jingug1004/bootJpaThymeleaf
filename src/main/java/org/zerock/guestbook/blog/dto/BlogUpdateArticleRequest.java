package org.zerock.guestbook.blog.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class BlogUpdateArticleRequest {

    private String blogTitle;
    private String blogContent;


}