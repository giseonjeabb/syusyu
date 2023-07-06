package com.teamProject.syusyu.service.order;

import com.teamProject.syusyu.domain.order.CartInfoDTO;
import com.teamProject.syusyu.domain.order.CartProdDTO;

public interface CartService {
    int add(CartProdDTO cartProductDTO) throws Exception;
    CartInfoDTO getCartInfo(int mbrCd) throws Exception;
    int modify(CartProdDTO cartProductDTO) throws Exception;
    int remove(int[] cartProdId) throws Exception;

}
