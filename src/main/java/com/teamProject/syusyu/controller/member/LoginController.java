package com.teamProject.syusyu.controller.member;

import com.teamProject.syusyu.domain.member.MemberDto;
import com.teamProject.syusyu.service.member.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    MemberService memberService;

    private final String viewPath = "fos/member/";

    @GetMapping("/login")
    public String loginForm() {
        return viewPath + "loginForm";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        // 1. 세션을 종료
        session.invalidate();
        // 2. 홈으로 이동
        return "redirect:/";
    }

    @PostMapping("/login")
    @ResponseBody
    public String login(@RequestBody MemberDto memberDto, HttpServletRequest request) {
        // 1. id와 pwd를 확인한다.
        if (!loginCheck(memberDto)) {
            // 1-1. 일치하지 않으면
            return "fail";
        }

        // 2. id와 pwd가 일치하면
        // 2-1. 세션 객체에 id를 저장한다.
        HttpSession session = request.getSession();
        session.setAttribute("id", memberDto.getLginId());

        // 2-1. 홈으로 이동한다.
        return "success";
    }

    private boolean loginCheck(MemberDto memberDto) {
        int cnt = 0;
        try {
            // 만약 반환값이 1이 아니면 false, 1이면 true 반환
            cnt = memberService.loginCheck(memberDto);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        System.out.println("cnt = " + cnt);
        return cnt == 1;
    }
}