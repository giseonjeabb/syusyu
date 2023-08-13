$(document).ready(function () {
    /**
     * "datepicker" 클래스를 가진 HTML 요소에 flatpickr를 적용하는 함수입니다.
     * 적용될 날짜 형식은 "Y-m-d"로 설정되어 있습니다.
     *
     * @returns 이 함수는 리턴 값이 없습니다.
     * @see {@link https://flatpickr.js.org/} flatpickr 공식 문서를 참조하십시오.
     * @author soso
     * @since 2023/07/29
     */
    flatpickr(".datepicker", {
        dateFormat: "Y-m-d"
    });

    /**
     * '#summernote' 셀렉터를 가진 HTML 요소에 Summernote 플러그인을 적용하는 함수입니다.
     * 이는 Rich Text Editor로 사용자에게 다양한 텍스트 스타일링 기능을 제공합니다.
     * 플레이스홀더, 탭 크기, 에디터의 높이 및 도구 모음 설정을 포함합니다.
     *
     * @returns 이 함수는 리턴 값이 없습니다.
     * @see {@link https://summernote.org/} Summernote 공식 문서를 참조하십시오.
     * @author soso
     * @since 2023/07/27
     */
    $('#summernote').summernote({
        placeholder: 'Hello stand alone ui',
        tabsize: 2,
        height: 300,
        toolbar: [
            ['style', ['style']],
            ['font', ['bold', 'underline', 'clear']],
            ['color', ['color']],
            ['para', ['ul', 'ol', 'paragraph']],
            ['table', ['table']],
            ['insert', ['link', 'picture', 'video']],
            ['view', ['fullscreen', 'codeview', 'help']]
        ]
    });

    /**
     * "운동화"와 관련된 소분류 카테고리를 기본으로 표시하고,
     * 사용자가 중분류 카테고리를 클릭하면 해당 중분류에 맞는 소분류 카테고리를 보여주는 함수입니다.
     * 일치하는 경우 해당 요소를 표시하고, 그렇지 않은 경우 해당 요소를 숨깁니다.
     *
     * @author soso
     * @since 2023/07/27
     */
    const small = $('#cate_small').children();
    $(small).hide();
    for (let i = 0; i < small.length; i++) {
        if (small[i].dataset.smallKey === '1') {
            $(small[i]).show();
        }
    }
    $('#cate_middle').change(function () {
        const middle = $(this).val(); // 선택된 option 값 가져오기

        for (let i = 0; i < small.length; i++) {
            if (small[i].dataset.smallKey == middle) {
                $(small[i]).show();
            } else {
                $(small[i]).hide();
            }
        }
    });


    /**
     * '설정함' 버튼을 클릭하면 할인 설정 내용을 보여주고,
     * '설정안함' 버튼을 클릭하면 할인 설정 내용을 숨깁니다.
     *
     * @author soso
     * @since 2023/07/28
     */
// 할인 설정 내용을 참조하고 숨깁니다.
    const dcContent = $('.dc_content').hide();
    $('#dc_btnradio').click(function () {
        dcContent.show(); // "설정함" 클릭시 행을 보여줍니다.
    });

    $('#dc_btnradio_no').click(function () {
        dcContent.hide(); // "설정안함" 클릭시 행을 숨깁니다.
    });

    /**
     * 할인 기간 설정 기능
     *
     * - 체크박스가 선택되면:
     *  1. 기간 설정 옵션을 활성화합니다.
     *  2. 오늘 날짜를 시작 날짜로 설정합니다.
     *  3. 체크된 라디오 버튼에 따라 종료 날짜를 설정합니다.
     *  4. 각 라디오 버튼에 이벤트 리스너를 추가하여 선택 변경 시 종료 날짜를 자동으로 조정합니다.
     *
     * - 체크박스 선택이 해제되면:
     *  1. 기간 설정 옵션을 비활성화합니다.
     *  2. 시작 및 종료 날짜를 초기화합니다.
     *
     * - 페이지 로드 시 체크박스의 초기 상태에 따라 기간 설정 옵션의 가시성을 설정합니다.
     *
     * @author soso
     * @since 2023/07/29
     */
        // 오늘날짜 생성합니다.
    let today = new Date();

    // 할인 기간 설정 체크박스와 기간 설정 옵션을 참조합니다.
    let checkBox = $("#dc_date_chk");
    let dateDiv = $("#dc_date");

    // 체크박스의 상태가 바뀔 때마다 이벤트 핸들러를 실행합니다.
    checkBox.change(function () {
        if (checkBox.is(':checked')) {
            // 체크박스가 선택되면 기간 설정 옵션을 보여줍니다.
            dateDiv.removeClass("d-none");
            /// 오늘 날짜를 시작 날짜로 설정합니다.
            setFlatpickrCalendar('dc_start_date', today);

            // 체크된 라디오 버튼의 data-interval 값을 가져옵니다.
            let checkedRadio = document.querySelector('.dc_date_range:checked');
            let interval = parseInt(checkedRadio.getAttribute('data-interval'));

            setCalendarRangeAddDays('dc_start_date', 'dc_end_date', interval);

            document.querySelectorAll('.dc_date_range').forEach((radio) => {
                // 각 할인 기간 설정 옵션에 이벤트 리스너를 추가합니다.
                radio.addEventListener('change', (event) => {
                    // 선택된 옵션에 따라 종료 날짜를 자동으로 설정합니다.
                    let interval = parseInt(event.target.getAttribute('data-interval'));
                    // setCalendarRangeAddDays 함수를 사용해 sale_start_date로부터 interval 만큼의 일 수를 더한 날짜를 sale_end_date 필드에 설정합니다.
                    setCalendarRangeAddDays('dc_start_date', 'dc_end_date', interval);
                });
            });
        } else {
            // 체크박스 선택이 해제되면 기간 설정 옵션을 숨기고, 시작 날짜와 종료 날짜를 null로 설정합니다.
            dateDiv.addClass("d-none");
            $("#dc_start_date").val(null);
            $("#dc_end_date").val(null);
        }
    });

   // 페이지 로드 시 체크박스 상태에 따라 캘린더의 가시성을 설정
    if (checkBox.is(':checked')) {
        dateDiv.show(); // show div
    } else {
        dateDiv.hide(); // hide div
    }

    /**
     * 사용자가 판매 기간 설정을 원할 경우 해당 설정 부분을 보여주고,
     * 설정하지 않을 경우 숨깁니다.
     * 페이지 로드 시 기본적으로 판매 기간 설정 부분은 숨겨져 있습니다('.sale_date' 요소).
     * 판매 시작일을 오늘 날짜로 기본 설정하고,
     * 판매 기간을 선택하는 라디오 버튼을 클릭하면 해당 기간만큼 판매 종료일이 자동으로 설정됩니다.
     *
     * @function '$("#sale_btnradio").click' - '설정함' 버튼을 클릭하면 판매 기간 설정 부분을 보여줍니다.
     * @function '$("#sale_btnradio_no").click' - '설정안함' 버튼을 클릭하면 판매 기간 설정 부분을 숨깁니다.
     * @function 'radio.addEventListener' - 각 라디오 버튼에 이벤트 리스너를 추가합니다. 선택된 버튼의 data-interval 속성값만큼 판매 시작일에 더하여 판매 종료일을 설정합니다.
     * @author soso
     * @since 2023/07/29
     */
    const saleDate = $('.sale_date').hide()

    $('#sale_btnradio').click(function () {
        saleDate.show(); // "설정함" 클릭시 행을 보여줍니다.
    });

    $('#sale_btnradio_no').click(function () {
        saleDate.hide(); // "설정안함" 클릭시 행을 숨깁니다.
    });

    // 판매 시작일을 오늘 날짜로 기본 설정합니다.
    setFlatpickrCalendar('sale_start_date', today);
    // 판매 종료일을 2099년 12월 31일로 초기 설정합니다.
    setFlatpickrCalendar('sale_end_date', new Date(2099, 11, 31));  // 11은 12월을 의미합니다. (월은 0부터 시작)

    // 문서 내의 모든 라디오 버튼을 선택합니다.
    document.querySelectorAll('.sale_date_range').forEach((radio) => {
        // 각 라디오 버튼에 이    벤트 리스너를 추가합니다.
        radio.addEventListener('change', (event) => {
            // 선택된 라디오 버튼의 data-interval 속성값을 가져옵니다.
            let interval = parseInt(event.target.getAttribute('data-interval'));
            // 판매 시작일로부터 interval 만큼의 일 수를 더한 날짜를 판매 종료일 필드에 설정합니다.
            setCalendarRangeAddDays('sale_start_date', 'sale_end_date', interval);
        });
    });

    /**
     * 할인율 입력 필드의 값이 변경될 때 유효성 검사를 수행하고 할인가격을 계산합니다.
     * @function 'productPerInput.addEventListener' - 할인율 입력 필드 값 변경 시 유효성 검사 및 할인가격 계산을 수행합니다.
     * @author soso
     * @since 2023/07/29
     */
    const productPerInput = document.getElementById('product_per');
    productPerInput.addEventListener('input', function () {
        validateNumericInput(this);
        removeLeadingZeros(this);
        validateDiscountInput(this);
        calculateDiscountPrice();
    });

    /**
     * 상품가격 입력 필드의 값이 변경될 때 유효성 검사를 수행하고, 가격 포맷을 조정합니다.
     * 가격포맷: 숫자만 입력, 천 단위 콤마, 1의자리 0확인. 할인가계산
     * @function 'productPriceInput.addEventListener' - 상품가격 입력 필드 값 변경 시 유효성 검사 및 가격 포맷 조정을 수행합니다.
     * @author soso
     * @since 2023/07/30
     */
    const productPriceInput = document.getElementById('product_price');
    productPriceInput.addEventListener('input', function () {
        validateNumericInput(this);
        removeLeadingZeros(this);
        this.value = formatWithComma(this);
        validateLastDigit(this);
    });

    /**
     * 매입가격 입력 필드의 값이 변경될 때 유효성 검사를 수행하고, 가격 포맷을 조정합니다.
     * 가격포맷: 숫자만 입력, 천단위콤마, 마지막숫자 확인.
     * @function 'productBuyPriceInput.addEventListener' - 매입가격 입력 필드 값 변경 시 유효성 검사 및 가격 포맷 조정을 수행합니다.
     * @author soso
     * @since 2023/07/29
     */
    const productBuyPriceInput = document.getElementById('product_buy_price');
    productBuyPriceInput.addEventListener('input', function () {
        validateNumericInput(this);
        removeLeadingZeros(this);
        this.value = formatWithComma(this);
        validateLastDigit(this);
    });

    /**
     * 색상 입력 필드에서 입력값의 유효성을 검사합니다.
     * 유효성검사: 한단어만, 숫자,특수문자제외
     * @function 'colorInput.addEventListener' - 색상 입력 필드에서 값 변경 시 한 단어만, 숫자, 특수문자제외 유효성 검사를 수행합니다.
     * @author soso
     * @since 2023/07/29
     */
    const colorInput = document.getElementById('input_color');
    colorInput.addEventListener('blur', function () {
        validateOneWordInput(this);
    });

    /**
     * 사이즈 입력 필드의 값이 변경될 때 유효성 검사를 수행합니다.
     * 유효성검사: 숫자, 콤마, 스페이스만 입력, 첫단어 0제거
     * @function 'sizeInput.addEventListener' - 사이즈 입력 필드에서 값 변경 시 유효성 검사를 수행합니다.
     * @author soso
     * @since 2023/07/29
     */
    const sizeInput = document.getElementById('input_size');
    sizeInput.addEventListener('input', function () {
        validateNumericCommaSpaceInput(this);
        removeLeadingZeros(this);
    });

    /**
     * "옵션목록으로 적용" 버튼에 클릭 이벤트 리스너를 등록합니다.
     * @function 'document.getElementById('btnOpt').addEventListener' - '옵션목록으로 적용' 버튼 클릭 시, applyOptions 함수를 호출합니다.
     * @author soso
     * @since 2023/07/30
     */
    document.getElementById('btnOpt').addEventListener('click', applyOptions);

    /**
     * "선택삭제" 버튼에 클릭 이벤트 핸들러를 등록합니다.
     * @function 'document.getElementById('chk_del').addEventListener' - '선택삭제' 버튼 클릭 시, 체크된 항목들을 삭제하고 총 재고 수량을 업데이트합니다.
     * @author soso
     * @since 2023/07/30
     */
    document.getElementById('chk_del').addEventListener('click', function () {
        // 모든 체크박스를 가져옵니다.
        const checkboxes = document.querySelectorAll('.opt_chk input');

        // 각 체크박스에 대해
        checkboxes.forEach(checkbox => {
            // 만약 체크박스가 체크되어 있다면
            if (checkbox.checked) {
                // 체크박스가 있는 행을 삭제합니다.
                checkbox.parentNode.parentNode.remove();
            }
        });
        // 총 재고 수량 업데이트
        updateTotalQuantity();
    });

    /**
     * 이미지 추가 버튼에 클릭 이벤트를 달아주는 함수를 호출합니다.
     * @function 'document.getElementById("addImgBtn").addEventListener' - '이미지 추가' 버튼 클릭 시, addImageInput 함수를 호출합니다.
     * @author soso
     * @since 2023/07/31
     */
    document.getElementById("addImgBtn").addEventListener("click", addImageInput);

    /**
     * 취소 버튼에 클릭 이벤트 핸들러를 등록합니다.
     * @function 'document.getElementById("cancelBtn").addEventListener' - '취소' 버튼 클릭 시, 사용자에게 수정된 내용이 있다고 알리고, 페이지 이동을 확인합니다.
     * @author soso
     * @since 2023/07/31
     */
    document.getElementById("cancelBtn").addEventListener("click", function (event) {
        let confirmation = confirm("수정된 내용이 있습니다. 페이지를 나가시겠습니까?");
        if (!confirmation) {
            event.preventDefault(); // 페이지 이동을 막음
        } else {
            window.location.href = "/admin/dashboard"; // 페이지 이동
        }
    });

});

/**
 * "옵션목록으로 적용" 버튼을 클릭하면 실행되는 함수입니다.
 * 입력한 색상과 사이즈를 바탕으로 새로운 행을 생성하고, 기타 설정값을 설정합니다.
 * 이 함수는 중복되는 사이즈를 입력했을 때 알림을 보냅니다.
 *
 * @function applyOptions - "옵션목록으로 적용" 버튼 클릭 시 실행되는 함수입니다. 새로운 행을 생성하고, 필요한 값을 설정합니다.
 * @author soso
 * @since 2023/07/30
 */
function applyOptions() {
    const colorInput = document.getElementById('input_color');
    const sizeInput = document.getElementById('input_size');

    // 사이즈를 ', ' ',' ' ,'기준으로 잘라서 각각의 사이즈에 대해
    const sizes = sizeInput.value.split(/\,\s*/);

    for (let i = 0; i < sizes.length; i++) {
        // 모든 행의 사이즈 값을 가져와서 배열로 만듭니다.
        let currentSizes = Array.from(document.querySelectorAll('.opt_size')).map(td => td.textContent);

        // 사이즈 값이 이전에 입력한 값과 같은지 확인
        if (currentSizes.includes(sizes[i])) {
            alert('이미 입력된 사이즈가 있습니다: ' + sizes[i]);
            continue;  // 중복된 사이즈를 입력하면 무시하고 다음 사이즈로 넘어갑니다.
        }

        // 새로운 행을 만들어 테이블에 추가
        let row = document.createElement('tr');

        // 체크박스 생성
        let checkBoxCell = document.createElement('td');
        checkBoxCell.classList.add('opt_chk', 'text-center', 'align-middle');
        let checkboxInput = document.createElement('input');
        checkboxInput.type = "checkbox";
        checkBoxCell.appendChild(checkboxInput);
        row.appendChild(checkBoxCell);

        // 색상
        let colorCell = document.createElement('td');
        colorCell.classList.add('opt_color', 'text-center', 'align-middle');
        colorCell.textContent = colorInput.value;
        row.appendChild(colorCell);

        // 사이즈
        let sizeCell = document.createElement('td');
        sizeCell.classList.add('opt_size', 'text-center', 'align-middle');
        sizeCell.textContent = sizes[i];
        row.appendChild(sizeCell);

        // 옵션가가격 설정
        let priceCell = document.createElement('td');
        priceCell.classList.add('text-center', 'ileen-mellinrant');
        let priceInput = document.createElement('input');
        priceInput.classList.add('opt_price', 'border-0', 'w-100');
        priceInput.type = "text";
        priceInput.min = "0";
        priceInput.oninput = function () {
            this.value = this.value.replace(/[^0-9]/g, '');
            if (this.value.startsWith('0')) {
                this.value = this.value.substr(1)
            }
        };
        priceInput.onblur = function () {
            let price = Number(this.value.replace(/[^0-9]/g, ''));
            price = Math.floor(price / 10) * 10;  // 1의 자리를 버림
            this.value = price.toLocaleString('en');
        };
        priceInput.value = "0";
        priceCell.appendChild(priceInput);
        row.appendChild(priceCell);

        // 재고 수량 설정
        let qtyCell = document.createElement('td');
        qtyCell.classList.add('text-center', 'align-middle');
        let qtyInput = document.createElement('input');
        qtyInput.classList.add('opt_inv_qty', 'border-0', 'w-100');
        qtyInput.type = "text";
        qtyInput.min = "0";
        qtyInput.oninput = function () {
            this.value = this.value.replace(/[^0-9]/g, '');
            if (this.value.startsWith('0')) {
                this.value = this.value.substr(1)
            }
        };
        qtyInput.onblur = function () {
            let qty = Number(this.value.replace(/[^0-9]/g, ''));
            this.value = qty.toLocaleString('en');
        };
        qtyInput.value = "0";
        qtyCell.appendChild(qtyInput);
        row.appendChild(qtyCell);

        // 판매상태
        let statusCell = document.createElement('td');
        statusCell.classList.add('opt_status', 'text-center', 'align-middle');
        statusCell.setAttribute('value', '603');
        statusCell.textContent = '품절';
        row.appendChild(statusCell);

        // 사용여부
        let ynCell = document.createElement('td');
        ynCell.classList.add('text-center', 'align-middle');
        let ynSelect = document.createElement('select');
        ynSelect.classList.add('opt_YN', 'form-select', 'border-0', 'w-100');
        let optionY = document.createElement('option');
        optionY.value = 'Y';
        optionY.textContent = 'Y';
        ynSelect.appendChild(optionY);
        let optionN = document.createElement('option');
        optionN.value = 'N';
        optionN.textContent = 'N';
        ynSelect.appendChild(optionN);
        ynCell.appendChild(ynSelect);
        row.appendChild(ynCell);

        // 삭제버튼
        let delCell = document.createElement('td');
        let delBtn = document.createElement('button');
        delBtn.type = 'button';
        delBtn.classList.add('btn', 'btn-outline-dark', 'align-middle', 'justify-content-center', 'align-items-center');
        let delIcon = document.createElement('i');
        delIcon.classList.add('fas', 'fa-times', 'align-middle');
        delBtn.appendChild(delIcon);
        delCell.appendChild(delBtn);
        row.appendChild(delCell);

        // 삭제 버튼에 이벤트 리스너 추가
        delBtn.addEventListener('click', function () {
            // 행 삭제
            row.remove();

            // 총 재고 수량 업데이트
            updateTotalQuantity();

            // 현재 페이지의 사이즈 값 업데이트
            updateCurrentSizes();
        });

        // 완성된 행을 테이블에 추가
        document.getElementById('opt_table').appendChild(row);

        // 입력 필드 비활성화
        colorInput.disabled = true;
        // 사이즈 입력 필드 초기화
        sizeInput.value = '';

        // 사이즈 입력 필드에 입력 이벤트 리스너를 추가
        sizeInput.addEventListener('input', function () {
            const newSizeValues = this.value.split(/\,\s*/);
            this.value = newSizeValues.join(', ');
        });

        // 재고 수량이 변경될 때 판매 상태 업데이트
        qtyInput.addEventListener('input', function () {
            updateSaleStatus(this, statusCell);
            updateTotalQuantity();
        });
    }
}

/**
 * 글자수 60까지
 * 텍스트의 길이를 갱신하여 화면에 표시하는 함수입니다.
 * 현재 입력된 텍스트의 길이를 "/60" 형식으로 표시합니다.
 * 이 함수는 텍스트 입력 시 호출됩니다.
 *
 * @function updateLengthSixty - 입력된 텍스트의 길이를 갱신하고 화면에 표시하는 함수입니다.
 * @param {HTMLElement} input - 텍스트 길이를 확인할 입력 요소입니다.
 * @author soso
 * @since 2023/07/29
 */
function updateLengthSixty(input) {
    // 현재 텍스트의 길이를 가져옵니다
    let length = input.value.length;

    // 현재 input 요소와 관련된 text_length 요소를 찾습니다
    let lengthDisplay = input.nextElementSibling;

    // 길이를 갱신합니다
    lengthDisplay.textContent = length + "/60";
}


/**
 * 글자수 100까지
 * 텍스트의 길이를 갱신하여 화면에 표시하는 함수입니다.
 * 현재 입력된 텍스트의 길이를 "/100" 형식으로 표시합니다.
 * 이 함수는 텍스트 입력 시 호출됩니다.
 *
 * @function updateLengthHundred - 입력된 텍스트의 길이를 갱신하고 화면에 표시하는 함수입니다.
 * @param {HTMLElement} input - 텍스트 길이를 확인할 입력 요소입니다.
 * @author soso
 * @since 2023/07/31
 */
function updateLengthHundred(input) {
    // 현재 텍스트의 길이를 가져옵니다
    let length = input.value.length;

    // 현재 input 요소와 관련된 text_length 요소를 찾습니다
    let lengthDisplay = input.nextElementSibling;

    // 길이를 갱신합니다
    lengthDisplay.textContent = length + "/100";
}


/**
 * 한단어만 입력받기
 * 입력된 텍스트를 검증하여 조건에 맞지 않는 문자를 제거하는 함수입니다.
 * 이 함수는 문자열에 대해 다음의 변환을 수행합니다.
 * 1. 숫자와 특수문자를 제거합니다.
 * 2. 이중 공백을 제거합니다.
 * 3. 첫 단어만 허용하고 그 이후의 단어는 모두 제거합니다.
 *
 * @function validateOneWordInput - 입력된 텍스트를 검증하고 조건에 맞지 않는 문자를 제거하는 함수입니다.
 * @param {HTMLElement} input - 검증 및 변환을 수행할 입력 요소입니다.
 * @author soso
 * @since 2023/07/30
 */
function validateOneWordInput(input) {
    input.value = input.value.replace(/[^a-zA-Z가-힣\s]/g, ''); // 숫자, 특수문자 제거
    input.value = input.value.replace(/(\s)(?=\s)/g, ''); // 이중 공백 제거
    input.value = input.value.split(' ')[0]; // 첫 단어만 허용
}

/**
 * 숫자만을 입력 받도록 하는 함수입니다.
 * 문자 입력시 문자는 제거됩니다.
 *
 * @function validateNumericInput - 숫자만을 입력받는 함수입니다.
 * @param {HTMLElement} input - 검증 및 변환을 수행할 입력 요소입니다.
 * @author soso
 * @since 2023/07/29
 */
function validateNumericInput(input) {
    input.value = input.value.replace(/[^0-9]/g, '');
}

/**
 * 입력된 문자열에서 맨 앞의 연속된 0들을 제거하는 함수입니다.
 *
 * @function removeLeadingZeros - 맨 앞의 연속된 0들을 제거하는 함수입니다.
 * @param {HTMLElement} input - 변환을 수행할 입력 요소입니다.
 * @author soso
 * @since 2023/07/29
 */
function removeLeadingZeros(input) {
    input.value = input.value.replace(/^0+(?=\d)/, '');
}

/**
 * 입력된 문자열에서 마지막 문자가 0인지 확인하는 함수입니다.
 * 만약 0이 아니라면 입력 요소에 'is-invalid' 클래스(경고)를 추가하고,
 * 0이라면 'is-valid' 클래스를 추가합니다.
 *
 * @function validateLastDigit - 마지막 문자가 0인지 확인하는 함수입니다.
 * @param {HTMLElement} input - 검증을 수행할 입력 요소입니다.
 * @author soso
 * @since 2023/07/29
 */
function validateLastDigit(input) {
    // 숫자만 남기고 나머지는 제거
    const numberOnly = input.value.replace(/[^0-9]/g, '');

    // 마지막 숫자가 0이 아닌지 확인
    if (numberOnly[numberOnly.length - 1] !== '0') {
        $(input).removeClass('is-valid');
        $(input).addClass('is-invalid');
    } else {
        $(input).removeClass('is-invalid');
        $(input).addClass('is-valid');
    }
}

/**
 * 숫자와 콤마, 스페이스만을 입력 받도록 하는 함수입니다.
 * 문자 입력시 문자는 제거됩니다.
 *
 * @function validateNumericCommaSpaceInput - 숫자와 콤마, 스페이스만을 입력받는 함수입니다.
 * @param {HTMLElement} input - 검증 및 변환을 수행할 입력 요소입니다.
 * @author soso
 * @since 2023/07/29
 */
function validateNumericCommaSpaceInput(input) {
    input.value = input.value.replace(/[^0-9, ]/g, '');
}

/**
 * 입력된 문자열을 천 단위로 콤마가 포함된 형식으로 변환하는 함수입니다.
 *
 * @function formatWithComma - 입력된 문자열을 천 단위로 콤마가 포함된 형식으로 변환하는 함수입니다.
 * @param {HTMLElement} input - 변환을 수행할 입력 요소입니다.
 * @author soso
 * @since 2023/07/29
 */
function formatWithComma(input) {
    // 숫자만 추출
    const numberOnly = input.value.replace(/[^0-9]/g, '');
    // 천 단위로 콤마 추가
    return numberOnly.replace(/\B(?=(\d{3})+(?!\d))/g, ",");
}

/**
 * 입력된 문자열이 100 이상인지 확인하고, 100 이상이면 99로 변환하는 함수입니다.
 *
 * @function validateDiscountInput - 입력된 문자열이 100 이상인지 확인하고, 100 이상이면 99로 변환하는 함수입니다.
 * @param {HTMLElement} input - 검증 및 변환을 수행할 입력 요소입니다.
 * @author soso
 * @since 2023/07/29
 */
function validateDiscountInput(input) {
    let inputValue = input.value;
    inputValue = inputValue.replace(/[^0-9]/g, '');
    if (parseInt(inputValue) > 100) {
        inputValue = '99';
    }
    input.value = inputValue;
}

/**
 * 제품의 할인된 가격을 계산하는 함수입니다.
 * 제품의 가격과 할인율을 이용하여 할인 가격을 계산합니다.
 * 제품의 가격이 1000 이상이면 할인 금액을 표시합니다.
 *
 * @function calculateDiscountPrice - 제품의 할인된 가격을 계산하는 함수입니다.
 * @author soso
 * @since 2023/07/29
 */
function calculateDiscountPrice() {
    // 제품 가격을 가져옵니다. 숫자가 아닌 문자는 제거합니다.
    const productPrice = parseInt(document.getElementById('product_price').value.replace(/[^0-9]/g, ''));

    // 할인율을 가져옵니다. 숫자가 아닌 문자는 제거합니다.
    const discountRate = parseInt(document.getElementById('product_per').value.replace(/[^0-9]/g, ''));

    // 제품 가격이나 할인율이 숫자가 아니라면 할인 가격을 0원으로 설정합니다.
    if (isNaN(productPrice) || isNaN(discountRate)) {
        document.getElementById('dcPrice').value = '0원';
    } else {
        // 할인 가격을 계산합니다.
        const discountAmount = productPrice * (100 - discountRate) / 100;

        // 할인 가격에 천 단위 콤마를 추가합니다.
        const numberWithComma = discountAmount.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");

        let discountedPrice = numberWithComma + '원';
        let discount = '';

        // 제품 가격이 1000 이상이면 할인 금액을 표시합니다.
        if (productPrice >= 1000) {
            // 할인 금액에 천 단위 콤마를 추가합니다.
            discount = (productPrice - discountAmount).toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");

            // 할인된 가격과 할인 금액을 함께 표시합니다.
            discountedPrice += ' ( ' + discount + '원 할인 )';

            // 할인 금액 표시를 활성화합니다.
            document.getElementById('dc_price').style.display = 'block';
        } else {
            // 제품 가격이 1000 미만이면 할인 금액 표시를 숨깁니다.
            document.getElementById('dc_price').style.display = 'none';
        }
        // 할인된 가격을 설정합니다.
        document.getElementById('dcPrice').value = discountedPrice;
    }
}

/**
 * 총 재고 수량을 계산하는 함수입니다.
 * 모든 재고 입력 필드의 값을 더하여 총 재고 수량을 계산하고, 이 값을 화면에 표시합니다.
 *
 * @function updateTotalQuantity - 총 재고 수량을 계산하는 함수입니다.
 * @author soso
 * @since 2023/07/30
 */
function updateTotalQuantity() {
    const qtyInputs = Array.from(document.querySelectorAll('.opt_inv_qty'));
    let totalQuantity = qtyInputs.reduce((total, input) => {
        let value = parseInt(input.value.replace(/,/g, ''), 10);
        return total + value;
    }, 0);
    document.getElementById('tot_qty').value = totalQuantity.toLocaleString('en');
}


/**
 * 재고 수량에 따라 판매 상태를 업데이트하는 함수입니다.
 * 재고 수량이 0보다 크면 상태를 '판매중'으로 업데이트하고,
 * 그렇지 않으면 '품절'로 업데이트합니다.
 *
 * @function updateSaleStatus - 재고 수량에 따른 판매 상태를 업데이트하는 함수입니다.
 * @param {HTMLInputElement} input - 재고 수량 입력 필드입니다.
 * @param {HTMLTableCellElement} statusCell - 판매 상태를 표시하는 테이블 셀입니다.
 * @author soso
 * @since 2023/07/30
 */
function updateSaleStatus(input, statusCell) {
    // 재고 수량이 0보다 크면 판매 상태를 '판매중'으로 업데이트하고,
    // 그렇지 않으면 '품절'로 업데이트합니다.
    if (parseInt(input.value, 10) > 0) {
        statusCell.textContent = '판매중';
        statusCell.setAttribute('value', '601');
    } else {
        statusCell.textContent = '품절';
        statusCell.setAttribute('value', '603');
    }
}

/**
 * 현재 페이지의 사이즈 값을 업데이트하는 함수입니다.
 * 모든 사이즈 입력 필드의 값을 가져와 currentSizes 배열을 업데이트합니다.
 *
 * @function updateCurrentSizes - 현재 페이지의 사이즈 값을 업데이트하는 함수입니다.
 * @author soso
 * @since 2023/07/30
 */
function updateCurrentSizes() {
    // 모든 사이즈 입력 필드의 값을 가져와서 currentSizes 배열을 업데이트합니다.
    currentSizes = Array.from(document.querySelectorAll('.opt_size input')).map(input => input.value);
}

/**
 * 파일의 확장자를 검사하여, 허용된 이미지 파일 형식인지 확인하는 함수입니다.
 * 허용된 확장자에는 "jpg", "jpeg", "gif", "png", "bmp"가 있습니다.
 *
 * @function validateFile - 파일 유효성을 검사하는 함수입니다.
 * @param {File} file - 유효성을 검사할 파일입니다.
 * @returns {boolean} - 파일 확장자가 허용된 확장자 목록에 포함되어 있으면 true,
 *                      그렇지 않으면 false를 반환합니다.
 * @author soso
 * @since 2023/07/31
 */
function validateFile(file) {
    // 허용된 확장자 목록입니다.
    const allowedExtensions = ["jpg", "jpeg", "gif", "png", "bmp"];
    // 파일 이름에서 확장자를 추출합니다.
    const fileExtension = file.name.split('.').pop().toLowerCase();
    // 추출된 확장자가 허용된 확장자 목록에 포함되어 있는지 확인합니다.
    return allowedExtensions.includes(fileExtension);
}


/**
 * 파일 입력 필드에서 파일을 선택하면 호출되는 유효성 검사 함수입니다.
 * 선택된 파일이 이미지 파일 형식이 아니면 경고 메시지를 표시하고 입력 필드를 비웁니다.
 *
 * @function validateFileInput - 파일 입력 필드의 유효성을 검사하는 함수입니다.
 * @param {HTMLInputElement} input - 파일을 입력받는 필드입니다.
 * @author soso
 * @since 2023/07/31
 */
function validateFileInput(input) {
    // 입력 필드에서 파일을 가져옵니다.
    const file = input.files[0];
    // 파일이 존재하며, 파일 유효성 검사에 실패하면 경고 메시지를 표시합니다.
    if (file && !validateFile(file)) {
        alert("잘못된 파일입니다. 유효한 이미지 파일을 선택해 주세요.");
        // 유효하지 않은 파일이 선택된 경우, 입력 필드를 비웁니다.
        input.value = "";
    }
}

/**
 * 버튼이 클릭될 때마다 실행되어,
 * 이미지 파일을 추가할 새로운 입력 필드를 생성하는 함수입니다.
 * 이미 9개의 이미지 입력 필드가 생성된 경우,
 * 추가 입력 필드를 생성하지 않고 경고 메시지를 표시합니다.
 *
 * @function addImageInput - 이미지 입력 필드를 추가하는 함수입니다.
 * @author soso
 * @since 2023/07/31
 */
function addImageInput() {
    // 현재 페이지에서 클래스명이 'smlImg'인 요소들의 수를 세어 이미지 입력 필드의 수를 확인합니다.
    const currentImgCount = document.getElementsByClassName('smlImg').length;
    // 이미지 입력 필드가 9개 미만인 경우에만 추가 입력 필드를 생성합니다.
    if (currentImgCount < 9) {
        // 새로운 입력 필드를 생성합니다.
        const input = document.createElement("input");
        // 생성된 입력 필드에 클래스명과 타입, onchange 이벤트 리스너를 설정합니다.
        input.setAttribute("class", "smlImg form-control");
        input.setAttribute("type", "file");
        input.setAttribute("onchange", "validateFileInput(this)");

        // 생성된 입력 필드를 'imgInfo'라는 id를 가진 div 요소 안에 추가합니다.
        document.getElementById("imgInfo").appendChild(input);
    } else {
        // 이미지 입력 필드가 이미 9개 생성되어 있는 경우, 경고 메시지를 표시합니다.
        alert('9개의 이미지까지만 추가할 수 있습니다.');
    }
}


/**
 * 사용자가 선택한 대표이미지와 추가 이미지들을 가져와 파일 유효성을 검사하는 함수입니다.
 * 파일 유효성 검사가 통과된 경우, 대표 이미지 파일과 추가 이미지 파일들을 객체로 반환합니다.
 *
 * @function getAndValidateImages - 이미지 데이터를 가져와 유효성을 검사하고 반환하는 함수입니다.
 * @returns {Object} 유효성을 통과한 대표 이미지와 추가 이미지 파일들의 객체,
 *          또는 유효성 검사에 실패한 경우 null
 * @author soso
 * @since 2023/07/31
 */
function getAndValidateImages() {
    // 대표이미지와 추가 이미지 입력 필드를 가져옵니다.
    let repImgInput = document.getElementById('repImg');
    let smlImgInputs = document.getElementsByClassName('smlImg');

    // 검증할 파일들을 저장할 배열을 생성합니다.
    let filesToValidate = [];

    // 대표이미지 파일이 있으면 검증할 파일 배열에 추가합니다.
    if (repImgInput.files[0]) {
        filesToValidate.push(repImgInput.files[0]);
    } else {
        // 대표 이미지 파일이 없으면 경고 메시지를 표시하고 null을 반환합니다.
        alert("대표 이미지를 선택해주세요.");
        return null;
    }

    // 추가 이미지 파일들을 검증할 파일 배열에 추가합니다.
    // 단, 파일이 선택된 입력 필드만 추가됩니다.
    for (let i = 0; i < smlImgInputs.length; i++) {
        if (smlImgInputs[i].files[0]) {
            filesToValidate.push(smlImgInputs[i].files[0]);
        }
    }

    // 파일 유효성 검사를 진행합니다.
    for (let i = 0; i < filesToValidate.length; i++) {
        if (!validateFile(filesToValidate[i])) {
            // 유효하지 않은 파일이 발견되면 경고 메시지를 표시하고 null을 반환합니다.
            alert("유효하지 않은 파일이 포함되어 있습니다.");
            return null;
        }
    }

    // 모든 파일이 유효성 검사를 통과하면,
    // 대표 이미지 파일과 추가 이미지 파일들을 객체로 반환합니다.
    return {
        repImgFile: repImgInput.files[0],  // 대표 이미지 파일
        smlImgFiles: Array.from(smlImgInputs).map(input => input.files[0]).filter(file => file) // 선택된 파일이 있는 입력 필드만 반환
    };
}

/**
 * 사용자가 제공한 상품 정보를 수집하고, 해당 정보를 서버에 전송하여 상품을 등록하는 함수입니다.
 *
 * 각 상품의 정보, 가격, 옵션값, 옵션명, 옵션가격, 재고수량 등을 수집하고,
 * 수집된 데이터는 JSON 형태로 변환되어 서버에 전송됩니다.
 * 또한 사용자가 선택한 이미지도 FormData 객체에 추가하여 같이 전송합니다.
 *
 * 이 함수는 jQuery의 $.ajax() 메서드를 사용하여 서버에 데이터를 전송하고,
 * 성공적으로 데이터를 전송한 후에는 알림 메시지를 표시하고 대시보드 페이지로 이동합니다.
 *
 * 에러 발생 시 콘솔에 에러 메시지를 출력합니다.
 *
 * 주의: 입력 필드의 유효성 검사나 서버 응답 처리 등에 대한 로직은 이 함수에 포함되어 있지 않습니다.
 *
 * @returns {Object} JSON 형태의 상품 데이터를 반환합니다.
 * @property {Object} product 상품 정보를 담은 객체
 * @property {Object} price 상품 가격 정보를 담은 객체
 * @property {Array} optPrices 옵션 가격을 담은 배열
 * @property {Array} optInvQtys 재고 수량을 담은 배열
 * @property {Array} optItemNms 옵션 이름을 담은 배열
 * @property {Array} optGrpNms 옵션 그룹 이름을 담은 배열
 * @property {Object} repImgFile 대표 이미지 파일
 * @property {Array} smlImgList 소형 이미지 파일 리스트
 *
 * @function productRegisterSave
 * @author  soso
 * @date    2023/07/28
 */
function productRegisterSave() {
    const cateList = JSON.parse(document.getElementById('jsonCateList').value);
    const selectLarge = document.getElementById("cate_large");
    const selectMiddle = document.getElementById("cate_middle");
    const selectSmall = document.getElementById("cate_small");

    let productCateId = null;
    cateList.forEach((cate) => {
        if (parseInt(selectSmall.value) === cate.smallNo && parseInt(selectMiddle.value) === cate.middleNo && parseInt(selectLarge.value) === cate.largeNo) {
            console.log(cate.cateId);
            productCateId = cate.cateId;
        }
    });

    // 상품정보
    let product = {
        prodNm: document.getElementById('product_name').value,
        cateId: productCateId,
        brndId: document.getElementById('product_brand').value,
        modelNm: document.getElementById('product_model').value,
        mfgdMatr: document.getElementById('mfgdMatr').value,
        mftco: document.getElementById('mftco').value,
        mftNatn: document.getElementById('mftNatn').value,
        rlesDt: document.getElementById('rles_dt').value,
        prodDtlDesc: $('#summernote').summernote('code'),
        dlvChgDtl: document.getElementById('dlvChgDtl').value,
        status: 601
    };

    //가격
    let price = {
        salePrc: document.getElementById('product_price').value.replace(/,/g, ""),
        buyPrc: document.getElementById('product_buy_price').value.replace(/,/g, ""),
        dcPer: document.getElementById('product_per').value,
        saleStDttm: document.getElementById('sale_start_date').value,
        saleEdDttm: document.getElementById('sale_end_date').value,
        dcStDttm: document.getElementById('dc_start_date').value,
        dcEdDttm: document.getElementById('dc_end_date').value,
    };

    //옵션값, 옵션명, 옵션가격, 재고수량
    let optPrices = Array.from(document.querySelectorAll('.opt_price')).map(el => ({optPrc: el.value ? el.value.replace(/,/g, '') : ''}));
    let optInvQtys = Array.from(document.querySelectorAll('.opt_inv_qty')).map(el => ({invQty: el.value ? el.value.replace(/,/g, '') : ''}));
    let optColors = Array.from(document.querySelectorAll('.opt_color')).map(cell => cell.textContent);
    let optSizes = Array.from(document.querySelectorAll('.opt_size')).map(cell => cell.textContent);

    let optItemNms = [optColors[0], ...optSizes].map(optItemNm => ({optItemNm}));
    let optGrpNms = [{optGrpNm: "color"}, {optGrpNm: "size"}];


    let data = {
        product: product,
        price: price,
        optPrices: optPrices,
        optInvQtys: optInvQtys,
        optItemNms: optItemNms,
        optGrpNms: optGrpNms
    }
    // 사용자가 선택한 이미지를 검증하고 유효성검사에 실패한 경우 함수를 종료.
    let images = getAndValidateImages();
    console.log("Validated images:", images);
    if (!images) return;

    // 'repImgFile' 및 'smlImgFiles'를 현재 함수 스코프에서 선언하고 값 할당
    let repImgFile = images.repImgFile;
    let smlImgFiles = images.smlImgFiles;
    let formData = new FormData();

    formData.append('data', JSON.stringify(data));
    formData.append('repImg', repImgFile, repImgFile.name);

// 이미지 파일 추가
    smlImgFiles.forEach((file, i) => {
        formData.append('smlImgList', file, file.name);
    });
    console.log("FormData after adding images:", formData);

    formData.forEach((value, key) => {
        console.log(key + " " + value);
    });

    $.ajax({
        url: '/bos/productRegister',
        type: 'POST',
        data: formData,
        processData: false,
        contentType: false,
        beforeSend: function () {
            console.log("Request is about to be sent");
        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.log("Error occurred: " + textStatus, errorThrown);
        },
        complete: function () {
            console.log("Request completed");
        }
    }).done(function (data) {

        console.log(data);
        alert("상품이 등록됐습니다.")
        window.location.href = "/bos/product/productList";

    });
}
