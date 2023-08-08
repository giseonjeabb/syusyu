package com.teamProject.syusyu.service.fos.product.impl;

import com.teamProject.syusyu.dao.product.FOS_ReviewDAO;
import com.teamProject.syusyu.domain.product.ReviewDTO;
import com.teamProject.syusyu.service.fos.product.FOS_ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FOS_ReviewServiceImpl implements FOS_ReviewService {

    FOS_ReviewDAO fosReviewDAO;

    @Autowired
    public FOS_ReviewServiceImpl(FOS_ReviewDAO fosReviewDAO) {
        this.fosReviewDAO = fosReviewDAO;
    }

    @Override
    public int getCount()throws Exception{
        return fosReviewDAO.count();
    }

    @Override
    public List<ReviewDTO> getList(Integer prodId) throws Exception{
        return fosReviewDAO.selectAll(prodId);
    }

    @Override
    public int write(ReviewDTO reviewDTO)throws Exception{
        return fosReviewDAO.insert(reviewDTO);
    }


    @Override
    public int LikeCnt(Integer revwNo)throws Exception{
        return fosReviewDAO.increaseLikeCnt(revwNo);

    }
    @Override
    public int modify(ReviewDTO reviewDTO)throws Exception{
        return fosReviewDAO.update(reviewDTO);
    }

    @Override
    public int removeUser(Integer revwNo, Integer regrId)throws Exception{
        return fosReviewDAO.deleteUser(revwNo,regrId);
    }



}
