<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<html>
<head>
    <title><tiles:getAsString name="title"/></title>
    <tiles:insertAttribute name="css" />
    <tiles:insertAttribute name="script" />
    <link rel="icon" href="${imgUrl}/logo/syusyu_icon.png"/>
    <link rel="apple-touch-icon" href="${imgUrl}/logo/syusyu_icon.png"/>
</head>
<body>
<tiles:insertAttribute name="header"/>
<main>
    <div class="inner-content move-container service-center">
        <tiles:insertAttribute name="helpLeft"/>
        <div class="content-mini right-case">
            <tiles:insertAttribute name="body"/>
        </div>
    </div>
</main>
<tiles:insertAttribute name="footer"/>
</body>
</html>