package org.zerock.guestbook.shop.entity;

import lombok.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.zerock.guestbook.shop.constant.Role;
import org.zerock.guestbook.shop.dto.MemberFormDto;

import javax.persistence.*;

@Entity
@Table(name = "mem")
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Mem extends BaseEntity {

    @Id
    @Column(name = "member_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @Column(unique = true)
    private String email;

    private String password;

    private String address;

    @Enumerated(EnumType.STRING)
    private Role role;

    public static Mem createMember(MemberFormDto memberFormDto, PasswordEncoder passwordEncoder) {

        String password = passwordEncoder.encode(memberFormDto.getPassword());

        return Mem.builder()
                .name(memberFormDto.getName())
                .email(memberFormDto.getEmail())
                .address(memberFormDto.getAddress())
                .password(password)
                .role(Role.ADMIN).build();
    }
}
//package org.zerock.guestbook.shop.entity;
//
//import com.shop.constant.Role;
//import com.shop.dto.MemberFormDto;
//import lombok.Getter;
//import lombok.Setter;
//import lombok.ToString;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.zerock.guestbook.entity.BaseEntity;
//
//import javax.persistence.*;
//
//@Entity
//@Table(name="member")
//@Getter @Setter
//@ToString
//public class Member extends BaseEntity {
//
//    @Id
//    @Column(name="member_id")
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;
//
//    private String name;
//
//    @Column(unique = true)
//    private String email;
//
//    private String password;
//
//    private String address;
//
//    @Enumerated(EnumType.STRING)
//    private Role role;
//
//    public static Member createMember(MemberFormDto memberFormDto, PasswordEncoder passwordEncoder){
//        Member member = new Member();
//        member.setName(memberFormDto.getName());
//        member.setEmail(memberFormDto.getEmail());
//        member.setAddress(memberFormDto.getAddress());
//        String password = passwordEncoder.encode(memberFormDto.getPassword());
//        member.setPassword(password);
//        member.setRole(Role.ADMIN);
//        return member;
//    }
//}
