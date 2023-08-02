    <%--
      Created by IntelliJ IDEA.
      User: Han
      Date: 2023-07-10
      Time: 오전 10:41
      To change this template use File | Settings | File Templates.
    --%>
    <%@ page import="java.time.LocalDate" %>
    <%@ page import="java.time.LocalDateTime" %>
    <%@ page import="java.time.format.DateTimeFormatter" %>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>


    <head>
        <style>
            @import url(${cssUrlBos}/cs/adminInqryList.scss);
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

    <section>
    <div class = all-board>
        <div class="fb__bbs__header">
            <h3 class="title-t ty3 mb-30"><a href="<c:url value="/adminInqry/adminInqryList"/>"> 문의사항 관리 </a></h3>
        </div>


        <%--검색 바  : 제목 + 내용 , 제목 , 내용 항목--%>

        <form action="<c:url value="/adminInqry/adminInqryList"/>" class="d-flex-1">

        <%--            pannel heading--%>
                <div class="panel panel-seller">
                    <div class="panel-heading">
                    </div>


                    <%--                pannel - body--%>
<%--                    <div class="panel-body">--%>
<%--                        <div class="seller-search-section">--%>
<%--                            <div class = "input-search">검색어</div>--%>
<%--                            <div class = "input-content">--%>
<%--                                <select id="sType" class="search-option" name="option">--%>
<%--                                    <option value="A" ${ph.option=='A' || ph.sc.option=='' ? "selected" : ""}>제목 + 내용</option>--%>
<%--                                    <option value="T" ${ph.option=='T' ? "selected" : ""}>제목만</option>--%>
<%--                                    <option value="C" ${ph.option=='C' ? "selected" : ""}>내용만</option>--%>
<%--                                    <option value="N" ${ph.option=='N' ? "selected" : ""}>문의사항 번호</option>--%>
<%--                                </select> <i class="fa-solid fa-caret-down"></i>--%>

<%--                                <input type="text" id="noticeSearchText" name="keyword" class="search-input" type="text" value="${ph.sc.keyword}"--%>
<%--                                       placeholder="Search keyword">--%>
<%--                                <input type="submit" id="btnSearch" class="btn btn-secondary my-2 my-sm-0" value="Search">--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                    </div>--%>

                </div> <%-- panel panel-seller--%>

            </form>

<%--            <div class="pull-right">--%>
<%--                <button type="button" id="writeNewBtn" class="btn btn-primary btn-sm" onclick="location.href='<c:url value='/adminNotice/write'/>'">--%>
<%--                    <i class="fa fa-pen-nib"></i> &nbsp; 문의사항 작성</button>--%>
<%--            </div>--%>

        <form id="form" class="frm" action="" method="post">
            <div class="notice-list">문의사항 목록
                <c:set var="inqryCount" value="${inqryService.getCount()}" />
                <%--    게시글 갯수 카운팅--%>
                <span class="text fz-15" id="accordion">총<strong>${totalCnt}</strong>개</span>
            </div>

            <table class="table table-hover">

                <tr id="id-Table-dark" class="table-dark">
                    <th scope="col">번호</th>
                    <th scope="col">문의사항 종류</th>
                    <th scope="col">제목</th>
                    <th scope="col">문의 작성자 ID</th>
                    <th scope="col">등록 일자</th>
                    <th scope="col">답변 내용</th>
                </tr>

                <c:forEach var="inqryDTO" items="${list}">
                    <input type="hidden" name="inqryNo" value="${inqryDTO.inqryNo}">
                    <tr class="table-light">
                        <td scope="row">${inqryDTO.inqryNo}</td>        <%---문의사항 번호---%>
                        <td><c:out value="${inqryDTO.inqryTp}"/></td>   <%---문의사항 타입---%>
                        <td>${inqryDTO.title}</td>
                        <td>${inqryDTO.regrId}</td>
                            <%--                    <a href = "<c:url value='/adminNotice/read?notcNo=${noticeDTO.notcNo}&page=${page}&pageSize=${pageSize}'/>">${noticeDTO.title}</a>--%>
                            <%---문의사항 등록날짜---%>
                        <td><fmt:formatDate value="${inqryDTO.regDttm}" pattern="yyyy-MM-dd" type="date"/></td>
                        <td>${inqryDTO.ansCn}</td>
                    </tr>
                </c:forEach>

            </table>
            <div class="pagination-container">
                <div>
                    <c:if test="${ph.showPrev}">
                        <a href="<c:url value='/adminInqry/adminInqryList?page=${ph.beginPage-1}&pageSize=${ph.pageSize}'/>" class="arrow-link">&lt;</a>
                    </c:if>
                    <c:forEach var="i" begin="${ph.beginPage}" end="${ph.endPage}">
                        <a href="<c:url value='/adminInqry/adminInqryList?page=${i}&pageSize=${ph.pageSize}'/>">${i}</a>
                    </c:forEach>
                    <c:if test="${ph.showNext}">
                        <a href="<c:url value='/adminInqry/adminInqryList?page=${i}&pageSize=${ph.pageSize}'/>" class="arrow-link">&gt;</a>
                    </c:if>
                </div>
            </div>
        </form>
    </div>
    </section>

    <script>
        $(document).ready(function (){

            $('.removeBtn').on("click", function(){
                if(!confirm("삭제 하시겠습니까 ?")) return;
                let form =  $('#form');
                let url =  "<c:url value='/adminNotice/remove${searchCondition.queryString}'/>";
                form.attr("action", url);
                form.attr("method", "post");
                form.submit();
            });


            $("#writeNewBtn").on("click", function () {
                location.href = "<c:url value='/adminNotice/write'/>";
            });

            $(".modifyBtn").on("click", function () {
                const notcNo=$(this).data("notc-no");
                location.href = '/adminNotice/modify?notcNo='+notcNo;
            });
                <%--location.href = '/adminNotice/modify?notcNo=${noticeDTO.notcNo}';--%>
        });

    </script>
