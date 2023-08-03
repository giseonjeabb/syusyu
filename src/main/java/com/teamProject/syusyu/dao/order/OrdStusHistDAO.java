package com.teamProject.syusyu.dao.order;

import com.teamProject.syusyu.domain.order.OrdStusHistDTO;

import java.util.List;

public interface OrdStusHistDAO {
    int insertOrderStatusHistory(OrdStusHistDTO ordStusHistDTO) throws Exception;
    List<OrdStusHistDTO> selectOrderStatusHistory(int ordDtlNo) throws Exception;
    int deleteAllOrderStatusHistory() throws Exception;
    int countOrderStatusHistory() throws Exception;
}
