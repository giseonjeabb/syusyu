$(document).ready(function () {
     flatpickr(".datepicker", {
        dateFormat: "Y-m-d"
     });


    // 오늘날짜 생성합니다.
    let today=new Date();

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


    //카테고리 운동화 하위분류를 기본으로 보여주고 중분류카테고리클릭시 특정하위카테고리로 바뀜
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
    //cateId 찾기
    const cateList = JSON.parse(document.getElementById('jsonCateList').value);
    const selectLarge = document.getElementById("cate_large");
    const selectMiddle = document.getElementById("cate_middle");
    const selectSmall = document.getElementById("cate_small");

    cateList.forEach((cate)=>{
        if(parseInt(selectSmall.value)===cate.smallNo && parseInt(selectMiddle.value)===cate.middleNo && parseInt(selectLarge.value)===cate.largeNo){
            console.log(cate.cateId);
            cateIdInput.value = cate.cateId;
        }
    });


    //할인 설정함클릭시 설정사항들이 보여지고 설정안함 클릭시 설정사항 숨김
    const dcContent = $('.dc_content').hide();
    $('#dc_btnradio').click(function () {
        dcContent.show(); // "설정함" 클릭시 행을 보여줍니다.
    });

    $('#dc_btnradio_no').click(function () {
        dcContent.hide(); // "설정안함" 클릭시 행을 숨깁니다.
    });

// 특정기간만 할인 체크박스 클릭시 생기고 체크해제하면 숨김
    let checkBox = $("#dc_date_chk");
    let dateDiv = $("#dc_date");

    checkBox.change(function() {
        if(checkBox.is(':checked')) {
            dateDiv.removeClass("d-none");
            // 체크박스가 선택되었을 때 시작 날짜를 오늘로 설정합니다.
            setFlatpickrCalendar('dc_start_date', today);
            document.querySelectorAll('.dc_date_range').forEach((radio) => {
                // 각 라디오 버튼에 이벤트 리스너를 추가합니다.
                radio.addEventListener('change', (event) => {
                    // 선택된 라디오 버튼의 data-interval 속성값을 가져옵니다.
                    let interval = parseInt(event.target.getAttribute('data-interval'));
                    // setCalendarRangeAddDays 함수를 사용해 sale_start_date로부터 interval 만큼의 일 수를 더한 날짜를 sale_end_date 필드에 설정합니다.
                    setCalendarRangeAddDays('dc_start_date', 'dc_end_date', interval);
                });
            });
        } else {
            dateDiv.addClass("d-none");
            // 체크박스가 선택되지 않았을 때 시작 날짜와 종료 날짜를 null로 설정합니다.
            $("#dc_start_date").val(null);
            $("#dc_end_date").val(null);
        }
    });

    // 페이지 로드 시 체크박스 상태에 따라 캘린더의 가시성을 설정
    if(checkBox.is(':checked')) {
        dateDiv.show(); // show div
    } else {
        dateDiv.hide(); // hide div
    }

    //판매기간설정에서 설정함클릭시 기간설정이 보이고 설정안함 클릭시 보이지않게 숨김
    const saleDate=$('.sale_date').hide()
    $('#sale_btnradio').click(function () {
        saleDate.show(); // "설정함" 클릭시 행을 보여줍니다.
    });

    $('#sale_btnradio_no').click(function () {
        saleDate.hide(); // "설정안함" 클릭시 행을 숨깁니다.
    });


    //sale_start_date 필드에 오늘 날짜를 기본값으로 설정합니다.
    setFlatpickrCalendar('sale_start_date', today);
    // 문서 내의 모든 라디오 버튼을 선택합니다.
    document.querySelectorAll('.sale_date_range').forEach((radio) => {
        // 각 라디오 버튼에 이벤트 리스너를 추가합니다.
        radio.addEventListener('change', (event) => {
            // 선택된 라디오 버튼의 data-interval 속성값을 가져옵니다.
            let interval = parseInt(event.target.getAttribute('data-interval'));
            // setCalendarRangeAddDays 함수를 사용해 sale_start_date로부터 interval 만큼의 일 수를 더한 날짜를 sale_end_date 필드에 설정합니다.
            setCalendarRangeAddDays('sale_start_date', 'sale_end_date', interval);
        });
    });


    // 할인율 입력 필드 값 변경 시, 할인율 유효성 검사와 할인가 계산을 실행하는 이벤트 리스너 등록
    const productPerInput = document.getElementById('product_per');
    productPerInput.addEventListener('input', function() {
        validateNumericInput(this);
        removeLeadingZeros(this);
        validateDiscountInput(this);
        calculateDiscountPrice();
    });

    // 상품가격 입력 필드 값 변경 시, 숫자만 입력하도록 제한하고, 천 단위 콤마와 마지막 숫자 확인, 할인가 계산 실행하는 이벤트 리스너 등록
    const productPriceInput = document.getElementById('product_price');
    productPriceInput.addEventListener('input', function() {
        validateNumericInput(this);
        removeLeadingZeros(this);
        this.value = formatWithComma(this.value);
        validateLastDigit(this);
    });

    //매입가격 입력 필드값 변경 시, 숫자만 입력, 천단위콤마, 마지막숫자 확인.
    const productBuyPriceInput=document.getElementById('product_buy_price');
    productBuyPriceInput.addEventListener('input',function(){
        validateNumericInput(this);
        removeLeadingZeros(this);
        this.value = formatWithComma(this.value);
        validateLastDigit(this);
    });


// 컬러 입력 필드에서 한단어만, 숫자,특수문자제외 유효성 검사 실행
    const colorInput = document.getElementById('input_color');
    colorInput.addEventListener('blur', function() {
        validateOneWordInput(this);
    });

    // 사이즈 입력 필드에서 값이 변경될 때마다 유효성 검사 (숫자, 콤마, 스페이스만 입력하고 첫 0 제거)
    const sizeInput = document.getElementById('input_size');
    sizeInput.addEventListener('input', function() {
        validateNumericCommaSpaceInput(this);
        removeLeadingZeros(this);
    });

// "옵션목록으로 적용" 버튼에 클릭 이벤트 리스너 등록
    document.getElementById('btnOpt').addEventListener('click', applyOptions);


    // "선택삭제" 버튼에 이벤트 핸들러를 추가
    document.getElementById('chk_del').addEventListener('click', function() {
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


// 버튼에 클릭 이벤트를 달아주는 함수를 호출한다.
    document.getElementById("addImgBtn").addEventListener("click", addImageInput);

});

// "옵션목록으로 적용" 버튼을 클릭하면 실행되는 함수
function applyOptions() {
    const colorInput = document.getElementById('input_color');
    const sizeInput = document.getElementById('input_size');

    // 사이즈를 ', ' ',' ' ,'기준으로 잘라서 각각의 사이즈에 대해
    const sizes = sizeInput.value.split(/\,\s*/);

    for (let i = 0; i < sizes.length; i++) {
        // 모든 행의 사이즈 값을 가져와서 배열로 만듭니다.
        let currentSizes = Array.from(document.querySelectorAll('.opt_size')).map(td => td.textContent);

        // 사이즈 값이 이전에 입력한 값과 같은지 확인
        if(currentSizes.includes(sizes[i])){
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
        priceCell.classList.add('opt_price', 'text-center', 'ileen-mellinrant');
        let priceInput = document.createElement('input');
        priceInput.classList.add('border-0', 'w-100');
        priceInput.type = "text";
        priceInput.min = "0";
        priceInput.oninput = function () {
            this.value = this.value.replace(/[^0-9]/g, ''); // 수정된 부분
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
        qtyCell.classList.add('opt_inv_qty', 'text-center', 'align-middle');
        let qtyInput = document.createElement('input');
        qtyInput.classList.add('border-0', 'w-100');
        qtyInput.type = "number";
        qtyInput.min = "0";
        qtyInput.oninput = function () {
            this.value = this.value.replace(/[^0-9]/g, '');
            if (this.value.startsWith('0')) {
                this.value = this.value.substr(1)
            }
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
        ynCell.classList.add('opt_YN', 'text-center', 'align-middle');
        let ynSelect = document.createElement('select');
        ynSelect.classList.add('form-select', 'border-0', 'w-100');
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
        delBtn.addEventListener('click', function() {
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
        sizeInput.addEventListener('input', function() {
            const newSizeValues = this.value.split(/\,\s*/);
            this.value = newSizeValues.join(', ');
        });

        // 재고 수량이 변경될 때 판매 상태 업데이트
        qtyInput.addEventListener('input', function() {
            updateSaleStatus(this, statusCell);
            updateTotalQuantity();
        });
    }
}


// 글자수 60자까지
function updateLengthSixty(input) {
    // 현재 텍스트의 길이를 가져옵니다
    let length = input.value.length;

    // 텍스트의 길이를 표시하는 요소를 찾습니다
    let lengthDisplay = document.getElementById("text_length");

    // 텍스트의 길이를 갱신합니다
    lengthDisplay.textContent = length + "/60";
}

//글자수 100자까지
function updateLengthHundred(input) {
    // 현재 텍스트의 길이를 가져옵니다
    let length = input.value.length;

    // 텍스트의 길이를 표시하는 요소를 찾습니다
    let lengthDisplay = document.getElementById("text_length_mfgdMatr");

    // 텍스트의 길이를 갱신합니다
    lengthDisplay.textContent = length + "/100";
}
//한단어만 입력받기
function validateOneWordInput(input) {
    input.value = input.value.replace(/[^a-zA-Z가-힣\s]/g, ''); // 숫자, 특수문자 제거
    input.value = input.value.replace(/(\s)(?=\s)/g, ''); // 이중 공백 제거
    input.value = input.value.split(' ')[0]; // 첫 단어만 허용
}

// 숫자만 입력 받고, 그 외의 문자는 제거
function validateNumericInput(input) {
    input.value = input.value.replace(/[^0-9]/g, '');
}

// 맨 앞의 연속된 0들을 제거
function removeLeadingZeros(input) {
    input.value = input.value.replace(/^0+(?=\d)/, '');
}

// 마지막 숫자가 0인지 확인
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
// 숫자와 콤마, 스페이스만 입력 받고, 그 외의 문자는 제거
function validateNumericCommaSpaceInput(input) {
    input.value = input.value.replace(/[^0-9, ]/g, '');
}

// 숫자에 천 단위로 콤마 추가
function formatWithComma(input) {
    const numberOnly = input.value.replace(/[^0-9]/g, '');
    const numberWithComma = numberOnly.replace(/\B(?=(\d{3})+(?!\d))/g, ",");
    input.value = numberWithComma;
}

// 100 이상의 숫자를 입력 받지 못하게 막기
function validateDiscountInput(input) {
    let inputValue = input.value;
    inputValue = inputValue.replace(/[^0-9]/g, '');
    if (parseInt(inputValue) > 100) {
        inputValue = '99';
    }
    input.value = inputValue;
}

// 할인된 가격 계산
function calculateDiscountPrice() {
    const productPrice = parseInt(document.getElementById('product_price').value.replace(/[^0-9]/g, ''));
    const discountRate = parseInt(document.getElementById('product_per').value.replace(/[^0-9]/g, ''));

    if (isNaN(productPrice) || isNaN(discountRate)) {
        document.getElementById('dcPrice').value = '0원';
    } else {
        const discountAmount = productPrice * (100 - discountRate) / 100;
        const numberWithComma = discountAmount.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
        let discountedPrice = numberWithComma + '원';
        let discount = '';

        if (productPrice >= 1000) {
            discount = (productPrice - discountAmount).toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
            discountedPrice += ' ( ' + discount + '원 할인 )';
            document.getElementById('dc_price').style.display = 'block';
        } else {
            document.getElementById('dc_price').style.display = 'none';
        }

        document.getElementById('dcPrice').value = discountedPrice;
    }
}

// 총 재고 수량을 계산하는 함수
function updateTotalQuantity() {
    const qtyInputs = Array.from(document.querySelectorAll('.opt_inv_qty input'));
    let totalQuantity = qtyInputs.reduce((total, input) => {
        return total + parseInt(input.value, 10);
    }, 0);
    document.getElementById('tot_qty').value = totalQuantity;
}

// 재고 수량에 따른 판매 상태를 업데이트하는 함수
function updateSaleStatus(input, statusCell) {
    if (parseInt(input.value, 10) > 0) {
        statusCell.textContent = '판매중';
        statusCell.setAttribute('value', '601');
    } else {
        statusCell.textContent = '품절';
        statusCell.setAttribute('value', '603');
    }
}

function updateCurrentSizes() {
    currentSizes = Array.from(document.querySelectorAll('.opt_size input')).map(input => input.value);
}

// 이미지 유효성 검사 함수
function validateFile(file) {
    const allowedExtensions = ["jpg", "jpeg", "gif", "png", "bmp"];
    const fileExtension = file.name.split('.').pop().toLowerCase();
    return allowedExtensions.includes(fileExtension);
}

// 이미지 선택 시 유효성 검사 함수
function validateFileInput(input) {
    const file = input.files[0];
    if (file && !validateFile(file)) {
        alert("잘못된 파일입니다. 유효한 이미지 파일을 선택해 주세요.");
        input.value = "";  // Clear the input
    }
}


// 버튼이 클릭될 때마다 실행되는 함수
function addImageInput() {
    const currentImgCount = document.getElementsByClassName('smlImg').length;
    if (currentImgCount < 9) {

        const input = document.createElement("input");
        input.setAttribute("class", "smlImg form-control");
        input.setAttribute("type", "file");
        input.setAttribute("onchange", "validateFileInput(this)");

        // 샇녀 생성된 입력필러을 "imgInfo"라는 id를 가진 div안에 넣는다.
        document.getElementById("imgInfo").appendChild(input);
    } else {
        alert('9개의 이미지까지만 추가할 수 있습니다.');
    }
}

//이미지데이터 가져오기.
function getAndValidateImages() {
    // 대표이미지와 추가 이미지 파일들을 가져옴
    let refImgInput = document.getElementById('refImg');
    let smlImgInputs = document.getElementsByClassName('smlImg');

    // 검증할 파일들을 저장할 배열
    let filesToValidate = [];

    // 대표이미지 파일이 있으면 배열에 추가
    if(refImgInput.files[0]) {
        filesToValidate.push(refImgInput.files[0]);
    } else {
        // 대표 이미지가 선택되지 않았다면 null을 반환합니다.
        alert("대표 이미지를 선택해주세요.");
        return null;
    }

    // 추가 이미지 파일들을 배열에 추가 (선택된 파일이 있는 경우만)
    for(let i = 0; i < smlImgInputs.length; i++) {
        if(smlImgInputs[i].files[0]) {
            filesToValidate.push(smlImgInputs[i].files[0]);
        }
    }

    // 파일 유효성 검사
    for(let i = 0; i < filesToValidate.length; i++) {
        if(!validateFile(filesToValidate[i])) {
            alert("유효하지 않은 파일이 포함되어 있습니다.");
            return null;
        }
    }

    // 파일들이 모두 유효하다면, 파일들을 객체로 반환
    return {
        refImgFile: refImgInput.files[0],  // 대표 이미지 파일
        smlImgFiles: Array.from(smlImgInputs).map(input => input.files[0]).filter(file => file) // 선택된 파일이 있는 입력 필드만 반환
    };
}


function productRegisterSave(){
    let images = getAndValidateImages();
    if(!images) return;

    let refImgFile = images.refImgFile;
    let smlImgFiles = images.smlImgFiles;
    let formData = new FormData();

    // 유효성 검사를 통과한 이미지 파일들을 formData에 추가
    formData.append("refImg", refImgFile);
    for(let i = 0; i < smlImgFiles.length; i++){
        formData.append("smlImg", smlImgFiles[i]);
    }


    //옵션리스트만들기
    let tableRows = document.querySelectorAll('#opt_table tr');
    let itemOptions = Array.from(tableRow).map(row => {
        return {
            color: row.querySelector('.opt_color').textContent,
            size: row.querySelector('.opt_size').textContent,
            optPrc: row.querySelector('.adempiere_opt_price input').value.replace(/,/g, ""),
            invQty: row_textSelector('.adem_opt_inv_qty input').value.replace(/,/g, "")
        };
    });

    let items = []; // 아이템들을 담을 배열

    let item = {
        prodId: document.getElementById('product_name').value,
        cateId: document.getElementById('cateId').value,
        salePrc: document.getElementById('product_price').value.replace(/,/g, ""),
        buyPrc: document.getElementById('product_buy_price').value.replace(/,/g, ""),
        dcPer: document.getElementById('product_per').value,
        dcStDttm: document.getElementById('dc_start_date').value,
        dcEdDttm: document.getElementById('dc_end_date').value,
        saleStDttm: document.getElementById('ia').value,
        saleEdDttm: document.getElementById('ib').value,
        brndId: document.getElementById('product_brand').value,
        modelNm: document.getElementById('product_model').value,
        mfgdMatr: document.getElementById('mfgdMatr').value,
        mftco: document.getElementById('mftco').value,
        mftNatn: document.getElementById('mftNatn').value,
        rlesDt:document.getElementById('rles_dt').value,
        prodDtlDesc: $('#summernote').summernote('code'),
        itemOptions: itemOptions // itemOptions 는 테이블에서 옵션을 가져와 설정
    };

    formData.append('item', JSON.stringify(item)); // 데이터 객체를 JSON 문자열로 변환

    $.ajax({
        type: "POST",
        url: "/bos/productRegister",
        data: formData,
        processData: false,  // tell jQuery not to process the data
        contentType: false,  // tell jQuery not to set contentType
        contentType: "application/json", // 서버로 보내는 데이터의 타입 지정
        success: function (response) {
            window.location.href = "/bos/productRegister"

        },
        error: function (err) {
            console.log("Error in sending data.");
        }
    });
}

