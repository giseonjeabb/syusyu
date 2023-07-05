<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<<<<<<< HEAD
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<head>
    <script src="<c:url value="${jsUrlBos}/product/productRegister.js"/>"></script>
</head>
=======
>>>>>>> soso

<div class="container-fluid px-4">
    <h1 class="mt-4">상품 등록</h1>
    <br>
    <ol class="breadcrumb mb-4">
<<<<<<< HEAD
        <li class="breadcrumb-item">카테고리</li>
    </ol>
    <div class="col">

        <button type="button" class="btn btn-outline-dark" id="cate_search_button">카테고리 검색</button>
        <div class="input-group mb-3" id="cate_search">
=======
        <li class="breadcrumb-item active">카테고리</li>
    </ol>
    <div class="col">

        <button type="button" class="btn btn-outline-dark active">카테고리 검색</button>
        <div class="input-group mb-3">
>>>>>>> soso
            <input type="text" class="form-control" placeholder="Recipient's username" aria-label="Recipient's username" aria-describedby="button-addon2">
            <button class="btn btn-primary" type="button" id="button-addon2"><i class="fa-solid fa-magnifying-glass"></i></button>
        </div>

<<<<<<< HEAD
        <button type="button" class="btn btn-outline-dark" id="cate_choice_button">카테고리명 선택</button>
        <div class="form-group row">
            <div class="col">
                <div class="form-group">
                    <select multiple="" class="form-select" id="exampleSelect1">
                        <option>신발</option>
                    </select>
                </div>
            </div>
            <div class="col">
                <div class="form-group">
                    <select multiple="" class="form-select" id="exampleSelect2">
                        <option>운동화</option>
                        <option>샌들/슬리퍼</option>
                        <option>부츠</option>
                        <option>구두</option>
                    </select>
                </div>
            </div>
            <div class="col">
                <div class="form-group">
                    <select multiple="" class="form-select" id="exampleSelect3">
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
        <div class="form-group">
            <label class="col-form-label mt-4" for="product_name">상품명</label>
            <input type="text" class="form-control" placeholder="상품명 60자" id="product_name">
        </div>
        <div class="form-group">
            <label class="col-form-label mt-4" for="product_price">판매가</label>
            <input type="text" class="form-control" placeholder="상품명 60자" id="product_price">
        </div>


=======
        <button type="button" class="btn btn-outline-dark">카테고리명 선택</button>
        <div class="form-group row hidden">
            <div class="col">
                <textarea class="form-control" id="exampleTextareaLarge" rows="3"></textarea>
            </div>
            <div class="col">
                <textarea class="form-control" id="exampleTextareaMiddle" rows="3"></textarea>
            </div>
            <div class="col">
                <textarea class="form-control" id="exampleTextareaSmall" rows="3"></textarea>
            </div>
        </div>
>>>>>>> soso

    </div>
</div>

