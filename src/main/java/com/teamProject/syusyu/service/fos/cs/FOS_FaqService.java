package com.teamProject.syusyu.service.fos.cs;

import com.teamProject.syusyu.domain.cs.FaqDTO;
import com.teamProject.syusyu.domain.cs.FaqSearchCondition;
import com.teamProject.syusyu.domain.cs.NoticeDTO;
import com.teamProject.syusyu.domain.cs.SearchCondition;

import java.util.List;
import java.util.Map;

public interface FOS_FaqService {
    int getCount() throws Exception;

    int remove(Integer faqNo, String writer) throws Exception;

    int write(FaqDTO faqDtO) throws Exception;

    List<FaqDTO> getList() throws Exception;

    FaqDTO read(Integer faqNo) throws Exception;

    List<FaqDTO> getPage(Map map) throws Exception;

    int modify(FaqDTO faqDto) throws Exception;

    int getFosSearchResultCnt(FaqSearchCondition fsc) throws Exception;

    List<FaqDTO> getFosSearchSelectPage(FaqSearchCondition fsc) throws Exception;


    FaqDTO getPrevTitle(Integer faqNo) throws Exception;

    FaqDTO getNextTitle(Integer faqNo) throws Exception;



}
