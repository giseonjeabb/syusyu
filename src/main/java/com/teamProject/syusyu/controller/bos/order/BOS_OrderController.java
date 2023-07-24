package com.teamProject.syusyu.controller.bos.order;

import com.teamProject.syusyu.common.ViewPath;
import com.teamProject.syusyu.domain.order.OrderInfoDTO;
import com.teamProject.syusyu.domain.order.request.OrderSearchRequestDTO;
import com.teamProject.syusyu.service.bos.order.BOS_OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
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
    @GetMapping("/orders")
    public ResponseEntity<List<OrderInfoDTO>> getOrderList(OrderSearchRequestDTO orderSearchRequestDTO) {
        List<OrderInfoDTO> result = null;
        try {
            result = service.getOrderList(orderSearchRequestDTO);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
