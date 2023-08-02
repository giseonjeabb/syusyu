
/**
 * syusyu.common.Utils namespace
 * 공통적으로 사용하는 유틸리티 함수를 정의
 *
 * @namespace syusyu.common.Utils
 * @since 2023/08/01
 */
namespace("syusyu.common.Utils");

syusyu.common.Utils = {
    /**
     * 체크박스의 총 개수(totalCount)와 체크된 체크박스의 개수(checkedCount)를 반환한다.
     *
     * @param {string} selector - 체크박스의 선택자
     * @returns {Object} 체크된 체크박스의 정보 객체
     * @author min
     * @since 2023/08/01
     */
    getCheckedBoxes(selector) {
        const checkbox = [...document.querySelectorAll(selector)];
        return {
            totalCount: checkbox.length, // 전체 체크박스의 개수
            checkedCount: checkbox.filter(input => input.checked).length // 체크된 체크박스의 개수
        };
    },

    /**
     * 체크박스를 일괄적으로 체크하거나 체크 해제해준다.
     *
     * @param {string} selector - 체크 상태를 변경할 체크박스의 선택자
     * @param {Boolean} checked - 체크박스에 설정할 체크 상태
     * @author min
     * @since 2023/08/019
     */
    checkAll(selector, checked) {
        const checkbox = document.querySelectorAll(selector);
        for (const check of checkbox) {
            check.checked = checked;
        }
    },

    /**
     * 텍스트의 길이를 해당 선택자에 표시해준다.
     *
     * @param {string} selector - 텍스트 카운트를 표시할 요소의 선택자
     * @param {string} value - 길이를 체크할 텍스트 영역의 내용
     * @author min
     * @since 2023/08/01
     */
    textCount(selector, value) {
        document.querySelector(selector).innerHTML = value.length;
    }
}