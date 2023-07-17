package com.teamProject.syusyu.dao.order.impl;

import com.teamProject.syusyu.dao.order.OrdDtlDAO;
import com.teamProject.syusyu.domain.order.OrdDtlDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class OrdDtlDAOImpl implements OrdDtlDAO {
    private final SqlSession session;
    private static final String namespace = "com.teamProject.syusyu.ordDtlMapper.";

    public OrdDtlDAOImpl(SqlSession session) {
        this.session = session;
    }

    /**
     * 주문상세 정보를 DB에 삽입한다.
     *
     * @param ordDtlDTO 삽입할 주문상세 정보를 담은 DTO
     * @return DB에 성공적으로 삽입된 row의 수
     * @throws Exception DB 삽입 도중 발생할 수 있는 예외
     * @author min
     * @since 2023/07/10
     */
    @Override
    public int insertOrderDetail(OrdDtlDTO ordDtlDTO) throws Exception {
        return session.insert(namespace + "insertOrdDtl", ordDtlDTO);
    }

    /**
     * 주문상세번호에 해당하는 주문 상세 정보를 DB에서 조회한다.
     *
     * @param ordDtlNo 조회할 주문 상세 정보의 주문상세번호
     * @return 조회된 주문 상세 정보를 담은 DTO
     * @throws Exception DB 조회 도중 발생할 수 있는 예외
     * @author min
     * @since 2023/07/10
     */
    @Override
    public OrdDtlDTO selectOrderDetail(int ordDtlNo) throws Exception {
        return session.selectOne(namespace + "selectOrdDtl", ordDtlNo);
    }

    /**
     * 모든 주문 상세 정보를 DB에서 삭제한다.
     *
     * @return DB에서 성공적으로 삭제된 row의 수
     * @throws Exception DB 삭제 도중 발생할 수 있는 예외
     * @author min
     * @since 2023/07/10
     */
    @Override
    public int deleteAllOrderDetail() throws Exception {
        return session.delete(namespace + "deleteAllOrdDtl");
    }

    /**
     * DB에 저장된 주문 상세 정보의 총 개수를 조회한다.
     *
     * @return DB에 저장된 주문 상세 정보의 총 개수
     * @throws Exception DB 조회 도중 발생할 수 있는 예외
     * @author min
     * @since 2023/07/10
     */
    @Override
    public int countOrderDetail() throws Exception {
        return session.selectOne(namespace + "countOrdDtl");
    }
}
