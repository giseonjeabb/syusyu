package com.teamProject.syusyu.service.bos.cs;

import com.teamProject.syusyu.domain.cs.FaqDTO;
import com.teamProject.syusyu.domain.cs.SearchCondition;

import java.util.List;
import java.util.Map;

public interface BOS_FaqService {
    int getCount() throws Exception;

    int remove(Integer faqNo, String writer) throws Exception;

    int write(FaqDTO faqDtO) throws Exception;

    List<FaqDTO> getList() throws Exception;

    FaqDTO read(Integer faqNo) throws Exception;

    List<FaqDTO> getPage(Map map) throws Exception;

    int modify(FaqDTO faqDto) throws Exception;

    int getSearchResultCnt(SearchCondition sc) throws Exception;

    List<FaqDTO> getSearchResultPage(SearchCondition sc) throws Exception;


}
