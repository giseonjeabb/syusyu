document.addEventListener("DOMContentLoaded", function () {
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
        success: function (data) {
            // 각 상품 목록에 따라 해당 섹션에 상품 추가
            renderProductsToSection(data.popularProductList, 'popularProductSection');
            renderProductsToSection(data.pickProductList, 'pickProductSection');
            renderProductsToSection(data.newProductList, 'newProductSection');
        },
        error: function (err) {
            console.error('Error fetching data', err);
        }
    });

    /**
     * 'Top' 버튼의 스크롤 기능.
     *
     * @description
     * - 스크롤 위치가 100px 이상일 때: 'Top' 버튼 표시
     * - 스크롤 위치가 100px 미만일 때: 'Top' 버튼 숨김
     * - 'Top' 버튼 클릭 시: 페이지 최상단으로 부드럽게 스크롤
     *
     * @author soso
     * @since 2023/08/04
     */
    scrollToTop();

});


/// 상품들을 지정된 섹션에 렌더링하는 함수
function renderProductsToSection(products, sectionId) {
    const container = document.querySelector(`#${sectionId} .productContainer`);

    products.forEach(function (product) {
        let priceContent;

        if (product.dcPer > 0) {
            priceContent = `<span class="per">${product.dcPer}%</span>${formatPrice(product.dcPrc)}<span class="won"></span><del>${formatPrice(product.salePrc)} 원</del>`;
        } else {
            priceContent = `${formatPrice(product.salePrc)}<span class="won"></span>`;
        }

        const productHTML = `
            <div class="prd-item">
                <div class="thumbs hover">
                    <a href="/fos/products/product/${product.prodId}" target="_self" pno="${product.prodId}">
                        <img src="${product.repImg}" alt="${product.prodNm}">
                    </a>
                </div>
                <div class="desc">
                    <a href="/fos/products/product/${product.prodId}" target="_self" pno="${product.prodId}">
                        <p class="name line-clamp-2">${product.prodNm}</p>
                        <div class="price">
                            <p class="amount">${priceContent}</p>
                        </div>
                        <div class="grade">
                            <strong style="width:${product.avgStarRating === 0 ? 3 : (product.avgStarRating * 100) / 5}%">${product.avgStarRating}</strong>
                            <span>(${product.revwCnt})</span>
                        </div>
                    </a>
                    <div class="prd-item-btn">
                        <button type="button" class="btn icon alarm add-alarm-bt" pno="${product.prodId}">
                            <span class="text">장바구니 담기</span>
                        </button>
                    </div>
                </div>
            </div>
        `;

        container.innerHTML += productHTML;
    });
}

