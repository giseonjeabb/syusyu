package com.teamProject.syusyu.service.member;

import com.teamProject.syusyu.domain.member.MemberDto;

public interface MemberService {
    int loginCheck(MemberDto memberDto) throws Exception;
}
