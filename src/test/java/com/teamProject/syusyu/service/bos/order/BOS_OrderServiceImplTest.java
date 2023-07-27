package com.teamProject.syusyu.service.bos.order;

import com.teamProject.syusyu.dao.order.OrdDtlDAO;
import com.teamProject.syusyu.domain.order.OrdDtlDTO;
import com.teamProject.syusyu.domain.order.request.OrderSearchRequestDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class BOS_OrderServiceImplTest {
    @Autowired
    BOS_OrderService service;

    @Autowired
    OrdDtlDAO ordDtlDAO;

    @Test
    public void getOrderList() throws Exception {
        List<String> ordStusList = Arrays.asList("10", "20", "30", "37", "40", "50", "60", "70");
        OrderSearchRequestDTO orderSearchRequestDTO = OrderSearchRequestDTO.Builder.anOrderSearchRequestDTO()
                .startDate("2023-01-01")
                .endDate("2023-12-31")
                .ordStus(ordStusList)
//                .searchType("O.ORD_NO")
//                .searchKeyword("90")
                .build();

        Map<String, Object> result = service.getOrderList(orderSearchRequestDTO);
        System.out.println("orderInfoDTOList = " + result);

    }

    @Test
    public void confirmOrderTest() throws Exception {
        String ordStus = "30";
        Integer[] ordDtlNoArr = new Integer[]{246, 247, 251, 255, 261};
        List<Integer> ordDtlNoList = Arrays.asList(ordDtlNoArr);
        service.processUpdateOrderStatus(ordDtlNoList, 80001, ordStus);

        for (Integer ordDtlNo : ordDtlNoArr) {
            OrdDtlDTO ordDtlDTO = ordDtlDAO.selectOrderDetail(ordDtlNo);
            assertEquals(ordDtlDTO.getOrdStus(), ordStus);
            assertNotNull(ordDtlDTO.getUpdDttm());
            assertNotNull(ordDtlDTO.getUpdrId());
        }
    }
}