package com.teamProject.syusyu.controller.bos.product;

import com.teamProject.syusyu.common.ViewPath;
import com.teamProject.syusyu.domain.cs.PageHandler;
import com.teamProject.syusyu.domain.cs.SearchCondition;
import com.teamProject.syusyu.domain.product.ReviewDTO;
import com.teamProject.syusyu.service.bos.product.BOS_ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

@Controller
@RequestMapping(ViewPath.BOS)
public class BOS_ReviewController {

    @Autowired
    BOS_ReviewService reviewService;

    @GetMapping("reviewList")
    public String list(Model m , SearchCondition sc)throws Exception{
        try {
            int totalCnt = reviewService.getSearchResultCntReview(sc) ;
            m.addAttribute("totalCnt",totalCnt);

            PageHandler pageHandler = new PageHandler(totalCnt,sc);

            List<ReviewDTO> list = reviewService.getSearchSelectPageReview(sc);
            System.out.println("BOS_ReviewList = " + list);

            m.addAttribute("list",list);
            m.addAttribute("ph",pageHandler);

            Instant startOfToday = LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant();
            m.addAttribute("startOfToday", startOfToday.toEpochMilli());
        } catch (Exception e) {
            e.printStackTrace();
            m.addAttribute("msg","LIST_ERR");
            m.addAttribute("totalCnt",0);
        }
        return ViewPath.BOS_PRODUCT+"BOS_ReviewList";

    }
    @PostMapping("reviewRemoveAdmin")
    public String removeUser(Integer revwNo, ReviewDTO reviewDTO, SearchCondition sc, Model m , RedirectAttributes rattr , @SessionAttribute int mbrId){

        try {
            reviewDTO.setRegrId(mbrId);

            m.addAttribute("sc",sc);
            System.out.println("revwNo = " + revwNo);

            reviewService.removeAdmin(revwNo);
            rattr.addFlashAttribute("msg","DEL_OK");
        } catch (Exception e) {
            e.printStackTrace();
            rattr.addFlashAttribute("msg","DEL_ERR");
        }
        return "redirect:/bos/reviewList";
    }

}
