
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
                Product Management <%--   상품관리         --%>
                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
            </a>
            <div class="collapse" id="collapseProduct" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                <nav class="sb-sidenav-menu-nested nav">
                    <a class="nav-link" href="#">Product enquiry/modify</a><%--상품 조회/수정--%>
                    <a class="nav-link" href="#">Product register</a><%--상품 등록--%>
                    <a class="nav-link" href="#">Product collective registration</a><%--상품 일괄 등록--%>
                    <a class="nav-link" href="#">Delivery information management</a><%--배송정보관리--%>
                </nav>
            </div>

            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseSales" aria-expanded="false" aria-controls="collapseSales">
                Sales Management <%--   판매 관리         --%>
                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
            </a>
            <div class="collapse" id="collapseSales" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                <nav class="sb-sidenav-menu-nested nav">
                    <a class="nav-link" href="#">Order integrated search</a><%--주문 통합 검색--%>
                    <a class="nav-link" href="#">Order confirmation/dispatch management </a><%--발주(주문)확인/발송관리--%>
                    <a class="nav-link" href="#">Delivery status management</a><%--배송 현황 관리--%>
                    <a class="nav-link" href="#">Purchase confirmation list</a><%--구매 확정 내역--%>
                    <a class="nav-link" href="#">Cancel management</a><%--취소 관리--%>
                    <a class="nav-link" href="#">Take back management</a><%--반품 관리--%>
                    <a class="nav-link" href="#">exchange management</a><%--교환 관리--%>
                    <a class="nav-link" href="#">Sale disturbance customer management</a><%--판매 방해 고객관리--%>
                </nav>
            </div>

            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseCalculate" aria-expanded="false" aria-controls="collapseCalculate">
                Calculate Management <%--   정산 관리         --%>
                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
            </a>
            <div class="collapse" id="collapseCalculate" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                <nav class="sb-sidenav-menu-nested nav">
                    <a class="nav-link" href="#">Calculate list (daily/caseBy)</a><%--정산 내역(일별/건별)--%>
                    <a class="nav-link" href="#">Items calculate list </a><%--항목별 정산 내역--%>
                </nav>
            </div>

            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseCS" aria-expanded="false" aria-controls="collapseCS">
                CS(notice/enquiry/Review management)<%--공지사항/문의/리뷰관리 --%>
                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
            </a>
            <div class="collapse" id="collapseCS" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                <nav class="sb-sidenav-menu-nested nav">
                    <a class="nav-link" href="#">Notice management</a><%--공지사항--%>
                    <a class="nav-link" href="#">Enquiry management </a><%--문의관리--%>
                    <a class="nav-link" href="#">Review management </a><%--문의관리--%>
                </nav>
            </div>

            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseDisplay" aria-expanded="false" aria-controls="collapseDisplay">
                Display management<%--전시관리--%>
                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
            </a>
            <div class="collapse" id="collapseDisplay" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                <nav class="sb-sidenav-menu-nested nav">
                    <a class="nav-link" href="#">Categoryice management</a><%--카테고리 관리--%>
                    <a class="nav-link" href="#">Main display management </a><%--메인 진열 관리--%>
                    <a class="nav-link" href="#">Main display product management</a> <%--메인 진열 상품 관리--%>
                    <a class="nav-link" href="#">Slide Banner management</a> <%--슬라이드 배너 관리--%>
                </nav>
            </div>

            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseCB" aria-expanded="false" aria-controls="collapseCB">
                Customer benefit management<%--고객혜택관리--%>
                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
            </a>
            <div class="collapse" id="collapseCB" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                <nav class="sb-sidenav-menu-nested nav">
                    <a class="nav-link" href="#">coupon management</a><%--쿠폰 등록--%>
                    <a class="nav-link" href="#">coupon/enquiry/modify</a><%--혜택 조회/수정--%>
                    <a class="nav-link" href="#">Customer grade management</a> <%--고객등급 관리--%>
                    <a class="nav-link" href="#">Point payment list</a> <%--포인트지급내역조회--%>
                </nav>
            </div>

            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseSellerInfo" aria-expanded="false" aria-controls="collapseSellerInfo">
                Seller infomation<%--판매자정보--%>
                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
            </a>
            <div class="collapse" id="collapseSellerInfo" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                <nav class="sb-sidenav-menu-nested nav">
                    <a class="nav-link" href="#">Seller infomation</a><%--판매자정보--%>
                    <a class="nav-link" href="#">Manager management</a><%--매니저관리--%>
                </nav>
            </div>
        </div>
    </div>
</nav>
