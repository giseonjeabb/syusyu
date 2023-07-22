package com.teamProject.syusyu.service.product.impl;

import com.teamProject.syusyu.service.fos.product.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class ProductServiceImplTest {

    @Autowired
    ProductService productService;

    @Test
    public void getProductList() throws Exception{
        System.out.println(productService.getProductList(1,1));
        System.out.println(productService.getProductAllList(1));


    }

    @Test //상품조회
    public void getProductTest() throws Exception{
        System.out.println("dao:"+ productService.getProduct(10002));
    }
}