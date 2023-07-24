package com.teamProject.syusyu.service.bos.order;

import com.teamProject.syusyu.domain.order.OrderInfoDTO;
import com.teamProject.syusyu.domain.order.request.OrderSearchRequestDTO;

import java.util.List;
import java.util.Map;

public interface BOS_OrderService {
    //    @Override
    List<OrderInfoDTO> getOrderList(OrderSearchRequestDTO orderSearchRequestDTO) throws Exception;
}
