package com.teamProject.syusyu.service.bos.statistics;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class StatisticsServiceImplTest {
    @Autowired
    StatisticsService service;

    @Test
    public void getDashBoardStatistics() throws Exception {
        Map<String, Object> test = service.getDashBoardStatistics();

        System.out.println("test = " + test);
    }
}