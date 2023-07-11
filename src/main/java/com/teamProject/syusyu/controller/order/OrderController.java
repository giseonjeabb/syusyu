package com.teamProject.syusyu.controller.order;

import com.teamProject.syusyu.common.ViewPath;
import com.teamProject.syusyu.domain.order.Order;
import com.teamProject.syusyu.domain.order.*;
import com.teamProject.syusyu.service.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class OrderController {
    private final OrderService service;

    @Autowired
    public OrderController(OrderService service) {
        this.service = service;
    }

    /**
     * 주문서에 필요한 정보들을 조회해서 주문서 화면에 넘겨준다.
     *
     * @param cartProdNoArr 주문할 장바구니상품아이디 배열
     * @param mbrId         장바구니를 조회할 사용자의 아이디
     * @return 주문서에 필요한 정보들(주문상품정보, 주문자정보, 배송지정보, 할인정보)
     * @author min
     * @since 2023/07/07
     */
    @GetMapping("/orderSheet")
    public String orderSheet(Model m, int[] cartProdNoArr, @SessionAttribute int mbrId) {
        try {
            Map<String, Object> orderInfo = service.orderSheet(cartProdNoArr, mbrId);
            m.addAttribute("cartProdList", orderInfo.get("cartProdList"));
            m.addAttribute("memberInfo", orderInfo.get("memberInfo"));
            m.addAttribute("dlvAddr", orderInfo.get("dlvAddr"));
            m.addAttribute("couponCnt", orderInfo.get("couponCnt"));
            m.addAttribute("totPoint", orderInfo.get("totPoint"));
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }

        return ViewPath.FOS_ORDER + "orderSheet";
    }

    /**
     * 주문을 생성한다.
     *
     * @param orderRequestDTO 주문 요청 DTO
     * @param mbrId           주문자 아이디
     * @return 주문 생성 결과 메시지
     * @author min
     * @since 2023/07/11
     */
    @PostMapping("/order")
    @ResponseBody
    public ResponseEntity<String> order(@RequestBody OrderRequestDTO orderRequestDTO, @SessionAttribute int mbrId) {
        System.out.println("orderRequestDTO = " + orderRequestDTO);
        System.out.println("orderRequestDTO.getOrderProductList() = " + orderRequestDTO.getOrderProductList());

        Order order = new Order(orderRequestDTO, mbrId);
        try {
            service.order(order);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("ADD_ERR", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>("ADD_OK", HttpStatus.OK);
    }
}
