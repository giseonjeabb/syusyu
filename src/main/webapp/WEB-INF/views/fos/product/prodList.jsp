<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>syusyu</title>

    <style>
        @import url(${cssUrlFos}/common/reset.css);
        @import url(${cssUrlFos}/common/common.css);
        @import url(${cssUrlFos}/product/prodList.css);
    </style>

    <script src="${jsUrlFos}/product/prodList.js"></script>

</head>
<body>
<jsp:include page="../common/header.jsp"/>

<div class="container">
    <aside>
        <div class="aside_title">
            <h1>SHOES</h1>
        </div>
        <ul class="aside_menu">
            <li><a href="#" class="aside_menu_item">ALL</a></li>
            <li><a href="#" class="aside_menu_item">운동화</a>
                <ul class="aside_submenu">
                    <li><a href="#">스니커즈</a></li>
                    <li><a href="#">캔버스화</a></li>
                    <li><a href="#">조거</a></li>
                    <li><a href="#">슬립온</a></li>
                    <li><a href="#">뮬</a></li>
                    <li><a href="#">런닝화</a></li>
                    <li><a href="#">이읏도어</a></li>
                    <li><a href="#">안정화/작업화</a></li>
                </ul>
            </li>
            <li><a href="#" class="aside_menu_item">부츠</a>
                <ul class="aside_submenu">
                    <li><a href="#">레인부츠</a></li>
                    <li><a href="#">여성부츠</a></li>
                    <li><a href="#">레더부츠</a></li>
                    <li><a href="#">워크부츠</a></li>
                    <li><a href="#">겨울부츠</a></li>
                </ul>
            </li>
            <li><a href="#" class="aside_menu_item">구두</a>
                <ul class="aside_submenu">
                    <li><a href="#">로퍼</a></li>
                    <li><a href="#">레이스업</a></li>
                    <li><a href="#">힐/펌프스</a></li>
                    <li><a href="#">플랫슈즈</a></li>
                    <li><a href="#">모카신/데크슈즈</a></li>
                </ul>
            </li>
        </ul>
    </aside>
    <div id="content">
        <ul class="goods_list">
            <li><a href="#" onclick="product_desc('상품1')">
                <img src="product1.jpg" alt="상품 이미지">
                <div>
                    <span class="info_brand">브랜드명</span>
                    <span class="info_name">상품 이름</span>
                    <div class="info_price">
                        <span class="info_price_cost">109,000</span>
                        <span class="info_price_percent">76,300</span>
                        <span class="info_price_discount">30%</span>
                    </div>

                </div>
            </a>
                <button class="like_wish"><span>관심상품</span></button>
            </li>

        </ul>
    </div>


</div>


<jsp:include page="../common/footer.jsp"/>
</body>
</html>
