document.addEventListener("DOMContentLoaded", () => {
    getCartProductList();

    const orderBtn = document.getElementById('btn_order');
    const removeSelectedBtn = document.getElementById("btn_remove_selected");

    orderBtn.addEventListener('click', order);

    removeSelectedBtn.addEventListener('click', () => remove(getCheckedItem()));
});

const getCartProductList = () => {
    $.ajax({
        type: 'GET',
        url: '/cartList',
        contentType: 'application/json; charset=utf-8',
        success: (result) => {
            showCartProductList(result);
        },
        error: (jqXHR, textStatus, errorThrown) => {
            console.error("Error in remove:", textStatus, errorThrown);
        }
    });
}

const showCartProductList = (cartProductList) => {
    // 1. 기존에 보여지고 있던 장바구니 목록을 초기화한다.
    const cart = document.querySelectorAll('.prd-brd-list')[0];
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
                <p class="amount">${formatPrice(cartProduct.totPrc)}<span class="won">원</span></p>
            </div>
            <div class="remove-area">
                <button type="button" class="btn icon remove_20 btn_remove"><span class="text">삭제</span></button>
            </div>
        `;

        cartProductLi.innerHTML += result;

        cartProductLi.querySelector('.remove-area button').addEventListener('click', () => {
            let cartProdNo = e.target.closest('li').querySelector('input[name="cartProdNo"]').value;
            remove([cartProdNo]);
        });

        cartProductLi.querySelector('.item-qty').addEventListener('click', (e) => {
            // 1. 수량을 변경한다.
            const ordQtyInput = e.target.parentElement.querySelector('input[name="ordQty"]');
            updateQty(e.target, ordQtyInput);

            // 2. 변경된 수량과 장바구니상품코드를 넘겨서 DB쪽에 업데이트해야 함
            const cartProdNo = e.target.closest('li').querySelector('input[name="cartProdNo"]').value;
            modify(cartProdNo, ordQtyInput.value);
        });

        cartProductLi.querySelector('input[name="ordQty"]').addEventListener('focusout', (e) => {
            const cartProdNo = e.target.closest('li').querySelector('input[name="cartProdNo"]').value;
            modify(cartProdNo, e.target.value);
        });

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
            getList();
        },
        error: (jqXHR, textStatus, errorThrown) => {
            console.error("Error in remove:", textStatus, errorThrown);
        }
    });
}

const getCheckedItem = () => {
    const checkedItems = document.querySelectorAll("input[name='chk']:checked");
    return Array.from(checkedItems).map((item) => item.closest('li').querySelector('input[name="cartProdNo"]').value);
};

const getList = () => {
    location.href = '/cart';
}

const order = () => {
    const checkedItem = getCheckedItem();

    $.ajax({
        type: 'POST',
        url: '/order/cartOrder',
        contentType: 'application/json; charset=utf-8',
        dataType: 'json',
        data: JSON.stringify(checkedItem),
        success: (result) => {
            let cartOrderNos = result.map((item) => `cartOrderNo=${item}`).join('&');
            location.href = '/order/orderSheet?' + cartOrderNos;
        },
        error: (jqXHR, textStatus, errorThrown) => {
            alert("An error occurred: " + textStatus + " - " + errorThrown);
        }
    });
}
