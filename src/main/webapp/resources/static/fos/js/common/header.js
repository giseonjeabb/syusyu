/**
 * 카테고리 메뉴에 관한 스크립트입니다.
 * - 중간 카테고리(`.middle-link`)에 마우스를 올리면 해당 중간 카테고리의 하위 카테고리 목록(`.category_list`)를 표시합니다.
 * - 사용자가 전체 카테고리 영역(`.category`) 밖으로 마우스를 이동하면 모든 하위 카테고리 목록을 숨깁니다.
 *
 * @author soso
 * @since 2023/07/06
 */
$(document).ready(function(){
    $('.category_list').hide();
    // middle 카테고리에 마우스를 올리면
    $('.middle-link').on('mouseenter', function(){
        // 모든 category_list를 숨깁니다.
        $('.category_list').hide();

        // 현재 middle 카테고리에 연결된 category_list만 보여줍니다.
        $(this).next('.category_list').show();
    });

    // 카테고리 전체에 마우스를 벗어나면
    $('.category').on('mouseleave', function(){
        // 모든 category_list를 숨깁니다.
        $('.category_list').hide();
    });

    //신발카테고리 추가
    $('.category_btn, #category_All_list').on('mouseover', function() {
        clearTimeout(timeout);  // 기존의 딜레이를 취소
        $('#category_All_list').show();
    });

    $('.category_btn, #category_All_list').on('mouseout', function() {
        // 딜레이 후 서브 메뉴 숨김 처리
        timeout = setTimeout(function() {
            $('#category_All_list').hide();
        }, 300);  // 300ms 딜레이
    });


    const mainCategoryLinks = $('.mainCategory');

    // 모든 서브 메뉴(.depth2)를 숨기는 함수
    function hideSubCategoryItems() {
        $('.depth2').hide();
    }

    mainCategoryLinks.each(function() {
        const subCategoryMenu = $(this).next('.depth2');

        $(this).on('mouseenter', function() {
            hideSubCategoryItems();  // 모든 서브 메뉴를 숨김
            subCategoryMenu.show();  // 해당 메인 카테고리 항목의 서브 메뉴만 표시
        });

        subCategoryMenu.on('mouseleave', function() {
            $(this).hide();  // 마우스가 서브 메뉴에서 벗어났을 때 해당 서브 메뉴를 숨김
        });
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