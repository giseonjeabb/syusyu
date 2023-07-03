package com.teamProject.syusyu.dao.order;

import com.teamProject.syusyu.domain.order.CartProductDTO;
import com.teamProject.syusyu.domain.order.CartTotalDTO;

import java.util.List;

public interface CartProdDAO {
    int insert(CartProductDTO cartProductDTO) throws Exception;

    List<CartProductDTO> select(int mbrCd) throws Exception;

    int update(CartProductDTO cartProductDTO) throws Exception;

    /*
    * 장바구니에 담긴 상품들을 제거한다.
    * 메서드명 : delete
    * 매개변수 : int[] cartProdId
    * 반환타입 : int(영향을 받은 row의 수)
    * */
    int delete(int[] cartProdId) throws Exception;

    int deleteAll() throws Exception;

    CartTotalDTO selectCartTotal(int mbrId) throws Exception;


}
