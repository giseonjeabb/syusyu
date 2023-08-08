document.addEventListener("DOMContentLoaded", function() {
    const swiper = new Swiper('.swiper', {
        loop: true,
        slidesPerView: 1,  // 한 번에 보여줄 슬라이드 수
        spaceBetween: 30,  // 슬라이드 사이의 간격
        centeredSlides: true,
        autoplay: {
            delay: 4000,
            disableOnInteraction: false,
        },
        pagination: {
            el: '.swiper-pagination',
            clickable: true,
        },
        navigation: {
            nextEl: '.swiper-button-next',
            prevEl: '.swiper-button-prev',
        },
        keyboard: {
            enabled: true,
        },
    });

    let currentPage = window.location.pathname;

    if (currentPage === '/') {
        let mainElement = document.querySelector('main');
        mainElement.style.padding = '0 0 130px 0';
    }


    $.ajax({
        url: '/fos/categoryProduct',
        type: 'GET',
        dataType: 'json',
        success: function(data) {
            // 각 상품 목록에 따라 해당 섹션에 상품 추가
            renderProductsToSection(data.popularProductList, 'popularProductSection');
            renderProductsToSection(data.pickProductList, 'pickProductSection');
            renderProductsToSection(data.newProductList, 'newProductSection');
        },
        error: function(err) {
            console.error('Error fetching data', err);
        }
    });

});


/// 상품들을 지정된 섹션에 렌더링하는 함수
function renderProductsToSection(products, sectionId) {
    // 템플릿 가져오기
    const template = document.getElementById('product-template').textContent;

    // 상품들이 추가될 container 요소를 찾기
    const container = document.querySelector(`#${sectionId} .productContainer`);

    // 각 상품에 대한 처리
    products.forEach(function(product) {
        const productHTML = template.replace(/{{prodId}}/g, product.prodId)
            .replace('{{repImg}}', product.repImg)
            .replace(/{{prodNm}}/g, product.prodNm||'')
            .replace(/{{dcPer}}/g, product.dcPer)
            .replace(/{{dcPrc}}/g, product.dcPrc)
            .replace(/{{salePrc}}/g, product.salePrc)
            .replace(/{{avgStarRating}}/g, product.avgStarRating)
            .replace(/{{avgStarRatingPer}}/g, (product.avgStarRating * 100) / 5) // 별점을 백분율로 계산
            .replace(/{{revwCnt}}/g, product.revwCnt); // 별점을 백분율로 계산

        // 상품 HTML을 container에 추가하기
        container.innerHTML += productHTML;
    });
}

