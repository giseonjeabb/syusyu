package com.teamProject.syusyu.dao.product;

import com.teamProject.syusyu.domain.product.CategoryDTO;

import java.util.List;

public interface CategoryDAO {
    List<CategoryDTO> selectCategoryAllList();
}
