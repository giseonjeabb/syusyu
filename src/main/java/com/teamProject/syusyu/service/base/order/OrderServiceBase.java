package com.teamProject.syusyu.service.base.order;

import com.teamProject.syusyu.dao.order.OrdDtlDAO;
import com.teamProject.syusyu.dao.order.OrdStusHistDAO;
import com.teamProject.syusyu.domain.order.OrdStusHistDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class OrderServiceBase {
    @Autowired
    private OrdDtlDAO ordDtlDAO;

    @Autowired
    private OrdStusHistDAO ordStusHistDAO;

    /**
     * 주문 건의 주문상태를 업데이트하고 주문상태이력을 추가한다.
     *
     * @param ordDtlNoList 주문상태를 업데이트할 주문상세번호를 담은 리스트
     * @param mbrId        사용자 ID
     * @param ordStus      변경될 주문상태
     * @throws Exception 주문상태 업데이트 또는 주문상태이력 추가 도중 발생할 수 있는 예외
     * @author min
     * @since 2023/07/25
     */
    @Transactional(rollbackFor = Exception.class)
    public void processUpdateOrderStatus(List<Integer> ordDtlNoList, int mbrId, String ordStus) throws Exception {
        int updatedRows = updateOrderStatus(ordDtlNoList, mbrId, ordStus); // 1. 주문 상태 업데이트
        int insertedRows = addOrderStatusHistory(ordDtlNoList, mbrId, ordStus); // 2. 주문 상태 이력 추가

        if (updatedRows != ordDtlNoList.size() || insertedRows != ordDtlNoList.size())
            throw new Exception("주문 상태 변경 처리에 실패하였습니다. 업데이트된 주문의 수 또는 추가된 주문 이력의 수가 전체 주문의 수와 일치하지 않습니다.");

    }

    /**
     * 주문 건의 주문상태를 주어진 주문상태로 변경한다.
     *
     * @param ordDtlNoList 주문상태를 업데이트할 주문의 주문상세번호를 담은 리스트
     * @param mbrId        사용자 ID
     * @param ordStus      변경될 주문상태
     * @return 업데이트된 주문의 수
     * @throws Exception 주문 상태 업데이트 도중 발생할 수 있는 예외
     * @author min
     * @since 2023/07/25
     */
    public int updateOrderStatus(List<Integer> ordDtlNoList, int mbrId, String ordStus) throws Exception {
        Map<String, Object> map = new HashMap<>();
        int updatedRows = 0;

        for (Integer ordDtlNo : ordDtlNoList) {
            map.clear();
            map.put("ordDtlNo", ordDtlNo);
            map.put("ordStus", ordStus); // 20 = 주문확인
            map.put("updrId", mbrId);

            updatedRows += ordDtlDAO.updateOrdStus(map);
        }

        return updatedRows;
    }

    /**
     * 주어진 주문상세번호 리스트에 해당하는 주문상태이력을 추가한다.
     *
     * @param ordDtlNoList 주문상태이력을 추가할 주문의 주문상세번호를 담은 리스트
     * @param mbrId        사용자 ID
     * @param ordStus      변경될 주문상태
     * @return 추가된 주문 상태 이력의 수
     * @throws Exception 주문 상태 이력 추가 도중 발생할 수 있는 예외
     * @author min
     * @since 2023/07/25
     */
    public int addOrderStatusHistory(List<Integer> ordDtlNoList, int mbrId, String ordStus) throws Exception {
        OrdStusHistDTO ordStusHistDTO;
        int insertedRows = 0;

        for (Integer ordDtlNo : ordDtlNoList) {
            ordStusHistDTO = new OrdStusHistDTO(ordDtlNo, ordStus, null, mbrId);
            insertedRows += ordStusHistDAO.insertOrderStatusHistory(ordStusHistDTO);
        }

        return insertedRows;
    }
}
