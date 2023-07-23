package com.teamProject.syusyu.service.fos.member;

import com.teamProject.syusyu.domain.member.MemberDTO;
import org.springframework.transaction.annotation.Transactional;

public interface FOS_MemberService {
    MemberDTO loginCheck(MemberDTO memberDTO) throws Exception;

    @Transactional(rollbackFor = Exception.class)
    boolean register(MemberDTO memberDTO) throws Exception;
}
