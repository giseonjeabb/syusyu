package com.teamProject.syusyu.controller.cs.mypage;

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
@RequestMapping("/adminNotice")
public class AdminNoticeController {

    @Autowired
    NoticeService noticeService;

    @GetMapping("/list")
    public String list(SearchCondition sc , Model m , HttpServletRequest request){

        try {

            int totalCnt = noticeService.getSearchResultCnt(sc);
            m.addAttribute("totalCnt", totalCnt);

            PageHandler pageHandler = new PageHandler(totalCnt, sc);

            List<NoticeDTO> list = noticeService.getSearchResultPage(sc);
            System.out.println("list = " + list);
            m.addAttribute("list", list);
            m.addAttribute("ph", pageHandler);
            Instant startOfToday = LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant();
            m.addAttribute("startOfToday", startOfToday.toEpochMilli());

        } catch (Exception e) {
            e.printStackTrace();
            m.addAttribute("msg", "LIST_ERROR");
            m.addAttribute("totalCnt", 0);
        }

        return ViewPath.BOS_CS + "adminNoticeList";// 로그인을 한 상태이면, 관리자 - 공지게시판 화면으로 이동
    }



//    @PostMapping("/write")
//    public String write(NoticeDTO noticeDTO, Model m, HttpSession session, RedirectAttributes rattr) {
//        String writer = (String) session.getAttribute("id");
//        noticeDTO.setRegrId(writer);
//
//        try {
//            int rowCnt = noticeService.write(noticeDTO);
//
//            if (rowCnt != 1)
//                throw new Exception("Write failed");
//
//            rattr.addFlashAttribute("msg", "WRT_OK");
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            m.addAttribute("noticeDTO", noticeDTO);
//            m.addAttribute("msg", "WRT_ERR");
//            return "adminNoticeList";
//        }
//
//        return "redirect:/adminNotice/list";
//    }
//
//    @GetMapping("/write")
//    public String write(Model m) {
//        m.addAttribute("mode", "new"); // 읽기과 쓰기에 사용. 쓰게에 사용할 때는 mode = new
//        return "adminNoticeList";
//    }
//
//
//
//@PostMapping("remove")
//public String remove(Integer notcNo , SearchCondition sc , Model m , HttpSession session ,RedirectAttributes rattr){
//    String writer = (String) session.getAttribute("id");
//
//        try{
//            m.addAttribute("sc",sc);
//
//            int rowCnt = noticeService.remove(notcNo,writer);
//            if (rowCnt != 1) {
//                throw new Exception("board remove error");
//            }
//
//            // 일회성. 한 번만 쓰고 사라진다.(세션을 이용함. 세션에 잠깐 저장했다가 한 번 사용하고 삭제.)
//            rattr.addFlashAttribute("msg", "DEL_OK"); //
//        } catch (Exception e) {
//            e.printStackTrace();
//            rattr.addFlashAttribute("msg", "DEL_ERR");
//        }
//
//            return "redirect:/adminNotice/list";
//
//        }
//
//    @GetMapping("/read")
//    public String read(Integer notcNo, SearchCondition sc, Model m) throws Exception {
//        try {
//            NoticeDTO noticeDto = noticeService.read(notcNo);
//
//            // 이전 글과 다음 글의 제목 가져오기
//            NoticeDTO prevNotice = noticeService.getPrevTitle(notcNo);
//            NoticeDTO nextNotice = noticeService.getNextTitle(notcNo);
//            // 이전 글과 다음 글의 제목을 모델에 추가
//            m.addAttribute("prevTitle", prevNotice != null ? prevNotice.getTitle() : null);
//            m.addAttribute("nextTitle", nextNotice != null ? nextNotice.getTitle() : null);
//
//            m.addAttribute("noticeDto", noticeDto);
//            m.addAttribute("sc", sc);
//            // m.addAttribute("page", page);
//            // m.addAttribute("pageSize", pageSize);
//            // 매개변수 Integer page , Integer pageSize 에서 SearchCondition 사용
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return ViewPath.BOS_CS + "adminNoticeList";
//        //public static final String BOS_CS = ".dashboard/bos/cs/";
//    }
//
//
//
//    @PostMapping("/modify")
//    public String modify(NoticeDTO noticeDTO, Model m, HttpSession session, RedirectAttributes rattr) {
//        String writer = (String) session.getAttribute("id");
//        boardDto.setWriter(writer);
//
//        try {
//            int rowCnt = noticeService.modify(noticeDTO);
//
//            if (rowCnt != 1)
//                throw new Exception("modify failed");
//
//            rattr.addFlashAttribute("msg", "MOD_OK");
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            m.addAttribute("boardDto", boardDto);
//            m.addAttribute("msg", "MOD_ERR");
//            return "board";
//        }
//
//        return "redirect:/adminNotice/list";
//    }
//
//    private boolean loginCheck(HttpServletRequest request) {
//        // 1. 세션을 얻어서
//        HttpSession session = request.getSession();
//        // 2. 세션에 id가 있는지 확인, 있으면 true를 반환
//        return session.getAttribute("id") != null;
//    }
//
//
//
//
//









}









