package com.teamProject.syusyu.service.order;

import com.teamProject.syusyu.domain.order.CartProductDTO;

import java.util.List;

public interface OrderService {
    List<CartProductDTO> getCart(int mbrCd);
}
