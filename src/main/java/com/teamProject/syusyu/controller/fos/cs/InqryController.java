package com.teamProject.syusyu.controller.fos.cs;

import com.teamProject.syusyu.common.ViewPath;
import com.teamProject.syusyu.domain.PageHandler2;
import com.teamProject.syusyu.domain.cs.InqryDTO;
import com.teamProject.syusyu.domain.cs.inqryData;
import com.teamProject.syusyu.service.fos.cs.InqryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/inqry")
public class InqryController {

        @Autowired
        InqryService inqryService;

        private static final String CURR_IMAGE_REPO_PATH = "../../../image/inqry";

//        @PostMapping("/remove")
//        public String remove(Integer inqryNo, Integer page, Integer pageSize, Model m, HttpSession session, RedirectAttributes rattr) {
//            InqryDTO inqry = new InqryDTO();
//
//            Integer mbrId = (Integer)session.getAttribute("mbrId");
//            // 세션에서 regrId 값 가져오기
//            try {
//                inqryService.remove(inqryNo, mbrId.toString());
//                System.out.println("query resert"+inqryService.remove(inqryNo, mbrId.toString()));
//                System.out.println("inqryNo = " + inqryNo);
//            } catch (Exception e) {
//                e.printStackTrace();
////                rattr.addFlashAttribute("msg", "DEL_ERR");
//            }
//
//            m.addAttribute("page", page);
//            m.addAttribute("pageSize", pageSize);
//
//            return ViewPath.FOS_MYPAGE +"inqryList";
//            //"redirect:" +
//
//        }

    @PostMapping("/remove")
    @ResponseBody
    public int remove(Integer inqryNo, Integer page, Integer pageSize, Model m, HttpSession session, RedirectAttributes rattr) {
        InqryDTO inqry = new InqryDTO();
        int removeYn = 1;

        Integer mbrId = (Integer)session.getAttribute("mbrId");
        // 세션에서 regrId 값 가져오기
        try {
            if(inqryService.remove(inqryNo, mbrId.toString())!=1)
                throw new Exception("Delete failed.");
            System.out.println("query resert"+inqryService.remove(inqryNo, mbrId.toString()));
            System.out.println("inqryNo = " + inqryNo);
        } catch (Exception e) {
            e.printStackTrace();
            removeYn = 0;
//                rattr.addFlashAttribute("msg", "DEL_ERR");
        }

//            m.addAttribute("page", page);
//            m.addAttribute("pageSize", pageSize);
//            m.addAttribute("msg", msg);

        return removeYn;
        //"redirect:" +

    }

    @PostMapping("/inqry")
    public String inqry(Integer inqryNo, Model m) {
        try{
            InqryDTO inqry = new InqryDTO();
//            InqryDTO inqryDTO = inqryService.read(inqryNo);
//            m.addAttribute(inqryDTO);
        }catch (Exception e) {
            e.printStackTrace();
        }

        return ViewPath.FOS_MYPAGE +"inqry";
    }

    @GetMapping("/read")
        public String read(Integer inqryNo, Model m) {
            try{
                InqryDTO inqryDTO = inqryService.read(inqryNo);
                m.addAttribute(inqryDTO);
            }catch (Exception e) {
                e.printStackTrace();
            }

            return ViewPath.FOS_MYPAGE +"inqry";
        }



        @GetMapping("/inqryList")
        public String list(Integer page, Integer pageSize, Model m, HttpServletRequest request) {
//            if(!loginCheck(request))
//                return "redirect:/fos/login?toURL="+request.getRequestURL();  // 로그인을 안했으면 로그인 화면으로 이동

            if(page==null) page=1;
            if(pageSize==null) pageSize=10;

            try {
                int totalCnt = inqryService.getCount();
                PageHandler2 pageHandler = new PageHandler2(totalCnt, page, pageSize);

                Map map = new HashMap();
                map.put("offset", (page-1)*pageSize);
                map.put("pageSize", pageSize);

                List<InqryDTO> list = inqryService.getPage(map);
                m.addAttribute("list", list);
                m.addAttribute("ph", pageHandler);
                m.addAttribute("page", page);
                m.addAttribute("pageSize", pageSize);
                m.addAttribute("totalCnt", totalCnt);
                // 모델에 inqry 테이블의 컬럼 개수 추가
            } catch (Exception e) {
                e.printStackTrace();
            }

            return ViewPath.FOS_MYPAGE +"inqryList"; // 로그인을 한 상태이면, 게시판 화면으로 이동
        }

        @PostMapping("/modify")
        public String modify(Integer inqryNo, Model m, HttpSession session, RedirectAttributes rattr){

            try {
                InqryDTO inqryDTO = inqryService.read(inqryNo);
                String Content = inqryService.getContent(inqryNo);
                System.out.println(inqryDTO); // 또는 로깅을 이용하여 값 확인
                m.addAttribute("inqryDTO", inqryDTO);
                m.addAttribute("Content", Content);
            } catch (Exception e) {
                e.printStackTrace();
            }
                return ViewPath.FOS_MYPAGE +"inqrymodify";
        }

    @PostMapping("/imgUpload")
    public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile[] files) {
        System.out.println(" 진입 ");
        try {
            List<String> fileNames = new ArrayList<>();
            for (MultipartFile file : files) {
                String originalFilename = file.getOriginalFilename();
                String filePath = CURR_IMAGE_REPO_PATH + "/" + originalFilename;
                File destFile = new File(filePath);
                file.transferTo(destFile);
                fileNames.add(originalFilename);
            }
            return ResponseEntity.ok("파일 업로드 성공: " + fileNames);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("파일 업로드 실패");
        }
    }

    //파일명 같을시 나중에것이 기존거 덮어씌움. 파일명 있는지 확인하고 같은거 있으면 폴더생성하고 거기에 넣기. 폴더명은 일련번호로 넣고
    //경로에도 뒤에추가해주기.
    //등록버튼누르면 이미지명, 이미지 순서까지 같이 보내기. session으로 id확인해서 자기꺼 이미지 저장.
    //데이터 많이 보낼때 배열사용.(어차피 자스 배열은 맵으로 되어있음)

    @PostMapping("/write")
    @ResponseBody
    public int write(@RequestBody InqryDTO inqryDTO, HttpSession session, RedirectAttributes rattr, Model m) {
        // inqryDTO 객체에 클라이언트에서 전송한 데이터가 이미 매핑되어 있습니다.
        // 따라서 이후에 inqryDTO 객체를 사용하여 title과 RegDttm 정보를 가져와 사용할 수 있습니다.

        // 예시: title과 RegDttm 정보를 로깅하여 확인해보기
        System.out.println("title: " + inqryDTO.getTitle());
        System.out.println("RegDttm: " + inqryDTO.getRegDttm());

        // 모델에 inqryDTO 객체를 추가하여 클라이언트로 전달
        m.addAttribute("inqryDTO", inqryDTO);

        try {
            // InqryService를 통해 데이터 삽입
            int result = inqryService.insert(inqryDTO);
            // 필요한 경우 'result' 변수를 사용합니다. (예: 오류 처리 또는 추가 처리).

            // 성공적으로 등록되었음을 클라이언트에게 알리기 위해 1 반환
            return 1;
        } catch (Exception e) {
            // 예외 처리가 필요한 경우 처리합니다.
            e.printStackTrace();
            // 오류가 발생했음을 나타내는 오류 코드를 반환
            return -1;
        }
    }


//        @GetMapping("/write")
//        public String write(Model m) {
//            m.addAttribute("mode", "new");
//            return "board";
//        }
//

}
