package com.teamProject.syusyu.service.order.impl;

import com.teamProject.syusyu.dao.order.CartProdDAO;
import com.teamProject.syusyu.domain.order.CartProductDTO;
import com.teamProject.syusyu.service.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    CartProdDAO cartProdDAO;

    @Autowired
    public OrderServiceImpl(CartProdDAO cartProdDAO) {
        this.cartProdDAO = cartProdDAO;
    }

    @Override
    public List<CartProductDTO> getCart(int mbrCd) {
        return cartProdDAO.select(mbrCd);
    }
}
