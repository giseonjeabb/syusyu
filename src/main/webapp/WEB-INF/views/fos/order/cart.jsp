<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page session="false" %>
<head>
    <script src="<c:url value="${jsUrlFos}/order/cart.js"/>"></script>
</head>
<div class="breadcrumb">
    <div class="breadcrumb-inner">
        <a href="https://www.ottogimall.co.kr/front">홈</a>
        <a href="javascript:" onclick="location.reload();">장바구니</a>
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
                        <input type="checkbox" class="chk-all" checked="">
                        <span class="text fw-7">전체선택</span>
                    </label>
                </div>
                <div class="select-btn">
                        <span>
                            <button type="button" class="btn btn-text-type btt1" id="btn_remove_selected">선택삭제</button>
                        </span>
                </div>
            </div>
            <input type="hidden" id="totFinalNormalProdPrice" value="90640.00">
            <input type="hidden" id="totFinalColdProdPrice" value="0">

            <div class="chk-wrap cart-item-list divNormal">
                <input type="hidden" id="normalDlvrFee" value="3000.00">
                <input type="hidden" id="normalDlvrPolicyLimit" value="30000.00">
                <ul class="prd-brd-list">

                </ul>
                <div class="order-more-item ty1">
                    <div class="total" id="totFinalNormalProdPriceSpan">주문금액 90,640원</div>
                    <a href="javascript:" id="totFinalNormalProdPriceA"
                       class="btn btn-text-type btt1 underline mt-10" style="display: none" data-key="1"
                       data-diffprice="-60640.00" onclick="plusProduct(this);">실온 상품 더 담고 무료배송 받기</a>
                </div>
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
                        <span><strong id="totOrderPriceSpan">90,640</strong>원 </span>
                    </li>
                    <li>
                        <span>총 할인금액</span>
                        <span class="color-1"><strong id="totDiscEventPriceSpan">-0</strong>원</span>
                    </li>
                    <li>
                        <span>총 배송비</span>
                        <span><strong id="totFinalDlvrFeeSpan">0</strong>원</span>
                    </li>
                </ul>
            </div>
            <div class="in-cont">
                <div class="total">
                    <strong class="tit">결제예상금액</strong>
                    <strong class="r-side">
                        <span class="amount" id="paidPriceSpan">90,640</span><span class="word">원</span>
                    </strong>
                </div>
                <ul class="list ty2 mt-40">
                    <li>30,000원 이상 구매 시 무료배송입니다.</li>
                </ul>
            </div>
        </div>
        <button type="button" id="btn_order" class="btn ty5 c-ty1 w-full"><span
                id="finalAmount">90,640원 주문하기</span></button>
    </div>
    <div class="popup-wrap" id="plusProductPop">
        <div class="popup-layer w-910">
            <div class="popup-head">
                <h4>&nbsp;</h4>
                <button type="button" class="btn icon remove_19 close"><span class="text">닫기</span></button>
            </div>
            <div class="popup-content etc-ty1">
                <div class="inner">
                    <div class="recommend-content">
                        <div class="recommend-cont plusItemList">
                            <div class="recommend-cont-title">
                                <h4 class="title-t ty5">더 담고 무료배송</h4>
                            </div>
                            <div class="sw-cont recommend-type">
                                <div class="swiper-wrapper" id="plusItemList">
                                </div>
                                <div class="swiper-nav-btn swiper-button-prev"></div>
                                <div class="swiper-nav-btn swiper-button-next"></div>
                            </div>
                        </div>
                        <div class="recommend-cont plusItemList2">
                            <div class="recommend-cont-title">
                                <h4 class="title-t ty5">지금 함께 구매해 보세요</h4>
                            </div>
                            <div class="sw-cont recommend-type">
                                <div class="swiper-wrapper" id="plusItemList2">
                                </div>
                                <div class="swiper-nav-btn swiper-button-prev"></div>
                                <div class="swiper-nav-btn swiper-button-next"></div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- 토스트팝업 -->
    <div class="popup-toast" id="popToast">
        <div class="popup-toast-content" id="popToastContent">
            상품이 장바구니에 담겼습니다.
        </div>
    </div>
    <!-- 토스트팝업 -->
    <div class="popup-wrap" id="estimate" active-popup="true">
        <div class="popup-layer w-910">
            <div class="popup-head">
                <h4>견적서</h4>
                <button type="button" class="btn icon remove_19 close"><span class="text">닫기</span></button>
            </div>
            <div class="popup-fix-cont">
                <div class="r-side">
                    <button type="button" class="btn ty1 c-ty6 free w-120" onclick="connectPrint();"><span>인쇄</span>
                    </button>

                    <button type="button" class="btn ty1 c-ty6 free w-120 ml-5" onclick="connectEmail();">
                        <span>메일로 보내기</span>
                    </button>

                </div>
            </div>
            <div class="popup-content">
                <div class="inner" id="printArea">
                    <input type="hidden" id="prodName">
                    <div class="tbl ty4">
                        <table>
                            <colgroup>
                                <col style="width:276px">
                                <col style="width:42px">
                                <col style="width:80px">
                                <col style="width:175px">
                                <col style="width:80px">
                                <col style="width:178px">
                            </colgroup>
                            <tbody>
                            <tr>
                                <td rowspan="5" class="est">
                                    <strong class="name">방채민 님 귀하</strong>
                                    <ul class="list ty3">
                                        <li>견적일자 : 2023년 6월 29일</li>
                                        <li id="paidPriceTxt"></li>
                                    </ul>
                                </td>
                                <th rowspan="5" class="fw-7">공<br><br>급<br><br>자</th>
                                <th>상호</th>
                                <td colspan="3">오뚜기</td>
                            </tr>
                            <tr>
                                <th>사업자</th>
                                <td>138-81-03238</td>
                                <th>대표자</th>
                                <td>황성만</td>
                            </tr>
                            <tr>
                                <th>주소</th>
                                <td colspan="3">경기 안양시 동안구 흥안대로 405&nbsp; (평촌동)</td>
                            </tr>
                            <tr>
                                <th>업태</th>
                                <td>정보통신업</td>
                                <th>종목</th>
                                <td>식품</td>
                            </tr>
                            <tr>
                                <th>전화</th>
                                <td colspan="3">080-433-8888</td>
                            </tr>
                            <tr>
                                <td colspan="6" class="ta-c">아래와 같이 견적합니다.</td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                    <div class="tbl ty4">
                        <table>
                            <colgroup>
                                <col style="width:92px">
                                <col style="width:auto">
                                <col style="width:133px">
                                <col style="width:90px">
                                <col style="width:133px">
                                <col style="width:133px">
                            </colgroup>
                            <thead>
                            <tr>
                                <th class="fw-7">합계금액<br>(공급가액<br>+부가세)</th>
                                <th colspan="5" class="fw-7" id="supplySum"></th>
                            </tr>
                            <tr>
                                <th>번호</th>
                                <th>품명</th>
                                <th>제조사</th>
                                <th>수량</th>
                                <th>단가</th>
                                <th>공급가액</th>
                            </tr>
                            </thead>
                            <tbody id="tbl">

                            </tbody>
                            <tfoot>
                            <tr>
                                <td></td>
                                <td></td>
                                <td></td>
                                <th>합계</th>
                                <td colspan="2" class="ta-r fz-13" id="orderPriceEstimate"></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td></td>
                                <td></td>
                                <th>부가세</th>
                                <td colspan="2" class="ta-r fz-13" id="vatPriceEstimate"></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td></td>
                                <td></td>
                                <th>배송비</th>
                                <td colspan="2" class="ta-r fz-13" id="dlvrEstimate"></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td></td>
                                <td></td>
                                <th>계</th>
                                <td colspan="2" class="ta-r fz-13" id="finalPriceEstimate"></td>
                            </tr>
                            <tr>
                                <th>비고</th>
                                <td colspan="5"></td>
                            </tr>
                            </tfoot>
                        </table>
                    </div>
                    <div class="tbl ty4 mt-24">
                        <table>
                            <colgroup>
                                <col style="width:92px">
                                <col style="width:auto">
                            </colgroup>
                            <tbody>
                            <tr>
                                <th class="fw-7">입금계좌</th>
                                <td class="fz-13">

                                </td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
