package com.teamProject.syusyu.controller;

import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.teamProject.syusyu.dao.*;
import com.teamProject.syusyu.dao.member.MemberDao;
import com.teamProject.syusyu.domain.*;
import com.teamProject.syusyu.domain.member.MemberDto;
import com.teamProject.syusyu.service.MemberService;
import org.aspectj.apache.bcel.classfile.ConstantNameAndType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    MemberService memberService;

    @GetMapping("/login")
    public String loginForm() {
        return "loginForm";
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
        session.setAttribute("id", memberDto.getMemberId());

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

    @PostMapping("/login_bak")
    public String login_bak(String id, String pwd, String toURL, boolean rememberId,
                            HttpServletRequest request, HttpServletResponse response) throws Exception {

        System.out.println("id = " + id);
        System.out.println("pwd = " + pwd);

        // 1. id와 pwd를 확인
//        if (!login_bak(id, pwd)) {
//            // 2-1   일치하지 않으면, loginForm으로 이동
//            String msg = URLEncoder.encode("id 또는 pwd가 일치하지 않습니다.", "utf-8");
//
//            return "redirect:/login/login?msg=" + msg;
//        }
        // 2-2. id와 pwd가 일치하면,
        //  세션 객체를 얻어오기
        HttpSession session = request.getSession();
        //  세션 객체에 id를 저장
        session.setAttribute("id", id);

        if (rememberId) {
            //     1. 쿠키를 생성
            Cookie cookie = new Cookie("id", id); // ctrl+shift+o 자동 import
//		       2. 응답에 저장
            response.addCookie(cookie);
        } else {
            // 1. 쿠키를 삭제
            Cookie cookie = new Cookie("id", id); // ctrl+shift+o 자동 import
            cookie.setMaxAge(0); // 쿠키를 삭제
//		       2. 응답에 저장
            response.addCookie(cookie);
        }
//		       3. 홈으로 이동
        toURL = toURL == null || toURL.equals("") ? "/" : toURL;

        return "redirect:" + toURL;
    }


}