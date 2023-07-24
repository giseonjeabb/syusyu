// syusyu.common.Popup namespace를 정의
namespace("syusyu.common.Popup");

syusyu.common.Popup = {
    COMMON_LAYER_DEFAULT: '.popup-default',
    COMMON_LAYER_ALERT: '.popup-alert',
    COMMON_LAYER_ALERT_CONTENT: '.popup-alert .popup-content',


    openPopup: (_url, _param, _callback) => {
        syusyu.common.Ajax.sendPOPRequest('GET', _url, '', res => {
            const $popupWrap = document.querySelector('.popup-default');
            $(".popup-default").html(res);

            const closeBtn = document.querySelector('.popup-default .close');
            closeBtn.addEventListener('click', syusyu.common.Popup.close);

            // const module = _url.replaceAll('/', '');
            //
            // window[module].initLoad();
            // window[module].bindButtonEvent();

            $popupWrap.classList.add('active');
        });
    },

    commonLayerSetting: (_msg) => {
        syusyu.common.Ajax.sendPOPRequest('GET', '/fos/alertPopup', '', res => {
            const $popupAlert = document.querySelector('.popup-alert');
            $(this.COMMON_LAYER_ALERT).html(res);
            $(this.COMMON_LAYER_ALERT_CONTENT).html(_msg);
            $popupAlert.classList.add('active');

            // 1. 팝업을 닫는 이벤트 핸들러를 연결한다.
            const closeBtn = document.querySelector('.popup-alert .close');
            closeBtn.addEventListener('click', syusyu.common.Popup.close);
        });
    },

    alert: (_msg) => {
        syusyu.common.Ajax.sendPOPRequest('GET', '/fos/alertPopup', '', res => {
            const $popupAlert = document.querySelector('.popup-alert');
            $(".popup-alert").html(res);
            document.querySelector('.popup-alert .popup-content').innerHTML = _msg;

            document.querySelector('[data-btn="alert"]').style.display = 'flex';

            // 1. 팝업을 닫는 이벤트 핸들러를 연결한다.
            const closeBtn = document.querySelector('.popup-alert .close');
            closeBtn.addEventListener('click', syusyu.common.Popup.close);


            $popupAlert.classList.add('active');
        });
    },

    confirm: (_msg) => {
        syusyu.common.Ajax.sendPOPRequest('GET', '/fos/alertPopup', '', res => {
            const $popupAlert = document.querySelector('.popup-alert');
            $(".popup-alert").html(res);
            document.querySelector('.popup-alert .popup-content').innerHTML = _msg;

            document.querySelector('[data-btn="confirm"]').style.display = 'flex';

            // 1. 팝업을 닫는 이벤트 핸들러를 연결한다.
            const closeBtn = document.querySelector('.popup-alert .close');
            closeBtn.addEventListener('click', syusyu.common.Popup.close);


            $popupAlert.classList.add('active');
        });
    },

    close: (e) => {
        if (e) {
            e.target.closest('.popup-wrap').classList.remove('active');
        } else {
            document.querySelector('.popup-wrap').classList.toggle('active');
        }
    },

}