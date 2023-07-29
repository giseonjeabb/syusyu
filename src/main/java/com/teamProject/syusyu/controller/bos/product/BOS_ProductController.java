package com.teamProject.syusyu.controller.bos.product;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.teamProject.syusyu.common.ViewPath;
import com.teamProject.syusyu.domain.product.BrandDTO;
import com.teamProject.syusyu.domain.product.CategoryDTO;
import com.teamProject.syusyu.domain.product.ProductDTO;
import com.teamProject.syusyu.service.bos.product.BOS_ProductService;
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
    @Autowired
    BOS_ProductService productService;

    @GetMapping("productRegister")
    public String addProduct(Model model){
        Map<String, Object> categories =null;
        List<CategoryDTO> allCategory=null;
        Map<String, Object> productInfo=null; //brand, 제조사, 제조국 정보
        try {
            //select에 들어갈 category
            categories=CategoryService.getCategoryAllList();
            model.addAttribute("categories", categories);

            //카테고리json문자열로 바꾸고 자스에서 select된 카테고리들 비교해서 cateId찾기.
            allCategory = (List<CategoryDTO>)categories.get("cateList");
            ObjectMapper mapper = new ObjectMapper();
            String jsonCateList = mapper.writeValueAsString(allCategory);  // List를 JSON 문자열로 변환
            model.addAttribute("jsonCateList", jsonCateList);

            //브랜드, 제조사, 제조국 화면에 나오게하기.
            List<BrandDTO> brandList=(List<BrandDTO>) productService.getProductInfo().get("brandList");
            List<BrandDTO> mftNatnList=(List<BrandDTO>) productService.getProductInfo().get("mftNatnList");
            List<BrandDTO> mftcoList=(List<BrandDTO>) productService.getProductInfo().get("mftcoList");
            model.addAttribute("brandList", brandList);
            model.addAttribute("mftNatnList", mftNatnList);
            model.addAttribute("mftcoList", mftcoList);


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
