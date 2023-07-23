namespace("dlvAddrPopup");
dlvAddrPopup = {
    initLoad: () => {
        dlvAddrPopup.function.getDlvAddrList();
    },

    bindButtonEvent: () => { // 버튼에 이벤트 핸들러를 연결
        const closeBtn = document.querySelector('.popup-wrap .close');
        const selectDlvAddrBtn = document.querySelector('#btn_select_dlv_addr');

        closeBtn.addEventListener('click', syusyu.common.Popup.close);
        selectDlvAddrBtn.addEventListener('click', dlvAddrPopup.eventHandler.selectDlvAddrInfo);
    },
}

namespace("dlvAddrPopup.eventHandler"); // 이벤트 핸들러(특정 이벤트 발생 시 이벤트를 처리) 모음
dlvAddrPopup.eventHandler = {
    selectDlvAddrInfo: () => {
        // 1. 선택되어있는 radio input을 가져온다.(selectedRadio)
        const selectedDlvAddr = document.querySelector('input[name="dlvAddrRadio"]:checked');

        const recipient = selectedDlvAddr.dataset.recipient;
        const mpNo = selectedDlvAddr.dataset.mpno;
        const zipcode = selectedDlvAddr.dataset.zipcode;
        const dfltAddr = selectedDlvAddr.dataset.dfltaddr;
        const dtlAddr = selectedDlvAddr.dataset.dtladdr;


        // 2. 부모창에 데이터 뿌려준다.
        // 2-1. input hidden에
        document.getElementById('recipient').value = recipient;
        document.getElementById('mpNo').value = mpNo;
        document.getElementById('zipcode').value = zipcode;
        document.getElementById('dfltAddr').value = dfltAddr;
        document.getElementById('dtlAddr').value = dtlAddr;

        // 2-2. txt에(보여주기용)
        document.getElementById('recipientTxt').innerHTML = recipient;
        document.getElementById('dlvAddrTxt').innerHTML = dfltAddr + dtlAddr;
        document.getElementById('mpNoTxt').innerHTML = mpNo;

        // 3. 팝업창 닫는다.
        syusyu.common.Popup.close();
    }
}

namespace("dlvAddrPopup.function");
dlvAddrPopup.function = {
    // 배송지 목록을 얻어온다.
    getDlvAddrList: () => {
        syusyu.common.Ajax.sendJSONRequest('GET', '/fos/dlvAddr', '', dlvAddrList => {
            // 1. ul을 얻어온다. (.addr-lists)
            const $addrListUl = document.querySelector('.addr-lists')
            // 0. 기존 걸 초기화한다.
            $addrListUl.innerHTML = '';

            // 2. 조회해온 데이터를 넣어서 li를 생성한다.
            dlvAddrList.forEach(dlvAddr => {
                const $dlvAddrLi = document.createElement('li');

                const result = `
                <li>
                    <div class="addr-radio">
                        <div class="chkbox">
                            <label>
                                <input type="radio" name="dlvAddrRadio" data-recipient="${dlvAddr.recipient}" data-dfltAddr="${dlvAddr.dfltAddr}" data-dtlAddr="${dlvAddr.dtlAddr}" data-mpNo="${dlvAddr.mpNo}" data-zipcode="${dlvAddr.zipcode}" value="${dlvAddr.dlvAddrNo}">
                                <span class="text">${dlvAddr.recipient}</span>
                                <span class="badge-cont single ml-10">
                                <span class="badge-item ty8">기본배송지</span>
                            </span>
                            </label>
                        </div>
                        <p class="addr">${dlvAddr.dfltAddr} ${dlvAddr.dtlAddr}</p>
                        <p class="phone">${dlvAddr.mpNo}</p>
                    </div>
                    <div class="r-side">
                        <div class="brd-btns">
                            <span>
                                <a href="javascript:;" class="btn btn-text-type btt1" onclick="moveToupdateAddr(24090);">수정</a>
                            </span>
                        </div>
                    </div>
                </li> `;

                $dlvAddrLi.innerHTML += result;
                $addrListUl.appendChild($dlvAddrLi);
            });

            // 3. 생성한 li를 .addr-lists에 넣어준다.
        });
    }
}
