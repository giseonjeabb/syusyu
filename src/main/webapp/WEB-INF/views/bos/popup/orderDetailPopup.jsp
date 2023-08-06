<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script src="<c:url value="${jsUrlBos}/popup/orderDetailPopup.js"/>"></script>
<script>
    document.addEventListener("DOMContentLoaded", () => {
        orderDetailPopup.initLoad();
        orderDetailPopup.bindButtonEvent();
    });
</script>

<div class="popup-head">
    <h3>주문 상세정보 조회</h3>
    <button type="button" class="btn icon remove_19 close">
        <span class="text">닫기</span>
    </button>
</div>
<div class="data_view_table_container" style="width: 800px;">
    <h5>주문 상세정보</h5>
    <p>주문상세번호: ${ordDtl.ordDtlNo}</p>
    <div class="data_view_table">
        <table>
            <colgroup>
                <col width="20%">
                <col width="30%">
                <col width="20%">
                <col width="30%">
            </colgroup>
            <tr>
                <th>상품명</th>
                <td colspan="3">${ordDtl.prodNm}</td>
            </tr>
            <tr>
                <th>주문상태</th>
                <td>${ordDtl.ordStusNm}</td>
                <th>클레임</th>
                <td>${ordDtl.claimStusNm}</td>
            </tr>
            <tr>
                <th>구매자명</th>
                <td>${ordDtl.ordrNm}</td>
                <th>구매자 ID</th>
                <td>${ordDtl.lginId}</td>
            </tr>
            <tr>
                <th>옵션</th>
                <td>${ordDtl.optNm}</td>
                <th>주문수량</th>
                <td>${ordDtl.qty}</td>
            </tr>
            <tr>
                <th>총 상품금액</th>
                <td colspan="3"><fmt:formatNumber value="${ordDtl.prodAmt}" pattern="#,###"/></td>
            </tr>
        </table>
    </div>

    <h5>배송정보</h5>
    <div class="data_view_table">
        <table>
            <colgroup>
                <col width="20%">
                <col width="30%">
                <col width="20%">
                <col width="30%">
            </colgroup>
            <tr>
                <th>발송처리일시</th>
                <td>${delivery.dispatchDttm}</td>
                <th>집화처리일시</th>
                <td>${delivery.pickupDttm}</td>
            </tr>
            <tr>
                <th>출하일시</th>
                <td colspan="3">${delivery.shmtDttm}</td>
            </tr>
            <tr>
                <th>택배사명</th>
                <td>${delivery.dlvComNm}</td>
                <th>송장번호</th>
                <td>${delivery.trckNo}</td>
            </tr>
        </table>
    </div>

    <h5>배송지 정보</h5>
    <div class="data_view_table">
        <table>
            <tr>
                <th>수령인</th>
                <td>${ordDlvAddr.recipient}</td>
            </tr>
            <tr>
                <th>연락처</th>
                <td id="mpNoTxt">${ordDlvAddr.mpNo}</td>
            </tr>
            <tr>
                <th>배송지</th>
                <td>${ordDlvAddr.dfltAddr}${ordDlvAddr.dtlAddr}</td>
            </tr>
            <tr>
                <th>배송메모</th>
                <td>${ordDlvAddr.dlvReqComt}</td>
            </tr>
        </table>
    </div>

    <h5>주문 처리 이력</h5>
    <div class="data_view_table">
        <table>
            <c:forEach var="ordStusHist" items="${ordStusHistList}">
                <tr>
                    <th>${ordStusHist.nowOrdStusNm}</th>
                    <td>처리일시 <fmt:formatDate value="${ordStusHist.regDttm}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>