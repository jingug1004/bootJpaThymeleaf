package org.zerock.guestbook.shop.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;
import org.zerock.guestbook.shop.entity.Item;
import org.zerock.guestbook.shop.entity.Mem;

@Repository
public interface MemberRepository extends JpaRepository<Mem, Long>, QuerydslPredicateExecutor<Item> {

    Mem findByEmail(String email);

}
