<%@ page import="com.teamProject.syusyu.dao.cs.impl.FaqDAOImpl" %>
<%@ page import="com.teamProject.syusyu.domain.cs.FaqDTO" %>
<%@ page import="com.teamProject.syusyu.dao.cs.FaqDAO" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ page session="true" %>
<c:set var="loginId" value="${sessionScope.id}"/>
<c:set var="loginOutLink" value="${loginId=='' ? '/login/login' : '/login/logout'}"/>
<c:set var="loginOut" value="${loginId=='' ? 'Login' : 'ID='+=loginId}"/>


<head>
    <style>
       @import url(${cssUrlFos}/cs/faqList.scss);
    </style>

    <script src="<c:url value='${jsUrlFos}/cs/mypage/faqList.js'/>" defer></script>

</head>



<div class="content-mini right-case" id="ux_page_list">
  <form id="frm_search" action= "<c:url value="/faq/faqList"/>">


    <h3 class="title-t ty3 mb-30">자주 묻는 질문</h3>
      <%--  게시글 갯수 카운팅--%>

          <div class="input etc-ty4 w-full">
                <input type="text" id="faqSearchText" name="keyword" class="inp" placeholder="궁금하신 내용을 입력해 주세요." value="${fsc.keyword}">

                <button type="submit" class="btn icon search big">
                  <span><i class="fa fa-search"></i></span>
                </button>
          </div>


    <div class="faqType-middle">

        <input class="faqType-small" type="button" name="faqTp" key = "00" value="전체">
        <input class="faqType-small" type="button" name="faqTp" key = "10" value="회원">
        <input class="faqType-small" type="button" name="faqTp" key = "20" value="배송">
        <input class="faqType-small" type="button" name="faqTp" key = "30" value="주문 / 결제">
        <input class="faqType-small" type="button" name="faqTp" key = "40" value="교환 / 반품">
        <input class="faqType-small" type="button" name="faqTp" key = "50" value="이벤트">
        <input class="faqType-small" type="button" name="faqTp" key = "60" value="취소 / 환불">
        <input class="faqType-small" type="button" name="faqTp" key = "70" value="이용 안내">
        <input class="faqType-small" type="button" name="faqTp" key = "80" value="쿠폰 / 포인트">
    </div>
  </form>

    <div class="board_list">
        <div class="slide-wrap slide-ty2">
            <c:forEach var="faqDto" items="${list}">
                <div class="slide-title">
                    <button type="button" class="slide-trg" faqTp="${faqDto.faqTp}" faqNo="${faqDto.faqNo}">
                        <em>Q.</em>
                        <strong>[ ${faqDto.faqTp} ]  ${faqDto.title}</strong>
                    </button>
                </div>

                <div class="slide-cont">
                    <div class="inner">
                        <div class="answer">
                            <em class="ia">A.</em>
                            <div class="cont">${faqDto.content}</div>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>




<%--  <script>--%>

<%--      /**--%>
<%--       * FAQ 목록에서 제목 클릭하게되면 내용 보이게--%>
<%--       * display : none 에서 클릭시 display : block로 변경됨--%>
<%--       *--%>
<%--       * @author han--%>
<%--       * @since  2023-07-11--%>
<%--       */--%>

<%--      // FAQ 글 제목 클릭시 내용 보이게 display : none -> block--%>
<%--      const acc = document.getElementsByClassName("slide-trg");--%>
<%--      let i;--%>

<%--      for (i = 0; i < acc.length; i++) {--%>
<%--          acc[i].addEventListener("click", function() {--%>
<%--              this.classList.toggle("active");--%>

<%--              const inner =--%>
<%--              this.parentElement.nextElementSibling.querySelector('.inner');--%>
<%--              // this.closest(".slide-title").nextElementSibling.querySelector('.inner');--%>
<%--              if(inner){--%>
<%--                  inner.style.display = inner.style.display === "block" ? "none" : "block";--%>
<%--              }--%>
<%--          });--%>
<%--      }--%>

<%--      /**--%>
<%--       * FAQ 타입 분류버튼 클릭시 이벤트 발생 시키기--%>
<%--       * 버튼에 key 값으로 목록에서 faqTp 분류 하려고 만듬--%>
<%--       *--%>
<%--       * 첫 로딩 시 전체 FAQ 항목 보여주기--%>
<%--       *    filterFAQs("00");--%>
<%--       *--%>
<%--       * @author han--%>
<%--       * @since  2023-07-11--%>
<%--       */--%>

<%--      // FAQ 분류 버튼 클릭이벤트--%>
<%--      const faqTpButtons = document.querySelectorAll(".faqType-small");--%>
<%--      faqTpButtons.forEach(button => {--%>
<%--          button.addEventListener("click", function(event) {--%>
<%--              event.preventDefault();--%>

<%--              // 클릭한 FAQ 타입 값 가져오기--%>
<%--              const faqType = this.getAttribute("key");--%>

<%--              // 전체 페이지에서 해당 FAQ 타입 필터링--%>
<%--              filterFAQs(faqType);--%>
<%--              // active 된 버튼 표시 하기--%>
<%--              setActiveButton(this);--%>

<%--          });--%>
<%--      });--%>


<%--      // 활성화된 버튼 표시--%>
<%--      function setActiveButton(button) {--%>
<%--          const type = document.getElementsByClassName("faqType-small");--%>
<%--          for (let i = 0; i < type.length; i++) {--%>
<%--              if (type[i] !== button) {--%>
<%--                  type[i].classList.remove("active"); // 다른 버튼 active 제거--%>
<%--              }--%>
<%--          }--%>
<%--          button.classList.add("active"); // 클릭한 버튼 active 추가--%>
<%--      }--%>

<%--      // 초기 로딩 시 전체 FAQ 항목 보여주기--%>
<%--      filterFAQs("00");--%>
<%--      setActiveButton(document.querySelector('input[name="faqTp"][key="00"]'));--%>




<%--      // FAQ 타입 필터링--%>
<%--      function filterFAQs(faqType) {--%>
<%--          const faqItems = document.querySelectorAll(".slide-title");--%>
<%--          faqItems.forEach(item => {--%>
<%--              const faqTp = item.querySelector(".slide-trg").getAttribute("faqTp");--%>

<%--              // 클릭한 FAQ 타입과 일치하는 항목은 보여주고 그외는 숨김처리--%>
<%--              if (faqType === "00" || faqTp === faqType) {--%>
<%--                  item.style.display = "block"; // 보임 FAQ--%>
<%--              } else {--%>
<%--                  item.style.display = "none"; // 숨김 FAQ--%>
<%--              }--%>
<%--          });--%>
<%--      }--%>


<%--  </script>--%>


  <br>

</div>