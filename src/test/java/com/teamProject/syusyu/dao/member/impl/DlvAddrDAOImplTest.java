package com.teamProject.syusyu.dao.member.impl;

import com.teamProject.syusyu.dao.member.DlvAddrDAO;
import com.teamProject.syusyu.domain.member.DlvAddrDTO;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class DlvAddrDAOImplTest extends TestCase {
    @Autowired
    DlvAddrDAO dao;

    @Test
    public void testSelectDefaultDlvAddr() throws Exception {
        DlvAddrDTO dlvAddr = dao.selectDefaultDlvAddr(80001);
        System.out.println("dlvAddr = " + dlvAddr);
    }
}