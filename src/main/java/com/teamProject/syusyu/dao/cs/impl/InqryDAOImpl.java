package com.teamProject.syusyu.dao.cs.impl;

import com.teamProject.syusyu.dao.cs.InqryDAO;
import com.teamProject.syusyu.domain.SearchCondition;
import com.teamProject.syusyu.domain.cs.InqryDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class InqryDAOImpl implements InqryDAO {
    @Autowired
    SqlSession session;

    String namespace = "com.teamProject.syusyu.InqryMapper.";

    @Override
    public InqryDTO select(Integer inqryNo) throws Exception {
        return session.selectOne(namespace + "select", inqryNo);
    }

    @Override
    public List<InqryDTO> selectAll() throws Exception {
        return session.selectList(namespace+"selectAll");
    }

    @Override
    public String content(Integer inqryNo) throws Exception{
        return session.selectOne(namespace+"content");
    };

    @Override
    public int count() throws Exception {
        return session.selectOne(namespace+"count");
    }

    @Override
    public int insert(InqryDTO dto) throws Exception {
        return session.insert(namespace+"insert", dto);
    }

    @Override
    public int update(InqryDTO dto) throws Exception {
        return session.update(namespace+"update", dto);
    }

    @Override
    public int updateAnswer(InqryDTO dto) {
        return session.update(namespace+"updateAnswer", dto);
    }

    @Override
    public int increaseViewCnt(Integer inqryNo) throws Exception {
        return 0;
    }

    @Override
    public int delete(Integer inqryNo, String regrId) throws Exception {
        Map map = new HashMap();
        map.put("inqryNo", inqryNo);
        map.put("regrId", regrId);
        return session.delete(namespace+"delete", map);
    }

    @Override
    public int deleteAll() throws Exception {
        return 0;
    }

    @Override
    public List<InqryDTO> selectPage(Map map) throws Exception {
        return session.selectList(namespace + "selectPage", map);
    }

    @Override
    public List<InqryDTO> searchSelectPage(SearchCondition sc) throws Exception {
        return null;
    }

    @Override
    public int searchResultCnt(SearchCondition sc) throws Exception {
        return 0;
    }

}