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


   /**
    * notcNo 공지사항의 글 번호를 이용해서 해당 글을 읽음
    * notcNo 를 기준으로 이전 글과 다음글의 제목을 가져 온다.
    *
    * @param notcNo 공지사항의 번호 (글 번호)
    * @param sc 검색 조건 SearchCondition - page, pageSize, 검색바 -keyword,option
    * @return 공지사항 글 상세 페이지  notice.jsp
    * @throws Exception DB 조회 도중 발생할 수 있는 예외
    * @author han
    * @since  2023-07-31
    */
    // List/read?page=?&pageSize=?
    // 공지사항 글 읽기
    @GetMapping("/read")
    public String read(Integer notcNo, SearchCondition sc, Model m) throws Exception {
        try {
            // notcNo(글의 번호)를 이용해서 특정 공지사항 읽어오기
            NoticeDTO noticeDTO = noticeService.read(notcNo);

            // 이전 글과 다음 글의 제목 가져오기
            NoticeDTO prevNotice = noticeService.getPrevTitle(notcNo);
            NoticeDTO nextNotice = noticeService.getNextTitle(notcNo);

            // 이전 글과 다음 글의 제목을 모델에 추가해서 View 로 전달해줌
            m.addAttribute("prevTitle", prevNotice != null ? prevNotice.getTitle() : null);
            m.addAttribute("nextTitle", nextNotice != null ? nextNotice.getTitle() : null);

            // 이전 글과 다음 글의 번호를 모델에 추가
            m.addAttribute("prevNo", prevNotice != null ? prevNotice.getNotcNo() : null);
            m.addAttribute("nextNo", nextNotice != null ? nextNotice.getNotcNo() : null);




            // 조회한 공지사항의 글 정보와 검색조건(SearchCondition)을 모델에 추가해서 View로
            m.addAttribute("noticeDTO", noticeDTO);
            m.addAttribute("sc", sc);
            // m.addAttribute("page", page);
            // m.addAttribute("pageSize", pageSize);
            // 매개변수 Integer page , Integer pageSize 에서 SearchCondition 사용

        } catch (Exception e) {
            e.printStackTrace();
        }

        return ViewPath.FOS_HELP+"notice";
        // ViewPath :    public static final String FOS_HELP = ".help" + FOS + "cs/help/";

    }


    /**
     * 검색 조건에 맞는 공지사항 목록 보여주기
     * 페이지 처리를 해서 한페이지에 공지사항에 일정 글만 보여주고 다음페이지로 이동 해야 보인다.
     *
     * @param Model m , View 파일로 이동해서 보여주기 위함
     * @param SearchCondition  sc ,   page pageSize option keyword 포함되어있음.
     * @return  공지사항 목록 + 페이지를 보여줄 View 파일 경로
     * @throws Exception DB 조회 도중 발생할 수 있는 예외
     * @author han
     * @since  2023-07-31
     */

    // 공지사항 전체 목록 보기
    @GetMapping("/noticeList")
    public String list(SearchCondition sc, Model m, HttpServletRequest request) {
        // 로그인을 안했으면 로그인 화면으로 이동
//        if (!loginCheck(request))
//            return "redirect:/fos/login?toURL=" + request.getRequestURL();  // 로그인을 안했으면 로그인 화면으로 이동

        try {
            // 검색 조건에 맞는 공지사항 글들 총 갯수를 조회함
            int totalCnt = noticeService.getSearchResultCnt(sc);
            m.addAttribute("totalCnt", totalCnt);

            // 페이지 핸들러 생성
            // sc = page, pageSize, keyword , option
            PageHandler pageHandler = new PageHandler(totalCnt, sc);

            // 검색 조건에 맞는 공지사항들의 페이지를 조회함
            List<NoticeDTO> list = noticeService.getSearchResultPage(sc);

            // List<NoticeDTO> list 에 제대로 담겨있는지 확인
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

        return ViewPath.FOS_HELP+"noticeList"; // 로그인을 한 상태이면, 공지사항 화면으로 이동

    }

//    private boolean loginCheck(HttpServletRequest request) {
//        // 1. 세션을 얻어서
//        HttpSession session = request.getSession();
//        // 2. 세션에 id가 있는지 확인, 있으면 true를 반환
//        return session.getAttribute("id") != null;
//    }


}
