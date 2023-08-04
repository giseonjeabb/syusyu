<%--
  Created by IntelliJ IDEA.
  User: Han
  Date: 2023-07-26
  Time: 오후 5:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ page session="true"%>

<head>
    <style>
        @import url(${cssUrlBos}/cs/BOS_Faq.scss);
    </style>
</head>
    <script>
    let msg = "${msg}";
    if(msg == "READ_ERR") alert (" 게시물을 읽어오는데 실패 했습니다. ");
    if (msg == "LIST_ERR") alert("게시물 목록을 가져오는데 실패했습니다. 다시 시도해 주세요.")
    if (msg == "DEL_ERR") alert("삭제 실패 했습니다..");
    if (msg == "DEL_OK") alert("성공적으로 삭제되었습니다.");
    </script>


    <div class="container">
        <h2 class="title-t ty3 mb-30"> FAQ 자주묻는 질문 </h2><br>

        <form id="form" class="frm" action="" method="post">

            <input type="hidden" name="faqNo" value="${faqDTO.faqNo}">

            <colgroup>
                <col style="width: 105px">
                <col style="width: auto">
                <col style="width: 110px">
            </colgroup>
            <table id="titleForm">
                    <tr>
                        <td id="titleFormFirst"> ${faqDTO.title}</td>
                    </tr>

                    <tr>
                        <td id="titleFormSecond"><fmt:formatDate value="${faqDTO.regDttm}" pattern="yyyy-MM-dd" /></td>
                    </tr>
            </table>

            <table id="contentForm">
                <tr>
                    <td>
                        <textarea name="content" rows="15" class="detail-cont" readonly="readonly">${faqDTO.content}</textarea>
                    </td>
                </tr>

                <tr>
                    <td>
                        <ul class="prev_next_title">
                            <li class="detail__nav-next">
                                <span class="nextPage">다음 글&nbsp;&nbsp;&nbsp;&nbsp
                                    <i class="fa-sharp fa-solid fa-caret-up"></i></span>&nbsp;&nbsp;&nbsp;&nbsp;
                                <c:if test="${not empty nextFaqTitle}">
                                    <a href="/bos/faqRead?faqNo=${nextFaqNo}">&nbsp; ${nextFaqTitle}</a>
                                </c:if>
                                <c:if test="${empty nextFaqTitle}">
                                    <span>&nbsp;&nbsp;다음 글이 존재하지 않습니다. </span>
                                </c:if>
                            </li>
                        </ul>
                    </td>
                </tr>

            <tr>
                <td>
                    <ul>
                        <li class="detail__nav-prev">
                            <span class="prevPage">이전 글&nbsp;&nbsp;&nbsp;&nbsp;
                                <i class="fa-solid fa-caret-down"></i></span>&nbsp;&nbsp;&nbsp;&nbsp;
                            <c:if test="${not empty prevFaqTitle}">
                                <a href="/bos/faqRead?faqNo=${prevFaqNo}">&nbsp; ${prevFaqTitle}</a>
                            </c:if>
                            <c:if test = "${empty prevFaqTitle}">
                                <span>&nbsp;&nbsp;이전 글이 존재 하지 않습니다. </span>
                            </c:if>
                        </li>
                    </ul>
                </td>
            </tr>

            <tr>
                <td id="threeBtn">
                    <button type="button" id="listBtn" class="btn btn-primary btn-sm"><i class="fa-solid fa-list-ul"></i>  목록</button>
                    <button type="button" id="modifyBtn" data-faq-no="${faqDTO.faqNo}" class="btn btn-primary btn-sm"><i class="fa-solid fa-toolbox"></i>  수정</button>
                    <button type="button" id="removeBtn" data-faq-no="${faqDTO.faqNo}" class="btn btn-primary btn-sm"><i class="fa-solid fa-trash"></i>  삭제</button>
                </td>
            </tr>
            </table>

        </form>
    </div>


<script>
    $(document).ready(function (){
        $('#listBtn').on("click", function(){
            // 둘모두 같은내용
            <%--location.href="<c:url value='/bos/faqList${searchCondition.queryString}'/>";--%>
            location.href = "<c:url value="/bos/faqList"/>?page=${sc.page}&pageSize=${sc.pageSize}";
        });


        $("#modifyBtn").on("click", function () {
            const faqNo=$(this).data("faq-no");
            location.href = '/bos/faqModify?faqNo='+faqNo;
        });

        $("#removeBtn").on("click", function () {
            if(!confirm("삭제 하시겠습니까 ?")) return;
            let form = $('#form');
            const faqNo=$(this).data("faq-no");
            let url = '/bos/faqRemove?faqNo='+faqNo;
            form.attr("action", url);
            form.attr("method","post");
            form.submit();
        });



    });

</script>