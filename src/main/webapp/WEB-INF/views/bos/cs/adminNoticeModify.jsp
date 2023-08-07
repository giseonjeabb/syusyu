<%@ page import="java.time.LocalDateTime" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>


<head>
  <script src="<c:url value='/static/bos/summernote/summernote-lite.js'/>"></script>
  <link href="<c:url value='/static/bos/summernote/summernote-lite.css'/>" rel="stylesheet">
  <script src="<c:url value='/static/bos/summernote/lang/summernote-ko-KR.js'/>"></script>

    <style>
      @import url(${cssUrlBos}/cs/adminNoticeModify.scss);
    </style>
</head>

<script>
  let msg = "${msg}";
  if (msg == "LIST_ERR") alert("게시물 목록을 가져오는데 실패했습니다. 다시 시도해 주세요.");
  if (msg == "MOD_OK") alert("성공적으로 글이 수정되었습니다.");
  if (msg == "MOD_ERR") alert("게시물 수정 하는데 실패 했습니다.");
  // Add other messages here
</script>

<!-- Form for writing a notice -->
<div class="container">
  <h2 class="title-t ty3 mb-30">공지사항 수정</h2>


<%--  <form id="form" class="frm" action="<c:url value='/adminNotice/modify'/>" method="post">--%>
  <form id="form" class="frm" action="<c:url value='/adminNotice/modify'/>" method="post">

       <input type="hidden" name="notcNo" value="${noticeDTO.notcNo}">

    <!-- Notice Type -->
    <div class="form-group">
      <label for="exampleSelect1" class="form-label mt-4">공지사항 종류</label>
      <select class="form-select" name="notcTp" id="exampleSelect1">
        <option value="10" ${noticeDTO.notcTp == '10' ? 'selected' : ''}> 배송 </option>
        <option value="20" ${noticeDTO.notcTp == '20' ? 'selected' : ''}> 전체 공지 </option>
        <option value="30" ${noticeDTO.notcTp == '30' ? 'selected' : ''}> 이벤트 </option>
      </select>
    </div><br>

    <input name = notcNo type="hidden" value="${noticeDTO.notcNo}">

    <!-- Notice Title -->
    제목
    <input name="title" type="text" value="${noticeDTO.title}" class="detail-tit1" placeholder="제목을 입력해 주세요." required><br>

    <!-- Notice Content -->

    상세내용
    <textarea id="summernote" name="content" rows="15" class="detail-cont" placeholder="내용을 입력해 주세요." required>${noticeDTO.content}</textarea>



    <!-- Start Date -->
    공지사항 시작 날짜
    <input type="date" id="noticeCalendar1" name="startDttm" value='<fmt:formatDate value="${noticeDTO.startDttm}" pattern="yyyy-MM-dd" />' required>

  <%--    <input type="date" id = noticeCalendar1 name="startDttm" value = "${noticeDTO.startDttm}" required>--%>

    <!-- End Date -->
    공지사항 종료 날짜
    <input type="date" id="noticeCalendar2" name="endDttm" value='<fmt:formatDate value="${noticeDTO.endDttm}" pattern="yyyy-MM-dd" />' required>
<%--    <input type="date" id = noticeCalendar2  name="endDttm" value = "${noticeDTO.endDttm}" required>--%>

<%--    value = "${noticeDTO.startDttm}"--%>


    <!-- Buttons -->
    <button type="button" id="listBtn" class="btn btn-primary btn-sm"><i class="fa-solid fa-list-ul"></i> 목록</button>
    <button type="submit" id="writeBtn" class="btn btn-primary btn-sm"><i class="fa fa-pen-nib"></i> 수정</button>
  </form>
</div>

<!-- Show success or error messages -->
<script>

  // Define button click event handlers
  $(document).ready(function() {

    $('#summernote').summernote({
      placeholder: 'Hello stand alone ui',
      tabsize: 2,
      height: 300,
      toolbar: [
        ['style', ['style']],
        ['font', ['bold', 'underline', 'clear']],
        ['color', ['color']],
        ['para', ['ul', 'ol', 'paragraph']],
        ['table', ['table']],
        ['insert', ['link', 'picture', 'video']],
        ['view', ['fullscreen', 'codeview', 'help']]
      ]
    });


    $("#listBtn").on("click", function(){
      location.href="<c:url value='/adminNotice/list${searchCondition.queryString}'/>";


      // java.lang.NullPointerException
      <%--location.href = "<c:url value="/adminNotice/list"/>?page=${sc.page}&pageSize=${sc.pageSize}";--%>

    });

  });

</script>