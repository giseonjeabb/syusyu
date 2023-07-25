package com.teamProject.syusyu.service.bos.order;

import com.teamProject.syusyu.dao.order.OrdDtlDAO;
import com.teamProject.syusyu.domain.order.OrdDtlDTO;
import com.teamProject.syusyu.domain.order.OrderInfoDTO;
import com.teamProject.syusyu.domain.order.request.OrderSearchRequestDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class BOS_OrderServiceImplTest {
    @Autowired
    BOS_OrderService service;

    @Autowired
    OrdDtlDAO ordDtlDAO;

    @Test
    public void getOrderList() throws Exception {
        OrderSearchRequestDTO orderSearchRequestDTO = OrderSearchRequestDTO.Builder.anOrderSearchRequestDTO()
                .startDate("2023-01-01")
                .endDate("2023-12-31")
                .ordStus("20")
//                .searchType("O.ORD_NO")
//                .searchKeyword("90")
                .build();

        List<OrderInfoDTO> orderInfoDTOList = service.getOrderList(orderSearchRequestDTO);
        System.out.println("orderInfoDTOList = " + orderInfoDTOList);

    }

    @Test
    public void confirmOrderTest() throws Exception {
        Integer[] ordDtlNoArr = new Integer[]{246, 247, 251, 255, 261};
        List<Integer> ordDtlNoList = Arrays.asList(ordDtlNoArr);
        service.confirmOrder(ordDtlNoList, 80001);

        for (Integer ordDtlNo : ordDtlNoArr) {
            OrdDtlDTO ordDtlDTO = ordDtlDAO.selectOrderDetail(ordDtlNo);
            assertEquals(ordDtlDTO.getOrdStus(), "20");
            assertNotNull(ordDtlDTO.getUpdDttm());
            assertNotNull(ordDtlDTO.getUpdrId());
        }
    }
}