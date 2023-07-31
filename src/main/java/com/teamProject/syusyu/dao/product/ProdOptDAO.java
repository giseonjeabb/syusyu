package com.teamProject.syusyu.dao.product;

import com.teamProject.syusyu.domain.product.ProdOptDTO;
import com.teamProject.syusyu.domain.product.ProductDTO;

import java.util.List;

public interface ProdOptDAO {
    List<ProdOptDTO> selectProdOptSizeList(int prodId);

    int insertOptGrp(ProductDTO productDTO) throws Exception;

    int insertOptItem(ProductDTO productDTO) throws Exception;

    int insertProdOpt(ProductDTO productDTO) throws Exception;

    int insertProdOptComb(ProductDTO productDTO) throws Exception;
}
