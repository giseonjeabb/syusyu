namespace("orderView");
orderView = {
    initLoad: () => {
        // 기본은 캘린더 1개월 범위로 세팅
        setCalendarRangeByMonths(orderView.startDate, orderView.endDate, -1);

        orderView.function.showOrderList();
    },

    bindButtonEvent: () => {
    },

    startDate: 'start_date', // 조회시작일
    endDate: 'end_date', // 조회종료일
}

namespace("orderView.eventHandler");
orderView.eventHandler = {}

namespace("orderView.function");
orderView.function = {
    showOrderList() {
        // 1. 주문조회 시 사용할 조회조건을 가져온다.
        // 0) 조회할 날짜의 종류
        const dateType = document.querySelector('#start_date').selectedOptions[0].value;
        debugger;
        // 1) 시작일
        // 2) 종료일
        // 3) 조회조건
        // 4) 검색어

        // 2. 조회조건을 param으로 넘겨서 데이터를 받아온다.

        // 3. 받아온 데이터를 tableDate에 넣어준다.

        // 테이블에 사용될 데이터를 정의한다.
        const gridId = '#example-table';

        const tableData = [
            {
                ordNo: 89,
                ordDtlNo: 246,
                ordDttm: "2023-07-23 19:15:13",
                ordStusNm: "결제완료",
                claimStus: "",
                prodId: 10001,
                prodNm: "반스 올드스쿨",
                optNm: "color : BLACK, size : 220",
                qty: 3,
                prodAmt: 213600,
                payTp: 20,
                realPayAmt: 19280,
                ordrNm: "홍길동",
                recipient: "방채민"
            },
            {
                ordNo: 89,
                ordDtlNo: 247,
                ordDttm: "2023-07-23 19:15:13",
                ordStusNm: "결제완료",
                claimStus: "",
                prodId: 10007,
                prodNm: "아딜렛 클로그",
                optNm: "",
                qty: 1,
                prodAmt: 39600,
                payTp: 20,
                realPayAmt: 19280,
                ordrNm: "홍길동",
                recipient: "방채민"
            },
            {
                ordNo: 89,
                ordDtlNo: 248,
                ordDttm: "2023-07-23 19:15:13",
                ordStusNm: "결제완료",
                claimStus: "",
                prodId: 10011,
                prodNm: "로그 2.0",
                optNm: "",
                qty: 4,
                prodAmt: 384000,
                payTp: 20,
                realPayAmt: 19280,
                ordrNm: "홍길동",
                recipient: "방채민"
            },
        ];

        const columns = [ // 테이블의 열을 정의한다.
            {title: "주문번호", field: "ordNo"},
            {title: "주문상세번호", field: "ordDtlNo"},
            {title: "주문일시", field: "ordDttm"},
            {title: "주문상태", field: "ordStusNm"},
            {title: "클레임 처리상태", field: "claimStus"},
            {title: "상품ID", field: "prodId"},
            {title: "상품명", field: "prodNm"},
            {title: "옵션", field: "optNm"},
            {title: "수량", field: "qty"},
            {title: "상품금액", field: "prodAmt"},
            {title: "결제방법", field: "payTp"},
            {title: "결제금액", field: "realPayAmt"},
            {title: "구매자명", field: "ordrNm"},
            {title: "수령인", field: "recipient"},
        ];

        // "example-table" 요소에 새로운 Tabulator 테이블을 생성한다.
        const table = new Tabulator(gridId, {
            data: tableData, // 테이블에 데이터를 연결한다.
            columns: columns,
            layout: "fitColumns", // 테이블의 너비에 열을 맞춘다.
            responsiveLayout: "hide", // 테이블에 맞지 않는 열을 숨긴다.
            tooltips: true, // 셀에 툴팁을 표시한다.
            addRowPos: "top", // 새로운 행을 추가할 때 테이블의 위쪽에 추가한다.
            history: true, // 실행 취소 및 다시 실행 작업을 허용한다.
            pagination: "local", // 데이터를 페이지네이션한다.
            paginationSize: 7, // 페이지 당 7행의 데이터를 허용한다.
            movableColumns: true, // 열 순서를 변경할 수 있게 한다.
            resizableRows: true, // 행 크기를 조절할 수 있게 한다.
            initialSort: [ // 데이터의 초기 정렬 순서를 설정한다.
                {column: "name", dir: "asc"},
            ],
        });
    }
}