<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<head>
    <script src="<c:url value="${jsUrlBos}/product/productRegister.js"/>"></script>
    <script src="/static/bos/smarteditor/js/service/HuskyEZCreator.js" charset="utf-8"></script>
</head>


<div class="container-fluid px-4">
    <h1 class="mt-4">상품 등록</h1>



    <table class="table">
        <tr>
            <th class="col-1" scope="row">카테고리</th>
            <td class="col-11">
                <div class="col">
                    <div class="form-group row mt-6">
                        <div class="col">
                            <div class="form-group">  <%-- 선택하면 <strong></strong>추가 --%>
                                <select multiple="" class="form-select h-100" id="cate_large">
                                    <option>신발</option>
                                </select>
                            </div>
                        </div>
                        <div class="col">
                            <div class="form-group">
                                <select multiple="" class="form-select h-100" id="cate_middle">
                                    <option>운동화</option>
                                    <option>샌들/슬리퍼</option>
                                    <option>부츠</option>
                                    <option>구두</option>
                                </select>
                            </div>
                        </div>
                        <div class="col">
                            <div class="form-group">
                                <select multiple="" class="form-select h-100" id="cate_small">
                                    <option>스니커즈</option>
                                    <option>캔버스화</option>
                                    <option>조거</option>
                                    <option>아웃도어</option>
                                    <option>런닝화</option>
                                    <option>슬립온</option>
                                    <option>뮬</option>
                                </select>
                            </div>
                        </div>
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
                <div class="input-group mb-3 mt-2 fs-5">
                    <input type="text" class="form-control col-3" aria-label="qty" placeholder="숫자만 입력" id="inv_qty">
                    <span class="input-group-text">개</span>
                </div>
            </td>
        </tr>
    <%-- 옵션--%>
        <tr>
            <th scope="row">옵션입력</th>
            <td>
                <div class="d-flex align-items-end">
                    <div class="me-2">
                        <label class="col-form-label mt-4">옵션명</label>
                        <input type="text" class="form-control" name="opt_nm" placeholder="예시 : 컬러">
                    </div>

                    <div class="me-2">
                        <label class="col-form-label mt-4">옵션값</label>
                        <input type="text" class="form-control" name="opt_val" placeholder="예시 : 빨강, 노랑 (,로 구분)">
                    </div>

                    <button type="button" class="btn btn-dark me-2">
                        <i class="fas fa-plus"></i>
                    </button>


                </div>
                <div class="d-flex align-items-end mt-2">
                    <div class="me-2">
                        <input type="text" class="form-control" placeholder="예시 : 컬러">
                    </div>
                    <div class="me-2">
                        <input type="text" class="form-control" placeholder="예시 : 빨강, 노랑 (,로 구분)">

                    </div>
                    <button type="button" class="btn btn-dark">
                        <i class="fas fa-times"></i>
                    </button>
                </div>
                <button type="button" class="btn btn-dark disabled mt-2">옵션목록으로 적용 ↓</button>

            </td>

        </tr>
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

                    <textarea id="smarteditor" name="smarteditor"></textarea>

            </td>
        </tr>
        <tr>
            <th scope="row">모델명</th>
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






