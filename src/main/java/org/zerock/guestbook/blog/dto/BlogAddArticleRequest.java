package org.zerock.guestbook.blog.dto;

import lombok.*;
import org.zerock.guestbook.blog.domain.BlogArticleEntity;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class BlogAddArticleRequest {

    private String blogTitle;
    private String blogContent;

    public BlogArticleEntity toEntity() {
        return BlogArticleEntity.builder()
                .blogTitle(blogTitle)
                .blogContent(blogContent)
                .build();
    }

}