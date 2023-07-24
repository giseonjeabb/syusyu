<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="<c:url value="${jsUrlFos}/popup/dlvAddrPopup.js"/>"></script>
<script>
    dlvAddrPopup.initLoad();
    dlvAddrPopup.bindButtonEvent();
</script>
<div class="popup-layer w-510">
    <div class="popup-head">
        <h4>배송지 목록</h4>
        <button type="button" class="btn icon remove_19 close"><span class="text">닫기</span></button>
    </div>
    <div class="popup-fix-cont">
        <div class="chkbox">
            <label>
                <input type="checkbox" id="rcv_list_default_be">
                <span class="text">기본 배송지로 설정</span>
            </label>
        </div>
        <div class="r-side">
            <a href="javascript:" class="btn ty1 c-ty2" id="addrAddTxt"><span>배송지 추가</span></a>
        </div>
    </div>
    <div class="popup-content addr-ty">
        <div class="inner">
            <ul class="addr-lists" id="addrList">
            </ul>
        </div>
    </div>
    <div class="popup-btn-area">
        <button type="button" id="btn_select_dlv_addr" class="btn popup-btn ty4 c-ty9"><span>확인</span></button>
    </div>
</div>