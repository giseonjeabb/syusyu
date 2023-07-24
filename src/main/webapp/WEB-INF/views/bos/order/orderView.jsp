<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
        <script src="<c:url value="${jsUrlBos}/order/orderView.js"/>"></script>
        <script>
            document.addEventListener("DOMContentLoaded", () => {
                orderView.initLoad();
                orderView.bindButtonEvent();
            });
        </script>
</head>
<div class="container-fluid px-4">
    <h1 class="mt-4">주문통합검색</h1>

    <div class="search_form">
        <table>
            <tr>
                <th>기간</th>
                <td colspan="3" style="position:relative;">
                    <select name="date_type" style="width:115px;" class="fSelect disabled">
                        <option value="order_date" selected="selected">주문일</option>
                        <option value="memo_date">메모작성일</option>
                        <option value="pay_date">결제일</option>
                        <option value="shipready_date">송장번호입력일</option>
                        <option value="shipbegin_date">배송시작일</option>
                        <option value="shipend_date">배송완료일</option>
                        <option value="purchaseconfirmation_date">구매확정일</option>
                    </select>
                    <a href="#none" class="btnDate   " date-interval="0"><span>오늘</span></a>
                    <a href="#none" class="btnDate   " date-interval="1"><span>어제</span></a>
                    <a href="#none" class="btnDate   " date-interval="3"><span>3일</span></a>
                    <a href="#none" class="btnDate  selected " date-interval="7"><span>7일</span></a>
                    <a href="#none" class="btnDate   " date-interval="15"><span>15일</span></a>
                    <a href="#none" class="btnDate   " date-interval="30"><span>1개월</span></a>
                    <a href="#none" class="btnDate   " date-interval="90"><span>3개월</span></a>
                    <a href="#none" class="btnDate   " date-interval="180"><span>6개월</span></a>
                </td>
            </tr>
            <tr>
                <th>검색어</th>
                <td>
                    <select class="fSelect" name="MSK[]" style="width:163px;">
                        <option value="choice">-검색항목선택-</option>
                        <option value="order_id" selected="">주문번호</option>
                        <option value="ord_item_code">품목별 주문번호</option>
                        <option value="delivery_code">배송번호</option>
                        <option value="invoice_no">운송장번호</option>
                        <option value="s_order_info">마켓주문번호</option>
                        <option value="line1">-----------------</option>
                        <option value="o_name">주문자명</option>
                        <option value="member_id">주문자 아이디</option>
                        <option value="member_email">회원 이메일</option>
                        <option value="o_email">주문서 이메일</option>
                        <option value="o_phone2">주문자 휴대전화</option>
                        <option value="o_phone1">주문자 일반전화</option>
                    </select>
                    <input type="text" class="fText sBaseSearchBox eSearchText" name="MSV[]" id="sBaseSearchBox" style="width:400px;" value="">
                </td>
            </tr>
        </table>
    </div>
    <div class="button_area">
        <button>검색</button>
        <button>초기화</button>
    </div>

    <div id="example-table"></div>
</div>