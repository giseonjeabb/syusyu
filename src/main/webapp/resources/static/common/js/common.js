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

/**
 * 날짜 선택 필드에 Flatpickr를 설정한다.
 * 주어진 date로 기본 날짜를 설정한다.
 *
 * @param calendarId 날짜 선택 필드의 ID
 * @param date 기본으로 설정할 날짜
 * @author min
 * @since 2023/07/199
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
