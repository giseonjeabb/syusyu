package com.teamProject.syusyu.dao.product;

import com.teamProject.syusyu.domain.product.ProdOptCombDTO;

import java.util.List;


public interface ProdOptCombDAO {
    int insertProdOptCombList(List<ProdOptCombDTO> prodOptCombDTOList) throws Exception;


}
