package com.teamProject.syusyu.controller.fos.member;

import com.teamProject.syusyu.common.ViewPath;
import com.teamProject.syusyu.domain.member.DlvAddrDTO;
import com.teamProject.syusyu.service.fos.member.FOS_DlvAddrService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.List;

@Controller
@RequestMapping(ViewPath.FOS)
public class FOS_DlvAddrController {
    private final FOS_DlvAddrService service;

    public FOS_DlvAddrController(FOS_DlvAddrService service) {
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
