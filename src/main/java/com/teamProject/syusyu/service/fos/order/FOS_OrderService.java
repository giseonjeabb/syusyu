package com.teamProject.syusyu.service.fos.order;

import com.teamProject.syusyu.domain.member.CouponDTO;
import com.teamProject.syusyu.domain.order.OrdClaimDTO;
import com.teamProject.syusyu.domain.order.Order;
import com.teamProject.syusyu.domain.order.OrderInfoDTO;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.List;
import java.util.Map;

public interface FOS_OrderService {
    Map<String, Object> orderSheet(int[] cartProdNoArr, int mbrId) throws Exception;

    @Transactional(rollbackFor = Exception.class)
    void order(Order order) throws Exception;

    List<CouponDTO> getOrderCouponList(@SessionAttribute int mbrId, @RequestBody int totProductPrice) throws Exception;

    Map<Integer, List<OrderInfoDTO>> getOrderInfoListByOrdNo(Map<String, Object> param) throws Exception;

    Map<String, Object> getOrderDetailList(Map<String, Integer> param) throws Exception;

    List<OrderInfoDTO> getCancelOrderList(Map<String, Integer> param) throws Exception;

    @Transactional(rollbackFor = Exception.class)
    void cancelOrder(OrdClaimDTO ordClaimDTO, List<Integer> ordDtlNoList, int mbrId) throws Exception;
}
