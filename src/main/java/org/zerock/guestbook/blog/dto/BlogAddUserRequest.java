package org.zerock.guestbook.blog.dto;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class BlogAddUserRequest {
    private String email;
    private String password;
    private String auth;

}