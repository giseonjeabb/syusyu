package com.teamProject.syusyu.service.bos.order;

import com.teamProject.syusyu.dao.order.DeliveryDAO;
import com.teamProject.syusyu.dao.order.OrdDtlDAO;
import com.teamProject.syusyu.domain.order.DeliveryDTO;
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

    @Autowired
    DeliveryDAO deliveryDAO;

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

    @Test
    public void dispatchOrderTest() throws Exception {
        // 1. positive test
        // 1-1. 필요한 데이터 세팅
        List<Integer> ordDtlNoList = Arrays.asList(246, 247, 251, 255, 261);
        List<String> dlvComList = Arrays.asList("1", "3", "5", "7", "9");
        List<String> trckNoList = Arrays.asList("123456789012", "987654321098", "456789123456", "654321987654", "789123456789");

        // 1-2. 발송처리 진행
        service.dispatchOrder(ordDtlNoList, dlvComList, trckNoList, 80001, "30");

        // 1-3. 데이터 검증
        // 1-3-1. delivery 테이블에 데이터 잘 들어갔는지 검증
        List<DeliveryDTO> list = deliveryDAO.selectAllDelivery();
        System.out.println("list = " + list);

        // 1-3-2. ord_dtl에 상태값 잘 바뀌었는지 확인
        // 1-3-3. ord_stus_hist에 데이터 잘 들어갔는지 검증

    }
}