package org.zerock.guestbook.shop.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.zerock.guestbook.shop.entity.Item;
import org.zerock.guestbook.shop.entity.Mem;

public interface MemRepository extends JpaRepository<Mem, Long>, QuerydslPredicateExecutor<Item> {

    Mem findByEmail(String email);


}
