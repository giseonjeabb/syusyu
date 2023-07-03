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
    return price.toLocaleString();
}