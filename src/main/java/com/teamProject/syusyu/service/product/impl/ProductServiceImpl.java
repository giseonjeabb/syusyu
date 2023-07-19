package com.teamProject.syusyu.service.product.impl;

import com.teamProject.syusyu.dao.product.ProductDAO;
import com.teamProject.syusyu.domain.product.ProductDTO;
import com.teamProject.syusyu.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductDAO productDAO;

    /**
     * 중분류 번호를 소분류 번호를 사용하여 해당 카테고리에 속한 상품 목록을 가져오는 메소드입니다.
     *
     * @param middleNo 중분류 번호.
     * @param smallNo  소분류 번호.
     * @return 상품 목록과 총 상품 개수, 카테고리 목록을 담은 Map 객체를 반환합니다.
     * @throws Exception 상품 서비스에서 상품 목록을 가져오는 도중 발생할 수 있는 예외
     * @author soso
     * @since 2023/07/07
     */
    @Override
    public Map<String, Object> getProductList(int middleNo, int smallNo) throws Exception {
        List<ProductDTO> productList = productDAO.selectProductList(middleNo, smallNo);
        int prodListTot = productList.size();
        Map<String, Object> map = new HashMap<>();
        map.put("productList", productList);
        map.put("prodListTot", prodListTot);
        return map;
    }

    /**
     * 중분류 번호를 사용하여 해당 카테고리에 속한 모든 상품 목록을 가져오는 메소드입니다.
     *
     * @param middleNo 중분류 번호.
     * @return 해당 중분류 번호에 속한 상품 목록과 총 상품 개수, 카테고리 목록을 담은 Map 객체를 반환합니다.
     * @throws Exception 상품 서비스에서 상품 목록을 가져오는 도중 발생할 수 있는 예외
     * @author soso
     * @since 2023/07/07
     */
    @Override
    public Map<String, Object> getProductAllList(int middleNo) throws Exception{
        List<ProductDTO> productList = productDAO.selectProductAllList(middleNo);
        int prodListTot = productList.size();

        Map<String, Object> map = new HashMap<>();
        map.put("productList", productList);
        map.put("prodListTot", prodListTot);
        return map;
    }


    @Override
    public List<ProductDTO> getProductStatus(int[] prodIdArr) throws Exception {
        return productDAO.selectProductStatus(prodIdArr);
    }

    @Override
    public ProductDTO getProduct(int prodId) throws Exception{
        return productDAO.selectProduct(prodId);
    }
}
