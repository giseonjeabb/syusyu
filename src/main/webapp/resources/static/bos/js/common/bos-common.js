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
}