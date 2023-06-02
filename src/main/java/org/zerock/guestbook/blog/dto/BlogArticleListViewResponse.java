package org.zerock.guestbook.blog.dto;

import lombok.*;
import org.zerock.guestbook.blog.domain.BlogArticleEntity;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class BlogArticleListViewResponse {

    private Long id;
    private String blogTitle;
    private String blogContent;


    public BlogArticleListViewResponse(BlogArticleEntity blogArticleEntity) {
        this.id = blogArticleEntity.getId();
        this.blogTitle = blogArticleEntity.getBlogTitle();
        this.blogContent = blogArticleEntity.getBlogContent();
    }
}