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

/**
 * 주어진 비밀번호가 최소 8자리에 숫자, 대문자, 소문자, 특수문자가 각각 1개 이상 포함되어 있는지 검증한다.
 *
 * @param {string} password 검증할 비밀번호 문자열
 * @returns {Boolean} 비밀번호가 유효한 경우 true, 그렇지 않은 경우 false를 반환
 * @author min
 * @since 2023/06/27
 */
const validatePassword = (password) => {
    // 비밀번호가 최소 8자리에 숫자, 대문자, 소문자, 특수문자가 각각 1개 이상 포함되어 있는지 검사하는 정규표현식
    const regex = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z])(?=.*[!@#$%^&*]).{8,16}$/;

    return regex.test(password);
}

/**
 * 수량을 증가/감소시킨다.
 *
 * @param {HTMLButtonElement} button 수량 증가 혹은 감소 버튼 요소
 * @param {HTMLInputElement} input 수량을 표시하는 입력 필드 요소
 * @author min
 * @since 2023/07/03
 */
const updateQty = (button, input) => {
    let quantity = Number(input.value);
    if (button.classList.contains('minus') && quantity > 1) {
        quantity--;
    } else if (button.classList.contains('plus')) {
        quantity++;
    }
    input.value = quantity;
}

/**
 * 주어진 요소의 전화번호를 포맷팅한다.
 *
 * @param {string} elementId 전화번호 포맷팅 대상 요소의 ID
 * @author min
 * @since 2023/08/02
 */
function formatPhoneNumberForElement(elementId) {
    const $phoneNumberElement = document.getElementById(elementId);
    if ($phoneNumberElement) {
        $phoneNumberElement.innerHTML = formatPhoneNumber($phoneNumberElement.innerHTML);
    } else {
        console.error(`Element not found: ${elementId}`);
    }
}

/**
 * 전화번호를 포맷팅한다.
 *
 * @param {string} phoneNumberString 포맷팅할 전화번호 문자열
 * @returns {string} 포맷팅된 전화번호 문자열
 * @author min
 * @since 2023/08/02
 */
function formatPhoneNumber(phoneNumberString) {
    const cleaned = ('' + phoneNumberString).replace(/\D/g, '');
    const match = cleaned.match(/^(\d{3})(\d{4})(\d{4})$/);
    if (match) {
        return match[1] + '-' + match[2] + '-' + match[3];
    }
    return phoneNumberString;
}

/**
 * 금액 천 단위 포맷팅
 *
 * @param {number|string} price 포맷팅할 가격
 * @returns {string} 포맷팅된 가격 문자열
 * @author min
 * @since 2023/07/03
 */
const formatPrice = (price) => {
    if (typeof price !== 'number')
        price = parseInt(price);

    return price.toLocaleString();
}

/**
 * 날짜 선택 필드에 Flatpickr를 설정한다.
 * 주어진 date로 기본 날짜를 설정한다.
 *
 * @param calendarId 날짜 선택 필드의 ID
 * @param date 기본으로 설정할 날짜
 * @author min
 * @since 2023/07/19
 */
const setFlatpickrCalendar = (calendarId, date) => {
    flatpickr('#' + calendarId, {
        'locale': 'ko',
        'defaultDate': date
    });
}

/**
 * 날짜 선택 필드에 Flatpickr를 설정한다.
 * endDate는 오늘로 설정되고, startDate는 endDate로부터 day를 뺀 날짜로 설정된다.
 *
 * @param startDateId 시작 날짜 선택 필드의 ID
 * @param endDateId 종료 날짜 선택 필드의 ID
 * @param day endDate로부터 뺄 일수
 * @author min
 * @since 2023/07/19
 */
const setCalendarRangeByDays = (startDateId, endDateId, day) => {
    if (typeof day !== 'number')
        day = parseInt(day);

    let endDate = new Date();
    let startDate = new Date();
    startDate.setDate(endDate.getDate() - day);

    setFlatpickrCalendar(startDateId, startDate);
    setFlatpickrCalendar(endDateId, endDate);
}

/**
 * 날짜 선택 필드에 Flatpickr를 설정한다.
 * endDate는 오늘로 설정되고, startDate는 endDate로부터 month를 뺀 날짜로 설정된다.
 *
 * @param startDateId 시작 날짜 선택 필드의 ID
 * @param endDateId 종료 날짜 선택 필드의 ID
 * @param month endDate로부터 뺄 월수
 * @author min
 * @since 2023/07/19
 */
const setCalendarRangeByMonths = (startDateId, endDateId, month) => {
    if (typeof month !== 'number')
        month = parseInt(month);

    let endDate = new Date();
    let startDate = new Date();
    startDate.setMonth(endDate.getMonth() - month);

    setFlatpickrCalendar(startDateId, startDate);
    setFlatpickrCalendar(endDateId, endDate);
}

/**
 * Flatpickr를 사용하여 날짜 선택 필드를 설정합니다.
 * startDate는 선택한 날짜 혹은 현재 날짜로 설정되며,
 * endDate는 startDate로부터 day를 더한 날짜로 설정됩니다.
 *
 * @param {string} startDateId - 시작 날짜 선택 필드의 ID
 * @param {string} endDateId - 종료 날짜 선택 필드의 ID
 * @param {number} day - startDate로부터 더할 일 수
 * @author soso
 * @since 2023/07/30
 */
const setCalendarRangeAddDays =(startDateId, endDateId, day) => {
    if (typeof day !== 'number')
        day = parseInt(day);

    let startDate = new Date(document.getElementById(startDateId).value);
    let endDate = new Date(startDate);
    endDate.setDate(startDate.getDate() + day);

    setFlatpickrCalendar(endDateId, endDate);
    setFlatpickrCalendar(startDateId, startDate);
}

/**
 * 현재 날짜와 시간을 'YYYMMDD_HHMM' 형식의 문자열로 반환한다.
 *
 * @returns {string} 현재 날짜와 시간을 나타내는 문자열
 * @author min
 * @since 2023/08/06
 */
const getYYYYMMDDHHMM = () => {
    const now = new Date();
    const year = now.getFullYear();
    const month = String(now.getMonth() + 1).padStart(2, '0');
    const day = String(now.getDate()).padStart(2, '0');
    const hour = String(now.getHours()).padStart(2, '0');
    const minute = String(now.getMinutes()).padStart(2, '0');

    return year + month + day + "_" + hour + minute;
}