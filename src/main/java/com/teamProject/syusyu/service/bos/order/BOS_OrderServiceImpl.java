package com.teamProject.syusyu.service.bos.order;

import com.teamProject.syusyu.dao.order.impl.OrderInfoDAO;
import com.teamProject.syusyu.domain.order.OrderInfoDTO;
import com.teamProject.syusyu.domain.order.request.OrderSearchRequestDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BOS_OrderServiceImpl implements BOS_OrderService {
    private final OrderInfoDAO orderInfoDAO;

    public BOS_OrderServiceImpl(OrderInfoDAO orderInfoDAO) {
        this.orderInfoDAO = orderInfoDAO;
    }

    /**
     * 주어진 조회 저건에 따라 주문 리스트를 조회한다.
     *
     * @param orderSearchRequestDTO 조회 조건을 담고 있는 OrderSearchRequestDTO 객체.
     * @return 조회 조건을 만족하는 주문 리스트를 담은 OrderInfoDTO 객체의 리스트
     * @throws Exception DB 조회 도중 발생할 수 있는 예외
     * @author min
     * @since 2023/07/23
     */
    @Override
    public List<OrderInfoDTO> getOrderList(OrderSearchRequestDTO orderSearchRequestDTO) throws Exception {
        return orderInfoDAO.selectBosOrderList(orderSearchRequestDTO);
    }
}
