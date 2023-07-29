package com.teamProject.syusyu.dao.product.impl;

import com.teamProject.syusyu.domain.product.BrandDTO;
import com.teamProject.syusyu.dao.product.BrandDAO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BrandDAOImpl implements BrandDAO {
    @Autowired
    private SqlSession session;
    private static final String namespace = "com.teamProject.syusyu.brandMapper.";

    @Override
    public List<BrandDTO> selectBrandList(){
        return session.selectList(namespace+"selectBandList");
    }

}
