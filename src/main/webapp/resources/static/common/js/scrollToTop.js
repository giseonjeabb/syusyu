/**
 * 'Top' 버튼 관련 기능.
 *
 * @function
 * @description
 * - 사용자가 스크롤을 내릴 때 특정 위치(100px)를 지나면 'Top' 버튼이 화면에 표시됩니다.
 * - 'Top' 버튼을 클릭하면 페이지 최상단으로 부드럽게 스크롤됩니다.
 *
 * @author soso
 * @since 2023/08/04
 */

const scrollToTop = () => {
    // 스크롤 이벤트가 발생할 때마다 체크
    window.addEventListener('scroll', function() {
        const scrollTop = window.pageYOffset || document.documentElement.scrollTop;

        // 만약 스크롤 위치가 100px보다 크면 버튼을 보이게 합니다.
        if (scrollTop > 100) {
            document.getElementById('btnTop').style.display = 'block';
        } else {
            document.getElementById('btnTop').style.display = 'none';
        }
    });

    // 버튼을 클릭하면 상단으로 스크롤 이동
    document.getElementById('btnTop').addEventListener('click', function() {
        window.scrollTo({
            top: 0,
            behavior: 'smooth'
        });
    });
}
