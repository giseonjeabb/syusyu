namespace("orderCancel");
orderCancel = {
    initLoad: () => {
    },

    bindButtonEvent: () => {
        const $chkBtnContainer = document.querySelector('.order-history-list'); // 체크박스
        const $cancelOrderBtn = document.querySelector('#btn_cancel_order'); // 주문취소 버튼
        const $request_detail_reason = document.querySelector('#request_detail_reason'); // 클레임 상세사유 count

        $chkBtnContainer.addEventListener('click', orderCancel.eventHandler.chkBtnClick);
        $cancelOrderBtn.addEventListener('click', orderCancel.eventHandler.cancelOrderBtnClick);
        $request_detail_reason.addEventListener('input', e => syusyu.common.Utils.textCount('#count_request_detail_reason', e.target.value));
    },
}

namespace("orderCancel.eventHandler");
orderCancel.eventHandler = {
    // 주문취소 버튼 클릭 이벤트 핸들러
    cancelOrderBtnClick() {
        const ordNo = document.querySelector('#ordNo').value; // 주문번호
        const ordDtlNoList = orderCancel.function.getCheckedItem('ordDtlNo'); // 주문취소할 주문상세번호 리스트
        const reqRsn = document.querySelector('#request_reason').selectedOptions[0].value; // 사유
        const reqDtlRsn = document.querySelector('#request_detail_reason').value; // 상세사유


        const param = {
            ordClaimDTO: {
                ordNo
              , reqRsn
              , reqDtlRsn
            }
            , ordDtlNoList
        };

        // 2. 주문취소 api 호출
        syusyu.common.Ajax.sendJSONRequest('POST', '/fos/orders/cancel', param, () => {
            alert("주문취소되었습니다.");
            // 3. 성공 시 주문조회로 이동
            location.href = '/fos/orderView';
        });
    },

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
    getCheckedItem: (target) => {
        let $checkedItems = document.querySelectorAll("input[name='chk']:checked");
        $checkedItems = Array.from($checkedItems).filter(item => !item.classList.contains('chk-all'));

        return $checkedItems.map((item) => item.closest('.order-item').querySelector('input[name="' + target + '"]').value);
    }
}