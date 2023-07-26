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



//    private boolean loginCheck(HttpServletRequest request) {
//        // 1. 세션을 얻어서
//        HttpSession session = request.getSession();
//        // 2. 세션에 id가 있는지 확인, 있으면 true를 반환
//        return session.getAttribute("id") != null;
//    }







}