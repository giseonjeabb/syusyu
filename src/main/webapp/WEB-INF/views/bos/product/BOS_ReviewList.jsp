<%--
  Created by IntelliJ IDEA.
  User: Han
  Date: 2023-08-06
  Time: 오후 2:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>

<head>
    <style>
        @import url(${cssUrlBos}/product/BOS_ReviewList.scss);
    </style>
</head>
<script>
    let msg = "${msg}";
    if (msg == "LIST_ERR") alert("게시물 목록을 가져오는데 실패했습니다. 다시 시도해 주세요.");
    if (msg == "READ_ERR") alert("삭제되었거나 없는 게시물입니다.");

    if (msg == "DEL_ERR") alert("삭제 실패 했습니다..");
    if (msg == "DEL_OK") alert("성공적으로 삭제되었습니다.");
</script>


<div class = all-board>

    <div class="fb__bbs__header">
        <h3 class="title-t ty3 mb-30"><a href="<c:url value="/bos/reviewList"/>"> 상품 리뷰 관리 </a></h3>
    </div>


    <%--검색 바  : 제목 + 내용 , 제목 , 내용 항목--%>

    <div class="search">
        <form action="<c:url value="/bos/reviewList"/>" class="d-flex-1">

            <%--            pannel heading--%>
            <div class="panel panel-seller">
                <div class="panel-heading">
                    <div class="pull-left">
                        <h3 class="panel-title"> Review 조회 </h3>
                    </div>
                </div>


                <%--                pannel - body--%>
                <div class="panel-body">
                    <div class="seller-search-section">
                        <div class = "input-search">검색어</div>
                        <div class = "input-content">

                            <select id="sType" class="search-option" name="option">
                                <option value="A" ${ph.sc.option=='A' || ph.sc.option=='' ? "selected" : ""}>전체 검색</option>
                                <option value="P" ${ph.sc.option=='P' ? "selected" : ""}>상품 이름</option>
                                <option value="C" ${ph.sc.option=='C' ? "selected" : ""}>리뷰 내용</option>
                                <option value="B" ${ph.sc.option=='B' ? "selected" : ""}>브랜드 이름</option>
                            </select>

                            <i class="fa-solid fa-caret-down"></i>

                            <input type="text" id="noticeSearchText" name="keyword" class="search-input" type="text" value="${ph.sc.keyword}"
                                   placeholder="Search keyword">
                            <input type="submit" id="btnSearch" class="btn btn-secondary my-2 my-sm-0" value="Search">

                        </div>
                    </div>
                </div>

            </div> <%-- panel panel-seller--%>
        </form>
    </div>  <%---<div class="search">--%>






    <form id="form" class="frm" action="" method="post">
        <div class="notice-list"> Review  목록
            <%--    게시글 갯수 카운팅--%>
            <span class="review_count">
                    (총 ${ph.totalCnt}개)
                </span>



        </div>

        <table class="table table-hover">

                <tr class="table-dark">
                    <th scope="col">리뷰 번호</th>
                    <th scope="col">브랜드</th>
                    <th scope="col">상품</th>
                    <th scope="col">별점</th>
                    <th scope="col">등록자</th>
                    <th scope="col">등록 일시</th>
                    <th scope="col"> 삭제 </th>
                </tr>

            <c:forEach var="reviewDTO" items="${list}">
                <input type="hidden" name="revwNo" value="${reviewDTO.revwNo}">
                    <tr class="table-light">
                        <td scope="row">  ${reviewDTO.revwNo} </td>       <%--리뷰 번호--%>
                        <td><c:out value="${reviewDTO.brndKoNm}"/></td>   <%-- 브랜드--%>
                        <td><c:out value="${reviewDTO.prodNm}"/></td>
                        <td><c:out value="${reviewDTO.starRating}"/></td>
                        <td><c:out value="${reviewDTO.lginId}"/></td>
    <%--                <td><a href = "<c:url value="/bos/faqRead${ph.sc.queryString}&faqNo=${faqDTO.faqNo}"/>"> ${faqDTO.title}</a></td> &lt;%&ndash;-FAQ 제목-&ndash;%&gt;--%>
                        <td><fmt:formatDate value="${reviewDTO.regDttm}" pattern="yyyy-MM-dd" type="date"/></td>
                        <td><button type="button" id="removeBtn" class="removeBtn" data-revw-no="${reviewDTO.revwNo}">삭 제</button></td>
                    </tr>
            </c:forEach>


        </table>


        <%--            오류나는 부분 끝--%>



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
                        <a class="page" href="<c:url value='/bos/reviewList${ph.sc.getQueryString(ph.beginPage)}'/>"><i class="fa-solid fa-angles-left"></i></a>
                    </c:if>

                    <c:if test="${ph.showPrev}">
                        <a class="page"
                           href="<c:url value='/bos/reviewList${ph.sc.getQueryString(ph.beginPage-1)}'/>"><i class="fa-solid fa-angle-left"></i></a>
                    </c:if>


                    <c:forEach var="i" begin="${ph.beginPage}" end="${ph.endPage}">
                        <a class="page ${i==ph.sc.page? "paging-active" : ""}"
                           href="<c:url value='/bos/reviewList${ph.sc.getQueryString(i)}'/>">${i}</a>
                    </c:forEach>


                    <c:if test="${ph.showNext}">
                        <a class="page" href="<c:url value='/bos/reviewList${ph.sc.getQueryString(ph.endPage+1)}'/>"><i class="fa-solid fa-angle-right"></i></a>
                    </c:if>

                    <c:if test="${ph.showLast}">
                        <a class="page"
                           href="<c:url value='/bos/reviewList${ph.sc.getQueryString(ph.totalPage)}'/>"><i class="fa-solid fa-angles-right"></i></a>
                    </c:if>

                </c:if>

            </div>
        </div>

    </form>
</div>


<script>
    $(document).ready(function (){
        $('.removeBtn').on("click", function(){
            if(!confirm("삭제 하시겠습니까 ?")) return;
            let form =  $('#form');
            const revwNo = $(this).data("revw-no");
            let url =  "/bos/reviewRemoveAdmin?revwNo=" + revwNo;
            form.attr("action", url);
            form.attr("method", "post");
            form.submit();
        });

    });


</script>
