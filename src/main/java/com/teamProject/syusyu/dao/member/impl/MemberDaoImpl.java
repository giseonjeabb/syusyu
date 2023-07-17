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
    @Override
    public MemberDTO loginCheck(MemberDTO memberDTO) throws Exception {
        return session.selectOne(namespace + "loginCheck", memberDTO);
    }

    @Override
    public int memberInsert(MemberDTO memberDTO) throws Exception {
        return session.insert(namespace + "memberInsert", memberDTO);
    }

    @Override
    public int memberInfoInsert(MemberDTO memberDTO) throws Exception {
        return session.insert(namespace + "memberInfoInsert", memberDTO);
    }

    /**
     * 회원의 정보를 조회한다.
     *
     * @param mbrId 장바구니를 조회할 사용자의 아이디
     * @return 회원의 정보
     * @throws Exception DB 조회 도중 발생할 수 있는 예외
     * @author min
     * @since  2023/07/07
     */
    @Override
    public MemberDTO selectUserInfo(int mbrId) throws Exception {
        return session.selectOne(namespace + "selectUserInfo", mbrId);
    }

    /**
     * 회원이 보유하고 있는 총 포인트 금액을 가져온다.
     *
     * @param mbrId 장바구니를 조회할 사용자의 아이디
     * @return 회원이 보유하고 있는 총 포인트 금액
     * @throws Exception DB 조회 도중 발생할 수 있는 예외
     * @author min
     * @since  2023/07/07
     */
    @Override
    public int selectMemberTotalPoint(int mbrId) throws Exception {
        return session.selectOne(namespace + "selectMemberTotalPoint", mbrId);
    }

    /**
     * 회원이 보유하고 있는 쿠폰의 총 개수를 가져온다.
     *
     * @param mbrId 보유중인 쿠폰의 개수를 조회할 회원의 아이디
     * @return 해당 사용자의 장바구니에 담긴 상품들의 정보를 담은 List
     * @throws Exception DB 조회 도중 발생할 수 있는 예외
     * @author min
     * @since  2023/07/07
     */
    @Override
    public int memberCouponCnt(int mbrId) throws Exception {
        return session.selectOne(namespace + "memberCouponCnt", mbrId);
    }

}
