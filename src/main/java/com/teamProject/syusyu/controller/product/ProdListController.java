package com.teamProject.syusyu.controller.product;

import com.teamProject.syusyu.common.ViewPath;
import com.teamProject.syusyu.domain.product.CategoryDTO;
import com.teamProject.syusyu.domain.product.ProductDTO;
import com.teamProject.syusyu.service.product.CategoryService;
import com.teamProject.syusyu.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("product")
public class ProdListController {

    @Autowired
    CategoryService categoryService;
    ProductService productService;

    @GetMapping("prodList")
    public String showPlodList(Model m){

        try{
            List<CategoryDTO> cateList = categoryService.getCategory(1);
            m.addAttribute("cateList", cateList);
            System.out.println(cateList);

            int middleNo=1;
            int smallNo=1;


            List<ProductDTO> productList=productService.getProductList(middleNo, smallNo);
            m.addAttribute("prodList");
            System.out.println("-------->"+m);

        }catch (Exception e) {
            e.printStackTrace();
        }


        return ViewPath.PRODUCT +"prodList";
    }
}
