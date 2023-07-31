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
     * 각 주문의 주문상태를 업데이트하고 주문상태이력을 추가한다.
     * 각 주문에 대해서 순차적으로 주문상태를 업데이트하고 주문상태이력을 추가한다.
     *
     * @param ordDtlNoList 주문상태를 업데이트할 주문상세번호를 담은 리스트
     * @param mbrId        사용자 ID
     * @param ordStus      변경될 주문상태
     * @throws Exception 주문상태 업데이트 또는 주문상태이력 추가 도중 발생할 수 있는 예외
     * @author min
     * @since 2023/07/31
     */
    @Transactional(rollbackFor = Exception.class)
    public void processUpdateOrderStatus(List<Integer> ordDtlNoList, int mbrId, String ordStus) throws Exception {
        for (Integer ordDtlNo : ordDtlNoList) {
            boolean isSuccess = updateOrderStatusAndAddHistory(ordDtlNo, mbrId, ordStus);

            if (!isSuccess)
                throw new Exception("주문 번호 " + ordDtlNo + "의 주문 상태 변경 처리에 실패하였습니다. 주문 상태가 변경되거나 추가된 주문 이력의 수가 1이 아닙니다.");
        }
    }

    /**
     * 주문 상태를 업데이트하고 주문 상태 이력을 추가한다.
     *
     * @param ordDtlNo 주문상태를 업데이트할 주문의 주문상세번호
     * @param mbrId    사용자 ID
     * @param ordStus  변경될 주문상태
     * @return 주문 상태 변경 및 이력 추가 성공 여부
     * @throws Exception 주문 상태 업데이트 또는 주문 상태 이력 추가 도중 발생할 수 있는 예외
     * @author min
     * @since 2023/07/31
     */
    public boolean updateOrderStatusAndAddHistory(int ordDtlNo, int mbrId, String ordStus) throws Exception {
        int updatedRow = updateOrderStatus(ordDtlNo, mbrId, ordStus); // 1. 주문 상태 업데이트
        int insertedRow = addOrderStatusHistory(ordDtlNo, mbrId, ordStus); // 2. 주문 상태 이력 추가

        return updatedRow == 1 && insertedRow == 1;
    }


    /**
     * 주문 건의 주문상태를 주어진 주문상태로 변경한다.
     *
     * @param ordDtlNo 주문상태를 업데이트할 주문의 주문상세번호
     * @param mbrId    사용자 ID
     * @param ordStus  변경될 주문상태
     * @return 업데이트된 주문의 수
     * @throws Exception 주문 상태 업데이트 도중 발생할 수 있는 예외
     * @author min
     * @since 2023/07/31
     */
    public int updateOrderStatus(int ordDtlNo, int mbrId, String ordStus) throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("ordDtlNo", ordDtlNo);
        map.put("ordStus", ordStus);
        map.put("updrId", mbrId);

        return ordDtlDAO.updateOrdStus(map);
    }

    /**
     * 주어진 주문상세번호에 해당하는 주문상태이력을 추가한다.
     *
     * @param ordDtlNo 주문상태이력을 추가할 주문의 주문상세번호
     * @param mbrId    사용자 ID
     * @param ordStus  변경될 주문상태
     * @return 추가된 주문 상태 이력의 수
     * @throws Exception 주문 상태 이력 추가 도중 발생할 수 있는 예외
     * @author min
     * @since 2023/07/31
     */
    public int addOrderStatusHistory(int ordDtlNo, int mbrId, String ordStus) throws Exception {
        OrdStusHistDTO ordStusHistDTO = new OrdStusHistDTO(ordDtlNo, ordStus, null, mbrId);
        return ordStusHistDAO.insertOrderStatusHistory(ordStusHistDTO);
    }
}
