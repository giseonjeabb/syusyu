package com.teamProject.syusyu.service.product;

import com.teamProject.syusyu.domain.product.CategoryDTO;

import java.util.List;

public interface CategoryService {
    List<CategoryDTO> getCategoryList(int middleNo) throws Exception;
}
