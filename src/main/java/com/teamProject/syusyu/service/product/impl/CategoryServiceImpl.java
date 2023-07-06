package com.teamProject.syusyu.service.product.impl;

import com.teamProject.syusyu.dao.product.CategoryDAO;
import com.teamProject.syusyu.domain.product.CategoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements com.teamProject.syusyu.service.product.CategoryService {

    @Autowired
    CategoryDAO categoryDAO;

    @Override
    public List<CategoryDTO> getCategoryList(int middleNo) throws Exception {
        List<CategoryDTO> getCategoryList = categoryDAO.selectCategoryList(middleNo);
        return categoryDAO.selectCategoryList(middleNo);
    }
}
