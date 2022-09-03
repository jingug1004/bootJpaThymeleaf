package org.zerock.guestbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zerock.guestbook.entity.MemberTwo;

public interface MemberTwoRepository extends JpaRepository<MemberTwo, Long> {

}
