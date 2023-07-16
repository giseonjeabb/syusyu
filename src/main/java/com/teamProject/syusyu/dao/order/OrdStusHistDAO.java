package com.teamProject.syusyu.dao.order;

import com.teamProject.syusyu.domain.order.OrdStusHistDTO;

public interface OrdStusHistDAO {
    int insertOrderStatusHistory(OrdStusHistDTO ordStusHistDTO) throws Exception;
    OrdStusHistDTO selectOrderStatusHistory(int ordStusHistNo) throws Exception;
    int deleteAllOrderStatusHistory() throws Exception;
    int countOrderStatusHistory() throws Exception;
}
