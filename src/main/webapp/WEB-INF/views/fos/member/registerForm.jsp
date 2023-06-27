<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
    <script src="<c:url value="${jsUrlFos}/member/registerForm.js"/>"></script>
    <style>
        @import url(${cssUrlFos}/member/register.css);
    </style>
</head>
<body>
<jsp:include page="../common/header.jsp"/>

<div class="container join">
    <div class="content sm">
        <div class="join_area">
            <h2 class="join_title">회원가입</h2>
            <div class="input_join input_box">
                <h3 class="input_title ess">아이디</h3>
                <div class="input_item">
                    <input type="email" id="login_id" autocomplete="off" value="" class="input_txt">
                </div>
                <p class="input_error"></p>
            </div>
            <div class="input_box input_join has_button">
                <h3 class="input_title ess">비밀번호</h3>
                <div class="input_item">
                    <input type="password" id="login_pwd" placeholder="영문, 숫자, 특수문자 조합 8-16자" autocomplete="off" value="" class="input_txt" >
                </div>
                <p class="input_error">영문, 숫자, 특수문자를 조합하여 입력해주세요.</p>
            </div>
            <div class="input_join input_box">
                <h3 class="input_title">이메일 주소</h3>
                <div class="input_item">
                    <input type="email" id="email" placeholder="비밀번호 분실 시 확인용 이메일" autocomplete="off" value="" class="input_txt">
                </div>
                <p class="input_error"></p>
            </div>
            <div class="input_join input_box">
                <h3 class="input_title ess">이름</h3>
                <div class="input_item">
                    <input type="email" id="name" autocomplete="off" value="" class="input_txt">
                </div>
                <p class="input_error"></p>
            </div>
            <div class="input_join input_box">
                <h3 class="input_title ess">생년월일</h3>
                <div class="input_item">
                    <input type="email" id="birth" placeholder="8자리" autocomplete="off" value="" class="input_txt">
                </div>
                <p class="input_error"></p>
            </div>
            <div class="input_join input_box">
                <h3 class="input_title ess">성별</h3>
                <div class="input_item">
                    <input type="radio" id="male" name="sex" value="M">
                    <label for="male">남성</label>
                    <input type="radio" id="female" name="sex" value="F">
                    <label for="female">여성</label>
                </div>
                <p class="input_error"></p>
            </div>
            <div class="input_join input_box">
                <h3 class="input_title">휴대전화번호</h3>
                <div class="input_item">
                    <input type="email" id="mobile_no" placeholder="01012345678" autocomplete="off" value="" class="input_txt">
                </div>
                <p class="input_error"></p>
            </div>
            <div class="input_join option input_box">
                <h3 class="input_title">신발 사이즈</h3>
                <div class="input_item">
                    <input type="text" id="shoe_size" placeholder="250" disabled="disabled" autocomplete="off" value="" class="input_txt hover">
                    <button type="button" class="btn btn_size_select">
                    </button>
                </div>
            </div>
            <a id="btn_register" disabled="disabled" href="#" class="btn btn_join full solid disabled"> 가입하기 </a>
        </div>
    </div><!---->
</div>

<jsp:include page="../common/footer.jsp"/>
</body>
</html>