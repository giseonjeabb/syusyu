<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<footer id="main_footer" style="margin-top: 110px;">
    <div class="footer_content">
        <div class="footer_logo">
            <img src="<c:url value="${imgUrl}/logo/syusyuWhiteLogo.png"/>" alt="로고">
        </div>
        <div class="footer_wrapper_info">
            <div class="footer_info" style="float: left; width: 920px;">
                <div class="footer_info_desc"> 상호명 : FORESTALLMENT | 대표자명 : 한기선, 방채민, 이소윤, 김수철 | 사업자등록번호: 123-12-12345 |
                    통신팬매업신고 : 종로구청 제 2023-01234
                </div>
                <div class="footer_info_desc"> 사업장 주소 : 서울 종로구 종로 69 서울YMCA 522 정석코딩 FORESTALLMENT| 대표전화: 080-123-4567
                </div>
                <div class="footer_info_desc"> Copyright © 2023 FORESTALLMENT all rights reserved.</div>
            </div>

            <div class="footer_quickLink" style="float: left;">
                <div class="footer_quickLink_list">
                    <strong class="footer_quickLink_title">NOTICE</strong>
                    <ul class="footer_quickLink_sub">
                        <li class="footer_quickLink_subList"><a href="<c:url value='/notice/noticeList'/>">공지사항</a></li>
                        <li class="footer_quickLink_subList">이용약관</li>
                        <li class="footer_quickLink_subList">개인정보처리방침</li>
                    </ul>
                </div>
                <div class="footer_quickLink_list">
                    <strong class="footer_quickLink_title">SUPPORT</strong>
                    <ul class="footer_quickLink_sub">
                        <li class="footer_quickLink_subList">고객센터</li>
                        <li class="footer_quickLink_subList"><a href="<c:url value='/faq/faqList'/>">FAQ</a></li>
                        <li class="footer_quickLink_subList">교환 & 반품문의</li>
                    </ul>
                </div>
                <div class="footer_sns">
                    <a href="#" class="fa fa-instagram"></a>
                    <a href="#" class="fa fa-facebook"></a>
                    <a href="#" class="fa fa-youtube"></a>
                </div>
            </div>
        </div>
    </div>
</footer>
