package com.teamProject.syusyu.service.bos.product;

import com.teamProject.syusyu.domain.product.ImageDTO;
import com.teamProject.syusyu.domain.product.ProductDTO;

import java.util.Map;

public interface BOS_ProductService {
    Map<String, Object> getProductInfo() throws Exception;

    int addProduct(ProductDTO productDTO) throws Exception;

    int addPrice(ProductDTO productDTO) throws Exception;

    int addSmlImg(ImageDTO imageDTO) throws Exception;

    int addOptGrp(ProductDTO productDTO) throws Exception;

    int addOptItem(ProductDTO productDTO) throws Exception;

    int addProdOpt(ProductDTO productDTO) throws Exception;

    int addProdOptComb(ProductDTO productDTO) throws Exception;
}
