package com.teamProject.syusyu.service.product.impl;

import com.teamProject.syusyu.dao.product.CategoryDAO;
import com.teamProject.syusyu.domain.product.CategoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements com.teamProject.syusyu.service.product.CategoryService {

    @Autowired
    private CategoryDAO categoryDao;

    @Override
    public List<CategoryDTO> getCategory(int middleNo) throws Exception{
        List<CategoryDTO> categoryDto= categoryDao.getCategory(middleNo);
        return categoryDao.getCategory(middleNo);
    }
}
