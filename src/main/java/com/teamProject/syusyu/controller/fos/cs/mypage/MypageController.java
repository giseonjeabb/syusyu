package com.teamProject.syusyu.controller.fos.cs.mypage;

import com.teamProject.syusyu.common.ViewPath;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("mypage")
public class MypageController {
    @GetMapping("main")
    public String mainView() {
        return ViewPath.FOS_MYPAGE + "mypageMain";
    }
}
