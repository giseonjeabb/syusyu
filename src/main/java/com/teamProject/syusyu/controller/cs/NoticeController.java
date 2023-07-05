package com.teamProject.syusyu.controller.cs;
import com.teamProject.syusyu.common.ViewPath;
import com.teamProject.syusyu.domain.cs.NoticeDTO;
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



    @PostMapping("/modify")
    public String modify(NoticeDTO noticeDto, HttpSession session, Model m, RedirectAttributes rattr) {
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
                        m.addAttribute("msg", "MOD_ERR");

                         return ViewPath.MYPAGE+"notice";
                }
            }


    @PostMapping("/write")
    public String write(NoticeDTO noticeDto, HttpSession session, Model m, RedirectAttributes rattr) {
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
            m.addAttribute("msg", "LIST_ERR");
            m.addAttribute("totalCnt", 0);
        }

        return ViewPath.MYPAGE+"noticeList"; // 로그인을 한 상태이면, 공지사항 화면으로 이동


    }

//    private boolean loginCheck(HttpServletRequest request) {
//        // 1. 세션을 얻어서
//        HttpSession session = request.getSession();
//        // 2. 세션에 id가 있는지 확인, 있으면 true를 반환
//        return session.getAttribute("id") != null;
//    }


}
