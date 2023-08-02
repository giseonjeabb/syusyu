package com.teamProject.syusyu.service.bos.product;

import com.teamProject.syusyu.domain.product.*;

import java.util.List;
import java.util.Map;

public interface BOS_ProductService {
    Map<String, Object> getProductInfo() throws Exception;

    void addProductData(ProductDTO product,
                               PriceDTO price,
                               List<ImageDTO> smlImgDTOs,
                               List<ProdOptDTO> prodOptList,
                               List<OptItemDTO> optItemDTOList,
                               List<OptGrpDTO> optGrpDTOList) throws Exception;
}
