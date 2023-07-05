package com.teamProject.syusyu.dao.product.impl;

import com.teamProject.syusyu.domain.product.ProductDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductDAOImpl implements com.teamProject.syusyu.dao.product.ProductDAO {

    @Autowired
    private SqlSession session;
    private static final String namespace = "com.teamProject.syusyu.productMapper.";

    @Override
    public List<ProductDTO> selectProductList(int middleNo, int smallNo){
        Map map = new HashMap<>();
        map.put("middleNo", middleNo);
        map.put("smallNo", smallNo);
        return session.selectList(namespace + "selectProductList", map);

    }

    @Override
    public List<ProductDTO> selectProductAllList(int middleNo){
        return session.selectList(namespace + "selectProductList", middleNo);

    }

}
