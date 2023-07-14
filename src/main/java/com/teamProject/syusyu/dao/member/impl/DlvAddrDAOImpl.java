package com.teamProject.syusyu.dao.member.impl;

import com.teamProject.syusyu.dao.member.DlvAddrDAO;
import com.teamProject.syusyu.domain.member.DlvAddrDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DlvAddrDAOImpl implements DlvAddrDAO {
    private final SqlSession session;
    private static final String namespace = "com.teamProject.syusyu.dlvAddrMapper.";

    @Autowired
    public DlvAddrDAOImpl(SqlSession session) {
        this.session = session;
    }

    /**
     * 회원의 기본배송지를 조회해온다.
     *
     * @param mbrId 기본배송지를 조회할 사용자의 아이디
     * @return 기본배송지 정보
     * @throws Exception DB 조회 도중 발생할 수 있는 예외
     * @author min
     * @since  2023/07/07
     */
    @Override
    public DlvAddrDTO selectDefaultDlvAddr(int mbrId) throws Exception {
        return session.selectOne(namespace + "selectDefaultDlvAddr", mbrId);
    }

    /**
     * 회원의 배송지 리스트를 조회해온다.
     *
     * @param mbrId 배송지 리스트를 조회할 사용자의 아이디
     * @return 배송지 정보 리스트
     * @throws Exception DB 조회 도중 발생할 수 있는 예외
     * @author min
     * @since  2023/07/14
     */
    @Override
    public List<DlvAddrDTO> selectAllDlvAddr(int mbrId) throws Exception {
        return session.selectList(namespace + "selectAllDlvAddr", mbrId);
    }

}
