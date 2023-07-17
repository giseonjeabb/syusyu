package com.teamProject.syusyu.dao.order.impl;

import com.teamProject.syusyu.dao.order.OrdDtlDAO;
import com.teamProject.syusyu.domain.order.OrdDtlDTO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDateTime;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class OrdDtlDAOImplTest {
    @Autowired
    OrdDtlDAO dao;

    @Before
    public void beforeEach() throws Exception {
        int result;

        // 1. 존재하는 모든 주문상세를 삭제한다.
        result = dao.deleteAllOrderDetail();
        System.out.println("result = " + result);
        // 2. 삭제된 주문상세 데이터가 1개 이상인지 확인한다.
//        assertTrue(result > 0);
        // 3. 주문상테 테이블에 데이터가 하나도 없는지 확인한다.
        result = dao.countOrderDetail();
        assertTrue(result == 0);
    }

    // 주문상세(ORD_DTL) 데이터 insert 테스트
    @Test
    public void insertOrderDetail() throws Exception {
        int result;

        // 1. positive 테스트
        // 1-1. 주문 상세 데이터 넣고 잘 들어가는지 확인
        OrdDtlDTO ordDtlDTO = OrdDtlDTO.Builder.anOrdDtlDTO()
                .ordNo(8)
                .prodId(10001)
                .prodNm("반스 올드스쿨")
                .optCombNo(1)
                .prodPrc(89000)
                .prodDcPer(20)
                .qty(3)
                .prodTotalPayAmt(213600)
                .sendDdln(LocalDateTime.now())
                .regrId(80001)
                .build();

        result = dao.insertOrderDetail(ordDtlDTO);
        assertTrue(result == 1);

        // 2. negative 테스트
        // 2-1. TODO 중복된 값이거나
        // 2-2. 주문마스터가 존재하지 않으면 데이터가 insert 안 되어야 함
        OrdDtlDTO ordDtlDTO2 = OrdDtlDTO.Builder.anOrdDtlDTO()
                .ordNo(8)
                .prodId(10001)
                .prodNm("반스 올드스쿨")
                .optCombNo(1)
                .prodPrc(89000)
                .prodDcPer(20)
                .qty(3)
                .prodTotalPayAmt(213600)
                .sendDdln(LocalDateTime.now())
                .regrId(80001)
                .build();
        try {
            result = dao.insertOrderDetail(ordDtlDTO2);
            // 테스트가 예상한대로 작동하면 예외가 발생해야 하는데 그렇지 않으면 fail()문으로 테스트 실패처리
            fail("Expected exception not occurred");
        } catch (Exception e) {
            result = 0;
            assertTrue(result == 0);
        }
    }

    // 주문상세(ORD_DTL) 데이터 select 테스트
    @Test
    public void selectOrderDetail() throws Exception {
        int insertResult;
        int ordDtlNo;
        OrdDtlDTO ordDtlDTO = OrdDtlDTO.Builder.anOrdDtlDTO()
                .ordNo(8)
                .prodId(10001)
                .prodNm("반스 올드스쿨")
                .optCombNo(1)
                .prodPrc(89000)
                .prodDcPer(20)
                .qty(3)
                .prodTotalPayAmt(213600)
                .sendDdln(LocalDateTime.now())
                .regrId(80001)
                .build();
        insertResult = dao.insertOrderDetail(ordDtlDTO);
        assertTrue(insertResult == 1);

        // 1. positive 테스트
        // 1-1. 존재하는 주문번호 select
        ordDtlNo = ordDtlDTO.getOrdDtlNo();
        OrdDtlDTO ordDtl = dao.selectOrderDetail(ordDtlNo);
        assertTrue(ordDtlDTO.equals(ordDtl));

        // 2. negative 테스트
        // 2-1. 존재하지 않는 주문번호 select
        ordDtlNo = 3223;
        OrdDtlDTO ordDtl2 = dao.selectOrderDetail(ordDtlNo);
        assertTrue(ordDtl2 == null);
    }

    // 주문상세(ORD_DTL) 데이터 전체 삭제 테스트
    @Test
    public void deleteAllOrderDetail() throws Exception {
        OrdDtlDTO ordDtlDTO = OrdDtlDTO.Builder.anOrdDtlDTO()
                .ordNo(8)
                .prodId(10001)
                .prodNm("반스 올드스쿨")
                .optCombNo(1)
                .prodPrc(89000)
                .prodDcPer(20)
                .qty(3)
                .prodTotalPayAmt(213600)
                .sendDdln(LocalDateTime.now())
                .regrId(80001)
                .build();
        int result = dao.insertOrderDetail(ordDtlDTO);
        assertTrue(result == 1);

        int cnt;
        // 모든 주문 상세 데이터를 DB에서 삭제한다.
        // 모두 올바르게 삭제되었는지 테스트한다.
        cnt = dao.deleteAllOrderDetail();
        assertTrue(cnt == 1);

        cnt = dao.countOrderDetail();
        assertTrue(cnt == 0);
    }

    // 주문상세(ORD_DTL) DB에 저장된 주문 상세 정보의 총 개수 조회
    @Test
    public void countOrderDetail() throws Exception {
        int result;
        // 1. positive 테스트
        // 1-1. 주문을 2건 넣고 count가 2인지 확인
        OrdDtlDTO ordDtlDTO = OrdDtlDTO.Builder.anOrdDtlDTO()
                .ordNo(8)
                .prodId(10001)
                .prodNm("반스 올드스쿨")
                .optCombNo(1)
                .prodPrc(89000)
                .prodDcPer(20)
                .qty(3)
                .prodTotalPayAmt(213600)
                .sendDdln(LocalDateTime.now())
                .regrId(80001)
                .build();
        result = dao.insertOrderDetail(ordDtlDTO);
        assertTrue(result == 1);

        ordDtlDTO = OrdDtlDTO.Builder.anOrdDtlDTO()
                .ordNo(8)
                .prodId(10001)
                .prodNm("반스 올드스쿨")
                .optCombNo(1)
                .prodPrc(89000)
                .prodDcPer(20)
                .qty(3)
                .prodTotalPayAmt(213600)
                .sendDdln(LocalDateTime.now())
                .regrId(80001)
                .build();
        result = dao.insertOrderDetail(ordDtlDTO);
        assertTrue(result == 1);
        // 1-2. 주문을 모두 삭제하고 count가 0인지 확인
        result = dao.deleteAllOrderDetail();
        assertTrue(result == 2);

        result = dao.countOrderDetail();
        assertTrue(result == 0);

        // 2. negative 테스트
    }
}