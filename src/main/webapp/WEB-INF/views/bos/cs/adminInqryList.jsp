    <%@ page import="java.time.LocalDate" %>
    <%@ page import="java.time.LocalDateTime" %>
    <%@ page import="java.time.format.DateTimeFormatter" %>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>


    <head>
        <style>
            @import url(${cssUrlBos}/cs/adminInqryList.scss);
            .pagination-container {
                display: flex;
                justify-content: center;
                margin-top: 10px;
                color: #A0A0A0;
            }

            .pagination-container a {
                display: inline-block;
                padding: 5px 10px;
                margin: 0 2px;
                color: #A0A0A0;
                text-decoration: none;
            }

            .pagination-container a:hover {
                text-decoration: underline;
                color: #333;
            }

            .pagination-container a.active {
                background-color: #007bff;
                color: #000000;
            }
            .badge-item.ty10 {
                background-color: #587dc8; /* 배경색: 주황색 */
                color: #ffffff; /* 글자색: 흰색 */
                padding: 5px 10px;
                border-radius: 20px; /* 둥근 모양을 위한 border-radius 속성 */
            }

            /* 답변 완료 스타일 */
            .badge-item.ty10.complete {
                padding: 5px 10px;
                border-radius: 20px; /* 둥근 모양을 위한 border-radius 속성 */
            }
            .clickable-span {
                cursor: pointer;
                /* 기타 스타일 설정 */
            }
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
        <br><br>
        <%--            pannel heading--%>
                <div class="panel panel-seller" hidden="hidden">
                    <div class="panel-heading" hidden="hidden">
                    </div>
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
                    <th scope="col">문의 번호</th>
                    <th scope="col">문의사항 종류</th>
                    <th scope="col">문의 제목</th>
                    <th scope="col">문의 작성자 ID</th>
                    <th scope="col">등록 일자</th>
                    <th scope="col">답변 내용</th>
                    <th scope="col">답변 상태</th>
                </tr>

                <c:forEach var="inqryDTO" items="${list}">
                    <input type="hidden" name="inqryNo" value="${inqryDTO.inqryNo}">
                    <tr class="table-light">
                        <td scope="row"><span id="inqryNo">${inqryDTO.inqryNo}</span></td>        <%---문의사항 번호---%>
                        <td>${[inqryTypeTextMap[inqryDTO.inqryTp]]}</td>   <%---문의사항 타입---%>
                        <td><a href="#" class="notice-link" data-inqryno="${inqryDTO.inqryNo}">${inqryDTO.title}</a></td>
                        <td>
                            <c:choose>
                                <c:when test="${regrIdValueMap[inqryDTO.regrId] != null}">
                                    ${regrIdValueMap[inqryDTO.regrId]}
                                </c:when>
                                <c:otherwise>
                                    ${inqryDTO.regrId}
                                </c:otherwise>
                            </c:choose>
                        </td>
                        <td><fmt:formatDate value="${inqryDTO.regDttm}" pattern="yyyy-MM-dd" type="date"/></td>
                        <td>${inqryDTO.ansCn}</td>
                        <td>
                            <span class="badge-cont single">
								<c:choose>
                                    <c:when test="${not empty inqryDTO.ansCn}">
                                        <span class="badge-item ty10 complete" style="background-color: #c8c8c8; color: white;">답변완료</span>
                                    </c:when>
                                    <c:when test="${empty inqryDTO.ansCn}">
<%--                                        <span class="badge-item ty10 clickable-span" onclick="executeScript()" inqryNo="${inqryDTO.inqryNo}">답변대기</span>--%>
                                        <span class="badge-item ty10 clickable-span" onclick="executeScript(${inqryDTO.inqryNo})">답변대기</span>
                                        <%-- <span class="badge-item ty10"><button type="button" class="btn btn-text-type btt1 btn-modify" inqryNo="${inqryDTO.inqryNo}">수정</button>답변대기</span>--%>
                                    </c:when>
                                    <c:otherwise>
                                        <!-- 아무것도 하지 않음 -->
                                    </c:otherwise>
                                </c:choose>
		                </span>
                        </td>
                    </tr>
                </c:forEach>

            </table>
            <div id="devPageWrap">
                <div class="wrap-pagination">
                    <c:if test="${ph.showPrev}">
                        <a class="page" href="<c:url value='/adminInqry/adminInqryList?page=${ph.beginPage-1}&pageSize=${ph.pageSize}'/>" class="arrow-link">&lt;</a>
                    </c:if>
                    <c:forEach var="i" begin="${ph.beginPage}" end="${ph.endPage}">
                        <a class="page paging-active" href="<c:url value='/adminInqry/adminInqryList?page=${i}&pageSize=${ph.pageSize}'/>">${i}</a>
                    </c:forEach>
                    <c:if test="${ph.showNext}">
                        <a class="page" href="<c:url value='/adminInqry/adminInqryList?page=${i}&pageSize=${ph.pageSize}'/>" class="arrow-link">&gt;</a>
                    </c:if>
                </div>
            </div>
        </form>
    </div>
    </section>

    <script>
        // JavaScript에서 inqryNo 값을 읽어오기 위해 해당 span 요소를 선택합니다.
        const inqryNoElement = document.getElementById("inqryNo");

        // 선택한 span 요소의 내용을 가져옵니다.
        const inqryNoValue = inqryNoElement.textContent;

        function executeScript(inqryNo) {
            var preventClick = false; // 더블 클릭 방지용 변수

            if (preventClick) return; // 더블클릭 방지용 변수가 true이면 클릭 무시
            preventClick = true;  // 더블클릭 방지용 변수를 true로 설정

            if (!confirm("답변 등록을 하시겠습니까?")) {
                preventClick = false; // 클릭 이벤트 무시 해제
                return;
            }

            const modifyUrl = "<c:url value='/adminInqry/modify'/>";
            const urlWithParams = modifyUrl + "?inqryNo=" + inqryNo;

            // Ajax 요청을 보냅니다.
            $.ajax({
                type: 'GET',
                url: urlWithParams,
                contentType: 'application/json; charset=utf-8',
                success: function (response) {
                    // Ajax 요청이 성공적으로 완료된 후 실행할 코드를 작성합니다.
                    // 이 경우 서버에서 반환된 데이터를 사용할 수도 있습니다.
                    // 예: console.log(response);
                    // 페이지를 이동하려면 아래와 같이 사용합니다.
                    window.location.href = urlWithParams;
                    preventClick = false; // 클릭 이벤트 무시 해제
                },
                error: function () {
                    // Ajax 요청이 실패한 경우 실행할 코드를 작성합니다.
                    alert("문의 수정을 가져오는 동안 오류가 발생했습니다.");
                    preventClick = false; // 클릭 이벤트 무시 해제
                }
            });
        }

        $(".notice-link").on("click", function(event) {
            event.preventDefault(); // 기본 링크 동작 방지

            // data-inqryno 속성 값을 가져옵니다.
            const inqryNoValue = $(this).data("inqryno");

            // modifyUrl을 동적으로 생성합니다.
            const modifyUrl = "<c:url value='/adminInqry/read'/>";
            const urlWithParams = modifyUrl + "?inqryNo=" + inqryNoValue;

            // Ajax 요청을 보냅니다.
            $.ajax({
                type: 'GET',
                url: urlWithParams,
                contentType: 'application/json; charset=utf-8',
                success: function(response) {
                    // Ajax 요청이 성공적으로 완료된 후 실행할 코드를 작성합니다.
                    // 이 경우 서버에서 반환된 데이터를 사용할 수도 있습니다.
                    // 예: console.log(response);
                    // 페이지를 이동하려면 아래와 같이 사용합니다.
                    window.location.href = urlWithParams;
                },
                error: function() {
                    // Ajax 요청이 실패한 경우 실행할 코드를 작성합니다.
                    alert("문의 수정을 가져오는 동안 오류가 발생했습니다.");
                }
            });
        });

    </script>


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


    <%--var preventClick = false; // 더블 클릭 방지용 변수--%>

    <%--$(document).ready(function () {--%>
    <%--    $(".btn-modify").on("click", function (event) {--%>
    <%--        if (preventClick) return; // 더블클릭 방지용 변수가 true이면 클릭 무시--%>
    <%--        preventClick = true;  // 더블클릭 방지용 변수를 true로 설정--%>

    <%--        if (!confirm("답변 등록을 하시겠습니까?")) {--%>
    <%--            preventClick = false; // 클릭 이벤트 무시 해제--%>
    <%--            return;--%>
    <%--        }--%>

    <%--        const inqryNo = $(event.target).attr('inqryNo');--%>
    <%--        const modifyUrl = "<c:url value='/adminInqry/modify'/>";--%>
    <%--        const urlWithParams = modifyUrl + "?inqryNo=" + inqryNo;--%>

    <%--        // Ajax 요청을 보냅니다.--%>
    <%--        $.ajax({--%>
    <%--            type: 'GET',--%>
    <%--            url: urlWithParams,--%>
    <%--            contentType: 'application/json; charset=utf-8',--%>
    <%--            success: function (response) {--%>
    <%--                // Ajax 요청이 성공적으로 완료된 후 실행할 코드를 작성합니다.--%>
    <%--                // 이 경우 서버에서 반환된 데이터를 사용할 수도 있습니다.--%>
    <%--                // 예: console.log(response);--%>
    <%--                // 페이지를 이동하려면 아래와 같이 사용합니다.--%>
    <%--                window.location.href = urlWithParams;--%>
    <%--                preventClick = 0;--%>
    <%--            },--%>
    <%--            error: function () {--%>
    <%--                // Ajax 요청이 실패한 경우 실행할 코드를 작성합니다.--%>
    <%--                alert("문의 수정을 가져오는 동안 오류가 발생했습니다.");--%>
    <%--                preventClick = 0;--%>
    <%--            },--%>
    <%--            complete: function () {--%>
    <%--                preventClick = false; // 클릭 이벤트 무시 해제--%>
    <%--            }--%>
    <%--        });--%>
    <%--    });--%>
    <%--});--%>