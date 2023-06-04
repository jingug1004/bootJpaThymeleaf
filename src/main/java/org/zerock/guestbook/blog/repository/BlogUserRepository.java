package org.zerock.guestbook.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zerock.guestbook.blog.domain.BlogUsersEntity;

import java.util.Optional;

public interface BlogUserRepository extends JpaRepository<BlogUsersEntity, Long> {
    Optional<BlogUsersEntity> findByEmail(String email);
}
