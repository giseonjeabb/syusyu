package com.teamProject.syusyu.service.bos.cs;

import com.teamProject.syusyu.domain.cs.NoticeDTO;
import com.teamProject.syusyu.domain.cs.SearchCondition;

import java.util.List;
import java.util.Map;

public interface B_NoticeService {
    int getCount() throws Exception;

    int remove(Integer notcNo) throws Exception;

    int write(NoticeDTO noticeDTO) throws Exception;

    List<NoticeDTO> getList() throws Exception;

    NoticeDTO read(Integer notcNo) throws Exception;


    List<NoticeDTO> getPage(Map map) throws Exception;

    int modify(NoticeDTO noticeDTO) throws Exception;

    int getSearchResultCnt(SearchCondition sc) throws Exception;

    List<NoticeDTO> getSearchResultPage(SearchCondition sc) throws Exception;

    NoticeDTO getPrevTitle(Integer notcNo) throws Exception;

    NoticeDTO getNextTitle(Integer notcNo) throws Exception;
}
