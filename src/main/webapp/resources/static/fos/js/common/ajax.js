namespace("syusyu.common.Ajax");

syusyu.common.Ajax = {
    sendJSONRequest: function (_method, _url, _data, _callback, _async) {
        _async = _async === true || _async === false ? _async : true;

        $.ajax({
            type: _method,
            url: _url,
            contentType: 'application/json; charset=utf-8',
            data: _method == "POST" ? JSON.stringify(_data) : _data,
            async : _async,
            dataType : "json",
            success : function(response) {
                _callback(response);
            },
            error : function(jqXHR, error, errorThrown) {
                // that.error(jqXHR, error, errorThrown);
                alert("에러");
            }
        });
    },
}