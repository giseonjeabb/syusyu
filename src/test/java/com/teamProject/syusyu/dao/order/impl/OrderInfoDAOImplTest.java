package com.teamProject.syusyu.dao.order.impl;

import com.teamProject.syusyu.dao.order.OrderInfoDAO;
import com.teamProject.syusyu.domain.order.OrderInfoDTO;
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
public class OrderInfoDAOImplTest {
    @Autowired
    OrderInfoDAO orderInfoDAO;

    @Test
    public void selectOrderInfo() throws Exception {
        Map<String, Object> param = new HashMap<>();
        param.put("mbrId", 80001);
        param.put("startDate", "2023-01-01");
        param.put("endDate", "2023-12-01");

        List<OrderInfoDTO> list = orderInfoDAO.selectOrderList(param);
//        System.out.println("list = " + list);

        param.forEach((k, y) -> System.out.println("key: " + k + " value: " + y));
    }

    @Test
    public void countByOrdStusTest() throws Exception {
        List<Map<String, Integer>> list = orderInfoDAO.countByOrdStus();
        System.out.println("list = " + list);
    }
}