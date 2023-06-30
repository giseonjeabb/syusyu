package com.teamProject.syusyu.dao.order.impl;

import com.teamProject.syusyu.dao.order.CartProdDAO;
import com.teamProject.syusyu.domain.order.CartProductDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CartProdDAOImpl implements CartProdDAO {
    @Autowired
    private SqlSession session;
    private static final String namespace = "com.teamProject.syusyu.orderMapper.";

    @Override
    public List<CartProductDTO> select(int mbrCd) {
        return session.selectList(namespace + "getCartProduct", mbrCd);
    }

}
