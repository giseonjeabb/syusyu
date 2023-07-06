package com.teamProject.syusyu.dao.product;

import com.teamProject.syusyu.domain.product.ProductDTO;

import java.util.List;

public interface ProductDAO {
    List<ProductDTO> selectProductList(int middleNo, int smallNo) throws Exception;

    List<ProductDTO> selectProductAllList(int middleNo);

    List<ProductDTO> selectProductStatus(int[] prodId) throws Exception;


}
