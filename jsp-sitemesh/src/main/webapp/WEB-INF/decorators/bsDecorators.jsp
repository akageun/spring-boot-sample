<%@ page contentType="text/html;charset=UTF-8" language="java" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!doctype html>
<html lang="ko">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <sitemesh:decorate decorator="/WEB-INF/decorators/cmn/css.jsp"/>
    <link rel="stylesheet" type="text/css" href="<spring:url value="/resources/css/common.css"/>">
    <title>Hello, world!</title>
</head>
<body>
<sitemesh:write property="body"/>

<sitemesh:decorate decorator="/WEB-INF/decorators/cmn/js.jsp"/>
<script src="<spring:url value="/resources/js/common.js"/>"></script>
</body>
</html>
