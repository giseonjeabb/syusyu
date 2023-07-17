<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="urlParts" value="${sessionScope.url}"/>
<%--<c:set var="urlParts" value="${fn:split(pageContext.request.requestURI, '/')}"/>--%>
<%--&lt;%&ndash;<c:if test="${not empty urlParts[2]}">&ndash;%&gt;--%>
<%--    <c:set var="middleNo" value="${urlParts[2]}"/>--%>
<%--&lt;%&ndash;</c:if>&ndash;%&gt;--%>
<%--&lt;%&ndash;<c:if test="${not empty urlParts[3]}">&ndash;%&gt;--%>
<%--    <c:set var="smallNo" value="${urlParts[3]}"/>--%>
<%--</c:if>--%>

<%--<c:set var="smallNo" value="${urlParts[2]}"/>--%>
<c:set var="categories" value="${sessionScope.categories}"/>
<head>
    <script src="${jsUrlFos}/product/productList.js" type="text/javascript"></script>
</head>


<div class="breadcrumb">
    <div class="breadcrumb-inner">
        <a href="<c:url value="/productList?middleNo=1&smallNo=1"/>">신발</a>

        <%--   추후 카테고리 삽입하면 경로바꿀 예정임   --%>
        <a href="<c:url value="/productList?middleNo=1&smallNo=1"/>">운동화</a>

        <%--<a href="javascript:">스니커즈</a>--%>
        <a href="#">스니커즈</a>

    </div>
</div>
<div class="content-title">
    <div class="inner-content">
        <h2 class="title-t ty2">스니커즈</h2>
    </div>
</div>

<div class="inner-content">
    <div class="tab-wrap">
        <div class="tab ty1">
            <div class="inner">
                <a href="#" class="">전체</a>
<%--                <c:out value="${middleNo}"/>--%>
<%--                <c:out value="${smallNo}"/>--%>
                <c:forEach var="small" items="${categories.smallCategories}">
                    <c:if test="${small.key == middleNo}">
                        <c:forEach var="smallCategoryItem" items="${small.value}">

                                <a href="<c:url value='/productList/${small.key}/${smallCategoryItem.key}'/>">
                                    <c:out value="${smallCategoryItem.value}"/>
                                </a>

                        </c:forEach>
                    </c:if>
                </c:forEach>

            </div>
        </div>

        <form name="FrmProdFilter" id="frm_prod_filter">
            <div class="content-top">
                <span class="prd-counter">전체 <strong></strong>개</span>
                <div class="r-side">
                    <div class="tab ty3">
                        <a href="#" class="active" name="pop">인기순</a>
                        <a href="#" name="new">신제품순</a>
                        <a href="#" name="disc">할인순</a>
                        <a href="#" name="lowp">낮은가격순</a>
                        <a href="#" name="highp">높은가격순</a>
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
                <%--해당 카테고리 상품이 없으면 --%>
<%--                <c:choose>--%>
<%--                    <c:when test="${prodListTot eq 0 || prodListTot eq null}">--%>
<%--                    <div class="list-none bt-0">--%>
<%--                        <p class="msg-text">상품이 없습니다.</p>--%>
<%--                    </div>--%>
<%--                    </c:when>--%>
<%--                &lt;%&ndash;해당 카테고리 상품이 있을때&ndash;%&gt;--%>
<%--                    <c:otherwise>--%>
<%--                    <c:forEach var="item" items="${productList}">--%>
<%--                    <div class="prd-item ">--%>
<%--                        <div class="thumbs hover">--%>
<%--                            <a href="https://www.ottogimall.co.kr/front/product/706" target="_self" pno="706">--%>
<%--                                <img src="${item.repImg}" alt="${item.prodNm}"/>--%>
<%--                            </a>--%>
<%--                        </div>--%>
<%--                        <div class="desc">--%>
<%--                            <a href="https://www.ottogimall.co.kr/front/product/706" target="_self" pno="706">--%>
<%--                                <p class="name">${item.prodNm}</p>--%>
<%--                                <div class="price">--%>
<%--                                    <c:choose>--%>
<%--                                        <c:when test="${item.dcPer > 0}">--%>
<%--                                            <!-- 할인율 있는 경우 -->--%>
<%--                                            <p class="amount">--%>
<%--                                                <span class="per">${item.dcPer}%</span><fmt:formatNumber value="${item.dcPrc}" pattern="#,###" /><span class="won">원</span>--%>
<%--                                                <del><fmt:formatNumber value="${item.price}" pattern="#,###" />원</del>--%>
<%--                                            </p>--%>
<%--                                        </c:when>--%>
<%--                                        <c:when test="${item.dcPer==0}">--%>
<%--                                            <!-- 할인율 없는 경우 -->--%>
<%--                                            <p class="amount">--%>

<%--                                                <fmt:formatNumber value="${item.price}" pattern="#,###" /><span class="won">원</span>--%>
<%--                                            </p>--%>
<%--                                        </c:when>--%>
<%--                                    </c:choose>--%>
<%--                                </div>--%>
<%--                                <div class="grade">--%>
<%--                                    <strong>${item.avgStarRating}</strong>--%>
<%--                                    <span>(${item.revwCnt})</span><!-- 리뷰 -->--%>
<%--                                </div>--%>
<%--                            </a>--%>
<%--                            <div class="prd-item-btn">--%>

<%--                                <button type="button" class="btn icon cart add-cart-bt" pno="706"><span--%>
<%--                                        class="text">장바구니 담기</span></button>--%>
<%--                            </div>--%>
<%--                        </div><!--//desc-->--%>
<%--                    </div><!--//prd-item -->--%>
<%--                    </c:forEach>--%>
<%--                    </c:otherwise>--%>
<%--                </c:choose>--%>

            </div>
        </div>
    </div>
</div>

