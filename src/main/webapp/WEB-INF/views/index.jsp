<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<head>
    <!-- swiper-->
    <style>
        @import url(https://unpkg.com/swiper/swiper-bundle.min.css);
        @import url(${cssUrlFos}/common/index.scss);
    </style>
    <script src="<c:url value="${jsUrlFos}/index.js"/>"></script>
</head>
<!-- Swiper Container -->
<div class="swiper mySwiper">
    <!-- Slides -->
    <div class="swiper-wrapper">
        <div class="swiper-slide"><img src="<c:url value='${imgUrl}/banner/promoBannerNike.jpg'/>" alt="Banner 1"></div>
        <div class="swiper-slide"><img src="<c:url value='${imgUrl}/banner/promoBanner2.jpeg'/>" alt="Banner 2"></div>
        <div class="swiper-slide"><img src="<c:url value='${imgUrl}/banner/promoBanner1.jpg'/>" alt="Banner 3"></div>
        <div class="swiper-slide"><img src="<c:url value='${imgUrl}/banner/promoBannerOofos.jpg'/>" alt="Banner 4"></div>
        <div class="swiper-slide"><img src="<c:url value='${imgUrl}/banner/promoBannerAdidas.jpg'/>" alt="Banner 5"></div>
        <div class="swiper-slide"><img src="<c:url value='${imgUrl}/banner/promoBannerConverse.jpg'/>" alt="Banner 6"></div>
        <div class="swiper-slide"><img src="<c:url value='${imgUrl}/banner/promoBannerOTZ.jpg'/>" alt="Banner 7"></div>
    </div>

    <!-- Pagination -->
    <div class="swiper-pagination"></div>

    <!-- Navigation buttons -->
    <div class="swiper-button-prev"></div>
    <div class="swiper-button-next"></div>
</div>






<!-- Swiper JS -->
<script src="https://cdn.jsdelivr.net/npm/swiper@10/swiper-bundle.min.js"></script>