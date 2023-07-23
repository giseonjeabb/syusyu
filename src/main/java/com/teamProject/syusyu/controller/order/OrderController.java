package com.teamProject.syusyu.controller.order;

import com.teamProject.syusyu.common.ViewPath;
import com.teamProject.syusyu.domain.member.CouponDTO;
import com.teamProject.syusyu.domain.order.Order;
import com.teamProject.syusyu.domain.order.*;
import com.teamProject.syusyu.service.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
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
            m.addAttribute("cartProdList", orderInfo.get("cartProdList")); // 주문상품정보
            m.addAttribute("memberInfo", orderInfo.get("memberInfo"));     // 주문자정보
            m.addAttribute("dlvAddr", orderInfo.get("dlvAddr"));           // 배송지정보
            m.addAttribute("couponCnt", orderInfo.get("couponCnt"));       // 할인정보 - 쿠폰
            m.addAttribute("totPoint", orderInfo.get("totPoint"));         // 할인정보 - 포인트
            m.addAttribute("totProdAmt", orderInfo.get("totProdAmt"));     // 총 주문금액 - 총 상품금액
            m.addAttribute("dlvFee", orderInfo.get("dlvFee"));             // 총 주문금액 - 배송비
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
    @PostMapping("/orders")
    @ResponseBody
    public ResponseEntity<String> order(@RequestBody OrderRequestDTO orderRequestDTO, @SessionAttribute int mbrId) {
        try {
            service.order(new Order(orderRequestDTO, mbrId));
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("ADD_ERR", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>("ADD_OK", HttpStatus.OK);
    }

    /**
     * 사용자가 주문/결제 시 사용할 수 있는 쿠폰 리스트를 조회한다.
     * 총 상품금액에 따라 사용 가능한 쿠폰들이 달라진다.(최소 주문금액 만족해야 함)
     *
     * @param mbrId 세션에서 가져온 사용자 ID
     * @param totProdAmt 총 상품금액
     * @return 사용 가능한 쿠폰 리스트
     * @author min
     * @since  2023/07/16
     */
    @GetMapping("/orders/available-coupons")
    @ResponseBody
    public ResponseEntity<List<CouponDTO>> orderCouponList(@SessionAttribute int mbrId, int totProdAmt) {
        List<CouponDTO> couponList = null;
        try {
            couponList = service.getOrderCouponList(mbrId, totProdAmt);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(couponList, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(couponList, HttpStatus.OK);
    }

    /**
     * 사용자의 주문 정보를 조회한다.
     * 세션에서 사용자 ID를 가져오고, 요청 파라미터로부터 조회 시작일과 종료일을 받아 해당 기간 동안의 주문 정보를 조회한다.
     *
     * @param mbrId 세션에서 가져온 사용자 ID
     * @param startDate 시작일
     * @param endDate 종료일
     * @return 해당 기간 동안의 주문 정보를 담은 OrderInfoDTO 객체의 리스트를 담은 ResponseEntity 객체.
     *         조회에 성공한 경우 상태 코드는 OK(200), 실패한 경우 BAD_REQUEST(400)를 반환한다.
     * @author min
     * @since 2023/07/18
     */
    @GetMapping("/orders")
    @ResponseBody
    public ResponseEntity<Map<Integer, List<OrderInfoDTO>>> orderInfo(@SessionAttribute int mbrId, String startDate, String endDate) {
        Map<Integer, List<OrderInfoDTO>> orderInfoListByOrdNo = null;
        Map<String, Object> param = new HashMap<>();
        param.put("mbrId", mbrId);
        param.put("startDate", startDate);
        param.put("endDate", endDate);

        try {
            orderInfoListByOrdNo = service.getOrderInfoListByOrdNo(param);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(orderInfoListByOrdNo, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(orderInfoListByOrdNo, HttpStatus.OK);
    }

    @GetMapping("/orders/{ordNo}")
    public String orderDeatil(Model m, @SessionAttribute int mbrId, @PathVariable int ordNo) {
        try {
            Map<String, Integer> param = new HashMap<>();
            param.put("mbrId", mbrId);
            param.put("ordNo", ordNo);

            Map<String, Object> result = service.getOrderDetailList(param);
            m.addAttribute("orderDetail", result);

            System.out.println("result = " + result);

        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }

        return ViewPath.FOS_MYPAGE + "orderDetail";
    }
}