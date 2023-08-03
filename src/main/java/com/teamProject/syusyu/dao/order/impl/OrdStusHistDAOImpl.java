package com.teamProject.syusyu.dao.order.impl;

import com.teamProject.syusyu.dao.order.OrdStusHistDAO;
import com.teamProject.syusyu.domain.order.OrdStusHistDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrdStusHistDAOImpl implements OrdStusHistDAO {
    private final SqlSession session;
    private static final String namespace = "com.teamProject.syusyu.ordStusHistMapper.";

    public OrdStusHistDAOImpl(SqlSession session) {
        this.session = session;
    }

    /**
     * 주문상태이력 정보를 DB에 삽입한다.
     *
     * @param ordStusHistDTO 삽입할 주문상태이력 정보를 담은 DTO
     * @return DB에 성공적으로 삽입된 row의 수
     * @throws Exception DB 삽입 도중 발생할 수 있는 예외
     * @author min
     * @since 2023/07/10
     */
    @Override
    public int insertOrderStatusHistory(OrdStusHistDTO ordStusHistDTO) throws Exception {
        return session.insert(namespace + "insertOrdStusHist", ordStusHistDTO);
    }

    /**
     * 주문상세번호에 해당하는 주문 상태 이력 정보를 조회한다.
     *
     * @param ordDtlNo 주문상세번호
     * @return 조회된 주문 상태 이력 정보를 담은 DTO
     * @throws Exception DB 조회 도중 발생할 수 있는 예외
     * @author min
     * @since 2023/07/10
     */
    @Override
    public List<OrdStusHistDTO>  selectOrderStatusHistory(int ordDtlNo) throws Exception {
        return session.selectList(namespace + "selectOrdStusHist", ordDtlNo);
    }

    /**
     * 모든 주문 상태 이력 정보를 DB에서 삭제한다.
     *
     * @return DB에서 성공적으로 삭제된 row의 수
     * @throws Exception DB 삭제 도중 발생할 수 있는 예외
     * @author min
     * @since 2023/07/10
     */
    @Override
    public int deleteAllOrderStatusHistory() throws Exception {
        return session.delete(namespace + "deleteAllOrdStusHist");
    }

    /**
     * DB에 저장된 주문 상태 이력 정보의 총 개수를 조회한다.
     *
     * @return DB에 저장된 주문 상태 이력 정보의 총 개수
     * @throws Exception DB 조회 도중 발생할 수 있는 예외
     * @author min
     * @since 2023/07/10
     */
    @Override
    public int countOrderStatusHistory() throws Exception {
        return session.selectOne(namespace + "countOrdStusHist");
    }
}
