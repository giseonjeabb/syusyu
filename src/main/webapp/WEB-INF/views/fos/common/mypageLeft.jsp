<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="move-container-left">
    <div class="inner">
        <h3 class="title-t ty3">마이페이지</h3>
        <dl class="mypage-menu-list">
            <dt class="title-t ty7">쇼핑정보</dt>
            <dd><a href="<c:url value="/fos/orderView"/>" class="">주문배송조회</a></dd>
            <dd><a href="" class="">취소/교환/반품 조회</a></dd>
            <dt class="title-t ty7">혜택정보</dt>
            <dd><a href="" class="">쿠폰</a></dd>
            <dd><a href="" class="active">포인트</a></dd>
            <dt class="title-t ty7">쇼핑활동</dt>
            <dd><a href="" class="">상품후기</a></dd>
            <dd><a href="" class="">찜리스트</a></dd>
            <dd><a href="" class="">자주 구매 상품</a></dd>
            <dd><a href="" class="">재입고 알림 신청</a></dd>
            <dt class="title-t ty7">회원정보</dt>
            <dd><a href="" class="">회원정보 변경</a></dd>
            <dd><a href="" class="">배송지 관리</a></dd>
            <dt class="title-t ty7">문의</dt>
            <dd><a href="" class="">상품문의</a></dd>
            <dd><a href="<c:url value='/inqry/inqryList'/>" class="">1:1문의</a></dd>
            <dd><a href="" class="">대량주문문의</a></dd>
            <dt class="title-t ty7">공지</dt>
            <dd><a href="<c:url value='/notice/noticeList'/>" class="">공지사항</a></dd>
            <dd><a href="<c:url value='/faq/faqList'/>" class="">자주 묻는 질문</a></dd>
        </dl>
    </div>
</div>