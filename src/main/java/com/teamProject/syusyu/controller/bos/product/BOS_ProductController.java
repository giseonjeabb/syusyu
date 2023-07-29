package com.teamProject.syusyu.controller.bos.product;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.teamProject.syusyu.common.ViewPath;
import com.teamProject.syusyu.domain.order.CartProdDTO;
import com.teamProject.syusyu.domain.product.CategoryDTO;
import com.teamProject.syusyu.domain.product.ProductDTO;
import com.teamProject.syusyu.service.fos.product.FOS_CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(ViewPath.BOS)
public class BOS_ProductController {

    @Autowired
    FOS_CategoryService CategoryService;

    @GetMapping("productRegister")
    public String addProduct(Model model){
        Map<String, Object> categories =null;
        try {
            categories=CategoryService.getCategoryAllList();
            model.addAttribute("categories", categories);

            List<CategoryDTO> allCategory = (List<CategoryDTO>)categories.get("cateList");
            ObjectMapper mapper = new ObjectMapper();
            String jsonCateList = mapper.writeValueAsString(allCategory);  // List를 JSON 문자열로 변환
            model.addAttribute("jsonCateList", jsonCateList);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return ViewPath.BOS_PRODUCT+"productRegister";
    }

    @PostMapping("productRegister")
    public ResponseEntity<String> addProduct(@RequestBody List<ProductDTO> productDTOList){
        try {



//            service.addProductsIntoCart(cartProductDTOList); // 수정된 메소드를 호출합니다.
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("ADD_ERR", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>("ADD_OK", HttpStatus.OK);
    }
}
