package com.teamProject.syusyu.service.order;

import com.teamProject.syusyu.domain.order.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

public interface OrderService {
    Map<String, Object> orderSheet(int[] cartProdNoArr, int mbrId) throws Exception;

    @Transactional(rollbackFor = Exception.class)
    String order(Order order) throws Exception;
}
