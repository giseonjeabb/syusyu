document.addEventListener("DOMContentLoaded", function () {
    var banners = Array.from(document.getElementsByClassName('banner-container'));
    var currentIndex = 0;
    var dotContainer = document.querySelector('.dot-container');

    function showBanner(index) {
        banners.forEach((banner, i) => {
            banner.style.display = i === index ? 'block' : 'none';
        });
        updateDots(index);
    }

    function updateDots(index) {
        var dots = Array.from(document.getElementsByClassName('dot'));
        dots.forEach((dot, i) => {
            dot.className = i === index ? 'dot active' : 'dot';
        });
    }

    banners.forEach((_, i) => {
        var dot = document.createElement('div');
        dot.className = 'dot';
        dot.addEventListener('click', () => {
            currentIndex = i;
            showBanner(currentIndex);
        });
        dotContainer.appendChild(dot);
    });

    document.querySelector('.btn-prev').addEventListener('click', () => {
        currentIndex = (currentIndex - 1 + banners.length) % banners.length;
        showBanner(currentIndex);
    });

    document.querySelector('.btn-next').addEventListener('click', () => {
        currentIndex = (currentIndex + 1) % banners.length;
        showBanner(currentIndex);
    });

    showBanner(currentIndex);

});


