package org.zerock.guestbook.shop.dto;

import lombok.Getter;
import lombok.Setter;
import org.zerock.guestbook.shop.constant.ItemSellStatus;

@Getter
@Setter
public class ItemSearchDto {

    private String searchDateType;

    private ItemSellStatus searchSellStatus;

    private String searchBy;

    private String searchQuery = "";

}