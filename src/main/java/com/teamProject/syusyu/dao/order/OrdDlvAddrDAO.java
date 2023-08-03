package com.teamProject.syusyu.dao.order;

import com.teamProject.syusyu.domain.order.OrdDlvAddrDTO;

public interface OrdDlvAddrDAO {
    int insertOrdDlvAddr(OrdDlvAddrDTO ordDlvAddrDTO) throws Exception;

    OrdDlvAddrDTO selectOrdDlvAddr(int ordDtlNo) throws Exception;

    int deleteAllOrdDlvAddr() throws Exception;

    int countOrdDlvAddr() throws Exception;
}
