package com.teamProject.syusyu.service.bos.product;

import com.teamProject.syusyu.domain.product.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface BOS_ProductService {
    Map<String, Object> getProductInfo() throws Exception;

    public void addProductData(ProductDTO product,
                               PriceDTO price,
                               List<ImageDTO> smlImgDTOs,
                               List<OptGrpDTO> optGrpNmList,
                               List<ProdOptDTO> prodOptList,
                               List<OptItemDTO> optItemDTOList,
                               int mbrId
    ) throws Exception;

//    Map<String, Object> getProductBosList(SearchConditionDTO searchConditionDTO);

    List<ProductDTO> getProductBosList(SearchConditionDTO searchConditionDTO);
}
