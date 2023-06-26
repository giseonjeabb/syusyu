package com.teamProject.syusyu.service.member;

import com.teamProject.syusyu.dao.member.MemberDao;
import com.teamProject.syusyu.domain.member.MemberDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    MemberDao memberDao;

    @Autowired
    public MemberService(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    public int loginCheck(MemberDto memberDto) throws Exception {
        return memberDao.loginCheck(memberDto);
    }

}
