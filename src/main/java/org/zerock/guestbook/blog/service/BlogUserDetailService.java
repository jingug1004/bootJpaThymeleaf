package org.zerock.guestbook.blog.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.zerock.guestbook.blog.repository.BlogUserRepository;


@RequiredArgsConstructor
@Service
public class BlogUserDetailService {
//public class BlogUserDetailService implements UserDetailsService {

    private final BlogUserRepository userRepository;

//    @Override
//    public BlogUsersEntity loadUserByUsername(String email) {
//        return userRepository.findByEmail(email)
//                .orElseThrow(() -> new IllegalArgumentException((email)));
//    }
}
