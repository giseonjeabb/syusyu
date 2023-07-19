
$(function(){
    // 모든 fold-box 요소를 선택합니다.
    const foldBoxes = document.querySelectorAll('.fold-box');

    // 각 fold-box 요소에 대한 클릭 이벤트 리스너를 설정합니다.
    foldBoxes.forEach((box) => {
        box.addEventListener('click', () => {
            debugger;
            // 현재 클릭된 fold-box의 active 클래스를 토글합니다.
            box.classList.toggle('active');

            // 다른 모든 fold-box들을 찾아서 active 클래스를 제거하고 접어둡니다.
            foldBoxes.forEach((otherBox) => {
                if (otherBox !== box) {
                    otherBox.classList.remove('active');
                }
            });
        });
    });

});

