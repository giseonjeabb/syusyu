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
        mousewheel: true,
        keyboard: {
            enabled: true,
        },
    });

    let currentPage = window.location.pathname;

    if (currentPage === '/') {
        let mainElement = document.querySelector('main');
        mainElement.style.padding = '0 0 130px 0';
    }
});


