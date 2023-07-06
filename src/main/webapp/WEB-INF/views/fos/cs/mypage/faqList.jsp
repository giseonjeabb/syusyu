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
      <a href="#" class="active sclassify_children" data-type = "00">전체</a>

      <a href="#" class="sclassify_children " classify="" data-type = "10">회원</a>

      <a href="#" class="sclassify_children " classify="" data-type = "20">배송</a>

      <a href="#" class="sclassify_children " classify="" data-type = "30">주문결제</a>

      <a href="#" class="sclassify_children " classify="" data-type = "40">교환/반품</a>

      <a href="#" class="sclassify_children " classify="" data-type = "50">이벤트</a>

      <a href="#" class="sclassify_children " classify="" data-type = "60">취소/환불</a>

      <a href="#" class="sclassify_children " classify="" data-type = "70">이용안내</a>

      <a href="#" class="sclassify_children " classify="" data-type = "80">쿠폰/포인트</a>
    </div>



  </form>





  <div class="board_list">
      <div class="slide-wrap slide-ty2">
            <c:forEach var="faqDto" items="${list}">
              <div class="slide-title">
                <button type="button" class="slide-trg" data-type="${faqDto.faqTp}" idx="${faqDto.faqNo}">
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

  <script>
    const acc = document.getElementsByClassName("slide-trg");
    const type = document.getElementsByClassName("sclassify_children");
    let i;


    for (i = 0; i < acc.length; i++) {
      acc[i].addEventListener("click", function() {
        this.classList.toggle("active");
        const inner = this.parentElement.nextElementSibling.querySelector('.inner');

        if(inner){
          inner.style.display = inner.style.display === "block" ? "none" : "block";
        }
      });
    }

    // const acc = document.getElementsByClassName("slide-trg");
    // let i;
    //
    // for (i = 0; i < acc.length; i++) {
    //   acc[i].addEventListener("click", function() {
    //     this.classList.toggle("active");
    //     const inner = this.nextElementSibling.querySelector('.inner');
    //     if (inner) {
    //       inner.style.display = inner.style.display === "none" ? "block" : "none";
    //     }
    //   });
    // }






    // 클릭된 글 이외의 모든 글의 내용을 자동으로 닫도록 구현
    // $(document).ready(function () {
    //   $('.slide-trg').each(function () {
    //     let $trg = $(this);
    //     if ($trg.hasClass('active')) {
    //       $(this).closest('.slide-title').next('.slide-cont').find('.inner').css('display', 'block');
    //     } else {
    //       $trg.closest('.slide-wrap').find('.slide-cont').find('.inner').css('display', 'none');
    //     }
    //   });
    //
    //   $(document).on('click', '.slide-wrap .slide-trg', function (e) {
    //     let slideTime = 200;
    //     e.preventDefault();
    //     if ($(this).closest('.slide-title').next('.slide-cont').find('.inner').css('display') === 'block') {
    //       $(this).closest('.slide-wrap').find('.slide-trg').removeClass('active');
    //       $(this).closest('.slide-wrap').find('.slide-cont').find('.inner').slideUp(slideTime);
    //     } else {
    //       $(this).closest('.slide-wrap').find('.slide-trg').removeClass('active');
    //       $(this).addClass('active');
    //       $(this).closest('.slide-wrap').find('.slide-cont').find('.inner').slideUp(slideTime);
    //       $(this).closest('.slide-title').next('.slide-cont').find('.inner').slideDown(slideTime);
    //     }
    //   });
    //   });





  </script>



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

    </div>   <%--  <div class="wrap-pagination"> --%>
</div>  <%--<div id="devPageWrap">--%>



</div>

