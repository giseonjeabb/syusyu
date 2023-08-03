package com.teamProject.syusyu.service.bos.order;

import com.teamProject.syusyu.domain.order.request.OrderSearchRequestDTO;

import java.util.List;
import java.util.Map;

public interface BOS_OrderService {
    Map<String, Object> getOrderList(OrderSearchRequestDTO orderSearchRequestDTO) throws Exception;
    void processUpdateOrderStatus(List<Integer> ordDtlNoList, int mbrId, String ordStus) throws Exception;
    void dispatchOrder(List<Integer> ordDtlNoList, List<String> dlvComList, List<String> trckNoList, int mbrId, String ordStus) throws Exception;

    Map<String, Object> getOrdDtlInfo(int ordDtlNo) throws Exception;
}
