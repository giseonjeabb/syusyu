<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%--이미지리스트 길이--%>
<c:set var="imgListLength" value="${fn:length(productImages) }"/>
<c:set var="categories" value="${sessionScope.categories}"/>
<c:set var="loginId" value="${sessionScope.mbrId}"/>
<head>

    <script src="${jsUrlFos}/product/product.js"></script>
</head>




    <div class="breadcrumb">
        <%--smallCategory--%>
        <div class="breadcrumb-inner">
            <a href="/products">홈</a>
            <a href="/products/${productDetail.middleNo}">${productDetail.middleNm}</a>
            <a href="/products/${productDetail.middleNo}/${productDetail.smallNo}}">${productDetail.smallNm}</a>
        </div>
    </div>
    <form id="frm_product" method="post">

        <div class="goods-detail-wrap">
<%--            <input type="hidden" id="pdPrice" data-baseprice="3380.00" data-finalprice="3380.00" data-discrate="0">--%>

            <!-- 상품상세 상단-->
            <div class="inner-content">
                <section class="goods-top-box">
                    <div class="goods-thumbs img-slide">
                        <div thumbsslider="" class="swiper mySwiper goods-thumb-slide">
                            <div class="swiper-wrapper">

                                <div class="swiper-slide">
                                    <img src="<c:url value='${productDetail.repImg}'/>" alt="">
                                </div>

                            </div>
                        </div>
                        <div class="swiper mySwiper2 goods-big-slide">
                            <div class="swiper-wrapper">

                                <div class="swiper-slide">
                                    <img src="<c:url value='${productDetail.repImg}'/>" alt="">
                                </div>

                            </div>
                            <div class="swiper-pagination"></div>
                        </div>
                    </div><!--//goods_thumbs-->
                    <div class="goods-info">
                        <div class="goods-desc">
                            <div class="name">
                                <p>${productDetail.prodNm}</p>
                                <div class="btn-wrap btn-active-wrap">
                                    <button type="button" class="btn icon like "><span class="btn-active-cont" no="${productDetail.prodId}"></span></button>
                                    <div class="pbw-wrap">
                                        <button type="button" class="btn icon share btn-share" data-type="share"><span class="text">공유하기</span></button>
                                        <div class="popup-wrap popup-share">
                                            <div class="popup-layer">
                                                <div class="popup-head">
                                                    <h4>공유하기</h4>
                                                    <a href="javascript:void(0);" class="btn icon remove_19" data-btn="false">close</a>
                                                </div>
                                                <div class="popup-content" data-type="share-box">

                                                    <div class="popup-bottom-share-content">

                                                        <a href="javascript:" data-type="kakao" key="1303d0818dd6a7080ae5b1275c4056c5">
                                                            <img src="<c:url value='${imgUrl}/icon_sns_kakao.png'/>" alt="카카오톡 공유하기">
                                                            <p>카카오톡</p>
                                                        </a>


                                                        <a href="javascript:" data-type="facebook">
                                                            <img src="<c:url value='${imgUrl}/icon_sns_facebook.png'/>" alt="페이스북 공유하기">
                                                            <p class="">페이스북</p>
                                                        </a>

                                                    </div>

                                                    <div class="url-copy">
                                                        <input type="text" id="ShareUrl" readonly="readonly">
                                                        <button type="button" class="btn clipboard" data-type="link"><span>복사</span></button>
                                                    </div>


                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div><!--// btn-wrap -->
                            </div><!--//name-->
                            <div class="star-avg">
                                <div class="avg-per">
                                    <span class="star-per"><em style="width:100.0%;">평점</em></span>
                                    <span data-name="num">${productDetail.avgStarRating}</span>
                                    <a href="#goodsReview" class="txt">${productDetail.revwCnt}건</a>
                                </div>
                            </div><!--//star-avg-->
                            <div class="price">
                                <c:choose>
                                    <c:when test="${productDetail.dcPer > 0}">
                                        <div class="flex al-center"  data-price="${productDetail.dcPrc}>
                                            <span class="per">${productDetail.dcPer}%</span>
                                            <fmt:formatNumber value="${productDetail.dcPrc}" pattern="#,###"/><span class="won">원</span>
                                        </div>
                                        <div class="amount flex al-center">
                                            <del><fmt:formatNumber value="${productDetail.salePrc}" pattern="#,###"/>원</del>
                                            <button type="button" class="btn icon mark tooltip-btn va-m"><span>가격 상세보기</span></button>
                                        </div>
                                    </c:when>
                                    <c:otherwise>
                                        <div class="flex al-center" data-price="${productDetail.salePrc}">
                                            <fmt:formatNumber value="${productDetail.salePrc}" pattern="#,###"/><span class="won">원</span>
                                        </div><!--// price -->
                                    </c:otherwise>
                                </c:choose>
                            </div>



                            <div class="coupon-box">
                                <input type="hidden" coupon-total="0">
                                <!-- 쿠폰 종류 -->
                            </div><!--// coupon-box -->


                            <ul class="goods-guide">
                                <li class="flex">
                                    <span class="g-tit">제조국</span>
                                    <span class="g-cont">상품정보 제조국표시 참조</span>
                                </li>
                                <li class="flex">
                                    <span class="g-tit">적립정보</span>
                                    <span class="g-cont">
                                        <span>로그인 후 적립혜택 제공
                                            <em class="fw-7">0.5%</em>
                                            (17 마일리지)
                                        </span>
                                    </span>
                                </li>
                                <li class="flex">
                                    <span class="g-tit">배송정보</span>
                                    <span class="g-cont">
                                        <span class="deli-info">
                                            <em class="fw-7">3,000</em>원
<%--                                            <button type="button" class="btn ar-r icon mark tooltip-btn" onclick="bta.alert.open('.deliveryPopup');">--%>
                                            <button type="button" class="btn ar-r icon mark tooltip-btn" onclick="openPopup()">
                                                <span class="ty2"></span>
                                            </button>
                                        </span>
                                        <p>상품 50,000원 이상 구매시 무료배송</p>

                                    </span>
                                </li>


                                <!--옵션 선택 -->

                                <li class="flex">
                                    <span class="g-tit pt-10">옵션선택</span>
                                    <span class="g-cont">


											<div class="custom_select" type="general">
												<div class="ui selection dropdown option-select" tabindex="0">
													<input type="hidden" id="opt_picker_1_1" value="">
													<div class="default text">사이즈를 선택하세요</div>
                                                    <div class="menu" tabindex="-1">
                                                        <c:forEach var="item" items="${shoesSizeList}">
                                                            <div class="item" data-value="${item.shoesSize}" data-opt-prc="${item.optPrc}" data-inv-qty="${item.invQty}" data-purchase-limit="${productDetail.dlvChgDtl}" data-opt-comb-no="${item.optCombNo}">
                                                                <span>${item.shoesSize} ${item.optPrc != 0 ?'(+'+= item.optPrc+=')':''} </span>
                                                            </div>
                                                        </c:forEach>
                                                    </div>
                                                </div>
											</div><!-- // custom_select -->
										</span>
                                </li><!--//옵션선택 -->
                                <div class="option-selected-list" style="display: none;"><!-- 선택한 상품 옵션 리스트 -->

                                </div>
                            </ul><!--//goods-guide-->
                            <div class="total-price-area">
                                <div class="total-price">
                                    총금액${productDetail.cateId}
                                    <strong data-type="price">0</strong>
                                    <span class="color-1 ">원</span>
                                </div>
                            </div><!--//total-price-area-->
                            <div class="btn-area">
                                <input type="hidden" id="prod_no"  name="prodId" value="${productDetail.prodId}"/>
                                <input type="hidden" id="prod_cate" name="cateId" value="${productDetail.cateId}"/>
                                <input type="hidden" id="prod_sale_price" name="salePrc" value="${productDetail.salePrc}"/>
                                <input type="hidden" id="prod_dc_per" name="dcPer" value="${productDetail.dcPer}"/>
                                <input type="hidden" id="prod_dc_prc" name="dcPrc" value="${prodectDetail.dcPrc}"/>
                                <input type="hidden" id="login_id" name="mbrId" value="${loginId}"/>


                                <a href="#" class="btn ty4 c-ty2 icon gift" data-name="order-by" data-type="gift" data-boolean="true"><span>선물함 담기</span></a>
                                <a href="#" class="btn ty4 c-ty2" data-name="order-by" data-type="cart" data-loggedin="${not empty sessionScope.mbrId}" onclick="productIntoCart()"><span>장바구니</span></a>
                                <a href="#" class="btn ty4 c-ty1" data-name="order-by" data-type="order "><span>바로구매</span></a>


                            </div><!--//btn-area-->

                        </div><!--//goods-desc-->
                    </div><!--//goods-info-->
                </section>
            </div>
            <!-- //상품상세 상단-->
            <!-- 상품 상세 하단 -->
            <section class="goods-bottom-box tab-box">
                <div class="tab-group-list-wrap">
                    <div class="inner-content">
                        <ul class="tab-group-list ty2">
                            <li class="tab-menu">
                                <a href="#" class="active">상세정보</a>
                            </li>
                            <li class="tab-menu">
                                <a href="#">상품후기 <span><em name="tab_review_size">${productDetail.revwCnt}</em></span></a>
                            </li>
                            <li class="tab-menu">
                                <a href="#">구매정보</a>
                            </li>
                            <li class="tab-menu">
                                <a href="#">상품문의 <span><em name="tab_qna_size">0</em></span></a>
                            </li>
                        </ul><!--//tab-group-list-->
                    </div>
                </div><!--//tab-group-list-wrap-->
                <div class="goods-detail-con">
                    <div class="inner-content move-container flex">
                        <div class="tab-group-cont content-mini left-case">
                            <!-- 상세정보 -->
                            <div class="tab-cont goods-detail-img">
                                <div style="text-align : center;">
                                    <c:forEach var="img" items="${imageList}">
                                        <img src="${img.imagePath}">
                                    </c:forEach>
                                </div>
                            </div>

                            <!-- 상품후기 -->
                            <div class="tab-cont goods-review" id="goodsReview">
                                <section class="def-box" data-name="review">
                                    <div class="def-box-head mb-15">
                                        <h4 class="tit">상품후기</h4>
                                        <a href="javascript:" class="btn ty1 c-ty5" data-type="review_regist"><span>후기 작성하기</span></a>
                                    </div>
                                    <div class="def-box-content">
                                        <div class="star-avg">
                                            <div class="avg-per">
                                                <span data-type="num">${productDetail.avgStarRating}</span>
                                                <span class="star-per"><em style="width:100%;">평점</em></span>
                                                <p class="txt">총 <span name="tab_review_size">${productDetail.revwCnt}</span>건</p>
                                            </div>
                                        </div>
                                        <div class="sorting">
								<span class="chkbox">
									<label>
										<input type="checkbox" class="chk-all" name="filter-photo">
										<span class="text">포토후기만 보기</span>
									</label>
								</span>
                                            <div class="tab ty3">
                                                <a href="javascript:" class="active" combo-list-item="high">추천순</a>
                                                <a href="javascript:" combo-list-item="new">최신순</a>
                                            </div>
                                        </div><!--//sorting-->

                                        <div class="reviews-list-wrap" page-no="1" total-size="1" total-page="1" total-review="1" rating-avg="5.0" rating-star="5">


                                            <div class="rev-list view-list" data-idx="1388">
                                                <div class="rev-detail">
                                                    <div class="star-per-wrap">
                                                        <div class="star-per"><em style="width:100%;">평점</em></div>
                                                        <p class="star-sc">5</p>
                                                    </div>
                                                    <div class="rev-info">
                                                        <span class="writer"><em>작성자</em>rlaaud***</span>
                                                        <span class="date"><em>날짜</em>2023.06.07</span>

                                                    </div><!--//rev-info -->
                                                    <div class="rev-cont">
                                                        같이 온 작은 밥과 먹기 딱 좋은 양이에요!<br>봉지채 조리 가능해서 먹기 넘 편해요!<br>맛도 당연히 좋습니당

                                                        <img src="https://ottogi-mall-s3.s3.ap-northeast-2.amazonaws.com/data/review/20230607/16861057723559Wxzi.jpeg" alt="">

                                                    </div>
                                                    <button type="button" class="review-more detail-more-btn" style="">더보기</button>
                                                </div>

                                                <div class="rev-photo">
                                                    <div class="photo-list">
                                                        <a href="#">
                                                            <img src="https://ottogi-mall-s3.s3.ap-northeast-2.amazonaws.com/data/review/20230607/16861057723559Wxzi.jpeg" alt="">
                                                        </a>
                                                    </div>
                                                    <span class="photo-amount"><em>1</em></span>
                                                </div>


                                            </div><!-- // rev-list -->


                                        </div><!--//reviews-list-wrap--></div><!--//def-box-content-->
                                </section>

                                <div id="ux_review_regist" class="popup-wrap" active-popup="true"></div>

                            </div><!--// 상품후기 -->
                            <!-- 구매정보 -->
                            <div class="tab-cont">

                                <div class="fold-box">
                                    <div class="fold-head">
                                        <h6>상품 정보 고시</h6>
                                        <i class="icon icon-arr-b"></i>
                                    </div>
                                    <div class="fold-content">
                                        <div class="tbl ty1">
                                            <table>
                                                <colgroup>
                                                    <col style="width:270px">
                                                    <col style="width:auto">
                                                </colgroup>
                                                <tbody>

                                                <tr>
                                                    <th>제품명</th>
                                                    <td>${productDetail.prodNm}</td>
                                                </tr>

                                                <tr>
                                                    <th>제품 소</th>
                                                    <td>${productDetail.mfgdMatr}</td>
                                                </tr>

                                                <tr>
                                                    <th>색상</th>
                                                    <td>상품설명 및 상품 이미지 참조</td>
                                                </tr>

                                                <tr>
                                                    <th>치수</th>
                                                    <td>사이즈 옵션표 참고</td>
                                                </tr>

                                                <tr>
                                                    <th>제조자, 수입품의 경우 수입자를 함께 표기</th>
                                                    <td>${productDetail.mftco}</td>
                                                </tr>

                                                <tr>
                                                    <th>제조국</th>
                                                    <td>${productDetail.mftNatn}</td>
                                                </tr>

                                                <tr>
                                                    <th>취급시 주의사항</th>
                                                    <td>상품 TAG 참고 / 소비자 부주의로 인한 제품 손상 보상 불가</td>
                                                </tr>

                                                <tr>
                                                    <th>품질보증기준</th>
                                                    <td>전자상거래법 및 공정거래위원회 고시 내 소비자 분쟁해결기준에 따름</td>
                                                </tr>

                                                <tr>
                                                    <th>소비자 안전을 위한 주의사항</th>
                                                    <td>상품설명 및 상품 이미지 참조</td>
                                                </tr>

                                                <tr>
                                                    <th>수입식품에 해당하는 경우</th>
                                                    <td>해당 없음</td>
                                                </tr>

                                                <tr>
                                                    <th>A/S 책임자</th>
                                                    <td>${productDetail.mftco}</td>
                                                </tr>

                                                </tbody>
                                            </table>
                                        </div>



                                    </div>
                                </div>


                                <div class="fold-box">
                                    <div class="fold-head">
                                        <h6>배송 정보</h6>
                                        <i class="icon icon-arr-b"></i>
                                    </div>
                                    <div class="fold-content">
                                        <p>&nbsp;</p>
                                        <div class="con mb-40"
                                             style="margin: 0px 0px 44px; box-sizing: border-box; border: 0px; padding: 0px; vertical-align: baseline; color: rgb(29, 29, 27); font-family: Pretendard, sans-serif; font-size: 16px; letter-spacing: -0.4px;">
                                            <h6 class="sub-tit"
                                                style="margin: 0px 0px 10px; box-sizing: border-box; border: 0px; padding: 0px; vertical-align: baseline; font-size: 16px;">
                                                [배송비 기본]</h6>
                                            <ul class="list ty1"
                                                style="margin: 0px; box-sizing: border-box; border: 0px; padding: 0px; vertical-align: baseline; list-style: none;">
                                                <li style="margin: 0px; box-sizing: border-box; border: 0px; padding: 0px 0px 0px 8px; vertical-align: baseline; position: relative; font-size: 15px; line-height: 26px; color: rgb(51, 51, 51);">
                                                    기본 배송료는 3,000원입니다.&ZeroWidthSpace;
                                                </li>
                                                <li style="margin: 2px 0px 0px; box-sizing: border-box; border: 0px; padding: 0px 0px 0px 8px; vertical-align: baseline; position: relative; font-size: 15px; line-height: 26px; color: rgb(51, 51, 51);"></li>
                                                <li style="margin: 2px 0px 0px; box-sizing: border-box; border: 0px; padding: 0px 0px 0px 8px; vertical-align: baseline; position: relative; font-size: 15px; line-height: 26px; color: rgb(51, 51, 51);">
                                                    도서산간지역 배송료는 3,000원 있습니다.<br
                                                        style="box-sizing: border-box; border-width: 0px; border-style: solid; border-color: currentcolor;">(단,
                                                    선물받는 사람이 도서산간 지역이어도 선물하기에서는 기본 배송료만 부과합니다.)&ZeroWidthSpace;
                                                </li>
                                            </ul>
                                        </div>
                                        <div class="con mb-40"
                                             style="margin: 0px 0px 44px; box-sizing: border-box; border: 0px; padding: 0px; vertical-align: baseline; color: rgb(29, 29, 27); font-family: Pretendard, sans-serif; font-size: 16px; letter-spacing: -0.4px;">
                                            <h6 class="sub-tit"
                                                style="margin: 0px 0px 10px; box-sizing: border-box; border: 0px; padding: 0px; vertical-align: baseline; font-size: 16px;">
                                                [무료배송 기준]</h6>
                                            <ul class="list ty1"
                                                style="margin: 0px; box-sizing: border-box; border: 0px; padding: 0px; vertical-align: baseline; list-style: none;">
                                                <li style="margin: 0px; box-sizing: border-box; border: 0px; padding: 0px 0px 0px 8px; vertical-align: baseline; position: relative; font-size: 15px; line-height: 26px; color: rgb(51, 51, 51);"></li>
                                                <li style="margin: 0px; box-sizing: border-box; border: 0px; padding: 0px 0px 0px 8px; vertical-align: baseline; position: relative; font-size: 15px; line-height: 26px; color: rgb(51, 51, 51);">
                                                    무료배송 혜택 상품 및 배송료는 50,000원 이상 구매 시 무료배송입니다.&ZeroWidthSpace;
                                                </li>
                                                <li style="margin: 2px 0px 0px; box-sizing: border-box; border: 0px; padding: 0px 0px 0px 8px; vertical-align: baseline; position: relative; font-size: 15px; line-height: 26px; color: rgb(51, 51, 51);"></li>
                                                <li style="margin: 2px 0px 0px; box-sizing: border-box; border: 0px; padding: 0px 0px 0px 8px; vertical-align: baseline; position: relative; font-size: 15px; line-height: 26px; color: rgb(51, 51, 51);">
                                                    무료배송 상품이 포함되어있는 주문 전체에는 무료배송이 적용됩니다&ZeroWidthSpace;
                                                </li>
                                            </ul>
                                        </div>
                                        <div class="con mb-40"
                                             style="margin: 0px 0px 44px; box-sizing: border-box; border: 0px; padding: 0px; vertical-align: baseline; color: rgb(29, 29, 27); font-family: Pretendard, sans-serif; font-size: 16px; letter-spacing: -0.4px;">
                                            <h6 class="sub-tit"
                                                style="margin: 0px 0px 10px; box-sizing: border-box; border: 0px; padding: 0px; vertical-align: baseline; font-size: 16px;">
                                                [출고일]</h6>
                                            <ul class="list ty1"
                                                style="margin: 0px; box-sizing: border-box; border: 0px; padding: 0px; vertical-align: baseline; list-style: none;">
                                                <li style="margin: 0px; box-sizing: border-box; border: 0px; padding: 0px 0px 0px 8px; vertical-align: baseline; position: relative; font-size: 15px; line-height: 26px; color: rgb(51, 51, 51);"></li>
                                                <li style="margin: 0px; box-sizing: border-box; border: 0px; padding: 0px 0px 0px 8px; vertical-align: baseline; position: relative; font-size: 15px; line-height: 26px; color: rgb(51, 51, 51);">
                                                    13시 이전 결제 완료 시 당일 출고&ZeroWidthSpace;
                                                </li>
                                                <li style="margin: 2px 0px 0px; box-sizing: border-box; border: 0px; padding: 0px 0px 0px 8px; vertical-align: baseline; position: relative; font-size: 15px; line-height: 26px; color: rgb(51, 51, 51);"></li>
                                                <li style="margin: 2px 0px 0px; box-sizing: border-box; border: 0px; padding: 0px 0px 0px 8px; vertical-align: baseline; position: relative; font-size: 15px; line-height: 26px; color: rgb(51, 51, 51);">
                                                    13시 이후 결제 완료 시 명일 출고&ZeroWidthSpace;
                                                </li>
                                                <span id="husky_bookmark_end_1675910884026"></span>
                                                <li style="margin: 2px 0px 0px; box-sizing: border-box; border: 0px; padding: 0px 0px 0px 8px; vertical-align: baseline; position: relative; font-size: 15px; line-height: 26px; color: rgb(51, 51, 51);"></li>
                                                <li style="margin: 2px 0px 0px; box-sizing: border-box; border: 0px; padding: 0px 0px 0px 8px; vertical-align: baseline; position: relative; font-size: 15px; line-height: 26px; color: rgb(51, 51, 51);">
                                                    재고 부족 등으로 출고가 불가할 경우 배송 가능한 상품은 선배송 처리되며, 알림톡 또는 SMS로 안내 드립니다.&ZeroWidthSpace;
                                                </li>
                                            </ul>
                                        </div>
                                        <div class="con mb-40"
                                             style="margin: 0px 0px 44px; box-sizing: border-box; border: 0px; padding: 0px; vertical-align: baseline; font-family: Pretendard, sans-serif; letter-spacing: -0.4px;">
                                            <h6 class="sub-tit"
                                                style="color: rgb(29, 29, 27); font-size: 16px; margin: 0px 0px 10px; box-sizing: border-box; border: 0px; padding: 0px; vertical-align: baseline;">
                                                [배송기간]&ZeroWidthSpace;</h6>
                                            <ul class="list ty1"
                                                style="color: rgb(29, 29, 27); font-size: 16px; margin: 0px; box-sizing: border-box; border: 0px; padding: 0px; vertical-align: baseline; list-style: none;">
                                                <li style="margin: 0px; box-sizing: border-box; border: 0px; padding: 0px 0px 0px 8px; vertical-align: baseline; position: relative; font-size: 15px; line-height: 26px; color: rgb(51, 51, 51);"></li>
                                                <li style="margin: 0px; box-sizing: border-box; border: 0px; padding: 0px 0px 0px 8px; vertical-align: baseline; position: relative; font-size: 15px; line-height: 26px; color: rgb(51, 51, 51);">
                                                    평균 배송일은 연휴 및 공휴일을 제외한 영업일 기준, 입금/결제 확인 후 2일~4일입니다.&ZeroWidthSpace;
                                                </li>
                                                <li style="margin: 2px 0px 0px; box-sizing: border-box; border: 0px; padding: 0px 0px 0px 8px; vertical-align: baseline; position: relative; font-size: 15px; line-height: 26px; color: rgb(51, 51, 51);"></li>
                                                <li style="margin: 2px 0px 0px; box-sizing: border-box; border: 0px; padding: 0px 0px 0px 8px; vertical-align: baseline; position: relative; font-size: 15px; line-height: 26px; color: rgb(51, 51, 51);">
                                                    배송 예정일은 주문시점에 따라 평균 배송일과 다를 수 있습니다.&ZeroWidthSpace;
                                                </li>
                                            </ul>
                                            <div style=""><font color="#333333"><span style="font-size: 15px;"><br></span></font>
                                            </div>
                                            <div style=""><font color="#333333"><span style="font-size: 15px;"><br></span></font>
                                            </div>
                                            <div style=""><font color="#333333"><span
                                                    style="font-size: 15px;"></span></font></div>
                                            <h6 class="sub-tit"
                                                style="letter-spacing: -0.4px; margin: 0px 0px 10px; box-sizing: border-box; border: 0px; padding: 0px; vertical-align: baseline; font-size: 16px; color: rgb(29, 29, 27);">
                                                [택배사]&ZeroWidthSpace;</h6>
                                            <ul class="list ty1"
                                                style="letter-spacing: -0.4px; margin: 0px; box-sizing: border-box; border: 0px; padding: 0px; vertical-align: baseline; list-style: none; color: rgb(29, 29, 27); font-size: 16px;">
                                                <li style="margin: 0px; box-sizing: border-box; border: 0px; padding: 0px 0px 0px 8px; vertical-align: baseline; position: relative; font-size: 15px; line-height: 26px; color: rgb(51, 51, 51);">
                                                    <b>CJ대한통운</b>&ZeroWidthSpace;
                                                </li>
                                                <li style="margin: 2px 0px 0px; box-sizing: border-box; border: 0px; padding: 0px 0px 0px 8px; vertical-align: baseline; position: relative; font-size: 15px; line-height: 26px; color: rgb(51, 51, 51);">
                                                    배송조회 및 문의는 마이페이지 &gt; 주문배송조회 또는 1588-1255(CJ대한통운)에서 가능합니다.&ZeroWidthSpace;
                                                </li>
                                                <li style="margin: 2px 0px 0px; box-sizing: border-box; border: 0px; padding: 0px 0px 0px 8px; vertical-align: baseline; position: relative; font-size: 15px; line-height: 26px; color: rgb(51, 51, 51);">
                                                    단 당사의 사정에 따라 택배사는 변경될 수 있습니다.&ZeroWidthSpace;&ZeroWidthSpace;
                                                </li>
                                            </ul>
                                            <div style=""><span style="letter-spacing: -0.4px;">&nbsp;</span><font
                                                    color="#333333"><span
                                                    style="font-size: 15px;"><br></span></font></div>
                                        </div>
                                    </div>
                                </div>



                                <div class="fold-box">
                                    <div class="fold-head">
                                        <h6>취소/교환/반품</h6>
                                        <i class="icon icon-arr-b"></i>
                                    </div>
                                    <div class="fold-content">
                                        <p>&nbsp;</p><div class="con mb-40" style="margin: 0px 0px 44px; box-sizing: border-box; border: 0px; padding: 0px; vertical-align: baseline; color: rgb(29, 29, 27); font-family: Pretendard, sans-serif; font-size: 16px; letter-spacing: -0.4px;"><h6 class="sub-tit" style="margin: 0px 0px 10px; box-sizing: border-box; border: 0px; padding: 0px; vertical-align: baseline; font-size: 16px;">[취소/반품 안내]</h6><ul class="list ty1" style="margin: 0px; box-sizing: border-box; border: 0px; padding: 0px; vertical-align: baseline; list-style: none;"><li style="margin: 0px; box-sizing: border-box; border: 0px; padding: 0px 0px 0px 8px; vertical-align: baseline; position: relative; font-size: 15px; line-height: 26px; color: rgb(51, 51, 51);">기존 결제 수단으로만 환불돼요.</li><li style="margin: 0px; box-sizing: border-box; border: 0px; padding: 0px 0px 0px 8px; vertical-align: baseline; position: relative; font-size: 15px; line-height: 26px; color: rgb(51, 51, 51);"></li><li style="margin: 0px; box-sizing: border-box; border: 0px; padding: 0px 0px 0px 8px; vertical-align: baseline; position: relative; font-size: 15px; line-height: 26px; color: rgb(51, 51, 51);">부분 취소/반품 시 쿠폰을 사용한 경우 <span style="letter-spacing: -0.4px;">귀책 주체와 상관 없이&nbsp;</span><u>할인 금액을 제외한 실 결제 금액에 대해 환불돼요.</u></li><li style="margin: 0px; box-sizing: border-box; border: 0px; padding: 0px 0px 0px 8px; vertical-align: baseline; position: relative; font-size: 15px; line-height: 26px; color: rgb(51, 51, 51);"><span style="letter-spacing: -0.4px;">계좌이체 결제한 경우 주문 시 입금자명과 동일한 계좌로 환불받을 수 있어요.&ZeroWidthSpace;</span></li><li style="margin: 2px 0px 0px; box-sizing: border-box; border: 0px; padding: 0px 0px 0px 8px; vertical-align: baseline; position: relative; font-size: 15px; line-height: 26px; color: rgb(51, 51, 51);">상품 검수 완료 후 입금되어 시간이 소요될 수 있으니 조금만 기다려 주세요.</li><li style="margin: 2px 0px 0px; box-sizing: border-box; border: 0px; padding: 0px 0px 0px 8px; vertical-align: baseline; position: relative; font-size: 15px; line-height: 26px; color: rgb(51, 51, 51);">타 택배사 이용 시 선불 발송만 가능해요. (착불 불가)</li></ul></div><div class="con mb-40" style="margin: 0px 0px 44px; box-sizing: border-box; border: 0px; padding: 0px; vertical-align: baseline; color: rgb(29, 29, 27); font-family: Pretendard, sans-serif; font-size: 16px; letter-spacing: -0.4px;"><h6 class="sub-tit" style="margin: 0px 0px 10px; box-sizing: border-box; border: 0px; padding: 0px; vertical-align: baseline; font-size: 16px;">[취소/교환/반품 불가&ZeroWidthSpace;]</h6><ul class="list ty1" style="margin: 0px; box-sizing: border-box; border: 0px; padding: 0px; vertical-align: baseline; list-style: none;"><li style="margin: 0px; box-sizing: border-box; border: 0px; padding: 0px 0px 0px 8px; vertical-align: baseline; position: relative; font-size: 15px; line-height: 26px; color: rgb(51, 51, 51);">다음의 경우 교환/반품 기간 내라도 취소/교환/반품/환불이 불가해요. (제품 불량 및 하자, 오배송 제외)&ZeroWidthSpace; &ZeroWidthSpace;</li><li style="margin: 2px 0px 0px; box-sizing: border-box; border: 0px; padding: 0px 0px 0px 8px; vertical-align: baseline; position: relative; font-size: 15px; line-height: 26px; color: rgb(51, 51, 51);">상품 수령일로부터 7일이 경과한 경우&ZeroWidthSpace;</li><li style="margin: 2px 0px 0px; box-sizing: border-box; border: 0px; padding: 0px 0px 0px 8px; vertical-align: baseline; position: relative; font-size: 15px; line-height: 26px; color: rgb(51, 51, 51);">포장을 개봉하거나 상품을 취식한 경우</li><li style="margin: 2px 0px 0px; box-sizing: border-box; border: 0px; padding: 0px 0px 0px 8px; vertical-align: baseline; position: relative; font-size: 15px; line-height: 26px; color: rgb(51, 51, 51);">구성품 또는 사은품을 반납하지 않은 경우</li><li style="margin: 2px 0px 0px; box-sizing: border-box; border: 0px; padding: 0px 0px 0px 8px; vertical-align: baseline; position: relative; font-size: 15px; line-height: 26px; color: rgb(51, 51, 51);">신선, 냉장, 냉동상품에 대해 시간이 경과되어 상품의 가치가 현저히 감소한 경우</li></ul></div><div class="con mb-40" style="margin: 0px 0px 44px; box-sizing: border-box; border: 0px; padding: 0px; vertical-align: baseline; color: rgb(29, 29, 27); font-family: Pretendard, sans-serif; font-size: 16px; letter-spacing: -0.4px;"><h6 class="sub-tit" style="margin: 0px 0px 10px; box-sizing: border-box; border: 0px; padding: 0px; vertical-align: baseline; font-size: 16px;">[취소/교환/반품 비용]</h6><ul class="list ty1" style="margin: 0px; box-sizing: border-box; border: 0px; padding: 0px; vertical-align: baseline; list-style: none;"><li style="margin: 0px; box-sizing: border-box; border: 0px; padding: 0px 0px 0px 8px; vertical-align: baseline; position: relative; font-size: 15px; line-height: 26px; color: rgb(51, 51, 51);">고객 단순 변심으로 인한 교환 및 반품 시 박스당 왕복 6,000원의 배송비가 부과돼요.</li><li style="margin: 0px; box-sizing: border-box; border: 0px; padding: 0px 0px 0px 8px; vertical-align: baseline; position: relative; font-size: 15px; line-height: 26px; color: rgb(51, 51, 51);">취소/반품으로 무료 배송 조건이 충족되지 못할 시 배송비가 추가로 부과될 수 있어요.</li><li style="margin: 2px 0px 0px; box-sizing: border-box; border: 0px; padding: 0px 0px 0px 8px; vertical-align: baseline; position: relative; font-size: 15px; line-height: 26px; color: rgb(51, 51, 51);">제품 하자로 인한 반품 비용은 당사에서 부담합니다.</li></ul></div><div class="con mb-40" style="margin: 0px 0px 44px; box-sizing: border-box; border: 0px; padding: 0px; vertical-align: baseline; color: rgb(29, 29, 27); font-family: Pretendard, sans-serif; font-size: 16px; letter-spacing: -0.4px;"><h6 class="sub-tit" style="margin: 0px 0px 10px; box-sizing: border-box; border: 0px; padding: 0px; vertical-align: baseline; font-size: 16px;">[환불 규정]&ZeroWidthSpace;&ZeroWidthSpace;</h6><ul class="list ty1" style="margin: 0px; box-sizing: border-box; border: 0px; padding: 0px; vertical-align: baseline; list-style: none;"><li style="margin: 0px; box-sizing: border-box; border: 0px; padding: 0px 0px 0px 8px; vertical-align: baseline; position: relative; font-size: 15px; line-height: 26px; color: rgb(51, 51, 51);">반품된 상품이 물류센터로 입고되어 검수가 완료되면 반품완료 안내를 드립니다.&ZeroWidthSpace;</li><li style="margin: 2px 0px 0px; box-sizing: border-box; border: 0px; padding: 0px 0px 0px 8px; vertical-align: baseline; position: relative; font-size: 15px; line-height: 26px; color: rgb(51, 51, 51);">환불은 반품완료 후 영업일 기준 평균 7일이 소요됩니다.&ZeroWidthSpace;</li><li style="margin: 2px 0px 0px; box-sizing: border-box; border: 0px; padding: 0px 0px 0px 8px; vertical-align: baseline; position: relative; font-size: 15px; line-height: 26px; color: rgb(51, 51, 51);">카드로 결제하신 경우 영업일 기준 평균 4일~7일의 승인취소 기간이 소요됩니다.&ZeroWidthSpace;</li><li style="margin: 2px 0px 0px; box-sizing: border-box; border: 0px; padding: 0px 0px 0px 8px; vertical-align: baseline; position: relative; font-size: 15px; line-height: 26px; color: rgb(51, 51, 51);">현금으로 결제하신 경우 환불계좌로 입금되며 평균 4일~7일의 환불기간이 소요됩니다.&ZeroWidthSpace;</li><li style="margin: 2px 0px 0px; box-sizing: border-box; border: 0px; padding: 0px 0px 0px 8px; vertical-align: baseline; position: relative; font-size: 15px; line-height: 26px; color: rgb(51, 51, 51);">결제 수단에 따라 환불기간이 평균일보다 길게 소요될 수 있습니다.&ZeroWidthSpace;</li></ul></div><div class="con mg-0" style="margin-bottom: 44px; box-sizing: border-box; border: 0px; padding: 0px; vertical-align: baseline; font-family: Pretendard, sans-serif; letter-spacing: -0.4px; margin-top: 0px !important; margin-right: 0px !important; margin-left: 0px !important;"><h6 class="sub-tit" style="color: rgb(29, 29, 27); font-size: 16px; margin: 0px 0px 10px; box-sizing: border-box; border: 0px; padding: 0px; vertical-align: baseline;">[취소/반품 정책]</h6><ul class="list ty1" style="color: rgb(29, 29, 27); font-size: 16px; margin: 0px; box-sizing: border-box; border: 0px; padding: 0px; vertical-align: baseline; list-style: none;"><li style="margin: 0px; box-sizing: border-box; border: 0px; padding: 0px 0px 0px 8px; vertical-align: baseline; position: relative; font-size: 15px; line-height: 26px; color: rgb(51, 51, 51);">주문 취소는 [결제완료] 상태일 때 마이페이지 &gt; 주문내역 상세페이지에서 가능합니다.</li><li style="margin: 0px; box-sizing: border-box; border: 0px; padding: 0px 0px 0px 8px; vertical-align: baseline; position: relative; font-size: 15px; line-height: 26px; color: rgb(51, 51, 51);">반품은 [배송완료] 상태일 때 마이페이지 &gt; 주문내역 상세페이지에서 가능합니다.</li><li style="margin: 0px; box-sizing: border-box; border: 0px; padding: 0px 0px 0px 8px; vertical-align: baseline; position: relative; font-size: 15px; line-height: 26px; color: rgb(51, 51, 51);">구매확정 시 취소,교환,반품이 불가합니다.&nbsp;</li><li style="margin: 0px; box-sizing: border-box; border: 0px; padding: 0px 0px 0px 8px; vertical-align: baseline; position: relative; font-size: 15px; line-height: 26px; color: rgb(51, 51, 51);">(제품 불량, 하자, 오 배송 제외)</li></ul><div style=""><br></div></div>
                                    </div>
                                </div>

                            </div><!-- //구매정보 -->
                            <!-- 상품문의 -->
                            <div class="tab-cont goods-qna">

                                <h4 class="tit">상품문의 <strong class="count color-1" name="tab_qna_size">0</strong></h4>
                                <div class="qna-head flex space-between">
                                    <div class="chkbox">
                                        <label>
                                            <input type="checkbox" name="smine" id="qna_mine" value="1">
                                            <span class="text">내 문의 보기</span>
                                        </label>
                                    </div>
                                    <a href="#" class="btn ty1 c-ty5 bt-qna-regist"><span>문의 작성하기</span></a>
                                </div>


                                <div id="ux_qna_regist" class="popup-wrap" active-popup="true"></div>




                                <div class="goods-qna-list-wrap" page-no="1" total-size="0" total-page="1" total-qna="0">


                                    <div class="list-none bt-0">
                                        <p class="msg-text">상품문의가 없습니다.</p>
                                    </div>



                                </div><!--//goods-qna-list-wrap--></div>
                            <!-- //상품문의 -->
                        </div><!-- //상세정보 left-case -->
<%--                        <div class="right-case">--%>
<%--                            <div class="move-container-right">--%>
<%--                                <div class="inner">--%>
<%--                                    <div class="option-selected-list">--%>


<%--                                        <div class="custom_select">--%>

<%--                                            <div class="ui selection dropdown option-select" tabindex="0">--%>
<%--                                                <input type="hidden" id="opt_picker_2_1" value="">--%>
<%--                                                <div class="default text">사이즈를 선택하세요</div>--%>
<%--                                                <div class="menu" tabindex="-1">--%>
<%--                                                    <c:forEach var="item" items="${shoesSizeList}">--%>
<%--                                                        <div class="item" data-value="${item.shoesSize}">--%>
<%--                                                            <span>${item.shoesSize}</span>--%>
<%--                                                        </div>--%>
<%--                                                    </c:forEach>--%>

<%--                                            </div>--%>

<%--                                        </div><!-- // custom_select -->--%>

<%--                                    </div><!--//option-selected-list-->--%>
<%--                                </div><!--//inner-->--%>
<%--                                <div class="bottom-wrap">--%>
<%--                                    <div class="total-price flex space-between">--%>
<%--                                        <span>총 금액</span>--%>
<%--                                        <span class="point flex al-center"><em data-type="price">0</em>원</span>--%>
<%--                                    </div>--%>
<%--                                    <div class="btn-wrap flex space-between">--%>




<%--                                        <button type="button" class="btn ty4 free w-92 c-ty2 gift" data-name="order-by" data-type="gift" data-boolean="true"><span>선물함 담기</span></button>--%>

<%--                                        <button type="button" class="btn ty4 free w-94 c-ty2" data-name="order-by" data-type=""><span>장바구니</span></button>--%>
<%--                                        <button type="button" class="btn ty4 free w-94 c-ty1" data-name="order-by" data-type="order "><span>바로구매</span></button>--%>


<%--                                    </div>--%>
<%--                                </div><!--//bottom-wrap-->--%>
<%--                            </div><!--//move-container-right-->--%>
<%--                        </div><!--//right-case-->--%>
<%--                    </div>--%>
<%--                </div><!--//goods-detail-con-->--%>


                <div class="goods-detail-recommend">



            </section>
            <!-- // 상품 상세 하단 -->
        </div><!--// goods-detail-wrap -->
    </form>

    <div class="popup-wrap discount-price-guide" active-popup="true">
        <div class="popup-layer w-430 pd-c-30">
            <div class="popup-head">
                <h5>슈슈몰 할인가 안내</h5>
                <button type="button" class="btn icon remove_19"><span class="text">닫기</span></button>
            </div>
            <div class="popup-content">
                <div class="inner">
                    <p>
                        상시 판매가 대비 슈슈 몰 내에서 혜택으로 드리는 할인가
                        입니다. 적용된 할인가는 옵션에 따라 할인 혜택이 다를 수
                        있으며 당사 사정에 따라 변경될 수 있습니다.
                    </p>
                </div>
            </div>
        </div>
    </div>

<%--상품 배송 팝업--%>
    <div class="popup-wrap deliveryPopup" active-popup="true">
        <div class="popup-layer w-430 pd-c-30">
            <div class="popup-head">
                <h5>배송 안내</h5>
                <button type="button" class="btn icon remove_19"><span class="text">닫기</span></button>
            </div>
            <div class="popup-content">
                <div class="inner">
                    <div class="mb-40" style="margin-top: 0px; margin-right: 0px; margin-left: 0px; box-sizing: border-box; border: 0px; padding: 0px; vertical-align: baseline; color: rgb(29, 29, 27); font-family: Pretendard, sans-serif; font-size: 16px; letter-spacing: -0.4px; background-color: rgb(255, 255, 255); margin-bottom: 40px !important;"><h6 class="popup-sub-tit" style="margin: 0px 0px 15px; box-sizing: border-box; border: 0px; padding: 0px; vertical-align: baseline; font-size: 18px; line-height: 21px; color: rgb(51, 51, 51);">무료배송 기준</h6><ul class="list ty3" style="margin: 0px; box-sizing: border-box; border: 0px; padding: 0px; vertical-align: baseline; list-style: none;"><li style="margin: 0px; box-sizing: border-box; border: 0px; padding: 0px 0px 0px 10px; vertical-align: baseline; position: relative; font-size: 15px; line-height: 20px; color: rgb(51, 51, 51);">상품 50,000원 이상 구매 시 무료배송</li><li style="margin: 3px 0px 0px; box-sizing: border-box; border: 0px; padding: 0px 0px 0px 10px; vertical-align: baseline; position: relative; font-size: 15px; line-height: 20px; color: rgb(51, 51, 51);">무료배송 상품 구매 시</li></ul></div><div class="mb-40" style="margin-top: 0px; margin-right: 0px; margin-left: 0px; box-sizing: border-box; border: 0px; padding: 0px; vertical-align: baseline; color: rgb(29, 29, 27); font-family: Pretendard, sans-serif; font-size: 16px; letter-spacing: -0.4px; background-color: rgb(255, 255, 255); margin-bottom: 40px !important;"><h6 class="popup-sub-tit mb-16" style="margin: 0px 0px 15px; box-sizing: border-box; border: 0px; padding: 0px; vertical-align: baseline; font-size: 18px; line-height: 21px; color: rgb(51, 51, 51);">배송 유형별 상품</h6><div class="tbl ty2 tbl-center" style="margin: 0px; box-sizing: border-box; border-width: 2px 0px 0px; border-top-style: solid; border-right-style: initial; border-bottom-style: initial; border-left-style: initial; border-top-color: rgb(51, 51, 51); border-right-color: initial; border-bottom-color: initial; border-left-color: initial; padding: 0px; border-image: initial; vertical-align: baseline;"><table class="__se_tbl_ext" style="margin: 0px; border-width: 0px; border-style: initial; border-color: inherit; padding: 0px; border-image: initial; vertical-align: baseline; table-layout: fixed; width: 350px; max-width: 100%; border-collapse: collapse; border-spacing: 0px;"><colgroup style="margin: 0px; box-sizing: border-box; border-width: 0px; border-style: solid; border-color: currentcolor;"><col style="width:120px; margin: 0px; box-sizing: border-box; border-width: 0px; border-style: solid; border-color: currentcolor;"><col style="width:auto; margin: 0px; box-sizing: border-box; border-width: 0px; border-style: solid; border-color: currentcolor;"></colgroup><tbody style="margin: 0px; box-sizing: border-box; border-width: 0px; border-style: solid; border-color: currentcolor;"><tr style="margin: 0px; box-sizing: border-box; border-width: 0px; border-style: solid; border-color: currentcolor;"><td class="fw-6" style="width:120px; margin: 0px; box-sizing: border-box; border-width: 0px 0px 1px; border-style: solid; border-color: currentcolor currentcolor rgb(238, 238, 238); font-weight: 600 !important; padding: 20px 0px; line-height: 24px;">상온 배송</td><td style="width:auto; margin: 0px; box-sizing: border-box; border-width: 0px 0px 1px; border-style: solid; border-color: currentcolor currentcolor rgb(238, 238, 238); padding: 20px 0px; line-height: 24px;"><ul class="list ty5" style="margin: 0px; box-sizing: border-box; border: 0px; padding: 0px; vertical-align: baseline; list-style: none;"><li class="etc-ty1" style="margin: 0px; box-sizing: border-box; border: 0px; padding: 0px 0px 0px 8px; vertical-align: baseline; position: relative; line-height: 29px; color: rgb(85, 85, 85);"><span class="color-1" style="margin: 0px; box-sizing: border-box; border: 0px; padding: 0px; vertical-align: baseline; color: rgb(211, 35, 58) !important;">실온</span>표기상품</li></ul></td></tr><tr style="margin: 0px; box-sizing: border-box; border-width: 0px; border-style: solid; border-color: currentcolor;"><td class="fw-6" style="width:120px; margin: 0px; box-sizing: border-box; border-width: 0px 0px 1px; border-style: solid; border-color: currentcolor currentcolor rgb(238, 238, 238); font-weight: 600 !important; padding: 20px 0px; line-height: 24px;">저온 배송</td><td style="width:auto; margin: 0px; box-sizing: border-box; border-width: 0px 0px 1px; border-style: solid; border-color: currentcolor currentcolor rgb(238, 238, 238); padding: 20px 0px; line-height: 24px;"><ul class="list ty5" style="margin: 0px; box-sizing: border-box; border: 0px; padding: 0px; vertical-align: baseline; list-style: none;"><li class="etc-ty1" style="margin: 0px; box-sizing: border-box; border: 0px; padding: 0px 0px 0px 8px; vertical-align: baseline; position: relative; line-height: 29px; color: rgb(85, 85, 85);"><span class="color-9" style="margin: 0px; box-sizing: border-box; border: 0px; padding: 0px; vertical-align: baseline; color: rgb(10, 48, 158) !important;">냉장·냉동</span>표기상품</li></ul></td></tr></tbody></table></div></div><div class="mb-40" style="margin-top: 0px; margin-right: 0px; margin-left: 0px; box-sizing: border-box; border: 0px; padding: 0px; vertical-align: baseline; color: rgb(29, 29, 27); font-family: Pretendard, sans-serif; font-size: 16px; letter-spacing: -0.4px; background-color: rgb(255, 255, 255); margin-bottom: 40px !important;"><h6 class="popup-sub-tit" style="margin: 0px 0px 15px; box-sizing: border-box; border: 0px; padding: 0px; vertical-align: baseline; font-size: 18px; line-height: 21px; color: rgb(51, 51, 51);">지역별 추가배송비</h6><ul class="list ty3" style="margin: 0px; box-sizing: border-box; border: 0px; padding: 0px; vertical-align: baseline; list-style: none;"><li style="margin: 0px; box-sizing: border-box; border: 0px; padding: 0px 0px 0px 10px; vertical-align: baseline; position: relative; font-size: 15px; line-height: 20px; color: rgb(51, 51, 51);">도서 산간 지역 추가 배송비 5,000원</li><li style="margin: 3px 0px 0px; box-sizing: border-box; border: 0px; padding: 0px 0px 0px 10px; vertical-align: baseline; position: relative; font-size: 15px; line-height: 20px; color: rgb(51, 51, 51);">제주 지역 추가 배송비 5,000원</li></ul></div><div style="margin: 0px; box-sizing: border-box; border: 0px; padding: 0px; vertical-align: baseline; background-color: rgb(255, 255, 255);"><h6 class="popup-sub-tit" style="font-family: Pretendard, sans-serif; letter-spacing: -0.4px; color: rgb(51, 51, 51); font-size: 18px; margin: 0px 0px 15px; box-sizing: border-box; border: 0px; padding: 0px; vertical-align: baseline; line-height: 21px;">배송기간</h6><ul class="list ty3" style="font-family: Pretendard, sans-serif; letter-spacing: -0.4px; color: rgb(29, 29, 27); font-size: 16px; margin: 0px; box-sizing: border-box; border: 0px; padding: 0px; vertical-align: baseline; list-style: none;"></ul><div style="font-family: Pretendard, sans-serif; letter-spacing: -0.4px;"><font color="#333333"><span style="font-size: 15px;"><br></span></font></div><div style="font-family: Pretendard, sans-serif; letter-spacing: -0.4px;"><font color="#333333"><span style="font-size: 15px;"></span></font></div><h6 class="popup-sub-tit" style="font-family: Pretendard, sans-serif; letter-spacing: -0.4px; color: rgb(51, 51, 51); font-size: 18px; margin: 0px 0px 15px; box-sizing: border-box; border: 0px; padding: 0px; vertical-align: baseline; line-height: 21px;">택배사</h6><ul class="list ty3" style="margin: 0px; box-sizing: border-box; border: 0px; padding: 0px; vertical-align: baseline; list-style: none;"><li style="color: rgb(51, 51, 51); font-family: Pretendard, sans-serif; font-size: 15px; letter-spacing: -0.4px; margin: 0px; box-sizing: border-box; border: 0px; padding: 0px 0px 0px 10px; vertical-align: baseline; position: relative; line-height: 20px;">CJ대한통운</li><li style="color: rgb(51, 51, 51); font-family: Pretendard, sans-serif; font-size: 15px; letter-spacing: -0.4px; margin: 0px; box-sizing: border-box; border: 0px; padding: 0px 0px 0px 10px; vertical-align: baseline; position: relative; line-height: 20px;">배송조회 및 문의는 마이페이지 &gt; 주문배송조회 또는 1588-1255(CJ대한통운)에서 가능합니다.&ZeroWidthSpace; 단 당사의 사정에 따라 택배사는 변경될 수 있습니다.&ZeroWidthSpace;&ZeroWidthSpace;</li></ul><div style="font-family: Pretendard, sans-serif; letter-spacing: -0.4px;"></div><div style="font-family: Pretendard, sans-serif; letter-spacing: -0.4px;"><span style="color: rgb(51, 51, 51); font-size: 15px; letter-spacing: -0.4px;"></span></div></div>
                </div>
            </div>
        </div>
    </div>


    <!-- 상품 정보 팝업 -->
    <div class="popup-wrap" id="prd-pick-detail" active-popup="true">
        <div class="popup-layer w-910">
            <div class="popup-head">
                <h4>상품정보</h4>
                <button type="button" class="btn icon remove_19" data-btn="false"><span class="text">닫기</span></button>
            </div>
            <div class="popup-content">
                <div class="inner"></div>
            </div>
        </div>
    </div>


    <!-- 상품 옵션 팝업 -->
    <div class="popup-wrap" id="prd-opt-popup"></div>

    <!-- 재고알림 신청 팝업 -->
    <div class="popup-wrap" id="prd-alarm-popup" active-popup="true"></div>

    <!-- 비밀번호 변경 안내 -->
    <div class="popup-wrap" id="updatePwPopup" active-popup="true">
        <div class="popup-layer w-510">
            <div class="popup-head">
                <h4>비밀번호 변경 안내</h4>
            </div>
            <div class="popup-content">
                <div class="inner">
                    <div class="content-title etc-ty4 mt-20">
                        <div class="inner-content ta-c w-full">
                            <h5 class="title-t ty6 icon-type5">고객님의 개인정보보호를 위해<br> 주기적으로 비밀번호를 변경해 주세요.</h5>
                            <p class="desc etc-ty1">
                                장기간 비밀번호를 변경하지 않고 동일한 비밀번호를 사용 중이신 경우, 개인정보를 안전하게 보호하고 개인정보도용으로 인한 피해를 방지하기 위해 주기적으로 비밀번호를 변경하도록 안내해 드리고 있습니다.
                            </p>
                        </div>
                    </div>
                </div>
            </div>
            <div class="popup-btn-area">
                <a href="https://www.ottogimall.co.kr/front" class="btn popup-btn ty4 c-ty8 delayPwReset" userno="352012"><span>다음에</span></a>
                <a href="https://www.ottogimall.co.kr/front/mypage/my_modify" class="btn popup-btn ty4 c-ty9 pwReset"><span>변경하기</span></a>
            </div>
        </div>
    </div>

    <!-- 약관 안내 -->
    <div class="popup-wrap" id="termPopup" active-popup="true">
        <div class="popup-layer w-910">
            <div class="popup-head">
                <h4 id="termSubject"></h4>
                <button type="button" class="btn icon remove_19"><span class="text">닫기</span></button>
            </div>
            <div class="popup-content">
                <div class="inner" id="termContent"></div>
                <div class="flex al-center mt-40" data-type="docList">
                    <p class="fz-15 color-5 mr-40" data-type="title"></p>
                    <select id="docMove" class="selectbox ty1 w-478 color-7"></select>
                </div>
            </div>
            <div class="popup-btn-area">
                <button type="button" class="btn popup-btn ty4 c-ty9" data-btn="false"><span>확인</span></button>
            </div>
        </div>
    </div>

    <!-- 공통 팝업 -->
    <div class="popup-wrap popup-alert">
        <div class="popup-layer w-360">
            <div class="popup-content"></div>
            <div class="popup-btn-area" data-btn="confirm">
                <button type="button" class="btn popup-btn ty4 c-ty8" data-btn="false"><span>취소</span></button>
                <button type="button" class="btn popup-btn ty4 c-ty9" data-btn="true"><span>확인</span></button>
            </div>
            <div class="popup-btn-area" data-btn="onlyTrue" style="display: none">
                <button type="button" class="btn popup-btn ty4 c-ty9" data-btn="true"><span>확인</span></button>
            </div>
        </div>
    </div>

    <!-- 토스트 팝업 -->
    <div class="popup-toast">
        <div class="popup-toast-content"></div>
    </div>