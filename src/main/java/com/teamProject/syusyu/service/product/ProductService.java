package com.teamProject.syusyu.service.product;

import com.teamProject.syusyu.domain.product.ProductDTO;

import java.util.List;
import java.util.Map;

public interface ProductService {

    Map<String, Object> getProductList(int middleNo, int smallNo) throws Exception;

    List<ProductDTO> getProductAllList(int middleNo);


    List<ProductDTO> getProductStatus(int[] prodId) throws Exception;
}
