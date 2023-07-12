package com.teamProject.syusyu.service.order;

import com.teamProject.syusyu.domain.order.Order;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

public interface OrderService {
    Map<String, Object> orderSheet(int[] cartProdNoArr, int mbrId) throws Exception;

    @Transactional(rollbackFor = Exception.class)
    void order(Order order) throws Exception;
}
