package com.teamProject.syusyu.dao.product.impl;

import com.teamProject.syusyu.dao.product.ProductDAO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class ProductDAOImplTest {
    @Autowired
    ProductDAO productDAO;

    @Test //상품조회리스트
    public void getProductList() throws Exception{
//        System.out.println("productDAO : "+productDAO.getProductList(1,1));
        assertTrue(productDAO!=null);
        System.out.println("productDAO = "+productDAO);

        assertTrue(productDAO.selectProductList(2,3).stream().count()==0);
            System.out.println("productDAO : "+productDAO.selectProductList(2,3));


        assertTrue(productDAO.selectProductList(1,1)!=null);
        System.out.println("productDAO : "+productDAO.selectProductList(1,1));





    }




}