package com.teamProject.syusyu.dao.product.impl;

import com.teamProject.syusyu.dao.product.FOS_ReviewDAO;
import com.teamProject.syusyu.domain.product.ReviewDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class FOS_ReviewDAOImpl implements FOS_ReviewDAO {

    @Autowired
    SqlSession session;

    String namespace = "com.teamProject.syusyu.ReviewMapper.";

    @Override
    public int count() throws Exception{
        return session.selectOne(namespace+"count");
    }

    @Override
    public List<ReviewDTO> selectAll(Integer prodId) throws Exception{
        return session.selectList(namespace+"selectAll",prodId);
    }

    @Override
    public int insert(ReviewDTO reviewDTO)throws Exception{
        return session.insert(namespace+"insert",reviewDTO);
    }

    @Override
    public int increaseLikeCnt(Integer revwNo)throws Exception{
        return session.update(namespace+"increaseLikeCnt",revwNo);
    }

    @Override
    public int update(ReviewDTO reviewDTO)throws Exception{
        return session.update(namespace+"update",reviewDTO);
    }

    @Override
    public int deleteUser(Integer revwNo, Integer regrId)throws Exception{
        Map m = new HashMap();
        m.put("revwNo",revwNo);
        m.put("regrId",regrId);
        return session.delete(namespace+"deleteUser",m);
    }

 }
