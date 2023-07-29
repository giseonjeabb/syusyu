package com.teamProject.syusyu.service.bos.product.impl;

import com.teamProject.syusyu.service.bos.product.BOS_ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class BOS_ProductServiceImplTest {

    @Autowired
    BOS_ProductService bosProductService;
    @Test
    public void getProductInfo() throws Exception {
        System.out.println(bosProductService.getProductInfo().get("brands"));

    }
}