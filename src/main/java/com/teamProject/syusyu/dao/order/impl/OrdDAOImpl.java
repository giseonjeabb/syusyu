package com.teamProject.syusyu.dao.order.impl;

import com.teamProject.syusyu.dao.order.OrdDAO;
import com.teamProject.syusyu.domain.member.CouponDTO;
import com.teamProject.syusyu.domain.order.OrdDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class OrdDAOImpl implements OrdDAO {
    private final SqlSession session;
    private static final String namespace = "com.teamProject.syusyu.ordMapper.";

    public OrdDAOImpl(SqlSession session) {
        this.session = session;
    }

    /**
     * 주문 정보를 DB에 삽입한다.
     *
     * @param ordDTO 삽입할 주문 정보를 담은 DTO
     * @return DB에 성공적으로 삽입된 row의 수
     * @throws Exception DB 삽입 도중 발생할 수 있는 예외
     * @author min
     * @since  2023/07/10
     */
    @Override
    public int insertOrder(OrdDTO ordDTO) throws Exception {
        return session.insert(namespace + "insertOrd", ordDTO);
    }

    /**
     * 주문번호에 해당하는 주문 정보를 DB에서 조회한다.
     *
     * @param ordNo 조회할 주문의 주문번호
     * @return 조회된 주문 정보를 담은 DTO
     * @throws Exception DB 조회 도중 발생할 수 있는 예외
     * @author min
     * @since  2023/07/10
     */
    @Override
    public OrdDTO selectOrder(int ordNo) throws Exception {
        return session.selectOne(namespace + "selectOrd", ordNo);
    }

    /**
     * 모든 주문 정보를 DB에서 삭제한다.
     *
     * @return DB에서 성공적으로 삭제된 row의 수
     * @throws Exception DB 삭제 도중 발생할 수 있는 예외
     * @author min
     * @since  2023/07/10
     */
    @Override
    public int deleteAllOrder() throws Exception {
        return session.delete(namespace + "deleteAllOrd");
    }

    /**
     * DB에 저장된 주문 정보의 총 개수를 조회한다.
     *
     * @return DB에 저장된 주문 정보의 총 개수
     * @throws Exception DB 조회 도중 발생할 수 있는 예외
     * @author min
     * @since  2023/07/10
     */
    @Override
    public int countOrd() throws Exception {
        return session.selectOne(namespace + "countOrd");
    }

    /**
     * 사용자가 주문/결제 시 사용할 수 있는 쿠폰 리스트를 조회한다.
     * 총 상품금액에 따라 사용 가능한 쿠폰들이 달라진다.(최소 주문금액 만족해야 함)
     *
     * @param mbrId 쿠폰을 조회할 사용자의 아이디
     * @param totProdAmt 총 상품금액
     * @return 사용 가능한 쿠폰 리스트
     * @throws Exception DB 조회 도중 발생할 수 있는 예외
     * @author min
     * @since  2023/07/16
     */
    @Override
    public List<CouponDTO> selectOrderCoupon(int mbrId, int totProdAmt) throws Exception {
        Map<String, Integer> param = new HashMap<>();
        param.put("mbrId", mbrId);
        param.put("totProdAmt", totProdAmt);

        return session.selectList(namespace + "selectOrderCoupon", param);
    }
}
