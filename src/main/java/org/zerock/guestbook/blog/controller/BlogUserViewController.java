package org.zerock.guestbook.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BlogUserViewController {
    @GetMapping("/login")
    public String login() {
        return "blog/login";
    }

    @GetMapping("/signup")
    public String signup() {
        return "blog/signup";
    }
}