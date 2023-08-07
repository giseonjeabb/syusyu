package com.teamProject.syusyu.dao.order.impl;

import com.teamProject.syusyu.dao.order.PayDAO;
import com.teamProject.syusyu.domain.order.PayDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class PayDAOImpl implements PayDAO {
    private final SqlSession session;
    private static final String namespace = "com.teamProject.syusyu.payMapper.";

    public PayDAOImpl(SqlSession session) {
        this.session = session;
    }

    /**
     * 결제 정보를 삽입한다.
     *
     * @param payDTO 삽입할 결제 정보를 담은 DTO
     * @return DB에 성공적으로 삽입된 row의 수
     * @throws Exception DB 삽입 도중 발생할 수 있는 예외
     * @author min
     * @since 2023/07/10
     */
    @Override
    public int insertPay(PayDTO payDTO) throws Exception {
        return session.insert(namespace + "insertPay", payDTO);
    }

    /**
     * 주문취소 시 새로운 결제 정보를 삽입한다.
     *
     * @param param 삽입할 결제 정보를 담은 Map
     * @return DB에 성공적으로 삽입된 row의 수
     * @throws Exception DB 삽입 도중 발생할 수 있는 예외
     * @author min
     * @since 2023/07/30
     */
    @Override
    public int insertCancelPay(Map<String, Object> param) throws Exception {
        return session.insert(namespace + "insertCancelPay", param);
    }

    /**
     * 결제번호에 해당하는 결제 정보를 조회한다.
     *
     * @param payNo 조회할 결제 정보의 결제번호
     * @return 조회된 결제 정보를 담은 DTO
     * @throws Exception DB 조회 도중 발생할 수 있는 예외
     * @author min
     * @since 2023/07/10
     */
    @Override
    public PayDTO selectPay(int payNo) throws Exception {
        return session.selectOne(namespace + "selectPay", payNo);
    }

    /**
     * 주문 취소 시 이전 PAY 데이터 일부주문취소(20)/주문취소(30)로 변경한다.
     *
     * @param param 업데이트에 필요한 파라미터를 담은 Map
     * @return DB에 성공적으로 업데이트된 row의 수
     * @throws Exception DB 업데이트 도중 발생할 수 있는 예외
     * @author min
     * @since 2023/07/30
     */
    @Override
    public int updateCancelPay(Map<String, Object> param) throws Exception {
        return session.update(namespace + "updateCancelPay", param);
    }

    /**
     * 모든 결제 정보를 삭제한다.
     *
     * @return DB에서 성공적으로 삭제된 row의 수
     * @throws Exception DB 삭제 도중 발생할 수 있는 예외
     * @author min
     * @since 2023/07/10
     */
    @Override
    public int deleteAllPay() throws Exception {
        return session.delete(namespace + "deleteAllPay");
    }

    /**
     * 결제 정보의 총 개수를 조회한다.
     *
     * @return DB에 저장된 결제 정보의 총 개수
     * @throws Exception DB 조회 도중 발생할 수 있는 예외
     * @author min
     * @since 2023/07/10
     */
    @Override
    public int countPay() throws Exception {
        return session.selectOne(namespace + "countPay");
    }

    /**
     * 최근 1개월간 일별 결제금액을 조회한다.
     *
     * @return 일별 결제금액 정보를 담은 Map의 List
     * @throws Exception DB 조회 도중 발생할 수 있는 예외
     * @author min
     * @since 2023/08/06
     */
    @Override
    public List<Map<String, Object>> selectDailyTotalPayAmt() throws Exception {
        return session.selectList(namespace + "selectDailyTotalPayAmt");
    }

}
