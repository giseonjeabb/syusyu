<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="loginId" value="${sessionScope.mbrId}"/>

<head>
    <script src="<c:url value='${jsUrlBos}/product/productRegister.js'/>"></script>
    <script src="<c:url value='/static/bos/summernote/summernote-lite.js'/>"></script>
    <link href="<c:url value='/static/bos/summernote/summernote-lite.css'/>" rel="stylesheet">
    <script src="<c:url value='/static/bos/summernote/lang/summernote-ko-KR.js'/>"></script>

    <style>
        @import url(/static/bos/product/productRegister.scss);
    </style>
</head>


<div class="container-fluid px-4">
    <h1 class="mt-4">상품 등록</h1>
    <input type="hidden" id="jsonCateList" value="${fn:escapeXml(jsonCateList)}"/>
    <table class="table m-3">
        <tr>
            <th class="col-auto">카테고리<span style="color: red;">*</span></th>
            <td class="col-auto">

                <div class="form-group row mt-6 no-gutters h-auto m-2">
                    <div class="col">
                        <select multiple size="8" class="form-select h-auto fs-5" id="cate_large">
                            <c:forEach var="large" items="${categories.largeCategories}">
                                <option name="largeNo" value="${large.key}">${large.value}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="col">
                        <select multiple size="8" class="form-select h-auto fs-5" id="cate_middle">
                            <c:forEach var="middle" items="${categories.middleCategories}">
                                <option name="middleNo" value="${middle.key}">${middle.value}</option>
                            </c:forEach>
                        </select>

                    </div>
                    <div class="col">
                        <select multiple size="8" class="form-select h-auto fs-5" id="cate_small">
                            <c:forEach var="small" items="${categories.smallCategories}">

                                <c:forEach var="smallItem" items="${small.value}">
                                    <option data-small-key="${small.key}" name="smallNo" value="${smallItem.key}">${smallItem.value}</option>

                                </c:forEach>

                            </c:forEach>
                        </select>
                    </div>
                </div>
            </td>
        </tr>

        <tr>
            <th>상품명<span style="color: red;">*</span></th>
            <td>
                <div class="input-group mb-3 mt-2">
                    <!-- 숫자만 입력 받으며, 포커스를 잃을 때 천 단위로 콤마를 추가, 키를 누를 때마다 마지막 숫자가 0인지 확인 -->
                    <input type="text" class="form-control" placeholder="상품명 60자" id="product_name" onkeyup="updateLengthSixty(this);">
                    <span class="input-group-text text_length">0/60</span>
                </div>
            </td>
        </tr>
        <!-- 판매가 입력 필드 -->
        <tr>
            <th>판매가<span style="color: red;">*</span></th>
            <td>
                <div class="input-group mb-2 mt-2 w-25">
                    <!-- 숫자만 입력 받으며, 포커스를 잃을 때 천 단위로 콤마를 추가, 키를 누를 때마다 마지막 숫자가 0인지 확인 -->
                    <input type="text" class="form-control" aria-label="Price" placeholder="숫자만 입력" value="0" id="product_price">
                    <span class="input-group-text">원</span>
                    <div class="invalid-feedback">10원 단위로 입력해주세요.</div>
                </div>
            </td>
        </tr>
        <!-- 매입가 입력 필드 -->
        <tr>
            <th>매입가<span style="color: red;">*</span></th>
            <td>
                <div class="input-group mb-2 mt-2 w-25">
                    <!-- 숫자만 입력 받으며, 포커스를 잃을 때 천 단위로 콤마를 추가, 키를 누를 때마다 마지막 숫자가 0인지 확인 -->
                    <input type="text" class="form-control" aria-label="Price" placeholder="숫자만 입력" value="0" id="product_buy_price">
                    <span class="input-group-text">원</span>
                    <div class="invalid-feedback">10원 단위로 입력해주세요.</div>
                </div>
            </td>
        </tr>

    <%--할인--%>
        <tr>
            <th>할인</th>
            <td>
                <div class="btn-group" role="group" aria-label="Basic radio toggle button group">
                    <input type="radio" class="btn-check" name="dc_btnradio" id="dc_btnradio" autocomplete="off">
                    <label class="btn btn-outline-dark" for="dc_btnradio">설정함</label>
                    <input type="radio" class="btn-check" name="dc_btnradio" id="dc_btnradio_no" autocomplete="off" checked="">
                    <label class="btn btn-outline-dark" for="dc_btnradio_no">설정안함</label>
                </div>
            </td>
        </tr>

        <tr class="dc_content">
            <th text-dark>기본할인</th>
            <td>
                <div class="input-group mb-2 mt-2 w-25">
                    <input type="text" class="form-control" maxlength="2" aria-label="Amount" placeholder="할인율" value="0" id="product_per"  oninput="checkDiscount(this);" onblur="formatWithComma(this);">
                    <span class="input-group-text">%</span>
                </div>
                <div class="form-check m-3">
                    <input class="form-check-input chk-dark" type="checkbox" value="" id="dc_date_chk">
                        <label class="form-check-label" for="dc_date_chk">
                            특정기간만 할인
                        </label>
                    </input>
                </div>
                <div class="d-flex d-none" id="dc_date">
                    <div class="btn-group col-6 align-items-end p-2" role="group" aria-label="Basic radio toggle button group" id="dcDate">
                        <input type="radio" class="btn-check col-auto date_range dc_date_range" name="dcbtnradio" data-interval="3" id="dcDate1" autocomplete="off" checked="">
                        <label class="btn btn-outline-dark  date_range" for="dcDate1">3일</label>
                        <input type="radio" class="btn-check  date_range dc_date_range" name="dcbtnradio" data-interval="5" id="dcDate2" autocomplete="off">
                        <label class="btn btn-outline-dark" for="dcDate2">5일</label>
                        <input type="radio" class="btn-check  date_range dc_date_range" name="dcbtnradio" data-interval="7" id="dcDate3" autocomplete="off">
                        <label class="btn btn-outline-dark" for="dcDate3">7일</label>
                        <input type="radio" class="btn-check  date_range dc_date_range" name="dcbtnradio" data-interval="15" id="dcDate4" autocomplete="off">
                        <label class="btn btn-outline-dark" for="dcDate4">15일</label>
                        <input type="radio" class="btn-check  date_range dc_date_range" name="dcbtnradio" data-interval="30" id="dcDate5" autocomplete="off">
                        <label class="btn btn-outline-dark" for="dcDate5">30일</label>
                        <input type="radio" class="btn-check  date_range dc_date_range" name="dcbtnradio" data-interval="90" id="dcDate6" autocomplete="off">
                        <label class="btn btn-outline-dark" for="dcDate6">90일</label>
                        <input type="radio" class="btn-check  date_range dc_date_range" name="dcbtnradio" data-interval="120" id="dcDate7" autocomplete="off">
                        <label class="btn btn-outline-dark" for="dcDate7">120일</label>
                    </div>
                    <div class="calendar p-1 col-8 d-flex align-items-center">
                        <div class="input col-4 p-1 align-items-center justify-content-center">
                            <input type="text" name="dcStDttm" id="dc_start_date" readonly="readonly"
                                   class="inp datepicker hasDatepicker">
                        </div>
                        <span class="m p-1 align-items-center justify-content-center">~</span>
                        <div class="input p-1 align-items-center justify-content-center">
                            <input type="text" name="dcEdDttm" id="dc_end_date" readonly="readonly"
                                   class="inp datepicker hasDatepicker">
                        </div>
                    </div>
                </div>
                <div class="form-group d-flex border-top p-1 mt-2" id="dc_price">
                    <label for="dcPrice" class="col-sm-2 col-form-label">할인가</label>
                    <div class="col-sm-10">
                        <input type="text" readonly="" class="form-control-plaintext" id="dcPrice" value="0원">
                    </div>
                </div>
            </td>
        </tr>

        <%--팬매기간--%>
        <tr>
            <th>판매기간</th>
            <td>
                <div class="btn-group" role="group" aria-label="Basic radio toggle button group">
                    <input type="radio" class="btn-check" name="sale_date" id="sale_btnradio" autocomplete="off">
                    <label class="btn btn-outline-dark" for="sale_btnradio">설정함</label>
                    <input type="radio" class="btn-check" name="sale_date" id="sale_btnradio_no" autocomplete="off" checked="">
                    <label class="btn btn-outline-dark" for="sale_btnradio_no">설정안함</label>
                </div>
            </td>
        </tr>

        <tr class="sale_date mt-2">
            <th>기간설정</th>
            <td class="d-flex align-items-end date_range_container btn-group fs-5">
                <div class="btn-group col-6 align-items-end p-2" role="group" aria-label="Basic radio toggle button group">
                    <input type="radio" class="btn-check  date_range sale_date_range" name="btnradio" data-interval="7" id="saleDate1" autocomplete="off">
                    <label class="btn btn-outline-dark  date_range sale_date_range" for="saleDate1">7일</label>
                    <input type="radio" class="btn-check  date_range sale_date_range" name="btnradio" data-interval="15" id="saleDate2" autocomplete="off">
                    <label class="btn btn-outline-dark" for="saleDate2">15일</label>
                    <input type="radio" class="btn-check  date_range sale_date_range" name="btnradio" data-interval="30" id="saleDate3" autocomplete="off">
                    <label class="btn btn-outline-dark" for="saleDate3">30일</label>
                   <input type="radio" class="btn-check  date_range sale_date_range" name="btnradio" data-interval="90" id="saleDate4" autocomplete="off">
                    <label class="btn btn-outline-dark" for="saleDate4">90일</label>
                   <input type="radio" class="btn-check  date_range sale_date_range" name="btnradio" data-interval="120" id="saleDate5" autocomplete="off">
                    <label class="btn btn-outline-dark" for="saleDate5">120일</label>
                   <input type="radio" class="btn-check  date_range sale_date_range" name="btnradio" data-interval="365" id="saleDate6" autocomplete="off">
                    <label class="btn btn-outline-dark" for="saleDate6">1년</label>
                   <input type="radio" class="btn-check  date_range sale_date_range" name="btnradio" data-interval="1825`" id="saleDate7" autocomplete="off">
                    <label class="btn btn-outline-dark" for="saleDate7">5년</label>
                </div>

                <div class="calendar d-flex align-items-center justify-center p-2">
                    <div class="input">
                        <input type="text" name="saleStDttm" id="sale_start_date" readonly="readonly"
                               class="inp datepicker hasDatepicker">
                    </div>
                    <span class="m mx-2">~</span>
                    <div class="input">
                        <input type="text" name="saleEdDttm" id="sale_end_date" readonly="readonly"
                               class="inp datepicker hasDatepicker">
                    </div>
                </div>
            </td>
            </td>
        </tr>
        <%--재고수량--%>
        <tr>
            <th>재고수량</th>
            <td>
                <div class="input-group mb-3 d-flex">
                    <div class="input-group mb-3 mt-2 w-25">
                        <input type="text" class="form-control" aria-label="qty" placeholder="숫자만 입력" id="tot_qty" value="0" disabled>
                        <span class="input-group-text">개</span>
                    </div>
                    <p class="p-3 text-black-50 small">옵션 재고수량을 사용하면, 옵션의 재고수량으로 적용되어 자동으로 입력됩니다.</p>
                </div>
            </td>
        </tr>
        <%-- 옵션--%>
        <tr>
            <th c>옵션입력<span style="color: red;">*</span></th>
            <td>
                <div class="flex-column">
                    <div class="col-10 d-flex">
                        <div class="p-3 col-4 d-flex align-items-center">
                            <label for="input_color" class="me-3 col-2">컬러</label>
                            <input type="text" id="input_color" class="form-control col" placeholder="색상 입력">
                        </div>
                        <div class="p-3 col-6 d-flex align-items-center">
                            <label for="input_size" class="me-3 col-2">사이즈</label>
                            <input type="text" id="input_size" class="form-control col-6" placeholder="예시 : 220, 225 (,로 구분)">
                        </div>
                    </div>
                    <div>
                        <button type="button" class="btn btn-dark" id="btnOpt">옵션목록으로 적용↓</button>
                    </div>
                </div>
            </td>
        </tr>
        <tr>
            <th>옵션목록</th>
            <td>
                <div class="datatable-wrapper datatable-loading flex-column no-footer sortable searchable fixed-columns">

                    <div class="datatable-top d-flex justify-content-between">
                        <button type="button" class="btn btn-outline-dark" id="chk_del">선택삭제</button>
                    </div>
                    <div class="table-responsive datatable-container ml-auto">
                        <table id="opt_table" class="table bg-white table-striped datatable-table table-bordered">
                            <thead class="bg-dark text-light">
                            <tr>
                                <th rowspan="2" class="text-center align-middle"><input type="checkbox"></th>
                                <th data-sortable="true" colspan="2" class="text-center align-middle">옵션명</th>
                                <th data-sortable="true" rowspan="2" class="text-center align-middle"><a href="#" class="datatable-sorter">옵션가</a></th>
                                <th data-sortable="true" rowspan="2" class="text-center align-middle"><a href="#" class="datatable-sorter">재고수량</a></th>
                                <th data-sortable="true" rowspan="2" class="text-center align-middle"><a href="#" class="datatable-sorter">판매상태</a></th>
                                <th data-sortable="true" rowspan="2" class="text-center align-middle"><a href="#" class="datatable-sorter">사용여부</a></th>
                                <th data-sortable="true" rowspan="2" class="text-center align-middle">삭제</th>
                            </tr>
                            <tr>
                                <td class="text-center align-middle">컬러</td>
                                <td class="text-center align-middle">사이즈</td>
                            </tr>
                            </thead>
                            <tbody>

                            </tbody>
                        </table>
                    </div>
                </div>
            </td>
        </tr>
        <%-- 이미지--%>
        <tr>
            <th >대표이미지<span style="color: red;">*</span></th>
            <td>
                <input class="form-control" type="file" id="repImg" onchange="validateFileInput(this)">
                <p class="text-dark small p-2">권장 크기 : 1000 x 1000 (윈도대상 750 x 1000)</p>
            </td>
        </tr>
        <tr>
            <th scope="row">추가이미지</th>
            <td id="smlImgDiv row">
                <div>

                    <input class="smlImg form-control " type="file" onchange="validateFileInput(this)">
                    <div id="imgInfo" >

                    </div>정
                    <p class="text-dark small p-2">권장 크기 : 1000 x 1000 (윈도대상 750 x 1000)
                        추가이미지는 최대 9개까지 설정할 수 있습니다.
                        jpg,jpeg,gif,png,bmp 형식의 정지 이미지만 등록됩니다.</p>
                    <button type="button" class="btn btn-dark" id="addImgBtn"><i class="fa-solid fa-plus"></i></button>
                </div>

            </td>
        </tr>
        <%-- 스마트에디터--%>
        <tr>
            <th scope="row">상세설명</th>
            <td>

                <div id="summernote"></div>

            </td>
        </tr>
        <tr>
            <th scope="row">모델명</th>
            <td>
                <div class="input-group mb-3 mt-2">
                    <input type="text" class="form-control" placeholder="모델명 60자" id="product_model" onkeyup="updateLengthSixty(this);">
                    <span class="input-group-text text_length">0/60</span>
                </div>
            </td>
        </tr>
        <tr>
        <th scope="row">최대구매수량</th>
        <td><input type="text" class="form-control" placeholder="숫자만입력" id="dlvChgDtl" value="999999" oninput="updateLengthSixty(this)"></td>

    </tr>
    <tr>
        <th scope="row">제품소재<span style="color: red;">*</span></th>
        <td>
            <div class="input-group mb-3 mt-2">
                <input type="text" class="form-control" placeholder="제품소재 100자" id="mfgdMatr" oninput="updateLengthHundred(this)">
                <span class="input-group-text text_length">0/100</span>
            </div>
        </td>
    </tr>
    <tr>
        <th>브랜드<s매pan style="color: red;">*</s매pan></th>
        <td>
            <select class="form-select" id="product_brand">
                <c:forEach var="brand" items="${brandList}">
                    <option name="brandId" value="${brand.brndId}">${brand.brndNm}</option>
                </c:forEach>
            </select>
        </td>
    </tr>
    <tr>
        <th scope="row">제조사<span style="color: red;">*</span></th>
        <td>
            <select class="form-select" id="mftco">
                <c:forEach items="${mftcoList}" var="item">
                    <option value="${item.code}">${item.cdNm}</option>
                </c:forEach>
            </select>
        </td>
    </tr>

    <tr>
        <th scope="row">제조국<span style="color: red;">*</span></th>
        <td>
            <select class="form-select" id="mftNatn">
                <c:forEach items="${mftNatnList}" var="item">
                    <option value="${item.code}">${item.cdNm}</option>
                </c:forEach>
            </select>
        </td>
    </tr>
    <tr>
        <th>출시일</th>
        <td>
            <div class="input col-3">
                <input type="text" name="rles_dt" id="rles_dt" readonly="readonly" class="inp datepicker hasDatepicker col-3">
            </div>
        </td>
    </tr>
    <tr>
        <td colspan="2">

            <div class="d-flex align-items-center justify-content-center">
                <button type="button" class="btn btn-outline-dark m-2" id="cancelBtn">취소하기</button>
                <button type="button" class="btn btn-dark m-2" onclick="productRegisterSave()">저장하기</button>
            </div>

        </td>
    </tr>
</table>



</div>




