package com.teamProject.syusyu.dao.member;

import com.teamProject.syusyu.domain.member.MemberDTO;

public interface MemberDao {
    MemberDTO loginCheck(MemberDTO memberDTO) throws Exception;

    int memberInsert(MemberDTO memberDTO) throws Exception;

    int memberInfoInsert(MemberDTO memberDTO) throws Exception;
}
