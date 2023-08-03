<%@ page import="com.teamProject.syusyu.dao.cs.impl.FOS_FaqDAOImpl" %>
<%@ page import="com.teamProject.syusyu.domain.cs.FaqDTO" %>
<%@ page import="com.teamProject.syusyu.dao.cs.FOS_FaqDAO" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ page session="true" %>

<head>
    <style>
       @import url(${cssUrlFos}/cs/faqList.scss);
    </style>

    <script src="<c:url value='${jsUrlFos}/cs/mypage/faqList.js'/>" defer></script>

</head>



<div class="content-mini right-case" id="ux_page_list">
    <form id="frm_search" action= "<c:url value='/faq/faqList'/>"method="get">


        <h3 class="title-t ty3 mb-30"><a href="<c:url value='/faq/faqList'/>">FAQ</a></h3>
        <%--  게시글 갯수 카운팅--%>

        <div class="input etc-ty4 w-full">
            <input type="text" id="faqSearchText" name="keyword" class="inp" placeholder="궁금하신 내용을 입력해 주세요." value="${fsc.keyword}">

            <button type="submit" class="btn icon search big">
                <span><i class="fa fa-search"></i></span>
            </button>
        </div>


        <div class="faqType-middle">
            <input class="faqType-small" type="button" key = "00" value="전체">
            <input class="faqType-small" type="button" key = "10" value="회원 정보">
            <input class="faqType-small" type="button" key = "20" value="배송">
            <input class="faqType-small" type="button" key = "30" value="주문 / 결제">
            <input class="faqType-small" type="button" key = "40" value="교환 / 반품">
            <input class="faqType-small" type="button" key = "50" value="이벤트">
            <input class="faqType-small" type="button" key = "60" value="취소 / 환불">
            <input class="faqType-small" type="button" key = "70" value="이용 안내">
            <input class="faqType-small" type="button" key = "80" value="쿠폰 / 포인트">
        </div>

    </form>

    <div class="board_list">
        <div class="slide-wrap slide-ty2">
            <c:forEach var="faqDto" items="${list}">
                <div class="slide-title">
                    <button type="button" class="slide-trg" faqTp="${faqDto.faqTp}" faqNo="${faqDto.faqNo}">
                        <em>Q.</em>
                        <strong>[ ${faqDto.faqTpNm} ]  ${faqDto.title}</strong>
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



</div>