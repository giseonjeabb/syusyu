package com.teamProject.syusyu.dao.product;

import com.teamProject.syusyu.domain.product.ImageDTO;
import com.teamProject.syusyu.domain.product.ProductDTO;

import java.util.List;

public interface ProductDAO {
    List<ProductDTO> selectProductList(int middleNo, int smallNo, String sort) throws Exception;

    List<ProductDTO> selectProductAllList(int middleNo, String sort) throws Exception;

    List<ProductDTO> selectProductStatus(int[] prodId) throws Exception;

    ProductDTO selectProduct(int prodId) throws Exception;

    List<ProductDTO> selectMftNatnList();

    List<ProductDTO> selectMftcoList();

    int insertProduct(ProductDTO productDTO) throws Exception;

}
