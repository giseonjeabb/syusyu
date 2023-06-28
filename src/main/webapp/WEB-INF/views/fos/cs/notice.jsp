<%--
  Created by IntelliJ IDEA.
  User: Han
  Date: 2023-06-27
<<<<<<< Updated upstream
<<<<<<< Updated upstream
  Time: AM 10:23
  To change this template use File | Settings | File Templates.
--%>


=======
  Time: AM 10:40
  To change this template use File | Settings | File Templates.
--%>
>>>>>>> Stashed changes
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true"%>
<html>
<head>
<<<<<<< Updated upstream
    <script src="https://code.jquery.com/jquery-1.11.3.js"></script>
    <title>syusyu</title>
</head>
<body>
<jsp:include page="../common/header.jsp"/>
=======
    <title>syusyu</title>
</head>
<body>
<jsp:include page="./fos/common/header.jsp"/>
>>>>>>> Stashed changes

<script>
    let msg = ${msg};
    if(msg == "Write_Error") alert("글 등록 실패 했습니다.");
    if(msg == "Modify_Error") alert("글 수정 실패 했습니다.");
</script>

<div class="container">
    <h2 class="writing-header">게시판 ${mode=="new" ? "글쓰기" : "읽기"}</h2>
    <form id="form" class="frm" action="" method="post">
        <input type="hidden" name="notcNo" value="${noticeDto.notcNo}">

<<<<<<< Updated upstream
        <input name="title" type="text" value="<c:out value= '${noticeDto.title}'/>" placeholder="  제목을 입력해 주세요." ${mode=="new" ? "" : "readonly='readonly'"}><br>
        <textarea name="content" rows="20" placeholder=" 내용을 입력해 주세요." ${mode=="new" ? "" : "readonly='readonly'"}><c:out value=" ${noticeDto.content}"/></textarea><br>

<%--        지우지 마세요 다른 게시판에서 쓸껍니다 .--%>

<%--        <c:if test="${mode eq 'new'}">--%>
<%--            <button type="button" id="writeBtn" class="btn btn-write"><i class="fa fa-pencil"></i> 등록</button>--%>
<%--        </c:if>--%>

<%--        <c:if test="${mode ne 'new'}">--%>
<%--            <button type="button" id="writeNewBtn" class="btn btn-write"><i class="fa fa-pencil"></i> 글쓰기</button>--%>
<%--        </c:if>--%>

<%--        <c:if test="${noticeDto.regrId eq loginId}">--%>
<%--            <button type="button" id="modifyBtn" class="btn btn-modify"><i class="fa fa-edit"></i> 수정</button>--%>
<%--            <button type="button" id="removeBtn" class="btn btn-remove"><i class="fa fa-trash"></i> 삭제</button>--%>
<%--        </c:if>--%>

=======
        <input name="title" type="text" value="<c:out value= '${boardDto.title}'/>" placeholder="  제목을 입력해 주세요." ${mode=="new" ? "" : "readonly='readonly'"}><br>
        <textarea name="content" rows="20" placeholder=" 내용을 입력해 주세요." ${mode=="new" ? "" : "readonly='readonly'"}><c:out value=" ${noticeDto.content}"/></textarea><br>

        <c:if test="${mode eq 'new'}">
            <button type="button" id="writeBtn" class="btn btn-write"><i class="fa fa-pencil"></i> 등록</button>
        </c:if>
        <c:if test="${mode ne 'new'}">
            <button type="button" id="writeNewBtn" class="btn btn-write"><i class="fa fa-pencil"></i> 글쓰기</button>
        </c:if>
        <c:if test="${boardDto.writer eq loginId}">
            <button type="button" id="modifyBtn" class="btn btn-modify"><i class="fa fa-edit"></i> 수정</button>
            <button type="button" id="removeBtn" class="btn btn-remove"><i class="fa fa-trash"></i> 삭제</button>
        </c:if>
>>>>>>> Stashed changes
        <button type="button" id="listBtn" class="btn btn-list"><i class="fa fa-bars"></i> 목록</button>
    </form>
</div>



<script>
    $(document).ready(function(){
        let formCheck = function() {
            let form = document.getElementById("form");
            if(form.title.value=="") {
                alert("제목을 입력해 주세요.");
                form.title.focus();
                return false;
            }

            if(form.content.value=="") {
                alert("내용을 입력해 주세요.");
                form.content.focus();
                return false;
            }
            return true;
        }

        $("#writeNewBtn").on("click", function(){
            location.href="<c:url value='/notice/write'/>";
        });

        $("#writeBtn").on("click", function(){
            let form = $("#form");
            form.attr("action", "<c:url value='/notice/write'/>");
            form.attr("method", "post");

            if(formCheck())
                form.submit();
        });

        $("#modifyBtn").on("click", function(){
            let form = $("#form");
            let isReadonly = $("input[name=title]").attr('readonly');

            // 1. 읽기 상태이면, 수정 상태로 변경
            if(isReadonly=='readonly') {
                $(".writing-header").html("게시판 수정");
                $("input[name=title]").attr('readonly', false);
                $("textarea").attr('readonly', false);
                $("#modifyBtn").html("<i class='fa fa-pencil'></i> 등록");
                return;
            }

            // 2. 수정 상태이면, 수정된 내용을 서버로 전송
            form.attr("action", "<c:url value='/notice/modify${searchCondition.queryString}'/>");
            form.attr("method", "post");
            if(formCheck())
                form.submit();
        });

        $("#removeBtn").on("click", function(){
            if(!confirm("정말로 삭제하시겠습니까?")) return;

            let form = $("#form");
            form.attr("action", "<c:url value='/notice/remove${searchCondition.queryString}'/>");
            form.attr("method", "post");
            form.submit();
        });

        $("#listBtn").on("click", function(){
<<<<<<< Updated upstream
            location.href="<c:url value='/notice/noticeList${searchCondition.queryString}'/>";
=======
            location.href="<c:url value='/notice/list${searchCondition.queryString}'/>";
>>>>>>> Stashed changes
        });
    });
</script>








<<<<<<< Updated upstream
<jsp:include page="../common/footer.jsp"/>

>>>>>>> Stashed changes
=======

<jsp:include page="./fos/common/footer.jsp"/>
>>>>>>> Stashed changes
</body>
</html>
