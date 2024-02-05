package com.teamProject.syusyu.service.order;

import com.teamProject.syusyu.dao.product.ProdOptDAO;
import com.teamProject.syusyu.domain.order.Order;
import com.teamProject.syusyu.domain.product.ProdOptDTO;
import com.teamProject.syusyu.service.fos.order.FOS_OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class OrderConcurrencyTest {
    @Autowired
    FOS_OrderService service;
    @Autowired
    ProdOptDAO prodOptDAO;

    @Test
    public void orderQtyTest() throws Exception {
        // 1. 테스트할 상품의 재고수량을 1로 설정한다.(opt_comb_no = 1, 2)
        int[] optCombArr = {1};
        int[] invQtyArr = {1};
        int updateInvQtyresult = setInvQty(optCombArr, invQtyArr);

        // 재고수량 변경이 잘 되었는지 체크
        assertTrue(optCombArr.length == updateInvQtyresult);

        // 2. 2개의 쓰레드로 총 10개의 주문을 시도한다.
        int numberOfThreads = 2;
        int ordersPerThread = 1;

        ExecutorService executorService = Executors.newFixedThreadPool(numberOfThreads);

        for (int i = 0; i < numberOfThreads; i++) {
            executorService.execute(() -> {
                for (int j = 0; j < ordersPerThread; j++) {
                    // 현재 쓰레드 이름 출력
                    System.out.println("Executing order #" + j + " on thread: " + Thread.currentThread().getName());

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

        // 3. 재고수량이 기대한값대로 0인지 체크
        List<ProdOptDTO> prodOptDTOList = prodOptDAO.selectProductQty(optCombArr);
        int totalProdInvQty = prodOptDTOList.stream().mapToInt(ProdOptDTO::getInvQty).sum();

        assertEquals(0, totalProdInvQty);
    }

    private int setInvQty(int[] optCombNoArr, int[] invQtyArr) throws Exception {
        // 1. optCombNoArr의 길이만큼 param을 생성하고, dao 호출하기..
        Map<String, Integer> param = new HashMap<>();
        int result = 0;

        for (int i = 0; i < optCombNoArr.length; i++) {
            param.put("invQty", invQtyArr[i]);
            param.put("optCombNo", optCombNoArr[i]);

            result += prodOptDAO.updateProdQty(param);

            param.clear();
        }

        return result;
    }
}
