<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script src="<c:url value="${jsUrlFos}/cs/mypage/orderDetail.js"/>"></script>
<script>
    document.addEventListener("DOMContentLoaded", () => {
        orderDetail.initLoad();
        orderDetail.bindButtonEvent();
    });
</script>
<section class="mt-60"><!-- 주문 상품 내역 -->
    <form name="FrmOrder" id="frm_order" method="post" action="order.act">
        <input type="hidden" name="mnu" value="delivery">
        <input type="hidden" name="cmd">
        <input type="hidden" name="idx" value="39796">
        <input type="hidden" name="redirect" value="#">
        <input type="hidden" name="params" value="sdts=2023-06-21&amp;sdte=2023-07-21&amp;page=0">
        <div class="sub-content-head etc-ty2 mb-30">
            <div class="inner">
                <h3 class="title-t ty3">주문상세</h3>
            </div>
        </div><!--//sub-content-head-->
        <div class="tbl ty3">
            <div class="history-info">
                <div class="detail">
                    <span class="order-num">${orderDetailList[0].ordNo}</span>
                    <span class="date"><fmt:formatDate value="${orderDetailList[0].ordDttm}" pattern="yyyy-MM-dd"/></span>
                </div>
                <div class="a-btn-area">
                    <a href="javascript:;" class="btn ty1 c-ty5" onclick="deleteOrder();"><span>주문내역삭제</span></a>
                </div>
            </div><!--//history-info-->
            <div class="order-history-list detail">
                <c:forEach var="orderDetail" items="${orderDetailList}">
                    <div class="order-item">
                        <input type="hidden" name="ordProd" value="168805" claims="0" pno="2254">
                        <div class="thumb">
                            <img src="${orderDetail.repImg}" alt="">
                        </div>
                        <div class="order-info">
                            <div class="badge-cont">
                                <c:choose>
                                    <c:when test="${orderDetail.ordStus == 10}">
                                        <span class="badge-item ty13 fw-7">결제완료</span>
                                    </c:when>
                                    <c:when test="${orderDetail.ordStus == 20}">
                                        <span class="badge-item ty12 fw-7">상품준비중</span>
                                    </c:when>
                                    <c:when test="${orderDetail.ordStus == 30 || orderDetail.ordStus == 40 || orderDetail.ordStus == 50}">
                                        <span class="badge-item ty13 fw-7">배송중</span>
                                    </c:when>
                                    <c:when test="${orderDetail.ordStus == 60}">
                                        <span class="badge-item ty13 fw-7">배송완료</span>
                                    </c:when>
                                    <c:when test="${orderDetail.ordStus == 70}">
                                        <span class="badge-item ty11 fw-7">주문취소</span>
                                    </c:when>
                                    <c:when test="${orderDetail.ordStus == 80}">
                                        <span class="badge-item ty11 fw-7">반품</span>
                                    </c:when>
                                    <c:when test="${orderDetail.ordStus == 90}">
                                        <span class="badge-item ty11 fw-7">교환</span>
                                    </c:when>
                                    <c:otherwise>
                                        <span class="badge-item unknown fw-7">알 수 없는 상태</span>
                                    </c:otherwise>
                                </c:choose>

                            </div>
                            <p class="name">${orderDetail.prodNm}</p>
                            <div class="option">${orderDetail.optNm}</div>
                            <div class="price-area">
                                <span class="amount"><fmt:formatNumber value="${orderDetail.prodAmt}" type="number" pattern="#,###"/></span><span class="won">원</span>
                                <span>${orderDetail.qty}개</span>
                            </div>
                        </div>
                        <div class="btn-area" data-name="state-btns">
                            <!-- 주문상태가 10(결제완료)일 경우에만 주문취소 가능 -->
                            <c:if test="${orderDetail.ordStus == '10'}">
                                <a href="/fos/orders/${orderDetail.ordNo}/cancel-view" class="btn ty1 c-ty6 w-90" cmd="claim" claim="100" paids="1"><span>주문취소</span></a>
                            </c:if>
                        </div>
                    </div>
                </c:forEach>
            </div><!--//order-history-list -->
        </div><!--//tbl-->
    </form>

    <ul class="list ty6 mt-30">
        <li>주문취소는 입금대기/결제완료 상태의 상품만 가능합니다.</li>
        <li>교환/반품신청은 배송완료일로부터 7일 이내에 신청하실 수 있으며, 배송완료 후 8일이 경과한 경우 1:1문의 또는 고객센터로 문의해 주시기 바랍니다.</li>
    </ul>
</section>
<!-- // 주문 상품 내역 -->

<!-- 배송지 정보 -->
<section>
    <div class="sub-content-head etc-ty2">
        <div class="inner">
            <h4 class="title-t ty5">배송지 정보</h4>
        </div>
    </div>
    <div class="tbl ty3 mt-18 pb-20 line-gray1">
        <table>
            <colgroup>
                <col style="width:210px;">
                <col style="width:auto">
            </colgroup>
            <tbody>
            <tr>
                <th>받는 분</th>
                <td>${ordDlvAddr.recipient}</td>
            </tr>
            <tr>
                <th>주소</th>
                <td>${ordDlvAddr.dfltAddr}${ordDlvAddr.dtlAddr}
                </td>
            </tr>
            <tr>
                <th>연락처</th>
                <td id="mpNo">${ordDlvAddr.mpNo}</td>
            </tr>
            <tr>
                <th>배송 요청사항</th>
                <td>${ordDlvAddr.dlvReqComt}</td>
            </tr>
            </tbody>
        </table>
    </div><!--//tbl-->
</section>
<!-- //배송지 정보 -->


<!-- 결제금액 -->
<section>
    <div class="sub-content-head etc-ty2">
        <div class="inner">
            <h4 class="title-t ty5">결제금액</h4>
        </div>
    </div>
    <div class="tbl ty3 mt-18 mp-payment-amount-tbl">
        <div class="box">
            <strong>주문금액</strong>
            <p><span><fmt:formatNumber value="${payInfo.ordAmt + payInfo.dlvFee}" type="number" pattern="#,###"/></span>원</p>
            <ul>
                <li class="flex space-between color-3">
                    <span>총 상품금액</span>
                    <span><fmt:formatNumber value="${payInfo.ordAmt}" type="number" pattern="#,###"/>원</span>
                </li>
                <li class="flex space-between color-3">
                    <span>총 배송비</span>
                    <span><fmt:formatNumber value="${payInfo.dlvFee}" type="number" pattern="#,###"/>원</span>
                </li>
            </ul>
        </div>
        <div class="box">
            <strong>쿠폰할인</strong>
            <p><span><fmt:formatNumber value="${payInfo.cpnDcAmt * -1}" type="number" pattern="#,###"/></span>원</p>
        </div>
        <div class="box">
            <strong>마일리지 사용</strong>
            <p><span><fmt:formatNumber value="${payInfo.pntUseAmt * -1}" type="number" pattern="#,###"/></span>원 </p>
        </div>
        <div class="box">
            <strong>총 결제금액</strong>
            <p class="color-1"><span><fmt:formatNumber value="${payInfo.realPayAmt}" type="number" pattern="#,###"/></span>원 </p>

        </div>
    </div>
</section>
<!-- // 결제금액 -->

<!-- 결제정보 -->
<section>
    <div class="sub-content-head etc-ty2">
        <div class="inner">
            <h4 class="title-t ty5">결제정보</h4>

        </div>
    </div>
    <div class="tbl ty3 mt-18 pb-20 line-gray1">
        <table>
            <colgroup>
                <col style="width:210px;">
                <col style="width:auto">
            </colgroup>
            <tbody>


            <tr>
                <th>결제금액</th>
                <td><span class="fw-7"><fmt:formatNumber value="${payInfo.realPayAmt}" type="number" pattern="#,###"/></span>원</td>
            </tr>
            <tr>
                <th>결제방법</th>
                <td>${payInfo.payTpNm}</td>
            </tr>
            <tr>
                <th>결제일시</th>
                <td><fmt:formatDate value="${payInfo.aprvDttm}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
            </tr>
            </tbody>
        </table>
    </div>
    <ul class="list ty6 mt-20">
        <li>총 결제금액은 주문취소, 반품/환불, 할인금액 재계산 등이 모두 반영된 금액이므로 최초 결제정보와 다를 수 있습니다.</li>
        <li>구매 마일리지는 구매확정 후 적립됩니다.</li>
    </ul>
</section>
<!-- // 결제정보 -->
<div class="btn-area mt-40">
    <a href="#" class="btn ty4 c-ty2"><span>1:1 문의</span></a>
</div>