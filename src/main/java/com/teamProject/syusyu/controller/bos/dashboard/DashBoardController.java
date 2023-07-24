package com.teamProject.syusyu.controller.bos.dashboard;

import com.teamProject.syusyu.common.ViewPath;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin")
public class DashBoardController {

    @GetMapping("dashboard")
    public String dashBoardMain(){
        return ViewPath.BOS_DASHBOARD +"dashboard";
    }
}

