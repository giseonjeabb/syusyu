package com.teamProject.syusyu.controller.member;

import com.teamProject.syusyu.domain.member.DlvAddrDTO;
import com.teamProject.syusyu.service.member.DlvAddrService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.List;

@Controller
public class DlvAddrController {
    private final DlvAddrService service;

    public DlvAddrController(DlvAddrService service) {
        this.service = service;
    }

    /**
     * 회원의 배송지 리스트를 조회해온다.
     *
     * @param mbrId 배송지 리스트를 조회할 사용자의 아이디
     * @return 배송지 정보 리스트
     * @throws Exception DB 조회 도중 발생할 수 있는 예외
     * @author min
     * @since  2023/07/14
     */
    @GetMapping("/dlvAddr")
    @ResponseBody
    public ResponseEntity<List<DlvAddrDTO>> getDlvAddrList(@SessionAttribute int mbrId) {
        List<DlvAddrDTO> dlvAddrList = null;

        try {
            dlvAddrList = service.getDlvAddrList(mbrId);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(dlvAddrList, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(dlvAddrList, HttpStatus.OK);
    }
}
