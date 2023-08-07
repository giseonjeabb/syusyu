package com.teamProject.syusyu.service.bos.product;

import com.teamProject.syusyu.domain.cs.SearchCondition;
import com.teamProject.syusyu.domain.product.ReviewDTO;

import java.util.List;

public interface BOS_ReviewService {
    int getCount() throws Exception;

    List<ReviewDTO> getList(Integer prodId) throws Exception;

    ReviewDTO read(Integer revwNo, Integer prodId) throws Exception;

    List<ReviewDTO> getSearchSelectPageReview(SearchCondition sc) throws Exception;

    int getSearchResultCntReview(SearchCondition sc) throws Exception;

    int removeAdmin(Integer revwNo)throws Exception;
}
