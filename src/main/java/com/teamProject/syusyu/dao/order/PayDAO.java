package com.teamProject.syusyu.dao.order;

import com.teamProject.syusyu.domain.order.PayDTO;

public interface PayDAO {
    int insertPay(PayDTO payDTO) throws Exception;
    PayDTO selectPay(int payNo) throws Exception;
    int deleteAllPay() throws Exception;
    int countPay() throws Exception;
}
