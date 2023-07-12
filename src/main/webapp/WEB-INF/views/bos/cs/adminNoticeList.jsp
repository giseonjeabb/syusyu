<%--
  Created by IntelliJ IDEA.
  User: Han
  Date: 2023-07-10
  Time: 오전 10:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>

<head>
    <style>
        @import url(${cssUrlBos}/cs/adminNoticeList.scss);
    </style>
</head>
<script>
    let msg = "${msg}";
    if (msg == "LIST_ERR") alert("게시물 목록을 가져오는데 실패했습니다. 다시 시도해 주세요.");
    if (msg == "READ_ERR") alert("삭제되었거나 없는 게시물입니다.");

    if (msg == "DEL_ERR") alert("삭제되었거나 없는 게시물입니다.");
    if (msg == "DEL_OK") alert("성공적으로 삭제되었습니다.");
    if (msg == "WRT_OK") alert("성공적으로 등록되었습니다.");
    if (msg == "MOD_OK") alert("성공적으로 수정되었습니다.");
</script>
<div class = all-board>

        <div class="fb__bbs__header">
            <h3 class="title-t ty3 mb-30">공지사항 관리 </h3>
        </div>


<%--검색 바  : 제목 + 내용 , 제목 , 내용 항목--%>

    <div class="search">
        <form action="<c:url value="/adminNotice/list"/>" class="d-flex-1">

<%--            pannel heading--%>
            <div class="panel panel-seller">
                    <div class="panel-heading">
                            <div class="pull-left">
                                <h3 class="panel-title"> 공지사항 조회 </h3>
                            </div>

                            <div class="pull-right">
                                <button type="writeBtn" class="btn btn-primary btn-sm" onclick="location.href='<c:url value="/adminNotice/write"/>'"><i class="fa fa-pen-nib"></i> &nbsp; 공지사항 작성</button>
                            </div>
                    </div>


<%--                pannel - body--%>
                <div class="panel-body">
                    <div class="seller-search-section">

                        <div class = "input-search">검색어</div>
                                <div class = "input-content">
                                    <select id="sType" class="search-option" name="option">
                                        <option value="A" ${ph.sc.option=='A' || ph.sc.option=='' ? "selected" : ""}>제목 + 내용</option>
                                        <option value="T" ${ph.sc.option=='T' ? "selected" : ""}>제목만</option>
                                        <option value="C" ${ph.sc.option=='C' ? "selected" : ""}>내용만</option>
                                        <option value="N" ${ph.sc.option=='N' ? "selected" : ""}>공지사항 번호</option>
                                    </select> <i class="fa-solid fa-caret-down"></i>

                                    <input type="text" id="noticeSearchText" name="keyword" class="search-input" type="text" value="${ph.sc.keyword}"
                                           placeholder="Search keyword">
                                    <input type="submit" id="btnSearch" class="btn btn-secondary my-2 my-sm-0" value="Search">
                                </div>
                    </div>

                </div>

            </div> <%-- panel panel-seller--%>

        </form>

    </div>   <%---search--%>



<div class="notice-list">공지 사항 목록
    <%--    게시글 갯수 카운팅--%>
    <span class="notice_count">(총 ${ph.totalCnt}개)</span>
</div>

<table class="table table-hover">

    <tr class="table-dark">
        <th scope="col">번호</th>
        <th scope="col">공지사항 분류 코드</th>
        <th scope="col">제목</th>
        <th scope="col">조회수</th>
        <th scope="col">등록 일자</th>
        <th scope="col">수정 일자</th>
        <th scope="col">공지 시작</th>
        <th scope="col">공지 종료</th>

    </tr>

<c:forEach var="noticeDto" items="${list}">
    <tr class="table-light">
        <td scope="row">${noticeDto.notcNo}</td>        <%---공지사항 분류---%>
        <td><c:out value="${noticeDto.notcTp}"/></td>   <%---공지사항 타입---%>
        <td><a href="<c:url value="/notice/read${ph.sc.queryString}&notcNo=${noticeDto.notcNo}"/>"> ${noticeDto.title}</a></td> <%---공지사항 제목---%>
        <td>${noticeDto.viewCnt}</td>                   <%---공지사항 조회수---%>


            <%---공지사항 등록날짜---%>
       <c:choose>
            <c:when test="${noticeDto.regDttm.time >= startOfToday}">
                <td><fmt:formatDate value="${noticeDto.regDttm}" pattern="HH:mm" type="time"/></td>
            </c:when>

            <c:otherwise>
                <td><fmt:formatDate value="${noticeDto.regDttm}" pattern="yyyy-MM-dd" type="date"/></td>
            </c:otherwise>
        </c:choose>


            <%---공지사항 수정 날짜---%>
        <c:choose>
            <c:when test="${noticeDto.updDttm.time >= startOfToday}">
                <td><fmt:formatDate value="${noticeDto.updDttm}" pattern="HH:mm" type="time"/></td>
            </c:when>

            <c:otherwise>
                <td><fmt:formatDate value="${noticeDto.updDttm}" pattern="yyyy-MM-dd" type="date"/></td>
            </c:otherwise>
        </c:choose>

            <%---공지사항 시작 날짜---%>
        <c:choose>
            <c:when test="${noticeDto.startDttm.time >= startOfToday}">
                <td><fmt:formatDate value="${noticeDto.startDttm}" pattern="HH:mm" type="time"/></td>
            </c:when>

            <c:otherwise>
                <td><fmt:formatDate value="${noticeDto.startDttm}" pattern="yyyy-MM-dd" type="date"/></td>
            </c:otherwise>
        </c:choose>

            <%---공지사항 종료 날짜---%>
        <c:choose>
            <c:when test="${noticeDto.endDttm.time <= startOfToday}">
                <td><fmt:formatDate value="${noticeDto.endDttm}" pattern="HH:mm" type="time"/></td>
            </c:when>

            <c:otherwise>
                <td><fmt:formatDate value="${noticeDto.endDttm}" pattern="yyyy-MM-dd" type="date"/></td>
            </c:otherwise>
        </c:choose>


    </tr>
</c:forEach>


</table>


    <%--페이지 이동 페이지 핸들링--%>
    <%--  << <  1 2 3 4 5 6 7 8 9 10 > >>  --%>
    <br>


    <div id="devPageWrap">
        <div class="wrap-pagination">
            <c:if test="${ph.totalCnt==null || ph.totalCnt==0}">
                <div> 게시물이 없습니다.</div>
            </c:if>

            <c:if test="${ph.totalCnt!=null && ph.totalCnt!=0}">

                <c:if test="${ph.showFirst}">
                    <a class="page" href="<c:url value='/adminNotice/list${pg.sc.getQueryString(ph.beginPage)}'/>"><i class="fa-solid fa-angles-left"></i></a>
                </c:if>

                <c:if test="${ph.showPrev}">
                    <a class="page"
                       href="<c:url value='/adminNotice/list${ph.sc.getQueryString(ph.beginPage-1)}'/>"><i class="fa-solid fa-angle-left"></i></a>
                </c:if>

                <c:forEach var="i" begin="${ph.beginPage}" end="${ph.endPage}">
                    <a class="page ${i==ph.sc.page? "paging-active" : ""}"
                       href="<c:url value='/adminNotice/list${ph.sc.getQueryString(i)}'/>">${i}</a>
                </c:forEach>

                <c:if test="${ph.showNext}">
                    <a class="page" href="<c:url value='/adminNotice/list${ph.sc.getQueryString(ph.endPage+1)}'/>"><i class="fa-solid fa-angle-right"></i></a>
                </c:if>

                <c:if test="${ph.showLast}">
                    <a class="page"
                       href="<c:url value='/adminNotice/list${ph.sc.getQueryString(ph.totalPage)}'/>"><i class="fa-solid fa-angles-right"></i></a>
                </c:if>

            </c:if>



        </div>
    </div>
</div>

