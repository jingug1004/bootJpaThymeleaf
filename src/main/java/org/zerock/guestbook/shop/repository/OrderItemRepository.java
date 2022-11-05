package org.zerock.guestbook.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zerock.guestbook.shop.entity.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}