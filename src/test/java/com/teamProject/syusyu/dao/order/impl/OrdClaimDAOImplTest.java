package com.teamProject.syusyu.dao.order.impl;

import com.teamProject.syusyu.dao.order.OrdClaimDAO;
import com.teamProject.syusyu.domain.order.OrdClaimDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class OrdClaimDAOImplTest {
    @Autowired
    OrdClaimDAO ordClaimDAO;

    @Test
    public void insertCancelClaim() throws Exception {
        OrdClaimDTO ordClaimDTO = OrdClaimDTO.Builder.anOrdClaimDTO()
//                .ordDtlNo(338)
//                .ordDtlNo(337)
                .ordDtlNo(336)
                .claimTp(1)
                .claimStus("17")
                .rfndYn('Y')
                .reqrId(80001)
                .reqRsn("10") // 10 = 단순변심(O0003)
                .reqDtlRsn("단순변심으로 취소")
                .build();

        ordClaimDAO.insertCancelClaim(ordClaimDTO);

        OrdClaimDTO result = ordClaimDAO.selectOrdClaim(ordClaimDTO.getOrdClaimNo());
        System.out.println("result = " + result);
        assertNotNull(result);

    }
}