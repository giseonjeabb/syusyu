package com.teamProject.syusyu.service.fos.member;

import com.teamProject.syusyu.domain.member.DlvAddrDTO;

import java.util.List;

public interface FOS_DlvAddrService {
    List<DlvAddrDTO> getDlvAddrList(int mbrId) throws Exception;
}
