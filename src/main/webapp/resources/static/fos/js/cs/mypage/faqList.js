/**
 * JS 작성 순서
 * FAQ 타입 버튼 - hover,active
 * 첫화면 key = 00인 전체 화면
 *
 * FAQ 타입 버튼 클릭시 해당 FaqDTO.FaqTp에 맞는 글만 조회하기
 * 조회된 글의 제목 클릭시 아코디언 효과로 내용 접었다가 폈다가 하기
 * @author han
 * @since  2023-07-14
 */



/**
 * FAQ 타입버튼 active,hover
 * scss에
 * .faqType-small:hover
 * .faqType-small.active 설정해둠
 *
 * @author han
 * @since  2023-07-14
 */
function ActiveBtn(button) {
    const typeBtn = document.getElementsByClassName("faqType-small");
    for (let i = 0; i < typeBtn.length; i++) {
        // 만약 클릭된 버튼이 아니라면 active 제거
        if (typeBtn[i] !== button) {
            typeBtn[i].classList.remove("active"); // active 제거
        }
    }
    // 클릭한 버튼 active 추가
    button.classList.add("active");

    // 클릭된 버튼이 "전체"라면  로딩 시 모든 FAQ 항목을 보여줌.
    if (button.value === "전체") {
        filterFaq("00");
    }else {
        filterFaq(button.getAttribute("key"));
    }
}


/**
 * FAQ 타입 분류버튼 클릭시 이벤트 발생 시키기
 * 버튼에 key 값으로 목록에서 FaqDTO.faqTp 분류
 *
 * 첫 로딩 시 전체 FAQ 항목 보여주기
 *    filterFAQs("00");
 *
 * @author han
 * @since  2023-07-11
 */

    // FAQ 타입 버튼
const faqTpBtn = document.querySelectorAll(".faqType-small");
faqTpBtn.forEach(function(button){
    button.addEventListener("click", function(event) {
        event.preventDefault();

        // 클릭한 FAQ 타입 값 가져오기
        const faqType = this.getAttribute("key");

        // 전체 페이지에서 해당 FAQ 타입 필터링
        filterFaq(faqType);
        // active 된 버튼 표시 하기
        ActiveBtn(this);
    });
});

// ActiveBtn 함수를 호출하고 key="00"인 버튼 요소를 전달합니다.
ActiveBtn(document.querySelector('input[key="00"]'));

/**
 * FAQ타입 버튼에서 타입에 맞는 글만 조회 하기
 * 동적으로 가져오는거 할줄 몰라서
 * display 옵션으로 none , block 해서 숨김 처리했음.
 *
 * @author han
 * @since  2023-07-14
 */

// FAQ 타입버튼 클릭시 해당 타입에 맞는 글 보여주기
function filterFaq(faqType) {
    // FAQ 타입 선택
    const faqTp = document.querySelectorAll(".slide-title");
    // FAQ 타입들을 foreach로 한바퀴 돌면서 처리할꺼임
    faqTp.forEach(function (item) {
        // 각 FAQ타입 가져옴
        const faqTp = item.querySelector(".slide-trg").getAttribute("faqTp");

        // 클릭한 FAQ 타입과 일치하는 항목은 보여주고 그외는 숨김처리
        if (faqType === "00" || faqTp === faqType) {
            item.style.display = "block"; // 보임 FAQ
        } else {
            item.style.display = "none"; // 숨김 FAQ
        }
    });
}



/**
 * FAQ 목록에서 제목 클릭하게되면 아코디언 처럼 내용 보임 접었다가 폈다가
 * display : none 에서 클릭시 display : block로 변경됨
 *
 * @author han
 * @since  2023-07-11
 */

    // FAQ화면에서 FAQ 글 제목 클릭시 내용 보이게 display : none -> block
const acc = document.getElementsByClassName("slide-trg");
let i;

for (i = 0; i < acc.length; i++) {
    acc[i].addEventListener("click", function() {
        this.classList.toggle("active");

        const inner =
            this.parentElement.nextElementSibling.querySelector('.inner');
        // this.closest(".slide-title").nextElementSibling.querySelector('.inner');
        if(inner){
            inner.style.display = inner.style.display === "block" ? "none" : "block";
        }
    });
}