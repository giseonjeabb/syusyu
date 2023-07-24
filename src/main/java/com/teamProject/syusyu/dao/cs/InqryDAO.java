package com.teamProject.syusyu.dao.cs;

import com.teamProject.syusyu.domain.SearchCondition;
import com.teamProject.syusyu.domain.cs.InqryDTO;

import java.util.List;
import java.util.Map;

public interface InqryDAO {

    InqryDTO select(Integer INQRY_NO) throws Exception;

    List<InqryDTO> selectAll() throws Exception;

    String content(Integer inqryNo) throws Exception;

    int count() throws Exception;

    int insert(InqryDTO dto) throws Exception; // 등록

    int update(InqryDTO dto) throws Exception; // 수정

    int increaseViewCnt(Integer inqryNo) throws Exception;

    int delete(Integer inqryNo, String regrId) throws Exception; // 삭제

    int deleteAll() throws Exception; //전체 삭제

    List<InqryDTO> selectPage(Map map) throws Exception;

    List<InqryDTO> searchSelectPage(SearchCondition sc) throws Exception;

    int searchResultCnt(SearchCondition sc) throws Exception;

}
