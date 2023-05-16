package org.zerock.guestbook.blog.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.zerock.guestbook.blog.domain.BlogArticleEntity;
import org.zerock.guestbook.blog.dto.BlogAddArticleRequest;
import org.zerock.guestbook.blog.dto.BlogArticleResponse;
import org.zerock.guestbook.blog.dto.BlogUpdateArticleRequest;
import org.zerock.guestbook.blog.service.BlogService;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
public class BlogApiController {

    private final BlogService blogService;

    @PostMapping("/api/articles")
    public ResponseEntity<BlogArticleEntity> blogAddArticle(@RequestBody BlogAddArticleRequest request) {
        BlogArticleEntity blogSavedArticle = blogService.blogSave(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(blogSavedArticle);
    }

    @GetMapping("/api/articles")
    public ResponseEntity<List<BlogArticleResponse>> findAllArticles() {
        List<BlogArticleResponse> articleResponses = blogService.findAll()
                .stream()
                .map(BlogArticleResponse::new)
                .collect(Collectors.toList());

        return ResponseEntity.ok()
                .body(articleResponses);
    }

    @GetMapping("/api/articles/{id}")
    public ResponseEntity<BlogArticleResponse> findAllArticle(@PathVariable long id) {
        BlogArticleEntity article = blogService.findById(id);

        return ResponseEntity.ok()
                .body(new BlogArticleResponse(article));
    }

    @DeleteMapping("/api/articles/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable long id) {
        blogService.delete(id);

        return ResponseEntity.ok()
                .build();
    }

    @PutMapping("/api/articles/{id}")
    public ResponseEntity<BlogArticleEntity> updateArticle(@PathVariable long id, @RequestBody BlogUpdateArticleRequest request) {

        BlogArticleEntity updatedArticle = blogService.update(id, request);

        return ResponseEntity.ok()
                .body(updatedArticle);
    }
}