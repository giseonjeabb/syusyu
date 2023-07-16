namespace("orderSheet");
orderSheet = {
    initLoad: () => {
        orderSheet.function.getDlvAddrList(); // 배송지 리스트 가져오기
    },

    bindButtonEvent: () => { // 버튼에 이벤트 핸들러를 연결
        const $paymentBtn = document.querySelector('button[data-type="payment"]'); // 주문하기 버튼
        const $payChoiceContainer = document.querySelector(".pay-choice"); // 결제수단 버튼
        const $addrChangeBtn = document.querySelector('#btn_addr_change'); // 배송지 변경 버튼

        $paymentBtn.addEventListener('click', requestPay);
        $payChoiceContainer.addEventListener('click', handlePaymentBtnClick);
        $addrChangeBtn.addEventListener('click', orderSheet.eventHandler.openDlvAddrPopup);
    },
};

namespace("orderSheet.eventHandler"); // 이벤트 핸들러(특정 이벤트 발생 시 이벤트를 처리) 모음
orderSheet.eventHandler = {
    openDlvAddrPopup: () => {
        syusyu.common.Popup.openPopup('/dlvAddrPopup');
    },
};

namespace("orderSheet.function");
orderSheet.function = {
    getDlvAddrList: () => {

    }
};

// 결제수단 버튼의 클릭 이벤트를 처리하는 함수
const handlePaymentBtnClick = function () {
    // 현재 클릭된 버튼에 'active' 클래스를 추가한다.
    this.classList.add("active");

    // 다른 버튼들은 'active' 클래스를 제거한다.
    const $buttons = document.querySelectorAll(".pay-choice-btn"); // 결제수단 버튼
    $buttons.forEach(btn => {
        if (btn !== this) {
            btn.classList.remove("active");
        }
    });
}

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
    const ordName = document.getElementById('ord_name').value;
    const ordMobile = document.getElementById('ord_mobile').value;
    const ordEmail = document.getElementById('ord_email').value;

    const dfltAddr = document.getElementById("dfltAddr").value;
    const zipcode = document.getElementById("zipcode").value;

    IMP.request_pay({
        pg: 'html5_inicis.INIpayTest',
        pay_method: 'card',
        // pay_method : 'naverpay',
        merchant_uid: "IMP" + makeMerchantUid, // 생성한 고유 주문번호
        name: '당근 10kg',
        amount: 100,
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
    const pntUseAmt = document.getElementById("pnt_use_amt").value;

    // 최종 데이터 객체 생성
    const orderData = {
        orderProductList: orderProductList,
        payTp: "20", // TODO 수정필요 : 결제수단(카드, 포인트+카드, 포인트)
        cpnIssNo: 2, // TODO 수정필요 : 쿠폰
        pntUseAmt: pntUseAmt, // TODO 수정필요 : 포인트 사용 금액
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
        url: "/order",
        method: "POST",
        headers: {"Content-Type": "application/json"},
        // data: {
        //     imp_uid: rsp.imp_uid,            // 결제 고유번호
        //     merchant_uid: rsp.merchant_uid   // 주문번호
        // }
        data: JSON.stringify(orderData)
    }).done(function (data) {
        debugger;
        // 가맹점 서버 결제 API 성공시 로직
    })
}