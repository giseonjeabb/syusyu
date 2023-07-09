<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page session="false" %>
<head>
    <script src="https://cdn.iamport.kr/v1/iamport.js"></script>
    <script src="<c:url value="${jsUrlFos}/order/orderSheet.js"/>"></script>
</head>
<form name="FrmOrder" id="frm_order" method="post">
    <main>
        <div class="breadcrumb">
            <div class="breadcrumb-inner">
                <a href="https://www.ottogimall.co.kr/front">홈</a>
                <a href="javascript:;" onclick="location.reload();">주문결제</a>
            </div>
        </div>
        <div class="content-title">
            <div class="inner-content">
                <h2 class="title-t ty2">주문결제</h2>
            </div>
        </div>
        <div class="inner-content move-container">
            <div class="content-mini left-case">
                <div class="sections ty1">
                    <!-- 주문상품 -->
                    <section>
                        <div class="slide-wrap slide-ty1">
                            <div class="slide-title">
                                <button type="button" class="slide-trg active">
                                    <strong>주문상품 <span class="color-5">${fn:length(cartProdList)}</span></strong>
                                </button>
                            </div>
                            <div class="slide-cont">
                                <div class="inner" style="display: block;">
                                    <ul class="prd-brd-list">
                                        <c:forEach var="cartProd" items="${cartProdList}">
                                            <li>
                                                <div class="item-area">
                                                    <div class="prd-item etc-ty1">
                                                        <div class="thumbs hover">
                                                            <a href="https://www.ottogimall.co.kr/front/product/525">
                                                                <img src="${cartProd.repImg}" alt="스파게티 (150GX4)">
                                                            </a>
                                                        </div>
                                                        <div class="desc">
                                                            <a href="https://www.ottogimall.co.kr/front/product/525">
                                                                <p class="name">${cartProd.prodNm}</p>
                                                                <div class="option">
                                                                    <p>
                                                                            ${cartProd.opt}
                                                                            <%-- 옵션가가 존재할 때만 보여준다. --%>
                                                                        <c:if test="${cartProd.totOptPrc > 0}">
                                                                            (+<fmt:formatNumber value="${cartProd.totOptPrc}" type="number" pattern="#,###"/>원)
                                                                        </c:if>
                                                                    </p>
                                                                </div>
                                                            </a>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="item-cnt">${cartProd.qty}개</div>
                                                <div class="price-arae">
                                                    <p class="amount"><fmt:formatNumber value="${cartProd.totDcAplPrc}" type="number" pattern="#,###"/><span class="won">원</span></p>
                                                    <c:if test="${cartProd.totDcAplPrc != cartProd.totPrc}">
                                                        <del><fmt:formatNumber value="${cartProd.totPrc}" type="number" pattern="#,###"/><span class="won">원</span></del>
                                                    </c:if>
                                                </div>
                                            </li>
                                        </c:forEach>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </section>
                    <!-- 주문상품 -->

                    <!-- 주문자 정보 -->
                    <input type="hidden" id="ord_name" name="ordName" value="${memberInfo.name}">
                    <input type="hidden" id="ord_mobile" name="ordMobile" value="${memberInfo.mpNo}">
                    <input type="hidden" id="ord_email" name="ordEmail" value="${memberInfo.email}">

                    <section>
                        <div class="sub-content-head etc-ty2">
                            <div class="inner">
                                <h3 class="title-t ty5">주문자 정보</h3>
                                <div class="r-side">
                                    <div class="fz-14 color-3">
                                        주문자 정보는 <a href="#" class="color-4">마이페이지 &gt; 회원정보 변경</a>에서 변경하실 수 있습니다.
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="tbl ty3 mt-18">
                            <table>
                                <colgroup>
                                    <col style="width:210px">
                                    <col style="width:auto">
                                </colgroup>
                                <tbody>
                                <tr>
                                    <th>보내는 분</th>
                                    <td>${memberInfo.name}</td>
                                </tr>
                                <tr>
                                    <th>휴대전화</th>
                                    <td>${memberInfo.mpNo}</td>
                                </tr>
                                <tr>
                                    <th>이메일</th>
                                    <td>${memberInfo.email}</td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                    </section>

                    <!-- 배송지 정보 -->

                    <input type="hidden" id="rcv_def_name" name="rcvName" value="${dlvAddr.recipient}">
                    <input type="hidden" id="rcv_def_mobile" name="rcvMobile" value="${dlvAddr.mpNo}">
                    <input type="hidden" id="rcv_def_post" name="rcvPost" value="${dlvAddr.zipcode}03328">
                    <input type="hidden" id="rcv_def_addr_base" name="rcvAddrBase" value="${dlvAddr.dfltAddr}">
                    <input type="hidden" id="rcv_def_addr_detail" name="rcvAddrDetail" value="${dlvAddr.dtlAddr}">

                    <section>
                        <div class="sub-content-head etc-ty2">
                            <div class="inner">
                                <h3 class="title-t ty5">배송지 정보</h3>
                                <div class="r-side">
                                    <button type="button" class="btn ty1 c-ty6" id="addrUpdateTxt" style="display: ">
                                        <span>배송지변경</span></button>
                                    <button type="button" class="btn ty1 c-ty6" id="addrInsertTxt"
                                            style="display: none"><span>배송지등록</span></button>
                                </div>
                            </div>
                        </div>

                        <div class="tbl ty3 mt-10">
                            <table>
                                <colgroup>
                                    <col style="width:210px">
                                    <col style="width:auto">
                                </colgroup>
                                <tbody>
                                <tr class="defInfoTxt" style="display: ">
                                    <th>받는 분</th>
                                    <td id="defNameTxt">${dlvAddr.recipient}<span class="color-1">(기본배송지)</span></td>
                                </tr>
                                <tr class="defInfoTxt" style="display: ">
                                    <th>배송지</th>
                                    <td id="defAddrBaseTxt">${dlvAddr.addr}</td>
                                </tr>
                                <tr class="defInfoTxt" style="display: ">
                                    <th>연락처</th>
                                    <td id="defPhoneTxt">${dlvAddr.mpNo}</td>
                                </tr>
                                <tr class="notDefnameTxt" style="display: none">
                                    <th>배송지</th>
                                    <td class="color-6">등록된 기본배송지가 없습니다. 배송지를 추가해 주세요.</td>
                                </tr>
                                <tr>
                                    <th class="top">배송 요청사항</th>
                                    <td>
                                        <div class="select-inp">
                                            <select name="rcvMemoClassifyIdx" id="rcv_def_memo_classify_idx" class="selectbox ty1 w-450">
                                                <option value="">배송 요청사항</option>

                                                <option value="60">부재시 경비실에 맡겨주세요.</option>

                                                <option value="63">부재시 전화주세요.</option>

                                                <option value="61">문앞에 놓아주세요.</option>

                                                <option value="62">택배보관실에 맡겨주세요.</option>

                                                <option value="직접입력" data-select-inp="true">직접입력</option>
                                            </select>
                                            <div class="input w-450">
                                                <input type="text" class="inp" id="def_memo_dlvr" name="defMemoDlvr"
                                                       placeholder="배송 요청사항을 30자 이내로 입력해 주세요." maxlength="30">
                                            </div>
                                        </div>
                                    </td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                    </section>

                    <!-- 할인정보 -->
                    <section>
                        <div class="sub-content-head etc-ty2">
                            <div class="inner">
                                <h3 class="title-t ty5">할인 정보</h3>
                            </div>
                        </div>

                        <div class="tbl ty2 mt-18">
                            <table>
                                <colgroup>
                                    <col style="width:210px">
                                    <col style="width:auto">
                                </colgroup>
                                <tbody>
                                <tr>
                                    <th class="top">쿠폰 사용</th>
                                    <td>
                                        <div class="flex al-center">
                                            <div class="input etc-ty1 w-450">
                                                <input type="text" id="paidCouponPriceValue" class="inp" value="0"
                                                       readonly="">
                                                <span class="side">원</span>
                                            </div>
                                            <button type="button" class="btn ty2 c-ty5 w-90 free ml-10" id="couponOpen">
                                                <span>쿠폰선택</span></button>
                                            <span class="ml-20 color-5">사용가능 쿠폰 <span class="color-1"
                                                                                      id="useCouponCount">0장</span></span>
                                        </div>
                                        <ul class="list ty2 mt-10">
                                            <li>쿠폰은 할인이 들어가지 않은 상품에 대해서만 적용됩니다.</li>
                                        </ul>
                                    </td>
                                </tr>
                                <tr>
                                    <th class="top">마일리지 사용</th>
                                    <td>
                                        <div class="flex al-center">
                                            <div class="input etc-ty1 w-450">
                                                <input type="hidden" name="hasSmoney" id="has_smoney" value="1000.00"
                                                       usablehas="1000.00" usablemin="1000.00" usablemax="0.00">
                                                <input type="text" name="issueSmoney" id="issue_smoney"
                                                       class="inp num-comma" value="0">
                                                <span class="side">원</span>
                                            </div>
                                            <button type="button" class="btn ty2 c-ty5 w-90 free ml-10 bt-smoney-whole">
                                                <span>최대사용</span></button>
                                            <span class="ml-20 color-5">보유 마일리지 <span
                                                    class="color-1">1,000원</span></span>
                                        </div>
                                        <ul class="list ty2 mt-10">
                                            <li>마일리지는 배송비를 제외한 결제 금액을 대체하여 사용하실 수 있습니다.</li>
                                        </ul>
                                    </td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                    </section>


                    <div class="popup-wrap" id="popL" active-popup="true">
                        <div class="popup-layer w-510">
                            <div class="popup-head">
                                <h4>배송지 목록</h4>
                                <button type="button" class="btn icon remove_19 close"><span class="text">닫기</span>
                                </button>
                            </div>
                            <div class="popup-fix-cont">
                                <div class="chkbox">
                                    <label>
                                        <input type="checkbox" id="rcv_list_default_be" style="display: ">
                                        <span class="text">기본 배송지로 설정</span>
                                    </label>
                                </div>
                                <div class="r-side">
                                    <a href="javascript:" class="btn ty1 c-ty2" id="addrAddTxt"><span>배송지 추가</span></a>
                                </div>
                            </div>
                            <div class="popup-content addr-ty">
                                <div class="inner">
                                    <ul class="addr-lists" id="addrList">

                                    </ul>
                                </div>
                            </div>
                            <div class="popup-btn-area">
                                <button type="button" class="btn popup-btn ty4 c-ty9" onclick="selectedAddrInfo();">
                                    <span>확인</span></button>
                            </div>
                        </div>
                    </div>

                    <div class="popup-wrap" id="popIU" active-popup="true">
                        <input type="hidden" id="rcv_idx" value="">
                        <div class="popup-layer w-570">
                            <div class="popup-head">
                                <h4 id="addrHeaderTxt">배송지 등록</h4>
                                <button type="button" class="btn icon remove_19 close"><span class="text">닫기</span>
                                </button>
                            </div>
                            <div class="popup-fix-cont">
                                <div class="chkbox">
                                    <label>
                                        <input type="checkbox" name="rcvDefaultBe" id="rcv_default_be" value="1">
                                        <span class="text">기본 배송지로 설정</span>
                                    </label>
                                </div>
                            </div>
                            <div class="popup-content">
                                <div class="inner">
                                    <div class="tbl ty3 etc-ty1">
                                        <table>
                                            <colgroup>
                                                <col style="width:130px">
                                                <col style="width:auto">
                                            </colgroup>
                                            <tbody>
                                            <tr>
                                                <th>받는 분</th>
                                                <td>
                                                    <div class="input w-full">
                                                        <input type="text" name="rcvName" id="rcv_name" class="inp"
                                                               maxlength="100" placeholder="받는분을 입력해주세요" value="">
                                                    </div>
                                                </td>
                                            </tr>
                                            <tr>
                                                <th>휴대폰 번호</th>
                                                <td>
                                                    <div class="flex-wrap etc-ty1">
                                                        <div>
                                                            <select name="rcvMobile1" id="rcv_mobile1"
                                                                    class="selectbox ty1">
                                                                <option value="010">010</option>
                                                                <option value="011">011</option>
                                                                <option value="016">016</option>
                                                                <option value="017">017</option>
                                                                <option value="018">018</option>
                                                                <option value="019">019</option>
                                                                <option value="02">02</option>
                                                                <option value="031">031</option>
                                                                <option value="032">032</option>
                                                                <option value="033">033</option>
                                                                <option value="041">041</option>
                                                                <option value="042">042</option>
                                                                <option value="043">043</option>
                                                                <option value="044">044</option>
                                                                <option value="051">051</option>
                                                                <option value="052">052</option>
                                                                <option value="053">053</option>
                                                                <option value="054">054</option>
                                                                <option value="055">055</option>
                                                                <option value="061">061</option>
                                                                <option value="062">062</option>
                                                                <option value="063">063</option>
                                                                <option value="064">064</option>
                                                                <option value="070">070</option>
                                                                <option value="080">080</option>
                                                                <option value="050">050</option>
                                                                <option value="0501">0501</option>
                                                                <option value="0502">0502</option>
                                                                <option value="0503">0503</option>
                                                                <option value="0504">0504</option>
                                                                <option value="0505">0505</option>
                                                                <option value="0507">0507</option>
                                                                <option value="0508">0508</option>
                                                                <option value="0509">0509</option>
                                                            </select>
                                                        </div>
                                                        <div class="input">
                                                            <input type="number" class="inp" name="rcvMobile2"
                                                                   id="rcv_mobile2" pattern="\d*" max="4" maxlength="4">
                                                        </div>
                                                        <div class="input">
                                                            <input type="number" class="inp" name="rcvMobile3"
                                                                   id="rcv_mobile3" pattern="\d*" max="4" maxlength="4">
                                                        </div>
                                                    </div>
                                                </td>
                                            </tr>
                                            <tr>
                                                <th class="top">주소검색</th>
                                                <td>
                                                    <div class="address-form">
                                                        <div class="top">
                                                            <div class="input">
                                                                <input type="text" class="inp" name="rcvPost"
                                                                       id="rcv_post" maxlength="5" placeholder="우편번호"
                                                                       readonly="readonly">
                                                            </div>
                                                            <button type="button"
                                                                    class="btn ty1 c-ty5 free w-90 zipcode-open"
                                                                    zip-embed="1" zip-width="450" zip-height="600"
                                                                    zip-post="#rcv_post" zip-addr-base="#rcv_addr_base"
                                                                    zip-addr-detail="#rcv_addr_detail"><span>주소검색</span>
                                                            </button>
                                                        </div>
                                                        <div class="input w-full">
                                                            <input type="text" name="rcvAddrBase" id="rcv_addr_base"
                                                                   class="inp" readonly="" value="" maxlength="100">
                                                        </div>
                                                        <div class="input w-full">
                                                            <input type="text" name="rcvAddrDetail" id="rcv_addr_detail"
                                                                   class="inp" value="" maxlength="100">
                                                        </div>
                                                    </div>
                                                </td>
                                            </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                            <div class="popup-btn-area">
                                <button type="button" class="btn popup-btn ty4 c-ty9" onclick="saveAddrInfo();">
                                    <span>확인</span></button>
                            </div>
                        </div>
                    </div>


                    <script>
                        var basketKind = 1;
                        var isMember = true;
                        var progressing = 0;

                        onload = function () {
                            if (nvl($("#issue_smoney").val(), '0') > '0') {
                                $("#issue_smoney").val(0);
                            }
                        }
                    </script>

                    <input type="hidden" id="totFinalNormalProdPrice" value="127480.00">
                    <input type="hidden" id="totFinalColdProdPrice" value="0">

                    <input type="hidden" id="couponExcludes" value="Y">
                    <input type="hidden" id="basketKind" name="basketKind" value="1">
                    <input type="hidden" id="tempPaidPrice" value="127480.00">
                    <input type="hidden" id="totFinalDlvrFee" value="0">
                    <input type="hidden" id="use_coupon_count" value="0">

                    <input type="hidden" id="baskets" name="baskets"
                           value="34xRBwn2a0nj9M5aRamdvRtuAhIyxT2OFmzfVAmy9A8=">
                    <input type="hidden" id="buyer_id" name="buyerId" value="2874133643">

                    <input type="hidden" name="totOrderPrice" value="127480.00">
                    <input type="hidden" id="totDlvrFee" name="totDlvrFee" value="0">
                    <input type="hidden" id="totCouponProdDiscPrice" name="totCouponProdDiscPrice" value="0">
                    <input type="hidden" id="totCouponOrderDiscPrice" name="totCouponOrderDiscPrice" value="0">
                    <input type="hidden" id="totCouponDlvrDiscPrice" name="totCouponDlvrDiscPrice" value="0">
                    <input type="hidden" id="paidPrice" name="paidPrice" value="126480">

                    <input type="hidden" id="paidCouponPrice" name="totCouponDiscPrice" value="0">

                    <input type="hidden" id="productCouponIdxs" name="productCouponIdxs" value="[]">
                    <input type="hidden" id="basketCouponIdx" name="basketCouponIdx" value="{}">
                    <input type="hidden" id="dlvrCouponIdx" name="dlvrCouponIdx" value="{}">

                    <input type="hidden" id="payway" name="payway" value="">
                    <input type="hidden" id="bill_reg_type" name="billRegType" value="">
                    <input type="hidden" id="bill_reg_no" name="billRegNo" value="">

                    <input type="hidden" id="dlvrIsolatedAreaPrice" name="dlvrIsolatedAreaPrice" value="0">
                    <input type="hidden" id="dlvrIsolatedArea" name="dlvrIsolatedArea" value="false">
                    <input type="hidden" id="couponDuplicateBe" value="0">
                    <!-- 결제수단 -->
                    <section>
                        <div class="sub-content-head etc-ty2">
                            <div class="inner">
                                <h3 class="title-t ty5">결제수단</h3>


                                <div class="r-side">
                                    <div class="chkbox">
                                        <label>
                                            <input type="checkbox" name="savePaywayBe" id="save_payway_be" value="1">
                                            <span class="text">선택한 결제수단 저장</span>
                                        </label>
                                    </div>
                                </div>

                            </div>
                        </div>

                        <div class="tbl ty2 mt-18">
                            <table>
                                <colgroup>
                                    <col style="width:210px">
                                    <col style="width:auto">
                                </colgroup>
                                <tbody>
                                <tr>
                                    <th class="top">결제수단 선택</th>
                                    <td>
                                        <div class="pay-wrap">
                                            <div class="pay-choice">
                                                <button type="button" data-type="1" class="pay-choice-btn ty1 active"
                                                        id="pay_card" data-payway="1" data-sign="nice">신용카드
                                                </button>
                                                <button type="button" data-type="2" class="pay-choice-btn ty2"
                                                        id="pay_ezkakao" data-payway="32" data-sign="nice"><img
                                                        src="//www.ottogimall.co.kr/static/imgs/front/cw/images/icon_kakaopay.png"
                                                        alt="kakaopay"></button>
                                                <button type="button" data-type="8" class="pay-choice-btn ty3"
                                                        id="pay_eznaver" data-payway="256" data-sign="nice"><img
                                                        src="//www.ottogimall.co.kr/static/imgs/front/cw/images/icon_npay.png"
                                                        alt="네이버페이"></button>
                                                <button type="button" data-type="3" class="pay-choice-btn ty4"
                                                        id="pay_ezpayco" data-payway="64" data-sign="nice"><img
                                                        src="//www.ottogimall.co.kr/static/imgs/front/cw/images/icon_payco.png"
                                                        alt="PAYCO"></button>

                                                <button type="button" data-type="5" class="pay-choice-btn ty1"
                                                        id="pay_virtual" data-payway="4" data-sign="nice">가상계좌
                                                </button>

                                                <button type="button" data-type="7" class="pay-choice-btn ty1"
                                                        id="pay_bank" data-payway="2" data-sign="nice">실시간계좌이체
                                                </button>
                                            </div>
                                            <div class="pay-type">
                                                <ul class="list ty2 mt-20 active" data-type="1">
                                                    <li class="color-4">최소 결제 금액 100원 이상일 때 승인 처리가 가능해요.</li>
                                                </ul>
                                                <ul class="list ty2 mt-20" data-type="2">
                                                    <li class="color-4">카카오톡에서 신용/체크카드 연결하고, 결제도 지문으로 쉽고 편리하게 이용하세요!
                                                    </li>
                                                    <li class="color-4">카드 결제 시, 결제금액 200만 원 이상일 경우 ARS 추가 인증이 필요합니다.
                                                        (카카오머니 결제시는 추가 인증 없음)
                                                    </li>
                                                </ul>
                                                <ul class="list ty2 mt-20" data-type="3">
                                                    <li class="color-4">페이코 포인트로 결제 시 1% 적립</li>
                                                    <li class="color-4">지원 카드: 모든 국내 신용/체크카드</li>
                                                </ul>
                                                <ul class="list ty2 mt-20" data-type="4">
                                                    <li class="color-4">10,000원 이상 첫 결제 시 10% 즉시 할인 (최대 5천원)</li>
                                                    <li class="color-4">스마일페이 결제시마다 0.5% 적립 (최대 5천원)</li>
                                                    <li class="color-4">스마일카드로 캐시 충전 결제시마다 2.0% 추가 적립</li>
                                                </ul>
                                                <ul class="list ty2 mt-20" data-type="6">
                                                    <li class="color-4">휴대폰 요금 청구서에 소액결제로 표시됩니다.</li>
                                                    <li class="color-4">결제한도는 각 통신사 고객센터로 문의해 주세요.</li>
                                                    <li class="color-4">휴대폰 결제 취소는 결제일 당월에만 가능하며, 이후 취소를 원하는 경우 고객센터로
                                                        문의해 주세요.
                                                    </li>
                                                </ul>
                                                <ul class="list ty2 mt-20" data-type="7">
                                                    <li class="color-4">최소 결제 금액 200원 이상일 때 승인 처리 가능해요.</li>
                                                    <li class="color-4">결제 완료 시 본인 계좌에서 즉시 이체 처리됩니다.</li>
                                                    <li class="color-4">은행별 이용 시간이 다를 수 있어요.</li>
                                                </ul>
                                                <ul class="list ty2 mt-20" data-type="8"> <!--네이버페이 -->
                                                    <li class="color-4">삼성큐커플랜 고객님! 네이버페이 결제분은 큐커플랜 실적에 포함되지 않으니 이점 참고해
                                                        주시기 바랍니다.
                                                    </li>
                                                </ul>
                                            </div>
                                        </div>
                                    </td>
                                </tr>


                                <tr class="pay-type-cont" data-type="5">
                                    <th>환불은행</th>
                                    <td>
                                        <select name="refundBank" id="refund_bank" class="selectbox ty1 w-full">
                                            <option value="">환불은행을 선택해주세요</option>

                                            <option value="23">SC제일은행</option>

                                            <option value="39">경남은행</option>

                                            <option value="34">광주은행</option>

                                            <option value="04">국민은행</option>

                                            <option value="03">기업은행</option>

                                            <option value="11">농협은행</option>

                                            <option value="31">대구은행</option>

                                            <option value="32">부산은행</option>

                                            <option value="02">산업은행</option>

                                            <option value="45">새마을금고</option>

                                            <option value="07">수협</option>

                                            <option value="88">신한은행</option>

                                            <option value="48">신협</option>

                                            <option value="27">한국시티은행</option>

                                            <option value="20">우리은행</option>

                                            <option value="71">우체국</option>

                                            <option value="37">전북은행</option>

                                            <option value="35">제주은행</option>

                                            <option value="81">하나은행</option>

                                        </select>
                                    </td>
                                </tr>
                                <tr class="pay-type-cont" data-type="5">
                                    <th class="top">환불계좌 예금주</th>
                                    <td>
                                        <div class="input">
                                            <input type="text" id="refund_depositor" name="refundDepositor" class="inp"
                                                   placeholder="환불은행 예금주명을 입력해주세요." value="방채민">
                                        </div>
                                    </td>
                                </tr>
                                <tr class="pay-type-cont" data-type="5">
                                    <th class="top">환불계좌번호</th>
                                    <td>
                                        <div class="input">
                                            <input type="number" id="refund_account" name="refundAccount" class="inp"
                                                   placeholder="환불 계좌번호를 입력해주세요 (‘-‘제외)">
                                        </div>
                                        <ul class="list ty2 mt-10">
                                            <li>주문 후 3일 내 미입금 시 주문이 취소돼요.</li>
                                            <li>가상 계좌, 이름, 금액이 일치해야 입금 확인이 가능합니다.</li>
                                        </ul>
                                    </td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                    </section>
                    <!-- 결제수단 -->

                    <!-- 동의 -->
                    <section>
                        <div class="bdr-box ty2">
                            <div class="chkbox">
                                <label>
                                    <input type="checkbox" id="agree">
                                    <span class="text" id="agree2"><span class="color-1">(필수)</span> 위 내용을 확인하였으며, 결제에 동의합니다.</span>
                                </label>
                            </div>

                            <div class="flex al-center space-between">
                                <div class="chkbox">
                                    <label>
                                        <input type="checkbox" name="terms3" id="terms3">
                                        <span class="text"><span class="color-1">(필수)</span> 이용약관 동의</span>
                                    </label>
                                </div>
                                <button type="button" class="btn btn-text-type btt1 underline"
                                        onclick="termAjaxFunc();">보기
                                </button>
                            </div>
                            <div class="flex al-center space-between">
                                <div class="chkbox">
                                    <label>
                                        <input type="checkbox" name="terms" id="terms" value="1">
                                        <span class="text"><span class="color-1">(필수)</span> 개인정보 수집, 이용에 관한 동의</span>
                                    </label>
                                </div>
                                <button type="button" class="btn btn-text-type btt1 underline"
                                        onclick="termAjaxFunc('privacy_collect');"><span>보기</span></button>
                            </div>

                        </div>
                        <ul class="list ty2 mt-20">
                            <li class="color-5">미성년자가 결제 시 법정대리인이 그 거래를 취소할 수 있습니다.</li>
                            <li class="color-5">주문 취소 시 결제하신 수단으로만 환불됩니다.</li>
                        </ul>

                    </section>
                    <!-- 동의 -->

                    <div class="btn-area mt-40">
                        <button type="button" class="btn ty5 c-ty1 w-390 free" data-type="payment"><span
                                id="finalAmount2">126,480원 주문하기</span></button>
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
                                <span><strong>127,480</strong>원</span>
                            </li>
                            <li>
                                <span>총 배송비</span>
                                <span><strong id="finalDeliverFeeTxt">0</strong>원</span>
                            </li>

                            <li class="sale" style="display: none">
                                <span>배송비 할인</span>
                                <span id="paidDlvrPriceTxt"><strong>-0</strong>원</span>
                            </li>
                            <li>
                                <span>쿠폰 할인</span>
                                <span id="paidCouponPriceTxt"><strong>-0</strong>원</span>
                            </li>
                            <li>
                                <span>마일리지 사용</span>
                                <span id="issueSmoneyTxt"><strong>-1,000</strong>원</span>
                            </li>

                        </ul>
                    </div>
                    <div class="in-cont">
                        <div class="total">
                            <strong class="tit">최종 결제금액</strong>
                            <strong class="r-side">
                                <span class="amount" id="paidPriceTxt"><strong>126,480</strong></span><span
                                    class="word">원</span>
                            </strong>
                        </div>
                        <ul class="list ty2 mt-40">
                            <li>무료배송 혜택 상품 및 배송 유형별 30,000원 이상 구매 시 무료배송입니다.</li>
                            <li>배송 유형 간 교차 합계 금액은 무료배송에 적용되지 않습니다.<br> (상온 배송+저온 배송 합계 30,000원 무료배송불가)</li>
                        </ul>
                    </div>

                </div>
                <button type="button" class="btn ty5 c-ty1 w-full" data-type="payment"><span id="finalAmount">126,480원 주문하기</span>
                </button>
            </div>
        </div>
    </main>
    <!-- main -->
</form>