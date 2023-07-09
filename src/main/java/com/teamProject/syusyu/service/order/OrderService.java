package com.teamProject.syusyu.service.order;

import java.util.Map;

public interface OrderService {
    Map<String, Object> orderSheet(int[] cartProdNoArr, int mbrId) throws Exception;
}
