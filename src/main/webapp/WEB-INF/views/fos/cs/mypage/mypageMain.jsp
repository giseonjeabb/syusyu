<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<div class="sub-content-head etc-ty2">
    <div class="inner">
        <h3 class="title-t ty3">주문/배송조회</h3>
    </div>
</div>
<form name="sFrm" id="frm_search">
    <div class="period-srch-box ty2 flex-wrap mt-30">
        <div class="tab ty5">
            <a href="javascript:" interval="m1" class="active">1개월</a>
            <a href="javascript:" interval="m3">3개월</a>
            <a href="javascript:" interval="m6">6개월</a>
            <a href="javascript:" interval="m12">12개월</a>
        </div>
        <div class="calendar">
            <div class="input w-208">
                <input type="text" name="sdts" id="sdts" value="2023-05-28" readonly="readonly"
                       class="inp datepicker hasDatepicker">
            </div>
            <span class="m">~</span>
            <div class="input w-208">
                <input type="text" name="sdte" id="sdte" value="2023-06-28" readonly="readonly"
                       class="inp datepicker hasDatepicker">
            </div>
            <button type="submit" class="btn ty2 c-ty5 free"><span>조회</span></button>
        </div>
    </div>
</form>

<!-- 주문 내역 -->
<div id="ux_page_list">
    <div class="orderlistbox myorderlist" page-no="1" total-size="1" total-page="1">
        <div class="order-history-list">
            <div class="history-info">
                <div class="detail">
                    <span class="order-num">2023062738186636</span>
                    <span class="date">2023.06.27</span>
                </div>
                <div class="a-btn-area">
                    <a href="order_detail?order=35814&amp;params=ZH4U0DtZAK0J7k4iqTmCHgPERJWL6ZAZHfJ6vKnnOx777Ezgqgq"
                       class="btn"><span>상세보기</span></a>
                </div>
            </div>
            <div class="order-item">
                <input type="hidden" name="ordProd" value="152584" claims="0" pno="2310">
                <div class="thumb"><img
                        src="https://ottogi-mall-s3.s3.ap-northeast-2.amazonaws.com/data/product/thumb/20230609/1686294393817fo76d.1iuys0qya3jg8.jpg"
                        alt=""></div>
                <div class="order-info">
                    <div class="badge-cont">
                        <span class="badge-item ty11 fw-7">취소완료</span>
                    </div>
                    <ul>
                        <li>
                            <span class="tit fw-7">상품명</span>
                            <span>[위글위글 콜라보] 사과쨈 500G </span>
                        </li>
                        <li>
                            <span class="tit fw-7">결제방법</span>
                            <span>신용카드</span>
                        </li>
                        <li>
                            <span class="tit fw-7">결제금액</span>
                            <span>8,980원</span>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </div><!-- //orderlistbox -->
</div>