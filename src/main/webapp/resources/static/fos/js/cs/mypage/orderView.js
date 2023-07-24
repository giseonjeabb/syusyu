namespace("orderView");
orderView = {
    initLoad: () => {
        // 기본은 캘린더 1개월 범위로 세팅
        setCalendarRangeByMonths(orderView.startDate, orderView.endDate, 1);
        // 주문 목록 정보를 가져온다.
        orderView.eventHandler.getOrderInfoList();
    },

    bindButtonEvent: () => {
        const $searchBtn = document.querySelector('#btn_search'); // 검색 버튼(주문조회)
        const $dateRangeContainer = document.querySelector('.date_range_container'); // 날짜 범위 선택 tab container

        $dateRangeContainer.addEventListener('click', orderView.eventHandler.dateRangeContainerClick);
        $searchBtn.addEventListener('click', orderView.eventHandler.getOrderInfoList);
    },

    startDate: 'start_date', // 조회시작일
    endDate: 'end_date', // 조회종료일
}

namespace("orderView.eventHandler");
orderView.eventHandler = {
    dateRangeContainerClick(e) {
        const that = e.target;

        // 현재 클릭된 버튼에 'active' 클래스를 추가한다.
        that.classList.add("active");

        // 다른 버튼들은 'active' 클래스를 제거한다.
        const $buttons = document.querySelectorAll(".date_range"); // 결제수단 버튼
        $buttons.forEach(btn => {
            if (btn !== that) {
                btn.classList.remove("active");
            }
        });

        // 클릭한 요소의 데이터 속성의 interval을 지용해 캘린더의 범위를 설정한다.
        setCalendarRangeByMonths(orderView.startDate, orderView.endDate, that.dataset.interval);

    },

    // 주문 리스트를 가져온다.
    getOrderInfoList() { // TODO 이게 어떻게 허용이 되는건지 찾아보기
        const param = {
            startDate: document.querySelector('#start_date').value // 시작일자
            , endDate: document.querySelector('#end_date').value, // 종료일자
        };

        syusyu.common.Ajax.sendJSONRequest('GET', '/fos/orders', param, res => {
            // 화면에 주문 목록 보여주기
            orderView.function.showOrderInfoList(res);
        });
    },
}

namespace("orderView.function");
orderView.function = {
    showOrderInfoList(orderInfoList) {
        // 0. 마이페이지 - 주문조회 상위 div 요소를 선택한다.
        const $orderListBox = document.querySelector('.orderlistbox');
        // 1. 주문목록 리스트를 초기화한다.
        $orderListBox.innerHTML = '';

        // 2. orderInfoList의 각 주문번호(ordNum)에 대해 HTML 문자열을 생성한다.
        const result = Object.keys(orderInfoList).map(ordNum => {
            // 주문 일자(ordDttm) 추출
            const ordDttm = orderInfoList[ordNum][0].ordDttm.substring(0, 10);

            // 3. 해당 주문번호의 모든 주문상세에 대해 HTML 문자열을 생성한다.
            const orderDetails = orderInfoList[ordNum].map(orderInfo => {
                // 옵션이 있을 경우 해당 HTML 문자열을 생성
                const option = orderInfo.optNm ? `<span class="option">${orderInfo.optNm}</span>` : '';
                // 주문상세 HTML 문자열 반환
                return `
                <div class="order-item">
                    <div class="thumb">
                        <img src="${orderInfo.repImg}" onclick="location.href='/product/${orderInfo.prodId}'">
                    </div>
                    <div class="order-info">
                        <div class="badge-cont">
                            <span class="badge-item ty11 fw-7">${orderInfo.ordStusNm}</span>
                        </div>
                        <ul>
                            <li>
                                <span class="title">${orderInfo.prodNm}</span>
                            </li>
                            <li>
                                ${option}
                                <span class="qty"> ${formatPrice(orderInfo.qty)}개 </span>
                            </li>
                            <li>
                                <span>
                                    <strong>
                                        ${formatPrice(orderInfo.realPayAmt)}
                                    </strong>
                                    원
                                </span>
                            </li>
                        </ul>
                    </div>
                </div>`;
            }).join(''); // 생성된 모든 주문상세 HTML 문자열을 하나로 결합

            // 4. 각 주문번호에 대한 HTML 문자열을 반환

            return `
            <div class="order-history-list">
                <div class="history-info">
                    <div class="detail">
                        <span class="order-num">${ordNum}</span>
                        <span class="date">${ordDttm}</span>
                    </div>
                    <div class="a-btn-area">
                        <a href="/fos/orders/${ordNum}" class="btn">
                            <span>상세보기</span>
                        </a>
                    </div>
                </div>
                ${orderDetails} <!-- 생성된 주문상세 HTML 문자열 삽입-->
            </div>`;
        }).join(''); // 생성된 모든 주문번호 HTML 문자열을 하나로 결합

        // 5. 생성된 주문목록 정보를 화면에 보여준다.
        $orderListBox.innerHTML = result;
    },


    // // 주문 목록 정보를 화면에 보여준다.
    // showOrderInfoList(orderInfoList) {
    //     // 0. 마이페이지 - 주문조회 상위 div 요소를 가져온다.
    //     const $orderListBox = document.querySelector('.orderlistbox');
    //     // 1. 리스트를 초기화한다.
    //     $orderListBox.innerHTML = ``;
    //
    //     let result = ``;
    //     for (let ordNum in orderInfoList) {
    //         const ordDttm = orderInfoList[ordNum][0].ordDttm.substring(0, 10); // 주문번호
    //         // 주문 목록 생성 시작
    //         result += `
    //         <div class="order-history-list">
    //             <div class="history-info">
    //                 <div class="detail">
    //                     <span class="order-num">${ordNum}</span>
    //                     <span class="date">${ordDttm}</span>
    //                 </div>
    //                 <div class="a-btn-area">
    //                     <a href="order_detail?order=39120&amp;params=ZH4U0DtZAK0J7k4i5OCPJxgYP2v78c19Qvscl6aP7kZ1b241K8u" class="btn">
    //                         <span>상세보기</span>
    //                     </a>
    //                 </div>
    //             </div>`;
    //
    //         // 각 주문 별로 주문상세 데이터 생성
    //         orderInfoList[ordNum].forEach(function (orderInfo) {
    //             result += `
    //             <div class="order-item">
    //                 <div class="thumb">
    //                     <img src="${orderInfo.repImg}" alt="">
    //                 </div>
    //                 <div class="order-info">
    //                     <div class="badge-cont">
    //                         <span class="badge-item ty11 fw-7">${orderInfo.ordStusNm}</span>
    //                     </div>
    //                     <ul>
    //                         <li>
    //                             <span class="title">${orderInfo.prodNm}</span>
    //                         </li>
    //                         <li>`;
    //             if (orderInfo.optNm) {
    //             result += `
    //                             <span class="option">${orderInfo.optNm}</span>`;
    //             }
    //             result += `
    //                             <span class="qty"> ${formatPrice(orderInfo.qty)}개 </span>
    //                         </li>
    //                         <li>
    //                             <span>
    //                                 <strong>
    //                                     ${formatPrice(orderInfo.realPayAmt)}
    //                                 </strong>
    //                                 원
    //                             </span>
    //                         </li>
    //                     </ul>
    //                 </div>
    //             </div>`;
    //         });
    //         result += ` </div>`; // 주문 목록 생성 끝
    //     }
    //     // 생성된 주문목록 정보를 화면에 보여준다.
    //     $orderListBox.innerHTML += result;
    // },
}