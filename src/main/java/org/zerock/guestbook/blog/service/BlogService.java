package org.zerock.guestbook.blog.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.zerock.guestbook.blog.domain.BlogArticleEntity;
import org.zerock.guestbook.blog.dto.BlogAddArticleRequest;
import org.zerock.guestbook.blog.dto.BlogUpdateArticleRequest;
import org.zerock.guestbook.blog.repository.BlogRepository;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
public class BlogService {

    private final BlogRepository blogRepository;

    public BlogArticleEntity blogSave(BlogAddArticleRequest request) {
        return blogRepository.save(request.toEntity());
    }

    public List<BlogArticleEntity> findAll() {
        return blogRepository.findAll();
    }

    public BlogArticleEntity findById(long id) {
        return blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("l~ not found: " + id));
    }

    public void delete(long id) {
        blogRepository.deleteById(id);
    }

    @Transactional
    public BlogArticleEntity update(long id, BlogUpdateArticleRequest request) {
        BlogArticleEntity article = blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("l~ not found: " + id));

        article.update(request.getBlogTitle(), request.getBlogContent());

        return article;
    }

}