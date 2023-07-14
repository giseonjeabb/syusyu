package com.teamProject.syusyu.dao.order.impl;

import com.teamProject.syusyu.dao.order.PayDAO;
import com.teamProject.syusyu.domain.order.PayDTO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class PayDAOImplTest {
    @Autowired
    PayDAO dao;

    @Before
    // 각 테스트 실행 전에 수행될 메서드. 기존 데이터를 모두 삭제한다.
    public void beforeEach() throws Exception {
        int result;

        // 기존 데이터 삭제
        result = dao.deleteAllPay();
        System.out.println("Deleted records: " + result);

        // 테이블이 비어있는지 확인
        result = dao.countPay();
        assertEquals(0, result);
    }

    @Test
    // 결제 정보 insert 테스트
    public void testInsertPay() throws Exception {
        PayDTO pay = PayDTO.Builder.aPayDTO()
                .payNo(3)
                .payerId(80001)
                .ordNo(8)
                .payStus(10)
                .payTp("10")
                .ordAmt(451200)
                .dlvFee(0)
                .cpnIssNo(2)
                .orgnPayAmt(428640)
                .pntUseAmt(12000)
                .realPayAmt(416640)
                .regrId(80000)
                .build();

        int result = dao.insertPay(pay);
        assertEquals(1, result);

        PayDTO insertedPay = dao.selectPay(pay.getPayNo());
        assertNotNull(insertedPay);
        assertEquals(3, insertedPay.getPayNo());

        // 이미 존재하는 결제 번호로 결제 정보 추가 -> insert 안 되어야 정상
        PayDTO duplicatePay = PayDTO.Builder.aPayDTO()
                .payNo(3)
                .payerId(80001)
                .ordNo(8)
                .payStus(10)
                .payTp("10")
                .ordAmt(451200)
                .dlvFee(0)
                .cpnIssNo(2)
                .orgnPayAmt(428640)
                .pntUseAmt(12000)
                .realPayAmt(416640)
                .regrId(80000)
                .build();

        // insert를 시도하고 실패했음을 확인
        try {
            dao.insertPay(duplicatePay);
            fail("PK 중복");
        } catch (Exception e) {
            System.out.println("성공");
        }
    }

    @Test
    // 결제 정보 조회 테스트
    public void testSelectPay() throws Exception {
        // 조회할 정보 먼저 insert
        PayDTO pay = PayDTO.Builder.aPayDTO()
                .payNo(3)
                .payerId(80001)
                .ordNo(8)
                .payStus(10)
                .payTp("10")
                .ordAmt(451200)
                .dlvFee(0)
                .cpnIssNo(2)
                .orgnPayAmt(428640)
                .pntUseAmt(12000)
                .realPayAmt(416640)
                .regrId(80000)
                .build();

        dao.insertPay(pay);

        // 위에서 insert한 결제 정보 조회
        PayDTO selectedPay = dao.selectPay(3);
        assertNotNull(selectedPay);
        assertEquals(3, selectedPay.getPayNo());

        // 존재하지 않는 pay key로 결제 정보 조회
        PayDTO notExistingPay = dao.selectPay(99);
        assertNull(notExistingPay);
    }

    @Test
    // 모든 결제 정보 삭제 테스트
    public void testDeleteAllPay() throws Exception {
        // 삭제할 정보 먼저 삽입
        PayDTO pay = PayDTO.Builder.aPayDTO()
                .payNo(3)
                .payerId(80001)
                .ordNo(8)
                .payStus(10)
                .payTp("10")
                .ordAmt(451200)
                .dlvFee(0)
                .cpnIssNo(2)
                .orgnPayAmt(428640)
                .pntUseAmt(12000)
                .realPayAmt(416640)
                .regrId(80000)
                .build();
        dao.insertPay(pay);

        // row가 한 개 있는지 확인
        int count = dao.countPay();
        assertEquals(1, count);

        // row 삭제 후 table이 비어있는지 확인
        int deletedRecords = dao.deleteAllPay();
        assertEquals(1, deletedRecords);

        count = dao.countPay();
        assertEquals(0, count);
    }

    @Test
    // 결제 정보 총 개수 테스트
    public void testCountPay() throws Exception {
        // 테이블에 데이터가 없어야 함
        assertEquals(0, dao.countPay());

        // 데이터 insert 후 개수 확인
        PayDTO pay = PayDTO.Builder.aPayDTO()
                .payNo(3)
                .payerId(80001)
                .ordNo(8)
                .payStus(10)
                .payTp("10")
                .ordAmt(451200)
                .dlvFee(0)
                .cpnIssNo(2)
                .orgnPayAmt(428640)
                .pntUseAmt(12000)
                .realPayAmt(416640)
                .regrId(80000)
                .build();

        dao.insertPay(pay);
        assertEquals(1, dao.countPay());
    }
}