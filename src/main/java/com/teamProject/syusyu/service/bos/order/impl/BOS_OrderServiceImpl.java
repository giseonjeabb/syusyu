package com.teamProject.syusyu.service.bos.order.impl;

import com.teamProject.syusyu.dao.order.DeliveryDAO;
import com.teamProject.syusyu.dao.order.OrdDtlDAO;
import com.teamProject.syusyu.dao.order.OrdStusHistDAO;
import com.teamProject.syusyu.dao.order.OrderInfoDAO;
import com.teamProject.syusyu.domain.order.DeliveryDTO;
import com.teamProject.syusyu.domain.order.OrdStusHistDTO;
import com.teamProject.syusyu.domain.order.OrderInfoDTO;
import com.teamProject.syusyu.domain.order.request.OrderSearchRequestDTO;
import com.teamProject.syusyu.service.bos.order.BOS_OrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BOS_OrderServiceImpl implements BOS_OrderService {
    private final OrderInfoDAO orderInfoDAO;
    private final OrdDtlDAO ordDtlDAO;
    private final OrdStusHistDAO ordStusHistDAO;
    private final DeliveryDAO deliveryDAO;

    public BOS_OrderServiceImpl(OrderInfoDAO orderInfoDAO, OrdDtlDAO ordDtlDAO, OrdStusHistDAO ordStusHistDAO, DeliveryDAO deliveryDAO) {
        this.orderInfoDAO = orderInfoDAO;
        this.ordDtlDAO = ordDtlDAO;
        this.ordStusHistDAO = ordStusHistDAO;
        this.deliveryDAO = deliveryDAO;
    }

    /**
     * 주어진 조회 조건을 만족하는 주문 리스트를 조회한다.
     *
     * @param orderSearchRequestDTO 조회 조건을 담고 있는 OrderSearchRequestDTO 객체
     * @return 조회 조건에 따라 얻은 주문 리스트와 주문 상태별 건수 카운트 결과를 담은 Map 객체
     * @throws Exception DB 조회 도중 발생할 수 있는 예외
     * @author min
     * @since 2023/07/23
     */
    @Override
    public Map<String, Object> getOrderList(OrderSearchRequestDTO orderSearchRequestDTO) throws Exception {
        // 1. 주문 상태별로 주문 건수를 카운트한다.
        List<Map<String, Integer>> countByOrdStusList = orderInfoDAO.countByOrdStus();
        // 2. 주어진 조회 조건에 만족하는 주문 리스트의 개수를 가져온다.
        // 3. 주어진 조회 조건에 만족하는 주문 리스트를 조회한다.
        List<OrderInfoDTO> orderInfoList = orderInfoDAO.selectBosOrderList(orderSearchRequestDTO);

        Map<String, Object> result = new HashMap<>();
        result.put("countByOrdStusList", countByOrdStusList);
        result.put("orderInfoList", orderInfoList);

        return result;
    }

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
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void processUpdateOrderStatus(List<Integer> ordDtlNoList, int mbrId, String ordStus) throws Exception {
        int updatedRows = updateOrderStatus(ordDtlNoList, mbrId, ordStus); // 1. 주문 상태 업데이트
        int insertedRows = addOrderStatusHistory(ordDtlNoList, mbrId, ordStus); // 2. 주문 상태 이력 추가

        if (updatedRows != ordDtlNoList.size() || insertedRows != ordDtlNoList.size())
            throw new Exception("주문확인 처리에 실패하였습니다. 업데이트된 주문의 수 또는 추가된 주문 이력의 수가 전체 주문의 수와 일치하지 않습니다.");

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
    @Override
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
    @Override
    public int addOrderStatusHistory(List<Integer> ordDtlNoList, int mbrId, String ordStus) throws Exception {
        OrdStusHistDTO ordStusHistDTO = null;
        int insertedRows = 0;

        for (Integer ordDtlNo : ordDtlNoList) {
            ordStusHistDTO = new OrdStusHistDTO(ordDtlNo, ordStus, null, mbrId);
            insertedRows += ordStusHistDAO.insertOrderStatusHistory(ordStusHistDTO);
        }

        return insertedRows;
    }

    /**
     * 주어진 주문상세번호, 택배사코드, 송장번호 리스트로 주문을 발송처리한다.
     * 주문 배송 정보를 추가하고, 주문의 상태를 발송완료로 업데이트한다.
     *
     * @param ordDtlNoList 발송처리할 주문의 주문상세번호를 담은 리스트
     * @param dlvComList 택배사코드를 담은 리스트
     * @param trckNoList 송장번호를 담은 리스트
     * @param mbrId 사용자 ID
     * @param ordStus 변경될 주문상태
     * @throws Exception 주문 발송 처리 도중 발생할 수 있는 예외
     * @author min
     * @since 2023/07/28
     */
    @Override
    public void dispatchOrder(List<Integer> ordDtlNoList, List<String> dlvComList, List<String> trckNoList, int mbrId, String ordStus) throws Exception {
        // 1. 주문배송 테이블에 정보를 넣어준다.
        addDelivery(ordDtlNoList, dlvComList, trckNoList, mbrId);

        // 2. 주문 건의 주문상태를 발송완료로 업데이트하고 주문상태이력을 추가한다.
        processUpdateOrderStatus(ordDtlNoList, mbrId, ordStus);
    }

    /**
     * 주어진 주문상세번호, 택배사코드, 송장번호 리스트로 주문 배송 정보를 추가한다.
     * 리스트의 길이가 일치하지 않으면 IllegalArgumentException이 발생한다.
     *
     * @param ordDtlNoList 주문배송 정보를 추가할 주문의 주문상세번호를 담은 리스트
     * @param dlvCom 택배사코드를 담은 리스트
     * @param trckNo 송장번호를 담은 리스트
     * @param mbrId 사용자 ID
     * @throws Exception 배송 정보 추가 도중 발생할 수 있는 예외
     * @author min
     * @since 2023/07/28
     */
    private void addDelivery(List<Integer> ordDtlNoList, List<String> dlvCom, List<String> trckNo, int mbrId) throws Exception {
        if (ordDtlNoList.size() != dlvCom.size() || ordDtlNoList.size() != trckNo.size()) {
            throw new IllegalArgumentException("올바르지 않은 데이터");
        }

        // 주문 건 list를 매개변수로 받아서 주문배송 정보를 생성해준다.
        for (int i = 0; i < ordDtlNoList.size(); i++) {
            deliveryDAO.insertDelivery(new DeliveryDTO(ordDtlNoList.get(i), dlvCom.get(i), trckNo.get(i), mbrId));
        }
    }
}
