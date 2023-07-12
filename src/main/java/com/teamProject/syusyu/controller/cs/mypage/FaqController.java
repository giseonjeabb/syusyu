package com.teamProject.syusyu.controller.cs.mypage;

import com.teamProject.syusyu.common.ViewPath;

import com.teamProject.syusyu.domain.cs.FaqDTO;
import com.teamProject.syusyu.domain.cs.FaqSearchCondition;
import com.teamProject.syusyu.domain.cs.PageHandler;
import com.teamProject.syusyu.domain.cs.SearchCondition;
import com.teamProject.syusyu.service.cs.FaqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

import java.util.List;

@Controller
@RequestMapping("/faq")
public class FaqController {

    @Autowired
    FaqService faqService;


    @GetMapping("/faqList")
    public String list(Model m, FaqSearchCondition fsc) {
        try {
            List<FaqDTO> list = faqService.getSearchResultPage(fsc); // 검색 결과 가져오기

            // list에 제대로 담겨서 넘어왔는지 테스트
            System.out.println("Faqlist = " + list);

            m.addAttribute("list", list);
            Instant startOfToday = LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant();
            m.addAttribute("startOfToday", startOfToday.toEpochMilli());
            m.addAttribute("fsc", fsc);
        } catch (Exception e) {
            e.printStackTrace();
            m.addAttribute("msg", "LIST_ERR");
            m.addAttribute("totalCnt", 0);
        }

        return ViewPath.FOS_MYPAGE + "faqList";
    }




//    @GetMapping("/faqList")
//    public String list( SearchCondition sc, Model m) {
//
////        if (!loginCheck(request))
////            return "redirect:/login/login?toURL=" + request.getRequestURL();  // 로그인을 안했으면 로그인 화면으로 이동
//        try {
//            int totalCnt = faqService.getSearchResultCnt(sc);
//            m.addAttribute("totalCnt", totalCnt);
//
//            PageHandler pageHandler = new PageHandler(totalCnt, sc);
//
//            // 현재 페이지에서 해당 우형의 FAQ만 필터
//            List<FaqDTO> list = faqService.getSearchResultPage(sc);
//
//
//            // list에 제대로 담겨서 넘오올지 Test
//            System.out.println("Faqlist = " + list);
//
//            m.addAttribute("list", list);
//            m.addAttribute("ph", pageHandler);
//            Instant startOfToday = LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant();
//            m.addAttribute("startOfToday", startOfToday.toEpochMilli());
//            m.addAttribute("sc",sc);
////           m.addAttribute("page",page);
////           m.addAttribute("pageSize",pageSize);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            m.addAttribute("msg", "LIST_ERR");
//            m.addAttribute("totalCnt", 0);
//        }
//
//        return ViewPath.FOS_MYPAGE +"faqList";
//
//    }




//    private boolean loginCheck(HttpServletRequest request) {
//        // 1. 세션을 얻어서
//        HttpSession session = request.getSession();
//        // 2. 세션에 id가 있는지 확인, 있으면 true를 반환
//        return session.getAttribute("id") != null;
//    }







}