namespace("dashboard");
dashboard = {
    initLoad: () => {
        dashboard.function.getDashBoardStatistics();
    },

    bindButtonEvent: () => {
    },
}

namespace("dashboard.eventHandler");
dashboard.eventHandler = {
}

namespace("dashboard.function");
dashboard.function = {
    getDashBoardStatistics() {
        syusyu.common.Ajax.sendJSONRequest('GET', '/bos/dashboard/statistics', '', dashBoardStatistics => {
            // 일별매출현황
            dashboard.function.showDailyTotalPayAmtChart(dashBoardStatistics.dailyTotalPayAmt);
            // 상품별 결제금액
            dashboard.function.showPayByProd(dashBoardStatistics.payByProd);
            dashboard.function.showCountByOrdStus(dashBoardStatistics.countByOrdStusList);

        });
    },

    // 일별매출현황
    showDailyTotalPayAmtChart(dailyTotalPayAmt) {
        syusyu.common.Chart.createChart('myLineChart', 'line', dailyTotalPayAmt.payDttmList, dailyTotalPayAmt.totPayAtmList);
    },

    // 상품별 결제금액
    showPayByProd(payByProd) {
        syusyu.common.Chart.createChart('myLineChart2', 'bar', payByProd.prodNmList, payByProd.totProdAmtList, 'x');
    },

    showCountByOrdStus(countByOrdStusList) {
        syusyu.common.Bos.updateOrderCount('#newOrderCnt', ['10'], countByOrdStusList); // 10 = 결제완료
        syusyu.common.Bos.updateOrderCount('#orderConfirmCnt', ['20'], countByOrdStusList); // 20 = 주문확인
        syusyu.common.Bos.updateOrderCount('#inDeliveryCnt', ['30', '40', '50'], countByOrdStusList); // 30 = 발송완료
        syusyu.common.Bos.updateOrderCount('#deliveryComplete', ['60'], countByOrdStusList); // 60 = 배송완료
    }

}