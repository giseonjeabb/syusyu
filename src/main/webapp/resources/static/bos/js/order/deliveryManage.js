let deliveryManageGrid;
namespace("deliveryManage");
deliveryManage = {
    initLoad: () => {
        // 기본은 오늘 날짜로 세팅(from ~ to)
        setCalendarRangeByDays(deliveryManage.startDate, deliveryManage.endDate, 0);
        syusyu.common.Bos.setupEnterSearch('search_container', 'btn_search');

        // 신규주문(주문확인 전 = 결제완료(10)) 리스트를 가져온다.
        // 배송중(30-발송완료, 40-집화완료, 50-배송중)
        deliveryManage.eventHandler.searchInDeliveryBtnClick();
    },

    bindButtonEvent: () => {
        const $searchInDeliveryBtn = document.querySelector('#btn_search_in_delivery'); // '배송중' 상태의 주문 건들을 조회하는 버튼
        const $searchDeliveryCompleteBtn = document.querySelector('#btn_search_delivery_complete'); // '배송완료' 상태의 주문 건들을 조회하는 버튼
        const $searchBtn = document.querySelector('#btn_search'); // 주문 검색 버튼
        const $dateRangeContainer = document.querySelector('.date_range_container'); // 날짜 범위 선택 tab container
        const $orderStatusCheckbox = document.querySelector('#orderStatusCheckbox'); // 주문상태 체크박스
        const $statusButtonArea = document.querySelector('.status_button_area');
        const $deliveryCompleteBtn = document.querySelector('#btn_delivery_complete'); // 배송완료 버튼
        const $excelDownloadBtn = document.querySelector('#btn_excel_download'); // 엑셀 다운로드 버튼

        $searchInDeliveryBtn.addEventListener('click', deliveryManage.eventHandler.searchInDeliveryBtnClick);
        $searchDeliveryCompleteBtn.addEventListener('click', deliveryManage.eventHandler.searchDeliveryCompleteBtnClick);
        $searchBtn.addEventListener('click', deliveryManage.eventHandler.searchBtnClick);
        $dateRangeContainer.addEventListener('click', deliveryManage.eventHandler.dateRangeContainerClick);
        $orderStatusCheckbox.addEventListener('click', (e) => deliveryManage.eventHandler.orderStatusCheckboxClick(e));
        $statusButtonArea.addEventListener('click', deliveryManage.eventHandler.statusButtonAreaClick);
        $deliveryCompleteBtn.addEventListener('click', deliveryManage.eventHandler.deliveryCompleteBtnClick);
        $excelDownloadBtn.addEventListener('click', deliveryManage.eventHandler.excelDownloadBtnClick);
    },

    startDate: 'start_date', // 조회시작일
    endDate: 'end_date', // 조회종료일
}

namespace("deliveryManage.eventHandler");
deliveryManage.eventHandler = {
    excelDownloadBtnClick() {
        deliveryManageGrid.download("xlsx", `배송현황_${getYYYYMMDDHHMM()}.xlsx`);
    },

    // 배송완료(주문상태 60으로 변경)
    deliveryCompleteBtnClick() {
        // 1. 선택되어있는 셀을 가져온다.
        const checkedData = deliveryManageGrid.getSelectedData(); // grid에서 체크된 row를 가져온다.

        // 선택한 셀에서 배송중(30-발송완료, 40-집화완료, 50-배송중) 상태가 아닌 데이터가 있는지 확인한다.
        if (!syusyu.common.Bos.validateOrderStatus(checkedData, ['30', '40', '50']))
            return;

        // 2. 그 셀에서 ordDtlNo만 뽑아낸다.
        const checkedOrdDtlNoArr = checkedData.map(data => data.ordDtlNo); // 체크된 row에서 ordDtlNo(주문상세번호)만 가져온다.

        // 3. 뽑아낸 데이터를 서버쪽으로 보내준다.
        syusyu.common.Ajax.sendJSONRequest('POST', '/bos/orders/status/delivery-complete', checkedOrdDtlNoArr, () => {
            alert("배송완료 처리가 완료되었습니다.");
            deliveryManage.eventHandler.searchInDeliveryBtnClick();
        });
    },

    statusButtonAreaClick(e) {
        const that = e.target;

        // 다른 버튼들은 'active' 클래스를 제거한다.
        const $buttons = document.querySelectorAll(".status_button"); // 결제수단 버튼
        $buttons.forEach(btn => {
            btn.classList.remove("active");
        });

        // 'active' 클래스를 추가한다.
        that.closest('.status_button').classList.add("active");
    },

    // 배송중 버튼 클릭 이벤트 핸들러
    searchInDeliveryBtnClick() {
        deliveryManage.function.getOrderListByOrdStus(['30', '40', '50']);
    },

    // 배송완료 버튼 클릭 이벤트 핸들러
    searchDeliveryCompleteBtnClick() {
        deliveryManage.function.getOrderListByOrdStus('60');
    },

    searchBtnClick() {
        // 1. 주문조회 시 사용할 조회조건을 가져온다.
        const dateType = document.querySelector('#date_type').selectedOptions[0].value; // 조회할 날짜의 종류
        const startDate = document.querySelector('#start_date').value; // 시작일
        const endDate = document.querySelector('#end_date').value; // 종료일
        const searchType = document.querySelector('#search_type').value; // 조회조건
        const searchKeyword = document.querySelector('#search_keyword').value; // 검색어
        const ordStus = deliveryManage.function.getCheckedBox().map(input => input.value); // 주문상태 체크된 체크박스를 가져온다.

        // 2. 조회조건을 param으로 넘겨서 데이터를 받아온다.
        const param = {
            dateType
            , startDate
            , endDate
            , searchType
            , searchKeyword
            , ordStus
        };

        deliveryManage.function.getOrderList(param);
    },

    // 주문 상태 체크박스 클릭 이벤트 핸들러
    orderStatusCheckboxClick(e) {
        const chkAll = document.querySelector('#chk-all');

        // class가 all이면 하위 체크 박스를 전부 체크/체크 해제 해준다.
        if (e.target.id === 'chk-all')
            deliveryManage.function.checkAll(e.target.checked);

        // 만약 현재 체크되어있는 개수와 전체 체크박스의 개수가 다르면 전체 체크박스 체크 해제하기
        const checkbox = document.querySelectorAll('.chk-point');
        const allChkCnt = checkbox.length; // 전체 체크박수 개수
        const chkCnt = deliveryManage.function.getCheckedBox().length; // 체크된 체크박스 개수

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
        setCalendarRangeByDays(deliveryManage.startDate, deliveryManage.endDate, that.dataset.interval);

    },
}

namespace("deliveryManage.function");
deliveryManage.function = {
    // 매개변수로 받은 주문상태 값에 해당하는 주문 건을 조회해오는 함수
    getOrderListByOrdStus(ordStus) {
        const param = { ordStus };

        deliveryManage.function.getOrderList(param);
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
            deliveryManage.function.showCountByOrdStus(res.countByOrdStusList);
            // 2. 주문의 총 개수를 보여준다.
            // deliveryManage.function.showCountOrder();
            // 1. 주문 리스트를 보여준다.
            deliveryManage.function.showOrderList(res.orderInfoList);
        }, null, true);
    },

    // 주문 리스틀 보여주는 함수
    showOrderList(orderList) {
        // 3. 받아온 데이터를 tableDate에 넣어준다.

        // 테이블에 사용될 데이터를 정의한다.
        const gridId = '#deliveryManageGrid';

        const columns = [ // 테이블의 열을 정의한다.
            {title: "Select", width: 20, formatter: "rowSelection", titleFormatter: "rowSelection", hozAlign: "center", headerSort: false, download: false}, // 체크박스 컬럼 추가
            {title: "주문번호", field: "ordNo", width: 120},
            {title: "주문상세번호", field: "ordDtlNo", width: 160, cellClick: syusyu.common.Tabulator.openOrderDetailPopup, formatter: syusyu.common.Tabulator.blueCellFormatter},
            {title: "발송처리일", field: "dispatchDttm", width: 200},
            {title: "택배사", field: "dlvCom", width: 160, editor: "select", editorParams: {
                    values: {
                        "1": "롯데택배",
                        "2": "하나로택배",
                        "3": "SC로지스",
                        "4": "로젠택배",
                        "5": "옐로우캡",
                        "6": "동부택배",
                        "7": "우체국택배",
                        "8": "CJ대한통운",
                        "9": "한진택배",
                        "10": "대신택배"
                    }
                },
                formatter: "lookup", // 보여지는 값을 다른 값으로 매핑
                formatterParams: {
                    "1": "롯데택배",
                    "2": "하나로택배",
                    "3": "SC로지스",
                    "4": "로젠택배",
                    "5": "옐로우캡",
                    "6": "동부택배",
                    "7": "우체국택배",
                    "8": "CJ대한통운",
                    "9": "한진택배",
                    "10": "대신택배"
                }
            },
            {title: "송장번호", field: "trckNo", width: 200, editor: "input"},
            {title: "구매자명", field: "ordrNm", width: 120},
            {title: "구매자 ID", field: "ordrId", width: 120},
            {title: "수령인", field: "recipient", width: 120},
            {title: "주문상태", field: "ordStusNm", width: 120},
            {title: "주문상태코드", field: "ordStus", visible: false, width: 120},
            {title: "주문일시", field: "ordDttm", width: 200},
            {title: "상품아이디", field: "prodId", width: 120},
            {title: "상품명", field: "prodNm", width: 120},
            {title: "옵션", field: "optNm", width: 200},
            {title: "수량", field: "qty", width: 120, formatter: syusyu.common.Tabulator.formatNumberForTabulator},
            {title: "상품금액", field: "prodAmt", width: 160, formatter: syusyu.common.Tabulator.formatNumberForTabulator},
            {title: "결제방법", field: "payTpNm", width: 120},
            {title: "결제금액", field: "realPayAmt", width: 200, formatter: syusyu.common.Tabulator.formatNumberForTabulator},
        ];

        deliveryManageGrid = syusyu.common.Tabulator.createTabulatorTable(gridId, orderList, columns, true);
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
        syusyu.common.Bos.updateOrderCount('#inDeliveryCnt', ['30', '40', '50'], countByOrdStusList);
        // 2. 신규주문(주문확인 후)에 해당하는 주문 건 개수를 할당해준다.
        syusyu.common.Bos.updateOrderCount('#orderConfirmCnt', ['60'], countByOrdStusList);
    },


}