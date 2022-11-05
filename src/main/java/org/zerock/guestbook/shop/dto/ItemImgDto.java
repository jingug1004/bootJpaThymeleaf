package org.zerock.guestbook.shop.dto;

import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.zerock.guestbook.shop.entity.ItemImg;

@Getter
@Setter
public class ItemImgDto {

    private static ModelMapper modelMapper = new ModelMapper();
    private Long id;
    private String imgName;
    private String oriImgName;
    private String imgUrl;
    private String repImgYn;

    public static ItemImgDto of(ItemImg itemImg) {
        return modelMapper.map(itemImg, ItemImgDto.class);
    }

}