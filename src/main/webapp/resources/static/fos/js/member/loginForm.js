document.addEventListener("DOMContentLoaded", function () {
    const loginBtn = document.querySelector('#btn_login'); // 로그인 버튼

    // 로그인 버튼을 누른다.
    loginBtn.addEventListener('click', () => {
        // 1. 유효성 검사를 한다.
        if (!validateLogin()) {
            // 1-2. 유효성 검사를 통과하지 못하면 입력되지 않은 값을 alert로 띄워준다.
            return;
        }
        // 1-1. 유효성 검사를 통과하면 로그인을 시킨다.
        login();
    });

});

function validateLogin() {
    const id = document.getElementById('login_id');
    const pwd = document.getElementById('login_pwd');

    if (!id.value) {
        alert("아이디를 입력해주세요");
        id.focus();

        return false;
    }

    if (!pwd.value) {
        alert("비밀번호를 입력해주세요");
        pwd.focus();

        return false;
    }

    return true;
}

/**
 * 사용자 로그인을 처리하는 함수입니다.
 * 입력된 아이디와 비밀번호를 매개변수로 하여 서버에 로그인 요청을 보냅니다.
 * 로그인 성공 시 사용자를 이전 페이지로 이동시키며, 실패 시 오류 메시지를 출력합니다.
 *
 * @author min
 * @since  2023/06/25
 * @modifier soso
 * @modified 2023/07/25
 */
function login() {
    // ajax로 로그인 컨트롤러 메서드를 ajax로 호출한다.
    // 매개변수 : 아이디, pw
    const param = {
        lginId: document.getElementById('login_id').value,
        lginPwd: document.getElementById('login_pwd').value
    }

    syusyu.common.Ajax.sendJSONRequest('POST', '/fos/login', param, res => {
        if (res) {
            // 이전 페이지로 이동한다.
            location.href = res;
        } else {
            alert("아이디나 비밀번호를 잘못 입력하셨습니다.");
        }
        // result === 'success' -> 메인 화면으로 보내기
        // result === 'fail' -> 아이디 비번 잘못 입력했다고 메시지 띄워주기
    });
}
