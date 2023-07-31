package com.teamProject.syusyu.dao.order;

import com.teamProject.syusyu.domain.order.OrdClaimDTO;

import java.util.List;

public interface OrdClaimDAO {
    int insertCancelClaim(OrdClaimDTO ordClaimDTO) throws Exception;

    OrdClaimDTO selectOrdClaim(int ordClaimNo) throws Exception;

    int deleteOrdClaim(int ordClaimNo) throws Exception;

    int deleteAllOrdClaim() throws Exception;

    int countOrdClaim() throws Exception;

    List<OrdClaimDTO> selectAllOrdClaims() throws Exception;
}
