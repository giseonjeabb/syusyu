<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="loginOutLink" value="${sessionScope.mbrId != null ? '/fos/logout' : '/fos/login'}"/>
<c:set var="loginOutText" value="${sessionScope.mbrId != null ? '로그아웃' : '로그인'}"/>
<c:set var="categories" value="${sessionScope.categories}"/>
<html>
<head>
    <script src="<c:url value='${jsUrlFos}/common/header.js'/>"></script>
</head>
<body>
<jsp:include page="layerPopup.jsp"/>
<header>
    <div class="h-inner">
        <div class="header-top">
            <div class="inner">
                <h1 class="logo"><a href="/"
                                    style="background: url('/static/image/logo/syusyuBlackLogo.png') no-repeat center center;">syusyu</a>
                </h1>
                <div class="header-top-utils">
                    <a href="<c:url value="/admin/dashboard"/>">관리자페이지</a>
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
                            <button type="button" class="category_btn"><span>${large.value}</span></button>
                        </c:forEach>
                        <div class="category_list">
                            <ul class="depth1">
                                <%--중분류--%>
                                <c:forEach var="middle" items="${categories.middleCategories}" varStatus="status">
                                    <li>
                                        <a class="mainCategory"
                                           href="/productList/${middle.key}"
                                           idx=${middle.key} data-idx=${middle.key}> <c:out value="${middle.value}"/> </a>
                                        <div class="depth2">
                                            <ul class="subCategory">
                                                    <%-- 소분류 --%>
                                                <!-- middle.key와 small.key가 같다면 해당 small카테고리의 항목의 값을 리스트 항목으로 출력-->
                                                <c:forEach var="small" items="${categories.smallCategories}">
                                                    <c:if test="${middle.key eq small.key}">
                                                        <c:forEach var="smallCategoryItem" items="${small.value}">
                                                            <li><a href="<c:url value='/productList/${small.key}/${smallCategoryItem.key}'/>"><c:out
                                                                    value="${smallCategoryItem.value}"/></a></li>
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
                    <ul class="gnb-list">
                        <li><a href="https://www.ottogimall.co.kr/front/product/mainCategory/only"
                               target="_self">hey!</a></li>
                        <li><a href="https://www.ottogimall.co.kr/front/promo/event" target="_self">이벤트</a></li>
                        <li><a href="https://www.ottogimall.co.kr/front/product/brand" target="_self">브랜드관</a></li>
                        <li><a href="https://www.ottogimall.co.kr/front/product/best" target="_self">베스트</a></li>
                    </ul>
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
                        <div class="search-word-wrap" data-without="">
                            <div class="search-word-cont" id="recentKeywordBox">
                                <div class="search-word-head">
                                    <h4>최근 검색어</h4>
                                    <button type="button" class="btn btn-text-type bt-remove btt1 underline deleteAll">
                                        전체삭제
                                    </button>
                                </div>
                                <div class="word-wrap">
                                    <ul class="search-word-list ty1 word-list">
                                    </ul>
                                </div>
                            </div>
                            <div class="search-word-cont">
                                <div class="search-word-head">
                                    <h4>추천 검색어</h4>
                                </div>
                                <ul class="search-word-list ty2" id="recommandKeyword">
                                    <li>
                                        <a href="https://www.ottogimall.co.kr/front/product/search_result?keyword=오뮤 가뿐한끼 현미밥 150G">오뮤
                                            가뿐한끼 현미밥 150G</a></li>
                                    <li></li>
                                    <li>
                                        <a href="https://www.ottogimall.co.kr/front/product/search_result?keyword=진라면 매운맛 (120GX5)">진라면
                                            매운맛 (120GX5)</a></li>
                                    <li></li>
                                    <li>
                                        <a href="https://www.ottogimall.co.kr/front/product/search_result?keyword=진라면 매운맛 컵 65G">진라면
                                            매운맛 컵 65G</a></li>
                                    <li></li>
                                    <li>
                                        <a href="https://www.ottogimall.co.kr/front/product/search_result?keyword=육개장 컵 104G">육개장
                                            컵 104G</a></li>
                                    <li></li>
                                    <li>
                                        <a href="https://www.ottogimall.co.kr/front/product/search_result?keyword=참깨라면 용기 110G">참깨라면
                                            용기 110G</a></li>
                                    <li></li>
                                    <li>
                                        <a href="https://www.ottogimall.co.kr/front/product/search_result?keyword=옛날 사골곰탕 350G">옛날
                                            사골곰탕 350G</a></li>
                                    <li></li>
                                    <li>
                                        <a href="https://www.ottogimall.co.kr/front/product/search_result?keyword=컵밥 톡톡김치알밥(증량) 222G">컵밥
                                            톡톡김치알밥(증량) 222G</a></li>
                                    <li></li>
                                    <li>
                                        <a href="https://www.ottogimall.co.kr/front/product/search_result?keyword=짜슐랭(145GX5)">짜슐랭(145GX5)</a>
                                    </li>
                                    <li></li>
                                    <li>
                                        <a href="https://www.ottogimall.co.kr/front/product/search_result?keyword=컵밥 차돌강된장보리밥(증량) 310G">컵밥
                                            차돌강된장보리밥(증량) 310G</a></li>
                                    <li></li>
                                    <li>
                                        <a href="https://www.ottogimall.co.kr/front/product/search_result?keyword=3분카레 매운맛 200G">3분카레
                                            매운맛 200G</a></li>
                                    <li></li>
                                </ul>
                            </div>
                            <div class="search-word-cont">
                                <div class="search-word-head">
                                    <h4>인기 검색어</h4> <small>2023.07.14 기준</small>
                                </div>
                                <ul class="search-word-list" id="trendKeyword">
                                    <li><span class="sw-num">1</span><a
                                            href="https://www.ottogimall.co.kr/front/product/search_result?keyword=오뚜기">오뚜기</a>
                                    </li>
                                    <li><span class="sw-num">2</span><a
                                            href="https://www.ottogimall.co.kr/front/product/search_result?keyword=현미밥">현미밥</a>
                                    </li>
                                    <li><span class="sw-num">3</span><a
                                            href="https://www.ottogimall.co.kr/front/product/search_result?keyword=새우볶음밥">새우볶음밥</a>
                                    </li>
                                    <li><span class="sw-num">4</span><a
                                            href="https://www.ottogimall.co.kr/front/product/search_result?keyword=선물세트">선물세트</a>
                                    </li>
                                    <li><span class="sw-num">5</span><a
                                            href="https://www.ottogimall.co.kr/front/product/search_result?keyword=야채참치">야채참치</a>
                                    </li>
                                    <li><span class="sw-num">6</span><a
                                            href="https://www.ottogimall.co.kr/front/product/search_result?keyword=참치">참치</a>
                                    </li>
                                    <li><span class="sw-num">7</span><a
                                            href="https://www.ottogimall.co.kr/front/product/search_result?keyword=카레">카레</a>
                                    </li>
                                    <li><span class="sw-num">8</span><a
                                            href="https://www.ottogimall.co.kr/front/product/search_result?keyword=오뚜기밥">오뚜기밥</a>
                                    </li>
                                </ul>
                            </div>
                        </div>
                        <div class="h-search-autocomplete"></div>
                    </div>
                    <div class="header-bottom-utils">
                        <a href="/mypage/main" class="btn icon mypage"><span class="text">마이페이지</span></a>
                        <a href="/fos/cart" class="btn icon bag" style="display: inline-block">
                            <span class="text">장바구니</span>
                            <span class="cnt" data-name="basket-cnt">3</span>
                        </a>
                    </div>
                </div>
            </div>
        </div><!--//header-bottom--></div>
</header>
</body>
</html>
