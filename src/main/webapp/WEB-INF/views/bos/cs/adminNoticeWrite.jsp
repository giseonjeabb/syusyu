<%@ page import="java.time.LocalDateTime" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>


<head>
  <style>
    @import url(${cssUrlBos}/cs/adminNoticeWrite.scss);
  </style>
</head>

<script>
  let msg = "${msg}";
  if (msg == "LIST_ERR") alert("게시물 목록을 가져오는데 실패했습니다. 다시 시도해 주세요.");
  if (msg == "WRT_OK") alert("성공적으로 등록되었습니다.");
  if (msg == "WRT_ERR") alert("게시물 작성 하는데 실패 했습니다.");
  // Add other messages here
</script>

<!-- Form for writing a notice -->
<div class="container">
  <h2 class="title-t ty3 mb-30">공지사항 작성</h2>

  <form id="form" class="frm" action="<c:url value='/adminNotice/write'/>" method="post">

<%--   <input type="hidden" name="notcNo" value="${noticeDTO.notcNo}">--%>

    <!-- Notice Type -->
    <div class="form-group">
      <label for="exampleSelect1" class="form-label mt-4">공지사항 종류</label>
      <select class="form-select" name = "notcTp" id="exampleSelect1">
        <option value="10"> 배송  </option>
        <option value="20"> 전체 공지 </option>
        <option value="30"> 이벤트 </option>
      </select>
    </div><br>


    <!-- Notice Title -->
    제목
    <input name="title" type="text" class="detail-tit1" placeholder="제목을 입력해 주세요." required><br>

    <!-- Notice Content -->
    상세내용
    <textarea name="content" rows="15" class="detail-cont" placeholder="내용을 입력해 주세요." required></textarea>



    <!-- Start Date -->
    공지사항 시작 날짜
    <input type="date" id = noticeCalendar name="startDttm" required>

    <!-- End Date -->
    공지사항 종료 날짜
    <input type="date" id = noticeCalendar  name="endDttm"  required>




    <!-- Buttons -->
    <button type="button" id="listBtn" class="btn btn-primary btn-sm"><i class="fa-solid fa-list-ul"></i> 목록</button>
    <button type="submit" id="writeBtn" class="btn btn-primary btn-sm"><i class="fa fa-pen-nib"></i> 등록</button>
  </form>
</div>

<!-- Show success or error messages -->
<script>

  // Define button click event handlers
  $(document).ready(function() {

    <%--$('#listBtn').on("click", function() {--%>
    <%--  location.href = "<c:url value='/adminNotice/list'/>?page=${sc.page}&pageSize=${sc.pageSize}";--%>
    <%--});--%>



      $("#listBtn").on("click", function(){
          location.href="<c:url value='/adminNotice/list${searchCondition.queryString}'/>";
      });
  });

</script>