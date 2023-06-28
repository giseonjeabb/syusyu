<%--
  Created by IntelliJ IDEA.
  User: Han
  Date: 2023-06-28
  Time: 오후 1:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<tr>
    <td>
        <a href="<c:url value="/board/read${ph.sc.queryString}&notcNo=${noticeDto.notcNo}"/>">
                     <span class="badge-cont single">
                                <span class="badge-item ty4">
                                    <c:out value="${noticeDto.notcTp}"/>
                                </span>
                     </span>
                 ${noticeDto.title}
           </a>
    </td>
    <td class="fz-15 color-3 ta-c">
        <c:choose>

        <c:when test="${noticeDto.regDttm.time >= startOfToday}">
                 <td class="regDttm"><fmt:formatDate value="${noticeDto.regDttm}" pattern="HH:mm"
                                        type="time"/></td>
         </c:when>

            <c:otherwise>
                <td class="regDttm"><fmt:formatDate value="${noticeDto.regDttm}" pattern="yyyy-MM-dd"
                                                    type="date"/></td>
            </c:otherwise>

        </c:choose>
    </td>
</tr>




</body>
</html>
