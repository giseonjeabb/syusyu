package com.teamProject.syusyu.service.order;

import com.teamProject.syusyu.domain.order.Order;
import com.teamProject.syusyu.service.fos.order.FOS_OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.junit.Assert.fail;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class OrderConcurrencyTest {
    @Autowired
    FOS_OrderService service;

    @Test
    public void orderQtyTest() {
        int numberOfThreads = 3;
        int ordersPerThread = 100;

        ExecutorService executorService = Executors.newFixedThreadPool(numberOfThreads);

        for (int i = 0; i < numberOfThreads; i++) {
            executorService.execute(() -> {
                for (int j = 0; j < ordersPerThread; j++) {
                    Order order = FOS_OrderServiceImplTest.getOrder();
                    try {
                        // 주문을 생성한다.
                        service.order(order);
                    } catch (Exception e) {
                        e.printStackTrace();
                        fail("주문 생성 실패");
                    }
                }
            });
        }

        // 모든 스레드가 종료될 때까지 대기
        executorService.shutdown();
        while (!executorService.isTerminated()) {
            // 대기
        }
    }
}
