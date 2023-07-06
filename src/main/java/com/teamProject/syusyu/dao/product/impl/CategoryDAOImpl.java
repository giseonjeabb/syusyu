package com.teamProject.syusyu.dao.product.impl;

import com.teamProject.syusyu.domain.product.CategoryDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryDAOImpl implements com.teamProject.syusyu.dao.product.CategoryDAO {
    @Autowired
    private SqlSession session;
    private static final String namespace = "com.teamProject.syusyu.categoryMapper.";

    @Override
    public List<CategoryDTO> selectCategoryList(int middleNo){
        return session.selectList(namespace + "selectCategoryList", middleNo);
    }
}
