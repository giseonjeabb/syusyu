package com.teamProject.syusyu.controller.cs;
import com.teamProject.syusyu.common.ViewPath;
import com.teamProject.syusyu.dao.cs.impl.NoticeDao;
import com.teamProject.syusyu.domain.cs.NoticeDto;
import com.teamProject.syusyu.domain.cs.PageHandler;
import com.teamProject.syusyu.domain.cs.SearchCondition;
import com.teamProject.syusyu.service.cs.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
    NoticeDao noticeDao;


    // 만약 일반 게시판에서 글을 써야한다면 밑에 처럼 바꿔야함
//    Dto를 memberDto로 바꿔야 하고 String writer = (String)session.getAttribute("id");
//    memberDto.setlginId(writer);
    // 현재 기능은 했지만 버튼 자체를 주석 처리해서 다른 이들이 사용 할수 없게 했음.
    // 주석 해제시 관리자, 모든사용자 전부가 공지사항에 글을 쓸수 있게됨. 2023.06.28


    @PostMapping("/modify")
    public String modify( NoticeDto noticeDto, HttpSession session, Model m, RedirectAttributes rattr) {
        int writer = (int) session.getAttribute("id");
        noticeDto.setRegrId(writer);
//        memberDto.setLginId(writer);
        try {
            int rowCnt = noticeService.modify(noticeDto);

            if (rowCnt != 1)
                throw new Exception("Modify failed");

            rattr.addFlashAttribute("msg", "MOD_OK");


            return "redirect:/notice/noticeList";

             } catch (Exception e) {
                        e.printStackTrace();
                        m.addAttribute("noticeDto", noticeDto);
                        m.addAttribute("msg", "Modify_Error");

                         return ViewPath.MYPAGE+"notice";
                }
            }


    @PostMapping("/write")
    public String write(NoticeDto noticeDto, HttpSession session, Model m, RedirectAttributes rattr) {
        int writer = (int) session.getAttribute("id");
        noticeDto.setRegrId(writer);

        try {
            int rowCnt = noticeService.write(noticeDto);

            if (rowCnt != 1)
                throw new Exception("write failed");

            rattr.addFlashAttribute("msg", "WRT_OK");

            return "redirect:/notice/noticeList";

        } catch (Exception e) {
            e.printStackTrace();
            m.addAttribute("noticeDto", noticeDto);
            m.addAttribute("msg", "WRT_ERR");


            return ViewPath.MYPAGE+"notice";

        }

    }


    @GetMapping("/write")
    public String write(Model m) {
        m.addAttribute("mode", "new");

        return ViewPath.CS+"notice"; // 읽기와 쓰기에 사용 , 쓰기에 사용할때는 mode = new
    }


    @PostMapping("/remove")
    public String remove(Integer notcNo, Integer page, Integer pageSize, Model m, HttpSession session, RedirectAttributes rattr) {
        String writer = (String) session.getAttribute("id");
        try {
            m.addAttribute("page", page);
            m.addAttribute("pageSize", pageSize);

            int rowCnt = noticeService.remove(notcNo, writer);

            if (rowCnt != 1)
                throw new Exception("board remove error");

            rattr.addFlashAttribute("msg", "DEL_OK");
        } catch (Exception e) {
            e.printStackTrace();
            rattr.addFlashAttribute("msg", "DEL_ERR");
        }



        return "redirect:/notice/noticeList";

    }


    @GetMapping("/read")
    public String read(Integer notcNo, Integer page, Integer pageSize, Model m) throws Exception {
        try {
            NoticeDto noticeDto = noticeService.read(notcNo);

            // 이전 글과 다음 글의 제목 가져오기
            NoticeDto prevNotice = noticeService.getPrevTitle(notcNo);
            NoticeDto nextNotice = noticeService.getNextTitle(notcNo);
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

            List<NoticeDto> list = noticeService.getSearchResultPage(sc);
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

    private boolean loginCheck(HttpServletRequest request) {
        // 1. 세션을 얻어서
        HttpSession session = request.getSession();
        // 2. 세션에 id가 있는지 확인, 있으면 true를 반환
        return session.getAttribute("id") != null;
    }


}
