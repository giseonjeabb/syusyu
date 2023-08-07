package com.teamProject.syusyu.dao.order.impl;

import com.teamProject.syusyu.dao.order.OrderInfoDAO;
import com.teamProject.syusyu.domain.order.OrderInfoDTO;
import com.teamProject.syusyu.domain.order.PayInfoDTO;
import com.teamProject.syusyu.domain.order.request.OrderSearchRequestDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class OrderInfoDAOImpl implements OrderInfoDAO {
    private final SqlSession session;
    private static final String namespace = "com.teamProject.syusyu.orderInfoMapper.";

    public OrderInfoDAOImpl(SqlSession session) {
        this.session = session;
    }

    /**
     * 주어진 조회 조건에 따라 주문 정보 리스트를 조회한다.
     *
     * @param param 조회 조건을 담고 있는 Map 객체.
     * @return 조회 조건을 만족하는 주문 정보를 담은 OrderInfoDTO 객체의 리스트
     * @throws Exception DB 조회 도중 발생할 수 있는 예외
     * @author min
     * @since 2023/07/18
     */
    @Override
    public List<OrderInfoDTO> selectOrderList(Map<String, Object> param) throws Exception {
        return session.selectList(namespace + "selectOrderList", param);
    }

    /**
     * 주어진 주문 번호에 해당하는 주문 상세 정보 리스트를 조회한다.
     *
     * @param param 조회 조건을 담고 있는 Map 객체.
     * @return 주문 번호에 해당하는 주문 상세 정보를 담은 OrderInfoDTO 객체의 리스트
     * @throws Exception DB 조회 도중 발생할 수 있는 예외
     * @author min
     * @since 2023/07/18
     */
    @Override
    public List<OrderInfoDTO> selectOrderDetailList(Map<String, Integer> param) throws Exception {
        return session.selectList(namespace + "selectOrderDetailList", param);
    }


    /**
     * 주어진 주문 번호에 해당하는 결제 정보를 조회한다.
     *
     * @param param 조회 조건을 담고 있는 Map 객체.
     * @return 주문 번호에 해당하는 결제 정보를 담은 PayInfoDTO 객체
     * @throws Exception DB 조회 도중 발생할 수 있는 예외
     * @author min
     * @since 2023/07/18
     */
    @Override
    public PayInfoDTO selectPayInfo(Map<String, Integer> param) throws Exception {
        return session.selectOne(namespace + "selectPayInfo", param);
    }

    /**
     * 주어진 조회 조건에 따라 관리자 화면의 주문 정보 리스트를 조회한다.
     *
     * @param orderSearchRequestDTO 조회 조건을 담고 있는 OrderSearchRequestDTO 객체.
     * @return 조회 조건을 만족하는 주문 정보를 담은 OrderInfoDTO 객체의 리스트
     * @throws Exception DB 조회 도중 발생할 수 있는 예외
     * @author min
     * @since 2023/07/23
     */
    @Override
    public List<OrderInfoDTO> selectBosOrderList(OrderSearchRequestDTO orderSearchRequestDTO) throws Exception {
        return session.selectList(namespace + "selectBosOrderList", orderSearchRequestDTO);
    }

    /**
     * 주문 상태별로 주문 건수를 카운트한다.
     *
     * @return 주문 상태별 주문 건수를 담은 Map의 List
     * @throws Exception DB 조회 도중 발생할 수 있는 예외
     * @author min
     * @since 2023/07/27
     */
    @Override
    public List<Map<String, Integer>> countByOrdStus() throws Exception {
        return session.selectList(namespace + "countByOrdStus");
    }

    /**
     * 주어진 주문 상세 번호에 해당하는 주문 상세 정보를 조회한다.
     *
     * @param ordDtlNo 주문 상세 번호.
     * @return 주문 상세 번호에 해당하는 주문 상세 정보를 담은 OrderInfoDTO 객체
     * @throws Exception DB 조회 도중 발생할 수 있는 예외
     * @author min
     * @since 2023/08/03
     */
    @Override
    public OrderInfoDTO selectOrdDtl(int ordDtlNo) throws Exception {
        return session.selectOne(namespace + "selectOrdDtl", ordDtlNo);
    }

    /**
     * 상품별 판매액을 조회한다.
     *
     * @return 각 상품의 ID와 총 판매액을 담은 Map의 리스트
     * @throws Exception DB 조회 도중 발생할 수 있는 예외
     * @author min
     * @since 2023/08/06
     */
    @Override
    public List<Map<String, Object>> selectPayByProd() throws Exception {
        return session.selectList(namespace + "selectPayByProd");
    }

}