package com.teamProject.syusyu.controller.product;

import com.teamProject.syusyu.common.ViewPath;
import com.teamProject.syusyu.domain.product.CategoryDTO;
import com.teamProject.syusyu.domain.product.ProductDTO;
import com.teamProject.syusyu.service.product.CategoryService;
import com.teamProject.syusyu.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class ProductController {

    @Autowired
    CategoryService categoryService;
    @Autowired
    ProductService productService;

    @GetMapping("productList")
    public String getProductList(Integer middleNo, Integer smallNo, Model m){

        try{

            if(middleNo ==null || smallNo ==null){
                middleNo=1;
                smallNo=1;
            }

            //카테고리 중분류별로 소분류 출력
            List<CategoryDTO> categoryList = categoryService.getCategoryList(middleNo);
            m.addAttribute("categoryList", categoryList);


            // getProductList(카테고리별 상품리스트)메소드의 반환 값을 Map<String, Object>으로 변경
            Map<String, Object> productMap = productService.getProductList(middleNo, smallNo);


            //카테고리별 상품리스트 조회 및 총개수를 Map에서 꺼냄
            List<ProductDTO> productList = (List<ProductDTO>) productMap.get("productList");
            int prodListTot = (Integer) productMap.get("prodListTot");
            m.addAttribute("productList", productList);
            m.addAttribute("prodListTot", prodListTot);

            //카테고리 중분류별 총 상품리스트
            List<ProductDTO> productAllList = productService.getProductAllList(middleNo);
            m.addAttribute("productAllList", productAllList);

        }catch (Exception e) {
            e.printStackTrace();
        }

        return ViewPath.FOS_PRODUCT +"productList";
    }

    @GetMapping("productStatus")
    @ResponseBody
    public ResponseEntity<List<ProductDTO>> getProductStatus(int[] prodIdArr) {
        List<ProductDTO> productStatusList = null;

        try {
            productStatusList = productService.getProductStatus(prodIdArr);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(productStatusList, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(productStatusList, HttpStatus.OK);
    }

}
