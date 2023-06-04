package org.zerock.guestbook.blog.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.zerock.guestbook.blog.dto.BlogAddUserRequest;
import org.zerock.guestbook.blog.service.BlogUserService;

@RequiredArgsConstructor
@Controller
public class BlogUserApiController {

    private final BlogUserService userService;

    @PostMapping("/user")
    public String signup(BlogAddUserRequest request) {
        userService.save(request);
        return "redirect:/login";
    }

//    @GetMapping("/logout")
//    public String logout(HttpServletRequest request, HttpServletResponse response) {
//        new SecurityContextLogoutHandler().logout(request, response, SecurityContextHolder.getContext().getAuthentication());
//        return "redirect:/login";
//    }

}