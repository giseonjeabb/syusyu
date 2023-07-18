<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ page session="true" %>
<c:set var="loginId" value="${sessionScope.id}"/>
<c:set var="loginOutLink" value="${loginId=='' ? '/login/login' : '/login/logout'}"/>
<c:set var="loginOut" value="${loginId=='' ? 'Login' : 'ID='+=loginId}"/>

<head>
    <style>
        @import url(${cssUrlFos}/cs/inqryList.scss);
    </style>
</head>

<section>
    <h3 class="title-t ty3 mb-30">1:1 문의</h3>
    <div class="sub-content-head etc-ty1">
        <c:set var="inqryCount" value="${inqryService.getCount()}" />
        <div class="inner pb-14">
            <span class="prd-counter">
                <span class="text fz-15" id="accordion">총<strong>${inqryCount}</strong>개</span>
            </span>
            <div class="r-side">
                <form action="<c:url value='/inqry/inqry'/>" method="post">
                    <button type="submit" class="btn ty1 c-ty5" id="rightBtn"><span>문의하기</span></button>
                </form>
            </div>
        </div>
    </div>
    <form name="Frm" id="frm" method="post" action="cs.act">
        <input type="hidden" name="is-modify" id="is-modify">
        <input type="hidden" name="exec" value="inquiry">
        <input type="hidden" name="cmd">
        <input type="hidden" name="idx">
        <div id="ux_page_list">
            <div class="slide-wrap slide-ty3 bt-0" page-no="1" total-size="4" total-page="1" size-answer="0" size-wait="4">
                <c:forEach var="inqryDTO" items="${list}">
                    <div class="slide-title ">
                        <button type="button" class="slide-trg">
		                <span class="badge-cont single">
							<span class="badge-item ty10">
								답변대기
							</span>
		                </span>
                            <strong class="ml-20"> <c:out value="${inqryDTO.inqryTp} ${inqryDTO.title}"/></strong>
                            <span class="color-3 w-120 ta-c"><fmt:formatDate value="${inqryDTO.regDttm}" pattern="yyyy-MM-dd" type="date"/></span>
                        </button>
                        <div class="panel">
                            <p><span>Q. </span>${inqryDTO.ansCn}</p>
                                <input type="hidden" name="inquiry" value="2756">
                                <span><button type="button" class="btn btn-text-type btt1 btn-modify" id="modifyBtn" inqryNo="${inqryDTO.inqryNo}">수정</button></span>
                                <span><button type="button" class="btn btn-text-type btt1 btn-remove" id="removeBtn" inqryNo="${inqryDTO.inqryNo}">삭제</button></span>
                        </div>
                    </div>
<%--                    <div class="slide-cont ">--%>
<%--                        <div class="inner" style="display: none;">--%>
<%--                            <div class="question mb-10">--%>
<%--                                <em class="ia">Q.</em>--%>
<%--                                <div class="cont">--%>
<%--                                    테스트 좀 하겠습니다--%>
<%--                                </div>--%>

<%--                            </div>--%>
<%--                        </div>--%>
<%--                    </div>--%>
                </c:forEach>
            </div>
        </div>
        <div>
            <c:if test="${ph.showPrev}">
                <a href="<c:url value='/inqry/inqryList?page=${ph.beginPage-1}&pageSize=${ph.pageSize}'/>">&lt;</a>
            </c:if>
            <c:forEach var="i" begin="${ph.beginPage}" end="${ph.endPage}">
                <a href="<c:url value='/inqry/inqryList?page=${i}&pageSize=${ph.pageSize}'/>">${i}</a>
            </c:forEach>
            <c:if test="${ph.showNext}">
                <a href="<c:url value='/inqry/inqryList?page=${i}&pageSize=${ph.pageSize}'/>">&gt;</a>
            </c:if>
        </div>
    </form>
</section>

<script>
    let msg = "${msg}";
    if (msg == "LIST_ERR") alert("게시물 목록을 가져오는데 실패했습니다. 다시 시도해 주세요.");
    if (msg == "READ_ERR") alert("삭제되었거나 없는 게시물입니다.");
    if (msg == "DEL_ERR") alert("삭제되었거나 없는 게시물입니다.");

    if (msg == "DEL_OK") alert("성공적으로 삭제되었습니다.");
    if (msg == "WRT_OK") alert("성공적으로 등록되었습니다.");
    if (msg == "MOD_OK") alert("성공적으로 수정되었습니다.");

    let slideTitles = document.getElementsByClassName("slide-title");
    let i;

    for (i = 0; i < slideTitles.length; i++) {
        slideTitles[i].addEventListener("click", function() {
            this.classList.toggle("active");
            let panel = this.getElementsByClassName("panel")[0];
            let qText = panel.querySelector("span");
            if (panel.style.display === "block") {
                panel.style.display = "none";
                this.querySelector(".ml-20").style.color = ""; // 기본 색상으로 변경
                panel.style.maxHeight = null;
            } else {
                panel.style.display = "block";
                this.querySelector(".ml-20").style.color = "red"; // 빨간색으로 변경
                qText.style.color = "red"; // 빨간색으로 변경
                panel.style.maxHeight = panel.scrollHeight + "px";
            }
        });
    }

    $(document).ready(function (){
        $('#removeBtn').on("click", function (event){
            if(!confirm("정말로 삭제하시겠습니까?")) return;
            const inqryno = $(event.target).attr('inqryNo');
            console.log(inqryno);
            $.ajax({
                type: 'POST',
                url: `/inqry/remove?inqryNo=`+inqryno,
                contentType: 'application/json; charset=utf-8',
            });
            <%--let form = $('#form');--%>
            <%--form.attr("action", "<c:url value='/inqry/remove'/>?page=${page}&pageSize=${pageSize}");--%>
            <%--form.attr("method", "post");--%>
            <%--form.submit();--%>
        })

        $("#modifyBtn").on("click", function(){
            if(!confirm("1:1 문의를 수정하시겠습니까?")) return;
            let form = $("#frm");
            form.attr("action", "<c:url value='/inqry/inqrymodify'/>");
            form.attr("method", "post");
            form.submit();
        })

        $("#writeBtn").on("click", function(){
            let form = $("#frm");
            form.attr("action", "<c:url value='/inqry/inqry'/>");
            form.attr("method", "post");
            form.submit();
        })
    });

</script>



<%--        <h3 class="title-t ty3 mb-30">공지사항</h3>--%>
<%--        <span class="notice_count">총 ${ph.totalCnt} 개 </span>--%>
<%--        <br>--%>

<%--&lt;%&ndash;<div class="board-container">&ndash;%&gt;--%>
<%--    <div class="search-container">--%>
<%--        <form action="<c:url value="/notice/noticeList"/>" class="search-form" method="get">--%>

<%--            <div>--%>
<%--                <select class="search-option" name="option">--%>
<%--                    <option value="A" ${ph.sc.option=='A' || ph.sc.option=='' ? "selected" : ""}>제목+내용</option>--%>
<%--                    <option value="T" ${ph.sc.option=='T' ? "selected" : ""}>제목만</option>--%>
<%--                    <option value="W" ${ph.sc.option=='W' ? "selected" : ""}>작성자</option>--%>
<%--                </select>--%>

<%--            </div>--%>

<%--            <input type="text" name="keyword" class="search-input" type="text" value="${ph.sc.keyword}"--%>
<%--                   placeholder="검색어를 입력해주세요">--%>
<%--            <input type="submit" class="search-button" value="검색">--%>

<%--        </form>--%>

<%--        <button id="writeBtn" class="btn-write" onclick="location.href='<c:url value="/notice/write"/>'"><i--%>
<%--                class="fa fa-pencil"></i> 글쓰기--%>
<%--        </button>--%>

<%--    </div>--%>
<%--</div>--%>

<%--    <table>--%>
<%--        <tr>--%>
<%--        <th class="notcNo">번호</th>--%>
<%--        <th class="notcTp">분류</th>--%>
<%--        <th class="title">제목</th>--%>
<%--        <th class="regDttm">등록일</th>--%>
<%--        <th class="viewCnt">조회수</th>--%>
<%--        </tr>--%>

<%--        <c:forEach var="inqryDTO" items="${list}">--%>
<%--            <tr>--%>
<%--                <td class="notcNo">${inqryDTO.inqryNo}</td>--%>
<%--&lt;%&ndash;타입&ndash;%&gt;--%>
<%--                <td class="notcTp"><c:out value="${inqryDTO.inqryTp}"/></td>--%>
<%--&lt;%&ndash;제목&ndash;%&gt;--%>
<%--                <td class="title"><a href="<c:url value="/notice/read${ph.sc.queryString}&notcNo=${inqryDTO.inqryNo}"/>">${inqryDTO.title}</a></td>--%>
<%--&lt;%&ndash;등록날짜&ndash;%&gt;--%>
<%--                <c:choose>--%>
<%--                    <c:when test="${inqryDTO.regDttm.time >= startOfToday}">--%>
<%--                        <td class="regDttm"><fmt:formatDate value="${noticeDto.regDttm}" pattern="HH:mm" type="time"/></td>--%>
<%--                    </c:when>--%>
<%--                    <c:otherwise>--%>
<%--                        <td class="regDttm"><fmt:formatDate value="${noticeDto.regDttm}" pattern="yyyy-MM-dd" type="date"/></td>--%>
<%--                    </c:otherwise>--%>
<%--                </c:choose>--%>
<%--&lt;%&ndash;조회수&ndash;%&gt;--%>
<%--&lt;%&ndash;                <td class="viewCnt">${noticeDto.viewCnt}</td>&ndash;%&gt;--%>

<%--            </tr>--%>
<%--        </c:forEach>--%>

<%--    </table>--%>
<%--            <br>--%>

<%--            <div class="paging-container">--%>
<%--                    <div class="paging">--%>
<%--                        <c:if test="${ph.totalCnt==null || ph.totalCnt==0}">--%>
<%--                            <div> 게시물이 없습니다.</div>--%>
<%--                        </c:if>--%>
<%--                        <c:if test="${ph.totalCnt!=null && ph.totalCnt!=0}">--%>
<%--                            <c:if test="${ph.showPrev}">--%>
<%--                                <a class="page" href="<c:url value='/notice/noticeList${ph.sc.getQueryString(ph.beginPage-1)}'/>">&lt;</a>--%>
<%--                            </c:if>--%>

<%--                            <c:forEach var="i" begin="${ph.beginPage}" end="${ph.endPage}">--%>
<%--                                 <a class="page ${i==ph.sc.page? "paging-active" : ""}" href="<c:url value='/notice/noticeList${ph.sc.getQueryString(i)}'/>">${i}</a>--%>
<%--                            </c:forEach>--%>

<%--                            <c:if test="${ph.showNext}">--%>
<%--                                <a class="page" href="<c:url value='/notice/noticeList${ph.sc.getQueryString(ph.endPage+1)}'/>">&gt;</a>--%>
<%--                            </c:if>--%>

<%--                        </c:if>--%>

<%--                    </div>--%>
<%--            </div>--%>
