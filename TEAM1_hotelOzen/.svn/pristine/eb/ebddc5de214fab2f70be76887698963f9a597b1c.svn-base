<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title><tiles:getAsString name="title" /></title>
<!-- <title>Falcon | Dashboard &amp; Web App Template</title> -->
<tiles:insertAttribute name="preScript"/>

</head>

<body data-context-path="${pageContext.request.contextPath }" style="background-color: #F6F5F5;  margin: 0; padding: 0;">

<main class="main" id="top">
<div class="container-fluid" data-layout="container" style="background: linear-gradient(to top, #5f7af6, #fff);">

<tiles:insertAttribute name="sideBar"/>
<!-- <hr /> -->
<div class="content">

<tiles:insertAttribute name="headerMenu" />
<!-- <hr /> -->

<tiles:insertAttribute name="contentPage"/>
<!-- <hr /> -->

<tiles:insertAttribute name="footer"/>
</div>

<tiles:insertAttribute name="postScript"/>
</div>
</main>
</body>
</html>