package com.teamProject.syusyu.service.member;

import com.teamProject.syusyu.domain.member.MemberDto;
import org.springframework.transaction.annotation.Transactional;

public interface MemberService {
    int loginCheck(MemberDto memberDto) throws Exception;

    @Transactional(rollbackFor = Exception.class)
    boolean register(MemberDto memberDto) throws Exception;
}
