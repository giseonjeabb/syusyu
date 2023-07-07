package com.teamProject.syusyu.dao.member;

import com.teamProject.syusyu.domain.member.DlvAddrDTO;

public interface DlvAddrDAO {
    DlvAddrDTO selectDefaultDlvAddr(int mbrId) throws Exception;
}
