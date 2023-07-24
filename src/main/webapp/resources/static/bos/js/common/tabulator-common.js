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
}
