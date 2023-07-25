package com.teamProject.syusyu.dao.order;

import com.teamProject.syusyu.domain.order.OrdDtlDTO;

import java.util.Map;

public interface OrdDtlDAO {
    int insertOrderDetail(OrdDtlDTO ordDtlDTO) throws Exception;

    OrdDtlDTO selectOrderDetail(int ordDtlNo) throws Exception;

    int deleteAllOrderDetail() throws Exception;

    int countOrderDetail() throws Exception;

    int updateOrdStus(Map<String, Object> param) throws Exception;
}
