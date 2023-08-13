<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- jquery --%>
<script src="https://code.jquery.com/jquery-1.11.3.js"></script>

<%--underscore 라이브러리(디바운드 사용 위함)--%>
<script src= "https://cdnjs.cloudflare.com/ajax/libs/underscore.js/1.9.1/underscore-min.js"> </script>

<%--공통 전역변수 --%>
<%@ include file="global.jsp" %>

<%--s : ============================== 공통함수 ==============================--%>
<%--공통함수--%>
<script src="<c:url value="${jsUrlCommon}/common.js"/>"></script>
<script src="<c:url value="${jsUrlCommon}/utils.js"/>"></script>
<%--ajax 요청 공통 함수 라이브러리--%>
<script src="<c:url value="${jsUrlCommon}/ajax.js"/>"></script>
<%--팝업 공통 함수 라이브러리--%>
<script src="<c:url value="${jsUrlFos}/common/popup.js"/>"></script>
<%--e : ============================== 공통함수 ==============================--%>
<%-- flatpickr 캘린더 라이브러리 --%>
<script src="https://cdn.jsdelivr.net/npm/flatpickr"></script>
<script src="https://cdn.jsdelivr.net/npm/flatpickr/dist/l10n/ko.js"></script>
<%--공통 top 버튼--%>
<script src="${jsUrlCommon}/scrollToTop.js"></script>
