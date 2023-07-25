<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<script src="https://code.jquery.com/jquery-1.11.3.js"></script>
<script src="https://kit.fontawesome.com/4fb73240ec.js" crossorigin="anonymous"></script>

<%--부트스트랩 js--%>
<script src="<c:url value="${jsUrlBos}/common/dashboard.js"/>"></script>
<%--상위메뉴 클릭하면 하위메뉴 나오기.--%>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>

<%--페이지들만들면 삭제할 js--%>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
<script src="<c:url value="${jsUrlBos}/common/chart-area-demo.js"/>" defer></script>
<script src="<c:url value="${jsUrlBos}/common/chart-bar-demo.js"/>" defer></script>
<script src="<c:url value="${jsUrlBos}/common/chart-pie-demo.js"/>" defer></script>


<%--DataTable 게시판 js--%>
<script src="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/umd/simple-datatables.min.js" crossorigin="anonymous"></script>
<script src="<c:url value="${jsUrlBos}/common/dashboard_demo.js"/>"></script>

<!-- Tabulator 자바스크립트 라이브러리를 페이지에 포함시킨다. -->
<script type="text/javascript" src="https://unpkg.com/tabulator-tables@4.9.3/dist/js/tabulator.min.js"></script>

<%--상품등록--%>
<script src="<c:url value="${jsUrlBos}/product/productRegister.js"/>"></script>

<%--공통함수--%>
<script src="<c:url value="${jsUrlCommon}/common.js"/>"></script>
<%--ajax 요청 공통 함수 라이브러리--%>
<script src="<c:url value="${jsUrlCommon}/ajax.js"/>"></script>

<%--tabulator 공통 함수--%>
<script src="<c:url value="${jsUrlBos}/common/tabulator-common.js"/>"></script>

<%-- flatpickr 캘린더 라이브러리 --%>
<script src="https://cdn.jsdelivr.net/npm/flatpickr"></script>
<script src="https://cdn.jsdelivr.net/npm/flatpickr/dist/l10n/ko.js"></script>
