<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page session="false" %>
<!-- swiper-->
<style>
    @import url(https://unpkg.com/swiper/swiper-bundle.min.css);
    @import url(${cssUrlFos}/common/index.css);

</style>
<script src="<c:url value="${jsUrlFos}/index.js"/>"></script>
<!-- Swiper Container -->
<div class="swiper mySwiper">
    <!-- Slides -->
    <div class="swiper-wrapper">
        <div class="swiper-slide">   <a href="http://localhost:8080/notice/read?page=1&pageSize=10&option=&keyword=&notcNo=443"><img src="<c:url value='${imgUrl}/banner/promoBannerNike.jpg'/>" alt="Banner 1"></a></div>
        <div class="swiper-slide"><img src="<c:url value='${imgUrl}/banner/promoBanner2.jpeg'/>" alt="Banner 2"></div>
        <div class="swiper-slide"><img src="<c:url value='${imgUrl}/banner/promoBanner1.jpg'/>" alt="Banner 3"></div>
        <div class="swiper-slide"><img src="<c:url value='${imgUrl}/banner/promoBannerOofos.jpg'/>" alt="Banner 4"></div>
        <div class="swiper-slide">   <a href="http://localhost:8080/notice/read?page=1&pageSize=10&option=&keyword=&notcNo=440"> <img src="<c:url value='${imgUrl}/banner/promoBannerAdidas.jpg'/>" alt="Banner 5"></div>
        <div class="swiper-slide"><img src="<c:url value='${imgUrl}/banner/promoBannerConverse.jpg'/>" alt="Banner 6"></a></div>
        <div class="swiper-slide"><img src="<c:url value='${imgUrl}/banner/promoBannerOTZ.jpg'/>" alt="Banner 7"></div>
    </div>

    <!-- Pagination -->
    <div class="swiper-pagination"></div>

    <!-- Navigation buttons -->
    <div class="swiper-button-prev"></div>
    <div class="swiper-button-next"></div>
</div>



<section id="popularProductSection">
    <div class="content-title">
        <div class="sub-content-head etc-ty2">
            <div class="inner">
                <h3 class="title-t ty3" id="titleText">RANKING</h3>
                <!-- view all -->
                <div class="r-side"><a href="#" class="btn btn-text-type btt2 underline">VIEW ALL</a></div>
            </div>
        </div>
    </div>

        <div class="inner-content">
            <div class="tab-wrap">
                <div class="prd-list-wrap">
                    <div class="prd-lists n5 productContainer">
                    </div>
                </div>
            </div>
        </div>


</section>
<section id="pickProductSection">
    <div class="content-title">
        <div class="sub-content-head etc-ty2">
            <div class="inner">
                <h3 class="title-t ty3">MD’S PICK</h3>
            </div>
        </div>
    </div>
    <div class="inner-content">
        <div class="tab-wrap">
            <div class="prd-list-wrap">
                <div class="prd-lists n5 productContainer">
                    <!-- 여기에 상품 목록이 들어갑니다. -->
                </div>
            </div>
        </div>
    </div>
</section>

<section id="newProductSection">
    <div class="content-title">
        <div class="sub-content-head etc-ty2">
            <div class="inner">
                <h3 class="title-t ty3">WHAT'S NEW</h3>
            </div>
        </div>
    </div>
    <div class="inner-content">
        <div class="tab-wrap">
            <div class="prd-list-wrap">
                <div class="prd-lists n5 productContainer">
                    <!-- 여기에 상품 목록이 들어갑니다. -->
                </div>
            </div>
        </div>
    </div>
</section>

<!-- top버튼 -->
<button id="btnTop" class="top-btn"><i class="fas fa-arrow-up"></i></button>

<!-- Swiper JS -->
<script src="https://cdn.jsdelivr.net/npm/swiper@10/swiper-bundle.min.js"></script>