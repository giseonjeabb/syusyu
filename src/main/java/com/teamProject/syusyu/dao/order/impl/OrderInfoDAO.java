package com.teamProject.syusyu.dao.order.impl;

import com.teamProject.syusyu.domain.order.OrderInfoDTO;

import java.util.List;
import java.util.Map;

public interface OrderInfoDAO {
    List<OrderInfoDTO> selectOrderInfoList(Map<String, Object> param) throws Exception;
}
