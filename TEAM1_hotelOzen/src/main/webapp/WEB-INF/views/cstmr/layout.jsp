<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><tiles:getAsString name="title" /></title>
<tiles:insertAttribute name="preScript"/>

	<link href="${pageContext.request.contextPath}/resources/css/cstmr/comm/cstmr.css" rel="stylesheet">
	
</head>
<body data-context-path="${pageContext.request.contextPath }" style="background-color: rgba(255,255,255);" >
<tiles:insertAttribute name="header" />
<tiles:insertAttribute name="contentPage"/>
    <main class="main" id="top">

<tiles:insertAttribute name="scrapList"/>
<tiles:insertAttribute name="chatbot"/>

<tiles:insertAttribute name="footer"/>
</main>
<tiles:insertAttribute name="postScript"/>

</body>
</html>














