<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<head>
    <script src="<c:url value="${jsUrlFos}/index.js"/>"></script>
</head>
<div id="content">
    <div class="slide_banner">
        <div class="banner-container fade" style="background-color: #191919;">
            <img class="banner" src="<c:url value="${imgUrl}/banner/banner1.png"/>" alt="Banner Image 1">
        </div>
        <div class="banner-container fade" style="background-color: #fcf8e8; display: none;">
            <img class="banner" src="<c:url value="${imgUrl}/banner/banner2.png"/>" alt="Banner Image 2">
        </div>
        <div class="banner-container" style="background-color: #d4e4ed; display: none;">
            <img class="banner" src="<c:url value="${imgUrl}/banner/banner3.png"/>" alt="Banner Image 3">
        </div>
        <button class="btn btn-prev">❮</button>
        <button class="btn btn-next">❯</button>
        <div class="dot-container"></div>
    </div>
    <div id="main_dspy_mdPick">
        
    </div>
</div>