package org.zerock.guestbook.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.guestbook.shop.service.MemberService;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
@TestPropertySource(locations = "classpath:application-test.yml")
class MemberControllerTest {

    @Autowired
    private MemberService memberService;
    @Autowired
    private MockMvc mockMvc;

//    public Mem createMember(String email, String password) {
//        MemberFormDto memberFormDto = new MemberFormDto();
//        memberFormDto.setEmail(email);
//        memberFormDto.setName("홍길동");
//        memberFormDto.setAddress("서울시 마포구 합정동");
//        memberFormDto.setPassword(password);
//        Mem member = Mem.createMember(memberFormDto, passwordEncoder);
//        return memberService.saveMember(member);
//    }

//    @Test
//    @DisplayName("로그인 성공 테스트")
//    public void loginSuccessTest() throws Exception {
//        String email = "test@email.com";
//        String password = "1234";
//        this.createMember(email, password);
//        mockMvc.perform(formLogin().userParameter("email")
//                        .loginProcessingUrl("/members/login")
//                        .user(email).password(password))
//                .andExpect(SecurityMockMvcResultMatchers.authenticated());
//    }

//    @Test
//    @DisplayName("로그인 실패 테스트")
//    public void loginFailTest() throws Exception {
//        String email = "test@email.com";
//        String password = "1234";
//        this.createMember(email, password);
//        mockMvc.perform(formLogin().userParameter("email")
//                        .loginProcessingUrl("/members/login")
//                        .user(email).password("12345"))
//                .andExpect(SecurityMockMvcResultMatchers.unauthenticated());
//    }

}