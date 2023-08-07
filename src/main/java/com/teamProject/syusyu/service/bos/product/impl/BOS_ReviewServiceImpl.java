package com.teamProject.syusyu.service.bos.product.impl;

import com.teamProject.syusyu.dao.product.BOS_ReviewDAO;
import com.teamProject.syusyu.domain.cs.SearchCondition;
import com.teamProject.syusyu.domain.product.ReviewDTO;
import com.teamProject.syusyu.service.bos.product.BOS_ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BOS_ReviewServiceImpl implements BOS_ReviewService {


    private BOS_ReviewDAO reviewDAO;
    @Autowired
    public BOS_ReviewServiceImpl(BOS_ReviewDAO reviewDAO) {
        this.reviewDAO = reviewDAO;
    }


    @Override
    public int getCount() throws Exception{
        return reviewDAO.count();
    }

    @Override
    public List<ReviewDTO> getList(Integer prodId)throws Exception{
        return reviewDAO.selectAll(prodId);
    }

    @Override
    public ReviewDTO read(Integer revwNo, Integer prodId)throws Exception{
        return reviewDAO.select(prodId,revwNo);
    }

    @Override
    public int removeAdmin(Integer revwNo)throws Exception{
        return reviewDAO.deleteAdmin(revwNo);
    }

    @Override
    public List<ReviewDTO> getSearchSelectPageReview(SearchCondition sc)throws Exception{
        return reviewDAO.SearchSelectPageReview(sc);
    }

    @Override
    public int getSearchResultCntReview(SearchCondition sc)throws Exception{
        return reviewDAO.SearchResultCntReview(sc);
    }
}
