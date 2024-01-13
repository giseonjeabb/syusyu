package com.teamProject.syusyu.dao.product;

import com.teamProject.syusyu.domain.product.ProdOptDTO;

import java.util.List;
import java.util.Map;

public interface ProdOptDAO {
    List<ProdOptDTO> selectProdOptSizeList(int prodId);

    int insertProdOpt(ProdOptDTO prodOptDTO) throws Exception;

    List<ProdOptDTO> selectProductQty(int[] optCombNoArr) throws Exception;

    int decreaseProdQty(Map<String, Integer> param) throws Exception;

    int updateProdQty(Map<String, Integer> param) throws Exception;
}
