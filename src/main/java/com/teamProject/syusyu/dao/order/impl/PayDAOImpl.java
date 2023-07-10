package com.teamProject.syusyu.dao.order.impl;

import com.teamProject.syusyu.dao.order.PayDAO;
import com.teamProject.syusyu.domain.order.PayDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class PayDAOImpl implements PayDAO {
    private final SqlSession session;
    private static final String namespace = "com.teamProject.syusyu.payMapper.";

    public PayDAOImpl(SqlSession session) {
        this.session = session;
    }

    /**
     * 결제 정보를 DB에 삽입한다.
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
     * 결제번호에 해당하는 결제 정보를 DB에서 조회한다.
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
     * 모든 결제 정보를 DB에서 삭제한다.
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
     * DB에 저장된 결제 정보의 총 개수를 조회한다.
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
}
