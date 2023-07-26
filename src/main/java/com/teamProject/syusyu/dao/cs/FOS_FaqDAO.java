package com.teamProject.syusyu.dao.cs;

import com.teamProject.syusyu.domain.cs.FaqDTO;
import com.teamProject.syusyu.domain.cs.FaqSearchCondition;
import com.teamProject.syusyu.domain.cs.SearchCondition;

import java.util.List;
import java.util.Map;

public interface FOS_FaqDAO {
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


    /**
     * faqList.jsp 같은경우 페이징 처리를 하지 않고 한번에 보여주기에
     * FaqSearchConditiond을 만듬
     * FaqSearchCondition 은 page, pageSize가 존재 하지않는다
     * 검색 기능인 key, option만 존재
     * 그로인해 FOS,BOS 두개로 나누어서 DAO를 만들었따.
     * faqList.jsp 같은경우 페이징 처리를 하지 않고 한번에 보여주기에
     *
     *
     * @since  2023-07-25
     */
    List<FaqDTO> FosSearchSelectPage(FaqSearchCondition fsc) throws Exception;

    int FosSearchResultCnt(FaqSearchCondition fsc) throws Exception;





}
