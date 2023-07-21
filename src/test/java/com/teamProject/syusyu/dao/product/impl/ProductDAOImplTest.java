package com.teamProject.syusyu.dao.product.impl;

import com.teamProject.syusyu.dao.product.ProdOptDAO;
import com.teamProject.syusyu.dao.product.ProductDAO;
import com.teamProject.syusyu.domain.product.ProdOptDTO;
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

    @Autowired
    ProdOptDAO prodOptDAO;

    @Test //상품조회리스트
    public void getProductList() throws Exception {
//        System.out.println("productDAO : "+productDAO.getProductList(1,1));
//        assertTrue(productDAO != null);
//        System.out.println("productDAO = " + productDAO);

//        assertTrue(productDAO.selectProductList(2, 3).stream().count() == 0);
        System.out.println("productDAO : " + productDAO.selectProductList(1, 1));


//        assertTrue(productDAO.selectProductList(1, 1) != null);
//        System.out.println("productDAO : " + productDAO.selectProductList(1, 1));
        System.out.println("dao: " + productDAO.selectProductAllList(1));
    }

    //    @Test //상품조회리스트
//    public void getProductAllList() throws Exception {
//        System.out.println("dao: "+ productDAO.selectProductAllList(1));
//    }
    @Test //상품조회
    public void selectProductTest() throws Exception {
        System.out.println("dao:" + productDAO.selectProduct(10002));
    }

    @Test
    public void selectProductStatusTest() throws Exception {
        // TODO product insert 생기면 insert하고 내가 넣은 상태값이랑 select 해온 상태값이란 같은지 검증해야 함
        List<ProductDTO> ProductStatus = productDAO.selectProductStatus(new int[]{10001, 10007});
        System.out.println("ProductStatus = " + ProductStatus);
    }

    @Test //상품 옵션 조회
    public void selectProdOptSizeList() {
        List<ProdOptDTO> optList = prodOptDAO.selectProdOptSizeList(10001);
        System.out.println("shoes : " + optList);
    }

}