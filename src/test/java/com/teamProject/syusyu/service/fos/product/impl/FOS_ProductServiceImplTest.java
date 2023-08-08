package com.teamProject.syusyu.service.fos.product.impl;

import com.teamProject.syusyu.domain.product.ProductDTO;
import com.teamProject.syusyu.service.fos.product.FOS_ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})

public class FOS_ProductServiceImplTest {
    @Autowired
    FOS_ProductService service;
    @Test
    public void getDspyProductList() throws Exception {
        Map<String, List<ProductDTO>> mainProductList=service.getDspyProductList();
//        System.out.println(mainProductList.get("newProductList"));
//        System.out.println(mainProductList.get("pickProductList"));
        System.out.println(mainProductList.get("popularProductList"));
    }
}