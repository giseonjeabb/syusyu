package com.teamProject.syusyu.service.fos.member.impl;

import com.teamProject.syusyu.dao.member.DlvAddrDAO;
import com.teamProject.syusyu.domain.member.DlvAddrDTO;
import com.teamProject.syusyu.service.fos.member.FOS_DlvAddrService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FOS_DlvAddrServiceImpl implements FOS_DlvAddrService {
    private final DlvAddrDAO dlvAddrDAO;

    public FOS_DlvAddrServiceImpl(DlvAddrDAO dlvAddrDAO) {
        this.dlvAddrDAO = dlvAddrDAO;
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
    @Override
    public List<DlvAddrDTO> getDlvAddrList(int mbrId) throws Exception {
        return dlvAddrDAO.selectAllDlvAddr(mbrId);
    }
}
