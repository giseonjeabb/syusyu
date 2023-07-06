package com.teamProject.syusyu.service.order.impl;

import com.teamProject.syusyu.dao.order.CartProdDAO;
import com.teamProject.syusyu.domain.order.CartProdDTO;
import com.teamProject.syusyu.service.order.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {
    CartProdDAO cartProdDAO;

    @Autowired
    public CartServiceImpl(CartProdDAO cartProdDAO) {
        this.cartProdDAO = cartProdDAO;
    }

    @Override
    public int add(CartProdDTO cartProductDTO) throws Exception {
        return cartProdDAO.insert(cartProductDTO);
    }

    @Override
    public List<CartProdDTO> getCartInfo(int mbrId) throws Exception {
        return cartProdDAO.selectAll(mbrId);
    }

    @Override
    public int modify(CartProdDTO cartProductDTO) throws Exception {
        return cartProdDAO.update(cartProductDTO);
    }

    @Override
    public int remove(int[] cartProdNo, int delrId) throws Exception {
        return cartProdDAO.delete(cartProdNo, delrId);
    }
}
