package com.teamProject.syusyu.controller.product;

import com.teamProject.syusyu.common.ViewPath;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class plodListController {

    @GetMapping("/prodList")
    public String showPlodList(){
        return ViewPath.PRODUCT +"prodList";
    }
}
