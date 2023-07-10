package com.teamProject.syusyu.dao.order;

import com.teamProject.syusyu.domain.order.OrdDTO;

public interface OrdDAO {
    int insertOrder(OrdDTO ordDTO) throws Exception;

    OrdDTO selectOrder(int ordNo) throws Exception;

    int deleteAllOrder() throws Exception;

    // 존재하는 총 주문의 개수를 반환한다.
    int countOrd() throws Exception;
}
