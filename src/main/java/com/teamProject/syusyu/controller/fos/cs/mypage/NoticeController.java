package com.teamProject.syusyu.controller.fos.cs.mypage;

import com.teamProject.syusyu.common.ViewPath;
import com.teamProject.syusyu.domain.cs.NoticeDTO;
import com.teamProject.syusyu.domain.cs.PageHandler;
import com.teamProject.syusyu.domain.cs.SearchCondition;
import com.teamProject.syusyu.service.fos.cs.F_NoticeService;
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
    F_NoticeService noticeService;


    // List/read?page=?&pageSize=?
    // 공지사항 글 읽기
    @GetMapping("/read")
    public String read(Integer notcNo, SearchCondition sc, Model m) throws Exception {
        try {
            NoticeDTO noticeDto = noticeService.read(notcNo);

            // 이전 글과 다음 글의 제목 가져오기
            NoticeDTO prevNotice = noticeService.getPrevTitle(notcNo);
            NoticeDTO nextNotice = noticeService.getNextTitle(notcNo);
            // 이전 글과 다음 글의 제목을 모델에 추가
            m.addAttribute("prevTitle", prevNotice != null ? prevNotice.getTitle() : null);
            m.addAttribute("nextTitle", nextNotice != null ? nextNotice.getTitle() : null);

            m.addAttribute("noticeDto", noticeDto);
            m.addAttribute("sc", sc);
            // m.addAttribute("page", page);
            // m.addAttribute("pageSize", pageSize);
            // 매개변수 Integer page , Integer pageSize 에서 SearchCondition 사용

        } catch (Exception e) {
            e.printStackTrace();
        }

        return ViewPath.FOS_MYPAGE+"notice";
        // ViewPath : public static final String MYPAGE = ".mypage/fos/cs/mypage/";

    }

    // 공지사항 전체 목록 보기
    @GetMapping("/noticeList")
    public String list(SearchCondition sc, Model m, HttpServletRequest request) {
        // 로그인을 안했으면 로그인 화면으로 이동
//        if (!loginCheck(request))
//            return "redirect:/fos/login?toURL=" + request.getRequestURL();  // 로그인을 안했으면 로그인 화면으로 이동


        try {
            // 페이지 핸들러  << < 1,2,3,4,5,6,7,8,9,10 > >>
            int totalCnt = noticeService.getSearchResultCnt(sc);
            m.addAttribute("totalCnt", totalCnt);

            PageHandler pageHandler = new PageHandler(totalCnt, sc);

            List<NoticeDTO> list = noticeService.getSearchResultPage(sc);

            // List<NoticeDTO> list 에 담아서 오는 지 보려고
            System.out.println("noticelist = " + list);

            m.addAttribute("list", list);
            m.addAttribute("ph", pageHandler);
            //           m.addAttribute("page",page);
            //           m.addAttribute("pageSize",pageSize);

            // 날짜를 모델에 추가함
            Instant startOfToday = LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant();
            m.addAttribute("startOfToday", startOfToday.toEpochMilli());

        } catch (Exception e) {
            e.printStackTrace();
            m.addAttribute("msg", "LIST_ERR");
            m.addAttribute("totalCnt", 0);
        }

        return ViewPath.FOS_MYPAGE+"noticeList"; // 로그인을 한 상태이면, 공지사항 화면으로 이동
        // ViewPath : public static final String MYPAGE = ".mypage/fos/cs/mypage/";
    }

//    private boolean loginCheck(HttpServletRequest request) {
//        // 1. 세션을 얻어서
//        HttpSession session = request.getSession();
//        // 2. 세션에 id가 있는지 확인, 있으면 true를 반환
//        return session.getAttribute("id") != null;
//    }


}
