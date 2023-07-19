package com.teamProject.syusyu.dao.cs;

import com.teamProject.syusyu.domain.cs.NoticeDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class NoticeDAOTest {

    @Autowired
    NoticeDAO noticeDAO;
    @Test
    public void selectAll() throws Exception {
        System.out.println("noticeDAO = "+noticeDAO.selectAll());
    }

    @Test
    public void insert()throws Exception{
        NoticeDTO noticeDTO = new NoticeDTO();
        noticeDTO.setNotcTp("20");
        noticeDTO.setTitle("Test 제목");
        noticeDTO.setContent("Test 내용");
        noticeDTO.setRegrId(80000);

        int rowCnt = noticeDAO.insert(noticeDTO);
        int rowCnt2 = noticeDAO.insert(noticeDTO);

        assertEquals(1,rowCnt);

    }

    @Test
    public void delete()throws Exception{
        NoticeDTO noticeDTO = new NoticeDTO("20","Test제목","TEST 내용",80000);
        int rowCnt = noticeDAO.insert(noticeDTO);


        rowCnt = noticeDAO.delete(136);

        assertEquals(1,rowCnt);
    }
}