<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<html>
<head>
    <title><tiles:getAsString name="title"/></title>
    <tiles:insertAttribute name="css" />
    <tiles:insertAttribute name="script" />
</head>
<body>
<tiles:insertAttribute name="header"/>
<main>
    <tiles:insertAttribute name="body"/>
</main>
<tiles:insertAttribute name="footer"/>
</body>
</html>