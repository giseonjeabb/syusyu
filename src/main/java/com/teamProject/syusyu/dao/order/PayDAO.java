package com.teamProject.syusyu.dao.order;

import com.teamProject.syusyu.domain.order.PayDTO;

import java.util.List;
import java.util.Map;

public interface PayDAO {
    int insertPay(PayDTO payDTO) throws Exception;

    int insertCancelPay(Map<String, Object> param) throws Exception;

    PayDTO selectPay(int payNo) throws Exception;

    int updateCancelPay(Map<String, Object> param) throws Exception;

    int deleteAllPay() throws Exception;
    int countPay() throws Exception;

    List<Map<String, Object>> selectDailyTotalPayAmt() throws Exception;
}
