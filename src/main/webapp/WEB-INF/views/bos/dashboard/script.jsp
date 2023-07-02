<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
