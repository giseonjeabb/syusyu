<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ page session="true" %>

<head>
    <style>
        @import url(${cssUrlFos} /cs/inqryList.scss);

    </style>
</head>
<body>
<%--<form name="Frm" id="frm" method="post" action="https://www.ottogimall.co.kr/front/mypage/cs.act" >--%>
<%--    <input type="hidden" name="exec" value="inquiry" />--%>
<%--    <input type="hidden" name="cmd" value="regist"/>--%>
<%--    <input type="hidden" name="orderIdx" id="order_idx" value="" />--%>
<%--    <input type="hidden" name="idx" value="2866" />--%>
<section>
    <h3 class="title-t ty3 mb-30">1:1 문의하기</h3>

    <div class="tbl ty2 mb-40">

        <table>
            <colgroup>
                <col style="width:210px">
                <col style="width:auto">
            </colgroup>
            <tbody>
            <tr>
                <td>
                    <div class="inp-label ty3">
                        <span class="label essential">문의유형</span>
                    </div>
                </td>

                <td>
                    <select id="inquiry_classify" name="classify" choosed="96" class="selectbox ty1 w-450">
                        <option value="" selected="selected">문의유형을 선택해 주세요</option>
                        <option value="91" orders="1">주문문의</option>
                        <option value="92">상품문의</option>
                        <option value="93" orders="1">배송문의</option>
                        <option value="94">결제문의</option>
                        <option value="95">이 상품 찾아요</option>
                        <option value="96">건의사항 있어요</option>
                    </select>
                </td>
            </tr>

            <tr>
                <td class="va-tt">
                    <div class="inp-label ty3 mt-15">
                        <span class="label essential">문의사항</span>
                    </div>
                </td>
                    <td>
                        <div class="input w-full mb-10">
                            <input type="text" name="subject" id="inquiry_subject" class="inp" placeholder="문의제목을 입력해 주세요." oninput="save(this.value)" value="${inqryDTO.title}" />
                        <%--                            <c:out value="${inqryDTO.inqryTp} ${inqryDTO.title}"/>--%>
                        </div>
                        <div class="textarea word-chker ty-2 mb-18">
                            <textarea name="content" id="inquiry_content" maxlength="1000" rows="5" placeholder="문의내용을 입력해 주세요." oninput="char_Count(this.value)">${inqryDTO.content}</textarea>
                            <span id="count" style="float: right; margin-right: 20px; color: #aaa;">
                                0/1,000
                            </span>
                        </div>
                    </td>
                </tr>

<%--                <tr>--%>
<%--                    <td class="va-tt">--%>
<%--                        <div class="inp-label ty3 mt-15">--%>
<%--                            <span class="label">첨부파일</span>--%>
<%--                        </div>--%>
<%--                    </td>--%>

<%--                    <td>--%>
<%--                        <div class="review-add-album pt-0">--%>
<%--                            <div class="file-box l-wrap">--%>
<%--                                <input type="hidden" class="file-config" data-file-maxsize="3" data-file-maxvol="10" data-file-ext="jpg, jpeg, png">--%>

<%--                                <div class="photo-item ">--%>

<%--                                    <label for="photo1">--%>
<%--                                        <input type="file" name="photo1" id="photo1" accept=".jpg, .jpeg, .png" class="photo-file">--%>
<%--                                        <input type="hidden" name="image1Remove" class="imageRemoveFlag" value="0" />--%>
<%--                                    </label>--%>

<%--                                    <button type="button" class="btn icon close-w photo-del" data-photo-clear>--%>
<%--                                        <span>삭제</span>--%>
<%--                                    </button>--%>
<%--                                </div>--%>

<%--                                <div class="photo-item ">--%>

<%--                                    <label for="photo2">--%>
<%--                                        <input type="file" name="photo2" id="photo2" accept=".jpg, .jpeg, .png" class="photo-file">--%>
<%--                                        <input type="hidden" name="image2Remove" class="imageRemoveFlag" value="0" />--%>
<%--                                    </label>--%>
<%--                                    <button type="button" class="btn icon close-w photo-del" data-photo-clear><span>삭제</span></button>--%>
<%--                                </div>--%>

<%--                                <div class="photo-item ">--%>

<%--                                    <label for="photo3">--%>
<%--                                        <input type="file" name="photo3" id="photo3" accept=".jpg, .jpeg, .png" class="photo-file">--%>
<%--                                        <input type="hidden" name="image3Remove" class="imageRemoveFlag" value="0" />--%>
<%--                                    </label>--%>
<%--                                    <button type="button" class="btn icon close-w photo-del" data-photo-clear><span>삭제</span></button>--%>
<%--                                </div>--%>

<%--                            </div>--%>
<%--                        </div>--%>
<%--                        <ul class="list ty2">--%>
<%--                            <li>이미지는 30MB 미만의 jpg, jpeg, png 파일만 첨부하실 수 있으며, 최대 3개까지 등록 가능합니다.</li>--%>
<%--                        </ul>--%>
<%--                    </td>--%>
<%--                </tr>--%>
                </tbody>
            </table>
        </div>

        <div class="btn-area">
            <a href="/inqry/inqryList" class="btn ty4  c-ty7 free w-108"><span>취소</span></a>
            <button type="button" class="btn ty4  c-ty1 free w-108" id="btnRegister"><span>등록</span></button>
        </div>
    </section>
<form id="tmp_form" action="/inqry/inqryList" method="get">
    <input type="hidden" id="inqryNo" name="inqryNo" value="${inqryDTO.inqryNo}" />
</form>

</body>
<script>
    var preventClick = 0; // 더블 클릭 방지용 변수

    function setInquiryClassify() {
        const inqryTpValue = "${inqryDTO.inqryTp}"; // 'inqryDTO.inqryTp' 변수에는 'inqryTp' 값이 들어 있다고 가정합니다.

        // 'inqury_classify' 드롭다운 엘리먼트를 선택합니다.
        const inquiryClassifyDropdown = document.getElementById("inquiry_classify");

        // 'inqryTp' 값에 따라 선택된 옵션을 설정합니다.
        inquiryClassifyDropdown.value = inqryTpValue;

        // 선택된 값이 바뀌었을 때 이벤트 핸들러를 호출합니다.
        handleInquiryClassifyChange();
    }

    // 페이지가 로드될 때 함수를 호출하여 선택된 옵션을 설정합니다.
    setInquiryClassify();

    // 'inqury_classify' 드롭다운 값이 변경될 때 함수를 호출하여 선택된 옵션을 업데이트합니다.
    document.getElementById("inquiry_classify").addEventListener("change", handleInquiryClassifyChange);

    window.addEventListener("load", function() {
        // 처음에는 문의유형을 선택해 주세요의 색상을 #ccc로 변경합니다.
        const inquiryClassifyDropdown = document.getElementById("inquiry_classify");
        if (inquiryClassifyDropdown.value === "") {
            inquiryClassifyDropdown.style.color = "#ccc";
        }
    });

    function handleInquiryClassifyChange() {
        const selectedValue = document.getElementById("inquiry_classify").value;
        if (selectedValue !== "") {
            // 선택된 값이 있을 때만 글씨 색상을 검정으로 변경하고 필요한 작업을 수행합니다.
            document.getElementById("inquiry_classify").style.color = "black";
            inqryType = selectedValue;
        }
    }

    function char_Count(value) {
        let count = value.length;
        document.getElementById("count").textContent = count + '/1000';
    }

    // AJAX 요청 등으로 inqryDTO.inqryTp 값을 받아오는 부분은 삭제하였습니다.

    const inquiryContentTextarea = document.getElementById("inquiry_content");

    // 페이지가 로드될 때 함수를 호출하여 초기 글자 수를 설정합니다.
    char_Count(inquiryContentTextarea.value);

    // 'inquiry_content' textarea 요소의 입력 내용이 변경될 때마다 글자 수를 업데이트합니다.
    inquiryContentTextarea.addEventListener("input", function() {
        char_Count(this.value);
    });

    $("#btnRegister").on("click", function () {
        if (preventClick !== 0) return; // 더블클릭 방지용 변수가 0이 아닐시 return
        preventClick++;  // 더블클릭 방지용 변수 하나 올리고 작업
        // 폼 필드에서 데이터 수집
        const inqryType = $("#inquiry_classify").val();
        const inqryTitle = $("#inquiry_subject").val();
        const inqryContent = $("#inquiry_content").val();

        // AJAX 요청에 보낼 데이터 객체 생성
        const inqryData = {
            inqryTp: inqryType,
            title: inqryTitle,
            content: inqryContent,
            inqryNo: "${inqryDTO.inqryNo}" // inqryNo를 데이터 객체에 추가
        };

        // 서버로 AJAX 요청 보내기
        $.ajax({
            type: 'POST',
            url: '/inqry/modify', // InqryController에 추가한 새로운 메서드의 URL로 수정
            headers: { "content-type": "application/json" },
            dataType: 'text',
            data: JSON.stringify(inqryData),
            success: function (result) {
                if(confirm("1:1문의를 수정하시겠습니까?") == true){
                // 서버로부터 받은 응답 처리
                // 사용자에게 업데이트된 데이터 보여주기 (필요하면)
                alert("수정이 완료되었습니다.");
                location.href = "/inqry/inqryList";
                    preventClick = 0;
                }
                else{
                    preventClick = 0;
                    return ;
                }
            },
            error: function () {
                alert("1:1문의 업데이트에 실패하였습니다.");
                preventClick = 0;
            }
        });
    });
</script>