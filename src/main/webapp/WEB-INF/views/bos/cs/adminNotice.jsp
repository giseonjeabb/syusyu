<%--
  Created by IntelliJ IDEA.
  User: Han
  Date: 2023-07-16
  Time: 오후 2:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true"%>


<head>
    <style>
        @import url(${cssUrlBos}/cs/adminNotice.scss);
    </style>
</head>

<div class = all-board>
<%--    &lt;%&ndash;검색 바  : 제목 + 내용 , 제목 , 내용 항목&ndash;%&gt;--%>

<%--    <div class="search">--%>
<%--        <form action="<c:url value="/adminNotice/list"/>" class="d-flex-1">--%>

<%--            &lt;%&ndash;pannel heading&ndash;%&gt;--%>
<%--            <div class="panel panel-seller">--%>
<%--                <div class="panel-heading">--%>
<%--                    <div class="pull-left">--%>
<%--                        <h3 class="panel-title"> 공지사항 조회 </h3>--%>
<%--                    </div>--%>

<%--                    <div class="pull-right">--%>
<%--                        <button type="writeBtn" class="btn btn-primary btn-sm" onclick="location.href='<c:url value="/adminNotice/write"/>'"><i class="fa fa-pen-nib"></i> &nbsp; 공지사항 작성</button>--%>
<%--                    </div>--%>
<%--                </div>--%>


<%--                &lt;%&ndash;pannel - body&ndash;%&gt;--%>
<%--                <div class="panel-body">--%>
<%--                    <div class="seller-search-section">--%>

<%--                        <div class = "input-search">검색어</div>--%>
<%--                        <div class = "input-content">--%>
<%--                            <select id="sType" class="search-option" name="option">--%>
<%--                                <option value="A" ${ph.sc.option=='A' || ph.sc.option=='' ? "selected" : ""}>제목 + 내용</option>--%>
<%--                                <option value="T" ${ph.sc.option=='T' ? "selected" : ""}>제목만</option>--%>
<%--                                <option value="C" ${ph.sc.option=='C' ? "selected" : ""}>내용만</option>--%>
<%--                                <option value="N" ${ph.sc.option=='N' ? "selected" : ""}>공지사항 번호</option>--%>
<%--                            </select>--%>

<%--                            <i id="searchIcon" class="fa-solid fa-angle-down"></i>--%>
<%--&lt;%&ndash;                            <i class="fa-solid fa-caret-down"></i>&ndash;%&gt;--%>

<%--                            <input type="text" id="noticeSearchText" name="keyword" class="search-input" type="text" value="${ph.sc.keyword}"--%>
<%--                                   placeholder="Search keyword">--%>
<%--                            <input type="submit" id="btnSearch" class="btn btn-secondary my-2 my-sm-0" value="Search">--%>
<%--                        </div>--%>
<%--                    </div>--%>

<%--                </div>--%>

<%--            </div> &lt;%&ndash; panel panel-seller&ndash;%&gt;--%>

<%--        </form>--%>

<%--    </div>   &lt;%&ndash;-search&ndash;%&gt;--%>
<%--<hr>--%>
    <%-----상단 제목 , 검색바 끝-----------%>




        <%-----제목 , 내용 -----%>

        <div class="notice-list">
            공지 사항
        </div>
        <form action="" id = "form">
        <input type="hidden" name="notcNo" value="${noticeDTO.notcNo}">

        <colgroup>
            <col style="width: 105px">
            <col style="width: auto">
            <col style="width: 110px">
        </colgroup>

        <tr>
        <input name="title" type="text" class="detail-tit1" value= " ${noticeDTO.title}"  readonly='readonly'/>
        </tr><br>
        <textarea name="content" rows="15" class="detail-cont" readonly="readonly">${noticeDTO.content} </textarea>


<%--    <input name="notcNo" type="text" value="${noticeDTO.notcNo}" readonly="readonly">--%>
<%--    <tr>--%>
<%--     <input name="title" type="text" class="detail-tit1" value="<c:out value= '${noticeDto.title}'/>" placeholder="  제목을 입력해 주세요." ${mode=="new" ? "" : "readonly='readonly'"}><br>--%>
<%--    </tr>--%>
<%--    <textarea name="content" rows="20" class="detail-cont" placeholder=" 내용을 입력해 주세요." ${mode=="new" ? "" : "readonly='readonly'"}><c:out value=" ${noticeDto.content}"/></textarea><br>--%>

            <button type="button" id="listBtn" class="btn btn-primary btn-sm"><i class="fa-solid fa-list-ul"></i>  목록</button>
            <button type="button" id="writeBtn" class="btn btn-primary btn-sm"><i class="fa fa-pen-nib"></i>  등록 </button>
            <button type="button" id="modifyBtn" class="btn btn-primary btn-sm"><i class="fa-solid fa-toolbox"></i>  수정</button>
            <button type="button" id="removeBtn" class="btn btn-primary btn-sm"><i class="fa-solid fa-trash"></i>  삭제</button>
        </form>



        <%-----제목 , 내용 끝 -----%>




    <%-- 하단 이전글 다음글 선택--%>
    <nav class ="detail_nav">
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

            <br>

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