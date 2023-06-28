package com.teamProject.syusyu.service.member.impl;

import com.teamProject.syusyu.dao.member.MemberDao;
import com.teamProject.syusyu.domain.member.MemberDto;
import com.teamProject.syusyu.service.member.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional(rollbackFor = Exception.class)
    public boolean register(MemberDto memberDto) throws Exception {
        int result = memberDao.memberInsert(memberDto);
        int result2 = memberDao.memberInfoInsert(memberDto);

        return result > 0 && result2 > 0;
    }

}
