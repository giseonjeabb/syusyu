namespace("couponPopup");
couponPopup = {
    initLoad: () => {
        // 주문 시 사용 가능한 쿠폰 리스트를 얻어와 화면에 뿌려준다.
        couponPopup.function.getOrderCouponList();
    },

    bindButtonEvent: () => { // 버튼에 이벤트 핸들러를 연결
        const $productCoupon = document.querySelector('select[name="productCoupon"]'); // 쿠폰 선택 select box
        const $applyCouponDcBtn = document.querySelector('#btn_apply_coupon_dc'); // 쿠폰할인적용 버튼

        $productCoupon.addEventListener('change', couponPopup.eventHandler.selectOptionChange); // 적용할 쿠폰을 변경할 경우 발생되는 이벤트
        $applyCouponDcBtn.addEventListener('click', couponPopup.eventHandler.applyCouponDc);

    },
}

namespace("couponPopup.eventHandler"); // 이벤트 핸들러(특정 이벤트 발생 시 이벤트를 처리) 모음
couponPopup.eventHandler = {
    // 적용할 쿠폰을 변경할 경우 발생되는 이벤트
    selectOptionChange: function () {
        // 1. select box에서 선택된 option을 가져온다.
        const selectedOption = document.querySelector('select[name="productCoupon"] > option:checked'); // name을 기준으로, selectbox에서 현재 선택된 옵션의 텍스트(text) 조회

        // 2. 할인금액을 계산한다.
        const optionDataset = selectedOption.dataset;
        const totProdAmt = document.getElementById('totProdAmt').value; // 총 상품금액
        const couponDcAmt = couponPopup.function.calcCouponDcAmt(totProdAmt, optionDataset.bneftp, optionDataset.cpnbnef); // 쿠폰할인금액

        // 3. 화면에 보여준다.
        document.querySelector('#btn_apply_coupon_dc > span').innerHTML = `-${formatPrice(couponDcAmt)}원 할인 적용`;

        // 4. 사용한 쿠폰 세팅
        document.querySelector('#popupUseCpnIssNo').value = optionDataset.cpnissno; // 1. 쿠폰발행번호
        document.querySelector('#popupCouponDcAmt').value = couponDcAmt;            // 2. 쿠폰할인금액
    },

    // 쿠폰 할인을 적용한다.
    applyCouponDc: function () {
        // 1. 쿠폰발행번호와 쿠폰할인금액을 부모창에게 보내준다.
        // 1-1. 주문 시 사용할 input hidden에 값 넣어주기
        const cpnIssNo = document.querySelector('#popupUseCpnIssNo').value;
        const couponDcAmt = document.querySelector('#popupCouponDcAmt').value;

        document.querySelector('#useCpnIssNo').value = cpnIssNo;    // 쿠폰발행번호
        document.querySelector('#couponDcAmt').value = couponDcAmt; // 쿠폰할인금액

        // 1-2. 단순 보여주기용 txt couponDcAmtTxt
        document.querySelector('#couponDcAmtTxt').value = formatPrice(couponDcAmt);

        orderSheet.function.setFinalAmt();

        // 2. 팝업창을 닫는다.
        syusyu.common.Popup.close();

        // TODO 오른쪽 금액 계산 어케함..? 여기서 그 함수를 호출해야 하나? 그게 편할수도
    }
}

namespace("couponPopup.function");
couponPopup.function = {
    getOrderCouponList: function () {
        const param = {
            totProdAmt: document.getElementById('totProdAmt').value
        };

        syusyu.common.Ajax.sendJSONRequest("GET", "/fos/orders/available-coupons", param, function (res) {
            const $productCoupon = document.querySelector('select[name="productCoupon"]'); // input select

            // 응답으로 온 사용 가능한 쿠폰 리스트를 option으로 생성해서 넣어준다.
            // 1. 기존 select option을 초기화한다.
            let result = `<option value="">쿠폰을 선택하세요</option>`;

            // 2. res 반복문 돌려서
            res.forEach(coupon => {
                const bnefTp = coupon.bnefTp == '01' ? '원' : '%';

                result += `<option data-cpnIssNo="${coupon.cpnIssNo}" data-bnefTp="${coupon.bnefTp}" data-cpnBnef="${coupon.cpnBnef}" data-maxDcAmt="${coupon.maxDcAmt}" value="">${coupon.cpnNm}(${coupon.cpnBnef}${bnefTp} 할인)</option>`;
            });

            $productCoupon.innerHTML = result;
        });
    },

    calcCouponDcAmt: function (price, bnefTp, cpnBnef) {
        let discount = 0;

        if (bnefTp === '01') { // 원단위 할인
            discount = cpnBnef;

        } else if (bnefTp === '02') { // '%' 단위 할인
            discount = price * (cpnBnef / 100);
        }

        return discount;
    }
}
