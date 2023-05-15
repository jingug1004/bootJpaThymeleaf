package org.zerock.guestbook.shop.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.guestbook.shop.repository.CartRepository;
import org.zerock.guestbook.shop.repository.MemRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@SpringBootTest
@Transactional
@TestPropertySource(locations = "classpath:application-test.yml")
class CartTest {

    @Autowired
    CartRepository cartRepository;

    @Autowired
    MemRepository memberRepository;

//    @Autowired
//    PasswordEncoder passwordEncoder;

    @PersistenceContext
    EntityManager em;

//    public Mem createMember(){
//        MemberFormDto memberFormDto = new MemberFormDto();
//        memberFormDto.setEmail("test@email.com");
//        memberFormDto.setName("홍길동");
//        memberFormDto.setAddress("서울시 마포구 합정동");
//        memberFormDto.setPassword("1234");
//        return Mem.createMember(memberFormDto, passwordEncoder);
//    }

//    @Test
//    @DisplayName("장바구니 회원 엔티티 매핑 조회 테스트")
//    public void findCartAndMemberTest(){
//        Mem member = createMember();
//        memberRepository.save(member);
//        Cart cart = new Cart();
//        cart.setMember(member);
//        cartRepository.save(cart);
//
//        em.flush();
//        em.clear();
//
//        Cart savedCart = cartRepository.findById(cart.getId())
//                .orElseThrow(EntityNotFoundException::new);
//        assertEquals(savedCart.getMember().getId(), member.getId());
//    }

}