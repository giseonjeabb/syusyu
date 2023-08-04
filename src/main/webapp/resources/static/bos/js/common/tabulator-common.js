namespace("syusyu.common.Tabulator");

syusyu.common.Tabulator = {
    /**
     * Tabulator 테이블에 사용되는 함수로, 셀의 값에 천 단위마다 콤마를 추가한다.
     *
     * @param cell Tabulator 테이블의 셀을 나타내는 객체. 해당 셀의 값을 가져오기 위해 사용된다.
     * @return 콤마가 추가된 셀의 값
     * @author min
     * @since 2023/07/24
     */
    formatNumberForTabulator: (cell) => {
        return cell.getValue().toLocaleString();
    },

    /**
     * Tabulator 테이블을 생성한다.
     *
     * @param _gridId 테이블을 표시할 HTML 요소의 id
     * @param _tableData 테이블에 표시할 데이터
     * @param _columns 테이블의 컬럼 정보를 정의한 객체 배열
     * @param _selectable 체크박스 여부
     * @author min
     * @since 2023/07/24
     */
    createTabulatorTable: (_gridId, _tableData, _columns, _selectable = false) => {
        let table = new Tabulator(_gridId, {
            theme: "bootstrap",
            data: _tableData,
            columns: _columns,
            layout: "fitData",
            // responsiveLayout: "hide",
            tooltips: true,
            addRowPos: "top",
            history: true,
            pagination: "local",
            paginationSize: 10,
            movableColumns: true,
            resizableRows: true,
            initialSort: [{column: "name", dir: "asc"},],
            selectable: _selectable, // 이 옵션을 통해 행을 선택할 수 있게 설정
        });

        // 행의 총 개수를 표시해준다.
        document.querySelector('#resultCnt').innerHTML = table.getData().length;

        // TODO selectable true면 아래 checkbox 요소의 부모 div에 text-align: center 먹여주기
        // div.tabulator-header > div.tabulator-headers > div:nth-child(1) > div.tabulator-col-content > div > div > input[type=checkbox]

        return table;
    },

    /**
     * 주문상세 셀 클릭 시 주문상세팝업을 연다.
     *
     * @param {Event} e - 윈도우 이벤트 객체
     * @param {CellComponent} cell - Tabulator의 CellComponent
     * @author min
     * @since 2023/08/04
     */
    openOrderDetailPopup(e, cell) {
        const ordDtlNo = cell.getValue();
        window.open(`/bos/orders/${ordDtlNo}`, '_blank', 'height=600,width=840');
    },

    /**
     * 셀의 글씨를 파란색으로 설정한다.
     *
     * @param {CellComponent} cell - Tabulator의 CellComponent
     * @param {Object} formatterParams - Formatter 파라미터
     * @returns {any} 셀에 표시될 값
     * @author min
     * @since 2023/08/04
     */
    blueCellFormatter(cell, formatterParams) {
        cell.getElement().style.color = '#748eea';
        return cell.getValue();
    },
}
