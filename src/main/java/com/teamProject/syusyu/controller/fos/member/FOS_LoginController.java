package com.teamProject.syusyu.controller.fos.member;

import com.teamProject.syusyu.common.ViewPath;
import com.teamProject.syusyu.domain.member.MemberDTO;
import com.teamProject.syusyu.service.fos.member.FOS_MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(ViewPath.FOS)
public class FOS_LoginController {
    @Autowired
    FOS_MemberService memberService;

    /**
     * 로그인 페이지를 보여주는 메서드입니다.
     * 이 메서드는 이전 페이지의 URL을 세션에 저장한 후 로그인 폼을 반환합니다.
     * 이전 페이지의 URL은 'Referer' 헤더를 통해 얻어옵니다.
     *
     * @param request 클라이언트의 요청 정보를 담고 있는 HttpServletRequest 객체
     * @return 로그인 폼의 경로
     * @author min
     * @since 2023/06/26
     * @modifier soso
     * @modified 2023/07/25
     */
    @GetMapping("/login")
    public String loginForm(HttpServletRequest request) {
        // 이전 페이지 URL 저장
        HttpSession session = request.getSession();
        String referer = request.getHeader("Referer");
        if (referer != null) {
            session.setAttribute("prevPage", referer);
        }

        return ViewPath.FOS_MEMBER + "loginForm";
    }

    /**
     * 사용자의 로그아웃 요청을 처리하는 메서드입니다.
     * 세션을 종료시킨 후, 홈페이지로 리다이렉트합니다.
     *
     * @param session 사용자의 세션 정보를 담고 있는 HttpSession 객체
     * @return 홈페이지로의 리다이렉트 경로
     * @author min
     * @since 2023/06/26
     */
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        // 1. 세션을 종료
        session.invalidate();
        // 2. 홈으로 이동
        return "redirect:/";
    }

    /**
     * 로그인 요청을 처리하는 메서드입니다.
     * 전달받은 MemberDTO를 이용하여 사용자의 아이디와 비밀번호를 확인합니다.
     * 아이디와 비밀번호가 일치하면 세션에 아이디를 저장하고, 이전 페이지 URL을 클라이언트에게 보냅니다.
     * 아이디와 비밀번호가 일치하지 않으면 오류 메시지와 HTTP 상태 코드 401을 반환합니다.
     *
     * @param memberDTO 로그인 정보가 담긴 MemberDTO 객체
     * @param request 클라이언트의 요청 정보를 담고 있는 HttpServletRequest 객체
     * @return 이전 페이지 URL과 HTTP 상태 코드
     * @throws Exception 로그인 검증 도중 발생할 수 있는 예외를 처리합니다.
     * @author min
     * @since 2023/06/26
     * @modifier soso
     * @modified 2023/07/25
     */
    @PostMapping("/login")
    @ResponseBody
    public ResponseEntity<String> login(@RequestBody MemberDTO memberDTO, HttpServletRequest request) {
        MemberDTO checkedMember;
        try {
            // 1. id와 pwd를 확인한다.
            checkedMember = memberService.loginCheck(memberDTO);
            if (checkedMember == null) {
                throw new Exception("잘못된 아이디 또는 비밀번호");
            }
        } catch (Exception e) {
            // 로그인 확인 중 예외 발생
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
        }

        //2. id와 pwd가 일치하면 세션에 id를 저장한다.
        HttpSession session = request.getSession();
        session.setAttribute("mbrId", checkedMember.getMbrId());

        //3. 이전 페이지 URL 가져오기
        String prevPage = (String) session.getAttribute("prevPage");

        //4. 클라이언트에게 성공 메시지와 이전 페이지 URL을 보낸다.
        return new ResponseEntity<>(prevPage, HttpStatus.OK);
    }
}