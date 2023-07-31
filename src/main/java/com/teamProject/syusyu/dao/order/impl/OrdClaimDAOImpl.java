package com.teamProject.syusyu.dao.order.impl;

import com.teamProject.syusyu.dao.order.OrdClaimDAO;
import com.teamProject.syusyu.domain.order.OrdClaimDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrdClaimDAOImpl implements OrdClaimDAO {
    private final SqlSession session;
    private static final String namespace = "com.teamProject.syusyu.ordClaimMapper.";

    public OrdClaimDAOImpl(SqlSession session) {
        this.session = session;
    }

    /**
     * 주문취소 정보를 DB에 삽입한다.
     *
     * @param ordClaimDTO 주문취소 정보를 담은 DTO
     * @return DB에 성공적으로 삽입된 row의 수
     * @throws Exception DB 삽입 도중 발생할 수 있는 예외
     * @author min
     * @since  2023/07/30
     */
    @Override
    public int insertCancelClaim(OrdClaimDTO ordClaimDTO) throws Exception {
        return session.insert(namespace + "insertCancelClaim", ordClaimDTO);
    }

    /**
     * 주문 클레임 번호에 해당하는 주문 클레임 정보를 DB에서 조회한다.
     *
     * @param ordClaimNo 조회할 주문 클레임의 번호
     * @return 조회된 주문 클레임 정보를 담은 DTO
     * @throws Exception DB 조회 도중 발생할 수 있는 예외
     * @author min
     * @since  2023/07/30
     */
    @Override
    public OrdClaimDTO selectOrdClaim(int ordClaimNo) throws Exception {
        return session.selectOne(namespace + "selectOrdClaim", ordClaimNo);
    }

    /**
     * 주문 클레임 번호에 해당하는 주문 클레임 정보를 DB에서 삭제한다.
     *
     * @param ordClaimNo 삭제할 주문 클레임의 번호
     * @return DB에서 성공적으로 삭제된 row의 수
     * @throws Exception DB 삭제 도중 발생할 수 있는 예외
     * @author min
     * @since  2023/07/30
     */
    @Override
    public int deleteOrdClaim(int ordClaimNo) throws Exception {
        return session.delete(namespace + "deleteOrdClaim", ordClaimNo);
    }

    /**
     * 모든 주문 클레임 정보를 DB에서 삭제한다.
     *
     * @return DB에서 성공적으로 삭제된 row의 수
     * @throws Exception DB 삭제 도중 발생할 수 있는 예외
     * @author min
     * @since  2023/07/30
     */
    @Override
    public int deleteAllOrdClaim() throws Exception {
        return session.delete(namespace + "deleteAllOrdClaim");
    }

    /**
     * DB에 저장된 주문 클레임 정보의 총 개수를 조회한다.
     *
     * @return DB에 저장된 주문 클레임 정보의 총 개수
     * @throws Exception DB 조회 도중 발생할 수 있는 예외
     * @author min
     * @since  2023/07/30
     */
    @Override
    public int countOrdClaim() throws Exception {
        return session.selectOne(namespace + "countOrdClaim");
    }

    /**
     * DB에 저장된 모든 주문 클레임 정보를 조회한다.
     *
     * @return 모든 주문 클레임 정보를 담은 리스트
     * @throws Exception DB 조회 도중 발생할 수 있는 예외
     * @author min
     * @since  2023/07/30
     */
    @Override
    public List<OrdClaimDTO> selectAllOrdClaims() throws Exception {
        return session.selectList(namespace + "selectAllOrdClaims");
    }
}
