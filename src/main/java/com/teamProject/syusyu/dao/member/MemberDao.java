package com.teamProject.syusyu.dao.member;

import com.teamProject.syusyu.domain.member.MemberDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDao {
    @Autowired
    private SqlSession session;
    private static String namespace = "com.teamProject.syusyu.dao.member.MemberMapper.";

    /*
    * 로그인 체크를 한다.
    * 메서드명 : loginCheck
    * 매개변수 : MemberDto
    * 반환타입 : int(일치하면 1, 일치하지 않으면 0)
    * */
    public int loginCheck(MemberDto memberDto) throws Exception {
        return session.selectOne(namespace + "loginCheck", memberDto);
    }
}
