package com.teamProject.syusyu.dao.order;

import com.teamProject.syusyu.domain.order.OrdDtlDTO;

public interface OrdDtlDAO {
    int insertOrderDetail(OrdDtlDTO ordDtlDTO) throws Exception;

    OrdDtlDTO selectOrderDetail(int ordDtlNo) throws Exception;

    int deleteAllOrderDetail() throws Exception;

    int countOrderDetail() throws Exception;
}
