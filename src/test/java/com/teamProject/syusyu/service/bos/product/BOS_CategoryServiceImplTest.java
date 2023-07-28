package com.teamProject.syusyu.service.bos.product;

import com.teamProject.syusyu.service.fos.product.FOS_CategoryService;
import com.teamProject.syusyu.service.fos.product.FOS_ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class BOS_CategoryServiceImplTest {

    @Autowired
    FOS_CategoryService bosCategoryService;
    @Test
    public void getCategoryAllList() {
        System.out.println(bosCategoryService.getCategoryAllList());
    }
}