let orderViewGrid;
namespace("orderView");
orderView = {
    initLoad: () => {
        // 기본은 오늘 날짜로 세팅(from ~ to)
        setCalendarRangeByDays(orderView.startDate, orderView.endDate, 0);
        syusyu.common.Bos.setupEnterSearch('search_container', 'btn_search');

        // 주문 리스트를 가져온다.
        orderView.function.getOrderList();
    },

    bindButtonEvent: () => {
        const $searchBtn = document.querySelector('#btn_search');
        const $dateRangeContainer = document.querySelector('.date_range_container'); // 날짜 범위 선택 tab container
        const $orderStatusCheckbox = document.querySelector('#orderStatusCheckbox'); // 주문상태 체크박스
        const $excelDownloadBtn = document.querySelector('#btn_excel_download'); // 엑셀 다운로드

        $searchBtn.addEventListener('click', orderView.function.getOrderList);
        $dateRangeContainer.addEventListener('click', orderView.eventHandler.dateRangeContainerClick);
        $orderStatusCheckbox.addEventListener('click', (e) => orderView.eventHandler.orderStatusCheckboxClick(e));
        $excelDownloadBtn.addEventListener('click', orderView.eventHandler.excelDownloadBtnClick);
    },

    startDate: 'start_date', // 조회시작일
    endDate: 'end_date', // 조회종료일
}

namespace("orderView.eventHandler");
orderView.eventHandler = {
    excelDownloadBtnClick() {
        orderViewGrid.download("xlsx", `주문통합검색_${getYYYYMMDDHHMM()}.xlsx`);
    },

    // 주문 상태 체크박스 클릭 이벤트 핸들러
    orderStatusCheckboxClick(e) {
        const chkAll = document.querySelector('#chk-all');

        // class가 all이면 하위 체크 박스를 전부 체크/체크 해제 해준다.
        if (e.target.id === 'chk-all')
            orderView.function.checkAll(e.target.checked);

        // 만약 현재 체크되어있는 개수와 전체 체크박스의 개수가 다르면 전체 체크박스 체크 해제하기
        const checkbox = document.querySelectorAll('.chk-point');
        const allChkCnt = checkbox.length; // 전체 체크박수 개수
        const chkCnt = orderView.function.getCheckedBox().length; // 체크된 체크박스 개수

        // 모든 체크박스가 체크되어있는지 확인한다. 그렇지 않은 경우 전체 체크박스 선택 해제한다.
        chkAll.checked = allChkCnt === chkCnt;

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
        setCalendarRangeByDays(orderView.startDate, orderView.endDate, that.dataset.interval);

    },
}

namespace("orderView.function");
orderView.function = {
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

    // 주문 리스트를 가져오는 함수
    getOrderList() {
        // 1. 주문조회 시 사용할 조회조건을 가져온다.
        const dateType = document.querySelector('#date_type').selectedOptions[0].value; // 조회할 날짜의 종류
        const startDate = document.querySelector('#start_date').value; // 시작일
        const endDate = document.querySelector('#end_date').value; // 종료일
        const searchType = document.querySelector('#search_type').value; // 조회조건
        const searchKeyword = document.querySelector('#search_keyword').value; // 검색어
        const ordStus = orderView.function.getCheckedBox().map(input => input.value); // 주문상태 체크된 체크박스를 가져온다.

        // 2. 조회조건을 param으로 넘겨서 데이터를 받아온다.
        const param = {
            dateType
            , startDate
            , endDate
            , searchType
            , searchKeyword
            , ordStus
        };

        syusyu.common.Ajax.sendJSONRequest('GET', '/bos/orders', param, res => {
            orderView.function.showOrderList(res.orderInfoList);
        }, null, true);
    },

    // 주문 리스틀 보여주는 함수
    showOrderList(orderList) {
        // 3. 받아온 데이터를 tableDate에 넣어준다.

        // 테이블에 사용될 데이터를 정의한다.
        const gridId = '#orderViewGrid';

        const columns = [ // 테이블의 열을 정의한다.
            {title: "Select", formatter: "rowSelection", titleFormatter: "rowSelection", hozAlign: "center", headerSort: false, download: false}, // 체크박스 컬럼 추가
            {title: "주문번호", field: "ordNo"},
            {title: "주문상세번호", field: "ordDtlNo", cellClick: syusyu.common.Tabulator.openOrderDetailPopup, formatter: syusyu.common.Tabulator.blueCellFormatter},
            {title: "주문일시", field: "ordDttm"},
            {title: "주문상태", field: "ordStusNm"},
            {title: "클레임 처리상태", field: "claimStusNm"},
            {title: "상품ID", field: "prodId"},
            {title: "상품명", field: "prodNm"},
            {title: "옵션", field: "optNm"},
            {title: "수량", field: "qty", formatter: syusyu.common.Tabulator.formatNumberForTabulator},
            {title: "상품금액", field: "prodAmt", formatter: syusyu.common.Tabulator.formatNumberForTabulator},
            {title: "결제방법", field: "payTpNm"},
            {title: "결제금액", field: "realPayAmt", formatter: syusyu.common.Tabulator.formatNumberForTabulator},
            {title: "구매자명", field: "ordrNm"},
            {title: "수령인", field: "recipient"},
            {title: "택배사", field: "dlvCom"},
            {title: "송장번호", field: "trckNo"},
            {title: "주문상태코드", field: "ordStus", visible: false},
        ];

        orderViewGrid = syusyu.common.Tabulator.createTabulatorTable(gridId, orderList, columns, true);
    },
}