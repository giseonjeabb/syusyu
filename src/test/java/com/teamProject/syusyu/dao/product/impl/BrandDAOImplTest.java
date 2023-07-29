package com.teamProject.syusyu.dao.product.impl;

import com.teamProject.syusyu.dao.product.BrandDAO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class BrandDAOImplTest {

    @Autowired
    BrandDAO brandDAO;
    @Test
    public void selectBrands() {
        System.out.println(brandDAO.selectBrandList());
    }
}