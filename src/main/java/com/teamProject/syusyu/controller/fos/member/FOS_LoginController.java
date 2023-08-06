package com.teamProject.syusyu.controller.fos.member;

import com.teamProject.syusyu.common.ViewPath;
import com.teamProject.syusyu.domain.member.MemberDTO;
import com.teamProject.syusyu.service.fos.member.FOS_MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(ViewPath.FOS)
public class FOS_LoginController {
    private final FOS_MemberService memberService;

    public FOS_LoginController(FOS_MemberService memberService) {
        this.memberService = memberService;
    }

    /**
     * 로그인 페이지를 보여준다.
     *
     * @param request HttpServletRequest 객체
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
     * 로그아웃 요청을 처리한다.
     *
     * @param session HttpSession 객체
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
     *
     * @param memberDTO 로그인 정보가 담긴 MemberDTO 객체
     * @param request HttpServletRequest 객체
     * @return 이전 페이지 URL과 HTTP 상태 코드
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

            if (checkedMember == null)
                throw new Exception("잘못된 아이디 또는 비밀번호");

        } catch (Exception e) {
            // 로그인 확인 중 예외 발생
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
        }

        // 로그인 성공 시 세션에 ID 저장
        HttpSession session = request.getSession();
        session.setAttribute("mbrId", checkedMember.getMbrId());
        session.setAttribute("memberDTO", checkedMember);

        // 사용자의 권한에 따른 리다이렉트 URL 설정
        String redirectUrl = determineRedirectUrlBasedOnRole(checkedMember.getRole(), session);

        // 클라이언트에게 성공 메시지와 리다이렉트 URL 전달
        return new ResponseEntity<>(redirectUrl, HttpStatus.OK);
    }

    /**
     * 권한에 따라 리다이렉트 URL을 결정한다.
     * 관리자의 경우 관리자 대시보드로 이동하고,
     * 그 외의 권한은 이전에 보고있던 페이지로 리다이렉트한다.
     *
     * @param role 권한 코드
     * @param session 현재의 HttpSession 객체
     * @return 리다이렉트할 URL
     * @author min
     * @since 2023/08/03
     */
    private String determineRedirectUrlBasedOnRole(String role, HttpSession session) {
        final String ADMIN_ROLE_CODE = "10";
        final String ADMIN_DASHBOARD_URL = "/admin/dashboard";

        if (ADMIN_ROLE_CODE.equals(role)) {
            return ADMIN_DASHBOARD_URL;
        } else {
            // 이전 페이지 URL을 세션에서 가져옴
            String prevPage = (String) session.getAttribute("prevPage");
            System.out.println("prevPage = " + prevPage);
            if (prevPage.contains("/fos/register")) {
                prevPage = "/";
            }

            System.out.println("prevPage = " + prevPage);

            return prevPage;
        }
    }
}