package com.teamProject.syusyu.controller.fos.product;

import com.teamProject.syusyu.common.ViewPath;
import com.teamProject.syusyu.domain.cs.SearchCondition;
import com.teamProject.syusyu.domain.product.ReviewDTO;
import com.teamProject.syusyu.service.fos.product.FOS_ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(ViewPath.FOS)
public class FOS_ReviewController {

    @Autowired
    FOS_ReviewService reviewService;

    @GetMapping("reviewWrite")
    public String showReviewWriteForm(){

        return ViewPath.FOS_PRODUCT+"FOS_ReviewWrite";
    }

    @PostMapping("reviewWrite")
    public String write(ReviewDTO reviewDTO, Model m, RedirectAttributes rattr , @SessionAttribute int mbrId ) throws Exception{

        try {
            reviewDTO.setRegrId(mbrId);
            m.addAttribute("reviewDTO",reviewDTO);

            reviewService.write(reviewDTO);
            System.out.println("mbrId = " + mbrId);

            rattr.addFlashAttribute("msg","WRT_OK");
        } catch (Exception e) {
            e.printStackTrace();

            rattr.addFlashAttribute("reviewDTO",reviewDTO);
            rattr.addFlashAttribute("msg","WRT_ERR");
        }
        return "redirect:/fos/products";
    }


    @PostMapping("reviewRemoveUser")
    public String removeUser(Integer revwNo, ReviewDTO reviewDTO, SearchCondition sc, Model m ,RedirectAttributes rattr , @SessionAttribute int mbrId){

        try {
            reviewDTO.setRegrId(mbrId);

            m.addAttribute("sc",sc);
            System.out.println("revwNo = " + revwNo);

            reviewService.removeUser(revwNo,reviewDTO.getRegrId());
            rattr.addFlashAttribute("msg","DEL_OK");
        } catch (Exception e) {
           e.printStackTrace();
           rattr.addFlashAttribute("msg","DEL_ERR");
        }
        return "redirect:/fos/products";
    }

//    @GetMapping("reviewList")
//    public String list(SearchCondition sc , Model m ){
//        int totalCnt;
//    }

}
