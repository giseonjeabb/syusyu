package com.teamProject.syusyu.service.bos.order;

import com.teamProject.syusyu.domain.order.OrderInfoDTO;
import com.teamProject.syusyu.domain.order.request.OrderSearchRequestDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class BOS_OrderServiceImplTest {
    @Autowired
    BOS_OrderService service;

    @Test
    public void getOrderList() throws Exception {
        OrderSearchRequestDTO orderSearchRequestDTO = OrderSearchRequestDTO.Builder.anOrderSearchRequestDTO()
                .startDate("2023-01-01")
                .endDate("2023-12-31")
                .searchType("O.ORD_NO")
                .searchKeyword("90")
                .build();

        List<OrderInfoDTO> orderInfoDTOList = service.getOrderList(orderSearchRequestDTO);
        System.out.println("orderInfoDTOList = " + orderInfoDTOList);

    }
}