$(function () {
    $.ajax({
        url: '/categories',
        type: 'GET',
        dataType: 'json',
        success: function (data) {
            console.log(data);
        },
        error: function (request, status, error) {
            console.error("AJAX GET request failed. " + error);
        }
    });

});