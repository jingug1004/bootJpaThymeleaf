package org.zerock.guestbook.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zerock.guestbook.dto.GuestbookDTO;
import org.zerock.guestbook.dto.PageRequestDTO;
import org.zerock.guestbook.dto.PageResultDTO;
import org.zerock.guestbook.entity.Guestbook;

@SpringBootTest
public class GuestbookServiceTests {

    @Autowired
    private GuestbookService service;

    @Test
    public void testRegister() {

        GuestbookDTO guestbookDTO = GuestbookDTO.builder()
                .title("Sample Title...")
                .content("Sample Content...")
                .writer("user0")
                .build();

        System.out.println(service.register(guestbookDTO));
    }

    //
//    @Test
//    public void testList() {
//
//        PageRequestDTO pageRequestDTO = PageRequestDTO.builder().page(1).size(10).build();
//
//        PageResultDTO<GuestbookDTO, Guestbook> resultDTO = service.getList(pageRequestDTO);
//
//        for (GuestbookDTO guestbookDTO : resultDTO.getDtoList()) {
//            System.out.println("l~ l~ guestbookDTO : " + guestbookDTO);
//        }
//    }
//
//
    @Test
    public void testList() {

        PageRequestDTO pageRequestDTO = PageRequestDTO.builder().page(20).size(10).build();

        PageResultDTO<GuestbookDTO, Guestbook> resultDTO = service.getList(pageRequestDTO);

        System.out.println("l~ l~ PREV: " + resultDTO.isPrev());
        System.out.println("l~ l~ NEXT: " + resultDTO.isNext());
        System.out.println("l~ l~ TOTAL: " + resultDTO.getTotalPage());

        System.out.println("l~ l~ -------------------------------------");
        for (GuestbookDTO guestbookDTO : resultDTO.getDtoList()) {
            System.out.println("l~ l~ guestbookDTO : " + guestbookDTO);
        }

        System.out.println("l~ l~ ========================================");
        resultDTO.getPageList().forEach(i -> System.out.println("l~ l~ i : " + i));
    }

    @Test
    public void testSearch() {

        PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
                .page(1)
                .size(10)
                .type("tc")   //검색 조건 t, c, w, tc, tcw ..
                .keyword("1")  // 검색 키워드
                .build();

        PageResultDTO<GuestbookDTO, Guestbook> resultDTO = service.getList(pageRequestDTO);

        System.out.println("l~ PREV: " + resultDTO.isPrev());
        System.out.println("l~ NEXT: " + resultDTO.isNext());
        System.out.println("l~ TOTAL: " + resultDTO.getTotalPage());

        System.out.println("l~ -------------------------------------");
        for (GuestbookDTO guestbookDTO : resultDTO.getDtoList()) {
            System.out.println(guestbookDTO);
        }

        System.out.println("l~ ========================================");
        resultDTO.getPageList().forEach(i -> System.out.println(i));
    }


}