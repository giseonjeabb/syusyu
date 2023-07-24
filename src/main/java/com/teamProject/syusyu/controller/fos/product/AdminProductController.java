package com.teamProject.syusyu.controller.fos.product;

import com.teamProject.syusyu.common.ViewPath;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin")
public class AdminProductController {
    @GetMapping("productRegister")
    public String productRegister(){
        return ViewPath.BOS_PRODUCT+"productRegister";
    }
}
