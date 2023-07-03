package com.teamProject.syusyu.controller.product;

import com.teamProject.syusyu.common.ViewPath;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("product")
public class ProdListController {

    @GetMapping("prodList")
    public String showPlodList(){
        return ViewPath.PRODUCT +"prodList";
    }
}
