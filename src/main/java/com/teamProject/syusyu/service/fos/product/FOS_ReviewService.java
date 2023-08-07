package com.teamProject.syusyu.service.fos.product;

import com.teamProject.syusyu.domain.product.ReviewDTO;

import java.util.List;

public interface FOS_ReviewService {
    int getCount() throws Exception;

    List<ReviewDTO> getList(Integer prodId) throws Exception;

    int write(ReviewDTO reviewDTO) throws Exception;

    int LikeCnt(Integer revwNo) throws Exception;

    int modify(ReviewDTO reviewDTO) throws Exception;

    int removeUser(Integer revwNo, Integer regrId) throws Exception;


}
