package com.teamProject.syusyu.dao.member;

import com.teamProject.syusyu.domain.member.DlvAddrDTO;

import java.util.List;

public interface DlvAddrDAO {
    DlvAddrDTO selectDefaultDlvAddr(int mbrId) throws Exception;

    List<DlvAddrDTO> selectAllDlvAddr(int mbrId) throws Exception;
}
