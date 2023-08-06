package com.teamProject.syusyu.controller.bos.order;

import com.teamProject.syusyu.common.ViewPath;
import com.teamProject.syusyu.domain.order.request.OrderSearchRequestDTO;
import com.teamProject.syusyu.service.bos.order.BOS_OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(ViewPath.BOS)
public class BOS_OrderController {
    private final BOS_OrderService service;

    public BOS_OrderController(BOS_OrderService service) {
        this.service = service;
    }

    /**
     * 주어진 조회 조건에 따라 주문 리스트를 조회하고 결과를 반환한다.
     *
     * @param orderSearchRequestDTO 조회 조건을 담고 있는 OrderSearchRequestDTO 객체.
     * @return 조회 결과에 대한 ResponseEntity. 성공시 HTTP 상태 코드 200과 주문 정보를 담은 리스트를 반환하고, 실패시 HTTP 상태 코드 400과 null을 반환한다.
     * @author min
     * @since 2023/07/23
     */
    @ResponseBody
    @GetMapping("orders")
    public ResponseEntity<Map<String, Object>> getOrderList(OrderSearchRequestDTO orderSearchRequestDTO) {
        Map<String, Object> result = null;
        try {
            result = service.getOrderList(orderSearchRequestDTO);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * 주문들을 주문확인처리한다.
     * 결제완료(10)된 주문 건의 주문상태를 주문확인(20)으로 변경한다.
     *
     * @param ordDtlNoList 주문확인 처리할 주문의 주문상세번호를 담은 리스트
     * @param mbrId 세션에서 가져온 사용자 ID
     * @return ResponseEntity, HTTP 응답 상태와 메시지를 포함
     * @author min
     * @since 2023/07/25
     */
    @ResponseBody
    @PostMapping("orders/status/confirm")
    public ResponseEntity<String> confirmOrder(@RequestBody List<Integer> ordDtlNoList, @SessionAttribute int mbrId) {
        try {
            service.processUpdateOrderStatus(ordDtlNoList, mbrId, "20");

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>("CONFIRM_OK", HttpStatus.OK);
    }

    /**
     * 주문들을 발송처리한다.
     * 주문확인(20)된 주문 건의 주문상태를 배송중(30)으로 변경한다.
     *
     * @param payload JSON 형식의 페이로드, 키는 "ordDtlNoList", "dlvComList", "trckNoList" 각각에 대응되는 리스트
     * @param mbrId 세션에서 가져온 사용자 ID
     * @return ResponseEntity, HTTP 응답 상태와 메시지를 포함
     * @author min
     * @since 2023/07/26
     */
    @ResponseBody
    @PostMapping("orders/status/dispatch")
    public ResponseEntity<String> dispatchOrder(@RequestBody Map<String, Object> payload, @SessionAttribute int mbrId) {
        try {
            List<Integer> ordDtlNoList = (List<Integer>) payload.get("ordDtlNoList");
            List<String> dlvComList = (List<String>) payload.get("dlvComList");
            List<String> trckNoList = (List<String>) payload.get("trckNoList");
            service.dispatchOrder(ordDtlNoList, dlvComList, trckNoList, mbrId, "30");

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>("DISPATCH_OK", HttpStatus.OK);
    }

    /**
     * 주문들을 배송완료 처리한다.
     * 주문상태를 배송완료(60)으로 변경한다.
     *
     * @param ordDtlNoList 배송완료 처리할 주문의 주문상세번호를 담은 리스트
     * @param mbrId 세션에서 가져온 사용자 ID
     * @return ResponseEntity, HTTP 응답 상태와 메시지를 포함
     * @author min
     * @since 2023/07/29
     */
    @ResponseBody
    @PostMapping("orders/status/delivery-complete")
    public ResponseEntity<String> deliveryCompleteOrder(@RequestBody List<Integer> ordDtlNoList, @SessionAttribute int mbrId) {
        try {
            service.processUpdateOrderStatus(ordDtlNoList, mbrId, "60");

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>("DELIVERY_COMPLETE_OK", HttpStatus.OK);
    }

    /**
     * 주문 상세 정보를 조회해 화면에 보내준다.
     *
     * @param ordDtlNo 조회할 주문상세의 주문상세번호
     * @param m Model 객체
     * @return 조회에 성공하면 주문 상세 정보를 담은 뷰의 이름을, 실패하면 "error"를 반환
     * @author min
     * @since 2023/08/03
     */
    @GetMapping("/orders/{ordDtlNo}")
    public String orderDetail(@PathVariable int ordDtlNo, Model m) {

        try {
            Map<String, Object> result = service.getOrdDtlInfo(ordDtlNo);
            m.addAttribute("ordDtl", result.get("ordDtl"));
            m.addAttribute("delivery", result.get("delivery"));
            m.addAttribute("ordDlvAddr", result.get("ordDlvAddr"));
            m.addAttribute("ordStusHistList", result.get("ordStusHistList"));

        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }

        return ViewPath.BOS_WINDOW_POPUP + "orderDetailPopup";
    }
}
