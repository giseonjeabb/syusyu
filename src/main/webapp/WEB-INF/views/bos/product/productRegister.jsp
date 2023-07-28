<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<head>
    <script src="<c:url value="${jsUrlBos}/product/productRegister.js"/>"></script>
    <link href="<c:url value="${cssUrlBos}/product/productRegister.css"/>" rel="stylesheet">
    <!-- include libraries(jQuery, bootstrap) -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

    <!-- include summernote css/js -->
    <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>

</head>


<div class="container-fluid px-4">
    <h1 class="mt-4">상품 등록</h1>



    <table class="table m-3">
        <tr>
            <th class="col-1" scope="row">카테고리</th>
            <td class="col-11">

                <div class="form-group row mt-6 no-gutters h-auto m-2">
                    <div class="col-3">
                     <%-- 선택하면 <strong></strong>추가 --%>
                        <select multiple size="8" class="form-select h-auto fs-5" id="cate_large">
                            <c:forEach var="large" items="${categories.largeCategories}">
                                <option value="${large.key}">${large.value}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="col-3">
                        <select multiple size="8" class="form-select h-auto fs-5" id="cate_middle">
                            <c:forEach var="middle" items="${categories.middleCategories}">
                                <option value="${middle.key}">${middle.value}</option>
                            </c:forEach>
                        </select>

                    </div>
                    <div class="col-3">
                        <select multiple size="8" class="form-select h-auto fs-5" id="cate_small">
                            <c:forEach var="small" items="${categories.smallCategories}">

                                    <c:forEach var="smallItem" items="${small.value}">
                                        <option data-small-key="${small.key}" value="${smallItem.key}">${smallItem.value}</option>

                                    </c:forEach>

                            </c:forEach>
                        </select>
                    </div>
                </div>
            </td>
        </tr>

        <tr>
            <th scope="row">상품명</th>
            <td><input type="text" class="form-control" placeholder="상품명 60자" id="product_name"></td>
        </tr>
        <tr>
            <th scope="row">판매가</th>
            <td><input type="text" class="form-control" placeholder="판매가 60자" id="product_price"></td>

        </tr>
        <tr>
            <th scope="row" >할인</th>
            <td>
                <div class="btn-group" role="group" aria-label="Basic radio toggle button group">
                    <input type="radio" class="btn-check" name="dc_btnradio" id="dc_btnradio" autocomplete="off" checked="">
                    <label class="btn btn-outline-dark" for="dc_btnradio">설정함</label>
                    <input type="radio" class="btn-check" name="dc_btnradio" id="dc_btnradio_no" autocomplete="off" checked="">
                    <label class="btn btn-outline-dark" for="dc_btnradio_no">설정안함</label>
                </div>
            </td>
        </tr>
        <tr>
            <th scope="row" rowspan="2">기본할인</th>
            <td>
                <div class="input-group mb-3 mt-2 fs-5">
                    <input type="text" class="form-control col-3" aria-label="Amount (to the nearest dollar)" placeholder="할인율" id="product_per">
                    <span class="input-group-text">%</span>
                </div>
                <div class="form-check">
                    <input class="form-check-input chk-dark" type="checkbox" value="" id="flexCheckChecked" checked="">
                        <label class="form-check-label" for="flexCheckChecked">
                            특정기간만 할인
                        </label>
                    </input>
                </div>
            </td>
        </tr>
        <tr>
            <td>
                <div class="calendar d-flex align-items-center">
                    <div class="input col-4">
                        <input type="text" name="start_date" id="dc_start_date" readonly="readonly"
                               class="inp datepicker hasDatepicker">
                    </div>
                    <span class="m mx-2">~</span>
                    <div class="input col-4">
                        <input type="text" name="end_date" id="dc_end_date" readonly="readonly"
                               class="inp datepicker hasDatepicker">
                    </div>
                </div>

            </td>
        </tr>
        <tr>
            <th scope="row">판매기간</th>
            <td>
                <div class="btn-group" role="group" aria-label="Basic radio toggle button group">
                    <input type="radio" class="btn-check" name="sale_date" id="sale_date" autocomplete="off" checked="">
                    <label class="btn btn-outline-dark" for="sale_date">설정함</label>
                    <input type="radio" class="btn-check" name="sale_date" id="no_sale_date" autocomplete="off" checked="">
                    <label class="btn btn-outline-dark" for="no_sale_date">설정안함</label>
                </div>

            </td>
        </tr>
        <tr>
            <th scope="row del">기간설정</th>
            <td class="d-flex align-items-end">
                <div class="date_range_container btn-group">
                    <button data-interval="3" class="btn btn-outline-dark date_range active">3일</button>
                    <button data-interval="5" class="btn btn-outline-dark date_range">5일</button>
                    <button data-interval="7" class="btn btn-outline-dark date_range">7일</button>
                    <button data-interval="15" class="btn btn-outline-dark date_range">15일</button>
                    <button data-interval="30" class="btn btn-outline-dark date_range">30일</button>
                    <button data-interval="90" class="btn btn-outline-dark date_range">90일</button>
                    <button data-interval="120" class="btn btn-outline-dark date_range">120일</button>
                </div>
                <div class="calendar d-flex align-items-center">
                    <div class="input col-4">
                        <input type="text" name="start_date" id="sale_start_date" readonly="readonly"
                               class="inp datepicker hasDatepicker">
                    </div>
                    <span class="m mx-2">~</span>
                    <div class="input col-4">
                        <input type="text" name="end_date" id="sale_end_date" readonly="readonly"
                               class="inp datepicker hasDatepicker">
                    </div>
                </div>
            </td>


        </tr>
        <tr>
            <th scope="row">재고수량</th>
            <td>
                <div class="input-group">
                    <input type="text" class="form-control " aria-label="qty" placeholder="숫자만 입력" id="inv_qty">
                    <span class="input-group-text">개</span>
                </div>
            </td>
        </tr>
    <%-- 옵션--%>
        <tr>
            <th scope="row">옵션입력</th>
            <td>
                <div>
                    <label for="" class="col-sm-2 col-form-label">옵션명</label>
                    <label for="" class="col-sm-2 col-form-label">옵션가</label>

                    <label for="color" class="col-sm-2 col-form-label">컬러</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control col-3" aria-label="qty" placeholder="컬러 입력" id="color">
                    </div>
                    <label for="color" class="col-sm-2 col-form-label">사이즈</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control col-3" aria-label="qty" placeholder="컬러 입력" id="사이즈">
                    </div>
                </div>

            </td>

        </tr>
<%--                <div class="d-flex align-items-end">--%>
<%--                    <div class="me-2">--%>
<%--                        <label class="col-form-label mt-4">옵션명</label>--%>
<%--                        <input type="text" class="form-control" name="opt_nm" placeholder="예시 : 컬러">--%>
<%--                    </div>--%>

<%--                    <div class="me-2">--%>
<%--                        <label class="col-form-label mt-4">옵션값</label>--%>
<%--                        <input type="text" class="form-control" name="opt_val" placeholder="예시 : 빨강, 노랑 (,로 구분)">--%>
<%--                    </div>--%>

<%--                    <button type="button" class="btn btn-dark me-2">--%>
<%--                        <i class="fas fa-plus"></i>--%>
<%--                    </button>--%>
<%--                    --%>
<%--                </div>--%>
<%--                <div class="d-flex align-items-end mt-2">--%>
<%--                    <div class="me-2">--%>
<%--                        <input type="text" class="form-control" placeholder="예시 : 컬러">--%>
<%--                    </div>--%>
<%--                    <div class="me-2">--%>
<%--                        <input type="text" class="form-control" placeholder="예시 : 빨강, 노랑 (,로 구분)">--%>

<%--                    </div>--%>
<%--                    <button type="button" class="btn btn-dark">--%>
<%--                        <i class="fas fa-times"></i>--%>
<%--                    </button>--%>
<%--                </div>--%>


        <tr>
            <th scope="row">옵션목록</th>
            <td>
                <div class="datatable-wrapper datatable-loading no-footer sortable searchable fixed-columns">

                    <div class="datatable-top row align-items-center justify-content-center">
                        <div class="col-2">
                            <button type="button" class="btn btn-outline-dark">선택삭제</button>
                        </div>
                        <div class="col-4 d-flex align-items-center justify-content-center">
                            <span class="m-2">옵션값</span>
                            <input type="text" class="form-control col-9" placeholder="예시 : 빨강, 노랑 (,로 구분)" id="opt">
                        </div>
                        <div class="col-4 d-flex align-items-center justify-content-center">
                            <span class="m-2">재료수량</span>
                            <input type="text" class="form-control col-9" placeholder="예시 : 빨강, 노랑 (,로 구분)" id="opt_qty">
                        </div>
                        <div class="col-2 d-flex align-items-center justify-content-center">
                            <span class="m-2">사용여부</span>
                            <select class="form-select col-4" id="opt_YN">
                                <option>Y</option>
                                <option>N</option>
                            </select>
                        </div>
                    </div>





                    <div class="datatable-container">
                        <table id="opt_table" class="datatable-table" style="height: 300px; overflow: auto;">
                            <thead>
                                <tr>
                                    <th class="" rowspan="2"><input type="checkbox"></th>
                                    <th data-sortable="true" colspan="2">옵션명</th>
                                    <th data-sortable="true" rowspan="2"><a href="#" class="datatable-sorter">옵션가</a></th>
                                    <th data-sortable="true" rowspan="2"><a href="#" class="datatable-sorter">재고수량</a></th>
                                    <th data-sortable="true" rowspan="2"><a href="#" class="datatable-sorter">판매상태</a></th>
                                    <th data-sortable="true" rowspan="2"><a href="#" class="datatable-sorter">사용여부</a></th>
                                    <th data-sortable="true" rowspan="2">삭제</th>
                                </tr>
                                <tr>
                                    <td></td>
                                    <td></td>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td><input type="checkbox"></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td>Y</td>
                                    <td>
                                        <button type="button" class="btn btn-outline-dark">
                                            <i class="fas fa-times"></i>
                                        </button>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </td>
        </tr>
<%-- 이미지--%>
        <tr>
            <th >대표이미지</th>
            <td>
                <input class="form-control" type="file" id="refImg">
                <p class="text-dark small p-2">권장 크기 : 1000 x 1000 (윈도대상 750 x 1000)</p>
            </td>
        </tr>
        <tr>
            <th scope="row">추가이미지</th>
            <td>
                <input class="form-control " type="file" id="smlimg">
                <p class="text-dark small p-2">권장 크기 : 1000 x 1000 (윈도대상 750 x 1000)
                추가이미지는 최대 9개까지 설정할 수 있습니다.
                jpg,jpeg,gif,png,bmp 형식의 정지 이미지만 등록됩니다.</p>
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
            <td><input type="text" class="form-control" placeholder="모델명 60자" id="product_model"></td>

        </tr>
        <tr>
            <th scope="row">제품소재</th>
            <td><input type="text" class="form-control" placeholder="모델명 60자" id="product_model"></td>

        </tr>
        <tr>
            <th scope="row">브랜드</th>
            <td>
                <select class="form-select" id="brand">
                    <option>1</option>
                </select>
            </td>
        </tr>
        <tr>
            <th scope="row">제조사</th>
            <td>
                <select class="form-select" id="mftco">
                    <option>1</option>
                </select>
            </td>
        </tr>

        <tr>
            <th scope="row">제조국</th>
            <td>
                <select class="form-select" id="mft_natn">
                    <option>1</option>
                </select>
            </td>
        </tr>
        <tr>
            <th scope="row">출시일</th>
            <td>
                <div class="input col-4">
                    <input type="text" name="rles_dt" id="" readonly="readonly" class="inp datepicker hasDatepicker">
                </div>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <div class="d-flex align-items-center justify-content-center">
                    <button type="button" class="btn btn-outline-dark m-2">취소하기</button>
                    <button type="button" class="btn btn-dark m-2">저장하기</button>
                </div>

            </td>
        </tr>
    </table>



</div>




