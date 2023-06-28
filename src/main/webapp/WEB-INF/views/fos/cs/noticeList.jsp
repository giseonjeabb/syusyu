<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ page session="true" %>
<c:set var="loginId" value="${sessionScope.id}"/>
<c:set var="loginOutLink" value="${loginId=='' ? '/login/login' : '/login/logout'}"/>
<c:set var="loginOut" value="${loginId=='' ? 'Login' : 'ID='+=loginId}"/>
<html>
<head>
    <title>syusyu</title>
    <style>
        @import url(${cssUrlFos}/cs/noticeList.scss);
    </style>
</head>
<body>
<jsp:include page="../common/header.jsp"/>

<<<<<<< Updated upstream
<%--
  Created by IntelliJ IDEA.
  User: Han
  Date: 2023-06-27
  Time: AM 10:45
  To change this template use File | Settings | File Templates.
--%>

=======
>>>>>>> Stashed changes

<script>
    let msg = "${msg}";
    if (msg == "LIST_ERR") alert("게시물 목록을 가져오는데 실패했습니다. 다시 시도해 주세요.");
    if (msg == "READ_ERR") alert("삭제되었거나 없는 게시물입니다.");
    if (msg == "DEL_ERR") alert("삭제되었거나 없는 게시물입니다.");

    if (msg == "DEL_OK") alert("성공적으로 삭제되었습니다.");
    if (msg == "WRT_OK") alert("성공적으로 등록되었습니다.");
    if (msg == "MOD_OK") alert("성공적으로 수정되었습니다.");
</script>



<div class="content-mini right-case sections ty2">

    <section>
        <h3 class="title-t ty3 mb-30">공지사항</h3>
        <span class="notice_count">총 ${ph.totalCnt} 개 </span>
        <br>

        <div class="board-container">
            <div class="search-container">
                <form action="<c:url value="/notice/noticeList"/>" class="search-form" method="get">

                    <header class="fb__bbs__header">
                        <h1 class="fb__bbs__header__title"></h1>
                        <span class="count fb__bbs__header__count">
                <em id="keyword"></em> <em id="devTotal"></em>
            </span>

                        <div class="fb__bbs__header__filter">

                            <select id="sType" name="sType">
                                <option value="A"${ph.sc.option=='A' || ph.sc.option=='' ? "selected" : ""}>제목+내용</option>
                                <option value="T" ${ph.sc.option=='T' ? "selected" : ""}>제목</option>
                                <option value="W" ${ph.sc.option=='W' ? "selected" : ""}>내용</option>
                            </select>

                            <input type="text" id="keyword" name="searchText" title="검색어 입력" value="${ph.sc.keyword}" data-ix="{[ix]}"
                                   placeholder="검색어를 입력해주세요">
                            <input type="submit" id="btnSearch" value="검색" class="btn-default btn-dark">
                        </div>
                    </header>



<%--                    <div>--%>
<%--                        <select class="search-option" name="option">--%>
<%--                            <option value="A" ${ph.sc.option=='A' || ph.sc.option=='' ? "selected" : ""}>제목+내용</option>--%>
<%--                            <option value="T" ${ph.sc.option=='T' ? "selected" : ""}>제목만</option>--%>
<%--                            <option value="W" ${ph.sc.option=='W' ? "selected" : ""}>작성자</option>--%>
<%--                        </select>--%>

<%--                    </div>--%>



<%--                    <input type="text" name="keyword" class="search-input" type="text" value="${ph.sc.keyword}"--%>
<%--                           placeholder="검색어를 입력해주세요">--%>
<%--                    <input type="submit" class="search-button" value="검색">--%>


                </form>

                <button id="writeBtn" class="btn-write" onclick="location.href='<c:url value="/board/write"/>'"><i
                        class="fa fa-pencil"></i> 글 작성
                </button>

            </div>



        <div id="ux_page_list">
<<<<<<< Updated upstream
=======


>>>>>>> Stashed changes
            <div class="tbl ty1" page-no="1" page-size="10" total-size="4" total-page="1">
                <table>
                    <colgroup>
                        <col style="width:auto">
                        <col style="width:120px">
                    </colgroup>
                    <tbody>
<<<<<<< Updated upstream
                    <tr>
                        <td>
                            <a href="<c:url value="/board/read${ph.sc.queryString}&notcNo=${noticeDto.notcNo}"/>">
                     <span class="badge-cont single">
                                <span class="badge-item ty4">
                                    <c:out value="${noticeDto.notcTp}"/>
                                </span>
                     </span>
                                ${noticeDto.title}
                            </a>
                        </td>
                        <td class="fz-15 color-3 ta-c">
                            <c:choose>

                            <c:when test="${noticeDto.regDttm.time >= startOfToday}">
                        <td class="regDttm"><fmt:formatDate value="${noticeDto.regDttm}" pattern="HH:mm"
                                                            type="time"/></td>
                        </c:when>

                        <c:otherwise>
                            <td class="regDttm"><fmt:formatDate value="${noticeDto.regDttm}" pattern="yyyy-MM-dd"
                                                                type="date"/></td>
                        </c:otherwise>

                        </c:choose>
                        </td>
                    </tr>


                    </tbody>
                </table>



=======


<div class="board-container">
    <div class="search-container">
        <form action="<c:url value="/notice/noticeList"/>" class="search-form" method="get">

            <div>
                <select class="search-option" name="option">
                    <option value="A" ${ph.sc.option=='A' || ph.sc.option=='' ? "selected" : ""}>제목+내용</option>
                    <option value="T" ${ph.sc.option=='T' ? "selected" : ""}>제목만</option>
                    <option value="W" ${ph.sc.option=='W' ? "selected" : ""}>작성자</option>
                </select>

            </div>

            <input type="text" name="keyword" class="search-input" type="text" value="${ph.sc.keyword}"
                   placeholder="검색어를 입력해주세요">
            <input type="submit" class="search-button" value="검색">


        </form>
        <button id="writeBtn" class="btn-write" onclick="location.href='<c:url value="/notice/write"/>'"><i
                class="fa fa-pencil"></i> 글쓰기
        </button>

    </div>

>>>>>>> Stashed changes
    <table>
        <tr>
<%--            <th class="notcNo">번호</th>--%>
            <th class="notcTp">분류</th>
            <th class="title">제목</th>
<%--            <th class="regDttm">등록일</th>--%>
            <th class="viewCnt">조회수</th>
        </tr>


        <c:forEach var="noticeDto" items="${list}">
            <tr>
                <td class="notcNo">${noticeDto.notcNo}</td>

<%--                타입--%>
                <td class="notcTp"><c:out value="${noticeDto.notcTp}"/></td>

<%--                제목--%>
                <td class="title"><a
                        href="<c:url value="/notice/read${ph.sc.queryString}&notcNo=${noticeDto.notcNo}"/>">${noticeDto.title}</a>
                </td>

<%--                    등록날짜--%>
                <c:choose>

                    <c:when test="${noticeDto.regDttm.time >= startOfToday}">
                        <td class="regDttm"><fmt:formatDate value="${noticeDto.regDttm}" pattern="HH:mm"
                                                            type="time"/></td>
                    </c:when>

                    <c:otherwise>
                        <td class="regDttm"><fmt:formatDate value="${noticeDto.regDttm}" pattern="yyyy-MM-dd"
                                                            type="date"/></td>
                    </c:otherwise>

                </c:choose>

<%--                조회수--%>
<%--                <td class="viewCnt">${noticeDto.viewCnt}</td>--%>

            </tr>
        </c:forEach>

    </table>

    <br>
<%--    페이지 --%>
    <div class="paging-container">
        <div class="paging">
            <c:if test="${ph.totalCnt==null || ph.totalCnt==0}">
            <div> 게시물이 없습니다.</div>
            </c:if>
            <c:if test="${ph.totalCnt!=null && ph.totalCnt!=0}">
            <c:if test="${ph.showPrev}">
            <a class="page" href="<c:url value="/notice/noticeList${ph.sc.getQueryString(ph.beginPage-1)}"/>">&lt;</a>
            </c:if>
            <c:forEach var="i" begin="${ph.beginPage}" end="${ph.endPage}">
            <a class="page ${i==ph.sc.page? "paging-active" : ""}"
               href="<c:url value="/notice/noticeList${ph.sc.getQueryString(i)}"/>">${i}</a>
            </c:forEach>
            <c:if test="${ph.showNext}">
            <a class="page"
               href="<c:url value="/notice/noticeList${ph.sc.getQueryString(ph.endPage+1)}"/>">&gt;</a>
            </c:if>
            </c:if>

        </div>
    </div>
<<<<<<< Updated upstream

</div>


=======
</div>


<section id="sectionForm">
    <div id ="first_div" style="text-align:center">
            <div class="board-container">
                    <span class="search-container">
                            <form action="<c:url value='/notice/noticeList'/>" class="search-form" method="get">

                                <div class="logo_notice">공지사항</div>

                                <span class="notice_count">총 ${ph.totalCnt} 개 </span>

                                    <div class="search_filter">
                                        <select class="search-option" name="option">
                                            <option value="A" ${ph.sc.option=='A' || ph.sc.option=='' ? "selected" : ""}>제목+내용</option>
                                            <option value="T" ${ph.sc.option=='T' ? "selected" : ""}>제목만</option>
                                            <option value="W" ${ph.sc.option=='W' ? "selected" : ""}>작성자</option>
                                        </select>
                                    </div>



                                <input type="text" name="keyword" class="search-input" type="text" value="${ph.sc.keyword}"
                                       placeholder="검색어를 입력해주세요">
                                <input type="submit" class="search-button" value="검색">

<%--                                <button id="writeBtn" class="btn-write" onclick="location.href='<c:url value='/notice/write'/>' "><i--%>
<%--                                        class="fa fa-pencil"></i> 글쓰기--%>
<%--                                </button>--%>
                            </form>
                    </span>
                    </div>
>>>>>>> Stashed changes




<<<<<<< Updated upstream
=======


            <br>

                            <div class="paging-container">
                                    <div class="paging">
                                                <c:if test="${ph.totalCnt==null || ph.totalCnt==0}">
                                                <div> 게시물이 없습니다.</div>
                                                </c:if>
                                            <c:if test="${ph.totalCnt!=null && ph.totalCnt!=0}">

                                                <c:if test="${ph.showPrev}">
                                                <a class="page" href="<c:url value='/notice/noticeList${ph.sc.getQueryString(ph.beginPage-1)}'/>">&lt;</a>
                                                </c:if>

                                                <c:forEach var="i" begin="${ph.beginPage}" end="${ph.endPage}">
                                                     <a class="page ${i==ph.sc.page? "paging-active" : ""}" href="<c:url value='/notice/noticeList${ph.sc.getQueryString(i)}'/>">${i}</a>
                                                </c:forEach>

                                                <c:if test="${ph.showNext}">
                                                <a class="page"
                                                   href="<c:url value='/notice/noticeList${ph.sc.getQueryString(ph.endPage+1)}'/>">&gt;</a>
                                                </c:if>

                                            </c:if>

                                    </div>
                            </div>


            </div>

    </div>
 </section>


>>>>>>> Stashed changes
<jsp:include page="../common/footer.jsp"/>

</body>
</html>
