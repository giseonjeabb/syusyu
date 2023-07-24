<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="<c:url value="${jsUrlFos}/popup/couponPopup.js"/>"></script>
<script>
    couponPopup.initLoad();
    couponPopup.bindButtonEvent();
</script>
<div class="popup-layer w-510">
    <div class="popup-head">
        <h4>쿠폰 선택</h4>
        <button type="button" class="btn icon remove_19 close"><span class="text">닫기</span></button>
    </div>
    <div class="popup-content">
        <div class="inner">
            <div class="coupon-select-wrap" id="couponList">
                <div class="coupon-select-cont">
                    <div class="head">
                        <h5 class="title-t ty6">상품 쿠폰</h5>
                    </div>
                    <div class="inner">
                        <div class="in-cont product">
                            <input type="hidden" id="popupUseCpnIssNo" value="">
                            <input type="hidden" id="popupCouponDcAmt" value="">
<%--                            <input type="hidden" name="prodNo" value="523">--%>
<%--                            <input type="hidden" name="finalOrderPrice" value="4280">--%>
<%--                            <input type="hidden" name="walletIdx" value="">--%>
<%--                            <input type="hidden" name="walletOverLapIdx" value="">--%>
<%--                            <input type="hidden" name="discEventPrice" value="0">--%>
<%--                            <input type="hidden" name="productDlvrType" value="1">--%>
<%--                            <input type="hidden" name="productkeyValues" value="1>16">--%>
<%--                            <input type="hidden" name="brandIdx" value="">--%>

                            <select name="productCoupon" class="selectbox ty1 w-full" style="color: rgb(51, 51, 51);">
                                <option value="">쿠폰을 선택하세요</option>
                                <option data-idx="489820" data-title="진비빔면 15%할인" data-benefitunit="1" data-benefitvalue="0.15" data-benefitmax="5000" data-uselimitprice="0" value=""> 진비빔면 15%할인 </option>
                            </select>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="popup-btn-area">
        <button type="button" class="btn popup-btn ty4 c-ty1" id="btn_apply_coupon_dc">
            <span>-0원 할인 적용</span></button>
    </div>
</div>