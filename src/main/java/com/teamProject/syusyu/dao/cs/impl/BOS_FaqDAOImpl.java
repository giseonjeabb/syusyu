package com.teamProject.syusyu.dao.cs.impl;

import com.teamProject.syusyu.dao.cs.BOS_FaqDAO;
import com.teamProject.syusyu.domain.cs.FaqDTO;
import com.teamProject.syusyu.domain.cs.SearchCondition;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class BOS_FaqDAOImpl implements BOS_FaqDAO {


    @Autowired
    SqlSession session;

    String namespace = "com.teamProject.syusyu.BOS_FaqMapper.";

    @Override
    public FaqDTO select(Integer faqNo) throws Exception{
        return session.selectOne(namespace+"select", faqNo);
    }

    @Override
    public FaqDTO selectPrev(Integer faqNo) throws Exception{
        return session.selectOne(namespace+"selectPrev",faqNo);
    }

    @Override
    public FaqDTO selectNext(Integer faqNo) throws Exception{
        return session.selectOne(namespace+"selectNext",faqNo);
    }

    @Override
    public List<FaqDTO> selectAll() throws Exception{
        return session.selectList(namespace+"selectAll");
    }

    @Override
    public int count() throws Exception{
        return session.selectOne(namespace+"count");
    }

    @Override
    public int insert(FaqDTO dto) throws Exception{
        return session.insert(namespace+"insert",dto);
    }

    @Override
    public int update(FaqDTO dto) throws Exception{
        return session.update(namespace+"update",dto);
    }


    @Override
    public int delete(Integer faqNo, Integer regrId) throws Exception{
        Map map = new HashMap();
        map.put("faqNo",faqNo);
        map.put("regrId",regrId);
        return session.delete(namespace+"delete",map);
    }

    @Override
    public int deleteAll() throws Exception{
        return session.delete(namespace+"deleteAll");
    }

    @Override
    public List<FaqDTO> selectPage(Map map) throws Exception{
        return session.selectList(namespace + "selectPage", map);
    }



    @Override
    public List<FaqDTO> BosSearchSelectPage(SearchCondition sc) throws Exception{
        List<FaqDTO> test = session.selectList(namespace+"BosSearchSelectPage", sc);
        System.out.println("BOS_FaqLIST = " + test);
        return test;
    }

    @Override
    public int BosSearchResultCnt(SearchCondition sc) throws Exception{
        return session.selectOne(namespace+"BosSearchResultCnt", sc);
    }


}
