package com.teamProject.syusyu.service.product.impl;

import com.teamProject.syusyu.dao.product.ProductDAO;
import com.teamProject.syusyu.domain.product.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public class ProductServiceImpl implements com.teamProject.syusyu.service.product.ProductService {

    @Autowired
    ProductDAO productDAO;

    @Override
    public Map<String, Object> getProductList(int middleNo, int smallNo) throws Exception {
        List<ProductDTO> productList= productDAO.selectProductList(middleNo, smallNo);
        int prodListTot= productList.size();
        Map<String, Object> map= new HashMap<>();
        map.put("productList",productList);
        map.put("prodListTot",prodListTot);
        return map;
    }

    @Override
    public List<ProductDTO> getProductAllList(int middleNo){
        return productDAO.selectProductAllList(middleNo);
    }


}
