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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

@Controller
@RequestMapping(ViewPath.BOS)
public class BOS_FaqController {

    @Autowired
    BOS_FaqService faqService;

    /**
     * FAQ 글들을 목록으로 조회
     *
     * @param SearchCondition sc, 검색조건 , page pageSize option keyword 포함되어있음
     * @param Model m 컨트롤러에서 뷰파일로 데이터를 전달함
     * @return FAQ 목록조회 해서 뷰 페이지로 이동함
     * @throws Exception DB 조회 도중 발생할 수 있는 예외
     * @author han
     * @since  2023-07-31
     */
    @GetMapping("faqList")
    public String list(Model m , SearchCondition sc)throws Exception{

        try {

            // 검색 조건에 해당하는 공지사항 총 개수 조회
            int totalCnt = faqService.getBosSearchResultCnt(sc);
            m.addAttribute("totalCnt", totalCnt);

            // 페이징 처리를 위한 PageHandler 객체
            PageHandler pageHandler = new PageHandler(totalCnt, sc);

            // 검색 조건에 맞는 공지사항 목록 조회
            List<FaqDTO> list = faqService.getBosSearchSelectPage(sc);
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
        return ViewPath.BOS_CS+"BOS_FaqList";
    }

    /**
     * FAQ의 글을 faqNo로 조회해서 상세하게 본다.
     * 상세페이지
     * @param SearchCondition sc, 검색조건 , page pageSize option keyword 포함되어있음
     * @param faqNo 조회할 FAQ 글의 번호
     * @param Model m 컨트롤러에서 뷰파일로 데이터를 전달함
     * @return FAQ 글의 상세 내용 보는 BOS_Faq.jsp
     * @throws Exception DB 조회 도중 발생할 수 있는 예외
     * @author han
     * @since  2023-07-31
     */
    @GetMapping("faqRead")
    public String read(Integer faqNo, Model m ,SearchCondition sc) throws Exception{

        try {
            // read() 에 faqNo를 이용해서 특정 FAQ글의 내용을 볼수있음.
            FaqDTO  faqDTO = faqService.read(faqNo);
            // faqNo 제대로 되어있는지 확인하려고
            System.out.println("faqNo = " + faqNo);


            // 주어진 faqNo로 인해 faqNo를 기준으로
            // 이전글과 다음글의 제목과 글 번호가 담겨있음
            FaqDTO prevFaq = faqService.getPrevTitle(faqNo);
            FaqDTO nextFaq = faqService.getNextTitle(faqNo);

            // 이전글 , 다음글의 제목을 Model 에 담아서 뷰에서 쓸수있게 하려고
            m.addAttribute("prevFaqTitle", prevFaq != null ? prevFaq.getTitle():null);
            m.addAttribute("nextFaqTitle", nextFaq != null ? nextFaq.getTitle() : null);

            // Mapper에 SELECT TITLE, FAQ_NO , FAQ_NO AS PREV_NO
            // getPrevNo() 라고 써도되고 getFaqNO() 라고 써도됨
            // 이전글 , 다음글의 제목을 Model 에 담아서 뷰에서 쓸수있게 하려고
            m.addAttribute("prevFaqNo", prevFaq != null ? prevFaq.getPrevNo():null);
            m.addAttribute("nextFaqNo", nextFaq != null ? nextFaq.getFaqNo() : null);

            // FAQ글의 상세내용 , 검색 조건을 Model 에 담아서 뷰로 ~
            m.addAttribute("faqDTO",faqDTO);
            m.addAttribute("sc",sc);
        } catch (Exception e) {
            // 실패시 , 예외 발생시 에러 메세지
            // "msg" 값이 READ_ERR 일경우 뷰에 있는 JS 코드에 맞게 alert 표시
            e.printStackTrace();
            m.addAttribute("msg","READ_ERR");
            return "redirect:/bos/faqList";
        }

        return ViewPath.BOS_CS+"BOS_Faq";
    }


    /**
     * FAQ글 수정하기위해 수정하는 폼으로 이동해서 보여주려고
     *
     * @param faqNo 수정할 FAQ글의 번호
     * @return FAQ 글을 수정할수있는 폼으로 이동
     * @throws Exception DB 조회 도중 발생할 수 있는 예외
     * @author han
     * @since  2023-07-31
     */
    @GetMapping("faqModify")
    public String showModifyForm(Integer faqNo,Model m){
        try {
            FaqDTO faqDTO = faqService.read(faqNo);
            m.addAttribute("faqDTO",faqDTO);
        } catch (Exception e) {
           e.printStackTrace();
            return "redirect:/bos/faqList";
        }
        return ViewPath.BOS_CS+"BOS_FaqModify";
    }

    /**
     * FAQ 글을 수정하는 메서드
     *
     * @param faqDTO 수정할 FAQ글의 정보를 담고 있음
     * @param rattr  RedirectAttributes 사용해서 redirect시 데이터를 전달
     * @param mbrId 현재 로그인 되어있는 사용자의 아이디
     * @return 글을 수정하고 나서 이동할 뷰 페이지이 redirect
     * @throws Exception DB 조회 도중 발생할 수 있는 예외
     * @author han
     * @since  2023-07-31
     */
    @PostMapping("faqModify")
    public String modify(Model m,FaqDTO faqDTO,RedirectAttributes rattr, @SessionAttribute int mbrId){

        try {
            // 현재 로그인 되어있는 사용자의 아이디를 수정할 FAQ글의 등록자 아이디로 설정
            faqDTO.setRegrId(mbrId);

            // 수정할 FAQ글의 정보를 Model 에 담아서 뷰에서 쓸수 있게
            m.addAttribute("faqDTO",faqDTO);
            System.out.println("Modify_faqDTO = " + faqDTO);

            // FAQ글을 수정함.
            faqService.modify(faqDTO);

            // 글 수정이 성공할경우 redirect시 메시지 전달
            // "msg"가 MOD_OK 일시 뷰 페이지에 있는 JS 코드에 맞춰 alert 메세지 뜨게함.
            rattr.addFlashAttribute("msg","MOD_OK");
        } catch (Exception e) {
            e.printStackTrace();

            // 글 수정 실패 할 경우 "msg" MOD_ERR
            rattr.addFlashAttribute("msg","MOD_ERR");

            // 수정 실패시 원래의 수정하는 폼으로 다시 돌아가려고 FAQ글의 번호인 faqNo를 redirect시 파라미터로 줌
            m.addAttribute("faqDTO",faqDTO);
            m.addAttribute("faqNo", faqDTO.getFaqNo());

            // 수정 실패하면 다시 FAQ수정 하는 폼으로
            return "redirect:/bos/faqModify";
        }
        // 수정 성공시 FAQ 목록을 보여줌
        return "redirect:/bos/faqList";
    }


    @GetMapping("faqWrite")
    public String showWriteForm(){

        return ViewPath.BOS_CS+"BOS_FaqWrite";
    }

    /**
     * FAQ의 글을 작성하는 메서드
     *
     * @param mbrId 현재 로그인 되어있는 사용자의 아이디
     * @param rattr  RedirectAttributes 사용해서 redirect시 데이터를 전달
     * @param  faqDTO 작성할 FAQ 글의 정보를 담고 있음.
     * @return 해당 사용자의 장바구니에 담긴 상품들의 정보를 담은 List
     * @throws Exception DB 조회 도중 발생할 수 있는 예외
     * @author han
     * @since  2023-07-31
     */
    @PostMapping("faqWrite")
        public String write(FaqDTO faqDTO,Model m ,RedirectAttributes rattr , @SessionAttribute int mbrId)throws Exception{

            try {
                // 현재 로그인 되어있는 사용자의 아이디를 작성하는 FAQ글의 등록자 아아디로 설정
                faqDTO.setRegrId(mbrId);

                // 작성할 FAQ글의 정보를 Model 에 담아서 뷰에서 씀
                m.addAttribute("faqDTO",faqDTO);

                // FAQ글을 작성하는 FaqService 파일에 write() 메서드
                faqService.write(faqDTO);

                System.out.println("mbrId = " + mbrId);
                // FAQ 글 작성 성공시 redirect시 메시지 전달
                rattr.addFlashAttribute("msg","WRT_OK");
            } catch (Exception e) {
                e.printStackTrace();
                // 글작성 실패시 , 에러 메시지와 작성한 FAQ글의 정보
                rattr.addFlashAttribute("faqDTO",faqDTO);
                rattr.addFlashAttribute("msg","WRT_ERR");

                // 작성실패시 다시 글작성 폼으로 이동
                return "redirect:/bos/faqWrite";
            }
            // 글작성 성공시 FAQ 목록을 보여줌.
            return "redirect:/bos/faqList";
            // 작성후 faqWrite 뷰페이지가 아니라 FAQ목록 페이지로 이동시켜주기위해
            // redirect 사용 한다
            // 새로고침으로 중복 작성을 방지 할수 있고
            // rattr 메시지 정보를 다음 페이지로 전달할수있다고 한다.
            // 주로 작성 , 삭제 , 수정에 쓰인다.
             }


        /**
        * 해당글의 faqNo로 글을 삭제 할수 있따.
        *
        * @param  faqNo 해당글의 글의 번호
        * @param mbrId 현재 로그인 되어있는 사용자의 아이디
        * @param rattr  RedirectAttributes 사용해서 redirect시 데이터를 전달
        * @param  faqDTO 작성할 FAQ 글의 정보를 담고 있음.
        * @return 해당 사용자의 장바구니에 담긴 상품들의 정보를 담은 List
        * @throws Exception DB 조회 도중 발생할 수 있는 예외
        * @author han
        * @since  2023-07-31
        */
    @PostMapping("faqRemove")
    public String remove(Integer faqNo,FaqDTO faqDTO,SearchCondition sc, Model m , RedirectAttributes rattr,@SessionAttribute int mbrId){
        try {

            // 현재 로그인 되어있는 사용자의 아이디를  삭제하려는 FAQ글의 등록자 아아디로 설정
            faqDTO.setRegrId(mbrId);

            // 검색 조건을 모델에
            m.addAttribute("sc",sc);
            System.out.println("faqNo = " + faqNo);

            // faqService에 remove() 사용 하는데 faqNo에 해당하는 FAQ를 삭제함.
            faqService.remove(faqNo,faqDTO.getRegrId());
            // 삭제 성공시에만 메시지를 redirect 할 떄에만 유지
            rattr.addFlashAttribute("msg","DEL_OK");
        } catch (Exception e) {
            // 삭제 실패시
           e.printStackTrace();
            rattr.addFlashAttribute("msg","DEL_ERR");
        }
        // 삭제후 FAQ 목록페이지로 redirect
        // 수정 삭제 등록 은 데이터를 받아서 처리 후 결과를 보여줄때 redirect
        return  "redirect:/bos/faqList";
    }


}
