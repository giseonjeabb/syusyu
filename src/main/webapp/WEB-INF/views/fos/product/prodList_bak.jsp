<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<head>
    <script src="${jsUrlFos}/product/prodList.js"></script>
    @import url(${cssUrlFos}/product/prodList.css);
</head>



<div class="breadcrumb">
    <div class="breadcrumb-inner">
        <a href="<c:url value="/index"/>">홈</a>::after
        <a href="javascript:">운동화</a>
    </div>

    <div class="content-title">
        <div class="inner-content">
            <h2 class="title-t ty2">운동화</h2>
        </div>
    </div>


    <div class="inner-content">
        <div class="tab-wrap">
            <div class="tab ty1">
                <div class="inner">
                    <a href="#" class="active">전체</a>
                    <a href="#" class="">스니커즈</a>
                    <a href="#" class="">캔버스화</a>
                    <a href="#" class="">조거</a>
                    <a href="#" class="">아웃도어</a>
                    <a href="#" class="">런닝화</a>
                    <a href="#" class="">슬립온</a>
                    <a href="#" class="">뮬</a>
                </div>
            </div>
            <form name="FrmProdFilter" id="frm_prod_filter">
                <div class="content-top">
                    <span class="prd-counter">전체 <strong>104</strong>개</span>
                    <div class="r-side">
                        <ul class="tab ty3">
                            <li><a href="#" class="active" name="pop">인기순</a></li>
                            <li><a href="#" name="new">신제품순</a></li>
                            <li><a href="#" name="disc">할인순</a></li>
                            <li><a href="#" name="lowp">낮은가격순</a></li>
                            <li><a href="#" name="highp">높은가격순</a></li>
                        </ul>
                    </div>
                    <div class="r-side-items">
                        <button type="button" class="btn icon change-list" id="listBtn">
                            <span class="text">앨범/리스트</span>
                        </button>
                    </div>
                </div>
            </form>
            <div id="prd-list-wrap">
                <input type="hidden" id="searchInitSize" value="0">
                <div class="prd-lists n4 " page-no="1" total-size="104" total-page="3">


                    <div class="prd-item ">
                        <div class="thumbs hover">
                            <a href=#" target="_self" pno=""><!--pno상품번호-->
                                <img src="#" alt="오뮤 가뿐한끼 현미밥 150G">
                            </a>
                        </div>
                        <div class="desc">
                            <a href="#" target="_self" pno="">
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

                                    <!-- 상품관리 > 상품 아이콘 설정 / new, sale, 무료배송, coupon -->
                                <span class="badge-item">
									<img src="https://ottogi-mall-s3.s3.ap-northeast-2.amazonaws.com/data/icon/1DNzy0.1jyd9hw05nmu9.png" alt="BEST">
								</span>

                            </a>
                        </div>

                        <div class="prd-item-btn">
                            <button type="button" class="btn icon cart add-cart-bt" pno="">
                                <span class="text">장바구니 담기</span>
                            </button>
                        </div>
                    </div><!--//desc-->
                </div><!--//prd-item -->


                <div class="prd-item ">
                    <div class="thumbs hover">
                        <a href="#" target="_self" pno="">
                            <img src="https://ottogi-mall-s3.s3.ap-northeast-2.amazonaws.com/data/product/list/20221125/19310058_1.jpg" alt="컵밥 톡톡김치알밥(증량) 222G">
                        </a>
                    </div>
                    <div class="desc">
                        <a href="#" target="_self" pno="">
                            <p class="name">컵밥 톡톡김치알밥(증량) 222G</p>

                            <div class="price">
                                <!-- 할인율 있는 경우 -->
                                <p class="amount">
                                    <span class="per">19%</span>2,500<span class="won">원</span>
                                    <del>3,080원</del>
                                </p>
                            </div><!--//price-->

                            <div class="grade">
                                <strong>4.7</strong>
                                <span>(6)</span><!-- 리뷰 -->
                            </div><!-- // grade -->
                        </a>
                        <div class="prd-item-btn">
                            <button type="button" class="btn icon cart add-cart-bt" pno="">
                                <span class="text">장바구니 담기</span>
                            </button>
                        </div>
                    </div><!--//desc-->
                </div><!--//prd-item -->
            </div>


            <%--페이징--%>
            <div class="pagination">
                <a href="#" onclick="return false" class="page-btn first">처음 페이지</a>
                <a href="#" onclick="return false" class="page-btn prev">이전 페이지</a>
                <div class="pager">
                    <a href="#" class="active" page="1" onclick="return false"><span>1</span></a>
                    <a href="?page=2" page="2"><span>2</span></a>
                    <a href="?page=3" page="3"><span>3</span></a>
                </div>
                <a href="#" onclick="return false" class="page-btn next">다음 페이지</a>
                <a href="?page=3" page="3" class="page-btn last">마지막 페이지</a>
            </div>
        </div>
    </div>

</div>

