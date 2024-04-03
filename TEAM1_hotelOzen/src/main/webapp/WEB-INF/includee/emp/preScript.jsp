<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%-- <link href="<%=request.getContextPath() %>/resources/assets/dist/css/bootstrap.min.css" rel="stylesheet"> --%>

    <!-- ===============================================-->
    <!--    Favicons-->
    <!-- ===============================================-->
    <link rel="apple-touch-icon" sizes="180x180" href="${pageContext.request.contextPath}/resources/assets/img/favicons/apple-touch-icon.png">
    <link rel="icon" type="image/png" sizes="32x32" href="${pageContext.request.contextPath}/resources/assets/img/favicons/favicon-32x32.png">
    <link rel="icon" type="image/png" sizes="16x16" href="${pageContext.request.contextPath}/resources/assets/img/favicons/favicon-16x16.png">
    <link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath}/resources/assets/img/favicons/favicon.ico">
    
  	
    <meta name="msapplication-TileImage" content="${pageContext.request.contextPath}/resources/assets/img/favicons/mstile-150x150.png">
    <meta name="theme-color" content="#ffffff">
    <script src="${pageContext.request.contextPath}/resources/assets/js/config.js"></script>
    <script src="${pageContext.request.contextPath}/resources/vendors/simplebar/simplebar.min.js"></script>


    <!-- ===============================================-->
    <!--    Stylesheets-->
    <!-- ===============================================-->
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,500,600,700%7cPoppins:300,400,500,600,700,800,900&amp;display=swap" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/vendors/simplebar/simplebar.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/assets/css/theme-rtl.css" rel="stylesheet" id="style-rtl">
    <link href="${pageContext.request.contextPath}/resources/assets/css/theme.css" rel="stylesheet" id="style-default">
    <link href="${pageContext.request.contextPath}/resources/assets/css/user-rtl.css" rel="stylesheet" id="user-style-rtl">
    <link href="${pageContext.request.contextPath}/resources/assets/css/user.css" rel="stylesheet" id="user-style-default">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.0/font/bootstrap-icons.css" />
    <link href="${pageContext.request.contextPath}/resources/css/emp/empTable.css" rel="stylesheet">
    <script>
      var isRTL = JSON.parse(localStorage.getItem('isRTL'));
      if (isRTL) {
        var linkDefault = document.getElementById('style-default');
        var userLinkDefault = document.getElementById('user-style-default');
        linkDefault.setAttribute('disabled', true);
        userLinkDefault.setAttribute('disabled', true);
        document.querySelector('html').setAttribute('dir', 'rtl');
      } else {
        var linkRTL = document.getElementById('style-rtl');
        var userLinkRTL = document.getElementById('user-style-rtl');
        linkRTL.setAttribute('disabled', true);
        userLinkRTL.setAttribute('disabled', true);
      }
    </script>


<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery-3.7.1.min.js"></script>

<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/app/common/telnumberUtil.js"></script>

<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/sweetalert2@11.4.10/dist/sweetalert2.min.css">
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11.4.10/dist/sweetalert2.min.js"></script>

<link href="${pageContext.request.contextPath}/resources/css/emp/pagingCss.css" rel="stylesheet">
<script src='${pageContext.request.contextPath}/resources/js/app/common/paging.js'></script>