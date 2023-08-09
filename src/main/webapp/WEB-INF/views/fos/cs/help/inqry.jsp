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
                        <input type="title" name="subject" id="inquiry_subject" class="inp" placeholder="문의제목을 입력해 주세요."
                               oninput="save(this.value)">
                        <%--                            <c:out value="${inqryDTO.inqryTp} ${inqryDTO.title}"/>--%>
                    </div>
                    <div class="textarea word-chker ty-2 mb-18">
                        <textarea name="content" id="inquiry_content" maxlength="1000" rows="5"
                                  placeholder="문의내용을 입력해 주세요." oninput="char_Count(this.value)"></textarea>
                        <span id="count" style="float: right; margin-right: 20px; color: #aaa;">
                                0/1,000
                            </span>
                    </div>
                </td>
            </tr>

<%--            <tr>--%>
<%--                <td class="va-tt">--%>
<%--                    <div class="inp-label ty3 mt-15">--%>
<%--                        <span class="label">첨부파일</span>--%>
<%--                    </div>--%>
<%--                </td>--%>

<%--                <td>--%>
<%--                    <div class="review-add-album pt-0">--%>
<%--                        <div class="file-box l-wrap">--%>
<%--                            <input type="hidden" class="file-config" data-file-maxsize="3" data-file-maxvol="10"--%>
<%--                                   data-file-ext="jpg, jpeg, png">--%>
<%--                            <div class="photo-item" id="photoDiv1">--%>
<%--                                <div id="photodel1" style="float:right"></div>--%>
<%--                                <label for="photo1">--%>
<%--                                    <input type="file" class="photoImg" name="photo1" id="photo1"--%>
<%--                                           accept=".jpg, .jpeg, .png" class="photo-file">--%>
<%--                                    <input type="hidden" name="image1Remove" class="imageRemoveFlag" value="0"/>--%>
<%--                                </label>--%>
<%--                                <button type="button" class="btn icon close-w photo-del" data-photo-clear>--%>
<%--                                    <span>삭제</span></button>--%>
<%--                            </div>--%>

<%--                            <div class="photo-item" id="photoDiv2">--%>
<%--                                <div id="photodel2" style="float:right"></div>--%>
<%--                                <label for="photo2">--%>
<%--                                    <input type="file" class="photoImg" name="photo2" id="photo2"--%>
<%--                                           accept=".jpg, .jpeg, .png" class="photo-file">--%>
<%--                                    <input type="hidden" name="image2Remove" class="imageRemoveFlag" value="0"/>--%>
<%--                                </label>--%>
<%--                                <button type="button" class="btn icon close-w photo-del" data-photo-clear>--%>
<%--                                    <span>삭제</span></button>--%>
<%--                            </div>--%>

<%--                            <div class="photo-item" id="photoDiv3">--%>
<%--                                <div id="photodel3" style="float:right"></div>--%>
<%--                                <label for="photo3">--%>
<%--                                    <input type="file" class="photoImg" name="photo3" id="photo3"--%>
<%--                                           accept=".jpg, .jpeg, .png" class="photo-file">--%>
<%--                                    <input type="hidden" name="image3Remove" class="imageRemoveFlag" value="0"/>--%>
<%--                                </label>--%>
<%--                                <button type="button" class="btn icon close-w photo-del" data-photo-clear>--%>
<%--                                    <span>삭제</span></button>--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                    <ul class="list ty2">--%>
<%--                        <li>이미지는 30MB 미만의 jpg, jpeg, png 파일만 첨부하실 수 있으며, 최대 3개까지 등록 가능합니다.</li>--%>
<%--                    </ul>--%>
<%--                </td>--%>
<%--            </tr>--%>
            </tbody>
        </table>
    </div>
    <div class="btn-area">
        <a href="<c:url value='/inqry/inqryList'/>" class="btn ty4  c-ty7 free w-108"><span>취소</span></a>
        <button type="button" class="btn ty4  c-ty1 free w-108" id="btnRegister"><span>등록</span></button>
    </div>
</section>
<form id="tmp_form" action="/inqry/inqryList" method="get"></form>

</body>
<script>

    let photoDiv1; //이미지 넣을 div요소 주소가져옴

    let photoDiv2; //이미지 넣을 div요소 주소가져옴

    let photoDiv3; //이미지 넣을 div요소 주소가져옴

    let photodel1 = document.getElementById("photodel1"); // x 버튼 들어갈 요소주소 가져옴

    let photodel2 = document.getElementById("photodel2"); // x 버튼 들어갈 요소주소 가져옴

    let photodel3 = document.getElementById("photodel3"); // x 버튼 들어갈 요소주소 가져옴

   // let letImgExistYn = [0, 0, 0]; //이미지 등록되어있는지 여부 확인용 배열

    let preventClick = 0; //등록중 또 등록버튼 누르는거 방지용 변수

    let inqryNomber;

    let inqryType; // 문의 유형 번호 저장. 91: 주문문의, 92:상품문의, 93:배송문의, 94:결제문의, 95:이상품찾아요, 96:건의사항있어요

    let inqryTitle; // 문의 제목

    let inqryContent; // 문의 내용

    let inqryData; // 등록할 때 보낼 데이터

    let go_inqryList = document.getElementById("tmp_form");

    let regrIden; //사용자 id

    let regYn; // 등록성공여부를 저장할 변수

    let divImg = document.getElementsByClassName("photo-item");

    let photoImg = document.getElementsByClassName("photoimg");

    let delBtn; //삭제버튼 주소 저장용 변수

    let photo1;

    let photo2;

    let photo3;

    let lastChild;

    let formData;

    let fileInput;

    let photoItem;

    const inqryTypeTextMap = {
        "91": "주문문의",
        "92": "상품문의",
        "93": "배송문의",
        "94": "결제문의",
        "95": "이 상품 찾아요",
        "96": "건의사항 있어요"
    };

    $("#btnRegister").on("click", function () {
        if (preventClick !== 0) return; //더블클릭 방지용 변수가 0이 아닐시 return
        preventClick++;  //더블클릭 방지용 변수 하나올리고 작업

        var currentDate = new Date();
        var formattedDate = currentDate.toISOString(); // ISO 8601 형식으로 변환

        inqryData = {
            regrId: regrIden,
            inqryTp: inqryType,
            title: inqryTitle,
            content: inqryContent,
            regDttm: formattedDate // 현재 날짜와 시간을 ISO 8601 형식으로 저장
        }

        $.ajax({
            type: 'POST',
            url: '/inqry/write',
            headers: {"content-type": "application/json"},
            dataType: 'text',
            data: JSON.stringify(inqryData),
            success: function (result) {
                if(confirm("1:1문의를 등록하시겠습니까?") == true){
                    regYn = JSON.parse(result);
                    go_inqryList.submit();
                    alert("등록이 완료되었습니다.");
                    location.href = "/inqry/inqryList";
                    preventClick = 0;
                }
                else{
                    return ;
                }

            },
            error: function () {
                alert("error reg");
                preventClick = 0;
            }
        })
    })


    $("#inquiry_classify").on("change", function () {
        let optionvalue = this.value;
        if (optionvalue !== "") {
            this.style.color = "black";
            inqryType = this.value;

            // inqryTp가 94일 때와 96일 때에 따라 다른 값을 할당
            if (inqryType === "94") {
                // inqryTp가 94일 때
                // 원하는 한글 값을 변수에 할당
                // 예: "결제문의"와 같은 한글 문구를 변수에 할당
                let inqryTypeText = "결제문의";
                // 이후 inqryTypeText 변수를 활용하여 원하는 곳에 한글 값을 표시
            } else if (inqryType === "96") {
                // inqryTp가 96일 때
                // 원하는 한글 값을 변수에 할당
                // 예: "건의사항 있어요"와 같은 한글 문구를 변수에 할당
                let inqryTypeText = "건의사항 있어요";
                // 이후 inqryTypeText 변수를 활용하여 원하는 곳에 한글 값을 표시
            }
        }
    });


    function char_Count(value) {
        let count = value.length;
        document.getElementById("count").textContent = count + '/1000';
        inqryContent = value; // 문의 내용을 저장
    }

    function save(value) {
        inqryTitle = value; // 문의 제목을 저장
    }

    for (let i = 0; i < photoImg.length; i++) {
        photoImg[i].addEventListener('change', click_imgBtn);
    }


    function click_imgBtn() {
        photoItem = event.currentTarget.closest('.photo-item');

        let tmpId = event.currentTarget.id;

        alert("tmpId = "+ tmpId);

        fileInput = document.getElementById(tmpId);

        console.log("phtoItem = " + photoItem);

        //이미등록된 이미지가 있으면 삭제하고 새로추가.

        let closeTag = photoItem.firstElementChild;
        let TagId = closeTag.id;

        console.log("closeTag = " + closeTag);

        console.log("TagId  = " + TagId);

        switch (TagId) {

            case 'photodel1' :
                alert("photodel1 진입");

                    lastChild = photoItem.lastElementChild;
                    alert("lastChild = " + lastChild);
                    lastChild.remove();
                    photodel1.innerHTML = "";

                makeImg("1");
                img_upload("photo1");
                break;

            case 'photodel2' :
                   lastChild = photoItem.lastElementChild;
                    lastChild.remove();
                    photodel2.innerHTML = "";
                break;

            case 'photodel3' :

                    lastChild = photoItem.lastElementChild;
                    lastChild.remove();
                    photodel3.innerHTML = "";

                makeImg("3");
                break;
        }
    }

    function makeImg(position) {

        alert("mekeImg진입");

        alert("fileinput = " + fileInput);

        var file = fileInput.files[0];
        if (file) {
            var reader = new FileReader();
            reader.onload = function (event) {
                var imagePreview = document.createElement('img');
                imagePreview.src = event.target.result;
                imagePreview.alt = 'Uploaded Image';
                imagePreview.style.maxWidth = '200px'; // 이미지의 최대 너비 설정
                imagePreview.style.display = 'block';

                delBtn = document.createElement('button');
                delBtn.innerText = "X";
                delBtn.style.backgroundColor = "yellow";

                switch (position) {
                    case "1" :
                        photoDiv1 = document.getElementById("photoDiv1");
                        photoDiv1.innerHTML = "";
                        delBtn.id = "delBtn1";
                        photoDiv1.appendChild(delBtn)
                        photoDiv1.appendChild(imagePreview);
                        let delBtn1 = document.getElementById("delBtn1");
                        delBtn1.addEventListener("click", function () {
                            photoDiv1.innerHTML = "";
                            let tmpText = "";
                            tmpText += "<div id = 'photodel1' style='float:right'>" + "</div>" +
                                "<label for='photo1'>" +
                                "<input type='file' class='photoImg' onclick='click_imgBtn()' name='photo1' id='photo1' accept='.jpg, .jpeg, .png' class='photo-file'>" +
                                "<input type='hidden' name='image1Remove' class='imageRemoveFlag' value='0' />" +
                                "</label>";
                            // photo1 = document.getElementById("photo1");
                            // alert("photo1 = " + photo1);
                            // photo1.addEventListener('change', click_imgBtn);
                            photoDiv1.innerHTML = tmpText ;
                        })
                }
                //photoItem.appendChild(imagePreview);
            };
            reader.readAsDataURL(file);
        }
    }

    function img_upload(id) {

        formData = new FormData();
        formData.append('file', $('#'+id)[0].files[0]);

        console.log(formData);

        $.ajax({
            url: '/inqry/imgUpload',
            type: 'POST',
            data: formData,
            processData: false,
            contentType: false,
            success: function (response) {
                console.log("성공");
            },
            error: function (error) {
                console.log("실패");
            }
        });
    }

</script>