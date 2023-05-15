package org.zerock.guestbook.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zerock.guestbook.blog.domain.BlogArticle;

public interface BlogRepository extends JpaRepository<BlogArticle, Long> {


}