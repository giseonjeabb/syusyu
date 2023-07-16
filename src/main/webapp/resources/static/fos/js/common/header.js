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
$(function () {
    $.ajax({
        url: '/categories',
        type: 'GET',
        dataType: 'json',
        success: function (data) {
        },
        error: function (request, status, error) {
            console.error("AJAX GET request failed. " + error);
        }
    });

});


/**
 *
 * 펼침메뉴에서 중분류 카테고리에 마우스를 올리면 소분류 카테고리 펼침메뉴가 나옵니다.
 *
 * @return 카테고리 중분류, 소분류 카테고리
 * @author soso
 * @since 2023/07/06
 */
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
