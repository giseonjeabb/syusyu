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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class ProductController {

    @Autowired
    CategoryService categoryService;
    @Autowired
    ProductService productService;


    @GetMapping("productList")
    public String getProductList(Integer middleNo, Integer smallNo, Model m) {

        try {
            System.out.println("g호ㅓㅏㄱ인확ㄴ");
            if (middleNo == null || smallNo == null) {
                middleNo = 1;
                smallNo = 1;
            }

            //카테고리 중분류별로 소분류 출력
//            List<CategoryDTO> categoryList = categoryService.getCategoryList(middleNo);
//            m.addAttribute("categoryList", categoryList);


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

        } catch (Exception e) {
            e.printStackTrace();
        }

        return ViewPath.FOS_PRODUCT + "productList";
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

    /**
     * 이 메소드는 모든 카테고리를 가져와서 세션에 저장하는 기능을 수행합니다.
     * HTTP GET 요청을 통해 호출되며, 반환 값은 모든 카테고리의 정보와 HTTP 상태 코드입니다.
     *
     * @param request HttpServletRequest 객체. 세션을 얻기 위해 사용됩니다.
     * @return categories가 null이면 HTTP 상태 코드 204(NO CONTENT)와 함께 null 반환, 그렇지 않으면 categories 객체와 HTTP 상태 코드 200(OK)를 ResponseEntity 객체로 반환.
     * @throws Exception 카테고리 서비스에서 카테고리 목록을 가져오는 도중 발생할 수 있는 예외
     * @author soso
     * @since 2023/07/06
     */
    @GetMapping("/categories")
    public ResponseEntity<Map<String, Object>> CategoryAllList(HttpServletRequest request) {
        Map<String, Object> categories = categoryService.getCategoryAllList();

        if (categories == null) {
            System.out.println("categories is null");
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        // 세션에 카테고리 저장
        HttpSession session = request.getSession();
        session.setAttribute("categories", categories);

        return new ResponseEntity<>(categories, HttpStatus.OK);
    }


}
