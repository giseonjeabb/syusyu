// syusyu.common.Popup namespace를 정의
namespace("syusyu.common.Popup");

syusyu.common.Popup = {
    openPopup: (_url, _param, _callback) => {
        syusyu.common.Ajax.sendPOPRequest('GET', _url, '', res => {
            const $popupWrap = document.querySelector('.popup-wrap');
            $(".popup-wrap").html(res);
            $popupWrap.classList.toggle('active');
        });
    },

    close: () => {
        document.querySelector('.popup-wrap').classList.toggle('active');
    }
}