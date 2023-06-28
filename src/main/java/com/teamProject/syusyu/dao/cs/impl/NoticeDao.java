package com.teamProject.syusyu.dao.cs.impl;

import com.teamProject.syusyu.domain.cs.NoticeDto;
import com.teamProject.syusyu.domain.cs.SearchCondition;

import java.util.List;
import java.util.Map;

public interface NoticeDao {
    NoticeDto select(Integer notcNo) throws Exception;

    List<NoticeDto> selectAll() throws Exception;

    int count() throws Exception;

    int insert(NoticeDto dto) throws Exception;

    int update(NoticeDto dto) throws Exception;

    int increaseViewCnt(Integer notcNo) throws Exception;

    int delete(Integer notcNo, String regrId) throws Exception;

    int deleteAll() throws Exception;

    List<NoticeDto> selectPage(Map map) throws Exception;

    List<NoticeDto> searchSelectPage(SearchCondition sc) throws Exception;

    int searchResultCnt(SearchCondition sc) throws Exception;
}
