package com.teamProject.syusyu.dao.product;

import com.teamProject.syusyu.domain.product.PriceDTO;

public interface PriceDAO {
    int insertPrice(PriceDTO priceDTO) throws Exception;

}
