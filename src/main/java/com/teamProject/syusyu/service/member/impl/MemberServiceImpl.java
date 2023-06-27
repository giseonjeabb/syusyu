package com.teamProject.syusyu.service.member.impl;

import com.teamProject.syusyu.dao.member.MemberDao;
import com.teamProject.syusyu.domain.member.MemberDto;
import com.teamProject.syusyu.service.member.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {
    MemberDao memberDao;

    @Autowired
    public MemberServiceImpl(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    @Override
    public int loginCheck(MemberDto memberDto) throws Exception {
        return memberDao.loginCheck(memberDto);
    }

}
