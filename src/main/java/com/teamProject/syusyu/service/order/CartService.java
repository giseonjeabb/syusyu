package com.teamProject.syusyu.service.order;

import com.teamProject.syusyu.domain.order.CartProductDTO;

import java.util.List;

public interface CartService {
    int add(CartProductDTO cartProductDTO) throws Exception;
    List<CartProductDTO> getList(int mbrCd) throws Exception;
    int modify(CartProductDTO cartProductDTO) throws Exception;
    int remove(int[] cartProdId) throws Exception;
}
