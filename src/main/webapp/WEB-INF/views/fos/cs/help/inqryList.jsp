<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ page session="true" %>

<head>
    <style>
        @import url(${cssUrlFos}/cs/inqryList.scss);
        .arrow-link {
            color: #000000; /* 원하는 색상으로 변경 */
        }
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
        .r-side .btn {
            /* 버튼의 기본 스타일 설정 (예: 기본 배경색, 기본 글자색 등) */
            color: black; /* 기본 글자색: 검은색 */
            transition: background-color 0.5s, color 0.5s; /* 0.2초의 애니메이션 효과 추가 */
        }
        .r-side .btn:hover {
            /* 버튼 위에 마우스가 올라갔을 때의 스타일 설정 */
            color: white !important;
            background-color: #587dc8; /* 배경색: 주황색 */
            color: #ffffff; /* 글자색: 흰색 */
            /* 원하는 다른 스타일들 추가 가능 */
        }
        .r-side .btn:hover span {
            /* 버튼 위에 마우스가 올라갔을 때의 span 요소에 적용할 스타일 설정 */
            color: white; /* 글자색 변경: 흰색 */
        }
        .wrap-pagination .page.paging-active {
            font-weight: bold;
            color: #fff; /* 선택된 페이지 숫자의 글자색을 흰색으로 설정 */
            background-color: #000; /* 선택된 페이지의 배경색을 검정색으로 설정 */
            padding: 8px 12px; /* 선택된 페이지의 패딩 사이즈를 조정 */
            border-radius: 4px; /* 선택된 페이지의 테두리를 둥글게 설정 */
        }

    </style>
    <script>
        const inqryTypeTextMap = {
            "91": "주문문의",
            "92": "상품문의",
            "93": "배송문의",
            "94": "결제문의",
            "95": "이 상품 찾아요",
            "96": "건의사항 있어요"
        };
    </script>
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
								<c:choose>
                                    <c:when test="${inqryDTO.inqryYn eq 'Y'}">
                                        <span class="badge-item ty10" style="background-color: #587dc8; color: #ffffff;">답변완료</span>
                                    </c:when>
                                    <c:otherwise>
                                        <span class="badge-item ty10">답변대기</span>
                                    </c:otherwise>
                                </c:choose>
		                </span>
                            <strong class="ml-20">${[inqryTypeTextMap[inqryDTO.inqryTp]]} ${inqryDTO.title}</strong>
                            <span class="color-3 w-120 ta-c"><fmt:formatDate value="${inqryDTO.regDttm}" pattern="yyyy-MM-dd" type="date"/></span>
                        </button>
                        <div class="panel" style="display: none;">

                            <div class="slide-cont end">
                                <div class="inner" style="display: block;">
                                    <p><span>Q. </span>${inqryDTO.content}</p>
                                    <br>
                                    <c:if test="${inqryDTO.inqryYn eq 'Y'}">
                                        <p><span>A. </span>${inqryDTO.ansCn}</p><br>
                                    </c:if>
                                    <input type="hidden" name="inquiry" value="2756">
                                    <div style="margin-right: 40px">
                                        <span><button type="button" class="btn btn-text-type btt1 btn-remove" inqryNo="${inqryDTO.inqryNo}" style="float: right">삭제</button></span>
                                        <span style="float: right;">&nbsp;|&nbsp;</span>
                                        <span><button type="button" class="btn btn-text-type btt1 btn-modify" inqryNo="${inqryDTO.inqryNo}" inqryType="${inqryDTO.inqryTp}" style="float: right">수정</button></span><br>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
        <div id="devPageWrap">
            <div class="wrap-pagination">
                <c:if test="${ph.showPrev}">
                    <a class="page" href="<c:url value='/inqry/inqryList?page=${ph.beginPage-1}&pageSize=${ph.pageSize}'/>" class="arrow-link">&lt;</a>
                </c:if>
                <c:forEach var="i" begin="${ph.beginPage}" end="${ph.endPage}">
                    <a class="page paging-active" href="<c:url value='/inqry/inqryList?page=${i}&pageSize=${ph.pageSize}'/>">${i}</a>
                </c:forEach>
                <c:if test="${ph.showNext}">
                    <a class="page" href="<c:url value='/inqry/inqryList?page=${i}&pageSize=${ph.pageSize}'/>" class="arrow-link">&gt;</a>
                </c:if>
            </div>
        </div>
    </form>
</section>

<script>
    let removeYn ; //삭제가 잘 되었는지 확인하는 변수
    let removeMsg; //삭제 메시지
    let msg = "${msg}";

    let slideTitles = document.getElementsByClassName("slide-title");

    for (i = 0; i < slideTitles.length; i++) {
        slideTitles[i].addEventListener("click", function() {
            this.classList.toggle("active");

            let panel = this.getElementsByClassName("panel")[0];
            let qText = panel.querySelector("span");
            let statusBadge = this.querySelector(".badge-item.ty10");

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
            console.log("inqryno = " + inqryno);
            $.ajax({
                type: 'POST',
                url: `/inqry/remove?inqryNo=`+inqryno,
                contentType: 'application/json; charset=utf-8',
                dataType: 'Text',
                success: function(result) {
                    removeMsg = JSON.parse(result);
                    if(removeMsg ===1){
                        alert("성공적으로 삭제되었습니다.");
                        location.href = "/inqry/inqryList";
                    }else{
                        alert("삭제 중 오류가 발생했습니다.");
                    }
                },
                error: function() {
                    alert("삭제 중 오류가 발생했습니다.");
                }
            });
        })

        // $('.btn-modify').on("click", function (event){
        //     if (!confirm("1:1 문의를 수정하시겠습니까?")) return;
        //     const inqryNumber = $(event.target).attr('inqryNo');
        //     $.ajax({
        //         type: 'GET',
        //         url: `/inqry/modify`,
        //         contentType: 'application/json; charset=utf-8',
        //     });
        // })

        $(".btn-modify").on("click", function(event) {
            if (!confirm("1:1 문의를 수정하시겠습니까?")) return;

            const inqryNo = $(event.target).attr('inqryNo');
            const modifyUrl = "<c:url value='/inqry/modify'/>";
            const urlWithParams = modifyUrl + "?inqryNo=" + inqryNo;

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


        $("#writeBtn").on("click", function(){
            let form = $("#frm");
            form.attr("action", "<c:url value='/inqry/inqry'/>");
            form.attr("method", "post");
            form.submit();
        })
    });

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

</script>

