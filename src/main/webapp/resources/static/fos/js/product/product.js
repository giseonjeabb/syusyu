
$(function() {



    // 1. fold-box 요소의 active 클래스를 토글 처리
    const foldBoxes = document.querySelectorAll('.fold-box');
    foldBoxes.forEach((box) => {
        box.addEventListener('click', () => {
            // 클릭된 박스에 active 클래스를 토글 처리
            box.classList.toggle('active');

            // 클릭되지 않은 다른 모든 박스에서 active 클래스를 제거
            foldBoxes.forEach((otherBox) => {
                if (otherBox !== box) {
                    otherBox.classList.remove('active');
                }
            });
        });
    });

    // 2. 드롭다운 요소 클릭 이벤트 연결
    $('.ui.selection.dropdown.option-select').on('click', function(e) {
        // 클릭된 드롭다운의 클래스를 토글 처리
        $(this).toggleClass('active visible');

        // 드롭다운의 메뉴의 클래스와 스타일을 토글 처리
        $(this).children('.menu').toggleClass('transition visible').attr('style', function(i, style){
            return style === 'display: block !important' ? '' : 'display: block !important';
        });

        // 이벤트 버블링 막기
        e.stopPropagation();
    });

    // 3. 드롭다운 아이템 클릭 이벤트 처리
    $('.ui.selection.dropdown.option-select .menu .item').on('click', function(e) {
        // 아이템이 클릭되면 드롭다운을 닫음
        let dropdown = $(this).closest('.ui.selection.dropdown.option-select');
        dropdown.removeClass('active visible');
        dropdown.children('.menu').removeClass('transition visible').attr('style', '');

        // 이벤트 버블링 막기
        e.stopPropagation();
    });

    // 4. 문서 클릭 이벤트 처리
    $(document).on('click', function() {
        // 문서 클릭 시 드롭다운과 메뉴의 클래스와 스타일을 초기화
        $('.ui.selection.dropdown.option-select').removeClass('active visible');
        $('.ui.selection.dropdown.option-select .menu').removeClass('transition visible').attr('style', '');
    });

    // 5. 드롭다운 아이템에 마우스 호버 이벤트 처리
    $('.ui.selection.dropdown.option-select .menu .item').hover(function() {
        // 마우스를 올리면 배경색을 변경
        $(this).css('background-color', '#f5f5f5');
    }, function() {
        // 마우스를 뗐을 때 배경색을 원래대로 돌림
        $(this).css('background-color', '');
    });

    $('.ui.selection.dropdown.option-select .menu .item').on('click', function(e) {

        // 클릭한 아이템의 텍스트(사이즈)
        let selectedSize = $(this).find('span').text();

        // 이미 선택된 옵션이 없을 경우에만 추가
        if ($('.option-selected-list .option-select-item:contains("' + selectedSize + '")').length === 0) {
            // 선택한 옵션 추가
            let newItem = $('.option-select-item').first().clone(true);
            newItem.find('.option-tit span').first().text(selectedSize); // 사이즈 설정

            // 가격 계산 및 설정
            let basePrice = parseFloat($('.flex.al-center').data('price')); // 기본 가격
            let additionalPrice = parseFloat($(this).data('optPrc')); // 추가 가격

            if (isNaN(additionalPrice)) {
                additionalPrice = 0;
            }

            let total = basePrice + additionalPrice;

            newItem.find('#display-price').text(total.toLocaleString()); // 가격 설정
            $('.option-selected-list').append(newItem); // 옵션 리스트에 추가

            // 총 가격을 <span id="display-price" data-name="price">에 표시
            $('#display-price').text(total.toLocaleString());
        }
    });

    // 옵션 삭제 이벤트
    $('.option-selected-list').on('click', '.remove_18', function() {
        $(this).closest('.option-select-item').remove();
    });

    // // 수량 증가 이벤트
    // $('.option-selected-list').on('click', '.btn.icon.plus', function() {
    //     let quantityInput = $(this).siblings('.item_qty_count');
    //     let quantity = parseInt(quantityInput.val());
    //     quantityInput.val(quantity + 1);
    //
    //     // 상품 가격 업데이트
    //     let item = $(this).closest('.option-select-item');
    //     let basePrice = parseFloat(item.find('input[name="copt"]').attr('price')); // 기본 가격
    //     let total = basePrice * (quantity + 1);
    //     item.find('span[data-name="price"]').text(total); // 가격 설정
    //
    //     // 총 금액 업데이트
    //     let totalPrice = 0;
    //     $('.option-selected-list .option-select-item').each(function() {
    //         totalPrice += parseFloat($(this).find('span[data-name="price"]').text());
    //     });
    //     $('.total-price strong[data-type="price"]').text(totalPrice); // 총 금액 설정
    // });
    //
    // // 수량 감소 이벤트
    // $('.option-selected-list').on('click', '.btn.icon.minus', function() {
    //     let quantityInput = $(this).siblings('.item_qty_count');
    //     let quantity = parseInt(quantityInput.val());
    //     if (quantity > 1) {
    //         quantityInput.val(quantity - 1);
    //
    //         // 상품 가격 업데이트
    //         let item = $(this).closest('.option-select-item');
    //         let basePrice = parseFloat(item.find('input[name="copt"]').attr('price')); // 기본 가격
    //         let total = basePrice * (quantity - 1);
    //         item.find('span[data-name="price"]').text(total); // 가격 설정
    //
    //         // 총 금액 업데이트
    //         let totalPrice = 0;
    //         $('.option-selected-list .option-select-item').each(function() {
    //             totalPrice += parseFloat($(this).find('span[data-name="price"]').text());
    //         });
    //         $('.total-price strong[data-type="price"]').text(totalPrice); // 총 금액 설정
    //     }
    // });


});
