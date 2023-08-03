package com.teamProject.syusyu.dao.order;

import com.teamProject.syusyu.domain.order.DeliveryDTO;

import java.util.List;

public interface DeliveryDAO {
    int insertDelivery(DeliveryDTO deliveryDTO) throws Exception;

    DeliveryDTO selectDelivery(int ordNo) throws Exception;

    int updateDelivery(DeliveryDTO deliveryDTO) throws Exception;

    int deleteDelivery(int dlvNo) throws Exception;

    int deleteAllDelivery() throws Exception;

    int countDelivery() throws Exception;

    List<DeliveryDTO> selectAllDelivery() throws Exception;
}
