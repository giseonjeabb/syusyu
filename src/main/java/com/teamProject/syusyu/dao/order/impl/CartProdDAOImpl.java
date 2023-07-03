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
    private static final String namespace = "com.teamProject.syusyu.cartMapper.";

    @Override
    public int insert(CartProductDTO cartProductDTO) throws Exception {
        return session.insert(namespace + "insert", cartProductDTO);
    }

    @Override
    public List<CartProductDTO> select(int mbrId) throws Exception {
        return session.selectList(namespace + "select", mbrId);
    }

    @Override
    public int update(CartProductDTO cartProductDTO) throws Exception {
        return session.update(namespace + "update", cartProductDTO);
    }

    @Override
    public int delete(int[] cartProdId) throws Exception {
        return session.delete(namespace + "delete", cartProdId);
    }

    @Override
    public int deleteAll() throws Exception {
        return session.delete(namespace + "deleteAll");
    }

}
