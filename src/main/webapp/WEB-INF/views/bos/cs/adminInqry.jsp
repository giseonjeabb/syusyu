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
  <h2 class="title-t ty3 mb-30">답변 작성</h2>

  <form id="form" class="frm" action="" method="post">

<%--   <input type="hidden" name="notcNo" value="${noticeDTO.notcNo}">--%>

    <br>
    <!-- Notice Content -->
    답변내용
    <textarea name="ansCn" rows="15" class="detail-cont" placeholder="내용을 입력해 주세요." required></textarea>

    <!-- Buttons -->
    <button type="button" id="listBtn" class="btn btn-primary btn-sm"><i class="fa-solid fa-list-ul"></i> 목록</button>
    <button type="submit" id="writeBtn" class="btn btn-primary btn-sm"><i class="fa fa-pen-nib"></i> 등록</button>
  </form>
</div>

<!-- Show success or error messages -->
<script>



    $(document).ready(function() {
        $('#listBtn').on("click", function() {
            // 목록 버튼 클릭 시 '/adminInqry/adminInqryList'로 이동합니다.
            location.href = "<c:url value='/adminInqry/adminInqryList' />";
        });
    });


</script>