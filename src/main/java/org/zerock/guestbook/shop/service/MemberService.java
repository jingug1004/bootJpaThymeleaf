package org.zerock.guestbook.shop.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.guestbook.shop.entity.Mem;
import org.zerock.guestbook.shop.repository.MemRepository;

@Service
@Transactional
@RequiredArgsConstructor
//public class MemberService implements UserDetailsService {
public class MemberService {

    private final MemRepository memberRepository;

    public Mem saveMember(Mem member) {
        validateDuplicateMember(member);
        return memberRepository.save(member);
    }

    private void validateDuplicateMember(Mem member) {
        Mem findMember = memberRepository.findByEmail(member.getEmail());
        if (findMember != null) {
            throw new IllegalStateException("이미 가입된 회원입니다.");
        }
    }

//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//
//        Mem member = memberRepository.findByEmail(email);
//
//        if (member == null) {
//            throw new UsernameNotFoundException(email);
//        }
//
//        return User.builder()
//                .username(member.getEmail())
//                .password(member.getPassword())
//                .roles(member.getRole().toString())
//                .build();
//    }

}