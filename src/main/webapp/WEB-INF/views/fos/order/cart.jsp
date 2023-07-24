<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page session="false" %>
<head>
    <script src="<c:url value="${jsUrlFos}/order/cart.js?dddd"/>"></script>
    <script>
        document.addEventListener("DOMContentLoaded", () => {
            cart.initLoad();
            cart.bindButtonEvent();
        });
    </script>
</head>
<div class="breadcrumb">
    <div class="breadcrumb-inner">
        <a href="<c:url value="/"/>">홈</a>
        <a href="<c:url value="/fos/cart"/>" onclick="location.reload();">장바구니</a>
    </div>
</div>
<div class="content-title">
    <div class="inner-content">
        <h2 class="title-t ty2">장바구니</h2>
    </div>
</div>
<div class="inner-content move-container">
    <div class="content-mini left-case">
        <input type="hidden" id="optKind" value="1">
        <input type="hidden" id="basketKind" name="basketKind" value="1">
        <div class="chk-box-wrap cart-area mt-40">
            <div class="all-option-box">
                <div class="chkbox">
                    <label>
                        <input type="checkbox" name="chk" class="chk-all">
                        <span class="text fw-7">전체선택</span>
                    </label>
                </div>
                <div class="select-btn">
                        <span>
                            <button type="button" class="btn btn-text-type btt1" id="btn_remove_selected">선택삭제</button>
                        </span>
                </div>
            </div>
            <div class="list-none etc-ty1" style="display: none">
                <p class="msg-text icon-ty1">장바구니에 담긴 상품이 없습니다.</p>
                <div class="btn-area">
                    <a href="https://www.ottogimall.co.kr/front/product/best"
                       class="btn ty4 c-ty2"><span>상품 담으러 가기</span></a>
                </div>
            </div>
            <input type="hidden" id="totFinalNormalProdPrice" value="90640.00">
            <input type="hidden" id="totFinalColdProdPrice" value="0">

            <div class="chk-wrap cart-item-list divNormal">
                <input type="hidden" id="normalDlvrFee" value="3000.00">
                <input type="hidden" id="normalDlvrPolicyLimit" value="30000.00">
                <ul class="prd-brd-list">

                </ul>
            </div>
        </div>
    </div>
    <div class="move-container-right">
        <div class="inner">
            <h3 class="title-t ty4">상품금액</h3>
            <div class="in-cont">
                <ul class="list ty4">
                    <li>
                        <span>총 상품금액</span>
                        <span><strong id="cartTotPrc"></strong>원</span>
                    </li>
                    <li>
                        <span>총 할인금액</span>
                        <span class="color-1"><strong id="cartTotDcAmt"></strong>원</span>
                    </li>
                    <li>
                        <span>배송비</span>
                        <span><strong id="dlvFee"></strong>원</span>
                    </li>
                </ul>
            </div>
            <div class="in-cont">
                <div class="total">
                    <strong class="tit">결제예상금액</strong>
                    <strong class="r-side">
                        <span class="amount" id="cartPayAmt"></span><span class="word">원</span>
                    </strong>
                </div>
                <ul class="list ty2 mt-40">
                    <li>50,000원 이상 구매 시 무료배송입니다.</li>
                </ul>
            </div>
        </div>
        <button type="button" id="btn_order" class="btn ty5 c-ty1 w-full"><span id="finalAmt"></span></button>
    </div>
</div>
