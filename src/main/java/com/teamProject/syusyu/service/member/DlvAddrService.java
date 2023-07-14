package com.teamProject.syusyu.service.member;

import com.teamProject.syusyu.domain.member.DlvAddrDTO;

import java.util.List;

public interface DlvAddrService {
    List<DlvAddrDTO> getDlvAddrList(int mbrId) throws Exception;
}
