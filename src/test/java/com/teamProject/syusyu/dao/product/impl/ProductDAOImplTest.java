package com.teamProject.syusyu.dao.product.impl;

import com.teamProject.syusyu.dao.product.ProductDAO;
import com.teamProject.syusyu.domain.product.ProductDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class ProductDAOImplTest {
    @Autowired
    ProductDAO productDAO;

    @Test
    public void getProductList() throws Exception {
//        System.out.println("productDAO : "+productDAO.getProductList(1,1));
        assertTrue(productDAO != null);
        System.out.println("productDAO = " + productDAO);

        assertTrue(productDAO.getProductList(2, 3).stream().count() == 0);
        System.out.println("productDAO : " + productDAO.getProductList(2, 3));


        assertTrue(productDAO.getProductList(1, 1) != null);
        System.out.println("productDAO : " + productDAO.getProductList(1, 1));
    }

    @Test
    public void selectProductStatusTest() throws Exception {
        // TODO product insert 생기면 insert하고 내가 넣은 상태값이랑 select 해온 상태값이란 같은지 검증해야 함
        List<ProductDTO> ProductStatus = productDAO.selectProductStatus(new int[]{10001, 10007});
        System.out.println("ProductStatus = " + ProductStatus);
    }
}