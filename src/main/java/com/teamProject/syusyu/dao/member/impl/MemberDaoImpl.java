package com.teamProject.syusyu.dao.member.impl;

import com.teamProject.syusyu.dao.member.MemberDao;
import com.teamProject.syusyu.domain.member.MemberDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDaoImpl implements MemberDao {
    @Autowired
    private SqlSession session;
    private static final String namespace = "com.teamProject.syusyu.memberMapper.";

    /*
    * 로그인 체크를 한다.
    * 메서드명 : loginCheck
    * 매개변수 : MemberDTO
    * 반환타입 : int(일치하면 1, 일치하지 않으면 0)
    * */
    public MemberDTO loginCheck(MemberDTO memberDTO) throws Exception {
        return session.selectOne(namespace + "loginCheck", memberDTO);
    }

    public int memberInsert(MemberDTO memberDTO) throws Exception {
        return session.insert(namespace + "memberInsert", memberDTO);
    }

    public int memberInfoInsert(MemberDTO memberDTO) throws Exception {
        return session.insert(namespace + "memberInfoInsert", memberDTO);
    }

}
