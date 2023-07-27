let dispatchManageGrid;
namespace("dispatchManage");
dispatchManage = {
    initLoad: () => {
        // 기본은 오늘 날짜로 세팅(from ~ to)
        setCalendarRangeByDays(dispatchManage.startDate, dispatchManage.endDate, 0);

        // 신규주문(주문확인 전 = 결제완료(10)) 리스트를 가져온다.
        dispatchManage.eventHandler.searchNewOrderBtnClick();
    },

    bindButtonEvent: () => {
        const $searchNewOrderBtn = document.querySelector('#btn_search_new_order'); // '결제확인' 상태의 주문 건들을 조회하는 버튼
        const $searchOrderConfirmBtn = document.querySelector('#btn_search_order_confirm'); // '주문확인' 상태의 주문 건들을 조회하는 버튼
        const $searchBtn = document.querySelector('#btn_search'); // 주문 검색 버튼
        const $dateRangeContainer = document.querySelector('.date_range_container'); // 날짜 범위 선택 tab container
        const $orderConfirmBtn = document.querySelector('#btn_order_confirm'); // 주문확인 버튼
        const $orderDispatchBtn = document.querySelector('#btn_order_dispatch'); // 발송처리 버튼
        const $orderStatusCheckbox = document.querySelector('#orderStatusCheckbox'); // 주문상태 체크박스

        $searchNewOrderBtn.addEventListener('click', dispatchManage.eventHandler.searchNewOrderBtnClick);
        $searchOrderConfirmBtn.addEventListener('click', dispatchManage.eventHandler.searchOrderConfirmBtnClick);
        $searchBtn.addEventListener('click', dispatchManage.eventHandler.searchBtnClick);
        $dateRangeContainer.addEventListener('click', dispatchManage.eventHandler.dateRangeContainerClick);
        $orderConfirmBtn.addEventListener('click', dispatchManage.eventHandler.orderConfirmBtnClick);
        $orderDispatchBtn.addEventListener('click', dispatchManage.eventHandler.orderDispatchBtnClick);
        $orderStatusCheckbox.addEventListener('click', (e) => dispatchManage.eventHandler.orderStatusCheckboxClick(e));
    },

    startDate: 'start_date', // 조회시작일
    endDate: 'end_date', // 조회종료일
}

namespace("dispatchManage.eventHandler");
dispatchManage.eventHandler = {
    // 신규주문(주문확인 전) 버튼 클릭 이벤트 핸들러
    searchNewOrderBtnClick() {
        dispatchManage.function.getOrderListByOrdStus('10');
    },

    // 신규주문(주문확인 후) 버튼 클릭 이벤트 핸들러
    searchOrderConfirmBtnClick() {
        dispatchManage.function.getOrderListByOrdStus('20');
    },

    searchBtnClick() {
        // 1. 주문조회 시 사용할 조회조건을 가져온다.
        const dateType = document.querySelector('#date_type').selectedOptions[0].value; // 조회할 날짜의 종류
        const startDate = document.querySelector('#start_date').value; // 시작일
        const endDate = document.querySelector('#end_date').value; // 종료일
        const searchType = document.querySelector('#search_type').value; // 조회조건
        const searchKeyword = document.querySelector('#search_keyword').value; // 검색어
        const ordStus = dispatchManage.function.getCheckedBox().map(input => input.value); // 주문상태 체크된 체크박스를 가져온다.

        // 2. 조회조건을 param으로 넘겨서 데이터를 받아온다.
        const param = {
            dateType
            , startDate
            , endDate
            , searchType
            , searchKeyword
            , ordStus
        };

        dispatchManage.function.getOrderList(param);
    },

    // 주문 상태 체크박스 클릭 이벤트 핸들러
    orderStatusCheckboxClick(e) {
        const chkAll = document.querySelector('#chk-all');

        // class가 all이면 하위 체크 박스를 전부 체크/체크 해제 해준다.
        if (e.target.id === 'chk-all')
            dispatchManage.function.checkAll(e.target.checked);

        // 만약 현재 체크되어있는 개수와 전체 체크박스의 개수가 다르면 전체 체크박스 체크 해제하기
        const checkbox = document.querySelectorAll('.chk-point');
        const allChkCnt = checkbox.length; // 전체 체크박수 개수
        const chkCnt = dispatchManage.function.getCheckedBox().length; // 체크된 체크박스 개수

        // 모든 체크박스가 체크되어있는지 확인한다. 그렇지 않은 경우 전체 체크박스 선택 해제한다.
        chkAll.checked = allChkCnt === chkCnt;

    },

    // 주문확인(결제완료(10) -> 주문확인(20))
    orderConfirmBtnClick() {
        // 1. 선택되어있는 셀을 가져온다.
        const checkedData = dispatchManageGrid.getSelectedData(); // grid에서 체크된 row를 가져온다.
        // 0. 선택한 셀에서 결제완료(10)이 아닌 데이터가 있는지 확인한다.
        if (!dispatchManage.function.validateOrderStatus(checkedData, '10'))
            return;

        // 2. 그 셀에서 ordDtlNo만 뽑아낸다.
        const checkedOrdDtlNoArr = checkedData.map(data => data.ordDtlNo); // 체크된 row에서 ordDtlNo(주문상세번호)만 가져온다.

        // 3. 뽑아낸 데이터를 서버쪽으로 보내준다.
        syusyu.common.Ajax.sendJSONRequest('POST', '/bos/orders/status/confirm', checkedOrdDtlNoArr, () => {
            alert("주문확인 처리가 완료되었습니다.");
            dispatchManage.eventHandler.searchNewOrderBtnClick();
        });
    },

    // 발송처리(주문확인(20) -> 배송중(30)으로 변경)
    orderDispatchBtnClick() {
        // 1. 선택되어있는 셀을 가져온다.
        const checkedData = dispatchManageGrid.getSelectedData(); // grid에서 체크된 row를 가져온다.
        // 0. 선택한 셀에서 주문확인(20) 상태가 아닌 데이터가 있는지 확인한다.
        if (!dispatchManage.function.validateOrderStatus(checkedData, '20'))
            return;

        // 2. 그 셀에서 ordDtlNo만 뽑아낸다.
        const checkedOrdDtlNoArr = checkedData.map(data => data.ordDtlNo); // 체크된 row에서 ordDtlNo(주문상세번호)만 가져온다.

        // 3. 뽑아낸 데이터를 서버쪽으로 보내준다.
        syusyu.common.Ajax.sendJSONRequest('POST', '/bos/orders/status/dispatch', checkedOrdDtlNoArr, () => {
            alert("발송처리가 완료되었습니다.");
            dispatchManage.eventHandler.searchOrderConfirmBtnClick();
        });
    },

    // 날짜 범위 선택 버튼 클릭 이벤트 핸들러
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
        setCalendarRangeByDays(dispatchManage.startDate, dispatchManage.endDate, that.dataset.interval);

    },
}

namespace("dispatchManage.function");
dispatchManage.function = {
    // 매개변수로 받은 주문상태 값에 해당하는 주문 건을 조회해오는 함수
    getOrderListByOrdStus(ordStus) {
        const param = {
            ordStus
        };

        dispatchManage.function.getOrderList(param);
    },

    // 체크된 체크박스를 반환하는 함수
    getCheckedBox() {
        return [...document.querySelectorAll('.chk-point')].filter(input => input.checked); // 체크된 체크박스 개수
    },

    // 하위 체크 박스를 전부 체크/체크 해제 해준다.
    checkAll(checked) {
        const checkbox = document.querySelectorAll('input[name="chk"]');
        for (const check of checkbox) {
            check.checked = checked;
        }
    },

    // param으로 전달받은 조회조건에 해당하는 주문 리스트를 가져오는 함수
    getOrderList(param) {
        syusyu.common.Ajax.sendJSONRequest('GET', '/bos/orders', param, res => {
            // 1. 주문 상태별로 주문 건수를 보여준다.
            dispatchManage.function.showCountByOrdStus(res.countByOrdStusList);
            // 2. 주문의 총 개수를 보여준다.
            // dispatchManage.function.showCountOrder();
            // 1. 주문 리스트를 보여준다.
            dispatchManage.function.showOrderList(res.orderInfoList);
        }, null, true);
    },

    // 주문 리스틀 보여주는 함수
    showOrderList(orderList) {
        // 3. 받아온 데이터를 tableDate에 넣어준다.

        // 테이블에 사용될 데이터를 정의한다.
        const gridId = '#dispatchManageGrid';

        const columns = [ // 테이블의 열을 정의한다.
            {
                title: "Select",
                formatter: "rowSelection",
                titleFormatter: "rowSelection",
                hozAlign: "center",
                headerSort: false
            }, // 체크박스 컬럼 추가
            {title: "주문번호", field: "ordNo"},
            {title: "주문상세번호", field: "ordDtlNo"},
            {title: "발송처리일", field: "dispatchDttm"},
            {title: "택배사", field: "dlvCom"},
            {title: "송장번호", field: "dlvNo"},
            {title: "구매자명", field: "ordrNm"},
            {title: "구매자 ID", field: "ordrId"},
            {title: "수령인", field: "recipient"},
            {title: "주문상태", field: "ordStusNm"},
            {title: "주문상태코드", field: "ordStus", visible: false},
            {title: "주문일시", field: "ordDttm"},
            {title: "상품아이디", field: "prodId"},
            {title: "상품명", field: "prodNm"},
            {title: "옵션", field: "optNm"},
            {title: "수량", field: "qty", formatter: syusyu.common.Tabulator.formatNumberForTabulator},
            {title: "상품금액", field: "prodAmt", formatter: syusyu.common.Tabulator.formatNumberForTabulator},
            {title: "결제방법", field: "payTp"},
            {title: "결제금액", field: "realPayAmt", formatter: syusyu.common.Tabulator.formatNumberForTabulator},
        ];


        dispatchManageGrid = syusyu.common.Tabulator.createTabulatorTable(gridId, orderList, columns, true);
    },

    // 주문확인으로 변경이 가능한 주문 건인지 검증한다.
    validateOrderStatus(checkedData, ordStus) {
        // 1. checkedData 중에서 ordDtlNo가 10이 아닌 걸 찾는다.(filter 이용)
        const notOrdStusPayCompleted = checkedData.filter(data => data.ordStus !== ordStus);

        // 1-2. 존재하지 않으면 true를 반환한다.
        if (notOrdStusPayCompleted.length === 0)
            return true;

        // 1-1. 아닌 게 존재하다면 주문확인 처리가 불가능한 주문건을 alert 창으로 띄워준다.
        const alertOrdDtlNo = notOrdStusPayCompleted.map(data => data.ordDtlNo).join(', ');
        alert("처리가 불가능한 주문 건이 존재합니다.(" + alertOrdDtlNo + ")");

        return false;
    },

    /**
     * 주문 상태별로 주문 건수를 보여준다.
     *
     * @param {Array} countByOrdStusList 주문 상태별 주문 건수가 담긴 객체배열
     * @author min
     * @since 2023/07/27
     */
    showCountByOrdStus(countByOrdStusList) {
        // 1. 신규주문(주문확인 전)에 해당하는 주문 건 개수를 할당해준다.
        dispatchManage.function.updateOrderCount('#newOrderCnt', '10', countByOrdStusList);
        // 2. 신규주문(주문확인 후)에 해당하는 주문 건 개수를 할당해준다.
        dispatchManage.function.updateOrderCount('#orderConfirmCnt', '20', countByOrdStusList);
    },

    /**
     * 주어진 주문 상태에 따른 주문 건수를 HTML 요소에 업데이트한다.
     *
     * @param {String} id 주문 건수를 표시할 HTML 요소의 ID
     * @param {String} status 주문 상태 코드
     * @param {Array} countByOrdStusList 주문 상태별 주문 건수가 담긴 객체배열
     * @author min
     * @since 2023/07/27
     */
    updateOrderCount(id, status, countByOrdStusList) {
        const matchingStatus = countByOrdStusList.find(countByOrdStus => countByOrdStus.ORD_STUS === status);
        const orderCount = matchingStatus ? matchingStatus.ORD_STUS_CNT : 0;
        document.querySelector(id).innerHTML = orderCount;
    }
}