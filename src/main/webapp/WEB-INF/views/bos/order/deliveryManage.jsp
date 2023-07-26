<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
  <script src="<c:url value="${jsUrlBos}/order/deliveryManage.js"/>"></script>
  <script>
    document.addEventListener("DOMContentLoaded", () => {
      deliveryManage.initLoad();
      deliveryManage.bindButtonEvent();
    });
  </script>
</head>
<div class="container-fluid px-4">
  <h1 class="mt-4">배송현황관리</h1>

  <div class="search_form">
    <table>
    </table>
    <div class="button_area">
      <button id="btn_search" class="btn btn-dark">검색</button>
      <button class="btn btn-light">초기화</button>
    </div>
  </div>

  <div class="grid-container">
    <div class="button_area">
    </div>
    <div id="deliveryManageGrid"></div>
  </div>
</div>