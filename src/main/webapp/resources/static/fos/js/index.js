document.addEventListener("DOMContentLoaded", function () {
    const swiper = new Swiper('.swiper-container', {
        direction: 'horizontal',
        loop: true,

        // 네비게이션 버튼
        navigation: {
            nextEl: '.swiper-button-next',
            prevEl: '.swiper-button-prev',
        },

        // 점(dot) 네비게이션
        pagination: {
            el: '.swiper-pagination',
            clickable: true,
        },

        // 자동 슬라이드 옵션
        autoplay: {
            delay: 6000,  // 6초마다 슬라이드 자동 전환
            disableOnInteraction: false,  // 사용자의 슬라이드 조작 후에도 자동 슬라이드 계속 진행
        }
    });
});


