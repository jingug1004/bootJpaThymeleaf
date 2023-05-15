package org.zerock.guestbook.blog.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.guestbook.blog.domain.BlogArticle;
import org.zerock.guestbook.blog.dto.BlogAddArticleRequest;
import org.zerock.guestbook.blog.service.BlogService;

@RequiredArgsConstructor
@RestController
public class BlogApiController {

    private final BlogService blogService;

    @PostMapping("/api/articles")
    public ResponseEntity<BlogArticle> blogAddArticle(@RequestBody BlogAddArticleRequest request) {
        BlogArticle blogSavedArticle = blogService.blogSave(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(blogSavedArticle);
    }


}