//package org.zerock.guestbook.shop.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//import org.zerock.guestbook.shop.dto.ResponseDTO;
//import org.zerock.guestbook.shop.service.UserService;
//
//@RestController
//@RequestMapping(value = "/api/v1/app/")
//public class UserController {
//
//    @Autowired
//    UserService userService;
//
//    @RequestMapping(value = "findAll2", method = RequestMethod.POST)
//    public ResponseEntity<?> findAll2() {
//        ResponseDTO responseDTO = new ResponseDTO();
//        responseDTO.setResultCode("S0001");
//        responseDTO.setRes(userService.findAll2());
//        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
//    }
//}