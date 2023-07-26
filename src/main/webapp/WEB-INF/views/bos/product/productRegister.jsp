<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<head>
    <script src="<c:url value="${jsUrlBos}/product/productRegister.js"/>"></script>
</head>


<div class="container-fluid px-4">
    <h1 class="mt-4">상품 등록</h1>


    <ul>
        <li>
            <div class="col">
                <div class="form-group row mt-6">
                    <label class="col-form-label mt-4 fs-5" id="product_cate">카테고리</label>
                    <div class="col">
                        <div class="form-group">
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
        </li>
        <li>
            <label class="col-form-label mt-4 fs-5" for="product_name">상품명</label>
            <input type="text" class="form-control" placeholder="상품명 60자" id="product_name">
        </li>
        <li>
            <label class="col-form-label mt-4 fs-5" for="product_price">판매가</label>
            <input type="text" class="form-control" placeholder="판매가 60자" id="product_price">
        </li>
        <li>
            <label class="col-form-label mt-4 fs-5" for="product_per">할인</label><br>
            <button type="button" class="btn btn-dark">설정함</button>
            <button type="button" class="btn btn-dark">설정안함</button>
            <div class="input-group mb-3 mt-2 fs-5">
                <input type="text" class="form-control col-3" aria-label="Amount (to the nearest dollar)" placeholder="할인율" id="product_per">
                <span class="input-group-text">%</span>
                <div class="form-group">
                    <div class="form-check">
                        <input class="form-check-input" type="checkbox" value="" id="flexCheckChecked" checked="">
                        <label class="form-check-label" for="flexCheckChecked">
                            특정기간만 할인
                        </label>
                    </div>
                </div>
            </div>

        </li>


    </ul>














        </div>





        </div>
    </div>
</div>

