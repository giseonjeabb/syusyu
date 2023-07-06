package com.teamProject.syusyu.service.product;

import com.teamProject.syusyu.domain.product.ProductDTO;

import java.util.List;

public interface ProductService {
    List<ProductDTO> getProductList(int middleNo, int smallNo) throws Exception;

    List<ProductDTO> getProductStatus(int[] prodId) throws Exception;
}
