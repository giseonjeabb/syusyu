<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="categories" value="${sessionScope.categories}"/>
<head>
    <script src="<c:url value='${jsUrlFos}/product/productList.js'/>"></script>
    <style>
        .star-rating {
            position: relative;
            display: inline-block;
        }

        .star-rating span {
            font-size: 20px;  // 원하는 크기로 조절
        }

        .star-rating .star-rating-top {
            color: black;  // 원하는 색상으로 조절
        position: absolute;
            z-index: 1;
            overflow: hidden;
        }

        .star-rating .star-rating-bottom {
            color: lightgrey;  // 원하는 색상으로 조절
        z-index: 0;
        }
    </style>
</head>


<div class="breadcrumb">
    <div class="breadcrumb-inner">
        <a href="<c:url value='/'/>">홈</a>

        <%--   추후 카테고리 삽입하면 경로바꿀 예정임   --%>
        <a href="<c:url value='/fos/products/${middleNo}'/>">${categories.middleCategories.get(middleNo)}</a>

        <c:choose>
            <c:when test="${empty smallNo}">
                <a href="<c:url value='/fos/products/${middleNo}'/>">전체</a>
            </c:when>
            <c:otherwise>
                <a href="#">${categories.smallCategories.get(middleNo).get(smallNo)}</a>
            </c:otherwise>
        </c:choose>


    </div>
</div>
<div class="content-title">
    <div class="inner-content">
        <h2 class="title-t ty2">
            <c:choose>
                <c:when test="${empty smallNo}">
                    ${categories.middleCategories.get(middleNo)}
                </c:when>
                <c:otherwise>
                    ${categories.smallCategories.get(middleNo).get(smallNo)}
                </c:otherwise>
            </c:choose>


        </h2>
    </div>
</div>

<div class="inner-content">
    <div class="tab-wrap">
        <div class="tab ty1">
            <div class="inner">
                <a href="<c:url value='/fos/products/${middleNo}'/>" class="allCategory">전체</a>
                <c:forEach var="small" items="${categories.smallCategories}">
                    <c:if test="${small.key == middleNo}">
                        <c:forEach var="smallCategoryItem" items="${small.value}">

                            <a href="<c:url value='/fos/products/${small.key}/${smallCategoryItem.key}'/>"
                               class="smallCategory" data-category-name="${smallCategoryItem.value}">
                                <c:out value="${smallCategoryItem.value}"/>
                            </a>

                        </c:forEach>시
                    </c:if>
                </c:forEach>

            </div>
        </div>

        <form name="FrmProdFilter" id="frm_prod_filter">
            <div class="content-top">
                <span class="prd-counter">전체 <strong></strong>개</span>
                <div class="r-side">
                    <div class="tab ty3" id="sort">
                        <a href="#" id="newArrival" class="active">신제품순</a>
                        <a href="#" id="lowPrice">낮은가격순</a>
                        <a href="#" id="highPrice">높은가격순</a>
                        <a href="#" id="discount">할인순</a>
                        <a href="#" id="popularity">인기순</a>
                        <a href="#" id="reviewCount">리뷰순</a>
                        <a href="#" id="ratingCount">평점많은순</a>
                        <a href="#" id="buyCount">구매순</a>
                    </div>

<%--                    <div class="r-side-items">--%>
<%--                        <select name="pageSize" id="pageSize" class="selectbox ty2">--%>
<%--                            <option value="40">40개</option>--%>
<%--                            <option value="60">60개</option>--%>
<%--                            <option value="80" selected="">80개</option>--%>
<%--                            <option value="100">100개</option>--%>
<%--                        </select>--%>
<%--                    </div>--%>
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

            </div>
        </div>
    </div>
</div>
<!-- top버튼 -->
<button id="btnTop" class="top-btn"><i class="fas fa-arrow-up"></i></button>
