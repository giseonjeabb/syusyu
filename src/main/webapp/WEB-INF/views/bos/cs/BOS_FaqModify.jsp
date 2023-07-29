<%--
  Created by IntelliJ IDEA.
  User: Han
  Date: 2023-07-27
  Time: 오후 5:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>

<head>
    <style>
        @import url(${cssUrlBos}/cs/BOS_FaqModify.scss);
    </style>
</head>
<script>
    let msg = "${msg}";
    if (msg == "LIST_ERR") alert("게시물 목록을 가져오는데 실패했습니다. 다시 시도해 주세요.");
    if (msg == "MOD_OK") alert("성공적으로 글이 수정되었습니다.");
    if (msg == "MOD_ERR") alert("게시물 수정 하는데 실패 했습니다.");
    // Add other messages here
</script>

<!-- Form for writing a notice -->
<div class="container">
    <h2 class="title-t ty3 mb-30">FAQ 수정</h2>


    <%--  <form id="form" class="frm" action="<c:url value='/adminNotice/modify'/>" method="post">--%>
    <form id="form" class="frm" action="<c:url value='/bos/faqModify'/>" method="post">

        <!-- FAQ Type -->
        <div class="form-group">
            <label for="exampleSelect1" class="form-label mt-4">FAQ 종류</label>
            <select class="form-select" name="faqTp" id="exampleSelect1">
                <option value="10" ${faqDTO.faqTp == '10' ? 'selected' : ''}> 회원정보 </option>
                <option value="20" ${faqDTO.faqTp == '20' ? 'selected' : ''}> 배송  </option>
                <option value="30" ${faqDTO.faqTp == '30' ? 'selected' : ''}> 주문 / 결제 </option>
                <option value="40" ${faqDTO.faqTp == '40' ? 'selected' : ''}> 교환/반품 </option>
                <option value="50" ${faqDTO.faqTp == '50' ? 'selected' : ''}> 이벤트혜택 </option>
                <option value="60" ${faqDTO.faqTp == '60' ? 'selected' : ''}> 취소 / 환불 </option>
                <option value="70" ${faqDTO.faqTp == '70' ? 'selected' : ''}> 이용안내 </option>
                <option value="80" ${faqDTO.faqTp == '80' ? 'selected' : ''}> 쿠폰 / 포인트 </option>
            </select>
        </div><br>

        <input name ="faqNo" type="hidden" value="${faqDTO.faqNo}">

        <!-- FAQ Title -->
        제목
        <input name="title" type="text" value="${faqDTO.title}" class="detail-tit1" placeholder="제목을 입력해 주세요." required><br>

        <!-- FAQ Content -->
        상세내용
        <textarea name="content" rows="15" class="detail-cont" placeholder="내용을 입력해 주세요." required>${faqDTO.content}</textarea>

        <!-- Button -->
        <button type="button" id="listBtn" class="btn btn-primary btn-sm"><i class="fa-solid fa-list-ul"></i> 목 록</button>
        <button type="submit" id="writeBtn" class="btn btn-primary btn-sm"><i class="fa fa-pen-nib"></i> 글 수정</button>
    </form>
</div>




<!-- Show success or error messages -->
<script>

    // Define button click event handlers
    $(document).ready(function() {


        $("#listBtn").on("click", function(){
            // 둘모두 같은내용
            location.href="<c:url value='/bos/faqList${searchCondition.queryString}'/>";
            <%--location.href = "<c:url value="/bos/faqList"/>?page=${sc.page}&pageSize=${sc.pageSize}";--%>

        });

    });

</script>