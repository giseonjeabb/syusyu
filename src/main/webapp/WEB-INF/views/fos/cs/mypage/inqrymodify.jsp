<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ page session="true" %>

<head>
    <style>
        @import url(${cssUrlFos}/cs/inqryList.scss);

    </style>
</head>
<body>
<form name="Frm" id="frm" method="post" action="https://www.ottogimall.co.kr/front/mypage/cs.act" >
    <input type="hidden" name="exec" value="inquiry" />
    <input type="hidden" name="cmd" value="regist"/>
    <input type="hidden" name="orderIdx" id="order_idx" value="" />
    <input type="hidden" name="idx" value="2866" />


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
                            <option value="91"  orders="1">주문문의</option>
                            <option value="92"  >상품문의</option>
                            <option value="93"  orders="1">배송문의</option>
                            <option value="94"  >결제문의</option>
                            <option value="95"  >이 상품 찾아요</option>
                            <option value="96"  >건의사항 있어요</option>
                        </select>
                    </td>
                </tr>


<%--                <tr>--%>
<%--                    <td>--%>
<%--                        <div class="inp-label ty3">--%>
<%--                            <span id="production" class="label">문의상품</span>--%>
<%--                        </div>--%>
<%--                    </td>--%>

<%--                    <td>--%>
<%--                        <div class="input w-450 flex space-between">--%>
<%--                            <div class="input input-btn flex-1">--%>
<%--                                <input type="text" name="ordNo" id="ordNo" class="inp del-input" value="" readonly>--%>
<%--                                <button type="button" class="btn text-del" style="display: none;">--%>
<%--                                    <span>초기화</span>--%>
<%--                                </button>--%>
<%--                            </div>--%>
<%--                                <a href="#" class="btn ty2 c-ty5 w-90 free ml-10 bt-order-search">--%>
<%--                                    <span>주문선택</span>--%>
<%--                                </a>--%>
<%--                        </div>--%>
<%--                        <!-- 주문선택시 -->--%>

<%--                        <div id="order_product" class="product_line order mgt10 blind">--%>
<%--                        </div>--%>
<%--                    </td>--%>

                </tr>

                <tr>
                    <td class="va-tt">
                        <div class="inp-label ty3 mt-15">
                            <span class="label essential">문의사항</span>
                        </div>
                    </td>

                    <td>
                        <div class="input w-full mb-10">
                            <input type="text" name="subject" id="inquiry_subject" class="inp" placeholder="문의제목을 입력해 주세요." oninput="save(this.value)" value="${totalCnt}" />
                        <%--                            <c:out value="${inqryDTO.inqryTp} ${inqryDTO.title}"/>--%>
                        </div>
                        <div class="textarea word-chker ty-2 mb-18">
                            <textarea name="content" id="inquiry_content" maxlength="1000" rows="5" placeholder="문의내용을 입력해 주세요." oninput="char_Count(this.value)">${totalCnt}</textarea>
                            <span id="count" style="float: right; margin-right: 20px; color: #aaa;">
                                0/1,000
                            </span>
                        </div>
                    </td>
                </tr>

                <tr>
                    <td class="va-tt">
                        <div class="inp-label ty3 mt-15">
                            <span class="label">첨부파일</span>
                        </div>
                    </td>

                    <td>
                        <div class="review-add-album pt-0">
                            <div class="file-box l-wrap">
                                <input type="hidden" class="file-config" data-file-maxsize="3" data-file-maxvol="10" data-file-ext="jpg, jpeg, png">

                                <div class="photo-item ">

                                    <label for="photo1">
                                        <input type="file" name="photo1" id="photo1" accept=".jpg, .jpeg, .png" class="photo-file">
                                        <input type="hidden" name="image1Remove" class="imageRemoveFlag" value="0" />
                                    </label>

                                    <button type="button" class="btn icon close-w photo-del" data-photo-clear>
                                        <span>삭제</span>
                                    </button>
                                </div>

                                <div class="photo-item ">

                                    <label for="photo2">
                                        <input type="file" name="photo2" id="photo2" accept=".jpg, .jpeg, .png" class="photo-file">
                                        <input type="hidden" name="image2Remove" class="imageRemoveFlag" value="0" />
                                    </label>
                                    <button type="button" class="btn icon close-w photo-del" data-photo-clear><span>삭제</span></button>
                                </div>

                                <div class="photo-item ">

                                    <label for="photo3">
                                        <input type="file" name="photo3" id="photo3" accept=".jpg, .jpeg, .png" class="photo-file">
                                        <input type="hidden" name="image3Remove" class="imageRemoveFlag" value="0" />
                                    </label>
                                    <button type="button" class="btn icon close-w photo-del" data-photo-clear><span>삭제</span></button>
                                </div>

                            </div>
                        </div>
                        <ul class="list ty2">
                            <li>이미지는 30MB 미만의 jpg, jpeg, png 파일만 첨부하실 수 있으며, 최대 3개까지 등록 가능합니다.</li>
                        </ul>
                    </td>
                </tr>
<%--                <tr>--%>
<%--                    <td>--%>
<%--                        <div class="inp-label ty3">--%>
<%--                            <span class="label">답변받기</span>--%>
<%--                        </div>--%>
<%--                    </td>--%>
<%--                    <td>--%>
<%--                        <input type="hidden" name="reAllow" />--%>
<%--                        <div class="chkbox">--%>
<%--                            <label for="re_allow_mobile">--%>
<%--                                <input type="checkbox" name="_reAllow" id="re_allow_mobile" value="1" />--%>
<%--                                <span class="text">문자/알림톡</span>--%>
<%--                            </label>--%>
<%--                        </div>--%>
<%--                        <div class="chkbox">--%>
<%--                            <label for="re_allow_email">--%>
<%--                                <input type="checkbox" name="_reAllow" id="re_allow_email" value="2" />--%>
<%--                                <span class="text">이메일</span>--%>
<%--                            </label>--%>
<%--                        </div>--%>
<%--                    </td>--%>
<%--                </tr>--%>
                </tbody>
            </table>

        </div>

        <div class="btn-area">
            <a href="https://www.ottogimall.co.kr/front/mypage/cs_inquiry" class="btn ty4  c-ty7 free w-108"><span>취소</span></a>
            <button type="button" class="btn ty4  c-ty1 free w-108" id="btnRegister"><span>등록</span></button>
        </div>
    </section>
</form>

</body>
<script>

    function char_Count(value) {
        let count = value.length;
        document.getElementById("count").textContent = count + '/1000';
    }

    $("#inquiry_classify").on("change", function(){
        let optionvalue = this.value;
        if(optionvalue!==""){
            this.style.color="black";
            inqryType = this.value;
        }
    })
</script>