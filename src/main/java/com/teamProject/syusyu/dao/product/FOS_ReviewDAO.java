package com.teamProject.syusyu.dao.product;

import com.teamProject.syusyu.domain.product.ReviewDTO;

import java.util.List;

public interface FOS_ReviewDAO {
    int count()throws Exception;

    List<ReviewDTO> selectAll(Integer prodId) throws Exception;

    int insert(ReviewDTO reviewDTO) throws Exception;

    int increaseLikeCnt(Integer revwNo) throws Exception;

    int update(ReviewDTO reviewDTO) throws Exception;

    int deleteUser(Integer revwNo, Integer regrId) throws Exception;

}
