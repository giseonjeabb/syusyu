<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ page session="true" %>

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
                <span class="text fz-15" id="accordion">총<strong>${totalCnt}</strong>개</span>
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
                            <div style="margin-right: 40px">
                                <span><button type="button" class="btn btn-text-type btt1 btn-remove" inqryNo="${inqryDTO.inqryNo}" style="float: right">삭제</button></span>
                                <span style="float: right;">&nbsp;|&nbsp;</span>
                                <span><button type="button" class="btn btn-text-type btt1 btn-modify" inqryNo="${inqryDTO.inqryNo}" style="float: right">수정</button></span>
                            </div>
                        </div>
                    </div>
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
    let removeYn ; //삭제가 잘 되었는지 확인하는 변수
    let removeMsg; //삭제 메시지
    let msg = "${msg}";

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
        $('.btn-remove').on("click", function (event){
            if(!confirm("정말로 삭제하시겠습니까?")) return;
            const inqryno = $(event.target).attr('inqryNo');
            $.ajax({
                type: 'POST',
                url: `/inqry/remove?inqryNo=`+inqryno,
                contentType: 'application/json; charset=utf-8',
                dataType: 'Text',
                success: function(result) {
                    removeMsg = JSON.parse(result);
                    if(removeMsg ===1){
                        alert("성공적으로 삭제되었습니다.");
                        location.href = "http://localhost:80/inqry/inqryList";
                    }else{
                        alert("삭제 중 오류가 발생했습니다.");
                    }
                },
                error: function() {
                    alert("삭제 중 오류가 발생했습니다.");
                }
            });
        })

    <%--$(document).ready(function () {--%>
    <%--    $('.btn-remove').on("click", function (event) {--%>
    <%--        if (!confirm("정말로 삭제하시겠습니까?")) return;--%>

    <%--        const inqryNo = $(event.target).attr('inqryNo');--%>
    <%--        const mbrId = "${sessionScope.mbrId}";--%>

    <%--        // inqryNo와 mbrId를 서버로 전달할 데이터로 정리합니다.--%>
    <%--        const data = {--%>
    <%--            inqryNo: inqryNo,--%>
    <%--            mbrId: mbrId--%>
    <%--        };--%>

    <%--        $.ajax({--%>
    <%--            type: 'POST',--%>
    <%--            url: `/inqry/remove`,--%>
    <%--            data: data, // 서버로 전달할 데이터를 지정합니다.--%>
    <%--            dataType: "json", // 서버 응답을 JSON으로 처리합니다.--%>
    <%--            success: function(response) {--%>
    <%--                // 서버 응답에 따른 처리를 수행합니다.--%>
    <%--                if (response.success) {--%>
    <%--                    alert("성공적으로 삭제되었습니다.");--%>
    <%--                    location.reload(); // 페이지를 새로고침하여 최신 데이터를 보여줍니다.--%>
    <%--                } else {--%>
    <%--                    alert("삭제 중 오류가 발생했습니다.");--%>
    <%--                }--%>
    <%--            },--%>
    <%--            error: function() {--%>
    <%--                alert("삭제 중 오류가 발생했습니다.");--%>
    <%--            }--%>
    <%--        });--%>
    <%--    });--%>

        $(".btn-modify").on("click", function() {
            if (!confirm("1:1 문의를 수정하시겠습니까?")) return;
            let form = $("#frm");
            form.attr("action", "<c:url value='/inqry/modify'/>");
            form.attr("method", "post");
            form.submit();
        });

        $("#writeBtn").on("click", function(){
            let form = $("#frm");
            form.attr("action", "<c:url value='/inqry/inqry'/>");
            form.attr("method", "post");
            form.submit();
        })
    });

</script>

