package com.teamProject.syusyu.controller.bos.product;

import com.teamProject.syusyu.common.ViewPath;
import com.teamProject.syusyu.service.fos.product.FOS_CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(ViewPath.BOS)
public class BOS_ProductController {

    @Autowired
    FOS_CategoryService FOSFOSCategoryService;


}
