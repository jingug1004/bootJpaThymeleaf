package org.zerock.guestbook.shop.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.zerock.guestbook.shop.dto.ItemSearchDto;
import org.zerock.guestbook.shop.dto.MainItemDto;
import org.zerock.guestbook.shop.entity.Item;

public interface ItemRepositoryCustom {

    Page<Item> getAdminItemPage(ItemSearchDto itemSearchDto, Pageable pageable);

    Page<MainItemDto> getMainItemPage(ItemSearchDto itemSearchDto, Pageable pageable);

}