package org.zerock.guestbook.blog.dto;

import lombok.*;
import org.zerock.guestbook.blog.domain.BlogArticleEntity;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class BlogArticleResponse {

    private String blogTitle;
    private String blogContent;


    public BlogArticleResponse(BlogArticleEntity blogArticleEntity) {
        this.blogTitle = blogArticleEntity.getBlogTitle();
        this.blogContent = blogArticleEntity.getBlogContent();
    }
}