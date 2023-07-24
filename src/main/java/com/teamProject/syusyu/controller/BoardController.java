package com.teamProject.syusyu.controller;

import com.teamProject.syusyu.domain.BoardDto;
import com.teamProject.syusyu.domain.PageHandler;
import com.teamProject.syusyu.domain.SearchCondition;
import com.teamProject.syusyu.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardController {
    @Autowired
    BoardService boardService;

    @PostMapping("/modify")
    public String modify(BoardDto boardDto, Model m, HttpSession session, RedirectAttributes rattr) {
        String writer = (String) session.getAttribute("id");
        boardDto.setWriter(writer);

        try {
            int rowCnt = boardService.modify(boardDto);

            if (rowCnt != 1)
                throw new Exception("modify failed");

            rattr.addFlashAttribute("msg", "MOD_OK");

        } catch (Exception e) {
            e.printStackTrace();
            m.addAttribute("boardDto", boardDto);
            m.addAttribute("msg", "MOD_ERR");
            return "board";
        }

        return "redirect:/board/list";
    }

    @PostMapping("/write")
    public String write(BoardDto boardDto, Model m, HttpSession session, RedirectAttributes rattr) {
        String writer = (String) session.getAttribute("id");
        boardDto.setWriter(writer);

        try {
            int rowCnt = boardService.write(boardDto);

            if (rowCnt != 1)
                throw new Exception("Write failed");

            rattr.addFlashAttribute("msg", "WRT_OK");

        } catch (Exception e) {
            e.printStackTrace();
            m.addAttribute("boardDto", boardDto);
            m.addAttribute("msg", "WRT_ERR");
            return "board";
        }

        return "redirect:/board/list";
    }

    @GetMapping("/write")
    public String write(Model m) {
        m.addAttribute("mode", "new"); // 읽기과 쓰기에 사용. 쓰게에 사용할 때는 mode = new
        return "board";
    }

    @PostMapping("/remove")
    public String remove(Integer bno, Integer page, Integer pageSize, Model m, HttpSession session, RedirectAttributes rattr) {
        String writer = (String) session.getAttribute("id");

        try {
            m.addAttribute("page", page);
            m.addAttribute("pageSize", pageSize);

            int rowCnt = boardService.remove(bno, writer);

            if (rowCnt != 1) {
                throw new Exception("board remove error");
            }

            // 일회성. 한 번만 쓰고 사라진다.(세션을 이용함. 세션에 잠깐 저장했다가 한 번 사용하고 삭제.)
            rattr.addFlashAttribute("msg", "DEL_OK"); //
        } catch (Exception e) {
            e.printStackTrace();
            rattr.addFlashAttribute("msg", "DEL_ERR");
        }

        return "redirect:/board/list";
    }

    @GetMapping("/read")
    public String read(Integer bno, Integer page, Integer pageSize, Model m) {
        try {
            BoardDto boardDto = boardService.read(bno);
//            m.addAttribute("boardDto", boardDto); // 아래 문장과 동일
            m.addAttribute(boardDto); // 이름 생략 시 타입의 첫 글자가 소문자로 바뀐게 key가된다.
            m.addAttribute("page", page);
            m.addAttribute("pageSize", pageSize);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "board";
    }

    @GetMapping("/list")
//    public String list(int page, int pageSize, Model m, HttpServletRequest request) {
    public String list(SearchCondition sc, Model m, HttpServletRequest request) { // page 값이 안 들어왔을 때 에러 발생 X
        if (!loginCheck(request))
            return "redirect:/fos/login?toURL=" + request.getRequestURL();  // 로그인을 안했으면 로그인 화면으로 이동

        try {
            int totalCnt = boardService.getSearchResultCnt(sc);
            PageHandler pageHandler = new PageHandler(totalCnt, sc);

            List<BoardDto> list = boardService.getSearchResultPage(sc);
            m.addAttribute("list", list);
            m.addAttribute("ph", pageHandler);
//            m.addAttribute("page", page);
//            m.addAttribute("pageSize", pageSize);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "boardList"; // 로그인을 한 상태이면, 게시판 화면으로 이동
    }

    private boolean loginCheck(HttpServletRequest request) {
        // 1. 세션을 얻어서
        HttpSession session = request.getSession();
        // 2. 세션에 id가 있는지 확인, 있으면 true를 반환
        return session.getAttribute("id") != null;
    }
}