<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="<c:url value="${jsUrlBos}/common/dashboard.js"/>"></script>
<script>
    document.addEventListener("DOMContentLoaded", () => {
        dashboard.initLoad();
        dashboard.bindButtonEvent();
    });
</script>

<%--chart javascript--%>
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<div class="container-fluid px-4">
<%--    <h1 class="mt-4">Dashboard</h1>--%>
<%--    <ol class="breadcrumb mb-4">--%>
<%--        <li class="breadcrumb-item active">Dashboard</li>--%>
<%--    </ol>--%>
    <div class="panel_area">
        <div class="list-wrap">
            <div class="panel-icon-area">
                <span class="square-ico-area">
                    <i class="icon icon-order-complete"></i>
                </span>
            </div>
            <ul class="panel-list">
                <li>
                    <span class="info-title">신규주문</span>
                    <span class="number-area"> <a id="newOrderCnt" href="<c:url value="/bos/dispatchManageView"/>">0</a> <span>건</span> </span>
                </li>
            </ul>
        </div>
        <div class="list-wrap">
            <div class="panel-icon-area">
                <span class="square-ico-area">
                    <i class="icon icon-delivery"></i>
                </span>
            </div>
            <ul class="panel-list">
                <li>
                    <span class="info-title">배송준비</span>
                    <span class="number-area"> <a id="orderConfirmCnt" href="<c:url value="/bos/dispatchManageView"/>">0</a> <span>건</span> </span>
                </li>
                <li>
                    <span class="info-title">배송중</span>
                    <span class="number-area"> <a id="inDeliveryCnt" href="/bos/deliveryManageView">0</a> <span>건</span> </span>
                </li>
                <li>
                    <span class="info-title">배송완료</span>
                    <span class="number-area"> <a id="deliveryComplete" href="/bos/deliveryManageView">0</a> <span>건</span> </span>
                </li>
            </ul>
        </div>
        <div class="list-wrap">
            <div class="panel-icon-area">
                <span class="square-ico-area">
                    <i class="icon icon-claim"></i>
                </span>
            </div>
            <ul class="panel-list">
                <li>
                    <span class="info-title">취소요청</span>
                    <span class="number-area"> <a>0</a> <span>건</span> </span>
                </li>
                <li>
                    <span class="info-title">반품요청</span>
                    <span class="number-area"> <a>0</a> <span>건</span> </span>
                </li>
                <li>
                    <span class="info-title">교환요청</span>
                    <span class="number-area"> <a>0</a> <span>건</span> </span>
                </li>
            </ul>
        </div>
        <div class="list-wrap">
            <div class="panel-icon-area">
                <span class="square-ico-area">
                    <i class="icon icon-settlement"></i>
                </span>
            </div>
            <ul class="panel-list">
                <li>
                    <span class="info-title">구매확정</span>
                    <span class="number-area"> <a>0</a> <span>건</span> </span>
                </li>
                <li>
                    <span class="info-title">오늘정산</span>
                    <span class="number-area"> <a>0</a> <span>건</span> </span>
                </li>
                <li>
                    <span class="info-title">정산예정</span>
                    <span class="number-area"> <a>0</a> <span>건</span> </span>

                </li>
            </ul>
        </div>
    </div>

    <div class="row">
        <div class="col-xl-6">
            <div class="card mb-4">
                <div class="card-header">
                    <i class="fas fa-chart-area me-1"></i>
                    일별매출현황
                </div>
                <div class="card-body">
                    <canvas id="myLineChart"></canvas>
                </div>
            </div>
        </div>
        <div class="col-xl-6">
            <div class="card mb-4">
                <div class="card-header">
                    <i class="fas fa-chart-bar me-1"></i>
                    상품별 결제금액
                </div>
                <div class="card-body">
                    <canvas id="myLineChart2"></canvas>
                </div>
            </div>
        </div>
    </div>
</div>