package com.teamProject.syusyu.dao.product.impl;

import com.teamProject.syusyu.dao.product.ProdOptDAO;
import com.teamProject.syusyu.dao.product.ProductDAO;
import com.teamProject.syusyu.domain.product.ProdOptDTO;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class ProdOptDAOImplTest extends TestCase {
    @Autowired
    private ProdOptDAO prodOptDAO;

    @Test
    public void testSelectProductQty() throws Exception {
        List<ProdOptDTO> prodOptDTOList = prodOptDAO.selectProductQty(new int[]{820, 830});
        System.out.println("prodOptDTOList = " + prodOptDTOList);
    }

    @Test
    public void decreaseProdQtyTest() throws Exception {
        Map<String, Integer> param = new HashMap<>();
        param.put("qty", 2);
        param.put("optCombNo", 2);

        prodOptDAO.decreaseProdQty(param);
    }

    @Test
    public void updateProdQtyTest() throws Exception {
        Map<String, Integer> param = new HashMap<>();
        param.put("invQty", 2);
        param.put("optCombNo", 2);

        prodOptDAO.updateProdQty(param);
    }
}