namespace("orderView");
orderView = {
    initLoad: () => {
        // 페이지 로드시 실행될 코드
        orderView.function.getOrderInfoList();
    },

    bindButtonEvent: () => {
        // 이벤트 핸들러를 연결하는 코드
    },
}

namespace("orderView.eventHandler");
orderView.eventHandler = {
    // 특정 이벤트를 처리하는 함수들
}

namespace("orderView.function");
orderView.function = {

    // 페이지 내에서 사용되는 주요 함수들
    getOrderInfoList() { // TODO 이게 어떻게 허용이 되는건지 찾아보기
        const param = {
            startDate: '2023-01-01'
            , endDate: '2023-12-31',
        };

        syusyu.common.Ajax.sendJSONRequest('GET', '/orderInfo', param, res => {
            orderView.function.showOrderInfoList(res);
        });
    },
    showOrderInfoList(orderInfoList) {
        // 0. 마이페이지 - 주문조회 상위 div 요소를 가져온다.
        const $orderListBox = document.querySelector('.orderlistbox');
        // 1. 리스트를 초기화한다.
        $orderListBox.innerHTML = ``;

        let result = ``;

        for (let ordNum in orderInfoList) {
            const ordDttm = orderInfoList[ordNum][0].ordDttm.substring(0, 10); // 주문번호
            result += `
            <div class="order-history-list">
                <div class="history-info">
                    <div class="detail">
                        <span class="order-num">${ordNum}</span>
                        <span class="date">${ordDttm}</span>
                    </div>
                    <div class="a-btn-area">
                        <a href="order_detail?order=39120&amp;params=ZH4U0DtZAK0J7k4i5OCPJxgYP2v78c19Qvscl6aP7kZ1b241K8u" class="btn">
                            <span>상세보기</span>
                        </a>
                    </div>
                </div>`;
                orderInfoList[ordNum].forEach(function (orderInfo) {
                result += `
                <div class="order-item">
                    <div class="thumb">
                        <img src="${orderInfo.repImg}" alt="">
                    </div>
                    <div class="order-info">
                        <div class="badge-cont">
                            <span class="badge-item ty11 fw-7">${orderInfo.ordStus}</span>
                        </div>
                        <ul>
                            <li>
<!--                                <span class="tit fw-7">상품명</span>-->
                                <span>${orderInfo.prodNm}</span>
                            </li>
                            <li>
                                <span>${orderInfo.optNm}</span>
                                <span>${orderInfo.qty}</span>
</li>
                            <li>
<!--                                <span class="tit fw-7">결제금액</span>-->
                                <span>${orderInfo.realPayAmt}</span>
                            </li>
                        </ul>
                    </div>
                </div>`;
                });
            result += ` </div>`;
        }
        $orderListBox.innerHTML += result;
    },

}