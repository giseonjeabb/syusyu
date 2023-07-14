<%--
  Created by IntelliJ IDEA.
  User: Han
  Date: 2023-07-10
  Time: 오후 1:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ page session="true" %>
<c:set var="loginId" value="${sessionScope.id}"/>
<c:set var="loginOutLink" value="${loginId=='' ? '/login/login' : '/login/logout'}"/>
<c:set var="loginOut" value="${loginId=='' ? 'Login' : 'ID='+=loginId}"/>

<head>
  <style>
    @import url(${cssUrlFos}/cs/admminNotice.scss);
  </style>
</head>
<script>
  let msg = "${msg}";
  if (msg == "DEL_ERR") alert("삭제되었거나 없는 게시물입니다.");
  if (msg == "DEL_OK") alert("성공적으로 삭제되었습니다.");
  if (msg == "WRT_OK") alert("성공적으로 등록되었습니다.");
  if (msg == "MOD_OK") alert("성공적으로 수정되었습니다.");
</script>

<div class = all-board>

  <div class="fb__bbs__header">
    <h3 class="title-t ty3 mb-30">공지사항 ${mode=="new" ? " 등록 " : " "} </h3>
  </div>

</div>