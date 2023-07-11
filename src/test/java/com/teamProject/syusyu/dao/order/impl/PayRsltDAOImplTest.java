package com.teamProject.syusyu.dao.order.impl;

import com.teamProject.syusyu.dao.order.PayRsltDAO;
import com.teamProject.syusyu.domain.order.PayRsltDTO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class PayRsltDAOImplTest {
    @Autowired
    private PayRsltDAO dao;

    private PayRsltDTO payRsltDTO;

    @Before
    public void setUp() throws Exception {
        // 1. 모든 결제승인결과를 삭제한다.
        int result = dao.deleteAllPayResult();
        System.out.println("deleted count = " + result);
        // 2. 삭제된 결제승인결과 데이터가 1개 이상인지 확인한다.
//        assertTrue(result > 0);
        // 3. 결제승인결과 테이블에 데이터가 하나도 없는지 확인한다.
        result = dao.countPayResult();
        assertEquals(0, result);

        // 테스트에 사용할 PayRsltDTO 객체를 생성한다.
        payRsltDTO = PayRsltDTO.Builder.aPayRsltDTO()
                .payNo(123456789)
                .aprvNo("12345678")
                .aprvDttm(LocalDateTime.now())
                .cardNum("1234567812345678")
                .cardInterest('N')
                .cardQuota("00")
                .cardCode("01")
                .cardCorpFlag('1')
                .cardCheckFlag('1')
                .cardPrtcCode('1')
                .cardSrcCode('1')
                .cardPoint('0')
                .regrId(80001)
                .build();
    }

    @Test
    public void insertAndSelectTest() throws Exception {
        // 삽입 테스트
        int result = dao.insertPayResult(payRsltDTO);
        assertEquals(1, result);

        // 조회 테스트
        PayRsltDTO selectedPayRsltDTO = dao.selectPayResult(payRsltDTO.getPayNo());
        assertNotNull(selectedPayRsltDTO);
        assertEquals(payRsltDTO, selectedPayRsltDTO);
    }

    @Test
    public void updateTest() throws Exception {
        // 먼저 삽입한다.
        int result = dao.insertPayResult(payRsltDTO);
        assertEquals(1, result);

        // 수정할 PayRsltDTO 객체를 생성한다.
        PayRsltDTO updatedPayRsltDTO = PayRsltDTO.Builder.aPayRsltDTO()
                .payNo(payRsltDTO.getPayNo())
                .aprvNo("87654321")
                .aprvDttm(LocalDateTime.now())
                .cardNum("8765432187654321")
                .cardInterest('Y')
                .cardQuota("12")
                .cardCode("02")
                .cardCorpFlag('2')
                .cardCheckFlag('2')
                .cardPrtcCode('2')
                .cardSrcCode('2')
                .cardPoint('1')
                .regrId(80001)
                .build();

        // 수정 테스트
        result = dao.updatePayResult(updatedPayRsltDTO);
        assertEquals(1, result);

        // 수정된 내용이 제대로 반영되었는지 조회해서 확인한다.
        PayRsltDTO selectedPayRsltDTO = dao.selectPayResult(updatedPayRsltDTO.getPayNo());
        assertNotNull(selectedPayRsltDTO);
        assertEquals(updatedPayRsltDTO, selectedPayRsltDTO);
    }

    @Test
    public void deleteTest() throws Exception {
        // 먼저 삽입한다.
        int result = dao.insertPayResult(payRsltDTO);
        assertEquals(1, result);

        // 삭제 테스트
        result = dao.deletePayResult(payRsltDTO.getPayNo());
        assertEquals(1, result);

        // 삭제된 결제승인결과가 DB에서 제대로 삭제되었는지 확인한다.
        PayRsltDTO selectedPayRsltDTO = dao.selectPayResult(payRsltDTO.getPayNo());
        assertNull(selectedPayRsltDTO);
    }
}
