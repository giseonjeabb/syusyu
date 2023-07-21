package com.teamProject.syusyu.dao.product;

import com.teamProject.syusyu.domain.product.ProdOptDTO;

import java.util.List;

public interface ProdOptDAO {
    List<ProdOptDTO> selectProdOptSizeList(int prodId);
}
