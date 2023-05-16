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
public class BlogArticleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column
    private String blogTitle;

    @Column
    private String blogContent;

    public void update(String blogTitle, String blogContent) {
        this.blogTitle = blogTitle;
        this.blogContent = blogContent;
    }
}