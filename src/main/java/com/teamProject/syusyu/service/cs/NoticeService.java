package com.teamProject.syusyu.service.cs;

import com.teamProject.syusyu.domain.cs.NoticeDto;
import com.teamProject.syusyu.domain.cs.SearchCondition;

import java.util.List;
import java.util.Map;

public interface NoticeService {
    int getCount() throws Exception;

    int remove(Integer notcNo, String writer) throws Exception;

    int write(NoticeDto noticeDto) throws Exception;

    List<NoticeDto> getList() throws Exception;

    NoticeDto read(Integer notcNo) throws Exception;

    List<NoticeDto> getPage(Map map) throws Exception;

    int modify(NoticeDto noticeDto) throws Exception;

    int getSearchResultCnt(SearchCondition sc) throws Exception;

    List<NoticeDto> getSearchResultPage(SearchCondition sc) throws Exception;
}
