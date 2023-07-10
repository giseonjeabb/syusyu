package com.teamProject.syusyu.dao.order.impl;

import com.teamProject.syusyu.dao.order.OrdDAO;
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
     * DB에 저장된 주문 정보의 총 갯수를 조회한다.
     *
     * @return DB에 저장된 주문 정보의 총 갯수
     * @throws Exception DB 조회 도중 발생할 수 있는 예외
     * @author min
     * @since  2023/07/10
     */
    @Override
    public int countOrd() throws Exception {
        return session.selectOne(namespace + "countOrd");
    }
}
