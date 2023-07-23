package com.teamProject.syusyu.service.order;

import com.teamProject.syusyu.dao.order.*;
import com.teamProject.syusyu.domain.order.*;
import com.teamProject.syusyu.domain.order.request.OrderProductRequestDTO;
import com.teamProject.syusyu.domain.order.request.OrderRequestDTO;
import com.teamProject.syusyu.service.fos.order.FOS_OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class FOS_OrderServiceImplTest {
    @Autowired
    FOS_OrderService service;
    @Autowired
    OrdDAO ordDAO;
    @Autowired
    OrdDtlDAO ordDtlDAO;
    @Autowired
    OrdStusHistDAO ordStusHistDAO;
    @Autowired
    PayDAO payDAO;
    @Autowired
    PayRsltDAO payRsltDAO;
    @Autowired
    OrdDlvAddrDAO ordDlvAddrDAO;

    //@Before
    // 테스트 시작 전에 먼저 수행되는 메서드. 주문 관련 정보를 삭제한다.
    public void beforeEach() throws Exception {
        // 6. ORD_DLV_ADDR 테이블 데이터 삭제
        ordDlvAddrDAO.deleteAllOrdDlvAddr();
        int result = ordDlvAddrDAO.countOrdDlvAddr();

        assertEquals(0, result);

        // 5. PAY_RSLT 테이블 데이터 삭제
        payRsltDAO.deleteAllPayResult();
        result = payRsltDAO.countPayResult();
        assertEquals(0, result);

        // 4. PAY 테이블 데이터 삭제
        payDAO.deleteAllPay();
        result = payDAO.countPay();
        assertEquals(0, result);

        // 3. ORD_STUS_HIST 테이블 데이터 삭제
        ordStusHistDAO.deleteAllOrderStatusHistory();
        result = ordStusHistDAO.countOrderStatusHistory();
        assertEquals(0, result);

        // 2. ORD_DTL 테이블 데이터 삭제
        ordDtlDAO.deleteAllOrderDetail();
        result = ordDtlDAO.countOrderDetail();
        assertEquals(0, result);

        // 1. ORD 테이블 데이터 삭제
        ordDAO.deleteAllOrder();
        result = ordDAO.countOrd();
        assertEquals(0, result);
    }

    @Test
    // 주문 생성 후 컴퓨티드 컬럼들 의도한대로 잘 들어갔는지 데이터 검증
    public void validationOrderData() {
        // 주문 시 필요한 데이터 생성
        Order order = getOrder();

        // 주문을 생성한다.
        try {
            service.order(order);
        } catch (Exception e) {
            e.printStackTrace();
            fail("주문 생성 실패");
        }

        // 주문 생성 후 컴퓨티드 컬럼들 의도한대로 잘 들어갔는지 검증한다.
    }

    @Test
    // 주문 생성 후 존재여부 검증
    public void orderExistence() throws Exception {
        // 주문 시 필요한 데이터 생성
        Order order = getOrder();

        // TODO 데이터 세팅이 잘 되었는지 테스트 필요

        // 주문을 생성한다.
        try {
            service.order(order);
        } catch (Exception e) {
            e.printStackTrace();
            fail("주문 생성 실패");
        }

        // 1. 일단 insert한 데이터가 존재하는지 테스트부터 하자.

        // 1-1. ORD
        OrdDTO ordDTO = ordDAO.selectOrder(order.getOrd().getOrdNo());
        assertNotNull(ordDTO);
        System.out.println("ordDTO = " + ordDTO);

        // 1-2. ORD_DTL
        List<OrdDtlDTO> ordDtlDTOList = order.getOrdDtlList();
        ordDtlDTOList.forEach(ordDtlDTO -> {
            try {
                OrdDtlDTO result = ordDtlDAO.selectOrderDetail(ordDtlDTO.getOrdDtlNo());
                System.out.println("result = " + result);
                assertNotNull(result);
            } catch (Exception e) {
                fail("주문 상세 insert 후 select실패");
            }
        });

        // 얘는 여러개잖아
        // 1-3. ORD_STUS_HIST
        List<OrdStusHistDTO> ordStusHistDTOList = order.getOrdStusHistList();
        ordStusHistDTOList.forEach(ordStusHistDTO -> {
            try {
                OrdStusHistDTO ordStusHistDTOResult = ordStusHistDAO.selectOrderStatusHistory(ordStusHistDTO.getOrdStusHistNo());
                System.out.println("ordStusHistDTOResult = " + ordStusHistDTOResult);
                assertNotNull(ordStusHistDTOResult);
            } catch (Exception e) {
                fail("주문상태이력 insert 후 select 실패");
            }
        });

        // 1-4. PAY
        PayDTO payDTO = payDAO.selectPay(order.getPay().getPayNo());
        assertNotNull(payDTO);

        // 1-5. PAY_RSLT
        PayRsltDTO payRsltDTO = payRsltDAO.selectPayResult(order.getPayRslt().getPayNo());
        assertNotNull(payRsltDTO);

        // 1-6. ORD_DLV_ADDR
        OrdDlvAddrDTO ordDlvAddrDTO = ordDlvAddrDAO.selectOrdDlvAddr(order.getOrdDlvAddr().getOrdDlvAddrNo());
        assertNotNull(ordDlvAddrDTO);

    }

    @Test
    // 트랜잭션 테스트 - ORD 에러 발생
    public void transactionOrdTest() throws Exception {
        // 주문 관련 table들에 데이터가 없는지 검증한다.
        assertEquals(0, ordDAO.countOrd());
        assertEquals(0, ordDtlDAO.countOrderDetail());
        assertEquals(0, ordStusHistDAO.countOrderStatusHistory());
        assertEquals(0, payDAO.countPay());
        assertEquals(0, payRsltDAO.countPayResult());
        assertEquals(0, ordDtlDAO.countOrderDetail());

        int result;
        // 주문 시 필요한 데이터 생성
        Order order = getOrder();

        // 의도적으로 에러를 발생시킨다. - 등록자를 없는 회원 번호로 변경(FK 걸려있어서 에러날 것)
        order.getOrd().setRegrId(0);

        // 주문을 생성한다.
        try {
            service.order(order);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 데이터가 insert되지 않고 롤백되었는지 확인
        // 1. ORD
        assertEquals(0, ordDAO.countOrd());
        // 2. ORD_DTL
        assertEquals(0, ordDtlDAO.countOrderDetail());
        // 3. ORD_STUS_HIS
        assertEquals(0, ordStusHistDAO.countOrderStatusHistory());
        // 4. PAY
        assertEquals(0, payDAO.countPay());
        // 5. PAY_RSLT
        assertEquals(0, payRsltDAO.countPayResult());
        // 6. ORD_DLV_ADDR
        assertEquals(0, ordDtlDAO.countOrderDetail());
    }

    @Test
    // 트랜잭션 테스트 - ORD_STUS_HIST에서 에러 발생
    public void transactionOrdStusHistTest() throws Exception {
        // 주문 관련 table들에 데이터가 없는지 검증한다.
        assertEquals(0, ordDAO.countOrd());
        assertEquals(0, ordDtlDAO.countOrderDetail());
        assertEquals(0, ordStusHistDAO.countOrderStatusHistory());
        assertEquals(0, payDAO.countPay());
        assertEquals(0, payRsltDAO.countPayResult());
        assertEquals(0, ordDtlDAO.countOrderDetail());

        int result;
        // 주문 시 필요한 데이터 생성
        Order order = getOrder();

        // 의도적으로 에러를 발생시킨다. - 등록자를 없는 회원 번호로 변경(FK 걸려있어서 에러날 것)
        order.getOrdStusHistList().get(0).setRegrId(0);

        // 주문을 생성한다.
        try {
            service.order(order);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 데이터가 insert되지 않고 롤백되었는지 확인
        // 1. ORD
        assertEquals(0, ordDAO.countOrd());
        // 2. ORD_DTL
        assertEquals(0, ordDtlDAO.countOrderDetail());
        // 3. ORD_STUS_HIS
        assertEquals(0, ordStusHistDAO.countOrderStatusHistory());
        // 4. PAY
        assertEquals(0, payDAO.countPay());
        // 5. PAY_RSLT
        assertEquals(0, payRsltDAO.countPayResult());
        // 6. ORD_DLV_ADDR
        assertEquals(0, ordDtlDAO.countOrderDetail());
    }

    @Test
    // 트랜잭션 테스트 - ORD_DTL 에러 발생
    public void transactionOrdDtlTest() throws Exception {
        // 주문 관련 table들에 데이터가 없는지 검증한다.
        assertEquals(0, ordDAO.countOrd());
        assertEquals(0, ordDtlDAO.countOrderDetail());
        assertEquals(0, ordStusHistDAO.countOrderStatusHistory());
        assertEquals(0, payDAO.countPay());
        assertEquals(0, payRsltDAO.countPayResult());
        assertEquals(0, ordDtlDAO.countOrderDetail());

        int result;
        // 주문 시 필요한 데이터 생성
        Order order = getOrder();

        // 의도적으로 에러를 발생시킨다.
        // 2) 등록자를 없는 회원 번호로 변경(FK 걸려있어서 에러날 것)
        order.getOrdDtlList().get(0).setRegrId(0);

        // 주문을 생성한다.
        try {
            service.order(order);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 데이터가 insert되지 않고 롤백되었는지 확인
        // 1. ORD
        assertEquals(0, ordDAO.countOrd());
        // 2. ORD_DTL
        assertEquals(0, ordDtlDAO.countOrderDetail());
        // 3. ORD_STUS_HIS
        assertEquals(0, ordStusHistDAO.countOrderStatusHistory());
        // 4. PAY
        assertEquals(0, payDAO.countPay());
        // 5. PAY_RSLT
        assertEquals(0, payRsltDAO.countPayResult());
        // 6. ORD_DLV_ADDR
        assertEquals(0, ordDtlDAO.countOrderDetail());
    }

    @Test
    // 트랜잭션 테스트 - PAY_RSLT에서 에러 발생
    public void transactionPayRsltTest() throws Exception {
        // 주문 관련 table들에 데이터가 없는지 검증한다.
        assertEquals(0, ordDAO.countOrd());
        assertEquals(0, ordDtlDAO.countOrderDetail());
        assertEquals(0, ordStusHistDAO.countOrderStatusHistory());
        assertEquals(0, payDAO.countPay());
        assertEquals(0, payRsltDAO.countPayResult());
        assertEquals(0, ordDtlDAO.countOrderDetail());

        int result;
        // 주문 시 필요한 데이터 생성
        Order order = getOrder();

        // 의도적으로 에러를 발생시킨다. - 등록자를 없는 회원 번호로 변경(FK 걸려있어서 에러날 것)
        order.getPayRslt().setRegrId(0);

        // 주문을 생성한다.
        try {
            service.order(order);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 데이터가 insert되지 않고 롤백되었는지 확인
        // 1. ORD
        assertEquals(0, ordDAO.countOrd());
        // 2. ORD_DTL
        assertEquals(0, ordDtlDAO.countOrderDetail());
        // 3. ORD_STUS_HIS
        assertEquals(0, ordStusHistDAO.countOrderStatusHistory());
        // 4. PAY
        assertEquals(0, payDAO.countPay());
        // 5. PAY_RSLT
        assertEquals(0, payRsltDAO.countPayResult());
        // 6. ORD_DLV_ADDR
        assertEquals(0, ordDtlDAO.countOrderDetail());
    }

    @Test
    // 트랜잭션 테스트 - ORD_DLV_ADDR에서 에러 발생
    public void transactionOrdDlvAddrTest() throws Exception {
        // 주문 관련 table들에 데이터가 없는지 검증한다.
        assertEquals(0, ordDAO.countOrd());
        assertEquals(0, ordDtlDAO.countOrderDetail());
        assertEquals(0, ordStusHistDAO.countOrderStatusHistory());
        assertEquals(0, payDAO.countPay());
        assertEquals(0, payRsltDAO.countPayResult());
        assertEquals(0, ordDtlDAO.countOrderDetail());

        int result;
        // 주문 시 필요한 데이터 생성
        Order order = getOrder();

        // ORD_DLV_ADDR 우편번호(not null, 필수값)에 들어갈 zipcode null로 세팅 -> 의도적으로 에러 발생
        order.getOrdDlvAddr().setZipcode(null);

        // 주문을 생성한다.
        try {
            service.order(order);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 데이터가 insert되지 않고 롤백되었는지 확인
        // 1. ORD
        assertEquals(0, ordDAO.countOrd());
        // 2. ORD_DTL
        assertEquals(0, ordDtlDAO.countOrderDetail());
        // 3. ORD_STUS_HIS
        assertEquals(0, ordStusHistDAO.countOrderStatusHistory());
        // 4. PAY
        assertEquals(0, payDAO.countPay());
        // 5. PAY_RSLT
        assertEquals(0, payRsltDAO.countPayResult());
        // 6. ORD_DLV_ADDR
        assertEquals(0, ordDtlDAO.countOrderDetail());
    }


    // 컴퓨티드 컬럼 아니고 그냥 화면에서 받아온 값들 잘 들어갔는지 검증



    private static Order getOrder() {
        // 1. 주문에 필요한 데이터 세팅
        // 1-1. 주문 상품 정보가 들어있는 DTO 생성
        List<OrderProductRequestDTO> orderProductList = new ArrayList<>();
        orderProductList.add(OrderProductRequestDTO.Builder.anOrderProductRequestDTO()
                .prodId(10001)
                .prodNm("반스 올드스쿨")
                .optCombNo(1)
                .qty(3)
                .build());
        orderProductList.add(OrderProductRequestDTO.Builder.anOrderProductRequestDTO()
                .prodId(10007)
                .prodNm("아딜렛 클로그")
                .optCombNo(null)
                .qty(1)
                .build());
        orderProductList.add(OrderProductRequestDTO.Builder.anOrderProductRequestDTO()
                .prodId(10011)
                .prodNm("로그 2.0")
                .optCombNo(null)
                .qty(4)
                .build());

        // 1-2. 주문정보가 들어있는 DTO 생성
        OrderRequestDTO orderRequest = OrderRequestDTO.Builder.anOrderRequestDTO()
                .orderProductList(orderProductList)
                .payTp("20")
                .cpnIssNo(3)
                .pntUseAmt(554200)
                .recipient("방채민")
                .mpNo("01055173236")
                .zipcode("23423")
                .dfltAddr("서울시 종로구 69")
                .dtlAddr("서울 YMCA 518호")
                .dlvReqComt("문 앞에 놔주세요")
                .build();

        // 1-3. 주문 도메인 모델 생성
        return new Order(orderRequest, 80001);
    }

    @Test
    public void getOrderInfoListTest() throws Exception {
        Map<String, Object> param = new HashMap<>();
        param.put("mbrId", 80001);
        param.put("startDate", "2023-01-01");
        param.put("endDate", "2023-12-01");

        Map<Integer, List<OrderInfoDTO>> orderInfoListByOrdNo = service.getOrderInfoListByOrdNo(param);
        System.out.println("orderInfoListByOrdNo = " + orderInfoListByOrdNo);
    }
}