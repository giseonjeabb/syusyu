package com.teamProject.syusyu.service.product.impl;

import com.teamProject.syusyu.service.product.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

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
}