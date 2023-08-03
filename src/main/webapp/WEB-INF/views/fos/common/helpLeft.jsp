<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="move-container-left">
    <div class="inner">
        <h3 class="title-t ty3">고객센터</h3>
        <ul class="service-list">
            <li><a href="<c:url value='/notice/noticeList'/>" class="">공지사항</a></li>
            <li><a href="<c:url value='/faq/faqList'/>" class="">FAQ</a></li>
            <li><a href="<c:url value='/inqry/inqryList'/>">1:1 문의하기</a></li>
        </ul>
        <dl class="center-info">
            <dt>고객센터</dt>
            <dd class="num">080-123-4567</dd>
            <dd>월 - 금 09:00 - 17:00<br>(점심시간 PM 12:30 - PM 13:30)<br>주말 및 공휴일 휴무</dd>
        </dl>
    </div>
</div>