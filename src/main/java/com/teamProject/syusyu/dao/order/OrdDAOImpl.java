package com.teamProject.syusyu.dao.order;

import com.teamProject.syusyu.domain.order.OrdDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class OrdDAOImpl implements OrdDAO {
    private final SqlSession session;
    private static final String namespace = "com.teamProject.syusyu.ordMapper.";

    public OrdDAOImpl(SqlSession session) {
        this.session = session;
    }

    /**
     * 주문을 생성한다.
     *
     * @param ordDTO 주문 데이터
     * @return insert row 수
     * @throws Exception DB 삽입 도중 발생할 수 있는 예외
     * @author min
     * @since 2023/07/10
     */
    @Override
    public int insertOrder(OrdDTO ordDTO) throws Exception {
        return session.insert(namespace + "insertOrd", ordDTO);
    }

    /**
     * 주문을 조회한다.
     *
     * @param ordNo 주문 테이블의 PK값
     * @return 주문 정보(OrdDTO)
     * @throws Exception DB 조회 도중 발생할 수 있는 예외
     * @author min
     * @since 2023/07/10
     */
    @Override
    public OrdDTO selectOrder(int ordNo) throws Exception {
        return session.selectOne(namespace + "selectOrd", ordNo);
    }

    /**
     * 모든 주문 데이터를 삭제한다.
     *
     * @return 삭제된 row 수
     * @throws Exception DB 조회 도중 발생할 수 있는 예외
     * @author min
     * @since 2023/07/10
     */
    @Override
    public int deleteAllOrder() throws Exception {
        return session.delete(namespace + "deleteAllOrd");
    }

    // 존재하는 총 주문의 개수를 반환한다.
    @Override
    public int countOrd() throws Exception {
        return session.selectOne(namespace + "countOrd");
    }
}
