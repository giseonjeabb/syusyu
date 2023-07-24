document.addEventListener("DOMContentLoaded", function () {
    const registerBtn = document.querySelector('#btn_register'); // 로그인 버튼

    // 회원가입 버튼을 누른다.
    registerBtn.addEventListener('click', () => {

        // 1. 유효성 검사를 한다.
        if (!validateRegister()) {
            // 1-2. 유효성 검사를 통과하지 못하면 입력되지 않은 값을 alert으로 띄워준다.
            return;
        }
        // 1-1. 유효성 검사를 통과하면 로그인 화면으로 이동시킨다.
        register();
    });
});

function validateRegister() {
    // 필수값 : 아이디, 비밀먼호, 이름, 생년월일, 성별
    const lginId = document.getElementById('login_id');
    const lginPwd = document.getElementById('login_pwd');
    const name = document.getElementById('name');
    const birth = document.getElementById('birth');
    const selectedSex = document.querySelector('input[name="sex"]:checked');

    if (!lginId.value) {
        alert("아이디를 입력해 주세요.");
        lginId.focus();

        return false;
    }

    if (!validatePassword(lginPwd.value)) {
        alert("비밀번호를 영문, 숫자, 특수문자를 조합하여 입력해 주세요.");
        lginPwd.focus();

        return false;
    }

    if (!name.value) {
        alert("이름을 입력해 주세요.")
        name.focus();

        return false;
    }

    if (!validateBirthdate(birth.value)) {
        alert("생년월일을 올바르게 입력해 주세요. (ex. 19941203)")
        birth.focus();

        return false;
    }

    if (!selectedSex) {
        alert("성별을 선택해 주세요.");

        return false;
    }

    return true;
}

function register() {
    const param = {
        lginId:  document.getElementById('login_id').value,
        lginPwd: document.getElementById('login_pwd').value,
        email:   document.getElementById('email').value,
        name:    document.getElementById('name').value,
        role:    '20',
        birth:   document.getElementById('birth').value,
        sex:     document.querySelector('input[name="sex"]:checked').value,
        mpNo:    document.getElementById('mobile_no').value,
        shoeSize:    document.getElementById('shoe_size').value
    };

    syusyu.common.Ajax.sendJSONRequest('POST', '/fos/register', param, res => {
        if (res === 'success') {
            location.href = '/fos/login';
        } else {
            alert("정보를 올바르게 다시 입력해 주세요.");
        }
    });
}

function validateBirthdate(birthdate) {
    // 연도는 1900년 이후, 월은 01~12, 일은 01~31
    const regex = /^(19|20)\d{2}(0[1-9]|1[012])(0[1-9]|[12][0-9]|3[01])$/;

    return regex.test(birthdate);
}




















