document.addEventListener("DOMContentLoaded", () => {
    const paymentBtns = document.querySelectorAll('button[data-type="payment"]'); // 주문하기 버튼
    paymentBtns.forEach(paymentBtn => {
        paymentBtn.addEventListener('click', requestPay);
    });


});

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

    IMP.request_pay({
            pg: 'html5_inicis.INIpayTest',
            pay_method: 'card',
            // pay_method : 'naverpay',
            merchant_uid: "IMP" + makeMerchantUid, // 생성한 고유 주문번호
            name: '당근 10kg',
            amount: 100,
            buyer_email: 'Iamport@chai.finance',
            buyer_name: '아임포트 기술지원팀',
            buyer_tel: '010-1234-5678', // 필수 파라미터
            buyer_addr: '서울특별시 강남구 삼성동',
            buyer_postcode: '123-456'
        },
        // PC환경에서 일어나는 대부분의(iframe) 결제는 두 번째인자인 callback 함수를 통해 결제 결과 수신이 가능하다.
        function (rsp) {
            debugger;
            if (rsp.success) {
                // 결제 성공 시: 결제 승인 또는 가상계좌 발급에 성공한 경우
                // jQuery로 HTTP 요청
                $.ajax({
                    url: "{서버의 결제 정보를 받는 가맹점 endpoint}",
                    method: "POST",
                    headers: {"Content-Type": "application/json"},
                    data: {
                        imp_uid: rsp.imp_uid,            // 결제 고유번호
                        merchant_uid: rsp.merchant_uid   // 주문번호
                    }
                }).done(function (data) {
                    debugger;
                    // 가맹점 서버 결제 API 성공시 로직
                })
            } else {
                alert("결제에 실패하였습니다. 에러 내용: " + rsp.error_msg);
            }
        });
}