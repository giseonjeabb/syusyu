/**
 * 이 함수는 페이지 로드 시 다음 작업을 수행합니다:
 * 1) URL의 경로를 파싱하여 중분류와 소분류 카테고리 번호를 가져옵니다.
 * 2) 만약 중분류 카테고리 번호가 undefined 혹은 null인 경우, 기본값 1을 할당합니다.
 * 3) 정렬 기준을 설정하고, 사용자가 정렬 기준을 클릭하여 변경할 수 있도록 이벤트 리스너를 추가합니다.
 * 4) 지정된 중분류와 소분류 카테고리에 속하는 상품 목록을 AJAX POST 요청을 통해 가져옵니다.
 *
 * 반환 값은 각 카테고리에 대한 상품 목록과 총 상품 수를 포함하는 JSON 형식의 데이터입니다.
 *
 * @param middleNo 중분류 카테고리 번호. 이 값이 null 혹은 undefined일 경우, 기본값은 1입니다.
 * @param smallNo 소분류 카테고리 번호. 이 값이 null 혹은 undefined일 경우, 해당 카테고리 전체 상품을 가져옵니다.
 * @return 성공적인 경우, 상품 정보를 담은 JSON 데이터를 반환합니다. 실패할 경우, AJAX 요청 실패 메시지를 콘솔에 출력합니다.
 * @throws Exception 상품 리스트를 가져오는 동안 발생할 수 있는 예외를 처리합니다.
 * @author soso
 * @since 2023/07/07
 */
$(function () {
    // 현재 URL의 path를 가져옵니다.
    const path = window.location.pathname;
    const pathParts = path.split('/');
    let middleNo = pathParts[3];
    const smallNo = pathParts[4];

    // middleNo가 undefined 또는 null일 경우, 기본값 1을 할당합니다.
    if (middleNo === undefined || middleNo === null) {
        middleNo = 1;
    }

    // 정렬 기준(sort)의 기본값을 'default'로 설정합니다.
    let sort = 'default';

    // '#sort a' 요소가 클릭되었을 때의 동작을 정의합니다.
    const links = document.querySelectorAll("#sort a");

    links.forEach(link => {
        link.addEventListener("click", function (e) {
            e.preventDefault();

            links.forEach(link => {
                link.classList.remove("active");
            });

            e.currentTarget.classList.add("active");

            const sort = e.currentTarget.id;
            console.log(sort);
            getProducts(middleNo, smallNo, sort);
        });
    });

    console.log(middleNo, smallNo)

    // 상품 리스트를 가져옵니다.
    getProducts(middleNo, smallNo, sort);

    /**
     * 'Top' 버튼의 스크롤 기능.
     *
     * @description
     * - 스크롤 위치가 100px 이상일 때: 'Top' 버튼 표시
     * - 스크롤 위치가 100px 미만일 때: 'Top' 버튼 숨김
     * - 'Top' 버튼 클릭 시: 페이지 최상단으로 부드럽게 스크롤
     *
     * @author soso
     * @since 2023/08/14
     */
    scrollToTop();

});

/**
 * 이 함수는 지정된 중분류와 소분류 카테고리에 속하는 상품 목록을 AJAX GET 요청을 통해 가져옵니다.
 * 반환 값은 각 카테고리에 대한 상품 목록을 포함하는 JSON 형식의 데이터입니다.
 *
 * @param middleNo 중분류 카테고리 번호.
 * @param smallNo 소분류 카테고리 번호. 이 값이 빈 문자열일 경우, 해당 카테고리 전체 상품을 가져옵니다.
 * @param sort 정렬 기준. 이 값이 'defaultSort'일 경우, 기본 정렬 기준을 사용합니다.
 * @return 성공적인 경우, 상품 정보를 담은 JSON 데이터를 반환합니다. 실패할 경우, AJAX 요청 실패 메시지를 콘솔에 출력합니다.
 * @author soso
 * @since 2023/08/05
 */
function getProducts(middleNo, smallNo = '', sort = 'defaultSort') {
    const baseURL = "/fos/productsData/";
    let requestURL = baseURL + middleNo;
    console.log(sort);
    // smallNo가 있을 경우, URL에 추가합니다.
    if (smallNo) {
        requestURL += "/" + smallNo;
    }

    // 정렬 기준(sort)를 URL에 추가합니다.
    requestURL += "/" + sort;

    // AJAX 요청을 통해 서버에서 상품 리스트를 가져옵니다.
    $.ajax({
        type: 'GET',
        url: requestURL,
        contentType: 'application/json; charset=utf-8',
        dataType: "json",
        success: function (data) {
            // 가져온 상품 리스트를 보여줍니다.
            showProductList(data);
        },
        error: function (jqXHR, error, errorThrown) {
            console.error("AJAX request failed. " + error);
        }
    });
}


/**
 * 상품 리스트를 화면에 표시하는 함수입니다.
 * 받아온 데이터로부터 상품 리스트와 총 갯수를 변수에 저장한 후, 화면에 출력합니다.
 * 만약 상품 리스트가 비어있는 경우, 상품이 없다는 메시지를 표시합니다.
 *
 * @param {Object} data - 상품 리스트와 총 갯수를 포함한 데이터 객체
 * @since 2023/07/07
 */
const showProductList = (data) => {

    const productList = data.productList;
    const prodListTot = data.prodListTot;

    console.log(productList, prodListTot)
    //상품리스트 아이템들을 초기화
    const productItems = document.querySelector('.prd-lists');
    productItems.innerHTML = '';// 기존에 있던 상품리스트 아이템들을 제거

    //소분류별 상품 총갯수
    const prodListTotElement = document.querySelector('.prd-counter strong');
    prodListTotElement.textContent = prodListTot;


    //해당 카테고리에 상품리스트가 비어있는경우
    if (productList.length === 0) {
        const emptyItemMessage = document.createElement('div');
        emptyItemMessage.className = 'list-none bt-0';
        emptyItemMessage.innerHTML = '<p class="msg-text">상품이 없습니다.</p>';
        productItems.appendChild(emptyItemMessage);
    } else {
        //해당 카테고리 상품리스트 출력
        productList.forEach(item => {
            // Create elements
            const productItemDiv = document.createElement('div');
            productItemDiv.setAttribute('class', 'prd-item');

            const itemHoverDiv = document.createElement('div');
            itemHoverDiv.className = 'thumbs hover';

            //클릭시 상세페이지로
            const itemImgA = document.createElement('a');
            itemImgA.setAttribute('href', `/fos/products/product/${item.prodId}`);
            itemImgA.setAttribute('target', '_self');
            itemImgA.setAttribute('pno', `${item.prodId}`);

            //상품 이미지
            const itemImg = document.createElement('img');
            itemImg.setAttribute('src', `${item.repImg}`);
            itemImg.setAttribute('alt', `${item.prodNm}`);

            const itemDescDiv = document.createElement('div');
            itemDescDiv.setAttribute('class', 'desc');

            const itemDescA = document.createElement('a');
            itemDescA.setAttribute('href', `/fos/products/product/${item.prodId}`);
            itemDescA.setAttribute('target', '_self');
            itemDescA.setAttribute('pno', `${item.prodId}`);

            const itemNameP = document.createElement('p');
            itemNameP.setAttribute('class', 'name');
            itemNameP.innerText = `${item.prodNm}`;

            const itemPriceDiv = document.createElement('div');
            itemPriceDiv.setAttribute('class', 'price');

            const itemAmountP = document.createElement('p');
            itemAmountP.setAttribute('class', 'amount');

            //판매 할인이 있는경우
            if (item.dcPer > 0) {
                const itemPerSpan = document.createElement('span');
                itemPerSpan.setAttribute('class', 'per');
                itemPerSpan.innerText = `${item.dcPer}%`;

                const itemDcPrc = document.createTextNode(item.dcPrc.toLocaleString());

                const itemWonSpan = document.createElement('span');
                itemWonSpan.setAttribute('class', 'won');

                const itemPriceDel = document.createElement('del');
                itemPriceDel.innerText = formatPrice(item.salePrc) + ' 원';

                itemAmountP.appendChild(itemPerSpan);
                itemAmountP.appendChild(itemDcPrc);
                itemAmountP.appendChild(itemWonSpan);
                itemAmountP.appendChild(itemPriceDel);
            } else {
                //판매할인이 없는경우
                const itemPrice = document.createTextNode(formatPrice(item.salePrc));

                const itemWonSpan = document.createElement('span');
                itemWonSpan.setAttribute('class', 'won');

                // Append elements
                itemAmountP.appendChild(itemPrice);
                itemAmountP.appendChild(itemWonSpan);
            }



            //리뷰 별점, 리뷰수
            const itemRevwDiv = document.createElement('div');
            itemRevwDiv.setAttribute('class', 'grade');

            const itemRevwStrong = document.createElement('strong');
            itemRevwStrong.style.width='${(item.avgStarRating*100)/5}';
            itemRevwStrong.innerText = `${item.avgStarRating}`;

            const itemRevwSpan = document.createElement('span');
            itemRevwSpan.innerText = `(${item.revwCnt})`;

            //장바구니버튼
            const cartBtnDiv = document.createElement('div');
            cartBtnDiv.setAttribute('class', 'prd-item-btn');

            const cartBtn = document.createElement('button');
            cartBtn.setAttribute('type', 'button');
            cartBtn.className = 'btn icon cart add-cart-bt';
            cartBtn.setAttribute('pno', `${item.prodId}`);

            const cartSpan = document.createElement('span');
            cartSpan.setAttribute('class', 'text');
            cartSpan.innerText = '장바구니 담기';

            itemImgA.appendChild(itemImg);
            itemHoverDiv.appendChild(itemImgA);
            productItemDiv.appendChild(itemHoverDiv);

            itemPriceDiv.appendChild(itemAmountP);
            itemNameP.appendChild(itemPriceDiv);

            itemRevwStrong.appendChild(itemRevwSpan);
            itemRevwDiv.appendChild(itemRevwStrong);
            itemNameP.appendChild(itemRevwDiv);

            cartBtn.appendChild(cartSpan);
            cartBtnDiv.appendChild(cartBtn);
            itemNameP.appendChild(cartBtnDiv);

            itemDescA.appendChild(itemNameP);
            itemDescDiv.appendChild(itemDescA);
            productItemDiv.appendChild(itemDescDiv);

            productItems.appendChild(productItemDiv);
        });
    }
};