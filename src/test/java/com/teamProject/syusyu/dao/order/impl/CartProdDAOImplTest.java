package com.teamProject.syusyu.dao.order.impl;

import com.teamProject.syusyu.dao.order.CartProdDAO;
import com.teamProject.syusyu.domain.order.CartProdDTO;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class CartProdDAOImplTest extends TestCase {
    @Autowired
    CartProdDAO dao;

    @Before
    public void beforeEach() throws Exception {
        dao.deleteAllTest();
        assertTrue(dao.selectAllTest().size() == 0);
    }

    @After
    public void afterEach() throws Exception {
        beforeEach();

        CartProdDTO cartProdDTO = new CartProdDTO(1, 10001, 16, 1, 80001, null, null, 80001);
        assertTrue(dao.insertProductIntoCart(cartProdDTO) == 1);
        assertTrue(dao.selectAllTest().size() == 1);

        CartProdDTO cartProdDTO1 = new CartProdDTO(1, 10007, 2, null, 80001, null, null, 80001);
        assertTrue(dao.insertProductIntoCart(cartProdDTO1) == 1);
        assertTrue(dao.selectAllTest().size() == 2);

        CartProdDTO cartProdDTO2 = new CartProdDTO(1, 10011, 1, null, 80001, null, null, 80001);
        assertTrue(dao.insertProductIntoCart(cartProdDTO2) == 1);
        assertTrue(dao.selectAllTest().size() == 3);

        CartProdDTO cartProdDTO3 = new CartProdDTO(1, 10007, 2, null, 80001, null, null, 80001);
        assertTrue(dao.insertProductIntoCart(cartProdDTO3) == 1);
        assertTrue(dao.selectAllTest().size() == 4);
    }



    // 장바구니 추가 검증
    @Test
    public void testSelectHaveCart() throws Exception{
        System.out.println(dao.selectHaveCart(80002));
    }

    @Test
    public void testInsertHaveCart() throws Exception{
        CartProdDTO cartProdDTO = new CartProdDTO(80004, 80004);
        assertTrue(dao.insertCartNo(cartProdDTO) == 1);

    }
    @Test
    public void testInsertProductIntoCart() throws Exception{
        CartProdDTO cartProdDTO =new CartProdDTO(10002,2,12,80003,80003);
        assertTrue(dao.insertProductIntoCart(cartProdDTO)==1);
    }

    @Test
    public void testInsert() throws Exception {
        // 0. 장바구니에 존재하는 상품의 수가 0개인지 검증한다.
        assertTrue(dao.selectAllTest().size() == 0);

        // 장바구니를 하나 추가한다.
        CartProdDTO cartProdDTO = new CartProdDTO(1, 10001, 3, 1, 80001, null, null, 80001);

        // 1. insert한 결과가 1인지 확인(영향을 받은 row의 수)
        assertTrue(dao.insertProductIntoCart(cartProdDTO) == 1);
        // 2. insert 후 카트에 존재하는 row의 수가 1인지 확인
        assertTrue(dao.selectAllTest().size() == 1);

        // 3. insert한 객체와 select 해온 객체와 결과가 같은지 확인
        // 3-1. 위에서 insert한 장바구니상품번호(pk)로 장바구니를 조회해온다.
        CartProdDTO result = dao.selectOneTest(cartProdDTO.getCartProdNo());
        assertTrue(cartProdDTO.equals(result));

        // 장바구니를 하나 더 추가한다.
        CartProdDTO cartProdDTO2 = new CartProdDTO(1, 10007, 2, null, 80001, null, null, 80001);

        // 1. insert한 결과가 1인지 확인(영향을 받은 row의 수)
        assertTrue(dao.insertProductIntoCart(cartProdDTO2) == 1);
        // 2. insert 후에 카트에 존재하는 row의 수가 1인지 확인
        assertTrue(dao.selectAllTest().size() == 2);


        // 3. insert한 객체와 select 해온 객체와 결과가 같은지 확인
        // 3-1. 위에서 insert한 장바구니상품번호(pk)로 장바구니를 조회해온다.
        result = dao.selectOneTest(cartProdDTO2.getCartProdNo());
        assertTrue(cartProdDTO2.equals(result));

        // 처음 insert한 객체와 두 번째로 insert하고 가져온 객체와 다른지 검증
        assertTrue(!cartProdDTO.equals(result));
    }

    // 장바구니 조회 검증
    @Test
    public void testSelect() throws Exception {
        // 0. 장바구니에 존재하는 상품의 수가 0개인지 검증한다.
        assertTrue(dao.selectAllTest().size() == 0);

        // 1. 장바구니를 하나 추가한다.
        CartProdDTO cartProdDTO = new CartProdDTO(1, 10001, 3, 1, 80001, null, null, 80001);
        // 1-1. 추가 후 영향을 받은 row의 수가 1개인지 확인한다.(insert 잘 되었는지 테스트)
        assertTrue(dao.insertProductIntoCart(cartProdDTO) == 1);
        // 1-2. cart_prod 테이블에 존재하는 데이터의 수가 1개인지 검증한다.
        assertTrue(dao.selectAllTest().size() == 1);
        // 1-3. 위에서 insert한 객체를 조회해와서 두 객체의 값이 같은지 검증한다.
        CartProdDTO selectCartProd = dao.selectOneTest(cartProdDTO.getCartProdNo());
        assertTrue(cartProdDTO.equals(selectCartProd));

        assertTrue(dao.deleteAllTest() == 1);

        // 12개의 장바구니 상품을 추가한다.
        int cnt = 12;
        for (int i = 0; i < cnt; i++) {
            cartProdDTO = new CartProdDTO(1, 10001 + i, 3 + i, 1, 80001, null, null, 80001);
            assertTrue(dao.insertProductIntoCart(cartProdDTO) == 1);
        }

        // 추가한 상품과 가져온 장바구니상품의 개수가 같은지 검증한다.
        assertTrue(dao.selectAllTest().size() == cnt);

//        int price = result.getPrice();
//        int dcPer = result.getd
//
//        assertTrue(result);
    }

    @Test
    public void testUpdate() throws Exception {
        // 테스트에 필요한 객체 및 변수 설정
        int cartProdNo;  // 업데이트할 장바구니 상품 번호
        int newQuantity = 5; // 업데이트할 수량

        // 정상적인 상황에서의 업데이트 테스트

        // 1. 장바구니를 하나 추가한다.
        CartProdDTO cartProdDTO1 = new CartProdDTO(1, 10001, 3, 1, 80001, null, null, 80001);
        // 1-1. 추가 후 영향을 받은 row의 수가 1개인지 확인한다.(insert 잘 되었는지 테스트)
        int result = dao.insertProductIntoCart(cartProdDTO1);
        cartProdNo = cartProdDTO1.getCartProdNo();
        assertTrue(result == 1);

        CartProdDTO cartProdDTO = new CartProdDTO();
        cartProdDTO.setCartProdNo(cartProdDTO1.getCartProdNo());
        cartProdDTO.setQty(newQuantity);
        cartProdDTO.setUpdrId(80000); // 업데이트를 수행하는 사용자 ID 설정

        result = dao.update(cartProdDTO);

        // 업데이트 결과 확인
        assertEquals(1, result); // 업데이트된 상품 수

        // 업데이트 이후 장바구니에서 해당 상품 조회 및 수량 비교
        CartProdDTO updatedCartProd = dao.selectOneTest(cartProdNo);
        assertEquals(newQuantity, updatedCartProd.getQty());

        // 업데이트 실패 케이스 테스트: 존재하지 않는 상품 업데이트 시도
        CartProdDTO invalidCartProdDTO = new CartProdDTO();
        invalidCartProdDTO.setCartProdNo(999); // 존재하지 않는 장바구니 상품 번호
        invalidCartProdDTO.setQty(newQuantity);
        invalidCartProdDTO.setUpdrId(123);

        int invalidResult = dao.update(invalidCartProdDTO);

        assertEquals(0, invalidResult); // 업데이트된 상품 수
    }

    @Test
    public void testDelete() throws Exception {
        // 테스트에 필요한 객체 및 변수 설정
        CartProdDTO cartProdDTO1 = new CartProdDTO(1, 10001, 3, 1, 80001, null, null, 80001);
        CartProdDTO cartProdDTO2 = new CartProdDTO(1, 10001, 3, 1, 80001, null, null, 80001);
        CartProdDTO cartProdDTO3 = new CartProdDTO(1, 10001, 3, 1, 80001, null, null, 80001);
        assertTrue(dao.insertProductIntoCart(cartProdDTO1) == 1);
        assertTrue(dao.insertProductIntoCart(cartProdDTO2) == 1);
        assertTrue(dao.insertProductIntoCart(cartProdDTO3) == 1);


        int[] cartProdNoArr = {cartProdDTO1.getCartProdNo(), cartProdDTO2.getCartProdNo(), cartProdDTO3.getCartProdNo()}; // 삭제할 장바구니 상품 번호 배열
        int delrId = 80000; // 상품을 삭제하는 사용자 ID

        System.out.println("Arrays.toString(cartProdNoArr) = " + Arrays.toString(cartProdNoArr));

        // 삭제할 장바구니 상품 번호 배열과 사용자 ID를 맵에 저장
        Map<String, Object> deleteParam = new HashMap<>();
        deleteParam.put("cartProdNo", cartProdNoArr);
        deleteParam.put("delrId", delrId);

        int result = dao.deleteTest(cartProdNoArr);

        // 삭제 결과 확인
        assertEquals(cartProdNoArr.length, result); // 삭제된 상품 수

        // 삭제된 상품 확인을 위해 장바구니에서 해당 상품 조회
        for (int cartProdNo : cartProdNoArr) {
            CartProdDTO deletedCartProd = dao.selectOneTest(cartProdNo);
            assertNull(deletedCartProd); // 삭제된 상품은 조회되지 않아야 함
        }

        // 장바구니에서 존재하지 않는 상품 삭제 시도
        int[] invalidCartProdNoArray = {999, 1000}; // 존재하지 않는 장바구니 상품 번호 배열
        int invalidDelrId = 80001; // 상품을 삭제하는 사용자 ID

        int invalidResult = dao.delete(invalidCartProdNoArray, invalidDelrId);

        // 삭제 결과 확인
        assertEquals(0, invalidResult); // 삭제된 상품 수
    }
}