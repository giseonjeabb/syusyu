package com.teamProject.syusyu.dao.product.impl;

import com.teamProject.syusyu.dao.product.BOS_ReviewDAO;
import com.teamProject.syusyu.domain.cs.SearchCondition;
import com.teamProject.syusyu.domain.product.ReviewDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class BOS_ReviewDAOImpl implements BOS_ReviewDAO {

    @Autowired
    SqlSession session;

    String namespace = "com.teamProject.syusyu.BOS_ReviewMapper.";

    @Override
    public int count() throws Exception{
        return session.selectOne(namespace+"count");
    }


    @Override
    public ReviewDTO select(Integer prodId, Integer revwNo)throws Exception{
        Map map = new HashMap();
        map.put("revwNo",revwNo);
        map.put("prodId",prodId);
        return session.selectOne(namespace+"select",map);
    }

    @Override
    public List<ReviewDTO> selectAll(Integer prodId) throws Exception{
        return session.selectList(namespace+"selectAll",prodId);
    }

    @Override
    public int deleteAdmin(Integer revwNo) throws Exception{
       return session.delete(namespace+"deleteAdmin",revwNo);
    }

    @Override
    public List<ReviewDTO> SearchSelectPageReview(SearchCondition sc)throws Exception{
        List<ReviewDTO> reviewTest = session.selectList(namespace+"SearchSelectPageReview",sc);
        return reviewTest;
    }

    @Override
    public int SearchResultCntReview(SearchCondition sc)throws Exception{
        return session.selectOne(namespace+"SearchResultCntReview",sc);
    }


}
