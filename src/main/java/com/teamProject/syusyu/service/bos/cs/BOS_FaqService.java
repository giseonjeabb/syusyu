package com.teamProject.syusyu.service.bos.cs;

import com.teamProject.syusyu.domain.cs.FaqDTO;
import com.teamProject.syusyu.domain.cs.SearchCondition;

import java.util.List;
import java.util.Map;

public interface BOS_FaqService {
    int getCount() throws Exception;

    int remove(Integer faqNo, Integer regrId) throws Exception;

    int write(FaqDTO faqDtO) throws Exception;

    List<FaqDTO> getList() throws Exception;

    FaqDTO read(Integer faqNo) throws Exception;

    List<FaqDTO> getPage(Map map) throws Exception;

    int modify(FaqDTO faqDto) throws Exception;


    List<FaqDTO> getBosSearchSelectPage(SearchCondition sc) throws Exception;

    int getBosSearchResultCnt(SearchCondition sc) throws Exception;

    FaqDTO getPrevTitle(Integer faqNo) throws Exception;

    FaqDTO getNextTitle(Integer faqNo) throws Exception;

}
