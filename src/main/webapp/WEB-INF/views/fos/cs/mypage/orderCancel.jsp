<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script src="<c:url value="${jsUrlFos}/cs/mypage/orderCancel.js"/>"></script>
<script>
    document.addEventListener("DOMContentLoaded", () => {
        orderCancel.initLoad();
        orderCancel.bindButtonEvent();
    });
</script>
<form name="FrmClaim" id="frm_claim" method="post">
    <input type="hidden" name="idx" value="41562">
    <input type="hidden" name="type" value="100" text="취소">
    <input type="hidden" name="products">
    <input type="hidden" name="ordName" value="방채민">
    <input type="hidden" name="ordMobile" value="010-5517-3236">
    <input type="hidden" name="ordEmail" value="coals_0115@daum.net">
    <input type="hidden" id="ordNo" name="ordNo" value="${cancelOrderInfoList[0].ordNo}">

    <section class="mt-60">
        <div class="sub-content-head etc-ty2 mb-30">
            <div class="inner">
                <h3 class="title-t ty3">주문취소</h3>
            </div>
        </div>
        <ul class="list ty6">
<%--            <li>주문취소 시 약 3일~7일 이내에 결제금액이 환불처리 됩니다.</li>--%>
<%--            <li>할인쿠폰을 이용한 주문을 취소/반품하시는 경우 일부 쿠폰은 재발급 되지 않습니다.</li>--%>
<%--            <li>입금 대기중인 주문은 부분취소가 불가능하며, 전체 취소 후 재주문 하셔야 합니다.</li>--%>
<%--            <li>특정 상품에 하자 및 오류가 있는 경우 1:1문의 또는 고객센터로 문의주시기 바랍니다.</li>--%>
        </ul>
        <div class="tbl mt-40">
            <div class="order-history-list detail chk-wrap">
                <div class="order-type">
                    <div class="chkbox">
                        <label>
                            <input type="checkbox" id="chk-all" name="chk" class="chk-all">
                            <span class="text fw-7 sun fz-18">전체선택</span>
                        </label>
                    </div>
                </div>
                <c:forEach var="cancelOrderInfo" items="${cancelOrderInfoList}">
                    <c:if test="${cancelOrderInfo.ordStus == '10'}">
                        <div class="order-item ux-ord-prod">
                        <input type="hidden" name="ordDtlNo" value="${cancelOrderInfo.ordDtlNo}">
                            <div class="chk-area mr-10">
                                <div class="chkbox single">
                                    <label>
                                        <input type="checkbox" class="chk-point" name="chk">
                                        <span class="text">선택</span>
                                    </label>
                                </div>
                            </div>
                            <div class="thumb">
                                <img src="${cancelOrderInfo.repImg}" alt="">
                            </div>
                            <div class="order-info">
                                <input type="hidden" name="pidx" value="175579" disabled="disabled">
                                <p class="name">${cancelOrderInfo.prodNm}</p>
                                <div class="option">${cancelOrderInfo.optNm}</div>
                                <div class="price-area">
                                    <span class="amount"><fmt:formatNumber value="${cancelOrderInfo.prodAmt}" type="number" pattern="#,###"/></span><span class="won">원</span>
                                    <span>${cancelOrderInfo.qty}개</span>
                                    <input type="hidden" name="claimQty" id="claim_qty_1" value="1">
                                </div>
                            </div>
                        </div>
                    </c:if>
                </c:forEach>
            </div><!--// order-history-list 실온 -->
        </div>
    </section><!-- // 주문 취소 내역 -->

    <!-- 사유 -->
    <section id="reason_box" class="ordergroup">
        <div class="sub-content-head etc-ty2">
            <div class="inner">
                <h4 class="title-t ty5">취소 사유</h4>
            </div>
        </div>
        <div class="tbl ty2 mt-18">
            <table>
                <colgroup>
                    <col style="width:210px;">
                    <col style="width:auto">
                </colgroup>
                <tbody>
                <tr>
                    <th class="va-t pt-30">주문취소 사유</th>
                    <td>
                        <select id="request_reason" name="request_reason" class="selectbox ty1 w-full" style="color: rgb(51, 51, 51);">
                            <option value="" selected>사유를 선택해 주세요.</option>
                            <option value="10">단순 변심</option>
                            <option value="20">주문실수</option>
                            <option value="70">옵션변경</option>
                            <option value="80">기타</option>
                        </select>
                        <div class="textarea word-chker mt-10">
                            <textarea class="h-143" name="request_detail_reason" id="request_detail_reason" maxlength="50" placeholder="상세 사유를 입력해 주세요."></textarea>
                            <span class="count ty2"><em id="count_request_detail_reason">0</em>/50</span>
                        </div>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
    </section><!-- // 사유 -->

    <div class="btn-area mt-40">
        <a href="#" id="btn_cancel_order" class="btn ty4 c-ty1 bt-claim-calc"><span>취소 신청하기</span></a>
    </div>
</form>