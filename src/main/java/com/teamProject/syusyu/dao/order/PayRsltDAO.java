package com.teamProject.syusyu.dao.order;

import com.teamProject.syusyu.domain.order.PayRsltDTO;

public interface PayRsltDAO {
    int insertPayResult(PayRsltDTO PayResultDTO) throws Exception;
    PayRsltDTO selectPayResult(String payNo) throws Exception;
    int updatePayResult(PayRsltDTO PayResultDTO) throws Exception;
    int deletePayResult(String payNo) throws Exception;
    int deleteAllPayResult() throws Exception;
    int countPayResult() throws Exception;
}
