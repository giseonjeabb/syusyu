<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="loginOutLink" value="${sessionScope.mbrId != null ? '/fos/logout' : '/fos/login'}"/>
<c:set var="loginOutText" value="${sessionScope.mbrId != null ? '로그아웃' : '로그인'}"/>
<c:set var="categories" value="${sessionScope.categories}"/>
<html>
<style>
    @import url(${cssUrlFos}/common/header.scss);
</style>
<script src="<c:url value='${jsUrlFos}/common/header.js'/>"></script>
<body>
<jsp:include page="layerPopup.jsp"/>
<header>
    <div class="h-inner">
        <div class="header-top">
            <div class="inner">
                <h1 class="logo"><a href="/"
                                    style="background: url('/static/image/logo/syusyuBlackLogo.png') no-repeat center center;">syusyu</a>${categories.middleCategories}
                </h1>
                <div class="header-top-utils">
                    <a id="loginOut" href="#" onclick="location.href='${loginOutLink}'">${loginOutText}</a>
                    <a href="/notice/noticeList">고객센터</a>
                </div>
            </div>
        </div><!--//header-top-->
        <div class="header-bottom">
            <div class="inner">
                <div class="header-bottom-item">
                    <div class="category">
                        <c:forEach var="large" items="${categories.largeCategories}">
                            <button type="button" class="category_btn" id="cate__large"><span>${large.value}</span></button>
                        </c:forEach>
                        <div class="category_list" id="category_All_list">
                            <ul class="depth1">
                                <%--중분류--%>
                                <c:forEach var="middle" items="${categories.middleCategories}" varStatus="status">
                                    <li>
                                        <a class="mainCategory"
                                           href="/fos/products/${middle.key}"
                                           idx=${middle.key} data-idx=${middle.key}> <c:out value="${middle.value}"/> </a>
                                        <div class="depth2">
                                            <ul class="subCategory">
                                                    <%-- 소분류 --%>
                                                <!-- middle.key와 small.key가 같다면 해당 small카테고리의 항목의 값을 리스트 항목으로 출력-->
                                                <c:forEach var="small" items="${categories.smallCategories}">
                                                    <c:if test="${middle.key eq small.key}">
                                                        <c:forEach var="smallCategoryItem" items="${small.value}">
                                                            <li><a href="<c:url value='/fos/products/${small.key}/${smallCategoryItem.key}'/>">
                                                                <c:out value="${smallCategoryItem.value}"/></a></li>
                                                        </c:forEach>
                                                    </c:if>
                                                </c:forEach>
                                            </ul>
                                        </div>
                                    </li>
                                </c:forEach>
                            </ul>
                        </div>
                    </div>
                    <div class="category">
                        <ul class="gnb-list" id="gnb-list">
                            <c:forEach var="middle" items="${categories.middleCategories}" varStatus="status">
                                <li><a class="middle-link" href="<c:url value='/fos/products/${middle.key}'/>" idx=${middle.key} data-idx=${middle.key} target="_self"><c:out value="${middle.value}"/></a>
                                    <div class="category_list" id="category_link_list">
                                        <ul class="depth1" id="depth1__block">
                                            <c:forEach var="small" items="${categories.smallCategories}">
                                                <c:if test="${middle.key eq small.key}">
                                                    <c:forEach var="smallCategoryItem" items="${small.value}">
                                                        <li><a class="mainCategory" href="<c:url value='/fos/products/${small.key}/${smallCategoryItem.key}'/>">
                                                            <c:out value="${smallCategoryItem.value}"/></a></li>
                                                    </c:forEach>
                                                </c:if>
                                            </c:forEach>
                                        </ul>
                                    </div>
                                </li>
                            </c:forEach>
                        <li><a href="#" target="_self">베스트</a></li>
                        </ul>
                    </div>
                </div>
                <div class="header-bottom-item keywordBox">
                    <div class="h-search-wrap">
                        <form id="frm_topper_search" action="https://www.ottogimall.co.kr/front/product/search_result">
                            <div class="input">
                                <input type="text" id="search_input" name="keyword" class="inp" autocomplete="off">
                                <button type="submit" class="btn icon search">
                                    <%--                                    <span>검색</span>--%>
                                </button>
                            </div>
                        </form>
                        <div class="h-search-autocomplete"></div>
                    </div>
                    <div class="header-bottom-utils">
                        <a href="/fos/orderView" class="btn icon mypage"><span class="text">마이페이지</span></a>
                        <a href="/fos/cart" class="btn icon bag" style="display: inline-block">
                            <span class="text">장바구니</span>
<%--                            <span class="cnt" data-name="basket-cnt">3</span>--%>
                        </a>
                    </div>
                </div>
            </div>
        </div><!--//header-bottom--></div>
</header>
</body>
</html>
