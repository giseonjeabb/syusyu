package com.teamProject.syusyu.controller.bos.cs.mypage;

import com.teamProject.syusyu.common.ViewPath;
import com.teamProject.syusyu.domain.cs.FaqDTO;
import com.teamProject.syusyu.domain.cs.PageHandler;
import com.teamProject.syusyu.domain.cs.SearchCondition;
import com.teamProject.syusyu.service.bos.cs.BOS_FaqService;
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
@RequestMapping(ViewPath.BOS)
public class BOS_FaqController {

    @Autowired
    BOS_FaqService faqService;

    @GetMapping("faqList")
    public String list(Model m , SearchCondition sc)throws Exception{

        try {

            // 검색 조건에 해당하는 공지사항 총 개수 조회
            int totalCnt = faqService.getSearchResultCnt(sc);
            m.addAttribute("totalCnt", totalCnt);

            // 페이징 처리를 위한 PageHandler 객체 생성
            PageHandler pageHandler = new PageHandler(totalCnt, sc);

            // 검색 조건에 맞는 공지사항 목록 조회
            List<FaqDTO> list = faqService.getSearchResultPage(sc);
            System.out.println("bos.faqList = " + list);

            // 조회된 공지사항 목록과 페이징 정보를 Model에 추가하여 뷰에서 사용할 수 있도록 함
            m.addAttribute("list", list);
            m.addAttribute("ph", pageHandler);

            // 날짜를 모델에 추가함
            Instant startOfToday = LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant();
            m.addAttribute("startOfToday", startOfToday.toEpochMilli());

        } catch (Exception e) {
            // 예외가 발생하면 에러 메시지와 총 개수를 0으로 설정하여 뷰에 전달
            // "msg" LIST_ERR에 해당하는 문장이 alert 뜸
            e.printStackTrace();
            m.addAttribute("msg", "LIST_ERR");
            m.addAttribute("totalCnt", 0);
        }


        return ViewPath.BOS_CS+"adminFaqList";
    }



}
