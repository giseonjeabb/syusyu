package com.teamProject.syusyu.dao.order.impl;

import com.teamProject.syusyu.dao.order.OrdStusHistDAO;
import com.teamProject.syusyu.domain.order.OrdStusHistDTO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class OrdStusHistDAOImplTest {
    @Autowired
    OrdStusHistDAO dao;

    @Before
    // 각 테스트 실행 전에 수행될 메서드. 기존 데이터를 모두 삭제한다.
    public void beforeEach() throws Exception {
        // 기존 데이터 삭제
        dao.deleteAllOrderStatusHistory();
        // 테이블이 비어있는지 확인
        assertEquals(0, dao.countOrderStatusHistory());
    }

    @Test
    // 주문 상태 이력 정보 삽입 테스트
    public void testInsertOrderStatusHistory() throws Exception {
        OrdStusHistDTO ordStusHist = new OrdStusHistDTO();
        // 필드 설정에 필요한 값을 적절히 설정하세요.
        // 예시: ordStusHist.setOrdDtlNo(1);
        dao.insertOrderStatusHistory(ordStusHist);

        OrdStusHistDTO insertedOrdStusHist = dao.selectOrderStatusHistory(ordStusHist.getOrdStusHistNo());
        assertNotNull(insertedOrdStusHist);
        // 다른 필드들에 대한 assert 구문 추가..

        // 이미 존재하는 주문 상태 이력 정보 추가 -> 삽입이 안 되어야 정상
        try {
            dao.insertOrderStatusHistory(ordStusHist);
            fail("기본키 중복");
        } catch (Exception e) {
            assertTrue(true);
        }
    }

    @Test
    // 주문 상태 이력 정보 조회 테스트
    public void testSelectOrderStatusHistory() throws Exception {
        // 조회할 정보를 먼저 삽입합니다.
        OrdStusHistDTO ordStusHist = new OrdStusHistDTO();
        // 필드 설정에 필요한 값을 적절히 설정하세요.
        dao.insertOrderStatusHistory(ordStusHist);

        // 위에서 삽입한 주문 상태 이력 정보 조회
        OrdStusHistDTO selectedOrdStusHist = dao.selectOrderStatusHistory(ordStusHist.getOrdStusHistNo());
        assertNotNull(selectedOrdStusHist);
        // 다른 필드들에 대한 assert 구문 추가..

        // 존재하지 않는 주문 상태 이력 정보 조회
        OrdStusHistDTO notExistingOrdStusHist = dao.selectOrderStatusHistory(99);
        assertNull(notExistingOrdStusHist);
    }

    @Test
    // 모든 주문 상태 이력 정보 삭제 테스트
    public void testDeleteAllOrderStatusHistory() throws Exception {
        // 삭제할 정보를 먼저 삽입합니다.
        OrdStusHistDTO ordStusHist = new OrdStusHistDTO();
        // 필드 설정에 필요한 값을 적절히 설정하세요.
        dao.insertOrderStatusHistory(ordStusHist);

        // row가 한 개 있는지 확인합니다.
        assertEquals(1, dao.countOrderStatusHistory());

        // row 삭제 후 테이블이 비어있는지 확인합니다.
        dao.deleteAllOrderStatusHistory();
        assertEquals(0, dao.countOrderStatusHistory());
    }

    @Test
    // 주문 상태 이력 정보 총 개수 테스트
    public void testCountOrderStatusHistory() throws Exception {
        // 테이블에 데이터가 없어야 합니다.
        assertEquals(0, dao.countOrderStatusHistory());

        // 데이터 삽입 후 개수를 확인합니다.
        OrdStusHistDTO ordStusHist = new OrdStusHistDTO();
        // 필드 설정에 필요한 값을 적절히 설정하세요.
        dao.insertOrderStatusHistory(ordStusHist);
        assertEquals(1, dao.countOrderStatusHistory());
    }
}
