package com.teamProject.syusyu.controller.bos.cs.mypage;

import com.teamProject.syusyu.common.ViewPath;
import com.teamProject.syusyu.domain.cs.NoticeDTO;
import com.teamProject.syusyu.domain.cs.PageHandler;
import com.teamProject.syusyu.domain.cs.SearchCondition;
import com.teamProject.syusyu.service.bos.cs.B_NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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
    B_NoticeService noticeService;
    

    /**
     * 공지사항 목록을 조회하고, 페이징 처리된 결과를 화면에 보여준다.
     * 상단 검색바 기능
     *
     * @param m 컨트롤러에서 뷰로 데이터를 전달하는 Model 객체
     * @param request HTTP 요청 정보를 담고 있는 HttpServletRequest 객체
     * @param sc 검색 조건을 담은 SearchCondition 객체
     * @return 관리자 페이지에서 공지사항 목록을 표시하는 View 페이지 경로
     * @throws Exception 데이터베이스 조회 중 발생할 수 있는 예외
     * @since 2023-07-21
     * @author [작성자]
     */
    @GetMapping("/list")
    public String list(Model m , HttpServletRequest request,SearchCondition sc){

        try {

            // 검색 조건에 해당하는 공지사항 총 개수 조회
            int totalCnt = noticeService.getSearchResultCnt(sc);
            m.addAttribute("totalCnt", totalCnt);

            // 페이징 처리를 위한 PageHandler 객체 생성
            PageHandler pageHandler = new PageHandler(totalCnt, sc);

            // 검색 조건에 맞는 공지사항 목록 조회
            List<NoticeDTO> list = noticeService.getSearchResultPage(sc);
            System.out.println("adminNoticelist = " + list);

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
        // 관리자 페이지에서 공지사항 목록을 표시하는 View 페이지 경로 반환
        return ViewPath.BOS_CS + "adminNoticeList";
    }



    /**
     * 선택한 공지사항의 글을 읽을수있음
     * 제목과 내용 , 하단부분에 이전 글,다음글의 제목
     * 이전글 혹은 다음글이 존재하는지 하지 않은지 알수 있음.
     *
     * @param notcNo 조회할 공지사항의 고유 번호
     * @param m 컨트롤러에서 뷰로 데이터를 전달하는 Model 객체
     * @param sc 검색 조건을 담은 SearchCondition 객체
     * @return 공지사항 상세 정보를 표시하는 View 페이지 경로
     * @throws Exception 데이터베이스 조회 중 발생할 수 있는 예외
     * @author han
     * @since  2023-07-31
     */

    @GetMapping("/read")
    public String read(Integer notcNo,Model m ,SearchCondition sc,RedirectAttributes rattr){
        try {

            // 공지사항 번호를 이용하여 해당 공지사항의 상세 정보 조회
            // read(notcNo) 공지사항의 번호로 해당글을 읽을수 있음.
             NoticeDTO noticeDTO =  noticeService.read(notcNo);

            // 이전 글과 다음 글의 제목 가져오기
            NoticeDTO prevNotice = noticeService.getPrevTitle(notcNo);
            NoticeDTO nextNotice = noticeService.getNextTitle(notcNo);

            // 이전 글과 다음 글의 제목을 모델에 추가
            m.addAttribute("prevTitle", prevNotice != null ? prevNotice.getTitle() : null);
            m.addAttribute("nextTitle", nextNotice != null ? nextNotice.getTitle() : null);

            // 이전 글과 다음 글의 번호를 모델에 추가
            m.addAttribute("prevNo", prevNotice != null ? prevNotice.getNotcNo() : null);
            m.addAttribute("nextNo", nextNotice != null ? nextNotice.getNotcNo() : null);


            // 조회한 공지사항의 상세 정보와 검색 조건을 모델에 추가하여 뷰에서 사용할 수 있도록 함
            m.addAttribute("noticeDTO",noticeDTO);
         // m.addAttribute(noticeDTO); 이름 생략하고 이렇게 쓸수 있다. NoticeDTO에서 타입의 첫글자를 소문자로 noticeDTO로 사용
            m.addAttribute("sc",sc);
        } catch (Exception e) {
          e.printStackTrace();
            rattr.addFlashAttribute("msg", "READ_ERR");

           return "redirect:/adminNotice/list";
        }
        // 공지사항 상세 정보를 표시하는 View 페이지 경로 반환
        return ViewPath.BOS_CS + "adminNotice";
    }

    /**
     * 특정글에 notcNo로 인해 글을 삭제 할수 있다.
     *
     * @param  notcNo 삭제할 공지사항의 번호를 나타냄
     * @param  sc 검색조건 , page , pageSize, option , keyword 포함되어있음
     * @param  Model m , 컨트롤러에서 뷰로 전달
     * @param  rattr , redirect 할때 데이터를 전달하기 위해 씀
     * @return 해당 사용자의 장바구니에 담긴 상품들의 정보를 담은 List
     * @throws Exception DB 조회 도중 발생할 수 있는 예외
     * @author han
     * @since  2023-07-31
     */
    @PostMapping("remove")
    public String remove(Integer notcNo ,SearchCondition sc , Model m ,HttpSession session, RedirectAttributes rattr ){
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



    /**
     * 새로운 공지사항을 작성한다.
     *
     * @param noticeDTO 작성할 공지사항의 정보를 담고 있는 NoticeDTO 객체
     * @param m 컨트롤러에서 뷰로 데이터를 전달하는 Model 객체
     * @param session 세션 객체를 사용하여 로그인 정보를 확인하기 위한 HttpSession 객체
     * @param rattr RedirectAttributes를 사용하여 리다이렉트 시 데이터를 전달하기 위한 객체
     * @return 공지사항 작성 결과에 따라 적절한 뷰 페이지로 리다이렉트
     *
     * redirect는 m 모델에 담으면 유효하지 않는다고함
     * flashAttributes 는 redirect 시에만 유효하고 다음 요청까지 유지 되기 때문에 메시지가 유지 된다고함
     * 솔직히 마지막 문장 무슨말인지 이해못했음.
     * 결론은 return 이아니라  return redirect: 붙으면 RedirectAttributes 써야함
     * @author han
     * @since  2023-07-31
     */
    @PostMapping("/write")
    public String write(NoticeDTO noticeDTO, Model m, HttpSession session, RedirectAttributes rattr,@SessionAttribute int mbrId) {

        try {
            noticeDTO.setRegrId(mbrId);
            rattr.addFlashAttribute("noticeDTO", noticeDTO);


            // 작성된 공지사항을 DB에 등록하고 처리된 행의 수를 반환
            int rowCnt = noticeService.write(noticeDTO);

            // 날짜를 모델에 추가함
            Instant startOfToday = LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant();
            m.addAttribute("startOfToday", startOfToday.toEpochMilli());


            System.out.println("mbrId = " + mbrId);

            System.out.println("공지사항 종류: " + noticeDTO.getNotcTp());
            System.out.println("제목 = " + noticeDTO.getTitle());
            System.out.println("등록날짜 = " +noticeDTO.getRegDttm());
            System.out.println("종료날짜 = " + noticeDTO.getEndDttm());
            System.out.println("시작날짜 = " + noticeDTO.getStartDttm());
            // 처리된 행의 수가 1이 아니면 예외를 발생시킴
            if (rowCnt != 1)
                throw new Exception("Write failed!!!!!!!!!!!!!");


            // 성공적으로 작성되었음을 나타내는 메시지를 FlashAttribute에 추가하여 리다이렉트 시 전달
            rattr.addFlashAttribute("msg", "WRT_OK");



        } catch (Exception e) {
            e.printStackTrace();

            // 작성 실패한 공지사항 정보와 에러 메시지를 FlashAttribute에 추가하여 에러 페이지로 이동
            rattr.addFlashAttribute("noticeDTO", noticeDTO);
            rattr.addFlashAttribute("msg", "WRT_ERR");

            return "redirect:/adminNotice/write";


//            m.addAttribute("msg", "WRT_ERR");
//             작동하지않음 , 왜 ?
//             FlashAttribute는 리다이렉트 시에만 유효하며 다음 요청까지 유지되기 때문에 리다이렉트 이후에도 메시지가 유지됩니다.
        }

        // 성공적으로 작성되었음을 나타내는 메시지를 FlashAttribute에 추가하여 공지사항 목록으로 리다이렉트
//        return ViewPath.BOS_CS + "adminNotice/list";
        return "redirect:/adminNotice/list";
    }




    @GetMapping("/write")
    public String showWriteForm() {

        return ViewPath.BOS_CS + "adminNoticeWrite";
    }




    @PostMapping("/modify")
    public String modify(NoticeDTO noticeDTO, Model m, HttpSession session, RedirectAttributes rattr, @SessionAttribute int mbrId) {

        try {
            System.out.println("noticeDTO: " + noticeDTO);

            noticeDTO.setRegrId(mbrId);
            m.addAttribute("noticeDTO", noticeDTO);
            int rowCnt = noticeService.modify(noticeDTO);

            if (rowCnt != 1) {
                throw new Exception("modify failed!!!!!!!!!!!!!!!!!!!!!");
            }

            rattr.addFlashAttribute("msg", "MOD_OK");

        } catch (Exception e) {
            e.printStackTrace();

            m.addAttribute("noticeDTO", noticeDTO);
            m.addAttribute("notcNo", noticeDTO.getNotcNo());

            rattr.addFlashAttribute("msg","MOD_ERR");

            return "redirect:/adminNotice/modify";
        }
        return "redirect:/adminNotice/list";
    }

@GetMapping("/modify")
    public String showModifyForm(Integer notcNo, Model m){

    try {
        NoticeDTO noticeDTO = noticeService.read(notcNo);
        m.addAttribute("noticeDTO",noticeDTO);
    } catch (Exception e) {
        e.printStackTrace();
    }

    return ViewPath.BOS_CS + "adminNoticeModify";
}

//
//    private boolean loginCheck(HttpServletRequest request) {
//        // 1. 세션을 얻어서
//        HttpSession session = request.getSession();
//        // 2. 세션에 id가 있는지 확인, 있으면 true를 반환
//        return session.getAttribute("id") != null;
//    }

}









