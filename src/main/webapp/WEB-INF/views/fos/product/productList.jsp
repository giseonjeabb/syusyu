<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="categories" value="${sessionScope.categories}"/>
<head>
    <script src="<c:url value='${jsUrlFos}/product/productList.js'/>"></script>
</head>


<div class="breadcrumb">
    <div class="breadcrumb-inner">
        <a href="<c:url value='/fos/products?middleNo=1&smallNo=1'/>">신발</a>

        <%--   추후 카테고리 삽입하면 경로바꿀 예정임   --%>
        <a href="<c:url value='/fos/products/${middleNo}'/>">운동화</a>

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
                <a href="<c:url value='/fos/products/${middleNo}'/>" class="allCategory">전체</a>
                <%--                <c:out value="${middleNo}"/>--%>
                <%--                <c:out value="${smallNo}"/>--%>
                <c:forEach var="small" items="${categories.smallCategories}">
                    <c:if test="${small.key == middleNo}">
                        <c:forEach var="smallCategoryItem" items="${small.value}">

                            <a href="<c:url value='/fos/products/${small.key}/${smallCategoryItem.key}'/>" class ="smallCategory" data-category-name="${smallCategoryItem.value}">
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

            </div>
        </div>
    </div>
</div>

