<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
    <div class="sb-sidenav-menu">
        <div class="nav">
            <div class="sb-sidenav-menu-heading">
                <%-- select box--%>
                <div class="form-group">

                    <select class="form-select" id="exampleSelect1">
                        <option>Recipient name</option>
                        <option>수취인명</option>
                        <option>구매자명</option>
                        <option>구매자연락처</option>
                        <option>구매자ID</option>
                        <option>주문번호</option>
                        <option>주문번호</option>
                        <option>상품주문번호</option>
                        <option>상품번호</option>
                    </select>
                </div>
                <br>
                <!-- Navbar Search-->
                <form class="d-none d-md-inline-block form-inline ms-auto me-0 me-md-3 my-2 my-md-0">
                    <div class="input-group">
                        <input class="form-control" type="text" placeholder="Search for..." aria-label="Search for..." aria-describedby="btnNavbarSearch" />
                        <button class="btn btn-primary" id="btnNavbarSearch" type="button"><i class="fas fa-search"></i></button>
                    </div>
                </form>
            </div>

            <%-- Asidevar --%>
            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseProduct" aria-expanded="false" aria-controls="collapseProduct">
                상품관리
                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
            </a>
            <div class="collapse" id="collapseProduct" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                <nav class="sb-sidenav-menu-nested nav">
                    <a class="nav-link" href="#">상품 조회 / 수정</a>
                    <a class="nav-link" href="<c:url value='/admin/productRegister'/>">상품 등록</a>
                    <a class="nav-link" href="#">상품 일괄 등록</a>
                    <a class="nav-link" href="#">배송정보관리</a>
                </nav>
            </div>

            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseSales" aria-expanded="false" aria-controls="collapseSales">
                판매 관리
                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
            </a>
            <div class="collapse" id="collapseSales" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                <nav class="sb-sidenav-menu-nested nav">
                    <a class="nav-link" href="/bos/orders/view">주문 통합 검색</a>
                    <a class="nav-link" href="#">발주(주문)확인/발송관리 </a>
                    <a class="nav-link" href="#">배송 현황 관리</a>
                    <a class="nav-link" href="#">구매 확정 내역</a>
                    <a class="nav-link" href="#">취소 관리</a>
                    <a class="nav-link" href="#">반품 관리</a>
                    <a class="nav-link" href="#">교환 관리</a>
                    <a class="nav-link" href="#">판매 방해 고객관리</a>
                </nav>
            </div>

            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseCalculate" aria-expanded="false" aria-controls="collapseCalculate">
                정산 관리
                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
            </a>
            <div class="collapse" id="collapseCalculate" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                <nav class="sb-sidenav-menu-nested nav">
                    <a class="nav-link" href="#">정산 내역(일별/건별)</a>
                    <a class="nav-link" href="#">항목별 정산 내역</a>
                </nav>
            </div>

            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseCS" aria-expanded="false" aria-controls="collapseCS">
                공지사항/문의/FAQ관리
                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
            </a>
            <div class="collapse" id="collapseCS" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                <nav class="sb-sidenav-menu-nested nav">
                    <a class="nav-link" href="<c:url value='/adminNotice/list'/>"> 공지사항 관리</a>
                    <a class="nav-link" href="">문의사항 관리</a>
                    <a class="nav-link" href="<c:url value ='/bos/faqList'/>"> FAQ 관리</a>
                </nav>
            </div>

            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseDisplay" aria-expanded="false" aria-controls="collapseDisplay">
                전시관리
                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
            </a>
            <div class="collapse" id="collapseDisplay" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                <nav class="sb-sidenav-menu-nested nav">
                    <a class="nav-link" href="#">카테고리 관리</a>
                    <a class="nav-link" href="#">메인 진열 관리</a>
                    <a class="nav-link" href="#">메인 진열 상품 관리</a>
                    <a class="nav-link" href="#">슬라이드 배너 관리</a>
                </nav>
            </div>

            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseCB" aria-expanded="false" aria-controls="collapseCB">
                고객혜택관리
                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
            </a>
            <div class="collapse" id="collapseCB" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                <nav class="sb-sidenav-menu-nested nav">
                    <a class="nav-link" href="#">쿠폰 등록</a>
                    <a class="nav-link" href="#">혜택 조회/수정</a>
                    <a class="nav-link" href="#">고객등급 관리-</a>
                    <a class="nav-link" href="#">포인트지급내역조회-</a>
                </nav>
            </div>

            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseSellerInfo" aria-expanded="false" aria-controls="collapseSellerInfo">
                판매자정보
                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
            </a>
            <div class="collapse" id="collapseSellerInfo" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                <nav class="sb-sidenav-menu-nested nav">
                    <a class="nav-link" href="#">판매자정보</a>
                    <a class="nav-link" href="#">매니저관리</a>
                </nav>
            </div>
        </div>
    </div>
</nav>
