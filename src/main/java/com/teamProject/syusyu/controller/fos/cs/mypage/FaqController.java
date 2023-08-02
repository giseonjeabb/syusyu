package com.teamProject.syusyu.controller.fos.cs.mypage;

import com.teamProject.syusyu.common.ViewPath;
import com.teamProject.syusyu.domain.cs.FaqDTO;
import com.teamProject.syusyu.domain.cs.FaqSearchCondition;
import com.teamProject.syusyu.service.fos.cs.FOS_FaqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

@Controller
@RequestMapping("/faq")
public class FaqController {

    @Autowired
    FOS_FaqService faqService;

    /**
     * FAQ 목록을 페이지 처리 하지 않고 한 페이지에 모든 글을 보여준다.
     *
     * @param Model m , View로 보내줄 데이터 옮겨줄때 사용할 Model 객체
     * @param FaqSearchCondition fsc , keyword , option 만 존재함
     * @return helpLayout
     * @throws Exception DB 조회 도중 발생할 수 있는 예외
     * @author han
     * @since  2023-07-31
     */

    @GetMapping("/faqList")
    public String list(Model m, FaqSearchCondition fsc) {
        try {
            // FAQ 검색 조건에 맞는 검색결과 가져옴
            List<FaqDTO> list = faqService.getFosSearchSelectPage(fsc);

            // list에 제대로 담겨서 넘어왔는지 테스트
            System.out.println("Faqlist = " + list);
            m.addAttribute("list", list);

            // 현재 날짜를 모델에 추가함.
            Instant startOfToday = LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant();
            m.addAttribute("startOfToday", startOfToday.toEpochMilli());

            // 검색 조건을 모델에 추가함
            m.addAttribute("fsc", fsc);
        } catch (Exception e) {
            e.printStackTrace();
            // 오류 발생시 에러 메세지 모델에 추가
            m.addAttribute("msg", "LIST_ERR");
            // 오류 발생시 검색 결과 갯수는 0 개
            m.addAttribute("totalCnt", 0);
        }
        // FAQ 목록 화면으로 이동
        //  public static final String FOS_HELP = ".help" + FOS + "cs/help/***";
        return ViewPath.FOS_HELP + "faqList";
    }



//    private boolean loginCheck(HttpServletRequest request) {
//        // 1. 세션을 얻어서
//        HttpSession session = request.getSession();
//        // 2. 세션에 id가 있는지 확인, 있으면 true를 반환
//        return session.getAttribute("id") != null;
//    }







}