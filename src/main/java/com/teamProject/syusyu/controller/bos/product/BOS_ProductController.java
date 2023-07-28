package com.teamProject.syusyu.controller.bos.product;

import com.teamProject.syusyu.common.ViewPath;
import com.teamProject.syusyu.service.fos.product.FOS_CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping(ViewPath.BOS)
public class BOS_ProductController {

    @Autowired
    FOS_CategoryService bosCategoryService;

    @GetMapping("productRegister")
    public String addProduct(Model model){
        try {
            Map<String, Object> categories = bosCategoryService.getCategoryAllList();
            model.addAttribute("categories", categories);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return ViewPath.BOS_PRODUCT+"productRegister";
    }

}
