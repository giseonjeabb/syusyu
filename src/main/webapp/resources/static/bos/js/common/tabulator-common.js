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
            layout: "fitColumns",
            responsiveLayout: "hide",
            tooltips: true,
            addRowPos: "top",
            history: true,
            pagination: "local",
            paginationSize: 15,
            movableColumns: true,
            resizableRows: true,
            initialSort: [{column: "name", dir: "asc"},],
            selectable: _selectable, // 이 옵션을 통해 행을 선택할 수 있게 설정
        });

        // TODO selectable true면 아래 checkbox 요소의 부모 div에 text-align: center 먹여주기
        // div.tabulator-header > div.tabulator-headers > div:nth-child(1) > div.tabulator-col-content > div > div > input[type=checkbox]

        return table;
    }
}
