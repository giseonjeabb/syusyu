<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<head>

    <script src="<c:url value="${jsUrlFos}/cs/mypage/orderView.js"/>"></script>
    <script>
        document.addEventListener("DOMContentLoaded", () => {
            orderView.initLoad();
            orderView.bindButtonEvent();
        });
    </script>
</head>
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
        <div class="order-history-list">
            <div class="history-info">
                <div class="detail">
                    <span class="order-num">2023071831126554</span>
                    <span class="date">2023.07.18</span>
                </div>
                <div class="a-btn-area">
                    <a href="order_detail?order=39120&amp;params=ZH4U0DtZAK0J7k4i5OCPJxgYP2v78c19Qvscl6aP7kZ1b241K8u" class="btn">
                        <span>상세보기</span>
                    </a>
                </div>
            </div>
            <div class="order-item">
                <div class="thumb">
                    <img src="https://ottogi-mall-s3.s3.ap-northeast-2.amazonaws.com/data/product/thumb/20221125/10310019_1.jpg" alt="">
                </div>
                <div class="order-info">
                    <div class="badge-cont">
                        <span class="badge-item ty11 fw-7">취소완료</span>
                    </div>
                    <ul>
                        <li>
                            <span class="tit fw-7">상품명</span>
                            <span>옥수수컵스프(컵) 27G 외 1건</span>
                        </li>
                        <li>
                            <span class="tit fw-7">결제방법</span>
                            <span>신용카드</span>
                        </li>
                        <li>
                            <span class="tit fw-7">결제금액</span>
                            <span>7,720원</span>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="order-history-list">
            <div class="history-info">
                <div class="detail">
                    <span class="order-num">2023071676297633</span>
                    <span class="date">2023.07.16</span>

                </div>
                <div class="a-btn-area">
                    <a href="order_detail?order=38920&amp;params=ZH4U0DtZAK0J7k4i5OCPJxgYP2v78c19Qvscl6aP7kZ1b241K8u"
                       class="btn"><span>상세보기</span></a>
                </div>
            </div>
            <div class="order-item">
                <input type="hidden" name="ordProd" value="165621" claims="0" pno="2262">
                <div class="thumb"><img
                        src="https://ottogi-mall-s3.s3.ap-northeast-2.amazonaws.com/data/product/thumb/20230519/1684476638181HaIZJ.1ib5z908ryvxy.jpg"
                        alt=""></div>
                <div class="order-info">
                    <div class="badge-cont">
                        <span class="badge-item ty11 fw-7">취소완료</span>
                    </div>
                    <ul>
                        <li>
                            <span class="tit fw-7">상품명</span>
                            <span>마일드참치 100g </span>
                        </li>
                        <li>
                            <span class="tit fw-7">결제방법</span>
                            <span>신용카드</span>
                        </li>
                        <li>
                            <span class="tit fw-7">결제금액</span>
                            <span>4,280원</span>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="order-history-list">
            <div class="history-info">
                <div class="detail">
                    <span class="order-num">2023062738186636</span>
                    <span class="date">2023.06.27</span>

                </div>
                <div class="a-btn-area">
                    <a href="order_detail?order=35814&amp;params=ZH4U0DtZAK0J7k4i5OCPJxgYP2v78c19Qvscl6aP7kZ1b241K8u"
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