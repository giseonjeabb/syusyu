<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<head>
    <script src="${jsUrlFos}/product/prodList.js"></script>
</head>
<div class="breadcrumb">
    <div class="breadcrumb-inner">
        <a href="https://www.ottogimall.co.kr/front">홈</a>


        <a href="https://www.ottogimall.co.kr/front/product/category/2">밥/죽/누룽지</a>


        <a href="javascript:">잡곡밥</a>


    </div>
</div>
<div class="content-title">
    <div class="inner-content">
        <h2 class="title-t ty2">잡곡밥</h2>
    </div>
</div>


<div class="inner-content">
    <div class="tab-wrap">


        <div class="tab ty1">
            <div class="inner">
                <a href="https://www.ottogimall.co.kr/front/product/category/2" class="">전체</a>


                <a href="https://www.ottogimall.co.kr/front/product/category/23" class="">즉석밥</a>


                <a href="https://www.ottogimall.co.kr/front/product/category/24" class="">컵밥</a>


                <a href="https://www.ottogimall.co.kr/front/product/category/25" class="">죽</a>


                <a href="https://www.ottogimall.co.kr/front/product/category/26" class="active">잡곡밥</a>


                <a href="https://www.ottogimall.co.kr/front/product/category/27" class="">누룽지</a>


                <a href="https://www.ottogimall.co.kr/front/product/category/28" class="">냉동볶음밥</a>


                <a href="https://www.ottogimall.co.kr/front/product/category/29" class="">밥친구</a>


                <a href="https://www.ottogimall.co.kr/front/product/category/30" class="">곤약밥</a>


                <a href="https://www.ottogimall.co.kr/front/product/category/31" class="">오뚜기쌀</a>


                <a href="https://www.ottogimall.co.kr/front/product/category/32" class="">주먹밥/무스비</a>

            </div>
        </div>

        <form name="FrmProdFilter" id="frm_prod_filter">

            <input type="hidden" name="scate" id="qx_cate_idx" value="26">
            <input type="hidden" name="sbrand" id="qx_brand_idx" value="0">
            <input type="hidden" name="keyword" id="qx_keyword" value="">
            <input type="hidden" name="keywordRe" id="qx_keyword_re" value="">
            <input type="hidden" name="storeNo" id="qx_store_no" value="0">
            <input type="hidden" name="ptype" id="qx_ptype" value="0">
            <input type="hidden" name="psort" id="qx_sort" value="pop">
            <input type="hidden" name="listBtn" id="qx_listBtn" value="0">
            <div class="content-top">
                <span class="prd-counter">전체 <strong>16</strong>개</span>
                <div class="r-side">
                    <div class="tab ty3">
                        <a href="#" class="active" name="pop">인기순</a>
                        <a href="#" name="new">신제품순</a>
                        <a href="#" name="disc">할인순</a>
                        <a href="#" name="lowp">낮은가격순</a>
                        <a href="#" name="highp">높은가격순</a>
                    </div>
                    <div class="r-side-items">
                        <select name="ptype" class="selectbox ty2">
                            <option value="0" selected="">배송전체</option>
                            <option value="1">실온</option>
                            <option value="2">냉장&amp;냉동</option>
                        </select>
                    </div>
                    <div class="r-side-items">
                        <select name="pageSize" id="pageSize" class="selectbox ty2">
                            <option value="40">40개</option>
                            <option value="60">60개</option>
                            <option value="80" selected="">80개</option>
                            <option value="100">100개</option>
                        </select>
                    </div>
                    <div class="r-side-items">
                        <button type="button" class="btn icon change-list" id="listBtn"><span class="text">앨범/리스트</span>
                        </button>
                    </div>
                </div><!--//r-side-->
            </div><!--//content-top-->
        </form>
        <div id="prd-list-wrap">


            <input type="hidden" id="searchInitSize" value="0">


            <div class="prd-lists n4 " page-no="1" total-size="16" total-page="1">


                <div class="prd-item ">
                    <div class="thumbs hover">
                        <a href="https://www.ottogimall.co.kr/front/product/706" target="_self" pno="706">
                            <img src="https://ottogi-mall-s3.s3.ap-northeast-2.amazonaws.com/data/product/list/20221125/19210047_1.jpg"
                                 alt="오뮤 가뿐한끼 현미밥 150G">
                        </a>
                    </div>
                    <div class="desc">
                        <a href="https://www.ottogimall.co.kr/front/product/706" target="_self" pno="706">
                            <p class="name">오뮤 가뿐한끼 현미밥 150G</p>

                            <div class="price">


                                <!-- 할인율 없는 경우 -->
                                <p class="amount">
                                    1,180<span class="won">원</span>
                                </p>


                            </div><!--//price-->

                            <div class="grade">
                                <strong>4.9</strong>
                                <span>(15)</span><!-- 리뷰 -->
                            </div><!-- // grade -->
                        </a>


                        <div class="prd-item-btn">


                            <button type="button" class="btn icon cart add-cart-bt" pno="706"><span
                                    class="text">장바구니 담기</span></button>


                        </div>
                    </div><!--//desc-->
                </div><!--//prd-item -->


                <div class="prd-item ">
                    <div class="thumbs hover">
                        <a href="https://www.ottogimall.co.kr/front/product/2325" target="_self" pno="2325">
                            <img src="https://ottogi-mall-s3.s3.ap-northeast-2.amazonaws.com/data/product/list/20230621/1687324800702aKuUf.1ibe93bjenkva.jpg"
                                 alt="찰기가득진밥 210G 4개 + 찰진 흑미 잡곡밥 210G 4개">
                        </a>
                    </div>
                    <div class="desc">
                        <a href="https://www.ottogimall.co.kr/front/product/2325" target="_self" pno="2325">
                            <p class="name">찰기가득진밥 210G 4개 + 찰진 흑미 잡곡밥 210G 4개</p>

                            <div class="price">

                                <!-- 할인율 있는 경우 -->
                                <p class="amount">
                                    <span class="per">40%</span>8,060<span class="won">원</span>
                                    <del>13,440원</del>
                                </p>


                            </div><!--//price-->

                            <div class="grade">
                                <strong>0.0</strong>
                                <span>(0)</span><!-- 리뷰 -->
                            </div><!-- // grade -->
                        </a>


                        <div class="prd-item-btn">


                            <button type="button" class="btn icon cart add-cart-bt" pno="2325"><span class="text">장바구니 담기</span>
                            </button>


                        </div>
                    </div><!--//desc-->
                </div><!--//prd-item -->

            </div>


        </div>
    </div><!--//tab-wrap-->
</div>
<!--//inner-content-->

<script type="text/javascript">

    //<![CDATA[
    $(function () {
        const $pageList = $("#prd-list-wrap");
        bta.prodSearchPager.bind({
            urlProduct: "https://www.ottogimall.co.kr/front/product/product_list.ajax",
            onload: function (result) {
                $pageList.children().remove().end()
                    .append(result);

                let listCnt = 0;
                if ($(".prd-lists").attr("total-size") != undefined) {
                    listCnt = $(".prd-lists").attr("total-size");
                }
                $(".prd-counter strong").text(listCnt);

            }
        }).init();

        $("select[name='ptype'], select[name='pageSize']", ".content-top").on('change', function () {
            if ($(this).attr("name") == "ptype") {
                $("#qx_ptype").val($(this).val());
            }
            bta.prodSearchPager.setChange();
        });

        $(".r-side .tab a", ".content-top").on("click", function () {
            if ($(this).hasClass("active")) return false;

            $("#qx_sort").val($(this).attr("name"));
            $(".r-side .tab a").removeClass("active");
            $(this).addClass("active");
            bta.prodSearchPager.setChange();
        });

        $(document).on('click', '#prd-list-wrap .pagination a', function () {
            var page = $(this).attr('page');
            if ($("#prd-list-wrap .prd-lists").attr('page-no') == page) {
                return false;
            }
            bta.prodSearchPager.setPage(page);
            $('html, body').scrollTop('0');
            return false;
        });

        $(document).on('click', '#listBtn', function () {
            if ($("#qx_listBtn").val() == 0) {
                $("#qx_listBtn").val(1);
            } else {
                $("#qx_listBtn").val(0);
            }
        });

    });
    //]]>
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
                            장기간 비밀번호를 변경하지 않고 동일한 비밀번호를 사용 중이신 경우, 개인정보를 안전하게 보호하고 개인정보도용으로 인한 피해를 방지하기 위해 주기적으로 비밀번호를
                            변경하도록 안내해 드리고 있습니다.
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
    <div class="popup-toast-content"></div>
</div>