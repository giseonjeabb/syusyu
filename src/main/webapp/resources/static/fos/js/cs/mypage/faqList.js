
    /**
     * FAQ 목록에서 제목 클릭하게되면 내용 보이게
     * display : none 에서 클릭시 display : block로 변경됨
     *
     * @author han
     * @since  2023-07-11
     */

        // FAQ 글 제목 클릭시 내용 보이게 display : none -> block
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

    /**
     * FAQ 타입 분류버튼 클릭시 이벤트 발생 시키기
     * 버튼에 key 값으로 목록에서 faqTp 분류 하려고 만듬
     *
     * 첫 로딩 시 전체 FAQ 항목 보여주기
     *    filterFAQs("00");
     *
     * @author han
     * @since  2023-07-11
     */

        // FAQ 분류 버튼 클릭이벤트
    const faqTpButtons = document.querySelectorAll(".faqType-small");
    faqTpButtons.forEach(button => {
        button.addEventListener("click", function(event) {
            event.preventDefault();

            // 클릭한 FAQ 타입 값 가져오기
            const faqType = this.getAttribute("key");

            // 전체 페이지에서 해당 FAQ 타입 필터링
            filterFAQs(faqType);
            // active 된 버튼 표시 하기
            setActiveButton(this);

        });
    });


    // 활성화된 버튼 표시
    function setActiveButton(button) {
        const type = document.getElementsByClassName("faqType-small");
        for (let i = 0; i < type.length; i++) {
            if (type[i] !== button) {
                type[i].classList.remove("active"); // 다른 버튼 active 제거
            }
        }
        button.classList.add("active"); // 클릭한 버튼 active 추가
    }

    // 초기 로딩 시 전체 FAQ 항목 보여주기
    filterFAQs("00");
    setActiveButton(document.querySelector('input[name="faqTp"][key="00"]'));




    // FAQ 타입 필터링
    function filterFAQs(faqType) {
        const faqItems = document.querySelectorAll(".slide-title");
        faqItems.forEach(item => {
            const faqTp = item.querySelector(".slide-trg").getAttribute("faqTp");

            // 클릭한 FAQ 타입과 일치하는 항목은 보여주고 그외는 숨김처리
            if (faqType === "00" || faqTp === faqType) {
                item.style.display = "block"; // 보임 FAQ
            } else {
                item.style.display = "none"; // 숨김 FAQ
            }
        });
    }




