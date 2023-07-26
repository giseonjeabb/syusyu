package com.teamProject.syusyu.service.bos.order;

import com.teamProject.syusyu.domain.order.OrderInfoDTO;
import com.teamProject.syusyu.domain.order.request.OrderSearchRequestDTO;

import java.util.List;

public interface BOS_OrderService {
    List<OrderInfoDTO> getOrderList(OrderSearchRequestDTO orderSearchRequestDTO) throws Exception;

    void processUpdateOrderStatus(List<Integer> ordDtlNoList, int mbrId, String ordStus) throws Exception;

    int updateOrderStatus(List<Integer> ordDtlNoList, int mbrId, String ordStus) throws Exception;

    int addOrderStatusHistory(List<Integer> ordDtlNoList, int mbrId, String ordStus) throws Exception;
}
