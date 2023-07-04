package com.teamProject.syusyu.service.product.impl;

import com.teamProject.syusyu.dao.product.ProductDAO;
import com.teamProject.syusyu.domain.product.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements com.teamProject.syusyu.service.product.ProductService {

    @Autowired
    private ProductDAO productDAO;

    @Override
    public List<ProductDTO> getProductList(int middleNo, int smallNo) throws Exception {
        return productDAO.getProductList(middleNo, smallNo);
    }

}
