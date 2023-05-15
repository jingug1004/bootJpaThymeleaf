package org.zerock.guestbook.shop.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.guestbook.shop.repository.MemRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@SpringBootTest
@Transactional
@TestPropertySource(locations = "classpath:application-test.yml")
public class MemberTest {

    @Autowired
    MemRepository memberRepository;

    @PersistenceContext
    EntityManager em;

//    @Test
//    @DisplayName("Auditing 테스트")
//    @WithMockUser(username = "gildong", roles = "USER")
//    public void auditingTest() {
//        Mem newMember = new Mem();
//        memberRepository.save(newMember);
//
//        em.flush();
//        em.clear();
//
//        Mem member = memberRepository.findById(newMember.getId())
//                .orElseThrow(EntityNotFoundException::new);
//
//        System.out.println("l~ register time : " + member.getRegTime());
//        System.out.println("l~ update time : " + member.getUpdateTime());
//        System.out.println("l~ create member : " + member.getCreatedBy());
//        System.out.println("l~ modify member : " + member.getModifiedBy());
//    }

}