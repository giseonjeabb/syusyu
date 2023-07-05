package com.teamProject.syusyu.dao.order.impl;

import com.teamProject.syusyu.dao.order.CartProdDAO;
import com.teamProject.syusyu.domain.order.CartProdDTO;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.stream.Collectors;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class CartProdDAOImplTest extends TestCase {
    @Autowired
    CartProdDAO cartProdDAO;

    @Before
    public void beforeEach() throws Exception {
        cartProdDAO.deleteAll();
        assertEquals(0, cartProdDAO.select(80001).size());
    }

    @Test
    public void testInsert() throws Exception {
        // 장바구니를 하나 추가한다.
        CartProdDTO cartProductDTO = new CartProdDTO(1, 10001, 3, 1, 80001);
        cartProdDAO.insert(cartProductDTO);
        assertEquals(1, cartProdDAO.select(80001).size());

        CartProdDTO cartProductDTO2 = new CartProdDTO(1, 10007, 2, null, 80001);
        cartProdDAO.insert(cartProductDTO2);
        assertEquals(2, cartProdDAO.select(80001).size());
    }

    @Test
    public void testSelect() throws Exception {
        CartProdDTO cartProductDTO = new CartProdDTO(1, 10001, 3, 1, 80001);
        cartProdDAO.insert(cartProductDTO);

        assertEquals(0, cartProdDAO.select(80001).size());
        CartProdDTO result = cartProdDAO.select(80001).get(0);

//        int price = result.getPrice();
//        int dcPer = result.getd
//
//        assertTrue(result);
    }

    @Test
    public void testUpdate() throws Exception {
        CartProdDTO cartProductDTO = new CartProdDTO(1, 10001, 3, 1, 80001);
        cartProdDAO.insert(cartProductDTO);
        assertEquals(1, cartProdDAO.select(80001).size());

        cartProductDTO.setQty(2);
        cartProdDAO.update(cartProductDTO);

        CartProdDTO result = cartProdDAO.select(80001)
                .stream()
                .filter(cartProductDTO1 -> cartProductDTO.getCartProdNo() == cartProductDTO.getCartProdNo())
                .collect(Collectors.toList())
                .get(0);

        System.out.println("cartProductDTO = " + cartProductDTO); // 내가 생성해서 update한 객체
        System.out.println("result = " + result);

        assertEquals(result, cartProductDTO);
    }

    @Test
    public void testDelete() throws Exception {
        CartProdDTO cartProductDTO = new CartProdDTO(1, 10001, 3, 1, 80001);
        cartProdDAO.insert(cartProductDTO);
        assertEquals(1, cartProdDAO.select(80001).size());

        cartProdDAO.delete(new int[]{cartProductDTO.getCartProdNo()});

        assertEquals(0, cartProdDAO.select(80001).size());
    }
}