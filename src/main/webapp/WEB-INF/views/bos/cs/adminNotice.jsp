<%--
  Created by IntelliJ IDEA.
  User: Han
  Date: 2023-07-16
  Time: 오후 2:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.time.LocalDateTime" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>


<%@ page session="true"%>


<head>
    <style>
        @import url(${cssUrlBos}/cs/adminNotice.scss);
    </style>
</head>
<script>
    let msg = "${msg}";
    if (msg == "LIST_ERR") alert("게시물 목록을 가져오는데 실패했습니다. 다시 시도해 주세요.");
    if (msg == "READ_ERR") alert("삭제되었거나 없는 게시물입니다.");

    if (msg == "DEL_ERR") alert("삭제 실패 했습니다..");
    if (msg == "DEL_OK") alert("성공적으로 삭제되었습니다.");
    if (msg == "WRT_OK") alert("성공적으로 등록되었습니다.");
    if (msg == "MOD_OK") alert("성공적으로 수정되었습니다.");
</script>

    <%-----제목 , 내용 -----%>

    <div class="container">
        <h2 class="title-t ty3 mb-30"> 공지사항 </h2>

        <form id="form" class="frm" action="" method="post">

        <input type="hidden" name="notcNo" value="${noticeDTO.notcNo}">

        <colgroup>
            <col style="width: 105px">
            <col style="width: auto">
            <col style="width: 110px">
        </colgroup>


        <tr>
            <input name="title" type="text" class="detail-tit1" value= " ${noticeDTO.title}"  readonly='readonly'/>
        </tr>

<%--            LocalDateTime 버전--%>
<%--                <span class="date-info">--%>
<%--                    등록날짜: <span>${noticeDTO.regDttm.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))}</span><br>--%>
<%--                    <!-- 시작날짜 -->--%>
<%--                            <input type="hidden" name="startDttm"--%>
<%--                           value="${noticeDTO.startDttm.format(DateTimeFormatter.ofPattern('yyyy-MM-dd'))}">--%>

<%--                   <!-- 종료날짜 -->--%>
<%--                            <input type="hidden" name="endDttm"--%>
<%--                           value="${noticeDTO.endDttm.format(DateTimeFormatter.ofPattern('yyyy-MM-dd'))}">--%>
<%--                </span>--%>


<%--           <span class="date-info">--%>
<%--                   등록날짜: <span><fmt:formatDate value="${noticeDTO.regDttm}" pattern="yyyy-MM-dd" /></span><br>--%>
<%--                   시작날짜: <span><fmt:formatDate value="${noticeDTO.startDttm}" pattern="yyyy-MM-dd" /></span><br>--%>
<%--                   종료날짜: <span><fmt:formatDate value="${noticeDTO.endDttm}" pattern="yyyy-MM-dd" /></span>--%>
<%--           </span>--%>



            <span class="date-info">
                등록날짜: <span><fmt:formatDate value="${noticeDTO.regDttm}" pattern="yyyy-MM-dd" /></span><br>
                        <input type="hidden" name="startDate" value="<fmt:formatDate value="${noticeDTO.startDttm}" pattern="yyyy-MM-dd" />" />
                        <input type="hidden" name="endDate" value="<fmt:formatDate value="${noticeDTO.endDttm}" pattern="yyyy-MM-dd" />" />
            </span>



        <textarea name="content" rows="15" class="detail-cont" readonly="readonly">${noticeDTO.content}</textarea>

            <button type="button" id="listBtn" class="btn btn-primary btn-sm"><i class="fa-solid fa-list-ul"></i>  목록</button>
<%--            <button type="button" id="writeBtn" class="btn btn-primary btn-sm"><i class="fa fa-pen-nib"></i>  등록 </button>--%>
            <button type="button" id="modifyBtn" class="btn btn-primary btn-sm"><i class="fa-solid fa-toolbox"></i>  수정</button>
            <button type="button" id="removeBtn" class="btn btn-primary btn-sm"><i class="fa-solid fa-trash"></i>  삭제</button>


<%--    <input name="notcNo" type="text" value="${noticeDTO.notcNo}" readonly="readonly">--%>
<%--    <tr>--%>
<%--     <input name="title" type="text" class="detail-tit1" value="<c:out value= '${noticeDto.title}'/>" placeholder="  제목을 입력해 주세요." ${mode=="new" ? "" : "readonly='readonly'"}><br>--%>
<%--    </tr>--%>
<%--    <textarea name="content" rows="20" class="detail-cont" placeholder=" 내용을 입력해 주세요." ${mode=="new" ? "" : "readonly='readonly'"}><c:out value=" ${noticeDto.content}"/></textarea><br>--%>





        <%-----제목 , 내용 끝 -----%>




            <%-- 하단 이전글 다음글 선택--%>
            <nav class ="detail_nav">
                <br>
                <ul class="prev_next_title">
                    <%--        다음글  : 다음글 제목--%>
                    <%--            다음글이 없다면 empty nextTitle--%>
                    <li class="detail__nav-next">
                        <span class="nextPage">다음 글  &nbsp <i class="fa-sharp fa-solid fa-caret-up"></i></span>
                        <c:if test="${not empty nextTitle}">
                            <a href="/adminNotice/read?notcNo=${noticeDTO.notcNo + 1}">&nbsp; ${nextTitle}</a>
                        </c:if>
                        <c:if test="${empty nextTitle}">
                            <span>&nbsp;다음 글이 존재하지 않습니다. </span>
                        </c:if>
                    </li>

                        <br>    <%--  다음글 이전글 그 사이 공간 추가--%>

                    <%--        이전글 :  이전글 제목--%>
                    <%--        이전글이 없다면 emptyprevTitle--%>
                    <li class="detail__nav-prev">
                        <span class="prevPage">이전 글  &nbsp; <i class="fa-solid fa-caret-down"></i></span>
                        <c:if test="${not empty prevTitle}">
                            <a href="/adminNotice/read?notcNo=${noticeDTO.notcNo - 1}">&nbsp; ${prevTitle}</a>
                        </c:if>
                        <c:if test = "${empty prevTitle}">
                            <span>&nbsp;이전 글이 존재 하지 않습니다. </span>
                        </c:if>
                    </li>

                </ul>
            </nav>


        </form>
    </div>

<script>

    $(document).ready(function (){
         $('#listBtn').on("click", function(){
            location.href = "<c:url value="/adminNotice/list"/>?page=${sc.page}&pageSize=${sc.pageSize}";
         });


        $('#removeBtn').on("click", function(){
            if(!confirm("삭제 하시겠습니까 ?")) return;
           let form =  $('#form');
           <%--form.attr("action", "<c:url value='/adminNotice/remove${searchCondition.queryString}'/>");--%>
           form.attr("action", "<c:url value='/adminNotice/remove'/>?page=${sc.page}&pageSize=${sc.pageSize}");
           form.attr("method", "post");
           form.submit();
        });

    });
</script>