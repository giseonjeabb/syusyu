package com.teamProject.syusyu.dao.cs;

import com.teamProject.syusyu.domain.cs.FaqDTO;
import com.teamProject.syusyu.domain.cs.SearchCondition;

import java.util.List;
import java.util.Map;

public interface BOS_FaqDAO {
    FaqDTO select(Integer faqNo) throws Exception;

    FaqDTO selectPrev(Integer faqNo) throws Exception;

    FaqDTO selectNext(Integer faqNo) throws Exception;

    List<FaqDTO> selectAll() throws Exception;

    int count() throws Exception;

    int insert(FaqDTO dto) throws Exception;

    int update(FaqDTO dto) throws Exception;

    int delete(Integer faqNo, Integer regrId) throws Exception;

    int deleteAll() throws Exception;

    List<FaqDTO> selectPage(Map map) throws Exception;

    /**
     * 관리자 FAQ목록 .jsp 같은경우 페이징 처리를 하기에
     * SearchConditiond을 사용
     * SearchCondition 은 page, pageSize가 존재 함
     * 그로인해 FOS,BOS 두개로 나누어서 DAO를 만들었따.
     *
     * @since  2023-07-25
     */
    List<FaqDTO> BosSearchSelectPage(SearchCondition sc) throws Exception;

    int BosSearchResultCnt(SearchCondition sc) throws Exception;
}
