package com.teamProject.syusyu.service.fos.product;

import com.teamProject.syusyu.domain.product.ProductDTO;

import java.util.List;
import java.util.Map;

public interface FOS_ProductService {

    Map<String, Object> getProductList(int middleNo, int smallNo) throws Exception;

    Map<String, Object> getProductAllList(int middleNo) throws Exception;


    List<ProductDTO> getProductStatus(int[] prodId) throws Exception;

    Map<String, Object> getProduct(int prodId) throws Exception;

}
