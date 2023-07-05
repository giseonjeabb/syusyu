
//<![CDATA[
$(function() {
    const $pageList = $("#prd-list-wrap");
    bta.prodSearchPager.bind({
        urlProduct: "https://www.ottogimall.co.kr/front/product/product_list.ajax",
        onload: function(result) {
            $pageList.children().remove().end()
                .append(result);

            let listCnt = 0;
            if ($(".prd-lists").attr("total-size") != undefined) {
                listCnt = $(".prd-lists").attr("total-size");
            }
            $(".prd-counter strong").text(listCnt);

        }
    }).init();

    $("select[name='ptype'], select[name='pageSize']", ".content-top").on('change', function() {
        if ($(this).attr("name") == "ptype") {
            $("#qx_ptype").val($(this).val());
        }
        bta.prodSearchPager.setChange();
    });

    $(".r-side .tab a", ".content-top").on("click", function(){
        if($(this).hasClass("active")) return false;

        $("#qx_sort").val($(this).attr("name"));
        $(".r-side .tab a").removeClass("active");
        $(this).addClass("active");
        bta.prodSearchPager.setChange();
    });

    $(document).on('click', '#prd-list-wrap .pagination a', function() {
        var page = $(this).attr('page');
        if ($("#prd-list-wrap .prd-lists").attr('page-no') == page) {
            return false;
        }
        bta.prodSearchPager.setPage(page);
        $('html, body').scrollTop('0');
        return false;
    });

    $(document).on('click', '#listBtn', function() {
        if ($("#qx_listBtn").val() == 0) {
            $("#qx_listBtn").val(1);
        } else {
            $("#qx_listBtn").val(0);
        }
    });

});
//]]>
