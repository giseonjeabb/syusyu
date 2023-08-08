<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<script src="<c:url value="${jsUrlFos}/member/registerForm.js"/>"></script>
<style>
    @import url(${cssUrlFos}/member/register.css);
</style>
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
                    <select name="shoe_size" id="shoe_size" class="input_txt">
                        <option value="220">220</option>
                        <option value="225">225</option>
                        <option value="230">230</option>
                        <option value="235">235</option>
                        <option value="240">240</option>
                        <option value="245">245</option>
                        <option value="250">250</option>
                        <option value="255">255</option>
                        <option value="260">260</option>
                        <option value="265">265</option>
                        <option value="270">270</option>
                        <option value="275">275</option>
                        <option value="280">280</option>
                        <option value="285">285</option>
                        <option value="290">290</option>
                        <option value="295">295</option>
                        <option value="300">300</option>
                    </select>

                    <button type="button" class="btn btn_size_select">
                    </button>
                </div>
            </div>
            <a id="btn_register" disabled="disabled" href="#" class="btn full solid"> 가입하기 </a>
        </div>
    </div><!---->
</div>