package com.teamProject.syusyu.dao.order;

import com.teamProject.syusyu.domain.order.OrdDlvAddrDTO;

public interface OrdDlvAddrDAO {
    int insertOrdDlvAddr(OrdDlvAddrDTO ordDlvAddrDTO) throws Exception;

    OrdDlvAddrDTO selectOrdDlvAddrByOrdDtlNo(int ordDtlNo) throws Exception;

    OrdDlvAddrDTO selectOrdDlvAddrByOrdNo(int ordNo) throws Exception;

    int deleteAllOrdDlvAddr() throws Exception;

    int countOrdDlvAddr() throws Exception;

}
