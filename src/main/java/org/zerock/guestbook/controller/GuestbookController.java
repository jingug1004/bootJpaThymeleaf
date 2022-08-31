package org.zerock.guestbook.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by A on 2022-08-31 오전 10:09
 * guestbook / org.zerock.guestbook.controller
 * No pain, No gain!
 * What :
 * Why :
 * How :
 * << 개정이력(Modification Information) >>
 * 수정일         수정자          수정내용
 * -------       --------       ---------------------------
 * 2018/04/01     김진국          최초 생성
 * 2017/05/27     이몽룡          인증이 필요없는 URL을 패스하는 로직 추가
 *
 * @author 개발팀 김진국
 * @version 1.0
 * @see
 * @since 2018/04/01
 */

@Controller
@RequestMapping("/guestbook")
@Log4j2
public class GuestbookController {

    @GetMapping({"/", "/list"})
    public String list() {
        log.info("l~ list................");

        return "/guestbook/list";
    }


}