namespace("orderDetail");
orderDetail = {
    initLoad: () => {
        // 전화번호 포매팅
        const $mpNo = document.getElementById('mpNo');
        $mpNo.innerHTML = formatPhoneNumber($mpNo.innerHTML);
    },

    bindButtonEvent: () => {
    },
}

namespace("orderDetail.eventHandler");
orderDetail.eventHandler = {
}

namespace("orderDetail.function");
orderDetail.function = {
}