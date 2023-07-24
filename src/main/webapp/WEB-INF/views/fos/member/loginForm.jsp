<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<head>
    <script src="<c:url value="${jsUrlFos}/member/loginForm.js"/>"></script>
    <style>
        @import url(${cssUrlFos}/member/login.css);
    </style>
</head>
<div class="login_container">
    <div class="login_area">
        <h2 class="login_title">syusyu</h2>
        <div class="input_box">
            <h3 class="input_title">아이디</h3>
            <div class="input_item">
                <input type="email" id="login_id" autocomplete="off" class="input_txt" autofocus>
            </div>
            <p class="input_error">아이디를 정확히 입력해주세요.</p>
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
            <li class="look_list"><a href="<c:url value="/fos/register"/>" class="look_link">회원가입</a></li>
            <li class="look_list"><a href="" class="look_link">아이디 찾기</a></li>
            <li class="look_list"><a href="" class="look_link">비밀번호 찾기</a></li>
        </ul>
        <div class="social_login"></div>
    </div>
</div>