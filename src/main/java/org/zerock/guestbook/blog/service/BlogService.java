package org.zerock.guestbook.blog.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.zerock.guestbook.blog.domain.BlogArticle;
import org.zerock.guestbook.blog.dto.BlogAddArticleRequest;
import org.zerock.guestbook.blog.repository.BlogRepository;

@RequiredArgsConstructor
@Service
public class BlogService {

    private final BlogRepository blogRepository;

    public BlogArticle blogSave(BlogAddArticleRequest request) {
        return blogRepository.save(request.toEntity());
    }

}