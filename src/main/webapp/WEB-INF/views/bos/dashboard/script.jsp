<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<script src="https://code.jquery.com/jquery-1.11.3.js"></script>
<script src="https://kit.fontawesome.com/4fb73240ec.js" crossorigin="anonymous"></script>


<%--s : ============================== 공통함수 ==============================--%>
<%--공통함수--%>
<script src="<c:url value="${jsUrlCommon}/common.js"/>"></script>
<%--ajax 요청 공통 함수 라이브러리--%>
<script src="<c:url value="${jsUrlCommon}/ajax.js"/>"></script>
<script src="<c:url value="${jsUrlBos}/common/bos-common.js"/>"></script>
<script src="<c:url value="${jsUrlCommon}/chart-common.js"/>"></script>
<%--e : ============================== 공통함수 ==============================--%>

<%--부트스트랩 js--%>
<script src="<c:url value="${jsUrlBos}/common/dashboard.js"/>"></script>

<%--s : ============================== summernote ==============================--%>

<script src="<c:url value='/static/bos/summernote/lang/summernote-ko-KR.js'/>"></script>
<script src="<c:url value='/static/bos/summernote/summernote-lite.js'/>"></script>
<%--e : ============================== summernote ==============================--%>

<%--상위메뉴 클릭하면 하위메뉴 나오기.--%>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>

<%--s : ============================== DataTable 게시판 js ==============================--%>
<script src="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/umd/simple-datatables.min.js" crossorigin="anonymous"></script>
<script src="<c:url value="${jsUrlBos}/common/dashboard_demo.js"/>"></script>
<%--e : ============================== fDataTable 게시판 js ==============================--%>

<%--s : ============================== flatpickr 캘린더 라이브러리 ==============================--%>
<script src="https://cdn.jsdelivr.net/npm/flatpickr"></script>
<script src="https://cdn.jsdelivr.net/npm/flatpickr/dist/l10n/ko.js"></script>
<%--e : ============================== flatpickr 캘린더 라이브러리 ==============================--%>

<%--xlsx : 엑셀 라이브러리--%>
<script src="https://unpkg.com/xlsx/dist/xlsx.full.min.js"></script>

<%-- s : ============================== Tabulator ==============================--%>
<!-- Tabulator 라이브러리 -->
<script type="text/javascript" src="https://unpkg.com/tabulator-tables@4.9.3/dist/js/tabulator.min.js"></script>
<%-- Tabulator 공통 함수 --%>
<script src="<c:url value="${jsUrlBos}/common/tabulator-common.js"/>"></script>
<%--e : ============================== Tabulator ==============================--%>

