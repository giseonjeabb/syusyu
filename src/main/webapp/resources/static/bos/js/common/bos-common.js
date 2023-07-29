// syusyu.common.Bos namespace를 정의
namespace("syusyu.common.Bos");

syusyu.common.Bos = {
    /**
     * 주어진 주문 상태에 따른 주문 건수를 HTML 요소에 업데이트한다.
     *
     * @param {String} id 주문 건수를 표시할 HTML 요소의 ID
     * @param {string[]} statusList 주문 상태 코드 리스트
     * @param {Array} countByOrdStusList 주문 상태별 주문 건수가 담긴 객체배열
     * @author min
     * @since 2023/07/27
     */
    updateOrderCount(id, statusList, countByOrdStusList) {
        const matchingStatuses = countByOrdStusList.filter(countByOrdStus => statusList.includes(countByOrdStus.ORD_STUS));
        document.querySelector(id).innerHTML = matchingStatuses.reduce((sum, current) => sum + current.ORD_STUS_CNT, 0);
    },

    /**
     * 주어진 주문 데이터에 따라 주문 상태를 검증하고, 주문 상태 변경이 가능한지를 판단한다.
     *
     * @param {Array} checkedData 검증 대상이 되는 주문 데이터
     * @param {string[]} ordStusList 주문 상태 변경이 가능한 주문 상태 코드 리스트
     * @returns {Boolean} 주문 상태 변경이 가능한 경우 true, 그렇지 않은 경우 false를 반환
     * @author min
     * @since 2023/07/29
     */
    validateOrderStatus(checkedData, ordStusList) {
        // 1. 검증 대상 주문 데이터(checkedData) 중에서 ordStus가 주문 상태 변경 가능 코드에 포함되지 않는 데이터를 찾는다.
        const notOrdStusPayCompleted = checkedData.filter(data => !ordStusList.includes(data.ordStus));

        // 2. 주문 상태 변경 불가능한 주문이 없다면 true를 반환한다.
        if (notOrdStusPayCompleted.length === 0)
            return true;

        // 3. 주문 상태 변경 불가능한 주문이 있다면 해당 주문들의 ordDtlNo를 alert 창으로 띄워준다.
        const alertOrdDtlNo = notOrdStusPayCompleted.map(data => data.ordDtlNo).join(', ');
        alert("처리가 불가능한 주문 건이 존재합니다.(주문번호: " + alertOrdDtlNo + ")");

        return false;
    },
}