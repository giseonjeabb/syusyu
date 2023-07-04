package com.teamProject.syusyu.dao.product;

import com.teamProject.syusyu.domain.product.ProductDTO;

import java.util.List;

public interface ProductDAO {
    List<ProductDTO> getProductList(int middleNo, int smallNo) throws Exception;

    List<ProductDTO> selectProductStatus(int[] prodId) throws Exception;


}
