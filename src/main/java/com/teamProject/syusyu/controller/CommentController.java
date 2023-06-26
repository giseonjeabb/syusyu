package com.teamProject.syusyu.controller;

import com.teamProject.syusyu.domain.CommentDto;
import com.teamProject.syusyu.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class CommentController {
    @Autowired
    CommentService service;

    // 댓글을 등록하는 메서드
    @PatchMapping("comments/{cno}") // /comments/70 POST
    public ResponseEntity<String> modify(@PathVariable Integer cno, @RequestBody CommentDto commentDto) {
        String commenter = "asdf";
        commentDto.setCommenter(commenter);
        commentDto.setCno(cno);

        System.out.println("commentDto = " + commentDto);

        try {
            int rowCnt = service.modify(commentDto);

            if (rowCnt != 1)
                throw new Exception("Write failed.");

            return new ResponseEntity<>("MOD_OK", HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("MOD_ERR", HttpStatus.BAD_REQUEST);
        }
    }

    // 댓글을 등록하는 메서드
    @PostMapping("comments") // /comments?bno=1085 POST
    public ResponseEntity<String> write(@RequestBody CommentDto commentDto, Integer bno, HttpSession session) {
//        String commenter = (String) session.getAttribute("id");
        String commenter = "asdf";
        commentDto.setCommenter(commenter);
        commentDto.setBno(bno);

        System.out.println("commentDto = " + commentDto);

        try {
            int rowCnt = service.write(commentDto);

            if (rowCnt != 1)
                throw new Exception("Write failed.");

            return new ResponseEntity<>("WRT_OK", HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("WRT_OK", HttpStatus.BAD_REQUEST);
        }
    }

    // 지정된 댓글을 삭제하는 메서드
    @DeleteMapping("/comments/{cno}") // /comments/1?bno=1085 <- 삭제할 댓글 번호
    public ResponseEntity<String> remove(@PathVariable Integer cno, Integer bno, HttpSession session) {
//        String commenter = (String) session.getAttribute("id");
        String commenter = "asdf";

        System.out.println("cno = " + cno);
        System.out.println("bno = " + bno);
        System.out.println("commenter = " + commenter);

        try {
            int rowCnt = service.remove(cno, bno, commenter);

            if (rowCnt != 1)
                throw new Exception("Delete Failed");

            return new ResponseEntity<>("DEL_OK", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("DEL_ERR", HttpStatus.BAD_REQUEST);
        }
    }

    // 지정된 게시물의 모든 댓글을 가져오는 메서드
    @GetMapping("comments")
    public ResponseEntity<List<CommentDto>> list(Integer bno) {
        List<CommentDto> list = null;
        try {
            list = service.getList(bno);
            System.out.println("list = " + list);
            return new ResponseEntity<List<CommentDto>>(list, HttpStatus.OK); // 200
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<List<CommentDto>>(list, HttpStatus.BAD_REQUEST); // 400
        }
    }
}
