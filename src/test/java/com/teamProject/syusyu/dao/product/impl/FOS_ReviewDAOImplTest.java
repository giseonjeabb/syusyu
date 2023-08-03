package com.teamProject.syusyu.dao.product.impl;

import com.teamProject.syusyu.dao.product.FOS_ReviewDAO;
import com.teamProject.syusyu.domain.product.ReviewDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class FOS_ReviewDAOImplTest {

    @Autowired
    FOS_ReviewDAO fosReviewDAO;

    @Test
    public void selectAll() throws Exception {
        assertNotNull(fosReviewDAO);
        System.out.println("fosReviewDAO = " + fosReviewDAO.selectAll(10002));
        
        //        Integer prodId = 10002;
//        List<ReviewDTO> reviewList = fosReviewDAO.selectAll(prodId);
//
//        for (ReviewDTO review : reviewList) {
//            System.out.println("review = " + review);
//        }
    }
}