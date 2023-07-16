package com.teamProject.syusyu.dao.order.impl;

import com.teamProject.syusyu.dao.order.PayRsltDAO;
import com.teamProject.syusyu.domain.order.PayRsltDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class PayRsltDAOImpl implements PayRsltDAO {
    private final SqlSession session;
    private static final String namespace = "com.teamProject.syusyu.PayRsltMapper.";

    public PayRsltDAOImpl(SqlSession session) {
        this.session = session;
    }

    /**
     * 결제 승인 결과 정보를 DB에 삽입한다.
     *
     * @param payRsltDTO 삽입할 결제 승인 결과 정보를 담은 DTO
     * @return DB에 성공적으로 삽입된 row의 수
     * @throws Exception DB 삽입 도중 발생할 수 있는 예외
     * @author min
     * @since 2023/07/10
     */
    @Override
    public int insertPayResult(PayRsltDTO payRsltDTO) throws Exception {
        return session.insert(namespace + "insertPayRslt", payRsltDTO);
    }

    /**
     * 결제번호에 해당하는 결제 승인 결과 정보를 DB에서 조회한다.
     *
     * @param payNo 조회할 결제 승인 결과의 결제번호
     * @return 조회된 결제 승인 결과 정보를 담은 DTO
     * @throws Exception DB 조회 도중 발생할 수 있는 예외
     * @author min
     * @since 2023/07/10
     */
    @Override
    public PayRsltDTO selectPayResult(int payNo) throws Exception {
        return session.selectOne(namespace + "selectPayRslt", payNo);
    }

    /**
     * 결제 승인 결과 정보를 DB에서 수정한다.
     *
     * @param PayRsltDTO 수정할 결제 승인 결과 정보를 담은 DTO
     * @return DB에서 성공적으로 수정된 row의 수
     * @throws Exception DB 수정 도중 발생할 수 있는 예외
     * @author min
     * @since 2023/07/10
     */
    @Override
    public int updatePayResult(PayRsltDTO PayRsltDTO) throws Exception {
        return session.update(namespace + "updatePayRslt", PayRsltDTO);
    }

    /**
     * 결제번호에 해당하는 결제 승인 결과 정보를 DB에서 삭제한다.
     *
     * @param payNo 삭제할 결제 승인 결과의 결제번호
     * @return DB에서 성공적으로 삭제된 row의 수
     * @throws Exception DB 삭제 도중 발생할 수 있는 예외
     * @author min
     * @since 2023/07/10
     */
    @Override
    public int deletePayResult(int payNo) throws Exception {
        return session.delete(namespace + "deletePayRslt", payNo);
    }

    /**
     * 모든 결제 승인 결과 정보를 DB에서 삭제한다.
     *
     * @return DB에서 성공적으로 삭제된 row의 수
     * @throws Exception DB 삭제 도중 발생할 수 있는 예외
     * @author min
     * @since 2023/07/10
     */
    @Override
    public int deleteAllPayResult() throws Exception {
        return session.delete(namespace + "deleteAllPayRslt");
    }

    /**
     * DB에 저장된 결제 승인 결과 정보의 총 개수를 조회한다.
     *
     * @return DB에 저장된 결제 승인 결과 정보의 총 개수
     * @throws Exception DB 조회 도중 발생할 수 있는 예외
     * @author min
     * @since 2023/07/10
     */
    @Override
    public int countPayResult() throws Exception {
        return session.selectOne(namespace + "countPayRslt");
    }
}
