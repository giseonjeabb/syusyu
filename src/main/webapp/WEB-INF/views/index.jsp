<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<head>
    <script src="<c:url value="${jsUrlFos}/index.js"/>"></script>
    <link rel="stylesheet" href="https://unpkg.com/swiper/swiper-bundle.min.css">

    <!-- Swiper JS -->
    <script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>
    <style>
        .swiper-button-next, .swiper-button-prev {
            color: white; /* 버튼의 색상을 흰색으로 설정 */
        }
        .swiper-button-next svg, .swiper-button-prev svg {
            fill: white; /* SVG의 색상을 흰색으로 설정 */
        }
        .swiper-slide img {
            width: 100%;   /* 이미지 너비를 슬라이드 너비에 맞게 조절 */
            height: auto;
            object-fit: cover;  /* 이미지의 비율을 유지하면서 슬라이드에 맞게 조절 */
        }
        .swiper-pagination-bullet {
            background-color: #fff; /* 흰색으로 변경 */
        }
        .swiper-button-next, .swiper-button-prev {
            top: 50%; /* 버튼을 슬라이더의 중앙으로 이동 */
            transform: translateY(-50%); /* 버튼의 중앙이 슬라이더의 중앙과 정렬되도록 조정 */
        }

    </style>
</head>
<div class="swiper-container">
    <div class="swiper-wrapper">
        <div class="swiper-slide"><img src="<c:url value="${imgUrl}/banner/promoBannerNike.jpg"/>" alt="Banner 1"></div>
        <div class="swiper-slide"><img src="<c:url value="${imgUrl}/banner/promoBannerConverse.jpg"/>" alt="Banner 1"></div>
        <div class="swiper-slide"><img src="<c:url value="${imgUrl}/banner/promoBannerAdidas.jpg"/>" alt="Banner 1"></div>
        <div class="swiper-slide"><img src="<c:url value="${imgUrl}/banner/banner1.png"/>" alt="Banner 1"></div>
        <div class="swiper-slide"><img src="<c:url value="${imgUrl}/banner/banner2.png"/>" alt="Banner 1"></div>
        <div class="swiper-slide"><img src="<c:url value="${imgUrl}/banner/banner3.png"/>" alt="Banner 1"></div>

    </div>
    <!-- 필요한 경우 네비게이션 버튼 추가 -->
    <div class="swiper-button-next"></div>
    <div class="swiper-button-prev"></div>
    <!-- 점(dot) 네비게이션 -->
    <div class="swiper-pagination"></div>
</div>
