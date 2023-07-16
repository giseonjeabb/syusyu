const namespace = (...a) => {
    let o = null, i, j, d;
    for (i = 0; i < a.length; i = i + 1) {
        d = a[i].split(".");
        o = window;
        for (j = 0; j < d.length; j = j + 1) {
            o[d[j]] = o[d[j]] || {};
            o = o[d[j]];
        }
    }
    return o;
};



const validatePassword = (password) => {
    // 비밀번호가 최소 8자리에 숫자, 대문자, 소문자, 특수문자가 각각 1개 이상 포함되어 있는지 검사하는 정규표현식
    const regex = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z])(?=.*[!@#$%^&*]).{8,16}$/;

    return regex.test(password);
}

const updateQty = (button, input) => {
    let quantity = Number(input.value);
    if (button.classList.contains('minus') && quantity > 1) {
        quantity--;
    } else if (button.classList.contains('plus')) {
        quantity++;
    }
    input.value = quantity;
}

const formatPrice = (price) => {
    if (typeof price !== 'number')
        price = parseInt(price);

    return price.toLocaleString();
}