package com.teamProject.syusyu.dao.product;

import com.teamProject.syusyu.domain.product.BrandDTO;

import java.util.List;

public interface BrandDAO {
    List<BrandDTO> selectBrandList();
}
