package org.zerock.guestbook.blog.dto;

import lombok.*;
import org.zerock.guestbook.blog.domain.BlogArticle;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class BlogAddArticleRequest {

    private String blogTitle;
    private String blogContent;

    public BlogArticle toEntity() {
        return BlogArticle.builder()
                .blogTitle(blogTitle)
                .blogContent(blogContent)
                .build();
    }

}