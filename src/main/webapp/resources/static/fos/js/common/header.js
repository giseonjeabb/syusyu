/**
 * 이 메소드는 모든 카테고리를 가져와서 세션에 저장하는 기능을 수행합니다.
 * HTTP GET 요청을 통해 호출되며, 반환 값은 모든 카테고리의 정보와 HTTP 상태 코드입니다.
 *
 * @param request HttpServletRequest 객체. 세션을 얻기 위해 사용됩니다.
 * @return categories가 null이면 HTTP 상태 코드 204(NO CONTENT)와 함께 null 반환, 그렇지 않으면 categories 객체와 HTTP 상태 코드 200(OK)를 ResponseEntity 객체로 반환.
 * @throws Exception 카테고리 서비스에서 카테고리 목록을 가져오는 도중 발생할 수 있는 예외
 * @author soso
 * @since 2023/07/06
 */
$(function() {
    $.ajax({
        url: '/fos/categories',
        type: 'GET',
        dataType: 'json'
    }).done(function(data) {
        // Code that depends on the result of the AJAX request goes here
        // 예: 카테고리를 기반으로 HTML 요소를 동적으로 생성하는 코드

        const $mainCategoryItems = document.querySelectorAll('.mainCategory');

        // 모든 하위 메뉴를 숨깁니다.
        function hideSubCategoryItems() {
            document.querySelectorAll('.depth2').forEach(subCategoryItem => {
                subCategoryItem.style.display = 'none';
            });
        }

        $mainCategoryItems.forEach(mainCategoryItem => {
            const $subCategoryItems = mainCategoryItem.parentNode.querySelector('.depth2');

            mainCategoryItem.addEventListener('mouseenter', function () {
                // 모든 하위 메뉴를 숨기고,
                hideSubCategoryItems();
                // 해당 메인 카테고리 항목의 하위 메뉴만 표시합니다.
                $subCategoryItems.style.display = 'block';
            });

            $subCategoryItems.addEventListener('mouseleave', function () {
                // 마우스가 하위 메뉴에서 벗어났을 때 하위 메뉴를 숨깁니다.
                $subCategoryItems.style.display = 'none';
            });
        });

    }).fail(function(request, status, error) {
        console.error("AJAX GET request failed. " + error);
    });
});

/**
 * 이 함수는 스크롤 이벤트 발생시 마다 실행되며,
 * 웹 페이지 상단으로부터의 스크롤 위치에 따라 header 요소에 'fix' 클래스를 추가하거나 제거하는 역할을 수행합니다.
 * 스크롤 위치가 페이지 상단으로부터 0보다 크다면 'fix' 클래스를 추가하고, 그렇지 않다면 'fix' 클래스를 제거합니다.
 *
 * @event window.onscroll
 * @author soso
 * @since 2023/07/20
 */
// 스크롤이 발생할 때마다 실행되는 함수를 설정합니다.
window.onscroll = function() {
    // header 요소를 선택합니다.
    const header = document.querySelector("header");

    // 페이지 상단으로부터의 스크롤 위치가 0보다 크면 'fix' 클래스를 추가하고,
    // 그렇지 않으면 'fix' 클래스를 제거합니다.
    if (window.pageYOffset > 0) {
        header.classList.add("fix");
    } else {
        header.classList.remove("fix");
    }
};