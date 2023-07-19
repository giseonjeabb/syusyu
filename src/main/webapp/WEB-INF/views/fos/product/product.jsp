<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--이미지리스트 길이--%>
<c:set var="imgListLength" value="${fn:length(productImages) }"/>
<c:set var="categories" value="${sessionScope.categories}"/>
<%--<head>--%>
<%--    <script src="${jsUrlFos}/product/productDetail.js" type="text/javascript" defer></script>--%>
<%--</head>--%>

<main class="">

    <script type="text/javascript" src="//www.ottogimall.co.kr/static/jscript/front/ui.share.js"></script>
    <script type="text/javascript" src="//www.ottogimall.co.kr/static/jscript/front/ui.cw.product.coupon.js"></script>
    <script type="text/javascript" src="//www.ottogimall.co.kr/static/jscript/global/jquery.pickerpack.js"></script>
    <c:forEach var="item" items="${productDetailList}">
    <div class="breadcrumb">
        <%--smallCategory--%>
        <div class="breadcrumb-inner">
            <a href="/productList">홈</a>
            <a href="/productList/${item.middleNo}">${item.middleNm}</a>
            <a href="/productList/${item.middleNo}/${item.smallNo}}">${item.smallNm}</a>
        </div>
    </div>

    <form id="frm_product" method="post">
<%--        <input type="hidden" name="pno" id="prod_no" value="916">--%>
<%--        <input type="hidden" name="cate" id="prod_cate" value="28">--%>
<%--        <input type="hidden" name="params" value="">--%>
<%--        <input type="hidden" id="opt_kind" name="optKind" value="1">--%>
<%--        <input type="hidden" id="opt_type" name="optType" value="0">--%>
<%--        <input type="hidden" id="stock_qty" name="stockQty" value="33">--%>
<%--        <input type="hidden" id="prod_sale_price" value="4380.00">--%>
<%--        <input type="hidden" id="prod_disc_event" value="">--%>
<%--        <input type="hidden" id="prod_delivery" value="" fee="3000.00" limit="30000.00">--%>
<%--        <input type="hidden" id="pdInfo" data-pno="916" data-optkind="1" data-cateidx="28">--%>
        <div class="goods-detail-wrap">
<%--            <input type="hidden" id="pdPrice" data-baseprice="4380.00" data-finalprice="4380.00" data-discrate="0">--%>
            <!-- 상품상세 상단-->
            <div class="inner-content">
                <section class="goods-top-box">
                    <div class="goods-thumbs img-slide">
                        <div thumbsslider="" class="swiper mySwiper goods-thumb-slide">
                            <div class="swiper-wrapper">

                                <div class="swiper-slide">
                                    <img src="<c:url value='${item.repImg}'/>" alt="">
                                </div>

                            </div>
                        </div>
                        <div class="swiper mySwiper2 goods-big-slide">
                            <div class="swiper-wrapper">

                                <div class="swiper-slide">
                                    <img src="<c:url value='${item.repImg}'/>" alt="">
                                </div>

                            </div>
                            <div class="swiper-pagination"></div>
                        </div>
                    </div><!--//goods_thumbs-->
                    <div class="goods-info">
                        <div class="goods-desc">
                            <div class="name">
                                <p>${item.prodNm}</p>
                                <div class="btn-wrap btn-active-wrap">
                                    <button type="button" class="btn icon like "><span class="btn-active-cont" no="916">상품 찜하기</span></button>
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
                                    <span class="star-per"><em style="width:0.0%;">평점</em></span>
                                    <span data-name="num">${item.avgStarRating}</span>
                                    <a href="#goodsReview" class="txt">${item.revwCnt}건</a>
                                </div>
                            </div><!--//star-avg-->
                            <div class="price">
                                <div class="flex al-center">
<%--                                    <fmt:formatNumber value="${item.salePrc}" pattern="#,###"/>--%>
                                     4353<span class="won">원</span>
<%--                                <c:if test="${item.salePrc != null}">--%>
<%--                                    <fmt:formatNumber value="${item.salePrc}" pattern="#,###"/><span class="won">원</span>--%>
<%--                                </c:if>--%>

                                </div>
                            </div><!--// price -->

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
                                    <span class="g-cont"><span>로그인 후 적립혜택 제공</span></span>

                                </li>
                                <li class="flex">
                                    <span class="g-tit">배송정보</span>
                                    <span class="g-cont">
                                        <span class="deli-info">
                                            <em class="fw-7">3,000</em>원
												<button type="button" class="btn ar-r icon mark tooltip-btn" onclick="bta.alert.open('.deliveryPopup');">
													<span class="ty2"></span>
												</button>
											</span>
											<p>상품 50,000원 이상 구매시 무료</p>
										</span>
                                </li>

                                <li class="flex al-center">
                                    <span class="g-tit">수량선택</span>
                                    <span class="g-cont">
											<div class="item-qty" data-name="item-total-cnt">

													<input class="item_qty_count" name="cqty" type="number" title="상품수량" value="1" maxlength="4" min="1" max="0" stock="33">


												<button type="button" class="btn icon minus"><span>상품수량 빼기</span></button>
												<button type="button" class="btn icon plus"><span>상품수량 더하기</span></button>
											</div>
										</span>
                                </li><!--// 수량 선택 -->

                                <!--옵션 선택 -->

                            </ul><!--//goods-guide-->

                            <script id="tpl_basket_product" type="text/x-handlebars-template"><!-- 선택한 상품 옵션 리스트 -->
                            <div class="option-select-item" idx="{{idx}}">
                                <p class="option-tit">
                                    <span>{{text}}</span>
                                    <button type="button" class="btn icon remove_18" data-type="del"><span>옵션삭제</span></button>
                                </p>
                                <div class="option-control-box">
                                    <div class="item-qty">
                                        <input type="hidden" name="copt" price="0" />
                                        <input class="item_qty_count" name="cqty" type="number" title="상품수량" value="1" maxlength="4" min="1" max="0" stock="0" >
                                        <button type="button" class="btn icon minus"><span>상품수량 빼기</span></button>
                                        <button type="button" class="btn icon plus"><span>상품수량 더하기</span></button>
                                    </div>
                                    <div class="option-price"><del>0원</del><span data-name="price"></span><span class="won">원</span></div>
                                </div>
                            </div>
                            </script>

                            <div class="total-price-area">
                                <div class="total-price">
                                    총금액
                                    <strong data-type="price">4,380</strong>
                                    <span class="color-1 ">원</span>
                                </div>
                            </div><!--//total-price-area-->
                            <div class="btn-area">

                                <a href="javascript:" class="btn ty4 c-ty2 icon gift" data-name="order-by" data-type="gift" data-boolean="false"><span>선물함 담기</span></a>
                                <a href="javascript:" class="btn ty4 c-ty2" data-name="order-by" data-type=""><span>장바구니</span></a>
                                <a href="javascript:" class="btn ty4 c-ty1" data-name="order-by" data-type="order "><span>바로구매</span></a>

                            </div><!--//btn-area-->

                        </div><!--//goods-desc-->
                    </div><!--//goods-info-->
                </section>
            </div>
            <!-- //상품상세 상단-->
    </c:forEach>
            <!-- 상품 상세 하단 -->
            <section class="goods-bottom-box tab-box">
                <div class="tab-group-list-wrap">
                    <div class="inner-content">
                        <ul class="tab-group-list ty2">
                            <li class="tab-menu">
                                <a href="#" class="active">상세정보</a>
                            </li>
                            <li class="tab-menu">
                                <a href="#" class="">상품후기 <span><em name="tab_review_size">${item.revwCnt}</em></span></a>
                            </li>
                            <li class="tab-menu">
                                <a href="#" class="">구매정보</a>
                            </li>
                            <li class="tab-menu">
                                <a href="#" class="">상품문의 <span><em name="tab_qna_size">0</em></span></a>
                            </li>
                        </ul><!--//tab-group-list-->
                    </div>
                </div><!--//tab-group-list-wrap-->
                <div class="goods-detail-con">
                    <div class="inner-content move-container flex">
                        <div class="tab-group-cont content-mini left-case"><!-- 상세정보 -->



                            <div class="tab-cont goods-detail-img">
                                <!-- [OPENEDITOR] --><p><span class="rte-attach" style="display: block;"></span><span class="rte-attach" style="display: block;"><span class="rte-attach" style="display: block;"><img src="https://ottogi-mall-s3.s3.ap-northeast-2.amazonaws.com/data/ottogi/yj/jinstir_1.jpg"></span><br></span><span class="rte-attach" style="display: block;"><span class="rte-attach" style="display: block;"><img src="https://ottogi-mall-s3.s3.ap-northeast-2.amazonaws.com/data/yj0038/detailpage/rice/jin ramen/5.jpg"></span></span></p>
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
                                                <span data-type="num">0</span>
                                                <span class="star-per"><em style="width: 0%;">평점</em></span>
                                                <p class="txt">총 <span name="tab_review_size">0</span>건</p>
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

                                        <div class="reviews-list-wrap" page-no="1" total-size="0" total-page="1" total-review="0" rating-avg="0" rating-star="0">


                                            <div class="list-none bt-0">
                                                <p class="msg-text">상품후기가 없습니다.</p>
                                            </div>

                                        </div><!--//reviews-list-wrap--></div><!--//def-box-content-->
                                </section>

                                <div id="ux_review_regist" class="popup-wrap" active-popup="true"></div>


                                <script type="text/javascript">
                                    // //<![CDATA[
                                    // let prodReview = {
                                    //     params: {
                                    //         psort : 'high'
                                    //     },
                                    //     page: 0,
                                    //     oncompleted: function(){},
                                    //     setParams: function(params) {
                                    //         this.params = params;
                                    //     },
                                    //     setPage: function(page) {
                                    //         this.page = page;
                                    //     },
                                    //     getList: function(options) {
                                    //         let self = this;
                                    //         let opts = $.extend({
                                    //             page : 0,
                                    //             oncompleted:function(){}
                                    //         }, options);
                                    //
                                    //         self.page = opts.page;
                                    //         $.ajax({
                                    //             type: "post",
                                    //             url: "https://www.ottogimall.co.kr/front/product/review_list.ajax",
                                    //             data: $.extend({
                                    //                 pno: '916',
                                    //                 page: self.page,
                                    //                 psort: self.psort
                                    //             }, this.params),
                                    //             success: function (result) {
                                    //                 var $result = $(result);
                                    //                 var pageNo = $result.attr('page-no'),
                                    //                     totalReview = $result.attr('total-review'),
                                    //                     ratingAvg = $result.attr('rating-avg');
                                    //                 self.page = pageNo;
                                    //                 const $container = $("#goodsReview .def-box-content");
                                    //                 $container.find(".reviews-list-wrap").remove();
                                    //                 $container.find(".pagination").remove();
                                    //                 $container.append($result);
                                    //
                                    //                 // 상품후기 평점
                                    //                 var ratingRatio = (ratingAvg * 100) / '5'.toNum();
                                    //                 $(".star-avg .avg-per span[data-type='num']").text(ratingAvg);
                                    //                 $('.star-avg .avg-per').find('em').css({width: ratingRatio+'%'});
                                    //
                                    //                 // 상품후기 탭 > 후기 개수 설정
                                    //                 $("[name='tab_review_size']").text(function() {
                                    //                     return (totalReview>9999 ? "9,999+" : totalReview);
                                    //                 });
                                    //
                                    //                 // 더보기 버튼
                                    //                 $(".rev-list .rev-detail .rev-cont").filter(function(){
                                    //                     return $(this).outerHeight() >= 43
                                    //                 }).next(".review-more").show();
                                    //
                                    //                 opts.oncompleted();
                                    //             }
                                    //         });
                                    //     },
                                    //     getPhoto: function() { // 사용 X
                                    //         $.ajax({
                                    //             type: "post",
                                    //             dataType: "json",
                                    //             url: "https://www.ottogimall.co.kr/front/product/review_photo_lastly.ajax",
                                    //             data: {
                                    //                 pno: '916'
                                    //             },
                                    //             success: function (result) {
                                    //                 if (result.error > 0) return false;
                                    //
                                    //                 var $box = $('#review_photo_lastly'),
                                    //                     $count = $box.find('.count');
                                    //
                                    //                 $box.children(':not(.count)').remove();
                                    //
                                    //                 $.each(result.data.list, function(i, obj) {
                                    //                     var $row = $('<li />'),
                                    //                         $a = $('<a href="#" idx="'+obj.idx+'" />').appendTo($row),
                                    //                         $img = $('<img src="'+obj.photoUrl+'" alt="" />').appendTo($a);
                                    //
                                    //                     $count.before($row);
                                    //                 });
                                    //
                                    //                 if (result.data.size > 4) {
                                    //                     $count.removeClass('blind').find('span').text(function() {
                                    //                         return "("+(result.data.size>999 ? "999+" : result.data.size)+")";
                                    //                     });
                                    //                 } else {
                                    //                     $count.addClass('blind').find('span').text('');
                                    //                 }
                                    //             }
                                    //         });
                                    //     }
                                    // };
                                    //
                                    // $(function() {
                                    //     prodReview.getList();
                                    //
                                    //     // 후기 작성
                                    //     $("a[data-type='review_regist']").on("click", function(){
                                    //         bta.opener.reviewRegist({
                                    //             type : "product",
                                    //             pno: 916,
                                    //             oncompleted: function() {
                                    //                 prodReview.getList();
                                    //             }
                                    //         });
                                    //     });
                                    //
                                    //     // 상품 후기 수정
                                    //     $(document).on('click', ".reviews-list-wrap button[data-type='modify']", function() {
                                    //         bta.opener.reviewRegist({
                                    //             type : "product",
                                    //             pno: 916,
                                    //             idx: $(this).parents(".rev-list").data("idx"),
                                    //             oncompleted: function() {
                                    //                 prodReview.getList();
                                    //             }
                                    //         });
                                    //     });
                                    //
                                    //     // 상품 후기 삭제
                                    //     $(document).on('click', ".reviews-list-wrap button[data-type='del']", function() {
                                    //         let revIdx = $(this).parents(".rev-list").data("idx");
                                    //         bta.alert.confirmCustom("소중하게 작성하신 후기를 삭제 하시겠습니까?","네, 삭제할게요", "그럼 안할게요",function(res){
                                    //             if(res){
                                    //                 $.ajax({
                                    //                     type : 'post',
                                    //                     url: URI_FRONT_MW+"/mypage/shop.act",
                                    //                     data: $.extend({
                                    //                         pno: 916,
                                    //                         idx: revIdx,
                                    //                         exec:"review",
                                    //                         cmd :"remove",
                                    //                     }, this.params),
                                    //                     success: function(result) {
                                    //                         if (result.message) bta.alert.open(".popup-alert", result.message);
                                    //                         if (result.error > 0) return false;
                                    //
                                    //                         prodReview.getList();
                                    //                     }
                                    //                 });
                                    //             }
                                    //         });
                                    //     });
                                    //
                                    //     // 상품 후기 정렬
                                    //     $('#goodsReview .sorting a').on('click', function() {
                                    //         let stype = $("#goodsReview .sorting input[name='filter-photo']").is(":checked") ? 'photo' : '';
                                    //         if(!$(this).hasClass("active")){
                                    //             $('#goodsReview .sorting a').removeClass("active");
                                    //             $(this).addClass("active");
                                    //         }else{
                                    //             return false;
                                    //         }
                                    //         prodReview.setParams({
                                    //             stype: stype,
                                    //             psort: $(this).attr("combo-list-item")
                                    //         });
                                    //         prodReview.getList();
                                    //     });
                                    //
                                    //
                                    //     // 포토 후기만 보기
                                    //     $(document).on('click', "#goodsReview .sorting input[name='filter-photo']", function() {
                                    //         let psort = $('#goodsReview .sorting a.active').attr("combo-list-item");
                                    //         if ($(this).is(":checked")) {
                                    //             prodReview.setParams({
                                    //                 stype: 'photo',
                                    //                 psort: psort
                                    //             });
                                    //         }else{
                                    //             prodReview.setParams({
                                    //                 psort: psort
                                    //             });
                                    //         }
                                    //         prodReview.getList();
                                    //     });
                                    //
                                    //     // 상품 후기 페이징
                                    //     $(document).on('click', '#goodsReview .pagination a', function() {
                                    //         var page = $(this).attr('page');
                                    //         if ($('.reviews-list-wrap').attr('page-no') == page) {
                                    //             return false;
                                    //         }
                                    //
                                    //         prodReview.getList({
                                    //             page : page,
                                    //             oncompleted : function(){
                                    //                 $(".tab-group-list .tab-menu a").eq(1).click();
                                    //             }
                                    //         });
                                    //         return false; // 기존 pagination href 페이지 이동 false;
                                    //     });
                                    //
                                    //
                                    // });
                                    // //]]>
                                </script>
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
                                                    <td>상품설명 및 상품 이미지 참조</td>
                                                </tr>

                                                <tr>
                                                    <th>식품의 유형</th>
                                                    <td>상품설명 및 상품 이미지 참조</td>
                                                </tr>

                                                <tr>
                                                    <th>생산자 및 소재지</th>
                                                    <td>상품설명 및 상품 이미지 참조</td>
                                                </tr>

                                                <tr>
                                                    <th>제조 년원일, 소비기한</th>
                                                    <td>제품 별도 라벨 표기 참조</td>
                                                </tr>

                                                <tr>
                                                    <th>포장단위별 내용물의 용량(중량),수량</th>
                                                    <td>상품설명 및 상품 이미지 참조</td>
                                                </tr>

                                                <tr>
                                                    <th>원재료명 및 함량(농수산물의 원산지 표시에 관한 법률에 따른 원산지 표시 포함)</th>
                                                    <td>상품설명 및 상품 이미지 참조</td>
                                                </tr>

                                                <tr>
                                                    <th>영양성분(식품 등의 표시·광고에 관한 법률에 따른 영향성분 표시 대상 식품에 한함)</th>
                                                    <td>상품설명 및 상품 이미지 참조</td>
                                                </tr>

                                                <tr>
                                                    <th>유전자변형식품에 해당하는 경우의 표시</th>
                                                    <td>해당 없음</td>
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
                                                    <th>소비자 상담 관련 전화번호</th>
                                                    <td>오뚜기 고객상담실 : 080-024-2311(수신자 요금 부담)</td>
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
                                        <p>&nbsp;</p><div class="con mb-40" style="margin: 0px 0px 44px; box-sizing: border-box; border: 0px; padding: 0px; vertical-align: baseline; color: rgb(29, 29, 27); font-family: Pretendard, sans-serif; font-size: 16px; letter-spacing: -0.4px;"><h6 class="sub-tit" style="margin: 0px 0px 10px; box-sizing: border-box; border: 0px; padding: 0px; vertical-align: baseline; font-size: 16px;">[배송비 기본]</h6><ul class="list ty1" style="margin: 0px; box-sizing: border-box; border: 0px; padding: 0px; vertical-align: baseline; list-style: none;"><li style="margin: 0px; box-sizing: border-box; border: 0px; padding: 0px 0px 0px 8px; vertical-align: baseline; position: relative; font-size: 15px; line-height: 26px; color: rgb(51, 51, 51);">기본 배송료는 3,000원입니다.&ZeroWidthSpace;</li><li style="margin: 2px 0px 0px; box-sizing: border-box; border: 0px; padding: 0px 0px 0px 8px; vertical-align: baseline; position: relative; font-size: 15px; line-height: 26px; color: rgb(51, 51, 51);"></li><li style="margin: 2px 0px 0px; box-sizing: border-box; border: 0px; padding: 0px 0px 0px 8px; vertical-align: baseline; position: relative; font-size: 15px; line-height: 26px; color: rgb(51, 51, 51);">오뚜기몰은 배송 유형별 분리 배송을 원칙으로 하며, 배송 유형별로 배송비가 부과됩니다.<br style="box-sizing: border-box; border-width: 0px; border-style: solid; border-color: currentcolor;">(도서산간지역은 5,000원의 추가 배송비가 부과되며, 배송이 제한될 수 있습니다.)<br style="box-sizing: border-box; border-width: 0px; border-style: solid; border-color: currentcolor;">(단, 선물받는 사람이 도서산간 지역이어도 선물하기에서는 기본 배송료만 부과합니다.)&ZeroWidthSpace;</li></ul></div><div class="con mb-40" style="margin: 0px 0px 44px; box-sizing: border-box; border: 0px; padding: 0px; vertical-align: baseline; color: rgb(29, 29, 27); font-family: Pretendard, sans-serif; font-size: 16px; letter-spacing: -0.4px;"><h6 class="sub-tit" style="margin: 0px 0px 10px; box-sizing: border-box; border: 0px; padding: 0px; vertical-align: baseline; font-size: 16px;">[무료배송 기준]</h6><ul class="list ty1" style="margin: 0px; box-sizing: border-box; border: 0px; padding: 0px; vertical-align: baseline; list-style: none;"><li style="margin: 0px; box-sizing: border-box; border: 0px; padding: 0px 0px 0px 8px; vertical-align: baseline; position: relative; font-size: 15px; line-height: 26px; color: rgb(51, 51, 51);"></li><li style="margin: 0px; box-sizing: border-box; border: 0px; padding: 0px 0px 0px 8px; vertical-align: baseline; position: relative; font-size: 15px; line-height: 26px; color: rgb(51, 51, 51);">무료배송 혜택 상품 및 배송 유형별 30,000원 이상 구매 시 무료배송입니다.&ZeroWidthSpace;</li><li style="margin: 2px 0px 0px; box-sizing: border-box; border: 0px; padding: 0px 0px 0px 8px; vertical-align: baseline; position: relative; font-size: 15px; line-height: 26px; color: rgb(51, 51, 51);"></li><li style="margin: 2px 0px 0px; box-sizing: border-box; border: 0px; padding: 0px 0px 0px 8px; vertical-align: baseline; position: relative; font-size: 15px; line-height: 26px; color: rgb(51, 51, 51);">배송 유형 간 교차 합계 금액은 무료배송에 적용되지 않습니다.&ZeroWidthSpace;<br style="box-sizing: border-box; border-width: 0px; border-style: solid; border-color: currentcolor;">(실온 배송 + 냉장냉동 상품의 합계가 30,000원 이상이어도 무료배송 불가)&ZeroWidthSpace;<br style="box-sizing: border-box; border-width: 0px; border-style: solid; border-color: currentcolor;">(단, 무료배송 상품이 포함되어있는 주문 전체에는 무료배송이 적용됩니다)</li></ul></div><div class="con mb-40" style="margin: 0px 0px 44px; box-sizing: border-box; border: 0px; padding: 0px; vertical-align: baseline; color: rgb(29, 29, 27); font-family: Pretendard, sans-serif; font-size: 16px; letter-spacing: -0.4px;"><h6 class="sub-tit" style="margin: 0px 0px 10px; box-sizing: border-box; border: 0px; padding: 0px; vertical-align: baseline; font-size: 16px;">[출고일]</h6><ul class="list ty1" style="margin: 0px; box-sizing: border-box; border: 0px; padding: 0px; vertical-align: baseline; list-style: none;"><li style="margin: 0px; box-sizing: border-box; border: 0px; padding: 0px 0px 0px 8px; vertical-align: baseline; position: relative; font-size: 15px; line-height: 26px; color: rgb(51, 51, 51);"></li><li style="margin: 0px; box-sizing: border-box; border: 0px; padding: 0px 0px 0px 8px; vertical-align: baseline; position: relative; font-size: 15px; line-height: 26px; color: rgb(51, 51, 51);">13시 이전 결제 완료 시 당일 출고&ZeroWidthSpace;</li><li style="margin: 2px 0px 0px; box-sizing: border-box; border: 0px; padding: 0px 0px 0px 8px; vertical-align: baseline; position: relative; font-size: 15px; line-height: 26px; color: rgb(51, 51, 51);"></li><li style="margin: 2px 0px 0px; box-sizing: border-box; border: 0px; padding: 0px 0px 0px 8px; vertical-align: baseline; position: relative; font-size: 15px; line-height: 26px; color: rgb(51, 51, 51);">13시 이후 결제 완료 시 명일 출고&ZeroWidthSpace;</li><span id="husky_bookmark_end_1675910884026"></span><li style="margin: 2px 0px 0px; box-sizing: border-box; border: 0px; padding: 0px 0px 0px 8px; vertical-align: baseline; position: relative; font-size: 15px; line-height: 26px; color: rgb(51, 51, 51);"></li><li style="margin: 2px 0px 0px; box-sizing: border-box; border: 0px; padding: 0px 0px 0px 8px; vertical-align: baseline; position: relative; font-size: 15px; line-height: 26px; color: rgb(51, 51, 51);">재고 부족 등으로 출고가 불가할 경우 배송 가능한 상품은 선배송 처리되며, 알림톡 또는 SMS로 안내 드립니다.&ZeroWidthSpace;</li></ul></div><div class="con mb-40" style="margin: 0px 0px 44px; box-sizing: border-box; border: 0px; padding: 0px; vertical-align: baseline; font-family: Pretendard, sans-serif; letter-spacing: -0.4px;"><h6 class="sub-tit" style="color: rgb(29, 29, 27); font-size: 16px; margin: 0px 0px 10px; box-sizing: border-box; border: 0px; padding: 0px; vertical-align: baseline;">[배송기간]&ZeroWidthSpace;</h6><ul class="list ty1" style="color: rgb(29, 29, 27); font-size: 16px; margin: 0px; box-sizing: border-box; border: 0px; padding: 0px; vertical-align: baseline; list-style: none;"><li style="margin: 0px; box-sizing: border-box; border: 0px; padding: 0px 0px 0px 8px; vertical-align: baseline; position: relative; font-size: 15px; line-height: 26px; color: rgb(51, 51, 51);"></li><li style="margin: 0px; box-sizing: border-box; border: 0px; padding: 0px 0px 0px 8px; vertical-align: baseline; position: relative; font-size: 15px; line-height: 26px; color: rgb(51, 51, 51);">평균 배송일은 연휴 및 공휴일을 제외한 영업일 기준, 입금/결제 확인 후 2일~4일입니다.&ZeroWidthSpace;</li><li style="margin: 2px 0px 0px; box-sizing: border-box; border: 0px; padding: 0px 0px 0px 8px; vertical-align: baseline; position: relative; font-size: 15px; line-height: 26px; color: rgb(51, 51, 51);"></li><li style="margin: 2px 0px 0px; box-sizing: border-box; border: 0px; padding: 0px 0px 0px 8px; vertical-align: baseline; position: relative; font-size: 15px; line-height: 26px; color: rgb(51, 51, 51);">배송 예정일은 주문시점에 따라 평균 배송일과 다를 수 있습니다.&ZeroWidthSpace;</li></ul><div style=""><font color="#333333"><span style="font-size: 15px;"><br></span></font></div><div style=""><font color="#333333"><span style="font-size: 15px;"><br></span></font></div><div style=""><font color="#333333"><span style="font-size: 15px;"></span></font></div><h6 class="sub-tit" style="letter-spacing: -0.4px; margin: 0px 0px 10px; box-sizing: border-box; border: 0px; padding: 0px; vertical-align: baseline; font-size: 16px; color: rgb(29, 29, 27);">[택배사]&ZeroWidthSpace;</h6><ul class="list ty1" style="letter-spacing: -0.4px; margin: 0px; box-sizing: border-box; border: 0px; padding: 0px; vertical-align: baseline; list-style: none; color: rgb(29, 29, 27); font-size: 16px;"><li style="margin: 0px; box-sizing: border-box; border: 0px; padding: 0px 0px 0px 8px; vertical-align: baseline; position: relative; font-size: 15px; line-height: 26px; color: rgb(51, 51, 51);"><b>롯데택배</b>&ZeroWidthSpace;</li><li style="margin: 2px 0px 0px; box-sizing: border-box; border: 0px; padding: 0px 0px 0px 8px; vertical-align: baseline; position: relative; font-size: 15px; line-height: 26px; color: rgb(51, 51, 51);">배송조회 및 문의는 마이페이지 &gt; 주문배송조회 또는 1588-2121(롯데택배)에서 가능합니다.&ZeroWidthSpace;</li><li style="margin: 2px 0px 0px; box-sizing: border-box; border: 0px; padding: 0px 0px 0px 8px; vertical-align: baseline; position: relative; font-size: 15px; line-height: 26px; color: rgb(51, 51, 51);">단 당사의 사정에 따라 택배사는 변경될 수 있습니다.&ZeroWidthSpace;&ZeroWidthSpace;</li></ul><div style=""><span style="letter-spacing: -0.4px;">&nbsp;</span><font color="#333333"><span style="font-size: 15px;"><br></span></font></div></div>
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

                                <script type="text/javascript">
                                    //<![CDATA[
                                    let prodQna = {
                                        params: {},
                                        page: 0,
                                        setParams: function(params) {
                                            this.params = params;
                                        },
                                        setPage: function(page) {
                                            this.page = page;
                                        },
                                        getList: function(options) {
                                            let self = this;
                                            let opts = $.extend({
                                                page : 0,
                                                oncompleted:function(){}
                                            }, options);

                                            self.page = opts.page;

                                            $.ajax({
                                                type: "post",
                                                url: "https://www.ottogimall.co.kr/front/product/qna_list.ajax",
                                                data: $.extend({
                                                    pno: '916',
                                                    page: this.page
                                                }, this.params),
                                                success: function (result) {
                                                    var $result = $(result);
                                                    var pageNo = $result.attr("page-no"),
                                                        totalSize = $result.attr("total-size"),
                                                        totalPage = $result.attr("total-page"),
                                                        totalQna = $result.attr("total-qna");

                                                    self.page = pageNo;
                                                    const $container = $(".goods-qna");
                                                    $container.find(".goods-qna-list-wrap").remove();
                                                    $container.append($result);

                                                    // 상품문의 탭 > 문의 개수 설정
                                                    $("[name='tab_qna_size']").text(function() {
                                                        return (totalQna>9999 ? "9,999+" : totalQna);
                                                    });

                                                    opts.oncompleted();
                                                }
                                            });
                                        }
                                    };

                                    $(function() {
                                        prodQna.getList();

                                        $('#qna_mine').on('change', function() { // 내 문의만 보기

                                            $(this).prop("checked", false);
                                            bta.alert.confirm("로그인이 필요한 서비스입니다.<br>로그인 하시겠습니까?",function(res){
                                                if(res){
                                                    bta.forceLogin();
                                                }
                                            });
                                            return false;

                                            prodQna.setParams({
                                                smine: ($('#qna_mine').is(':checked') ? 1 : 0)
                                            });
                                            prodQna.getList();
                                        });

                                        // 상품 문의 작성하기
                                        $('.bt-qna-regist').on('click', function() {
                                            bta.opener.qnaRegist({
                                                pno: 916,
                                                oncompleted: function(idx) {
                                                    if (! idx) {
                                                        prodQna.setParams({
                                                            smine: ($('#qna_mine').is(':checked') ? 1 : 0),
                                                        });
                                                        prodQna.setPage(0);
                                                    }
                                                    prodQna.getList();
                                                }
                                            });
                                        });

                                        // 상품 문의 수정
                                        $(document).on('click', "a[type='modify']", function() {
                                            bta.opener.qnaRegist({
                                                pno: 916,
                                                idx: $(this).parents(".qna-list").data("idx"),
                                                cmd: 'modify',
                                                oncompleted: function(idx) {
                                                    if (! idx) {
                                                        prodQna.setParams({
                                                            smine: ($('#qna_mine').is(':checked') ? 1 : 0),
                                                        });
                                                        prodQna.setPage(0);
                                                    }
                                                    prodQna.getList();
                                                }
                                            });
                                        });

                                        // 상품 문의 삭제
                                        $(document).on('click', "a[type='del']", function() {
                                            $.ajax({
                                                type : 'post',
                                                url: URI_FRONT_CW+"/product/qna.act",
                                                data: $.extend({
                                                    pno: 916,
                                                    idx: $(this).parents(".qna-list").data("idx"),
                                                    cmd : "remove",
                                                }, this.params),
                                                success: function(result) {
                                                    if (result.message) bta.alert.open(".popup-alert", result.message);
                                                    if (result.error > 0) return false;
                                                    bta.alert.open(".popup-alert", "상품문의가 삭제되었습니다.");
                                                    prodQna.setParams({
                                                        smine: ($('#qna_mine').is(':checked') ? 1 : 0),
                                                    });

                                                    prodQna.getList();
                                                }
                                            });
                                        });

                                        $(document).on('click', '.detail-more-btn.secret', function(){
                                            bta.alert.toastOpen(".popup-toast", "비공개 문의는 작성자 본인만 확인할 수 있습니다.");
                                        });

                                        // 상품문의 페이징
                                        $(document).on('click', '.goods-qna-list-wrap .pagination a', function() {
                                            var page = $(this).attr('page');
                                            if ($('.goods-qna-list-wrap').attr('page-no') == page) {
                                                return false;
                                            }

                                            prodQna.getList({
                                                page : page,
                                                oncompleted : function(){
                                                    $(".tab-group-list .tab-menu a").eq(3).click();
                                                    // $('html, body').animate({scrollTop: $('.goods-qna-list-wrap').offset().top - 200}, 0);
                                                }
                                            });
                                            return false; // 기존 pagination href 페이지 이동 false;
                                        });
                                    });
                                    //]]>
                                </script>


                                <div class="goods-qna-list-wrap" page-no="1" total-size="0" total-page="1" total-qna="0">


                                    <div class="list-none bt-0">
                                        <p class="msg-text">상품문의가 없습니다.</p>
                                    </div>



                                </div><!--//goods-qna-list-wrap--></div>
                            <!-- //상품문의 -->
                        </div><!-- //상세정보 left-case -->
                        <div class="right-case">
                            <div class="move-container-right">
                                <div class="inner">
                                    <div class="option-selected-list">






                                        <div class="option-select-item">

                                            <p class="option-tit">진라면볶음밥 230G</p>


                                            <div class="option-control-box">
                                                <div class="item-qty">

                                                    <input class="item_qty_count" name="cqty" type="number" title="상품수량" value="1" maxlength="4" min="1" max="0" stock="33">


                                                    <button type="button" class="btn icon minus"><span>상품수량 빼기</span></button>
                                                    <button type="button" class="btn icon plus"><span>상품수량 더하기</span></button>
                                                </div>
                                                <div class="option-price">

                                                    <span>4,380원</span>
                                                </div>
                                            </div>
                                        </div>

                                    </div><!--//option-selected-list-->
                                </div><!--//inner-->
                                <div class="bottom-wrap">
                                    <div class="total-price flex space-between">
                                        <span>총 금액</span>
                                        <span class="point flex al-center"><em data-type="price">4,380</em>원</span>
                                    </div>
                                    <div class="btn-wrap flex space-between">




                                        <button type="button" class="btn ty4 free w-92 c-ty2 gift" data-name="order-by" data-type="gift" data-boolean="false"><span>선물함 담기</span></button>

                                        <button type="button" class="btn ty4 free w-94 c-ty2" data-name="order-by" data-type=""><span>장바구니</span></button>
                                        <button type="button" class="btn ty4 free w-94 c-ty1" data-name="order-by" data-type="order "><span>바로구매</span></button>


                                    </div>
                                </div><!--//bottom-wrap-->
                            </div><!--//move-container-right-->
                        </div><!--//right-case-->
                    </div>
                </div><!--//goods-detail-con-->


                <div class="goods-detail-recommend">


                    <div class="inner-content"><!--함께 구매하면 더 좋은 상품-->
                        <section class="def-box">
                            <div class="def-box-head">
                                <h4 class="tit">함께 구매하면 더 좋은 상품</h4>
                            </div>
                            <div class="def-box-content l-wrap">
                                <div class="sw-box etc-ty2">
                                    <div class="sw-cont sw-items normal-type n4" data-nth="4" data-swsb="40">
                                        <div class="swiper-wrapper">




                                            <div class="swiper-slide">
                                                <div class="prd-item">
                                                    <div class="thumbs hover">
                                                        <a href="https://lc.recopick.com/1/banner/3365/pick?uid=27761726.1687853370651&amp;source=916&amp;pick=886&amp;method=4&amp;channel=detail_down&amp;reco_type=item-item&amp;product_type=R&amp;reco_list=%5B%22886%22%2C%22882%22%2C%22885%22%2C%22888%22%5D&amp;tag=V" target="_self">
                                                            <img src="https://ottogi-mall-s3.s3.ap-northeast-2.amazonaws.com/data/product/list/20221125/1687848566410jtbFu.1hbghv3g8o411.jpg" alt="맛있는 참치김치치즈볶음밥(용기) 230G">
                                                        </a>
                                                    </div>
                                                    <div class="desc">
                                                        <a href="https://lc.recopick.com/1/banner/3365/pick?uid=27761726.1687853370651&amp;source=916&amp;pick=886&amp;method=4&amp;channel=detail_down&amp;reco_type=item-item&amp;product_type=R&amp;reco_list=%5B%22886%22%2C%22882%22%2C%22885%22%2C%22888%22%5D&amp;tag=V" target="_self">
                                                            <p class="name fw-7">맛있는 참치김치치즈볶음밥(용기) 230G</p>
                                                            <div class="price">



                                                                <p class="amount">
                                                                    3,580<span class="won">원</span>
                                                                </p>


                                                            </div>
                                                            <div class="grade">
                                                                <strong>5.0</strong>
                                                                <span>(2)</span><!-- 리뷰 -->
                                                            </div><!-- // grade -->
                                                            <div class="badge-cont">


                                                                <span class="badge-item ty3">냉장&amp;냉동</span>


                                                            </div>
                                                        </a>
                                                        <div class="prd-item-btn">
                                                            <button type="button" class="btn icon cart add-cart-bt"><span class="text">장바구니 담기</span></button>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>




                                            <div class="swiper-slide">
                                                <div class="prd-item">
                                                    <div class="thumbs hover">
                                                        <a href="https://lc.recopick.com/1/banner/3365/pick?uid=27761726.1687853370651&amp;source=916&amp;pick=882&amp;method=4&amp;channel=detail_down&amp;reco_type=item-item&amp;product_type=R&amp;reco_list=%5B%22886%22%2C%22882%22%2C%22885%22%2C%22888%22%5D&amp;tag=V" target="_self">
                                                            <img src="https://ottogi-mall-s3.s3.ap-northeast-2.amazonaws.com/data/product/list/20221125/23010020_1.jpg" alt="맛있는 새우볶음밥(용기) 230G">
                                                        </a>
                                                    </div>
                                                    <div class="desc">
                                                        <a href="https://lc.recopick.com/1/banner/3365/pick?uid=27761726.1687853370651&amp;source=916&amp;pick=882&amp;method=4&amp;channel=detail_down&amp;reco_type=item-item&amp;product_type=R&amp;reco_list=%5B%22886%22%2C%22882%22%2C%22885%22%2C%22888%22%5D&amp;tag=V" target="_self">
                                                            <p class="name fw-7">맛있는 새우볶음밥(용기) 230G</p>
                                                            <div class="price">



                                                                <p class="amount">
                                                                    3,280<span class="won">원</span>
                                                                </p>


                                                            </div>
                                                            <div class="grade">
                                                                <strong>5.0</strong>
                                                                <span>(1)</span><!-- 리뷰 -->
                                                            </div><!-- // grade -->
                                                            <div class="badge-cont">


                                                                <span class="badge-item ty3">냉장&amp;냉동</span>


                                                            </div>
                                                        </a>
                                                        <div class="prd-item-btn">
                                                            <button type="button" class="btn icon cart add-cart-bt"><span class="text">장바구니 담기</span></button>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>




                                            <div class="swiper-slide">
                                                <div class="prd-item">
                                                    <div class="thumbs hover">
                                                        <a href="https://lc.recopick.com/1/banner/3365/pick?uid=27761726.1687853370651&amp;source=916&amp;pick=885&amp;method=4&amp;channel=detail_down&amp;reco_type=item-item&amp;product_type=R&amp;reco_list=%5B%22886%22%2C%22882%22%2C%22885%22%2C%22888%22%5D&amp;tag=V" target="_self">
                                                            <img src="https://ottogi-mall-s3.s3.ap-northeast-2.amazonaws.com/data/product/list/20221125/1687848462657irJJ8.1hbd9px084ab4.jpg" alt="맛있는 베이컨치즈볶음밥(용기) 230G">
                                                        </a>
                                                    </div>
                                                    <div class="desc">
                                                        <a href="https://lc.recopick.com/1/banner/3365/pick?uid=27761726.1687853370651&amp;source=916&amp;pick=885&amp;method=4&amp;channel=detail_down&amp;reco_type=item-item&amp;product_type=R&amp;reco_list=%5B%22886%22%2C%22882%22%2C%22885%22%2C%22888%22%5D&amp;tag=V" target="_self">
                                                            <p class="name fw-7">맛있는 베이컨치즈볶음밥(용기) 230G</p>
                                                            <div class="price">



                                                                <p class="amount">
                                                                    3,580<span class="won">원</span>
                                                                </p>


                                                            </div>
                                                            <div class="grade">
                                                                <strong>0.0</strong>
                                                                <span>(0)</span><!-- 리뷰 -->
                                                            </div><!-- // grade -->
                                                            <div class="badge-cont">


                                                                <span class="badge-item ty3">냉장&amp;냉동</span>


                                                            </div>
                                                        </a>
                                                        <div class="prd-item-btn">
                                                            <button type="button" class="btn icon cart add-cart-bt"><span class="text">장바구니 담기</span></button>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>




                                            <div class="swiper-slide">
                                                <div class="prd-item">
                                                    <div class="thumbs hover">
                                                        <a href="https://lc.recopick.com/1/banner/3365/pick?uid=27761726.1687853370651&amp;source=916&amp;pick=888&amp;method=4&amp;channel=detail_down&amp;reco_type=item-item&amp;product_type=R&amp;reco_list=%5B%22886%22%2C%22882%22%2C%22885%22%2C%22888%22%5D&amp;tag=V" target="_self">
                                                            <img src="https://ottogi-mall-s3.s3.ap-northeast-2.amazonaws.com/data/product/list/20221125/23010048_1.jpg" alt="오즈키친 철판낙지볶음밥 450G">
                                                        </a>
                                                    </div>
                                                    <div class="desc">
                                                        <a href="https://lc.recopick.com/1/banner/3365/pick?uid=27761726.1687853370651&amp;source=916&amp;pick=888&amp;method=4&amp;channel=detail_down&amp;reco_type=item-item&amp;product_type=R&amp;reco_list=%5B%22886%22%2C%22882%22%2C%22885%22%2C%22888%22%5D&amp;tag=V" target="_self">
                                                            <p class="name fw-7">오즈키친 철판낙지볶음밥 450G</p>
                                                            <div class="price">



                                                                <p class="amount">
                                                                    7,580<span class="won">원</span>
                                                                </p>


                                                            </div>
                                                            <div class="grade">
                                                                <strong>0.0</strong>
                                                                <span>(0)</span><!-- 리뷰 -->
                                                            </div><!-- // grade -->
                                                            <div class="badge-cont">


                                                                <span class="badge-item ty3">냉장&amp;냉동</span>


                                                            </div>
                                                        </a>
                                                        <div class="prd-item-btn">
                                                            <button type="button" class="btn icon cart add-cart-bt"><span class="text">장바구니 담기</span></button>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>

                                        </div>
                                    </div><!--//sw-cont-->
                                    <div class="swiper-nav-btn swiper-button-prev big swbp"></div>
                                    <div class="swiper-nav-btn swiper-button-next big swbn"></div>
                                </div><!--//sw-box-->
                            </div><!--//def-box-content-->
                        </section>
                    </div><!-- // 함께 구매하면 더 좋은 상품-->

                </div><!--//goods-detail-recommend-->

            </section>
            <!-- // 상품 상세 하단 -->
        </div><!--// goods-detail-wrap -->
    </form>

    <div class="popup-wrap discount-price-guide" active-popup="true">
        <div class="popup-layer w-430 pd-c-30">
            <div class="popup-head">
                <h5>오뚜기몰 할인가 안내</h5>
                <button type="button" class="btn icon remove_19"><span class="text">닫기</span></button>
            </div>
            <div class="popup-content">
                <div class="inner">
                    <p>
                        상시 판매가 대비 오뚜기 몰 내에서 혜택으로 드리는 할인가
                        입니다. 적용된 할인가는 옵션에 따라 할인 혜택이 다를 수
                        있으며 당사 사정에 따라 변경될 수 있습니다.
                    </p>
                </div>
            </div>
        </div>
    </div>

    <div class="popup-wrap deliveryPopup" active-popup="true">
        <div class="popup-layer w-430 pd-c-30">
            <div class="popup-head">
                <h5>배송 안내</h5>
                <button type="button" class="btn icon remove_19"><span class="text">닫기</span></button>
            </div>
            <div class="popup-content">
                <div class="inner">
                    <div class="mb-40" style="margin-top: 0px; margin-right: 0px; margin-left: 0px; box-sizing: border-box; border: 0px; padding: 0px; vertical-align: baseline; color: rgb(29, 29, 27); font-family: Pretendard, sans-serif; font-size: 16px; letter-spacing: -0.4px; background-color: rgb(255, 255, 255); margin-bottom: 40px !important;"><h6 class="popup-sub-tit" style="margin: 0px 0px 15px; box-sizing: border-box; border: 0px; padding: 0px; vertical-align: baseline; font-size: 18px; line-height: 21px; color: rgb(51, 51, 51);">무료배송 기준</h6><ul class="list ty3" style="margin: 0px; box-sizing: border-box; border: 0px; padding: 0px; vertical-align: baseline; list-style: none;"><li style="margin: 0px; box-sizing: border-box; border: 0px; padding: 0px 0px 0px 10px; vertical-align: baseline; position: relative; font-size: 15px; line-height: 20px; color: rgb(51, 51, 51);">동일배송 유형별 상품 30,000원 이상 구매 시 무료배송</li><li style="margin: 3px 0px 0px; box-sizing: border-box; border: 0px; padding: 0px 0px 0px 10px; vertical-align: baseline; position: relative; font-size: 15px; line-height: 20px; color: rgb(51, 51, 51);">무료배송 상품 구매 시</li></ul></div><div class="mb-40" style="margin-top: 0px; margin-right: 0px; margin-left: 0px; box-sizing: border-box; border: 0px; padding: 0px; vertical-align: baseline; color: rgb(29, 29, 27); font-family: Pretendard, sans-serif; font-size: 16px; letter-spacing: -0.4px; background-color: rgb(255, 255, 255); margin-bottom: 40px !important;"><h6 class="popup-sub-tit mb-16" style="margin: 0px 0px 15px; box-sizing: border-box; border: 0px; padding: 0px; vertical-align: baseline; font-size: 18px; line-height: 21px; color: rgb(51, 51, 51);">배송 유형별 상품</h6><div class="tbl ty2 tbl-center" style="margin: 0px; box-sizing: border-box; border-width: 2px 0px 0px; border-top-style: solid; border-right-style: initial; border-bottom-style: initial; border-left-style: initial; border-top-color: rgb(51, 51, 51); border-right-color: initial; border-bottom-color: initial; border-left-color: initial; padding: 0px; border-image: initial; vertical-align: baseline;"><table class="__se_tbl_ext" style="margin: 0px; border-width: 0px; border-style: initial; border-color: inherit; padding: 0px; border-image: initial; vertical-align: baseline; table-layout: fixed; width: 350px; max-width: 100%; border-collapse: collapse; border-spacing: 0px;"><colgroup style="margin: 0px; box-sizing: border-box; border-width: 0px; border-style: solid; border-color: currentcolor;"><col style="width:120px; margin: 0px; box-sizing: border-box; border-width: 0px; border-style: solid; border-color: currentcolor;"><col style="width:auto; margin: 0px; box-sizing: border-box; border-width: 0px; border-style: solid; border-color: currentcolor;"></colgroup><tbody style="margin: 0px; box-sizing: border-box; border-width: 0px; border-style: solid; border-color: currentcolor;"><tr style="margin: 0px; box-sizing: border-box; border-width: 0px; border-style: solid; border-color: currentcolor;"><td class="fw-6" style="width:120px; margin: 0px; box-sizing: border-box; border-width: 0px 0px 1px; border-style: solid; border-color: currentcolor currentcolor rgb(238, 238, 238); font-weight: 600 !important; padding: 20px 0px; line-height: 24px;">상온 배송</td><td style="width:auto; margin: 0px; box-sizing: border-box; border-width: 0px 0px 1px; border-style: solid; border-color: currentcolor currentcolor rgb(238, 238, 238); padding: 20px 0px; line-height: 24px;"><ul class="list ty5" style="margin: 0px; box-sizing: border-box; border: 0px; padding: 0px; vertical-align: baseline; list-style: none;"><li class="etc-ty1" style="margin: 0px; box-sizing: border-box; border: 0px; padding: 0px 0px 0px 8px; vertical-align: baseline; position: relative; line-height: 29px; color: rgb(85, 85, 85);"><span class="color-1" style="margin: 0px; box-sizing: border-box; border: 0px; padding: 0px; vertical-align: baseline; color: rgb(211, 35, 58) !important;">실온</span>표기상품</li></ul></td></tr><tr style="margin: 0px; box-sizing: border-box; border-width: 0px; border-style: solid; border-color: currentcolor;"><td class="fw-6" style="width:120px; margin: 0px; box-sizing: border-box; border-width: 0px 0px 1px; border-style: solid; border-color: currentcolor currentcolor rgb(238, 238, 238); font-weight: 600 !important; padding: 20px 0px; line-height: 24px;">저온 배송</td><td style="width:auto; margin: 0px; box-sizing: border-box; border-width: 0px 0px 1px; border-style: solid; border-color: currentcolor currentcolor rgb(238, 238, 238); padding: 20px 0px; line-height: 24px;"><ul class="list ty5" style="margin: 0px; box-sizing: border-box; border: 0px; padding: 0px; vertical-align: baseline; list-style: none;"><li class="etc-ty1" style="margin: 0px; box-sizing: border-box; border: 0px; padding: 0px 0px 0px 8px; vertical-align: baseline; position: relative; line-height: 29px; color: rgb(85, 85, 85);"><span class="color-9" style="margin: 0px; box-sizing: border-box; border: 0px; padding: 0px; vertical-align: baseline; color: rgb(10, 48, 158) !important;">냉장·냉동</span>표기상품</li></ul></td></tr></tbody></table></div></div><div class="mb-40" style="margin-top: 0px; margin-right: 0px; margin-left: 0px; box-sizing: border-box; border: 0px; padding: 0px; vertical-align: baseline; color: rgb(29, 29, 27); font-family: Pretendard, sans-serif; font-size: 16px; letter-spacing: -0.4px; background-color: rgb(255, 255, 255); margin-bottom: 40px !important;"><h6 class="popup-sub-tit" style="margin: 0px 0px 15px; box-sizing: border-box; border: 0px; padding: 0px; vertical-align: baseline; font-size: 18px; line-height: 21px; color: rgb(51, 51, 51);">지역별 추가배송비</h6><ul class="list ty3" style="margin: 0px; box-sizing: border-box; border: 0px; padding: 0px; vertical-align: baseline; list-style: none;"><li style="margin: 0px; box-sizing: border-box; border: 0px; padding: 0px 0px 0px 10px; vertical-align: baseline; position: relative; font-size: 15px; line-height: 20px; color: rgb(51, 51, 51);">도서 산간 지역 추가 배송비 5,000원</li><li style="margin: 3px 0px 0px; box-sizing: border-box; border: 0px; padding: 0px 0px 0px 10px; vertical-align: baseline; position: relative; font-size: 15px; line-height: 20px; color: rgb(51, 51, 51);">제주 지역 추가 배송비 5,000원</li></ul></div><div style="margin: 0px; box-sizing: border-box; border: 0px; padding: 0px; vertical-align: baseline; background-color: rgb(255, 255, 255);"><h6 class="popup-sub-tit" style="font-family: Pretendard, sans-serif; letter-spacing: -0.4px; color: rgb(51, 51, 51); font-size: 18px; margin: 0px 0px 15px; box-sizing: border-box; border: 0px; padding: 0px; vertical-align: baseline; line-height: 21px;">배송기간</h6><ul class="list ty3" style="font-family: Pretendard, sans-serif; letter-spacing: -0.4px; color: rgb(29, 29, 27); font-size: 16px; margin: 0px; box-sizing: border-box; border: 0px; padding: 0px; vertical-align: baseline; list-style: none;"><li style="margin: 0px; box-sizing: border-box; border: 0px; padding: 0px 0px 0px 10px; vertical-align: baseline; position: relative; font-size: 15px; line-height: 20px; color: rgb(51, 51, 51);">입금/결제 확인 후 평균 2일~4일 (영업일 기준)</li></ul><div style="font-family: Pretendard, sans-serif; letter-spacing: -0.4px;"><font color="#333333"><span style="font-size: 15px;"><br></span></font></div><div style="font-family: Pretendard, sans-serif; letter-spacing: -0.4px;"><font color="#333333"><span style="font-size: 15px;"></span></font></div><h6 class="popup-sub-tit" style="font-family: Pretendard, sans-serif; letter-spacing: -0.4px; color: rgb(51, 51, 51); font-size: 18px; margin: 0px 0px 15px; box-sizing: border-box; border: 0px; padding: 0px; vertical-align: baseline; line-height: 21px;">택배사</h6><ul class="list ty3" style="margin: 0px; box-sizing: border-box; border: 0px; padding: 0px; vertical-align: baseline; list-style: none;"><li style="color: rgb(51, 51, 51); font-family: Pretendard, sans-serif; font-size: 15px; letter-spacing: -0.4px; margin: 0px; box-sizing: border-box; border: 0px; padding: 0px 0px 0px 10px; vertical-align: baseline; position: relative; line-height: 20px;">롯데택배</li><li style="color: rgb(51, 51, 51); font-family: Pretendard, sans-serif; font-size: 15px; letter-spacing: -0.4px; margin: 0px; box-sizing: border-box; border: 0px; padding: 0px 0px 0px 10px; vertical-align: baseline; position: relative; line-height: 20px;">배송조회 및 문의는 마이페이지 &gt; 주문배송조회 또는 1588-2121(롯데택배)에서 가능합니다.&ZeroWidthSpace; 단 당사의 사정에 따라 택배사는 변경될 수 있습니다.&ZeroWidthSpace;&ZeroWidthSpace;</li></ul><div style="font-family: Pretendard, sans-serif; letter-spacing: -0.4px;"></div><div style="font-family: Pretendard, sans-serif; letter-spacing: -0.4px;"><span style="color: rgb(51, 51, 51); font-size: 15px; letter-spacing: -0.4px;"></span></div></div>
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
    <script>
        //<![CDATA[
        $(function(){
            let pno = "916";
            bta.prdOption.init().bind({container: ".goods-detail-wrap"}).setProdOpt(pno);

            // 쿠폰 목록
            bta.couponProduct.open({
                type: "issue",
                product: $('#prod_no').val(),
            });

            // 할인가 안내 팝업
            $(".price .tooltip-btn").on("click", function(){
                bta.alert.open(".discount-price-guide");
            });

            // 상품 문의 작성
            $("a[data-type='qna_regist']").on('click', function() {
                bta.opener.qnaRegist({
                    pno: 916,
                    oncompleted: function(idx) {
                        if (! idx) {
                            prodQna.setParams({
                                sclassify: $('#qna_classify', '#qna_search').find('li.active a').attr('idx'),
                                sanswer: $('#qna_answer', '#qna_search').val(),
                                ssecret: ($('#qna_secret', '#qna_search').is(':checked') ? 1 : 0),
                                smine: ($('#qna_mine', '#qna_search').is(':checked') ? 1 : 0),
                            });
                            prodQna.setPage(0);
                        }
                        prodQna.getList();
                    }
                });
            });

            // 골라담기 상품 상세 팝업
            $(".goods-detail-img .prd-item .thumbs a").on("click", function(){
                const pno = $(this).data("no");
                bta.laypop.prdDetail({
                    id:'prd-pick-detail',
                    url: URI_FRONT_CW+"/product/product_content",
                    data: $.extend({
                        prodNo:pno
                    }, this.params),
                    oncompleted: function(result) {
                        const $popup = $('#'+this.id);
                        $popup.find('.inner').children().remove().end().append(result);
                    }
                });
            });

            // 골라담기 상품 상세정보에서 담기 클릭 시
            let click = false;
            $(".prd-item button[data-type='add']").on("click", function(){
                let idx = $(this).attr("idx");
                $(".selection.dropdown").eq(0).find(".item[data-idx='"+idx+"']").click();
            });
        });
        //]]>

        kakaoPixel('50193296942939463').pageView();
        kakaoPixel('50193296942939463').viewContent({
            id: '916'
        });
    </script>






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
                <a href="https://www.ottogimall.co.kr/front" class="btn popup-btn ty4 c-ty8 delayPwReset" userno="0"><span>다음에</span></a>
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
        <div class="popup-toast-content">상품이 장바구니에 담겼습니다.</div>
    </div>
