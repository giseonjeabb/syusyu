$(function () {


    /**
     *  1. fold-box 요소의 active 클래스를 토글 처리
     * 이 함수는 '.fold-box' 요소의 클릭 이벤트를 처리합니다. 클릭된 요소에 'active' 클래스를 추가하고,
     * 클릭되지 않은 나머지 요소들의 'active' 클래스를 제거합니다.
     *
     * @param foldBoxes '.fold-box' 클래스를 가진 요소의 NodeList입니다. 이 값이 null 혹은 undefined일 경우, 작동하지 않습니다.
     * @return 별도의 반환값은 없으나, 클릭 이벤트가 발생할 때마다 'active' 클래스의 상태가 변경됩니다.
     * @throws Exception 요소 선택이나 이벤트 등록 과정에서 발생할 수 있는 예외를 처리합니다.
     * @author soso
     * @since 2023/07/19
     */
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

    /**
     * 2. 드롭다운 요소 클릭 이벤트 연결
     * 이 함수는 '.ui.selection.dropdown.option-select' 요소에 대한 클릭 이벤트를 처리합니다.
     * 클릭된 요소 및 그의 자식 요소들의 클래스와 스타일을 토글 처리하며, 이벤트의 버블링을 막습니다.
     *
     * @param e 클릭 이벤트 객체입니다. 클릭 이벤트의 상세 정보를 포함하고 있습니다.
     * @return 별도의 반환값은 없으나, 클릭 이벤트가 발생할 때마다 해당 요소의 클래스와 스타일 상태가 변경됩니다.
     * @throws Exception 요소 선택이나 이벤트 등록 과정에서 발생할 수 있는 예외를 처리합니다.
     * @author soso
     * @since 2023/07/19
     */
    $('.ui.selection.dropdown.option-select').on('click', function (e) {
        // 클릭된 드롭다운의 클래스를 토글 처리
        $(this).toggleClass('active visible');

        // 드롭다운의 메뉴의 클래스와 스타일을 토글 처리
        $(this).children('.menu').toggleClass('transition visible').attr('style', function (i, style) {
            return style === 'display: block !important' ? '' : 'display: block !important';
        });

        // 이벤트 버블링 막기
        e.stopPropagation();
    });


    /**
     * 3. 드롭다운 아이템에 마우스 호버 이벤트 처리
     * 이 함수는 '.ui.selection.dropdown.option-select .menu .item' 요소에 대한 마우스 호버 이벤트를 처리합니다.
     * 마우스를 올리면 배경색을 변경하고, 마우스를 뗐을 때 원래의 배경색으로 되돌립니다.
     *
     * @return 별도의 반환값은 없으나, 마우스 호버 이벤트가 발생할 때마다 해당 요소의 배경색이 변경됩니다.
     * @throws Exception 요소 선택이나 이벤트 등록 과정에서 발생할 수 있는 예외를 처리합니다.
     * @author soso
     * @since 2023/07/19
     */
    $('.ui.selection.dropdown.option-select .menu .item').hover(function () {
        // 마우스를 올리면 배경색을 변경
        $(this).css('background-color', '#f5f5f5');
    }, function () {
        // 마우스를 뗐을 때 배경색을 원래대로 돌림
        $(this).css('background-color', '');
    });


    /**
     * 4. 옵션 항목이 클릭될 때의 이벤트 핸들러
     * 옵션 항목이 클릭될 때 실행되는 이벤트 핸들러입니다.
     * 선택한 옵션의 정보를 가져와서 선택한 옵션 리스트에 존재하지 않는다면,
     * 해당 옵션에 대한 항목을 선택한 옵션 리스트에 추가합니다.
     * 추가된 옵션 항목에 대한 가격을 계산하고 화면에 표시합니다.
     * 그리고 전체 가격을 업데이트하고, 드롭다운 메뉴를 닫고, 선택한 옵션 리스트를 화면에 표시합니다.
     *
     * @param e 클릭 이벤트 객체입니다.
     * @return 선택한 옵션에 대한 항목을 선택한 옵션 리스트에 추가하고 화면에 표시합니다.
     * @throws Exception 옵션을 추가하고 가격을 업데이트하는 동안 발생할 수 있는 예외를 처리합니다.
     * @author soso
     * @since 2023/07/22
     */
    let itemIndex = 0;
    $('.ui.selection.dropdown.option-select .menu .item').off().on('click', function (e) {
        // 선택한 옵션의 텍스트를 가져옵니다.
        let selectedSize = $(this).find('span').text();
        // 선택한 옵션의 data-opt-comb-no 값을 가져옵니다.
        let selectedOptCombNo = $(this).data('optCombNo');


        // 클릭된 item의 .option-select-item 데이터들을 추가(장바구니에 넘겨줄 데이터들).
        let invQty = $('.ui.selection.dropdown.option-select .menu .item').data('invQty');
        let purchaseLimit = $('.ui.selection.dropdown.option-select .menu .item').data('purchaseLimit');
        let prodOptNo = $('.ui.selection.dropdown.option-select .menu .item').data('optCombNo');
        let prodNo = $("#prod_no").val();
        let prodCate = $("#prod_cate").val();
        let loginId = $("#login_id").val();

        // 선택한 사이즈가 이미 선택된 옵션 리스트에 존재하는지 확인합니다.
        if ($('.option-selected-list .option-select-item').filter(function () {
            return $(this).data('opt-comb-no') == selectedOptCombNo;
        }).length === 0) {
            // 상품의 기본 가격을 가져옵니다.
            let basePrice = parseFloat($('.flex.al-center').data('price'));
            // 선택한 옵션의 추가 가격을 가져옵니다.
            let additionalPrice = parseFloat($(this).data('optPrc'));

            if (isNaN(additionalPrice)) {
                additionalPrice = 0;
            }

            // 선택한 옵션에 대한 DOM 요소를 생성합니다.
            let newItem = $('<div class="option-select-item"></div>');
            // 생성한 DOM 요소에 고유 인덱스를 설정합니다.
            newItem.attr('data-inx', itemIndex);
            newItem.attr('data-purchase-limit', purchaseLimit);
            newItem.attr('data-opt-comb-no', prodOptNo);
            // 데이터셋으로 필요한 값들을 설정합니다.
            newItem.data('prod-no', prodNo);
            newItem.data('prod-cate', prodCate);
            newItem.data('login-id', loginId);

            // 선택한 사이즈를 표시하는 요소를 추가합니다.
            let optionTitle = $('<p class="option-tit"></p>');
            optionTitle.append('<span></span>').text(selectedSize);
            optionTitle.append('<button type="button" class="btn icon remove_18" data-type="del"><span>옵션삭제</span></button>');
            newItem.append(optionTitle);
            // 수량 조절 버튼과 가격을 표시하는 요소를 추가합니다.
            newItem.append(`
            <div class="option-control-box">
                <div class="item-qty">
                    <input class="item_qty_count" id="item-quantity-${itemIndex}" name="qty" type="number" title="상품수량" value="1" numeral="number">
                    <button type="button" class="btn icon minus" id="minus-btn-${itemIndex}"><span>상품수량 빼기</span></button>
                    <button type="button" class="btn icon plus" id="plus-btn-${itemIndex}"><span>상품수량 더하기</span></button>
                </div>
                <div class="option-price">
                    <del style="display: none;"></del>
                    <span class="display-price" id="display-price" data-name="price"></span>                      
                    <span class="won">원</span>
                    <input type="hidden" id="prod_opt_no" name="optCombNo" value="${prodOptNo}">
                </div>
            </div>`);

            // 인덱스 값을 1 증가시킵니다.
            itemIndex++;

            // 선택한 옵션 리스트에 새로 생성한 옵션 항목을 추가합니다.
            $('.option-selected-list').append(newItem);

            // 선택한 상품의 수량을 가져옵니다.
            let productQuantity = parseInt(newItem.find('input.item_qty_count').val());
            // 새로 추가한 항목의 가격을 계산하고 표시합니다.
            let newItemPrice = (basePrice + additionalPrice) * productQuantity;
            newItem.find('.display-price').text(newItemPrice.toLocaleString());
        }

        // 전체 가격을 업데이트합니다.
        updateTotalPrice();

        // 드롭다운 메뉴를 닫습니다.
        let dropdown = $(this).closest('.ui.selection.dropdown.option-select');
        dropdown.removeClass('active visible');
        dropdown.children('.menu').removeClass('transition visible').attr('style', '');

        // 선택한 옵션 리스트에 옵션 항목이 하나 이상 있다면, 선택한 옵션 리스트를 화면에 표시합니다.
        if ($('.option-selected-list .option-select-item').length > 0) {
            $('.option-selected-list').css('display', 'block');
        }

        // 이벤트 전파를 중지합니다.
        e.stopPropagation();
    });

    /**
     * 5. 옵션 삭제 이벤트
     * 이 함수는 '.option-selected-list' 안의 '.remove_18' 요소에 대한 클릭 이벤트를 처리합니다.
     * 클릭된 요소가 속한 '.option-select-item' 요소를 삭제하고, 총 가격을 업데이트하는 'updateTotalPrice()' 함수를 호출합니다.
     *
     * @return 별도의 반환값은 없으나, 클릭 이벤트가 발생할 때마다 해당 옵션이 삭제되고 총 가격이 업데이트됩니다.
     * @throws Exception 요소 선택이나 이벤트 등록, 요소 삭제 과정에서 발생할 수 있는 예외를 처리합니다.
     * @author soso
     * @since 2023/07/07
     */
    $('.option-selected-list').on('click', '.remove_18', function () {
        $(this).closest('.option-select-item').remove();

        // 삭제 후 총 가격 업데이트
        updateTotalPrice();
    });

    /**
     * 6. + 버튼 클릭 시 상품수량을 증가시키는 이벤트
     * 이 함수는 "+" 버튼을 클릭할 때 상품의 수량을 증가시키는 역할을 합니다.
     * 상품의 재고 수량(invQty) 또는 구매 제한 수량(purchaseLimit)에 도달했을 경우,
     * 함수를 종료하며 더 이상 '+' 버튼을 누를 수 없게 합니다.
     *
     * @param itemId 상품 ID. '.option-select-item'의 data-inx 속성값으로 얻어집니다.
     * @param itemQuantityInput 상품의 현재 수량을 나타내는 입력 필드입니다.
     * @param currentQuantity 상품의 현재 수량. itemQuantityInput 필드의 값으로 얻어집니다.
     * @param invQty 상품의 재고 수량. '.option-select-item'의 data-inv-qty 속성값으로 얻어집니다.
     * @param purchaseLimit 상품의 구매 제한 수량. '.option-select-item'의 data-purchase-limit 속성값으로 얻어집니다.
     * @return currentQuantity가 invQty 또는 purchaseLimit에 도달하지 않았을 경우, 상품 수량을 1 증가시키고 가격을 업데이트합니다.
     *         currentQuantity가 invQty 또는 purchaseLimit에 도달하면 알림을 띄우며 함수를 종료합니다.
     * @throws Exception 상품 수량을 증가시키는 동안 발생할 수 있는 예외를 처리합니다.
     * @author soso
     * @since 2023/07/23
     */
    $(document).on('click', '.btn.icon.plus', function () {
        let itemId = $(this).closest('.option-select-item').data('inx');
        let itemQuantityInput = $(`#item-quantity-${itemId}`);
        let currentQuantity = parseInt(itemQuantityInput.val());

        // 해당 항목의 data-inv-qty 값을 얻습니다.
        let invQty = $(this).closest('.option-select-item').data('inv-qty');

        // 해당 항목의 data-purchase-limit 값을 얻습니다.
        let purchaseLimit = $(this).closest('.option-select-item').data('purchase-limit');

        // currentQuantity가 invQty에 도달하거나 purchaseLimit에 도달하면 함수를 종료하고 더 이상 '+' 버튼을 누를 수 없게 합니다.
        if (currentQuantity >= invQty) {
            return;
        }

        if (currentQuantity >= purchaseLimit) {
            alert("최대 구매 수량은 " + purchaseLimit + "개 입니다.");
            return;
        }

        itemQuantityInput.val(currentQuantity + 1);
        updatePrice(this);

        // 총 가격 업데이트
        updateTotalPrice();
    });


    /**
     * 7. - 버튼 클릭 시 상품수량을 감소시키는 이벤트
     * 이 함수는 "-" 버튼을 클릭할 때 상품의 수량을 감소시키는 역할을 합니다.
     * 상품의 현재 수량이 1보다 큰 경우에만 수량을 1 감소시키고, 가격을 업데이트합니다.
     *
     * @param itemId 상품 ID. '.option-select-item'의 data-inx 속성값으로 얻어집니다.
     * @param itemQuantityInput 상품의 현재 수량을 나타내는 입력 필드입니다.
     * @param currentQuantity 상품의 현재 수량. itemQuantityInput 필드의 값으로 얻어집니다.
     * @return currentQuantity가 1보다 큰 경우, 상품 수량을 1 감소시키고 가격을 업데이트합니다.
     *         currentQuantity가 1인 경우, 아무 동작도 수행하지 않습니다.
     * @throws Exception 상품 수량을 감소시키는 동안 발생할 수 있는 예외를 처리합니다.
     * @author soso
     * @since 2023/07/23
     */
    $(document).on('click', '.btn.icon.minus', function () {
        let itemId = $(this).closest('.option-select-item').data('inx');
        let itemQuantityInput = $(`#item-quantity-${itemId}`);
        let currentQuantity = parseInt(itemQuantityInput.val());

        // 수량이 1보다 큰 경우에만 감소
        if (currentQuantity > 1) {
            itemQuantityInput.val(currentQuantity - 1);
            updatePrice(this);
            // 총 가격 업데이트
            updateTotalPrice();
        }
    });

    /**
     * '공유하기' 버튼 클릭 시 해당 팝업 레이어를 활성화하는 이벤트
     * 이 함수는 '공유하기' 버튼을 클릭할 때 해당하는 팝업 레이어를 활성화하는 역할을 합니다.
     *
     * @author soso
     * @since 2023/07/23
     */
    $('.btn.icon.share.btn-share').on('click', function () {
        const popupClass = '.popup-wrap.popup-share'; // '공유하기' 버튼
        $(popupClass).addClass('active');
    });

    /**
     * 버튼 클릭 시 팝업 레이어를 활성화하는 이벤트
     * 이 함수는 특정 버튼을 클릭할 때 관련 팝업 레이어를 활성화하는 역할을 합니다.
     * 버튼의 class를 확인하여 해당하는 팝업을 표시합니다.
     *
     * @author soso
     * @since 2023/07/26
     */
    $('.btn.icon.mark.tooltip-btn').on('click', function () {
        let popupClass;

        if ($(this).hasClass('va-m')) {
            popupClass = '.popup-wrap.discount-price-guide'; // '가격 상세보기' 버튼
        } else {
            popupClass = '.popup-wrap.deliveryPopup'; // 다른 버튼
        }

        $(popupClass).addClass('active');
    });

    /**
     * 팝업 닫기 버튼 클릭 시 팝업 레이어를 비활성화하는 이벤트
     * 이 함수는 팝업의 닫기 버튼을 클릭할 때 팝업 레이어를 비활성화하는 역할을 합니다.
     * 모든 팝업에 공통적으로 적용됩니다.
     *
     * @author soso
     * @since 2023/07/26
     */
    $('button.btn.icon.remove_19').on('click', function () {
        const popupWrap = $(this).closest('.popup-wrap');
        popupWrap.removeClass('active');
        popupWrap.removeClass('on');
    });


    /**
     * URL을 인풋 필드에 설정하는 코드로 현재 페이지의 URL을 ShareUrl 인풋 필드에 설정합니다.
     * 복사 버튼 클릭 이벤트 핸들러로 복사 버튼을 클릭하면 ShareUrl 인풋 필드의 값을 클립보드에 복사하도록 설정합니다.
     * 성공적으로 복사가 완료되면 'URL이 복사되었습니다.'라는 텍스트를 표시하는 토스트 팝업이 나타납니다.
     * 복사가 실패한 경우 콘솔에 에러 메시지를 출력합니다.
     *
     * @author soso
     * @since 2023/07/26
     */
    // 현재 페이지의 URL을 인풋 필드에 설정합니다.
    $('#ShareUrl').val(window.location.href);

    // 복사 버튼을 클릭하면 인풋 필드의 값을 클립보드에 복사합니다.
    $('.btn.clipboard').on('click', function () {
        navigator.clipboard.writeText($('#ShareUrl').val()).then(function () {
            // 토스트 팝업의 내용을 설정하고 팝업을 보이게 합니다.
            $('.popup-toast-content').text('URL이 복사되었습니다.');
            $('.popup-toast').addClass('on');

            //일정 시간이 지나면 팝업을 숨깁니다.
            setTimeout(function () {
                $('.popup-toast').removeClass('on');
            }, 1000); // 1초 후에 팝업을 숨깁니다.
        })
            .catch(function (error) {
                console.error('URL 복사에 실패했습니다.: ', error);
            });
    });

    /**
     * 탭 메뉴에서 항목을 클릭할 때 발생하는 이벤트 핸들러입니다.
     * 클릭된 탭에 'active' 클래스를 추가하고, 해당 탭의 섹션으로 스크롤합니다.
     * 스크롤 시 애니메이션 효과를 적용하며, 섹션의 상단에서 약 150px 위에서 스크롤이 시작됩니다.
     *
     * @param {Event} e - 발생한 클릭 이벤트입니다.
     *                  이를 통해 클릭된 요소에 접근하거나, 기본 이벤트 동작을 제어할 수 있습니다.
     * @return {void} 반환값은 없습니다. 함수의 동작은 화면의 스크롤 위치를 변경하는 것입니다.
     * @throws {Exception} 선택한 탭의 href 값이 유효하지 않거나, 해당 ID를 가진 섹션이 존재하지 않는 경우 예외가 발생할 수 있습니다.
     * @author soso
     * @since 2023/08/04
     */
    $(".tab-menu a").click(function (e) {
        e.preventDefault();

        // 모든 탭에서 'active' 클래스 제거
        $('.tab-menu a').removeClass('active');

        // 선택한 탭에 'active' 클래스 추가
        $(this).addClass('active');

        // 해당 섹션으로 스크롤
        let target = "#" + $(this).attr('href'); // 클릭한 탭의 href 값 앞에 '#' 추가
        let targetPosition = $(target).offset().top; // 섹션의 top 위치를 가져옴

        // 이전에 100px만큼 더 위에서 스크롤 시작
        $('html, body').animate({
            scrollTop: targetPosition - 150
        }, 600); // 600ms 동안 스크롤 애니메이션 수행
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

/**
 * 리스트 가격을 업데이트하는 함수입니다.
 * 주어진 element를 통해 해당 상품의 수량을 가져온 뒤,
 * 상품의 기본 가격(basePrice)과 추가 가격(additionalPrice)을 구하여 총 가격(updatedPrice)을 계산합니다.
 * 이후 해당 상품의 총 가격을 업데이트하여 화면에 표시합니다.
 *
 * @param element 가격을 업데이트할 상품 요소를 나타내는 HTML 요소입니다.
 *                '.btn.icon.plus' 또는 '.btn.icon.minus' 버튼 중 하나일 것으로 예상됩니다.
 * @return 상품의 수량과 가격에 따라 화면에 총 가격을 업데이트합니다.
 * @throws Exception 가격을 업데이트하는 동안 발생할 수 있는 예외를 처리합니다.
 * @author soso
 * @since 2023/07/23
 */
function updatePrice(element) {
    // 상품수량 업데이트
    let itemId = $(element).closest('.option-select-item').data('inx');
    let itemQuantityInput = $(`#item-quantity-${itemId}`);
    let currentQuantity = parseInt(itemQuantityInput.val());

    // 가격 업데이트
    let basePrice = parseFloat($('.flex.al-center').data('price'));
    let additionalPrice = parseFloat($(element).closest('.option-select-item').data('optPrc'));
    if (isNaN(additionalPrice)) {
        additionalPrice = 0;
    }

    let updatedPrice = (basePrice + additionalPrice) * currentQuantity;
    $(element).closest('.option-select-item').find('.display-price').text(updatedPrice.toLocaleString());
}

/**
 * 선택한 상품들의 총 가격을 계산하여 화면에 업데이트하는 함수입니다.
 * '.option-selected-list' 내부의 각 '.option-select-item' 요소들의 가격을 가져와서
 * 총 가격(grandTotal)을 계산하고, 이를 화면의 'strong[data-type="price"]' 요소에 업데이트합니다.
 *
 * @return 선택한 상품들의 가격을 총합하여 화면에 업데이트합니다.
 * @throws Exception 총 가격을 계산하는 동안 발생할 수 있는 예외를 처리합니다.
 * @author soso
 * @since 2023/07/23
 */
function updateTotalPrice() {
    let grandTotal = 0;
    $('.option-selected-list .option-select-item').each(function () {
        let itemPrice = Number($(this).find('.display-price').text().replace(/,/g, ""));
        grandTotal += itemPrice;
    });

    $('strong[data-type="price"]').text(grandTotal.toLocaleString());
}

/**
 * 장바구니에 상품을 추가하는 함수입니다.
 *
 * 사용자가 로그인한 상태가 아니라면 로그인 페이지로 이동합니다.
 * 로그인 상태라면 사용자가 선택한 상품의 정보를 서버에 전송합니다.
 *
 * 각 상품의 ID, 카테고리 ID, 수량, 옵션 번호, 그리고 등록자 ID를 객체로 생성하여 이를 배열에 저장합니다.
 * 생성된 배열을 JSON 형태로 변환하여 서버에 POST 요청을 보냅니다.
 *
 * 요청이 성공하면 '장바구니로 이동하시겠습니까?'라는 메시지를 사용자에게 보여주고,
 * 사용자가 이 메시지를 확인했다면 장바구니 페이지(/fos/cart)로 이동합니다.
 *
 * @return {boolean} false를 반환하여 a 태그의 기본 동작(페이지 이동)을 방지합니다.
 * @throws {exception} 상품 정보를 서버로 전송하는 과정에서 발생할 수 있는 예외를 처리합니다.
 * @author soso
 * @since 2023/07/25
 */
function productIntoCart() {
    const loginId = $("#login_id").val();

    if (!loginId) {
        window.location.href = `/fos/login`;
        return;
    }

    let items = []; // 아이템들을 담을 배열

    // 선택된 아이템들을 반복하여 처리
    $('.option-select-item').each(function () {
        let $this = $(this); // 선택된 아이템을 가리키는 jQuery 객체
        let item = {
            prodId: $("#prod_no").val(),
            cateId: $("#prod_cate").val(),
            qty: $this.find('.item_qty_count').val(), // 수량
            optCombNo: $this.data('opt-comb-no'), // 옵션 번호
            regrId: $("#login_id").val()
        };
        items.push(item); // 배열에 아이템 추가
    });


    $.ajax({
        type: "POST",
        url: "/fos/carts",
        data: JSON.stringify(items), // 데이터 객체를 JSON 문자열로 변환
        contentType: "application/json", // 서버로 보내는 데이터의 타입 지정
        success: function (response) {
            console.log("Data sent successfully.");
            let moveToCart = confirm("장바구니로 이동하시겠습니까?");
            if (moveToCart) {
                window.location.href = "/fos/cart";
            }
        },
        error: function (err) {
            console.log("Error in sending data.");
        }
    });

    return false; // a 태그의 기본 동작(페이지 이동)을 방지
}


