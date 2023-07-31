package com.teamProject.syusyu.dao.product;

import com.teamProject.syusyu.domain.product.ProdOptDTO;
import com.teamProject.syusyu.domain.product.ProductDTO;

import java.util.List;

public interface ProdOptDAO {
    List<ProdOptDTO> selectProdOptSizeList(int prodId);


    int insertOptGrp(ProdOptDTO prodOptDTO) throws Exception;

    int insertOptItem(ProdOptDTO prodOptDTO) throws Exception;

    int insertProdOpt(ProdOptDTO prodOptDTO) throws Exception;

    int insertProdOptComb(ProdOptDTO prodOptDTO) throws Exception;
}
