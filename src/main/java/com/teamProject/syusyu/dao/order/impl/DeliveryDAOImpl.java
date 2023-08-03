package com.teamProject.syusyu.dao.order.impl;

import com.teamProject.syusyu.dao.order.DeliveryDAO;
import com.teamProject.syusyu.domain.order.DeliveryDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DeliveryDAOImpl implements DeliveryDAO {
    private final SqlSession session;
    private static final String namespace = "com.teamProject.syusyu.deliveryMapper.";

    public DeliveryDAOImpl(SqlSession session) {
        this.session = session;
    }

    /**
     * 배송 정보를 DB에 삽입한다.
     *
     * @param deliveryDTO 삽입할 배송 정보를 담은 DTO
     * @return DB에 성공적으로 삽입된 row의 수
     * @throws Exception DB 삽입 도중 발생할 수 있는 예외
     * @author min
     * @since  2023/07/28
     */
    @Override
    public int insertDelivery(DeliveryDTO deliveryDTO) throws Exception {
        return session.insert(namespace + "insertDelivery", deliveryDTO);
    }

    /**
     * 주문상세번호에 해당하는 배송 정보를 DB에서 조회한다.
     *
     * @param ordDtlNo 주문상세번호
     * @return 조회된 배송 정보를 담은 DTO
     * @throws Exception DB 조회 도중 발생할 수 있는 예외
     * @author min
     * @since  2023/07/28
     */
    @Override
    public DeliveryDTO selectDelivery(int ordDtlNo) throws Exception {
        return session.selectOne(namespace + "selectDelivery", ordDtlNo);
    }

    /**
     * 배송 정보를 DB에 업데이트한다.
     *
     * @param deliveryDTO 업데이트할 배송 정보를 담은 DTO
     * @return DB에 성공적으로 업데이트된 row의 수
     * @throws Exception DB 업데이트 도중 발생할 수 있는 예외
     * @author min
     * @since  2023/07/28
     */
    @Override
    public int updateDelivery(DeliveryDTO deliveryDTO) throws Exception {
        return session.update(namespace + "updateDelivery", deliveryDTO);
    }

    /**
     * 배송번호에 해당하는 배송 정보를 DB에서 삭제한다.
     *
     * @param dlvNo 삭제할 배송의 배송번호
     * @return DB에서 성공적으로 삭제된 row의 수
     * @throws Exception DB 삭제 도중 발생할 수 있는 예외
     * @author min
     * @since  2023/07/28
     */
    @Override
    public int deleteDelivery(int dlvNo) throws Exception {
        return session.delete(namespace + "deleteDelivery", dlvNo);
    }

    /**
     * 모든 배송 정보를 DB에서 삭제한다.
     *
     * @return DB에서 성공적으로 삭제된 row의 수
     * @throws Exception DB 삭제 도중 발생할 수 있는 예외
     * @author min
     * @since  2023/07/28
     */
    @Override
    public int deleteAllDelivery() throws Exception {
        return session.delete(namespace + "deleteAllDelivery");
    }

    /**
     * DB에 저장된 배송 정보의 총 개수를 조회한다.
     *
     * @return DB에 저장된 배송 정보의 총 개수
     * @throws Exception DB 조회 도중 발생할 수 있는 예외
     * @author min
     * @since  2023/07/28
     */
    @Override
    public int countDelivery() throws Exception {
        return session.selectOne(namespace + "countDelivery");
    }

    /**
     * DB에 저장된 모든 배송 정보를 조회한다.
     *
     * @return 조회된 배송 정보를 담은 DTO 리스트
     * @throws Exception DB 조회 도중 발생할 수 있는 예외
     * @author min
     * @since  2023/07/28
     */
    @Override
    public List<DeliveryDTO> selectAllDelivery() throws Exception {
        return session.selectList(namespace + "selectAllDelivery");
    }
}
