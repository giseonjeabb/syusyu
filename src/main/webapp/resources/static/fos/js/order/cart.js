document.addEventListener("DOMContentLoaded", () => {
    getCartProductList();

    const orderBtn = document.getElementById('btn_order');
    const removeSelectedBtn = document.getElementById("btn_remove_selected");
    const chkAll = document.querySelector('.chk-all');

    orderBtn.addEventListener('click', order);
    removeSelectedBtn.addEventListener('click', () => remove(getCheckedCartProdNoArr()));
    chkAll.addEventListener('click', (e) => checkAll(e.target.checked));
});

const checkAll = (checked) => {
    document.querySelector('.chk-all').checked = checked;

    const chks = document.getElementsByName('chk');
    for (let i = 0; i < chks.length; i++)
        chks[i].checked = checked;
}

const updateCartStatus = (isCartExist) => {
    const listNone = document.querySelector('.list-none');
    const orderBtn = document.querySelector('#btn_order');

    if (isCartExist) {
        listNone.style.display = 'block';
        orderBtn.disabled = true;
    } else {
        listNone.style.display = 'none';
        orderBtn.disabled = false;
        checkAll(true);
    }
}

const getCartProductList = () => {
    $.ajax({
        type: 'GET',
        url: '/cartList',
        contentType: 'application/json; charset=utf-8',
        success: (result) => {
            showCartProductList(result.cartProduct);
            showCartTotal(result.cartTotal);
            updateCartStatus(result.cartProduct.length === 0);
        },
        error: (jqXHR, textStatus, errorThrown) => {
            console.error("Error in remove:", textStatus, errorThrown);
        }
    });
}

const showCartTotal = (cartTotal) => {
    const cartTotPrc = document.getElementById('cartTotPrc'); // 총 상품금액
    const cartTotDcPrc = document.getElementById('cartTotDcPrc'); // 총 할인금액
    const dlvFee = document.getElementById('dlvFee'); // 배송비
    const cartPayAmt = document.getElementById('cartPayAmt'); // 결제예상금액
    const finalAmt = document.getElementById('finalAmt');

    cartTotPrc.innerHTML = formatPrice(cartTotal.cartTotPrc);
    cartTotDcPrc.innerHTML = formatPrice(cartTotal.cartTotDcPrc);
    dlvFee.innerHTML = formatPrice(cartTotal.cartTotPrc === 0 ? 0 : cartTotal.dlvFee);
    cartPayAmt.innerHTML = formatPrice(cartTotal.cartPayAmt);
    finalAmt.innerHTML = formatPrice(cartTotal.cartPayAmt) + '원 주문하기';
}


// 분리한 이벤트 핸들러 함수들
const handleRemoveBtnClick = (e) => {
    let cartProdNo = e.target.closest('li').querySelector('input[name="cartProdNo"]').value;
    remove([cartProdNo]);
};

const handleQtyBtnClick = (e) => {
    // 1. 수량을 변경한다.
    const ordQtyInput = e.target.parentElement.querySelector('input[name="ordQty"]');
    updateQty(e.target, ordQtyInput);

    // 2. 변경된 수량과 장바구니상품코드를 넘겨서 DB쪽에 업데이트해야 함
    const cartProdNo = e.target.closest('li').querySelector('input[name="cartProdNo"]').value;
    modify(cartProdNo, ordQtyInput.value);
};

const handleQtyInputChange = (e) => {
    // 1보다 작은 값을 입력했을 경우 수량을 1로 변경한다.
    if (e.target.value < 1)
        e.target.value = 1;

    const cartProdNo = e.target.closest('li').querySelector('input[name="cartProdNo"]').value;
    modify(cartProdNo, e.target.value);
};

// 상품 리스트를 표시하는 함수
const showCartProductList = (cartProductList) => {


    // 1. 기존에 보여지고 있던 장바구니 목록을 초기화한다.
    const cart = document.querySelector('.prd-brd-list');
    cart.innerHTML = '';

    // 2. 요소를 동적으로 생성해서 화면에 보여준다.
    cartProductList.forEach(cartProduct => {
        const cartProductLi = document.createElement('li');

        const totOptPrc = cartProduct.totOptPrc > 0 ? ` (+${formatPrice(cartProduct.totOptPrc)}원) ` : '';
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
                    <input type="hidden" name="cartProdNo" value="${cartProduct.cartProdNo}">
                    <input type="hidden" name="prodId" value="${cartProduct.prodId}">
                    <input type="hidden" name="orderPrice" value="28480.00">
                    <input type="hidden" name="discEventPrice" value="0.00">
                    <input type="hidden" name="dlvrPolicyFee" value="3000.00">
                    <input type="hidden" name="itemQtyCount" value="2">
                    <div class="thumbs hover">
                        <a href="https://www.ottogimall.co.kr/front/product/2254">
                            <img src="/static/image/product/${cartProduct.repImg}" alt="이미지">
                        </a>
                    </div>
                    <div class="desc">
                        <a href="javascript:">
                            <p class="name">${cartProduct.prodNm}</p>
                            <div class="option">
                                <p>
                                    ${cartProduct.opt}
                                    ${totOptPrc}
                                </p>
                            </div>
                        </a>
                    </div>
                </div>
            </div>
            <div class="item-qty-area">
                <div class="item-qty">
                    <input class="item_qty_count ux-number" type="number" title="상품수량" name="ordQty" value="${cartProduct.qty}" maxlength="4" min="1" max="0" before="2" optneeds="0" stock="39" numeral="number">
                    <button type="button" class="btn icon minus"><span class="text">상품수량 빼기</span></button>
                    <button type="button" class="btn icon plus"><span class="text">상품수량 더하기</span></button>
                </div>
            </div>
            <div class="price-arae">
                <p class="amount">${formatPrice(cartProduct.totDcAplPrc)}<span class="won">원</span></p>
                ${cartProduct.totDcAplPrc !== cartProduct.totPrc ? `<del>${formatPrice(cartProduct.totPrc)}<span class="won">원</span></del>` : ''}
            </div>
            <div class="remove-area">
                <button type="button" class="btn icon remove_20 btn_remove"><span class="text">삭제</span></button>
            </div>`;

        cartProductLi.innerHTML += result;

        const removeButton = cartProductLi.querySelector('.remove-area button');
        removeButton.addEventListener('click', handleRemoveBtnClick);

        const qtyButtons = cartProductLi.querySelectorAll('.item-qty .btn');
        qtyButtons.forEach((btn) => {
            btn.addEventListener('click', handleQtyBtnClick);
        });

        const qtyInput = cartProductLi.querySelector('input[name="ordQty"]');
        qtyInput.addEventListener('change', handleQtyInputChange);

        cart.appendChild(cartProductLi);
    });
}

const modify = (cartProdNo, ordQty) => {
    const param = {qty: ordQty};

    $.ajax({
        type: 'PATCH',
        url: '/cart/' + cartProdNo,
        contentType: 'application/json; charset=utf-8',
        data: JSON.stringify(param),
        success: () => {
            getCartProductList();
        },
        error: (jqXHR, textStatus, errorThrown) => {
            console.error("Error in remove:", textStatus, errorThrown);
        }
    });
}

const remove = (cartProdNoArr) => {
    $.ajax({
        type: 'DELETE',
        url: '/cart',
        contentType: 'application/json; charset=utf-8',
        data: JSON.stringify(cartProdNoArr),
        success: () => {
            // getCartProductList();
        },
        error: (jqXHR, textStatus, errorThrown) => {
            console.error("Error in remove:", textStatus, errorThrown);
        }
    });
}

const getCheckedCartProdNoArr = () => getCheckedItem('cartProdNo');
const getCheckedProdIdArr = () => getCheckedItem('prodId');

const getCheckedItem = (target) => {
    const checkedItems = document.querySelectorAll("input[name='chk']:checked");
    return Array.from(checkedItems).map((item) => item.closest('li').querySelector('input[name="' + target + '"]').value);
};


const checkProductStatus = () => {
    const checkedProdIdArr = getCheckedProdIdArr();

    $.ajax({
        type: 'GET',
        url: '/productStatus',
        contentType: 'application/json; charset=utf-8',
        dataType: 'json',
        traditional: true, // 배열 파라미터를 prodIdArr=1&prodIdArr=2&prodIdArr=3과 같은 형태로 직렬화
        data: { 'prodIdArr': checkedProdIdArr },
        success: (result) => {
            debugger;
        },
        error: (jqXHR, textStatus, errorThrown) => {
            alert("An error occurred: " + textStatus + " - " + errorThrown);
        }
    });
}

const order = () => {
    // 주문하기 버튼을 누르면 상품이 구매가 가능한 상태인지 확인한다.
    // const checkedItem = getCheckedCartProdNoArr();
    checkProductStatus();

    // $.ajax({
    //     type: 'POST',
    //     url: '/order/cartOrder',
    //     contentType: 'application/json; charset=utf-8',
    //     dataType: 'json',
    //     data: JSON.stringify(checkedItem),
    //     success: (result) => {
    //         let cartOrderNos = result.map((item) => `cartOrderNo=${item}`).join('&');
    //         location.href = '/order/orderSheet?' + cartOrderNos;
    //     },
    //     error: (jqXHR, textStatus, errorThrown) => {
    //         alert("An error occurred: " + textStatus + " - " + errorThrown);
    //     }
    // });
}
