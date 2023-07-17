package com.teamProject.syusyu.dao.order;

import com.teamProject.syusyu.domain.member.CouponDTO;
import com.teamProject.syusyu.domain.order.OrdDTO;

import java.util.List;

public interface OrdDAO {
    int insertOrder(OrdDTO ordDTO) throws Exception;

    OrdDTO selectOrder(int ordNo) throws Exception;

    int deleteAllOrder() throws Exception;

    // 존재하는 총 주문의 개수를 반환한다.
    int countOrd() throws Exception;

    List<CouponDTO> selectOrderCoupon(int mbrId, int totProductPrice) throws Exception;
}
