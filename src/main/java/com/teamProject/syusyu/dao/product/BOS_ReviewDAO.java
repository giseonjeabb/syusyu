package com.teamProject.syusyu.dao.product;

import com.teamProject.syusyu.domain.cs.SearchCondition;
import com.teamProject.syusyu.domain.product.ReviewDTO;

import java.util.List;

public interface BOS_ReviewDAO {
    int count() throws Exception;

    ReviewDTO select(Integer prodId, Integer revwNo) throws Exception;

    List<ReviewDTO> selectAll(Integer prodId) throws Exception;

    int deleteAdmin(Integer revwNo) throws Exception;

    List<ReviewDTO> SearchSelectPageReview(SearchCondition sc)throws Exception;

    int SearchResultCntReview(SearchCondition sc)throws Exception;

}
