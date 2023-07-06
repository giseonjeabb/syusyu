package com.teamProject.syusyu.controller.cs;

import com.teamProject.syusyu.common.ViewPath;
import com.teamProject.syusyu.dao.cs.FaqDAO;
import com.teamProject.syusyu.domain.cs.FaqDTO;
import com.teamProject.syusyu.domain.cs.PageHandler;
import com.teamProject.syusyu.domain.cs.SearchCondition;
import com.teamProject.syusyu.service.cs.FaqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
    public String list(SearchCondition sc, Model m, HttpServletRequest request) {

//        if (!loginCheck(request))
//            return "redirect:/login/login?toURL=" + request.getRequestURL();  // 로그인을 안했으면 로그인 화면으로 이동

        try {
            // 페이지 핸들러  << < 1,2,3,4,5,6,7,8,9,10 > >>
            int totalCnt = faqService.getSearchResultCnt(sc);
            m.addAttribute("totalCnt", totalCnt);

            PageHandler pageHandler = new PageHandler(totalCnt, sc);

            List<FaqDTO> list = faqService.getSearchResultPage(sc);

            // list에 제대로 담겨서 넘오올지 Test용
            System.out.println("Faqlist = " + list);
            m.addAttribute("list", list);
            m.addAttribute("ph", pageHandler);
            Instant startOfToday = LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant();
            m.addAttribute("startOfToday", startOfToday.toEpochMilli());
            m.addAttribute("sc",sc);
//           m.addAttribute("page",page);
//           m.addAttribute("pageSize",pageSize);


        } catch (Exception e) {
            e.printStackTrace();
            m.addAttribute("msg", "LIST_ERR");
            m.addAttribute("totalCnt", 0);
        }

        return ViewPath.FOS_MYPAGE +"faqList"; // 로그인을 한 상태이면, 공지사항 화면으로 이동

    }



    @GetMapping("/read")
    public String read(Integer faqNo, Integer page, Integer pageSize, Model m) throws Exception {
        try {
            FaqDTO faqDto = faqService.read(faqNo);

            // 이전 글과 다음 글의 제목 가져오기
            FaqDTO prevNotice = faqService.getPrevTitle(faqNo);
            FaqDTO nextNotice = faqService.getNextTitle(faqNo);
            // 이전 글과 다음 글의 제목을 모델에 추가
            m.addAttribute("prevTitle", prevNotice != null ? prevNotice.getTitle() : null);
            m.addAttribute("nextTitle", nextNotice != null ? nextNotice.getTitle() : null);

            m.addAttribute("faqDto", faqDto);
            m.addAttribute("page", page);
            m.addAttribute("pageSize", pageSize);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return ViewPath.MYPAGE+"faq";

    }

//    private boolean loginCheck(HttpServletRequest request) {
//        // 1. 세션을 얻어서
//        HttpSession session = request.getSession();
//        // 2. 세션에 id가 있는지 확인, 있으면 true를 반환
//        return session.getAttribute("id") != null;
//    }







}