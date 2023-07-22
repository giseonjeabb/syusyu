package com.teamProject.syusyu.controller.fos.cs.mypage;

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
    public String list(Model m , HttpServletRequest request,SearchCondition sc){

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

        // C:\Users\Han\IdeaProjects\syusyu\syusyu\src\main\webapp\WEB-INF\views\bos\cs\adminNoticeList.jsp
        // .dashboard/bos/cs/
        return ViewPath.BOS_CS + "adminNoticeList";
    }


    @GetMapping("/read")
    public String read(Integer notcNo,Model m ,SearchCondition sc){
        try {

             NoticeDTO noticeDTO =  noticeService.read(notcNo);

            // 이전 글과 다음 글의 제목 가져오기
            NoticeDTO prevNotice = noticeService.getPrevTitle(notcNo);
            NoticeDTO nextNotice = noticeService.getNextTitle(notcNo);

            // 이전 글과 다음 글의 제목을 모델에 추가
            m.addAttribute("prevTitle", prevNotice != null ? prevNotice.getTitle() : null);
            m.addAttribute("nextTitle", nextNotice != null ? nextNotice.getTitle() : null);

            m.addAttribute("noticeDTO",noticeDTO);
         // m.addAttribute(noticeDTO); 이름 생략하고 이렇게 쓸수 있다. NoticeDTO에서 타입의 첫글자를 소문자로 noticeDTO로 사용
            m.addAttribute("sc",sc);
        } catch (Exception e) {
          e.printStackTrace();
        }

        return ViewPath.BOS_CS + "adminNotice";
    }


    @PostMapping("remove")
    public String remove(Integer notcNo ,SearchCondition sc , Model m , HttpSession session , RedirectAttributes rattr ){
//                                                        ,@SessionAttribute Integer mbrId ,@SessionAttribute String lginId
        try{
            m.addAttribute("sc",sc);
            System.out.println("notcNo = " + notcNo);

            int rowCnt =  noticeService.remove(notcNo);

            if (rowCnt != 1) {  // 삭제된 행이 1이 아니라면
                // 실패 에러 메세지 발생
                throw new Exception("adminNotice remove error");
            }

                // 삭제된 행이 1이라면
                // 성공 메세지
                rattr.addFlashAttribute("msg", "DEL_OK");
        } catch (Exception e) {
            e.printStackTrace();
            rattr.addFlashAttribute("msg","DEL_ERR");
        }

        return "redirect:/adminNotice/list";
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

}









