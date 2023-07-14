// syusyu.common.Ajax namespace를 정의
namespace("syusyu.common.Ajax");

syusyu.common.Ajax = {
    /**
     * 서버에 JSON 형식의 HTTP 요청을 보낸다.
     *
     * @param _method HTTP 메서드 (GET, POST, PUT, DELETE 등)
     * @param _url 요청을 보낼 서버의 URL
     * @param _data 서버에 보낼 데이터. GET 요청이 아닌 경우 JSON.stringify로 JSON 형태의 문자열로 변환
     * @param _callback 서버로부터 응답을 받았을 때 호출할 콜백 함수. 이 함수는 서버의 응답을 인자로 받는다.
     * @param _async 비동기 요청 여부. 기본값은 true
     * @param _traditional 파라미터 직렬화 여부(prodIdArr=1&prodIdArr=2&prodIdArr=3과 같은 형태로). 기본값은 false
     * @author min
     * @since 2023/07/07
     */
    sendJSONRequest: (_method, _url, _data, _callback, _async, _traditional = false) => {
        _async = _async === true || _async === false ? _async : true;

        $.ajax({
            type: _method,
            url: _url,
            contentType: 'application/json; charset=utf-8',
            data: _method !== "GET" ? JSON.stringify(_data) : _data,
            async : _async,
            // dataType : "json",
            traditional: _traditional,
            success : function(response) {
                _callback(response);
            },
            error : function(jqXHR, error, errorThrown) {
                // that.error(jqXHR, error, errorThrown);
                alert("에러");
            }
        });
    },

    sendPOPRequest : (_method, _url, _data, _callback, _async) => {
        _async = _async === true || _async === false ? _async : true;

        $.ajax({
            type : _method,
            url : _url,
            contentType : "application/json",
            data : _method !== "GET" ? JSON.stringify(_data) : _data,
            async : _async,
            dataType : "text",
            success : function(response) {
                _callback(response);
            },
            error : function(jqXHR, error, errorThrown) {
                alert("에러")
            }
        });
    },
}