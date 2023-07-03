package com.teamProject.syusyu.dao.cs.impl;

import com.teamProject.syusyu.domain.cs.NoticeDto;
import com.teamProject.syusyu.domain.cs.SearchCondition;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class NoticeDaoImpl implements NoticeDao {
    @Autowired
    SqlSession session;

    String namespace = "com.teamProject.syusyu.NoticeMapper.";

    @Override
    public NoticeDto select(Integer notcNo) throws Exception{
        return  session.selectOne(namespace+"select",notcNo);
    }

    public NoticeDto selectPrev(Integer notcNo)throws Exception{
        return  session.selectOne(namespace+"selectPrev",notcNo);
    }


    public NoticeDto selectNext(Integer notcNo)throws Exception{
        return  session.selectOne(namespace+"selectNext",notcNo);
    }

    @Override
    public List<NoticeDto> selectAll() throws Exception{
        return session.selectList(namespace+"selectAll");
    }

    @Override
    public int count() throws Exception{
        return session.selectOne(namespace+"count");
    }

    @Override
    public int insert(NoticeDto dto) throws Exception{
        return session.insert(namespace+"insert",dto);
    }

    @Override
    public int update(NoticeDto dto) throws Exception{
        return session.update(namespace+"update",dto);
    }

    @Override
    public int increaseViewCnt(Integer notcNo) throws Exception{
        return session.update(namespace+"increaseViewCnt",notcNo);
    }

    @Override
    public int delete(Integer notcNo, String regrId) throws Exception{
        Map map = new HashMap();
        map.put("notcNo",notcNo);
        map.put("regrID",regrId);
        return session.delete(namespace+"delete",map);
    }

    @Override
    public int deleteAll() throws Exception{
        return session.delete(namespace+"deleteAll");
    }

    @Override
    public List<NoticeDto> selectPage(Map map) throws Exception{
        return session.selectList(namespace + "selectPage", map);
    }

    @Override
    public List<NoticeDto> searchSelectPage(SearchCondition sc) throws Exception{
        List<NoticeDto> test = session.selectList(namespace+"searchSelectPage", sc);
        System.out.println("test = " + test);
        return test;
    }

    @Override
    public int searchResultCnt(SearchCondition sc) throws Exception{
        return session.selectOne(namespace+"searchResultCnt",sc);
    }

}
