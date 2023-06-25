<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<c:set var="loginId" value="${pageContext.request.getSession(false)==null ? '' : pageContext.request.session.getAttribute('id')}"/>
<c:set var="loginOutLink" value="${loginId=='' ? '/login/login' : '/login/logout'}"/>
<c:set var="loginOut" value="${loginId=='' ? 'Login' : 'ID='+=loginId}"/>
<!DOCTYPE html>
<html>
<head>
    <script src="/static/js/loginForm.js"></script>
    <style>
        @import url(/static/css/common/login.css);
    </style>
</head>
<body>
<jsp:include page="include/header.jsp"/>

<div class="login_container">
    <div class="login_area">
        <h2 class="login_title">syusyu</h2>
        <div class="input_box">
            <h3 class="input_title">아이디</h3>
            <div class="input_item">
                <input type="email" id="login_id" autocomplete="off" class="input_txt" autofocus>
            </div>
            <p class="input_error">이메일 주소를 정확히 입력해주세요.</p>
        </div>
        <div class="input_box">
            <h3 class="input_title">비밀번호</h3>
            <div class="input_item">
                <input type="password" id="login_pwd" autocomplete="off" class="input_txt"> <!-- autocom off = 자동완성 기능 사용 XX -->
            </div>
            <p class="input_error">영문, 숫자, 특수문자를 조합해서 입력해주세요. (8-16자)</p>
        </div>
        <div class="login_btn_box">
            <a disabled="disabled" href="#" id="btn_login" class="btn full solid disabled"> 로그인</a>
        </div>
        <ul class="look_box">
            <li class="look_list"><a href="" class="look_link">이메일 가입</a></li>
            <li class="look_list"><a href="" class="look_link">이메일 찾기</a></li>
            <li class="look_list"><a href="" class="look_link">비밀번호 찾기</a></li>
        </ul>
        <div class="social_login"></div>
    </div>
</div>
<jsp:include page="include/footer.jsp"/>
</body>
</html>