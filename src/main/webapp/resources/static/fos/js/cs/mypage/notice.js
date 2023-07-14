

$(document).ready(function(){
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

    $("#writeNewBtn").on("click", function(){
        location.href="<c:url value='/notice/write'/>";
    });

    $("#writeBtn").on("click", function(){
        let form = $("#form");
        form.attr("action", "<c:url value='/notice/write'/>");
        form.attr("method", "post");

        if(formCheck())
            form.submit();
    });

    $("#modifyBtn").on("click", function(){
        let form = $("#form");
        let isReadonly = $("input[name=title]").attr('readonly');

        // 1. 읽기 상태이면, 수정 상태로 변경
        if(isReadonly=='readonly') {
            $(".writing-header").html("게시판 수정");
            $("input[name=title]").attr('readonly', false);
            $("textarea").attr('readonly', false);
            $("#modifyBtn").html("<i class='fa fa-pencil'></i> 등록");
            return;
        }

        // 2. 수정 상태이면, 수정된 내용을 서버로 전송
        form.attr("action", "<c:url value='/notice/modify${searchCondition.queryString}'/>");
        form.attr("method", "post");
        if(formCheck())
            form.submit();
    });

    $("#removeBtn").on("click", function(){
        if(!confirm("정말로 삭제하시겠습니까?")) return;

        let form = $("#form");
        form.attr("action", "<c:url value='/notice/remove${searchCondition.queryString}'/>");
        form.attr("method", "post");
        form.submit();
    });

    $("#listBtn").on("click", function(){

        location.href="<c:url value='/notice/noticeList${searchCondition.queryString}'/>";

    });
});
