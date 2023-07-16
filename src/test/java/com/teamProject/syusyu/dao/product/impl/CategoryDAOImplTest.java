package com.teamProject.syusyu.dao.product.impl;

import com.teamProject.syusyu.dao.product.CategoryDAO;
import com.teamProject.syusyu.domain.product.CategoryDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class CategoryDAOImplTest {

    @Autowired
    CategoryDAO categoryDAO;

    @Test //카테고리 리스트 테스트
    public void selectCategoryList() throws Exception {
        System.out.println("categoryDTO = " + categoryDAO.selectCategoryAllList());

    }
}