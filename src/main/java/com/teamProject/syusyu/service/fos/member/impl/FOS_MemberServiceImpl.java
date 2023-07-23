package com.teamProject.syusyu.service.fos.member.impl;

import com.teamProject.syusyu.dao.member.MemberDao;
import com.teamProject.syusyu.domain.member.MemberDTO;
import com.teamProject.syusyu.service.fos.member.FOS_MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FOS_MemberServiceImpl implements FOS_MemberService {
    MemberDao memberDao;

    @Autowired
    public FOS_MemberServiceImpl(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    @Override
    public MemberDTO loginCheck(MemberDTO memberDTO) throws Exception {
        return memberDao.loginCheck(memberDTO);
    }

    @Transactional(rollbackFor = Exception.class)
    public boolean register(MemberDTO memberDTO) throws Exception {
        int result = memberDao.memberInsert(memberDTO);
        int result2 = memberDao.memberInfoInsert(memberDTO);

        return result > 0 && result2 > 0;
    }

}
