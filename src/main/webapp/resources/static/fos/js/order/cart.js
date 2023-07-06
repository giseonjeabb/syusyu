let g_cartProductList;

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
    const chks = document.getElementsByName('chk');
    for (let i = 0; i < chks.length; i++)
        chks[i].checked = checked;
}

const updateCartStatus = (isCartExist) => {
    const listNone = document.querySelector('.list-none');
    const orderBtn = document.querySelector('#btn_order');

    if (isCartExist) {
        listNone.style.display = 'none';
        orderBtn.disabled = false;
        checkAll(true);
    } else {
        listNone.style.display = 'block';
        orderBtn.disabled = true;
        checkAll(false);
    }
}

const getCartProductList = () => {
    $.ajax({
        type: 'GET',
        url: '/cartList',
        contentType: 'application/json; charset=utf-8',
        success: (result) => {
            // 장바구니에서 선택한 상품이 달라질 때마다 총 금액 계산을 다시 하기 위해 전역변수에 저장
            g_cartProductList = result;

            showCartProductList(result);
            showCartTotal(result);
            updateCartStatus(result.length > 0);
        },
        error: (jqXHR, textStatus, errorThrown) => {
            console.error("Error in remove:", textStatus, errorThrown);
        }
    });
}

// 장바구니 화면 오른쪽에 위치한 총 금액을 계산해서 보여주기 위한 함수(총 상품금액, 총 할인금액, 배송비, 결제예상금액)
const showCartTotal = (cartProdList) => {
    const cartTotPrc = cartProdList.reduce((acc, cur) => acc + cur.totPrc, 0);     // 총 상품금액
    const cartTotDcPrc = cartProdList.reduce((acc, cur) => acc + cur.totDcPrc, 0); // 총 할인금액
    const dlvFee = (0 < cartTotPrc && cartTotPrc < 50000) ? 3000 : 0;              // TODO 이거 공통으로 가져올 수 있는 방법 생각해야
    const cartPayAmt = cartTotPrc - cartTotDcPrc + dlvFee;                         // 결제예상금액 = (총 상품금액 - 총 할인금액 + 배송비)

    // TODO 변수에 $ 어떨 때 붙이는 건지...
    const $cartTotPrc = document.getElementById('cartTotPrc');      // 총 상품금액
    const $cartTotDcPrc = document.getElementById('cartTotDcPrc');  // 총 할인금액
    const $dlvFee = document.getElementById('dlvFee');              // 배송비
    const $cartPayAmt = document.getElementById('cartPayAmt');      // 결제예상금액
    const $finalAmt = document.getElementById('finalAmt');

    $cartTotPrc.innerHTML = formatPrice(cartTotPrc);
    $cartTotDcPrc.innerHTML = formatPrice(cartTotDcPrc);
    $dlvFee.innerHTML = formatPrice(dlvFee);
    $cartPayAmt.innerHTML = formatPrice(cartPayAmt);
    $finalAmt.innerHTML = formatPrice(cartPayAmt) + '원 주문하기';
}

// 분리한 이벤트 핸들러 함수들
const handleRemoveBtnClick = (e) => {
    let cartProdNo = e.target.closest('li').querySelector('input[name="cartProdNo"]').value;
    remove([cartProdNo]);
};

// 화면에서 수량 변경을 담당하는 이벤트 핸들러
const handleQtyChange = (e) => {
    // 1. 수량을 변경한다.
    const ordQtyInput = e.target.parentElement.querySelector('input[name="ordQty"]');
    updateQty(e.target, ordQtyInput);
};

// 변경된 수량 서버 업데이트
const handleQtyUpdate = (e) => {
    // 2. 변경된 수량과 장바구니상품코드를 넘겨서 DB쪽에 업데이트해야 함
    const ordQtyInput = e.target.parentElement.querySelector('input[name="ordQty"]');
    const cartProdNo = e.target.closest('li').querySelector('input[name="cartProdNo"]').value;

    modify(cartProdNo, ordQtyInput.value);
};

// 이벤트 핸들러에 디바운싱 적용
const debouncedHandler = _.debounce((e) => {
    handleQtyUpdate(e);
}, 500, false);

const handleQtyInputChange = (e) => {
    // 1보다 작은 값을 입력했을 경우 수량을 1로 변경한다.
    if (e.target.value < 1)
        e.target.value = 1;

    const cartProdNo = e.target.closest('li').querySelector('input[name="cartProdNo"]').value;
    modify(cartProdNo, e.target.value);
};

const handleChkBtnClick = () => {
    debugger;
    // 1. 전역으로 저장해뒀던 장바구니 상품 리스트에서 체크된 것만 filter로 걸려야 한다.
    // 그런데 전역으로 저장해둔 장바구니 상품리스트에는 Html 요소 정보가 아니기 때문에 chk 정보가 없고
    // 그렇다고 html 요소만 가져오기에는 가격 정보가 없다
    // 그렇다면 html요소에서 체크된 장바구니상품아이디만 가져오게 한 뒤에 그 객체와 g_cartProductList만 일치하는 걸 거르면 될듯?

    // 1. 현재 체크된 장바구니상품아이디를 가져온다.
    const checkedCartProductNoArr = getCheckedCartProdNoArr();

    // 2. checkedCartProductNoArr에 존재하는 장바구니상품만 남긴다.
    const result = g_cartProductList.filter(cartProduct => checkedCartProductNoArr.some(chk => chk == cartProduct.cartProdNo))
    showCartTotal(result);

    // 만약 모든 상품이 체크되어있지 않다면 전체체크 해제해야 함
    // chk된 거랑 모든 요소 개수가 다르면 전체 체크 해제하기

    // 1. chk된 요소 개수 가져오기
    const chkCnt = getCheckedCartProdNoArr().length;

    // 2. 전체 요소 개수 가져오기
    const totalCnt = g_cartProductList.length;

    document.querySelector('.chk-all').checked = chkCnt === totalCnt;
}

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

        const chkBtn = cartProductLi.querySelector('input[name="chk"]');
        chkBtn.addEventListener('click', handleChkBtnClick);

        const removeBtn = cartProductLi.querySelector('.remove-area button');
        removeBtn.addEventListener('click', handleRemoveBtnClick);

        const qtyBtns = cartProductLi.querySelectorAll('.item-qty .btn');
        qtyBtns.forEach((btn) => {
            btn.addEventListener('click', handleQtyChange); // 수량 변경
            btn.addEventListener('click', debouncedHandler); // 서버 업데이트
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
            getCartProductList();
        },
        error: (jqXHR, textStatus, errorThrown) => {
            console.error("Error in remove:", textStatus, errorThrown);
        }
    });
}

const getCheckedCartProdNoArr = () => getCheckedItem('cartProdNo');
const getCheckedProdIdArr = () => getCheckedItem('prodId');

const getCheckedItem = (target) => {
    let checkedItems = document.querySelectorAll("input[name='chk']:checked");
    // TODO querySelectorAll 반환 값이 왜 nodelist인지 거기서 왜 filter 호출할 수 없는지?
    checkedItems = Array.from(checkedItems).filter(item => !item.classList.contains('chk-all'));

    return checkedItems.map((item) => item.closest('li').querySelector('input[name="' + target + '"]').value);
};

const checkProductStatus = () => {
    const checkedProdIdArr = getCheckedProdIdArr();

    $.ajax({
        type: 'GET',
        url: '/productStatus',
        contentType: 'application/json; charset=utf-8',
        dataType: 'json',
        traditional: true, // 배열 파라미터를 prodIdArr=1&prodIdArr=2&prodIdArr=3과 같은 형태로 직렬화
        data: {'prodIdArr': checkedProdIdArr},
        success: (result) => {
            // 1. 판매상태가 601이 아닌 상품들을 찾는다.
            const tmp = result.filter(product => product.status !== 601);

            // 2. TODO tmp에 객체가 하나라도 있으면 그 name을 합쳐서 alert 띄워주고 return 하기
            if (tmp.length !== 0) {
                const prodNm = tmp.map(product => product.prodNm).join(',');
                alert(prodNm + "는 구매가 불가능한 상품입니다.");
            }
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
