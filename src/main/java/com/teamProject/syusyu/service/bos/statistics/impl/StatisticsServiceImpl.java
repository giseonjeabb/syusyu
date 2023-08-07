package com.teamProject.syusyu.service.bos.statistics.impl;

import com.teamProject.syusyu.dao.order.OrderInfoDAO;
import com.teamProject.syusyu.dao.order.PayDAO;
import com.teamProject.syusyu.service.bos.statistics.StatisticsService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class StatisticsServiceImpl implements StatisticsService {
    private final PayDAO payDAO;
    private final OrderInfoDAO orderInfoDAO;

    public StatisticsServiceImpl(PayDAO payDAO, OrderInfoDAO orderInfoDAO) {
        this.payDAO = payDAO;
        this.orderInfoDAO = orderInfoDAO;
    }

    /**
     * 관리자 메인 대시보드에 보여줄 통계 데이터를 조회한다.
     * 1. 최근 1개월 간의 일별 결제금액
     * 2. 상품별 판매액
     * 3. 주문 상태별 주문 건수 카운트
     *
     * @return 관리자 메인 대시보드에 보여줄 통계 데이터를 담은 Map 객체
     * @throws Exception DB 조회 도중 발생할 수 있는 예외
     * @author min
     * @since 2023/08/06
     */
    @Override
    public Map<String, Object> getDashBoardStatistics() throws Exception {
        // 최근 1개월간의 일별 결제금액 조회
        Map<String, Object> dailyTotalPayAmt = getDailyTotalPayAmt();

        // 상품별 판매액 조회
        Map<String, Object> payByProd = getPayByProd();

        // 주문 상태별로 주문 건수를 카운트한다.
        List<Map<String, Integer>> countByOrdStusList = orderInfoDAO.countByOrdStus();

        Map<String, Object> dashBoardStatistics = new HashMap<>();
        dashBoardStatistics.put("dailyTotalPayAmt", dailyTotalPayAmt);
        dashBoardStatistics.put("payByProd", payByProd);
        dashBoardStatistics.put("countByOrdStusList", countByOrdStusList);

        return dashBoardStatistics;
    }

    /**
     * 최근 1개월간의 일별 결제금액을 조회한다.
     * @return 일별 결제금액에 대한 맵 정보
     * @throws Exception DB 조회 도중 발생할 수 있는 예외
     * @author min
     * @since 2023/08/06
     */
    private Map<String, Object> getDailyTotalPayAmt() throws Exception {
        List<Map<String, Object>> dailyTotalPayAmtList = payDAO.selectDailyTotalPayAmt();
        List<String> payDttmList = dailyTotalPayAmtList.stream().map(map -> (String) map.get("PAY_DTTM")).collect(Collectors.toList());
        List<Integer> totPayAmtList = dailyTotalPayAmtList.stream() .map(map -> ((BigDecimal) map.get("TOT_PAY_AMT")).intValueExact()) .collect(Collectors.toList());

        Map<String, Object> dailyTotalPayAmt = new HashMap<>();
        dailyTotalPayAmt.put("payDttmList", payDttmList);
        dailyTotalPayAmt.put("totPayAtmList", totPayAmtList);

        return dailyTotalPayAmt;
    }

    /**
     * 상품별 판매액을 조회한다.
     * @return 상품별 판매액에 대한 맵 정보
     * @throws Exception DB 조회 도중 발생할 수 있는 예외
     * @author min
     * @since 2023/08/06
     */
    private  Map<String, Object> getPayByProd() throws Exception {
        List<Map<String, Object>> payByProdList = orderInfoDAO.selectPayByProd();
        List<String> prodNmList = payByProdList.stream().map(map -> (String) map.get("PROD_NM")).collect(Collectors.toList());
        List<Double> totProdAmtList = payByProdList.stream().map(map -> (Double) map.get("TOT_PROD_AMT")).collect(Collectors.toList());

        Map<String, Object> payByProd = new HashMap<>();
        payByProd.put("prodNmList", prodNmList);
        payByProd.put("totProdAmtList", totProdAmtList);

        return payByProd;
    }


}
