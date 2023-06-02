package org.zerock.guestbook.blog.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.zerock.guestbook.blog.domain.BlogArticleEntity;
import org.zerock.guestbook.blog.dto.BlogArticleListViewResponse;
import org.zerock.guestbook.blog.dto.BlogArticleViewResponse;
import org.zerock.guestbook.blog.service.BlogService;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Controller
public class BlogViewController {

    private final BlogService blogService;

    @GetMapping("/articles")
    public String getArticles(Model model) {
        List<BlogArticleListViewResponse> articles = blogService.findAll().stream()
                .map(BlogArticleListViewResponse::new)
                .collect(Collectors.toList());

        model.addAttribute("articles", articles);

        return "blog/articleList";
    }

    @GetMapping("/articles/{id}")
    public String getArticle(@PathVariable Long id, Model model) {
        BlogArticleEntity article = blogService.findById(id);


        model.addAttribute("article", convert(article));

        return "blog/article";
    }

    @GetMapping("/new-article")
    public String newArticle(@RequestParam(required = false) Long id, Model model) {
        if (id == null) {
            model.addAttribute("article", new BlogArticleViewResponse());
        } else {
            BlogArticleEntity article = blogService.findById(id);
            model.addAttribute("article", article);
        }

        return "blog/newArticle";
    }

    private BlogArticleViewResponse convert(BlogArticleEntity entity) {
        return BlogArticleViewResponse.builder()
                .id(entity.getId())
                .blogTitle(entity.getBlogTitle())
                .blogContent(entity.getBlogContent())
                .createdAt(entity.getCreatedAt())
                .build();
    }
}