<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<html>
<head>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons+Outlined" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/search.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/menu.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/body.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/page.css" rel="stylesheet">
    <title>
        <tiles:getAsString name="title"/>
    </title>
</head>
<body>
<div class="container-page">
    <div class="search-item">
        <tiles:insertAttribute name="header"/>
    </div>
    <div style="display: flex; height: 100%">
        <div class="container-nav">
            <nav class="navigation">
                <tiles:insertAttribute name="menu"/>
            </nav>
        </div>
        <div class="container-prof">
            <tiles:insertAttribute name="body"/>
        </div>
    </div>
    <div style="text-align: center; color: aliceblue; padding: 10px">
        <tiles:insertAttribute name="footer"/>
    </div>
</div>
</body>
</html>
