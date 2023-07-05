package com.teamProject.syusyu.controller.cs;
import com.teamProject.syusyu.common.ViewPath;
import com.teamProject.syusyu.dao.cs.NoticeDAO;
import com.teamProject.syusyu.domain.cs.NoticeDTO;
import com.teamProject.syusyu.domain.cs.PageHandler;
import com.teamProject.syusyu.domain.cs.SearchCondition;
import com.teamProject.syusyu.service.cs.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

@Controller
@RequestMapping("/notice")
public class NoticeController {

    @Autowired
    NoticeService noticeService;

    @Autowired
    NoticeDAO noticeDao;


    @GetMapping("/read")
    public String read(Integer notcNo, Integer page, Integer pageSize, Model m) throws Exception {
        try {
            NoticeDTO noticeDto = noticeService.read(notcNo);

            // 이전 글과 다음 글의 제목 가져오기
            NoticeDTO prevNotice = noticeService.getPrevTitle(notcNo);
            NoticeDTO nextNotice = noticeService.getNextTitle(notcNo);
            // 이전 글과 다음 글의 제목을 모델에 추가
            m.addAttribute("prevTitle", prevNotice != null ? prevNotice.getTitle() : null);
            m.addAttribute("nextTitle", nextNotice != null ? nextNotice.getTitle() : null);

            m.addAttribute("noticeDto", noticeDto);
            m.addAttribute("page", page);
            m.addAttribute("pageSize", pageSize);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return ViewPath.MYPAGE+"notice";

    }


    @GetMapping("/noticeList")
    public String list(SearchCondition sc, Model m, HttpServletRequest request) {

//        if (!loginCheck(request))
//            return "redirect:/login/login?toURL=" + request.getRequestURL();  // 로그인을 안했으면 로그인 화면으로 이동

        try {
            // 페이지 핸들러  << < 1,2,3,4,5,6,7,8,9,10 > >>
            int totalCnt = noticeService.getSearchResultCnt(sc);
            m.addAttribute("totalCnt", totalCnt);

            PageHandler pageHandler = new PageHandler(totalCnt, sc);

            List<NoticeDTO> list = noticeService.getSearchResultPage(sc);
            System.out.println("list = " + list);
            m.addAttribute("list", list);
            m.addAttribute("ph", pageHandler);
            Instant startOfToday = LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant();
            m.addAttribute("startOfToday", startOfToday.toEpochMilli());
//           m.addAttribute("page",page);
//           m.addAttribute("pageSize",pageSize);


        } catch (Exception e) {
            e.printStackTrace();
            m.addAttribute("msg", "LIST_ERROR");
            m.addAttribute("totalCnt", 0);
        }

        return ViewPath.MYPAGE+"noticeList"; // 로그인을 한 상태이면, 공지사항 화면으로 이동

    }
}
