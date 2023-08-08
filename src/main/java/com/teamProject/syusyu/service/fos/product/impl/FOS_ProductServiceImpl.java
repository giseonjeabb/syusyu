package com.teamProject.syusyu.service.fos.product.impl;

import com.teamProject.syusyu.dao.product.ImageDAO;
import com.teamProject.syusyu.dao.product.ProdOptDAO;
import com.teamProject.syusyu.dao.product.ProductDAO;
import com.teamProject.syusyu.domain.product.ImageDTO;
import com.teamProject.syusyu.domain.product.ProdOptDTO;
import com.teamProject.syusyu.domain.product.ProductDTO;
import com.teamProject.syusyu.service.fos.product.FOS_ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FOS_ProductServiceImpl implements FOS_ProductService {
    @Autowired
    ProductDAO productDAO;

    @Autowired
    ProdOptDAO prodOptDAO;

    @Autowired
    ImageDAO imageDAO;

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
    public Map<String, Object> getProductList(int middleNo, int smallNo, String sort) throws Exception {
        List<ProductDTO> productList = productDAO.selectProductList(middleNo, smallNo, sort);
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
     * @param sort     정렬 방식을 나타내는 문자열.
     * @return 해당 중분류 번호에 속한 상품 목록과 총 상품 개수, 카테고리 목록을 담은 Map 객체를 반환합니다.
     * @throws Exception 상품 서비스에서 상품 목록을 가져오는 도중 발생할 수 있는 예외
     * @author soso
     * @since 2023/07/07
     */
    @Override
    public Map<String, Object> getProductAllList(int middleNo, String sort) throws Exception {
        List<ProductDTO> productList = productDAO.selectProductAllList(middleNo, sort);
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

    /**
     * 상품 ID를 사용하여 해당 상품의 상세 정보, 이미지 리스트, 상품 옵션 사이즈 리스트를 가져오는 메소드입니다.
     *
     * @param prodId 상품 ID.
     * @return 해당 상품 ID에 대한 상세 정보, 이미지 리스트, 상품 옵션 사이즈 리스트를 담은 Map 객체를 반환합니다.
     * @throws Exception 상품 서비스에서 상품 정보를 가져오는 도중 발생할 수 있는 예외
     * @author soso
     * @since 2023/07/19
     */
    @Override
    public Map<String, Object> getProduct(int prodId) throws Exception {
        ProductDTO productDetail = productDAO.selectProduct(prodId);
        List<ImageDTO> imageList = imageDAO.selectImageList(prodId);
        List<ProdOptDTO> shoesSizeList = prodOptDAO.selectProdOptSizeList(prodId);
        Map<String, Object> map = new HashMap<>();
        map.put("productDetail", productDetail);
        map.put("imageList", imageList);
        map.put("shoesSizeList", shoesSizeList);

        return map;
    }

    @Override
    public Map<String,List<ProductDTO>> getDspyProductList()throws Exception{
        List<ProductDTO> newProductList= productDAO.selectNewProductList();
        List<ProductDTO> pickProductList= productDAO.selectPickProductList();
        List<ProductDTO> popularProductList= productDAO.selectPopularProductList();
        Map<String, List<ProductDTO>> map=new HashMap<>();
        map.put("newProductList", newProductList);
        map.put("pickProductList", pickProductList);
        map.put("popularProductList", popularProductList);
        return map;
    }
}
