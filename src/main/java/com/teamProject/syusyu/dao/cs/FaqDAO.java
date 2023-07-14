package com.teamProject.syusyu.dao.cs;

import com.teamProject.syusyu.domain.cs.FaqDTO;
import com.teamProject.syusyu.domain.cs.FaqSearchCondition;
import com.teamProject.syusyu.domain.cs.SearchCondition;

import java.util.List;
import java.util.Map;

public interface FaqDAO {
    FaqDTO select(Integer faqNo) throws Exception;

    FaqDTO selectPrev(Integer faqNo) throws Exception;

    FaqDTO selectNext(Integer faqNo) throws Exception;

    List<FaqDTO> selectAll() throws Exception;

    int count() throws Exception;

    int insert(FaqDTO dto) throws Exception;

    int update(FaqDTO dto) throws Exception;

    int delete(Integer faqNo, String regrId) throws Exception;

    int deleteAll() throws Exception;

    List<FaqDTO> selectPage(Map map) throws Exception;

    List<FaqDTO> searchSelectPage(FaqSearchCondition fsc) throws Exception;

    int searchResultCnt(FaqSearchCondition fsc) throws Exception;





}
