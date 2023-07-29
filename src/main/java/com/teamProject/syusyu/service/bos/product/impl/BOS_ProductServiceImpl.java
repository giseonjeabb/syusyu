package com.teamProject.syusyu.service.bos.product.impl;

import com.teamProject.syusyu.dao.product.ProductDAO;
import com.teamProject.syusyu.domain.product.ProductDTO;
import com.teamProject.syusyu.service.bos.product.BOS_ProductService;
import com.teamProject.syusyu.dao.product.BrandDAO;
import com.teamProject.syusyu.domain.product.BrandDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BOS_ProductServiceImpl implements BOS_ProductService {

    @Autowired
    BrandDAO brandDAO;

    @Autowired
    ProductDAO productDAO;

    @Override
    public Map<String, Object> getProductInfo() throws Exception {
        List<BrandDTO> brandList = brandDAO.selectBrandList();
        List<ProductDTO> mftNatnList = productDAO.selectMftNatnList();
        List<ProductDTO> mftcoList = productDAO.selectMftcoList();

        Map<String, Object> map = new HashMap<>();
        map.put("brandList", brandList);
        map.put("mftNatnList", mftNatnList);
        map.put("mftcoList", mftcoList);
        return map;

    }
}
