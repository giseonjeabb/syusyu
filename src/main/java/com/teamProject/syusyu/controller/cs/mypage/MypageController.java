package com.teamProject.syusyu.controller.cs.mypage;

import com.teamProject.syusyu.common.ViewPath;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("mypage")
public class MypageController {
    @GetMapping("main")
    public String mainView() {
        return ViewPath.CS + "mypageMain";
    }
}
