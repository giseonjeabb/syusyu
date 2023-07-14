package com.teamProject.syusyu.dao.order;

import com.teamProject.syusyu.domain.order.OrdDTO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class OrdDAOImplTest {
    @Autowired
    OrdDAO dao;

    @Before
    public void beforeEach() throws Exception {
        // 1. 존재하는 모든 주문을 삭제한다.
        int result = dao.deleteAllOrder();

        // 2. 삭제된 주문이 1개 이상인지 확인한다.
        assertTrue(result > 0);

        // 3. 주문 테이블에 주문이 하나도 없는지 확인한다.
        result = dao.countOrd();
        assertTrue(result == 0);

    }

    @Test
    public void insertOrder() throws Exception {
        int result;
        int ordNo;

        // 1. 주문을 하나 생성한다.
        OrdDTO ord = new OrdDTO(80001, 80001, null);

        // 2. 반환된 값이 1인지 확인한다(insert row 수)
        result = dao.insertOrder(ord);
        assertTrue(result == 1);

        // 3. 생성한 주문의 key 값으로 주문을 조회해와서 두 객체의 값이 같은지 확인한다.
        ordNo = ord.getOrdNo();
        OrdDTO selectOrd = dao.selectOrder(ordNo);

        assertTrue(ord.equals(selectOrd));
    }
}