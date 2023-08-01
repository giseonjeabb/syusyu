<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script src="<c:url value="${jsUrlFos}/cs/mypage/orderView.js"/>"></script>
<script>
    document.addEventListener("DOMContentLoaded", () => {
        orderView.initLoad();
        orderView.bindButtonEvent();
    });
</script>
<div class="sub-content-head etc-ty2">
    <div class="inner">
        <h3 class="title-t ty3">주문/배송조회</h3>
    </div>
</div>
<!--//sub-content-head-->

<form name="sFrm" id="frm_search">
    <div class="period-srch-box ty2 flex-wrap mt-30">
        <div class="date_range_container tab ty5">
            <a id="btn_m1" data-interval="1" class="date_range active">1개월</a>
            <a id="btn_m3" data-interval="3" class="date_range">3개월</a>
            <a id="btn_m6" data-interval="6" class="date_range">6개월</a>
            <a id="btn_m12" data-interval="12" class="date_range">12개월</a>
        </div>
        <div class="calendar">
            <div class="input w-208">
                <input type="text" name="start_date" id="start_date" readonly="readonly" class="inp datepicker hasDatepicker">
            </div>
            <span class="m">~</span>
            <div class="input w-208">
                <input type="text" name="end_date" id="end_date" readonly="readonly" class="inp datepicker hasDatepicker">
            </div>
            <button type="button" id="btn_search" class="btn ty2 c-ty5 free"><span>조회</span></button>
        </div>
    </div>
</form>

<!-- 주문 내역 -->
<div id="ux_page_list">
    <div class="orderlistbox myorderlist" page-no="1" total-size="5" total-page="1">
    </div><!-- //orderlistbox -->
</div>