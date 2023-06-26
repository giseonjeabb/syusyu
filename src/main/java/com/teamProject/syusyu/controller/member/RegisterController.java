package com.teamProject.syusyu.controller.member;

import com.teamProject.syusyu.service.member.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class RegisterController {
    @Autowired
    MemberService memberService;

    @GetMapping("/register")
    public String registerForm() {
        return "/member/registerForm";
    }

    /*
    * 회원가입
    * 메서드명 : register
    * 매개변수 :
    * 반환타입 :
    * */
}
