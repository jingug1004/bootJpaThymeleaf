package org.zerock.guestbook.blog.domain;


import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "blog_article")
@Entity
@Builder
@ToString
public class BlogArticle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column
    private String blogTitle;

    @Column
    private String blogContent;

//    @Builder
//    public BlogArticle(String title, String content) {
//        this.title = title;
//        this.content = content;
//    }

}