// 장바구니에 상품 목록을 저장하기 위한 전역 변수.
// 선택한 상품이 변경될 때마다 총 금액을 다시 계산하는 데 필요하다.
let g_cartProdList;

namespace("cart");
cart = {
    initLoad: () => {
        // 장바구니에 존재하는 상품 목록을 가져와서 보여준다.
        cart.function.getCartProductList();
    },

    bindButtonEvent: () => { // 버튼에 이벤트 핸들러를 연결
        const $orderBtn = document.getElementById('btn_order');                     // 주문하기 버튼
        const $removeSelectedBtn = document.getElementById("btn_remove_selected");  // 선택한 상품 장바구니에서 삭제
        const $chkAll = document.querySelector('.chk-all');                         // 전체 체크

        $orderBtn.addEventListener('click', cart.function.order);
        $removeSelectedBtn.addEventListener('click', () => cart.function.remove(cart.function.getCheckedCartProdNoArr()));
        $chkAll.addEventListener('click', (e) => cart.function.checkAll(e.target.checked));
    },
};

namespace("cart.eventHandler"); // 이벤트 핸들러(특정 이벤트 발생 시 이벤트를 처리) 모음
cart.eventHandler = {
    // 장바구니에서 상품을 제거
    removeBtnClick: (e) => {
        // 1. 장바구니 상품번호를 가져온다.
        let cartProdNo = e.target.closest('li').querySelector('input[name="cartProdNo"]').value;
        // 2. 제거할 장바구니상품번호를 remove 함수에 전달
        cart.function.remove([cartProdNo]);
    },

    // 화면에서 수량 변경을 담당하는 이벤트 핸들러
    qtyChange: (e) => {
        const $ordQtyInput = e.target.parentElement.querySelector('input[name="ordQty"]');
        updateQty(e.target, $ordQtyInput);
    },

    // 변경된 수량 서버 업데이트를 담당하는 이벤트 핸들러
    qtyUpdate: (e) => {
        // 2. 변경된 수량과 장바구니상품코드를 넘겨서 DB쪽에 업데이트해야 함
        const $ordQtyInput = e.target.parentElement.querySelector('input[name="ordQty"]');
        const cartProdNo = e.target.closest('li').querySelector('input[name="cartProdNo"]').value;

        cart.function.modify(cartProdNo, $ordQtyInput.value);
    },

    // 수량 입력 변경을 관리하는 이벤트 핸들러
    qtyInputChange: (e) => {
        // 1보다 작은 값을 입력했을 경우 수량을 1로 변경한다.
        if (e.target.value < 1)
            e.target.value = 1;

        const cartProdNo = e.target.closest('li').querySelector('input[name="cartProdNo"]').value;
        cart.function.modify(cartProdNo, e.target.value);
    },

    // 장바구니상품의 체크박스의 클릭 이벤트를 처리하는 함수
    chkBtnClick: () => {
        // 1. 현재 체크된 장바구니상품번호를 가져온다.
        const checkedCartProductNoArr = cart.function.getCheckedCartProdNoArr();

        // 2. checkedCartProductNoArr에 존재하는 장바구니상품만 남긴다.(체크된 상품만 필터링한다.)
        const result = g_cartProdList.filter(cartProd => checkedCartProductNoArr.some(chk => chk == cartProd.cartProdNo))
        cart.function.showCartTotal(result);

        // 모든 상품이 선택되었는지 확인한다. 그렇지 않은 경우 전체체크 체크박스를 선택 해제한다.
        const chkCnt = cart.function.getCheckedCartProdNoArr().length; // 체크된 요소 개수
        const totalCnt = g_cartProdList.length; // 전체 요소 개수

        document.querySelector('.chk-all').checked = chkCnt === totalCnt; // 두개수가 같으면, 모든 항목이 체크됨
    }
};

namespace("cart.function");
cart.function = {
    /**
     * 모든 체크박스를 선택하거나 해제한다.
     *
     * @param {boolean} checked 모든 체크박스를 선택할지 여부를 결정하는 불리언 값.
     * @author min
     * @since  2023/07/03
     */
    checkAll: (checked) => {
        const $chks = document.getElementsByName('chk');
        for (let i = 0; i < $chks.length; i++)
            $chks[i].checked = checked;
    },

    /**
     * 장바구니의 상태를 업데이트한다.
     *
     * @param {boolean} isCartExist 장바구니가 비어있는지 여부를 결정하는 불리언 값.
     * @author min
     * @since  2023/07/03
     */
    updateCartStatus: (isCartExist) => {
        const $listNone = document.querySelector('.list-none');
        const $orderBtn = document.querySelector('#btn_order');

        if (isCartExist) {
            $listNone.style.display = 'none';
            $orderBtn.disabled = false;
            cart.function.checkAll(true);
        } else {
            $listNone.style.display = 'block';
            $orderBtn.disabled = true;
            cart.function.checkAll(false);
        }
    },

    /**
     * 장바구니에 담긴 상품들의 목록을 서버로부터 가져온다.
     *
     * @author min
     * @since  2023/07/03
     */
    getCartProductList: () => {
        syusyu.common.Ajax.sendJSONRequest('GET', '/fos/carts', '', res => {
            // 장바구니에서 선택한 상품이 달라질 때마다 총 금액 계산을 다시 하기 위해 전역변수에 저장
            g_cartProdList = res;

            cart.function.showCartProductList(res);
            cart.function.showCartTotal(res);
            cart.function.updateCartStatus(res.length > 0);
        });
    },

    /**
     * 장바구니에 담긴 상품들의 총 가격을 계산하고 보여준다. (총 상품금액, 총 할인금액, 배송비, 결제예상금액)
     *
     * @param {Array} cartProdList 장바구니에 담긴 상품들의 목록.
     * @author min
     * @since  2023/07/03
     */
    showCartTotal: (cartProdList) => {
        const cartTotPrc = cartProdList.reduce((acc, cur) => acc + cur.totPrc, 0);     // 총 상품금액
        const cartTotDcAmt = cartProdList.reduce((acc, cur) => acc + cur.totDcAmt, 0); // 총 할인금액
        const dlvFee = (0 < cartTotPrc && cartTotPrc < 50000) ? 3000 : 0;              // TODO 이거 공통으로 가져올 수 있는 방법 생각해야
        const cartPayAmt = cartTotPrc - cartTotDcAmt + dlvFee;                         // 결제예상금액 = (총 상품금액 - 총 할인금액 + 배송비)

        const $cartTotPrc = document.getElementById('cartTotPrc');      // 총 상품금액
        const $cartTotDcAmt = document.getElementById('cartTotDcAmt');  // 총 할인금액
        const $dlvFee = document.getElementById('dlvFee');              // 배송비
        const $cartPayAmt = document.getElementById('cartPayAmt');      // 결제예상금액
        const $finalAmt = document.getElementById('finalAmt');

        $cartTotPrc.innerHTML = formatPrice(cartTotPrc);
        $cartTotDcAmt.innerHTML = formatPrice(cartTotDcAmt);
        $dlvFee.innerHTML = formatPrice(dlvFee);
        $cartPayAmt.innerHTML = formatPrice(cartPayAmt);
        $finalAmt.innerHTML = formatPrice(cartPayAmt) + '원 주문하기';
    },

    /**
     * 장바구니 상품 리스트를 화면에 표시한다.
     *
     * @param {Array} cartProdList - 장바구니 상품 리스트
     * @author min
     * @since 2023/07/03
     */
    showCartProductList: (cartProdList) => {
        // 1. 기존에 보여지고 있던 장바구니 목록을 초기화한다.
        const $cart = document.querySelector('.prd-brd-list');
        $cart.innerHTML = '';

        // 2. HTML 요소를 동적으로 생성해서 화면에 보여준다.
        cartProdList.forEach(cartProd => {
            const $cartProdLi = document.createElement('li');

            const totOptPrc = cartProd.totOptPrc > 0 ? ` (+${formatPrice(cartProd.totOptPrc)}원) ` : '';
            const result = `
            <div class="chk-area">
                <div class="chkbox single">
                    <label>
                        <input type="checkbox" class="chk-point" name="chk">
                        <span class="text">선택</span>
                    </label>
                </div>
            </div>
            <div class="item-area">
                <div class="prd-item etc-ty1 ">
                    <input type="hidden" name="cartProdNo" value="${cartProd.cartProdNo}">
                    <input type="hidden" name="prodId" value="${cartProd.prodId}">
                    <input type="hidden" name="orderPrice" value="28480.00">
                    <input type="hidden" name="discEventPrice" value="0.00">
                    <input type="hidden" name="dlvrPolicyFee" value="3000.00">
                    <input type="hidden" name="itemQtyCount" value="2">
                    <div class="thumbs hover">
                        <a href="https://www.ottogimall.co.kr/front/product/2254">
                            <img src="${cartProd.repImg}" alt="이미지">
                        </a>
                    </div>
                    <div class="desc">
                        <a href="javascript:">
                            <p class="name">${cartProd.prodNm}</p>
                            <div class="option">
                                <p>
                                    ${cartProd.opt}
                                    ${totOptPrc}
                                </p>
                            </div>
                        </a>
                    </div>
                </div>
            </div>
            <div class="item-qty-area">
                <div class="item-qty">
                    <input class="item_qty_count ux-number" type="number" title="상품수량" name="ordQty" value="${cartProd.qty}" maxlength="4" min="1" max="0" before="2" optneeds="0" stock="39" numeral="number">
                    <button type="button" class="btn icon minus"><span class="text">상품수량 빼기</span></button>
                    <button type="button" class="btn icon plus"><span class="text">상품수량 더하기</span></button>
                </div>
            </div>
            <div class="price-arae">
                <p class="amount">${formatPrice(cartProd.totDcPrc)}<span class="won">원</span></p>
                ${cartProd.totDcPrc !== cartProd.totPrc ? `<del>${formatPrice(cartProd.totPrc)}<span class="won">원</span></del>` : ''}
            </div>
            <div class="remove-area">
                <button type="button" class="btn icon remove_20 btn_remove"><span class="text">삭제</span></button>
            </div>`;

            $cartProdLi.innerHTML += result;

            const $chkBtn = $cartProdLi.querySelector('input[name="chk"]'); // 선택버튼
            $chkBtn.addEventListener('click', cart.eventHandler.chkBtnClick);

            const $removeBtn = $cartProdLi.querySelector('.remove-area button'); // 개별 상품 삭제 버튼
            $removeBtn.addEventListener('click', cart.eventHandler.removeBtnClick);

            const $qtyBtns = $cartProdLi.querySelectorAll('.item-qty .btn'); // 수량 +, - 버튼
            $qtyBtns.forEach((btn) => {
                btn.addEventListener('click', cart.eventHandler.qtyChange); // 수량 변경
                btn.addEventListener('click', debouncedHandler); // 서버 업데이트
            });

            const $qtyInput = $cartProdLi.querySelector('input[name="ordQty"]'); // 수량 수정 input 버튼
            $qtyInput.addEventListener('change', cart.eventHandler.qtyInputChange);

            $cart.appendChild($cartProdLi);
        });
    },

    /**
     * 장바구니에서 수량을 수정한다.
     *
     * @param {Number} cartProdNo - 장바구니 상품 번호
     * @param {Number} ordQty - 주문 수량
     * @author min
     * @since 2023/07/03
     */
    modify: (cartProdNo, ordQty) => {
        const param = {qty: ordQty};
        syusyu.common.Ajax.sendJSONRequest('PATCH', '/fos/carts/' + cartProdNo, param, () => {
            cart.function.getCartProductList();
        });
    },

    /**
     * 장바구니에 담긴 상품들을 제거한다.
     *
     * @param {string[]} cartProdNoArr 제거할 장바구니상품번호 배열
     * @author min
     * @since 2023/07/03
     */
    remove: (cartProdNoArr) => {
        syusyu.common.Ajax.sendJSONRequest('DELETE', '/fos/carts/', cartProdNoArr, () => {
            cart.function.getCartProductList();
        });
    },

    /**
     * 현재 선택된 장바구니 상품 번호들의 배열을 반환
     *
     * @author min
     * @since 2023/07/04
     */
    getCheckedCartProdNoArr: () => {
        return cart.function.getCheckedItem('cartProdNo')
    },

    /**
     * 현재 선택된 상품 ID들의 배열을 반환
     *
     * @author min
     * @since 2023/07/04
     */
    getCheckedProdIdArr: () => {
        return cart.function.getCheckedItem('prodId')
    },

    /**
     * 주어진 이름을 가진 요소 중 현재 선택된 요소들의 값을 배열로 반환
     *
     * @param {string} target - 값을 가져올 요소의 이름
     * @author min
     * @since 2023/07/03
     */
    getCheckedItem: (target) => {
        let $checkedItems = document.querySelectorAll("input[name='chk']:checked");
        // TODO querySelectorAll 반환 값이 왜 nodelist인지 거기서 왜 filter 호출할 수 없는지?
        $checkedItems = Array.from($checkedItems).filter(item => !item.classList.contains('chk-all'));

        return $checkedItems.map((item) => item.closest('li').querySelector('input[name="' + target + '"]').value);
    },

    /**
     * 현재 선택된 상품들이 주문 가능한 상태인지 확인
     *
     * @author min
     * @since 2023/07/04
     */
    checkProductStatus: () => {
        const checkedProdIdArr = cart.function.getCheckedProdIdArr();

        syusyu.common.Ajax.sendJSONRequest('GET', '/productStatus', {'prodIdArr': checkedProdIdArr}, () => {
            // 1. 판매상태가 601이 아닌 상품들을 찾는다.
            const tmp = result.filter(product => product.status !== 601);

            // 2. TODO tmp에 객체가 하나라도 있으면 그 name을 합쳐서 alert 띄워주고 return 하기
            if (tmp.length !== 0) {
                const prodNm = tmp.map(product => product.prodNm).join(',');
                alert(prodNm + "는 구매가 불가능한 상품입니다.");
            }
        }, null, true);
    },

    checkItemsSelected: () => {
        return cart.function.getCheckedCartProdNoArr().length > 0;
    },


    validateCartProducts: function () {
        // 선택되어있는 상품이 존재하는지 검증한다.
        return cart.function.checkItemsSelected();



        // AJAX 호출을 통해 유효성 검사를 수행
        // $.ajax({
        //     url: "validateCartProducts",
        //     method: "POST",
        //     data: {
        //         // cartProdNoArr: cartProdNoArr,  // 선택한 장바구니 상품 아이디 배열
        //         // mbrId: mbrId                  // 사용자 아이디
        //     },
        //     success: function (response) {
        //         var success = response.success;
        //         callback(success);  // 콜백 함수를 호출하여 결과 전달
        //     },
        //     error: function () {
        //         // callback(false);    // 오류 발생 시 유효성 검사 실패로 처리
        //         callback(true);
        //     }
        // });
    },

    // validateCartProducts: (callback) => {
    //     // AJAX 호출을 통해 유효성 검사를 수행
    //     $.ajax({
    //         url: "validateCartProducts",
    //         method: "POST",
    //         data: {
    //             // cartProdNoArr: cartProdNoArr,  // 선택한 장바구니 상품 아이디 배열
    //             // mbrId: mbrId                  // 사용자 아이디
    //         },
    //         success: function (response) {
    //             var success = response.success;
    //             callback(success);  // 콜백 함수를 호출하여 결과 전달
    //         },
    //         error: function () {
    //             // callback(false);    // 오류 발생 시 유효성 검사 실패로 처리
    //             callback(true);
    //         }
    //     });
    // },

    getOrderSheetData: () => {
        // 주문하기 버튼을 누르면 상품이 구매가 가능한 상태인지 확인한다.
        // cart.function.checkProductStatus();

        const cartProdNoArr = cart.function.getCheckedCartProdNoArr();

        // 주문서 데이터를 성공적으로 가져왔을 때, 페이지 리디렉션을 수행한다.
        location.href = '/fos/orderSheet?cartProdNoArr=' + JSON.stringify(cartProdNoArr);

        // 선택한 장바구니 상품 아이디 배열을 쿼리 문자열로 변환
        const queryString = 'cartProdNoArr=' + cartProdNoArr.join('&cartProdNoArr=');

        // 주문서 화면으로 이동
        window.location.href = '/fos/orderSheet?' + queryString;
    },

    order: function () {
        if (!cart.function.validateCartProducts()) {
            syusyu.common.Popup.alert('주문 상품을 선택해 주세요.');
            return false;
        }

        cart.function.getOrderSheetData();
        // 1. 유효성 검사를 수행한다.
        // cart.function.validateCartProducts(function (success) {
        //     if (success) {
        //         // 유효성 검사가 성공한 경우, 데이터를 조회하여 주문/결제 화면에 표시한다.
        //     } else {
        //         // 유효성 검사가 실패한 경우, 구매 불가능한 상품에 대한 알림을 표시한다.
        //         showErrorMessage("Some products are not eligible for purchase.");
        //     }
        // });

    }
}


// 이벤트 핸들러에 디바운싱 적용
const debouncedHandler = _.debounce((e) => {
    cart.eventHandler.qtyUpdate(e);
}, 500, false);






