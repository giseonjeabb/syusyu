namespace("orderDetailPopup");
orderDetailPopup = {
    initLoad: () => {
        formatPhoneNumberForElement('mpNoTxt');
    },

    bindButtonEvent: () => {
        const $closeBtn = document.querySelector('.popup-head .close');
        $closeBtn.addEventListener('click', () => window.close());
    },
}

namespace("orderDetailPopup.eventHandler");
orderDetailPopup.eventHandler = {
}

namespace("orderDetailPopup.function");
orderDetailPopup.function = {
}