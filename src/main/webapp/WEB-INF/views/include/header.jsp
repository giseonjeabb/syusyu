<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="loginOutLink" value="${sessionScope.id != null ? '/login/logout' : '/login/login'}" />
<c:set var="loginOutText" value="${sessionScope.id != null ? 'Logout' : 'Login'}" />
<html>
<head>
    <title>syusyu</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/static/image2?family=Noto+Sans+KR&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <link rel="stylesheet" href="<c:url value="/static/css/common/reset.css"/>">
    <link rel="stylesheet" href="<c:url value="/static/css/common/common.css"/>">
    <link rel="stylesheet" href="<c:url value="/static/css/common/main.css"/>">

    <script src="https://code.jquery.com/jquery-1.11.3.js"></script>
</head>
<body>
<header id="main_header">
    <nav id="main_gnb">
        <ul>
            <li><a href="#">고객센터</a></li>
            <li><a href="#">마이페이지</a></li>
            <li><a href="#">관심상품</a></li>
            <li><a href="#">알림</a></li>
            <li><a href="#">로그인</a></li>
        </ul>
    </nav>
    <div id="title">
        <div id="logo">
            <img src="<c:url value="/static/image/logo/syusyuBlackLogo.png"/>">
        </div>
        <div id="search_box">
            검색
        </div>
    </div>
    <nav id="main_lnb">
        <ul>
            <li><a href="#">추천</a></li>
            <li><a href="#">랭킹</a></li>
            <li><a href="#">남성</a></li>
            <li><a href="#">여성</a></li>
            <li><a href="#">발견</a></li>
        </ul>
    </nav>
</header>
</body>
</html>
