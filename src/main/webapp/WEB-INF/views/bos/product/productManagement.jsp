<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<head>
  <script type="text/javascript"src="<c:url value='${jsUrlBos}/product/productManagement.js'/>"></script>
  <script type="text/javascript" src="https://cdn.datatables.net/v/dt/jq-3.3.1/dt-1.10.21/datatables.min.js"></script>

  <style>
    @import url(https://cdn.datatables.net/v/dt/jq-3.3.1/dt-1.10.21/datatables.min.css);
  </style>
</head>
<div class="container-fluid px-4">
  <h1 class="mt-4">상품통합검색</h1>

  <div id="search_container" class="search_form">
    <table>
      <tr>
        <th>기간</th>
        <td colspan="3" style="position:relative;">
          <select id="date_type" class="form-select" style="width:115px;">
            <option value="REG_DTTM" selected="selected">등록일</option>
            <option value="SALE_ST_DTTM">판매시작일</option>
            <option value="SALE_ED_DTTM">판매종료일</option>
            <option value="DC_ST_DTTM">할인시작일</option>
            <option value="DC_ED_DTTM">할인종료일</option>
          </select>

          <div class="date_range_container">
            <button data-interval="0" class="btn btn-outline-dark date_range">오늘</button>
            <button data-interval="1" class="btn btn-outline-dark date_range">어제</button>
            <button data-interval="3" class="btn btn-outline-dark date_range">3일</button>
            <button data-interval="7" class="btn btn-outline-dark date_range">7일</button>
            <button data-interval="15" class="btn btn-outline-dark date_range">15일</button>
            <button data-interval="30" class="btn btn-outline-dark date_range">1개월</button>
            <button data-interval="90" class="btn btn-outline-dark date_range">3개월</button>
            <button data-interval="180" class="btn btn-outline-dark date_range active">6개월</button>
          </div>

          <div class="calendar">
            <div class="input w-208">
              <input type="text" name="start_date" id="start_date" readonly="readonly"
                     class="inp datepicker hasDatepicker">
            </div>
            <span class="m">~</span>
            <div class="input w-208">
              <input type="text" name="end_date" id="end_date" readonly="readonly"
                     class="inp datepicker hasDatepicker">
            </div>
          </div>
        </td>
      </tr>
      <tr>
        <th>검색어</th>
        <td>
          <select id="search_type" class="form-select" style="width:150px;">
            <option>-검색항목선택-</option>
            <option value="prodId">상품번호</option>
            <option value="prodNm">상품명</option>
            <option value="mftco">제조사명</option>
            <option value="modelNm">모델명</option>
            <option value="brndNm">브랜드명</option>
          </select>
          <input type="text" id="search_keyword" class="form-control" style="width: 500px">
        </td>
      </tr>
      <tr>
        <th>판매상태</th>
        <td colspan="3" id="productStatusCheckbox">
           <label><input type="checkbox" id="chk-all" name="chk" checked>전체</label>
          <label><input type="checkbox" name="chk" class="chk-point" value="601" checked>판매중</label>
          <label><input type="checkbox" name="chk" class="chk-point" value="602" checked>품절</label>
          <label><input type="checkbox" name="chk" class="chk-point" value="603" checked>판매대기</label>
          <label><input type="checkbox" name="chk" class="chk-point" value="604" checked>판매금지</label>
          <label><input type="checkbox" name="chk" class="chk-point" value="605" checked>판매종료</label>
        </td>
      </tr>
      <tr>
        <th>카테고리</th>
        <td class="d-flex">
          <select class="form-select" aria-label="Default select example" id="largeNo">
            <option selected>-대분류-</option>
            <c:forEach var="large" items="${categories.largeCategories}">
                <option name="largeNo" value="${large.key}">${large.value}</option>
            </c:forEach>
          </select>
          <select class="form-select" aria-label="Disabled select example" id="middleNo" disabled>
            <option selected>-중분류-</option>
            <c:forEach var="middle" items="${categories.middleCategories}">
              <option name="middleNo" value="${middle.key}">${middle.value}</option>
            </c:forEach>
          </select>
          <select class="form-select" aria-label="Disabled select example" id="smallNo" disabled>
            <option selected>-소분류-</option>
            <c:forEach var="small" items="${categories.smallCategories}">
                <c:forEach var="smallItem" items="${small.value}">
                    <option data-small-key="${small.key}" name="smallNo" value="${smallItem.key}">${smallItem.value}</option>
                </c:forEach>
            </c:forEach>
          </select>
        </td>
      </tr>
    </table>
    <div class="button_area">
      <button id="btn_search" class="btn btn-dark">검색</button>
      <button class="btn btn-light">초기화</button>
    </div>
  </div>

  <div class="grid-container">
    <table id="productTable" class="display nowrap dataTable">
      <thead>
      <tr>
        <th>체크박스</th>
        <th>수정</th>
        <th>삭제</th>
        <th>번호번호</th>
        <th>상품명</th>
        <th>상세설명</th>
        <th>판매상태</th>
        <th>판매상태명</th>
        <th>전시상태</th>
        <th>재고수량</th>
        <th>매입가</th>
        <th>판매가</th>
        <th>한인율</th>
        <th>할인가</th>
        <th>최대구매수량</th>
        <th>판매수량</th>
        <th>포인트</th>
        <th>총판매금액</th>
        <th>대분류번호</th>
        <th>대분류</th>
        <th>중분류번호</th>
        <th>중분류</th>
        <th>소분류번호</th>
        <th>소분류</th>
        <th>모델명</th>
        <th>브랜드아이디</th>
        <th>브랜드명</th>
        <th>제품소재</th>
        <th>제조사번호</th>
        <th>제조사</th>
        <th>제조국번호</th>
        <th>제조국</th>
        <th>좋아요</th>
        <th>상품등록일</th>
        <th>최종수정일</th>
        <th>상품판매시작일</th>
        <th>상품판매종료일</th>
        <th>상품할인시작일</th>
        <th>상품판매종료일</th>
      </tr>
      </thead>
      <tbody>

      </tbody>
    </table>
  </div>
</div>