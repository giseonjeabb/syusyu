package com.teamProject.syusyu.service.fos.order;

import com.teamProject.syusyu.domain.order.CartProdDTO;

import java.util.List;

public interface FOS_CartService {
    List<Integer> addProductsIntoCart(List<CartProdDTO> cartProductDTOs) throws Exception;
    List<CartProdDTO> getCartInfo(int mbrCd) throws Exception;
    int modify(CartProdDTO cartProductDTO) throws Exception;
    int remove(int[] cartProdNo, int delrId) throws Exception;
}
