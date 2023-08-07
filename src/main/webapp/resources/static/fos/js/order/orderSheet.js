namespace("orderSheet");
orderSheet = {
    initLoad: () => {
        orderSheet.function.setFinalAmt();

        // 전화번호 포매팅
        formatPhoneNumberForElement('memberMpNoTxt');
        formatPhoneNumberForElement('mpNoTxt');
    },

    bindButtonEvent: () => { // 버튼에 이벤트 핸들러를 연결
        const $paymentBtn = document.querySelector('button[data-type="payment"]'); // 주문하기 버튼
        const $payChoiceContainer = document.querySelector(".pay-choice"); // 결제수단 버튼
        const $addrChangeBtn = document.querySelector('#btn_addr_change'); // 배송지 변경 버튼
        const $couponSelectBtn = document.querySelector('#bnt_coupon_select'); // 배송지 변경 버튼
        const $pntUseAmtTxt = document.querySelector('#pntUseAmt'); // 포인트 사용 금액 입력창
        const $dlvReqComt = document.querySelector('#dlvReqComt'); // 배송 요청사항 select box

        $paymentBtn.addEventListener('click', requestPay);
        $payChoiceContainer.addEventListener('click', orderSheet.eventHandler.handlePaymentBtnClick);
        $addrChangeBtn.addEventListener('click', orderSheet.eventHandler.openDlvAddrPopup);
        $couponSelectBtn.addEventListener('click', orderSheet.eventHandler.openCouponPopup);
        $pntUseAmtTxt.addEventListener('blur', orderSheet.eventHandler.pntUseChange);
        $dlvReqComt.addEventListener('change', orderSheet.eventHandler.dlvReqComtChange);

    },
};

namespace("orderSheet.eventHandler"); // 이벤트 핸들러(특정 이벤트 발생 시 이벤트를 처리) 모음
orderSheet.eventHandler = {
    dlvReqComtChange(e) {
        const that = e.target;
        that.style.color = 'rgb(51, 51, 51)';

        document.querySelector(".input.w-450").style.display = e.target.selectedOptions[0].value === '직접입력' ? 'block' : 'none';
    },

    openDlvAddrPopup() {
        syusyu.common.Popup.openPopup('/fos/dlvAddrPopup');
    },

    openCouponPopup() {
        syusyu.common.Popup.openPopup('/fos/couponPopup');
    },

    // 결제수단 버튼의 클릭 이벤트를 처리하는 함수
    handlePaymentBtnClick(e) {
        const that = e.target;

        // 현재 클릭된 버튼에 'active' 클래스를 추가한다.
        that.classList.add("active");

        // 다른 버튼들은 'active' 클래스를 제거한다.
        const $buttons = document.querySelectorAll(".pay-choice-btn"); // 결제수단 버튼
        $buttons.forEach(btn => {
            if (btn !== that) {
                btn.classList.remove("active");
            }
        });
    },

    pntUseChange: (e) => {
        // 1. TODO 사용 가능 금액을 초과하지 않았는지 검증한다.
        // validatePointLimit();

        // 2. pntUseAmt에 값 넣어준다.

        // 3. 최종 결제 금액을 다시 계산한다.
        orderSheet.function.setFinalAmt();
    }

};


namespace("orderSheet.function");
orderSheet.function = {
    setFinalAmt: function () {
        // 1. 계산에 필요한 금액들을 가져온다.
        // 1) 총 할인적용금액
        const totDcPrc = parseInt(document.querySelector('#totDcPrc').value);
        // 2) 총 배송비
        const dlvFee = parseInt(document.querySelector('#dlvFee').value);
        // 3) 쿠폰 할인
        const couponDcAmt = parseInt(document.querySelector('#couponDcAmt').value);
        // 4) 포인트 사용
        const pntUseAmt = parseInt(document.querySelector('#pntUseAmt').value);

        // 2. 쿠폰 할인, 포인트 사용 금액을 넣어준다.
        document.querySelector('#paidCouponPriceTxt > strong').innerHTML = `-${formatPrice(couponDcAmt)}`;
        document.querySelector('#issueSmoneyTxt > strong').innerHTML = `-${formatPrice(pntUseAmt)}`;

        // 2. 최종 결제금액을 계산한다. (총 할인적용금액 + 배송비 - 쿠폰 할인 - 포인트 사용)
        const finalPayAmt = totDcPrc + dlvFee - couponDcAmt - pntUseAmt;

        // 3. 화면에 금액을 보여준다.(단순 보여주기용)
        document.querySelector('#paidPriceTxt').innerHTML = `<strong>${formatPrice(finalPayAmt)}</strong>`;
        document.querySelector('#finalAmount').innerHTML = `${formatPrice(finalPayAmt)}원 주문하기`;

        // 3-1. 결제, 주문 시 사용할 input hidden에도 넣어주기
        document.querySelector('#finalPayAmt').value = finalPayAmt;
    }
};

function requestPay() {
    const IMP = window.IMP;
    // IMP.init("imp67011510"); // 아임포트거
    IMP.init("imp75058214"); // 내거

    const today = new Date();
    const hours = today.getHours(); // 시
    const minutes = today.getMinutes();  // 분
    const seconds = today.getSeconds();  // 초
    const milliseconds = today.getMilliseconds();
    const makeMerchantUid = hours + minutes + seconds + milliseconds;

    // 결제 API 호출 시 넘겨줘야 하는 정보들
    // 주문자 정보
    const ordName = document.getElementById('ord_name').value;
    const ordMobile = document.getElementById('ord_mobile').value;
    const ordEmail = document.getElementById('ord_email').value;

    const dfltAddr = document.getElementById("dfltAddr").value;
    const zipcode = document.getElementById("zipcode").value;

    // 결제금액
    const finalPayAmt = document.querySelector('#finalPayAmt').value;

    IMP.request_pay({
        pg: 'html5_inicis.INIpayTest',
        pay_method: 'card',
        // pay_method : 'naverpay',
        merchant_uid: "IMP" + makeMerchantUid, // 생성한 고유 주문번호
        amount: finalPayAmt,
        buyer_email: ordEmail,
        buyer_name: ordName,
        buyer_tel: ordMobile, // 필수 파라미터
        buyer_addr: dfltAddr,
        buyer_postcode: zipcode
        // PC환경에서 일어나는 대부분의(iframe) 결제는 두 번째인자인 callback 함수를 통해 결제 결과 수신이 가능하다.
    }, rsp => {
        if (rsp.success) {
            createOrder(rsp);
        } else {
            alert("결제에 실패하였습니다. 에러 내용: " + rsp.error_msg);
        }
    });
}

function createOrder(rsp) {
    // 주문 생성 API 호출 시 넘겨줘야 할 정보를 세팅하는 함수
    // 데이터 객체 생성
    let orderProductList = [];

    // 주문 상품 목록을 생성한다.
    const $prdBrdList = document.querySelector(".prd-brd-list"); // 범위 줄여서 요소 찾기
    const $prodIds = $prdBrdList.querySelectorAll("[name='prod_id']");
    const $prodNms = $prdBrdList.querySelectorAll("[name='prod_nm']");
    const $optCombNos = $prdBrdList.querySelectorAll("[name='opt_comb_no']");
    const $qtys = $prdBrdList.querySelectorAll("[name='qty']");

    for (let i = 0; i < $prodIds.length; i++) {
        let product = {};
        product["prodId"] = parseInt($prodIds[i].value, 10);
        product["prodNm"] = $prodNms[i].value;
        product["optCombNo"] = $optCombNos[i].value ? parseInt($optCombNos[i].value, 10) : null;
        product["qty"] = parseInt($qtys[i].value, 10);
        orderProductList.push(product);
    }

    // 주문자 정보 및 배송지 정보 생성
    const recipient = document.getElementById("recipient").value;
    const mpNo = document.getElementById("mpNo").value;
    const zipcode = document.getElementById("zipcode").value;
    const dfltAddr = document.getElementById("dfltAddr").value;
    const dtlAddr = document.getElementById("dtlAddr").value;

    // 결제/할인
    const useCpnIssNo = document.getElementById("useCpnIssNo").value; // 쿠폰
    const pntUseAmt = document.getElementById("pntUseAmt").value; // 포인트

    // 최종 데이터 객체 생성
    const orderData = {
        orderProductList: orderProductList,
        payTp: "20", // TODO 수정필요 : 결제수단(카드, 포인트+카드, 포인트)
        cpnIssNo: useCpnIssNo,
        pntUseAmt: pntUseAmt,
        recipient: recipient,
        mpNo: mpNo,
        // safetNoYn: "N",
        zipcode: zipcode,
        dfltAddr: dfltAddr,
        dtlAddr: dtlAddr,
        dlvReqComt: "문 앞에 놔주세요" // TODO 수정필요
    };

    // 결제 성공 시: 결제 승인 또는 가상계좌 발급에 성공한 경우
    // jQuery로 HTTP 요청
    $.ajax({
        url: "/fos/orders",
        method: "POST",
        headers: {"Content-Type": "application/json"},
        // data: {
        //     imp_uid: rsp.imp_uid,            // 결제 고유번호
        //     merchant_uid: rsp.merchant_uid   // 주문번호
        // }
        data: JSON.stringify(orderData)
    }).done(function (data) {
        if (data === 'ADD_OK') {
            location.href = '/fos/order/complete';
        } else {
            alert("결제 실패")
        }
        // 가맹점 서버 결제 API 성공시 로직


    })
}