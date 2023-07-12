package com.teamProject.syusyu.dao.cs.impl;

import com.teamProject.syusyu.dao.cs.FaqDAO;
import com.teamProject.syusyu.domain.cs.FaqDTO;
import com.teamProject.syusyu.domain.cs.FaqSearchCondition;
import com.teamProject.syusyu.domain.cs.SearchCondition;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class FaqDAOImpl implements FaqDAO {

    @Autowired
    SqlSession session;

    String namespace = "com.teamProject.syusyu.FaqMapper.";

    @Override
    public FaqDTO selectFaq(Integer faqNo) throws Exception{
        return session.selectOne(namespace+"selectFaq", faqNo);
    }

    @Override
    public FaqDTO selectPrevFaq(Integer faqNo) throws Exception{
        return session.selectOne(namespace+"selectPrevFaq",faqNo);
    }

    @Override
    public FaqDTO selectNextFaq(Integer faqNo) throws Exception{
        return session.selectOne(namespace+"selectNextFaq",faqNo);
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
    public int insertFaq(FaqDTO dto) throws Exception{
        return session.insert(namespace+"insertFaq",dto);
    }

    @Override
    public int updateFaq(FaqDTO dto) throws Exception{
        return session.update(namespace+"updateFaq",dto);
    }


    @Override
    public int deleteFaq(Integer faqNo, String regrId) throws Exception{
        Map map = new HashMap();
        map.put("faqNo",faqNo);
        map.put("regrId",regrId);
        return session.delete(namespace+"deleteFaq",map);
    }

    @Override
    public int deleteAll() throws Exception{
        return session.delete(namespace+"deleteAll");
    }

    public List<FaqDTO> selectPage(Map map) throws Exception{
        return session.selectList(namespace + "selectPageFaq", map);
    }

    public List<FaqDTO> searchSelectPage(FaqSearchCondition fsc) throws Exception{
        List<FaqDTO> test = session.selectList(namespace+"searchSelectPageFaq", fsc);
        System.out.println("test = " + test);
        return test;
    }

    public int searchResultCnt(FaqSearchCondition fsc) throws Exception{
        return session.selectOne(namespace+"searchResultCntFaq", fsc);
    }

    public List<FaqDTO> selectFaqTp(String faqTp)throws Exception{
        return session.selectList(namespace+"selectFaqTp",faqTp);
    }








}
