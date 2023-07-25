package com.teamProject.syusyu.dao.order;

import com.teamProject.syusyu.domain.order.CartProdDTO;

import java.util.List;

public interface CartProdDAO {

    CartProdDTO selectHaveCart(int mbrCd) throws Exception;

    int insertCartNo(CartProdDTO cartProdDTO) throws Exception;

    int insertProductIntoCart(CartProdDTO cartProductDTO) throws Exception;

    List<CartProdDTO> selectAll(int mbrId) throws Exception;

    int update(CartProdDTO cartProductDTO) throws Exception;

    /*
    * 장바구니에 담긴 상품들을 제거한다.
    * 메서드명 : delete
    * 매개변수 : int[] cartProdNo
    * 반환타입 : int(영향을 받은 row의 수)
    * */
    int delete(int[] cartProdNo, int delrId) throws Exception;

    int deleteTest(int[] cartProdNoArr) throws Exception;
    int deleteAllTest() throws Exception;

    List<CartProdDTO> selectAllTest() throws Exception;

    CartProdDTO selectOneTest(int cartProdNo) throws Exception;
}
