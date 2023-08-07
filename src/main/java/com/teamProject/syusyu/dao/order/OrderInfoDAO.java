package com.teamProject.syusyu.dao.order;

import com.teamProject.syusyu.domain.order.OrderInfoDTO;
import com.teamProject.syusyu.domain.order.PayInfoDTO;
import com.teamProject.syusyu.domain.order.request.OrderSearchRequestDTO;

import java.util.List;
import java.util.Map;

public interface OrderInfoDAO {
    List<OrderInfoDTO> selectOrderList(Map<String, Object> param) throws Exception;

    List<OrderInfoDTO> selectOrderDetailList(Map<String, Integer>  param) throws Exception;

    PayInfoDTO selectPayInfo(Map<String, Integer> param) throws Exception;
    List<OrderInfoDTO> selectBosOrderList(OrderSearchRequestDTO orderSearchRequestDTO) throws Exception;

    List<Map<String, Integer>> countByOrdStus() throws Exception;

    OrderInfoDTO selectOrdDtl(int ordDtlNo) throws Exception;

    List<Map<String, Object>> selectPayByProd() throws Exception;
}
