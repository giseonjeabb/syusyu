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
    /**
     * 주문 정보를 내림차순으로 정렬한 데이터를 반환한다.
     *
     * @param {Object} orderInfoList 주문 정보를 담은 객체. key는 주문 번호, value는 해당 주문의 상세 정보를 담은 배열.
     * @returns {Array} 주문 번호를 기준으로 내림차순으로 정렬한 주문 정보 배열
     * @author min
     * @since 2023/08/02
     */
    convertOrderInfo(orderInfoList) {
        return Object.keys(orderInfoList).map(key => {
            return {
                ordNo: key,
                details: orderInfoList[key]
            };
        }).sort((a, b) => b.ordNo - a.ordNo);
    },

    /**
     * 주문 상세 HTML을 생성한다.
     *
     * @param {Object} orderInfo 주문 정보를 담은 객체
     * @returns {string} 생성된 HTML 문자열
     * @author min
     * @since 2023/08/02
     */
    createOrderDetail(orderInfo) {
        return `
        <div class="order-item">
            <div class="thumb">
                <a href="/fos/products/product/${orderInfo.prodId}" target="_blank">
                    <img src="${orderInfo.repImg}" alt="">
                </a>
            </div>
            <div class="order-info">
                <div class="badge-cont">
                    <span class="badge-item ${orderInfo.ordStus === '70' ? 'ty11' : 'ty13'} fw-7">${orderInfo.ordStusNm}</span>
                </div>
                <ul>
                    <li>
                        <span class="title">${orderInfo.prodNm}</span>
                    </li>
                    <li>
                        ${orderInfo.optNm ? `<span class="option">${orderInfo.optNm}</span>` : ''}
                        <span class="qty"> ${formatPrice(orderInfo.qty)}개 </span>
                    </li>
                    <li>
                        <span>
                            <strong>
                                ${formatPrice(orderInfo.prodAmt)}
                            </strong>
                            원
                        </span>
                    </li>
                </ul>
            </div>
        </div>`;
    },

    /**
     * 주문 리스트의 HTML을 생성한다.
     *
     * @param {Object} orderInfo2 주문 정보가 담겨져있는 객체
     * @returns {string} 생성된 HTML 문자열
     * @author min
     * @since 2023/08/02
     */
    createOrderList(orderInfo2) {
        const ordNo = orderInfo2.ordNo; // 주문번호
        const ordDttm = orderInfo2.details[0].ordDttm.substring(0, 10); // 주문일시
        return `
        <div class="order-history-list">
            <div class="history-info">
                <div class="detail">
                    <span class="order-num">${ordNo}</span>
                    <span class="date">${ordDttm}</span>
                </div>
                <div class="a-btn-area">
                    <a href="/fos/orders/${ordNo}" class="btn">
                        <span>상세보기</span>
                    </a>
                </div>
            </div>
            ${orderInfo2.details.map(orderView.function.createOrderDetail).join('')}
        </div>`;
    },

    /**
     * 주문 목록을 생성해서 화면에 보여준다.
     *
     * @param {Object} orderInfoList 주문 정보를 담은 객체. key는 주문 번호, value는 해당 주문의 상세 정보를 담은 배열.
     * @author min
     * @since 2023/08/02
     */
    showOrderInfoList(orderInfoList) {
        const $orderListBox = document.querySelector('.orderlistbox');
        $orderListBox.innerHTML = '';

        const arrayData = orderView.function.convertOrderInfo(orderInfoList);
        $orderListBox.innerHTML = arrayData.map(orderView.function.createOrderList).join('');
    },
}