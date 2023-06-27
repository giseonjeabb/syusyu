package com.teamProject.syusyu.dao.member;

import com.teamProject.syusyu.domain.member.MemberDto;

public interface MemberDao {
    int loginCheck(MemberDto memberDto) throws Exception;

    int memberInsert(MemberDto memberDto) throws Exception;

    int memberInfoInsert(MemberDto memberDto) throws Exception;
}
