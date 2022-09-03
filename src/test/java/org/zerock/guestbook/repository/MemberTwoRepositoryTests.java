package org.zerock.guestbook.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.zerock.guestbook.entity.MemberTwo;

import javax.transaction.Transactional;
import java.util.stream.IntStream;

@SpringBootTest
public class MemberTwoRepositoryTests {

    @Autowired
    private MemberTwoRepository memberTwoRepository;

    @Autowired
    private ReviewRepository reviewRepository;


    @Test
    public void insertMembers() {

        IntStream.rangeClosed(1, 100).forEach(i -> {
            MemberTwo memberTwo = MemberTwo.builder()
                    .email("r" + i + "@zerock.org")
                    .pw("1111")
                    .nickname("reviewer" + i).build();
            memberTwoRepository.save(memberTwo);
        });
    }

    @Commit
    @Transactional
    @Test
    public void testDeleteMember() {

        Long mid = 1L; //Member의 mid

        MemberTwo memberTwo = MemberTwo.builder().mid(mid).build();

        //기존
        //memberTwoRepository.deleteById(mid);
        //reviewRepository.deleteByMember(memberTwo);

        //순서 주의
        reviewRepository.deleteByMember(memberTwo);
        memberTwoRepository.deleteById(mid);
    }
}
