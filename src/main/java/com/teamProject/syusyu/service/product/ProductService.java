package com.teamProject.syusyu.service.product;

import com.teamProject.syusyu.domain.product.ProductDTO;

import java.util.List;
import java.util.Map;

public interface ProductService {

    List<ProductDTO> getProductList(int middleNo, int smallNo) throws Exception;
}
