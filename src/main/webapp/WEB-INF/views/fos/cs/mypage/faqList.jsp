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
</head>


<div class="content-mini right-case" id="ux_page_list">
  <form id="frm_search" action= "<c:url value="/faq/faqList"/>" >


    <h3 class="title-t ty3 mb-30">자주 묻는 질문</h3>

      <div class="input etc-ty4 w-full">
            <input type="text" id="faqSearchText" name="keyword" class="inp" placeholder="궁금하신 내용을 입력해 주세요." value="${ph.sc.keyword}">

            <button type="submit" class="btn icon search big">
              <span><i class="fa fa-search"></i></span>
            </button>
      </div>



    <div class="tab ty6 mt-20 sclassify">
      <a href="#" class="active sclassify_children">전체</a>

      <a href="#" class="sclassify_children " classify="">회원</a>

      <a href="#" class="sclassify_children " classify="">배송</a>

      <a href="#" class="sclassify_children " classify="">주문결제</a>

      <a href="#" class="sclassify_children " classify="">교환/반품</a>

      <a href="#" class="sclassify_children " classify="">이벤트</a>

      <a href="#" class="sclassify_children " classify="">취소/환불</a>

      <a href="#" class="sclassify_children " classify="">이용안내</a>

      <a href="#" class="sclassify_children " classify="">쿠폰/포인트</a>
    </div>



  </form>





  <div class="board_list">


    <div class="slide-wrap slide-ty2">


      <div class="slide-title">
        <button type="button" class="slide-trg" data-type="list-chk" idx="16">
          <em>Q.</em>
          <strong>[배송] 송장번호를 확인하고 싶어요.</strong>
        </button>
      </div>
      <div class="slide-cont">
        <div class="inner">
          <div class="answer">
            <em class="ia">A.</em>
            <div class="cont"><p>송장번호는 배송 시작 시 발송되는 알림톡에&nbsp;</p><p>함께 보내드리고 있습니다.</p><p>오뚜기몰이 보낸 카카오톡을 참고해보세요!</p><p>&nbsp;</p><p>카카오톡 사용이 어렵다면</p><p>고객센터로 문의주세요!</p></div>
          </div>
        </div>
      </div>



      <c:forEach items="${list}" var="faqDto">
        <div class="slide-title">
          <button type="button" class="slide-trg" data-type="list-chk" idx="${faqDto.faqNo}">
            <em>Q.</em>
            <strong>${faqDto.faqTp} ${faqDto.title}</strong>
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


  <br>
  <div id="devPageWrap">
    <div class="wrap-pagination">
      <c:if test="${ph.totalCnt==null || ph.totalCnt==0}">
        <div> 게시물이 없습니다.</div>
      </c:if>

      <c:if test="${ph.totalCnt!=null && ph.totalCnt!=0}">

        <c:if test="${ph.showFirst}">
          <a class="page" href="<c:url value='/faq/faqList${pg.sc.getQueryString(ph.beginPage)}'/>">&lt;&lt;</a>
        </c:if>

        <c:if test="${ph.showPrev}">
          <a class="page" href="<c:url value='/faq/faqList${ph.sc.getQueryString(ph.beginPage-1)}'/>">&lt;</a>
        </c:if>

        <c:forEach var="i" begin="${ph.beginPage}" end="${ph.endPage}">
          <a class="page ${i==ph.sc.page? "paging-active" : ""}" href="<c:url value='/faq/faqList${ph.sc.getQueryString(i)}'/>">${i}</a>
        </c:forEach>

        <c:if test="${ph.showNext}">
          <a class="page" href="<c:url value='/faq/faqList${ph.sc.getQueryString(ph.endPage+1)}'/>">&gt;</a>
        </c:if>

        <c:if test="${ph.showLast}">
          <a class="page" href="<c:url value='/faq/faqList${ph.sc.getQueryString(ph.totalPage)}'/>">&gt;&gt;</a>
        </c:if>

      </c:if>

    </div>
  </div>





