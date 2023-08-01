namespace("orderCancel");
orderCancel = {
    initLoad: () => {
    },

    bindButtonEvent: () => {
        const $chkBtnContainer = document.querySelector('.order-history-list'); // 체크박스
        $chkBtnContainer.addEventListener('click', orderCancel.eventHandler.chkBtnClick);
    },
}

namespace("orderCancel.eventHandler");
orderCancel.eventHandler = {
    // 체크박스 클릭 이벤트 핸들러
    chkBtnClick(e) {
        // 클릭한 요소가 체크박스가 아니면 리턴
        if (e.target.name !== 'chk')
            return;

        const chkAll = document.querySelector('#chk-all');
        // 클릭한 체크박스가 '전체 선택'일 경우
        if (e.target.id === 'chk-all')
            // 모든 체크박스를 체크/체크 해제
            syusyu.common.Utils.checkAll('input[name="chk"]', e.target.checked);

        // 체크박스의 총 개수와 체크된 체크박스의 개수를 가져옴
        const checkedBoxes = syusyu.common.Utils.getCheckedBoxes('.chk-point');
        // 모든 체크박스가 체크되어 있다면 '전체 선택' 체크박스도 체크, 그렇지 않다면 '전체 선택' 체크박스 체크 해제
        chkAll.checked = checkedBoxes.totalCount === checkedBoxes.checkedCount;
    },
}

namespace("orderCancel.function");
orderCancel.function = {
}