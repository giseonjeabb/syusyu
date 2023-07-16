package com.teamProject.syusyu.dao.member;

import com.teamProject.syusyu.domain.member.MemberDTO;

public interface MemberDao {
    MemberDTO loginCheck(MemberDTO memberDTO) throws Exception;
    int memberInsert(MemberDTO memberDTO) throws Exception;
    int memberInfoInsert(MemberDTO memberDTO) throws Exception;

    MemberDTO selectUserInfo(int mbrId) throws Exception;

    int selectMemberTotalPoint(int mbrId) throws Exception;
    int memberCouponCnt(int mbrId) throws Exception;
}
