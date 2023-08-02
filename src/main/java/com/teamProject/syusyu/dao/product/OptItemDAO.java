package com.teamProject.syusyu.dao.product;

import com.teamProject.syusyu.domain.product.OptItemDTO;
import com.teamProject.syusyu.domain.product.ProdOptDTO;

public interface OptItemDAO {
    int insertOptItem(OptItemDTO optItemDTO) throws Exception;
}
