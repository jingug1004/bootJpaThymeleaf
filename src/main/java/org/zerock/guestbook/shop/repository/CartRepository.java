package org.zerock.guestbook.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zerock.guestbook.shop.entity.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {

    Cart findByMemberId(Long memberId);

}