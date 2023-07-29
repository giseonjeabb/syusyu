package com.teamProject.syusyu.service.bos.product.impl;

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

    @Override
    public Map<String, Object> getProductInfo() throws Exception {
        List<BrandDTO> brands=brandDAO.selectBrandList();

        Map<String, Object> map = new HashMap<>();
        map.put("brands", brands);
        return map;

    }
}
