package com.teamProject.syusyu.service.order;

import com.teamProject.syusyu.domain.order.CartInfoDTO;
import com.teamProject.syusyu.domain.order.CartProductDTO;

public interface CartService {
    int add(CartProductDTO cartProductDTO) throws Exception;
    CartInfoDTO getCartInfo(int mbrCd) throws Exception;
    int modify(CartProductDTO cartProductDTO) throws Exception;
    int remove(int[] cartProdId) throws Exception;

}
