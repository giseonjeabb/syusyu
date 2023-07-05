package com.teamProject.syusyu.dao.cs;

import com.teamProject.syusyu.domain.cs.FaqDTO;
import com.teamProject.syusyu.domain.cs.SearchCondition;

import java.util.List;
import java.util.Map;

public interface FaqDAO {
    FaqDTO selectFaq(Integer faqNo) throws Exception;

    FaqDTO selectPrevFaq(Integer faqNo) throws Exception;

    FaqDTO selectNextFaq(Integer faqNo) throws Exception;

    List<FaqDTO> selectAll() throws Exception;

    int count() throws Exception;

    int insertFaq(FaqDTO dto) throws Exception;

    int updateFaq(FaqDTO dto) throws Exception;

    int deleteFaq(Integer faqNo, String regrId) throws Exception;

    int deleteAll() throws Exception;

    List<FaqDTO> selectPage(Map map) throws Exception;

    List<FaqDTO> searchSelectPage(SearchCondition sc) throws Exception;

    int searchResultCnt(SearchCondition sc) throws Exception;
}
