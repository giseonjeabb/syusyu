<%--
  Created by IntelliJ IDEA.
  User: Han
  Date: 2023-07-29
  Time: 오후 12:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>

<head>
    <style>
        @import url(${cssUrlBos}/cs/BOS_FaqWrite.scss);
    </style>
</head>
<script>
    let msg = "${msg}";
    if(msg == "WRT_OK") alert("성공적으로 작성 되었습니다.");
    if(msg == "WRT_ERR") alert("게시글 작성에 실패 했습니다 , 오류 및 에러를 찾아주세요");
</script>

<div class="container">
    <h2 class="title-t ty3 mb-30">FAQ 글 작성</h2>


    <%--  <form id="form" class="frm" action="<c:url value='/adminNotice/modify'/>" method="post">--%>
    <form id="form" class="frm" action="<c:url value='/bos/faqWrite'/>" method="post">

        <!-- FAQ Type -->
        <div class="form-group">
            <label for="exampleSelect1" class="form-label mt-4">FAQ 종류</label>
            <select class="form-select" name="faqTp" id="exampleSelect1">
                <option value="10"> 회원정보 </option>
                <option value="20"> 배송  </option>
                <option value="30"> 주문 / 결제 </option>
                <option value="40"> 교환 / 반품 </option>
                <option value="50"> 이벤트혜택 </option>
                <option value="60"> 취소 / 환불 </option>
                <option value="70"> 이용안내 </option>
                <option value="80"> 쿠폰 / 포인트 </option>
            </select>
        </div><br>

        <!-- FAQ Title -->
        제목
        <input name="title" type="text" class="detail-tit1" placeholder="제목을 입력해 주세요." required><br>

        <!-- FAQ Content -->
        상세내용
        <textarea name="content" rows="15" class="detail-cont" placeholder="내용을 입력해 주세요." required></textarea>

        <!-- Button -->
        <button type="button" id="listBtn" class="btn btn-primary btn-sm"><i class="fa-solid fa-list-ul"></i> 목 록</button>
        <button type="submit" id="writeBtn" class="btn btn-primary btn-sm"><i class="fa fa-pen-nib"></i> 글 작성</button>
    </form>
</div>




<!-- Show success or error messages -->
<script>

    // Define button click event handlers
    $(document).ready(function() {


        $("#listBtn").on("click", function(){
            location.href="<c:url value='/bos/faqList${searchCondition.queryString}'/>";
            <%--location.href = "<c:url value="/bos/faqList"/>?page=${sc.page}&pageSize=${sc.pageSize}";--%>

        });

    });

</script>