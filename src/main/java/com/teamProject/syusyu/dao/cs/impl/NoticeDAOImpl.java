package com.teamProject.syusyu.dao.cs.impl;

import com.teamProject.syusyu.dao.cs.NoticeDAO;
import com.teamProject.syusyu.domain.cs.NoticeDTO;
import com.teamProject.syusyu.domain.cs.SearchCondition;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class NoticeDAOImpl implements NoticeDAO {
    @Autowired
    SqlSession session;

    String namespace = "com.teamProject.syusyu.NoticeMapper.";

    @Override
    public NoticeDTO select(Integer notcNo) throws Exception{
        return  session.selectOne(namespace+"select",notcNo);
    }

    public NoticeDTO selectPrev(Integer notcNo)throws Exception{
        return  session.selectOne(namespace+"selectPrev",notcNo);
    }


    public NoticeDTO selectNext(Integer notcNo)throws Exception{
        return  session.selectOne(namespace+"selectNext",notcNo);
    }

    @Override
    public List<NoticeDTO> selectAll() throws Exception{
        return session.selectList(namespace+"selectAll");
    }

    @Override
    public int count() throws Exception{
        return session.selectOne(namespace+"count");
    }

    @Override
    public int insert(NoticeDTO dto) throws Exception{
        return session.insert(namespace+"insert",dto);
    }

    @Override
    public int update(NoticeDTO dto) throws Exception{
        return session.update(namespace+"update",dto);
    }

    @Override
    public int increaseViewCnt(Integer notcNo) throws Exception{
        return session.update(namespace+"increaseViewCnt",notcNo);
    }

    @Override
    public int delete(Integer notcNo) throws Exception{
//        Map map = new HashMap();
//        map.put("notcNo",notcNo);
//        map.put("regrId",regrId);
        return session.delete(namespace+"delete",notcNo);
    }

    @Override
    public int deleteAll() throws Exception{
        return session.delete(namespace+"deleteAll");
    }

    @Override
    public List<NoticeDTO> selectPage(Map map) throws Exception{
        return session.selectList(namespace + "selectPage", map);
    }

    @Override
    public List<NoticeDTO> searchSelectPage(SearchCondition sc) throws Exception{
        List<NoticeDTO> test = session.selectList(namespace+"searchSelectPage", sc);
        System.out.println("noticetest = " + test);
        return test;
    }

    @Override
    public int searchResultCnt(SearchCondition sc) throws Exception{
        return session.selectOne(namespace+"searchResultCnt",sc);
    }

}
