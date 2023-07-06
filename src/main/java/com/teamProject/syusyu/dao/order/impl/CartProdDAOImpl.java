package com.teamProject.syusyu.dao.order.impl;

import com.teamProject.syusyu.dao.order.CartProdDAO;
import com.teamProject.syusyu.domain.order.CartProdDTO;
import com.teamProject.syusyu.domain.order.CartTotalDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class CartProdDAOImpl implements CartProdDAO {
    @Autowired
    private SqlSession session;
    private static final String namespace = "com.teamProject.syusyu.cartMapper.";

    @Override
    public int insert(CartProdDTO cartProductDTO) throws Exception {
        return session.insert(namespace + "insert", cartProductDTO);
    }

    @Override
    public List<CartProdDTO> selectAll(int mbrId) throws Exception {
        return session.selectList(namespace + "selectAll", mbrId);
    }

    @Override
    public int update(CartProdDTO cartProductDTO) throws Exception {
        return session.update(namespace + "update", cartProductDTO);
    }

    @Override
    public int delete(int[] cartProdNo, int delrId) throws Exception {
        Map<String, Object> deleteParam = new HashMap<>();
        deleteParam.put("cartProdNo", cartProdNo);
        deleteParam.put("delrId", delrId + "");

        return session.delete(namespace + "delete", deleteParam);
    }

    @Override
    public int deleteAll() throws Exception {
        return session.delete(namespace + "deleteAll");
    }

    @Override
    public CartTotalDTO selectCartTotal(int mbrId) throws Exception {
        return session.selectOne(namespace + "selectCartTotal", mbrId);
    }

}
