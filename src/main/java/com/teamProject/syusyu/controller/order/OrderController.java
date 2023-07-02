package com.teamProject.syusyu.controller.order;

import com.teamProject.syusyu.common.ViewPath;
import com.teamProject.syusyu.domain.order.CartProductDTO;
import com.teamProject.syusyu.service.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderService orderService;

    @GetMapping("/cart")
    public String getCart(Model model) {
        List<CartProductDTO> cartProductList = orderService.getCart(80001);
        model.addAttribute("cartProductList", cartProductList);

        return ViewPath.ORDER + "cart";
    }
}
