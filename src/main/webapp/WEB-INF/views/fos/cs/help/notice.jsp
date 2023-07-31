<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true"%>

<head>
    <%----SCSS 파일 주입--%>
    <style>
        @import url(${cssUrlFos}/cs/notice.scss);
    </style>
    <%-- JS 파일 주입--%>
        <script src="https://code.jquery.com/jquery-1.11.3.js"></script>
        <script src="<c:url value='${jsUrlFos}/cs/mypage/notice.js'/>" ></script>
        <%-- 이상하게 적용안되는중 하단에 적으면되는데 JS 파일로 따로 빼서 받으면 404뜸--%>
</head>


        <script>
            let msg = "${msg}";
            if(msg == "WRT_ERR") alert("글 등록 실패 했습니다.");
            if(msg == "MOD_ERR") alert("글 수정 실패 했습니다.");
        </script>

<div class="container">
    <h2 class="title-t ty3 mb-30"> 공지사항 ${mode=="new" ? " 작성 " : " "}</h2>
    <form id="tbl ty1" class="frm" action="" method="post">


<%-- ===============================경계선-=========================--%>
        <input type="hidden" name="notcNo" value="${noticeDto.notcNo}">
        <colgroup>
            <col style="width: 105px">
            <col style="width: auto">
            <col style="width: 110px">
        </colgroup>

        <tr>
            <input name="title" type="text" class="detail-tit1" value="<c:out value= '${noticeDto.title}'/>" placeholder="  제목을 입력해 주세요." ${mode=="new" ? "" : "readonly='readonly'"}><br>
        </tr>
            <textarea name="content" rows="20" class="detail-cont" placeholder=" 내용을 입력해 주세요." ${mode=="new" ? "" : "readonly='readonly'"}><c:out value=" ${noticeDto.content}"/></textarea><br>


        <%-- 하단 이전글 다음글 선택--%>
        <nav class ="detail_nav">
            <ul>
                <%--        다음글  : 다음글 제목--%>
                <%--            다음글이 없다면 empty nextTitle--%>
                <li class="detail__nav-next">
                    <span class="nextPage">다음 글  &nbsp <i class="fa-sharp fa-solid fa-caret-up"></i></span>
                    <c:if test="${not empty nextTitle}">
                        <a href="/notice/read?notcNo=${noticeDto.notcNo + 1}">${nextTitle}</a>
                    </c:if>
                    <c:if test="${empty nextTitle}">
                        <span>다음 글이 존재하지 않습니다</span>
                    </c:if>
                </li>

                <br>
                <%--        이전글 :  이전글 제목--%>
                <%--        이전글이 없다면 emptyprevTitle--%>
                <li class="detail__nav-prev">
                    <span class="prevPage">이전 글  &nbsp; <i class="fa-solid fa-caret-down"></i></span>
                    <c:if test="${not empty prevTitle}">
                        <a href="/notice/read?notcNo=${noticeDto.notcNo - 1}">${prevTitle}</a>
                    </c:if>
                    <c:if test = "${empty prevTitle}">
                        <span>이전 글이 존재 하지 않습니다.</span>
                    </c:if>
                </li>

            </ul>
        </nav>

        <%--        < 버튼- 등록 수정 삭제>--%>
        <%--        <c:if test="${mode eq 'new'}">--%>
        <%--            <button type="button" id="writeBtn" class="btn btn-write"><i class="fa fa-pencil"></i> 등록</button>--%>
        <%--        </c:if>--%>

        <%--        <c:if test="${mode ne 'new'}">--%>
        <%--            <button type="button" id="writeNewBtn" class="btn btn-write"><i class="fa fa-pencil"></i> 글쓰기</button>--%>
        <%--        </c:if>--%>

        <%--        <c:if test="${boardDto.writer eq loginId}">--%>
        <%--            <button type="button" id="modifyBtn" class="btn btn-modify"><i class="fa fa-edit"></i> 수정</button>--%>
        <%--            <button type="button" id="removeBtn" class="btn btn-remove"><i class="fa fa-trash"></i> 삭제</button>--%>
        <%--        </c:if>--%>

        <button type="button" id="listBtn" class="btn btn-list"><i class="fa fa-bars"></i> 목록</button>
    </form>
</div>



<script>
    $(document).ready(function(){
        // 제목과 내용이 있는지 없는지 확인함
        let formCheck = function() {
            let form = document.getElementById("form");
            if(form.title.value=="") {
                alert("제목을 입력해 주세요.");
                form.title.focus();
                return false;
            }
            if(form.content.value=="") {
                alert("내용을 입력해 주세요.");
                form.content.focus();
                return false;
            }
            return true;
        }


        $("#listBtn").on("click", function(){
            location.href="<c:url value='/notice/noticeList${searchCondition.queryString}'/>";
        });
    });
</script>




