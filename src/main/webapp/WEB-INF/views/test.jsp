<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>CommentTest</title>
    <script src="https://code.jquery.com/jquery-1.11.3.js"></script>
</head>
<body>
<h2>commentTest</h2>
comment : <input type="text" name="comment"> <br>
<button id="sendBtn" type="button">SEND</button>
<button id="modBtn" type="button">수정</button>
<h2>Data From Server :</h2>
<div id="commentList"></div>
<div id="replyForm" style="display: none;">
    <input type="text" name="replyComment">
    <button id="wrtRepBtn" type="button">등록</button>

    <div id="as">A/s안내</div>
</div>
<script>
    let brand = ${brand};

    if (bradn == '이마트') {
        document.getElementById('id').innerHTML = '';

    } else if (brand == 'ssg') {

    }

    let bno = 1085;

    // 특정 게시물에 달려있는 댓글들을 가져온다.
    let showList = function (bno) {
        $.ajax({
            type: 'GET',       // 요청 메서드
            url: '/comments?bno=' + bno,  // 요청 URI
            success: function (result) {
                $("#commentList").html(toHtml(result)); // 서버로부터 응답이 도착하면 호출될 함수
            },
            error: function () {
                alert("error")
            }
        }); // $.ajax()
    }

    $(document).ready(function () {
        let person = { name: "abc", age: 10};
        let person2 = {};

        $.ajax({
            type: 'POST',       // 요청 메서드
            url: '/send',  // 요청 URI
            headers: {"content-type": "application/json"}, // 요청 헤더
            dataType: 'text', // 서버에서 받을 데이터 형식
            data: JSON.stringify(person),  // 서버로 전송할 데이터. stringify()로 직렬화 필요.
            success: function (result) { // 서버로부터 응답이 도착하면 호출될 함수
                person2 = JSON.parse(result);
                alert(result); // result는 서버가 전송한 데이터
            },
            error: function () { // 에러가 발생했을 때, 호출될 함수
                alert("error")
            }
        });


        showList(bno);

        $("#wrtRepBtn").click(function () {
            let comment = $("input[name=replyComment]").val();
            let pcno = $("#replyForm").parent().attr("data-pcno");

            if (comment.trim() == '') {
                alert("댓글을 입력해주세요.");
                $("input[name=replyComment]").focus();

                return;
            }

            $.ajax({
                type: 'POST',       // 요청 메서드
                url: '/comments?bno=' +  bno,  // 요청 URI
                headers: {"content-type": "application/json"}, // 요청 헤더
                data: JSON.stringify({pcno : pcno, bno : bno, comment : comment}),  // 서버로 전송할 데이터. stringify()로 직렬화 필요.
                success: function (result) {
                    alert(result);
                    showList(bno);
                },
                error: function () {
                    alert("error")
                } // 에러가 발생했을 때, 호출될 함수
            }); // $.ajax()

            // 초기화 작업
            $("#replyForm").css("display", "none");
            $("input[name=replyComment]").val('');
            $("#replyForm").appendTo("body"); // 대댓글 입력 form을 원래 자리로 다시 되돌려놓기
        });

        $("#sendBtn").click(function () {
            let comment = $("input[name=comment]").val();

            $.ajax({
                type: 'POST',       // 요청 메서드
                url: '/comments?bno=' +  bno,  // 요청 URI
                headers: {"content-type": "application/json"}, // 요청 헤더
                data: JSON.stringify({bno : bno, comment : comment}),  // 서버로 전송할 데이터. stringify()로 직렬화 필요.
                success: function (result) {
                    alert(result);
                    showList(bno);
                },
                error: function () {
                    alert("error")
                } // 에러가 발생했을 때, 호출될 함수

                // 에러가 발생했을 때 호출될
            }); // $.ajax()
        });

        $("#commentList").on("click", ".replyBtn", function () {
            // 1. replyForm을 옮기고
            $("#replyForm").appendTo($(this).parent());

            // 2. 답글을 입력할 폼을 보여준다.
            $("#replyForm").css("display", "block");
        });

        $("#commentList").on("click", ".modBtn", function () {
            let cno = $(this).parent().attr("data-cno");
            let bno = $(this).parent().attr("data-bno");
            let comment = $("span.comment", $(this).parent()).text();

            // 1. comment의 내용을 input에 뿌려주기
            $("input[name=comment]").val(comment);
            // 2. cno 전달하기
            $("#modBtn").attr("data-cno", cno);

            $("#modBtn").click(function () {
                let cno = $(this).attr("data-cno");
                let comment = $("input[name=comment]").val();

                $.ajax({
                    type: 'PATCH',       // 요청 메서드
                    url: '/comments/' + cno, // 요청 URI /syusyu/comments/70 POST
                    headers: {"content-type": "application/json"}, // 요청 헤더
                    data: JSON.stringify({cno : cno, comment : comment}),  // 서버로 전송할 데이터. stringify()로 직렬화 필요.
                    success: function (result) {
                        alert(result);
                        showList(bno);
                    },
                    error: function () {
                        alert("error")
                    } // 에러가 발생했을 때, 호출될 함수
                }); // $.ajax()
            });
        });
        // $(".delBtn").click(function () {
        $("#commentList").on("click", ".delBtn", function () {
            let cno = $(this).parent().attr("data-cno");
            let bno = $(this).parent().attr("data-bno");

            $.ajax({
                type: 'DELETE',       // 요청 메서드
                url: '/comments/' + cno + '?bno=' + bno,  // 요청 URI
                success: function (result) {
                    alert(result);
                    showList(bno);
                },
                error: function () {
                    alert("error")
                }
            }); // $.ajax()
        });
    });

    let toHtml = function (comments) {
        let tmp = "<ul>";

        comments.forEach(function (comment) {
            tmp += '<li data-cno=' + comment.cno
            tmp += ' data-pcno=' + comment.pcno
            tmp += ' data-bno=' + comment.bno + '>'
            if (comment.cno != comment.pcno)
                tmp += 'ㄴ'
            tmp += ' commenter=<span class="commenter">' + comment.commenter + '</span>'
            tmp += ' comment=<span class="comment">' + comment.comment + '</span>'
            tmp += ' up_date=' + comment.up_date
            tmp += '<button class="delBtn">삭제</button>'
            tmp += '<button class="modBtn">수정</button>'
            tmp += '<button class="replyBtn">답글</button>'
            tmp += '</li>'
        });

        return tmp + "</ul>";
    }

</script>
</body>
</html>