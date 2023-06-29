<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="loginOutLink" value="${sessionScope.id != null ? '/login/logout' : '/login/login'}" />
<c:set var="loginOutText" value="${sessionScope.id != null ? '로그아웃' : '로그인'}" />
<html>
<body>
<header id="main_header">
    <nav id="main_gnb">
        <ul>

            <li><a href="<c:url value='/notice/noticeList'/>">고객센터</a></li>
            <li><a href="<c:url value="/mypage/main"/>">마이페이지</a></li>
            <li><a href="#">관심상품</a></li>
            <li><a href="<c:url value="/order/cart"/>">장바구니</a></li>
            <li><a id="loginOut" href="#" onclick="location.href='${loginOutLink}'">${loginOutText}</a></li>
        </ul>
    </nav>
    <div id="title">
        <div id="logo">
            <img src="<c:url value="${imgUrl}/logo/syusyuBlackLogo.png"/>" onclick="location.href='/'">
        </div>
        <div id="search_box">
            검색
        </div>
    </div>
    <nav id="main_lnb">
        <ul>
            <li><a href="#">추천</a></li>
            <li><a href="#">랭킹</a></li>
            <li><a href="#">신발</a></li>
            <li><a href="#">남성</a></li>
            <li><a href="#">여성</a></li>
            <li><a href="<c:url value="/prodList"/>">신발</a></li>
            <li><a href="#">발견</a></li>
        </ul>
    </nav>
</header>
</body>
</html>
