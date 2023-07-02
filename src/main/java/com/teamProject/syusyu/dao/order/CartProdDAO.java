package com.teamProject.syusyu.dao.order;

import com.teamProject.syusyu.domain.order.CartProductDTO;

import java.util.List;

public interface CartProdDAO {
    List<CartProductDTO> select(int mbrCd);
}
