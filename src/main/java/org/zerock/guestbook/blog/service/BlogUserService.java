package org.zerock.guestbook.blog.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.zerock.guestbook.blog.domain.BlogUsersEntity;
import org.zerock.guestbook.blog.dto.BlogAddUserRequest;
import org.zerock.guestbook.blog.repository.BlogUserRepository;

@RequiredArgsConstructor
@Service
public class BlogUserService {
    private final BlogUserRepository userRepository;
//    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public Long save(BlogAddUserRequest dto) {
        return userRepository.save(BlogUsersEntity.builder()
                .email(dto.getEmail())
//                .auth(dto.getAuth())
//                .password(bCryptPasswordEncoder.encode(dto.getPassword()))
                .password(dto.getPassword())
                .build()).getId();
    }

    public BlogUsersEntity findById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("Unexpected user"));
    }
}