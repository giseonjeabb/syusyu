package com.teamProject.syusyu.dao.order.impl;

import com.teamProject.syusyu.dao.order.OrdDlvAddrDAO;
import com.teamProject.syusyu.domain.order.OrdDlvAddrDTO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class OrdDlvAddrDAOImplTest {
    @Autowired
    OrdDlvAddrDAO dao;

    @Before
    // 테스트 시작 전에 먼저 수행되는 메서드. 모든 주문 배송지 정보를 삭제한다.
    public void beforeEach() throws Exception {
        int result = dao.deleteAllOrdDlvAddr();
        System.out.println("Deleted records: " + result);
        result = dao.countOrdDlvAddr();
        assertEquals(0, result);
    }

    @Test
    // 주문 배송지 정보 삽입 테스트
    public void testInsertOrdDlvAddr() throws Exception {
        // 삽입할 배송지 정보 생성
        OrdDlvAddrDTO ordDlvAddr = OrdDlvAddrDTO.Builder.anOrdDlvAddrDTO()
                .ordNo(3)
                .recipient("홍길동")
                .mpNo("01012345678")
                .safetNoYn("N")
                .zipcode("12345")
                .dfltAddr("서울시 강남구")
                .dtlAddr("역삼동 123-45")
                .dlvReqComt("부재시 경비실에 맡겨주세요.")
                .regrId(80000)
                .build();

        // 배송지 정보 삽입
        int result = dao.insertOrdDlvAddr(ordDlvAddr);
        assertEquals(1, result);  // 삽입 결과 확인

        // 삽입된 배송지 정보 조회
        OrdDlvAddrDTO insertedOrdDlvAddr = dao.selectOrdDlvAddr(ordDlvAddr.getOrdDlvAddrNo());
        assertNotNull(insertedOrdDlvAddr);  // 조회 결과 확인
        assertEquals(ordDlvAddr.getOrdNo(), insertedOrdDlvAddr.getOrdNo());

        // 중복 배송지 정보 삽입 시도
        try {
            dao.insertOrdDlvAddr(ordDlvAddr);
            fail("PK 중복");  // 예외가 발생하지 않으면 테스트 실패
        } catch (Exception e) {
            System.out.println("성공");  // 예외가 발생하면 테스트 성공
        }
    }

    @Test
    // 주문 배송지 정보 조회 테스트
    public void testSelectOrdDlvAddr() throws Exception {
        // 조회할 배송지 정보 먼저 삽입
        OrdDlvAddrDTO ordDlvAddr = OrdDlvAddrDTO.Builder.anOrdDlvAddrDTO()
                .ordNo(3)
                .recipient("홍길동")
                .mpNo("01012345678")
                .safetNoYn("N")
                .zipcode("12345")
                .dfltAddr("서울시 강남구")
                .dtlAddr("역삼동 123-45")
                .dlvReqComt("부재시 경비실에 맡겨주세요.")
                .regrId(80000)
                .build();

        dao.insertOrdDlvAddr(ordDlvAddr);

        // 삽입한 배송지 정보 조회
        OrdDlvAddrDTO selectedOrdDlvAddr = dao.selectOrdDlvAddr(ordDlvAddr.getOrdDlvAddrNo());
        assertNotNull(selectedOrdDlvAddr);  // 조회 결과 확인
        assertEquals(ordDlvAddr.getOrdNo(), selectedOrdDlvAddr.getOrdNo());

        // 존재하지 않는 배송지 정보 조회
        OrdDlvAddrDTO notExistingOrdDlvAddr = dao.selectOrdDlvAddr(99);
        assertNull(notExistingOrdDlvAddr);  // 조회 결과 확인 (null이어야 함)
    }

    @Test
    // 모든 주문 배송지 정보 삭제 테스트
    public void testDeleteAllOrdDlvAddr() throws Exception {
        // 삭제할 배송지 정보 먼저 삽입
        OrdDlvAddrDTO ordDlvAddr = OrdDlvAddrDTO.Builder.anOrdDlvAddrDTO()
                .ordNo(3)
                .recipient("홍길동")
                .mpNo("01012345678")
                .safetNoYn("N")
                .zipcode("12345")
                .dfltAddr("서울시 강남구")
                .dtlAddr("역삼동 123-45")
                .dlvReqComt("부재시 경비실에 맡겨주세요.")
                .regrId(80000)
                .build();

        dao.insertOrdDlvAddr(ordDlvAddr);

        // 삽입된 배송지 정보 개수 확인
        int count = dao.countOrdDlvAddr();
        assertEquals(1, count);  // 배송지 정보 개수 확인 (1개 있어야 함)

        // 모든 배송지 정보 삭제
        int deletedRecords = dao.deleteAllOrdDlvAddr();
        assertEquals(1, deletedRecords);  // 삭제 결과 확인 (1개 삭제되어야 함)

        // 삭제 후 배송지 정보 개수 확인
        count = dao.countOrdDlvAddr();
        assertEquals(0, count);  // 배송지 정보 개수 확인 (0개 있어야 함)
    }
    @Test
    // 주문 배송지 정보 총 개수 테스트
    public void testCountOrdDlvAddr() throws Exception {
        // 초기 상태에서 배송지 정보 개수 확인
        assertEquals(0, dao.countOrdDlvAddr());

        // 배송지 정보 삽입 후 개수 확인
        OrdDlvAddrDTO ordDlvAddr = OrdDlvAddrDTO.Builder.anOrdDlvAddrDTO()
                .ordNo(3)
                .recipient("홍길동")
                .mpNo("01012345678")
                .safetNoYn("N")
                .zipcode("12345")
                .dfltAddr("서울시 강남구")
                .dtlAddr("역삼동 123-45")
                .dlvReqComt("부재시 경비실에 맡겨주세요.")
                .regrId(80000)
                .build();

        dao.insertOrdDlvAddr(ordDlvAddr);
        assertEquals(1, dao.countOrdDlvAddr());  // 배송지 정보 개수 확인 (1개 있어야 함)
    }
}
