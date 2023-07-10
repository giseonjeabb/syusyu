package com.teamProject.syusyu.dao.order.impl;

import com.teamProject.syusyu.dao.order.OrdDlvAddrDAO;
import com.teamProject.syusyu.domain.order.OrdDlvAddrDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class OrdDlvAddrDAOImpl implements OrdDlvAddrDAO {
    private final SqlSession session;
    private static final String namespace = "com.teamProject.syusyu.ordDlvAddrMapper.";

    public OrdDlvAddrDAOImpl(SqlSession session) {
        this.session = session;
    }

    /**
     * 주문 배송지 정보를 DB에 삽입한다.
     *
     * @param ordDlvAddrDTO 삽입할 주문 배송지 정보를 담은 DTO
     * @return DB에 성공적으로 삽입된 row의 수
     * @throws Exception DB 삽입 도중 발생할 수 있는 예외
     * @author min
     * @since 2023/07/10
     */
    @Override
    public int insertOrdDlvAddr(OrdDlvAddrDTO ordDlvAddrDTO) throws Exception {
        return session.insert(namespace + "insertOrdDlvAddr", ordDlvAddrDTO);
    }

    /**
     * 주문 배송지 정보를 DB에서 조회한다.
     *
     * @param ordDlvAddrNo 조회할 배송지의 주문 배송지 번호
     * @return 조회된 주문 배송지 정보를 담은 DTO
     * @throws Exception DB 조회 도중 발생할 수 있는 예외
     * @author min
     * @since 2023/07/10
     */
    @Override
    public OrdDlvAddrDTO selectOrdDlvAddr(int ordDlvAddrNo) throws Exception {
        return session.selectOne(namespace + "selectOrdDlvAddr", ordDlvAddrNo);
    }

    /**
     * 모든 주문 배송지 정보를 DB에서 삭제한다.
     *
     * @return DB에서 성공적으로 삭제된 row의 수
     * @throws Exception DB 삭제 도중 발생할 수 있는 예외
     * @author min
     * @since 2023/07/10
     */
    @Override
    public int deleteAllOrdDlvAddr() throws Exception {
        return session.delete(namespace + "deleteAllOrdDlvAddr");
    }

    /**
     * DB에 저장된 주문 배송지 정보의 총 개수를 조회한다.
     *
     * @return DB에 저장된 주문 배송지 정보의 총 개수
     * @throws Exception DB 조회 도중 발생할 수 있는 예외
     * @author min
     * @since 2023/07/10
     */
    @Override
    public int countOrdDlvAddr() throws Exception {
        return session.selectOne(namespace + "countOrdDlvAddr");
    }
}
