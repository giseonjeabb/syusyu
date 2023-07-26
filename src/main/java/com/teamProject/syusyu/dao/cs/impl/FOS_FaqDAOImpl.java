package com.teamProject.syusyu.dao.cs.impl;

import com.teamProject.syusyu.dao.cs.FOS_FaqDAO;
import com.teamProject.syusyu.domain.cs.FaqDTO;
import com.teamProject.syusyu.domain.cs.FaqSearchCondition;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class FOS_FaqDAOImpl implements FOS_FaqDAO {

    @Autowired
    SqlSession session;

    String namespace = "com.teamProject.syusyu.FOS_FaqMapper.";

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
    public int delete(Integer faqNo, String regrId) throws Exception{
        Map map = new HashMap();
        map.put("faqNo",faqNo);
        map.put("regrId",regrId);
        return session.delete(namespace+"delete",map);
    }

    @Override
    public int deleteAll() throws Exception{
        return session.delete(namespace+"deleteAll");
    }

    public List<FaqDTO> selectPage(Map map) throws Exception{
        return session.selectList(namespace + "selectPage", map);
    }

    public List<FaqDTO> FosSearchSelectPage(FaqSearchCondition fsc) throws Exception{
        List<FaqDTO> test = session.selectList(namespace+"FosSearchSelectPage", fsc);
        System.out.println("FOS_FaqList = " + test);
        return test;
    }

    public int FosSearchResultCnt(FaqSearchCondition fsc) throws Exception{
        return session.selectOne(namespace+"FosSearchResultCnt", fsc);
    }








}
